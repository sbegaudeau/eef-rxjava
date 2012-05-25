/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.gwt.editor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.eef.runtime.ui.gwt.command.CreateObjectCommand;
import org.eclipse.emf.eef.runtime.ui.gwt.command.CreateResourceCommand;
import org.eclipse.emf.eef.runtime.ui.gwt.command.SaveCommand;
import org.eclipse.emf.eef.runtime.ui.gwt.command.UpdateURIConverterCommand;
import org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateObjectDialog;
import org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateResourceDialog;
import org.eclipse.emf.eef.runtime.ui.gwt.dialog.ErrorDialog;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.EEFEditor;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.part.EEFEditorToolbar;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.part.EEFEditorToolbar.ToolbarEvent;

import com.google.gwt.user.client.ui.TreeItem;

public class EditorToolbarListener implements EEFEditorToolbar.ToolbarListener {

	private EEFEditor editor;
	private HashMap<Integer, EventProcess> process;
	
	/**
	 * @param editor
	 */
	public EditorToolbarListener(EEFEditor editor) {
		this.editor = editor;
		this.process = new HashMap<Integer, EventProcess>();
	}

	/**
	 * @param selection
	 */
	public void update(Object selection) {
		updateDeleteProcess(selection);
		updateToolbarButton(EEFEditorToolbar.DELETE);
		updateCutProcess(selection);
		updateToolbarButton(EEFEditorToolbar.CUT);
		updateCopyProcess(selection);
		updateToolbarButton(EEFEditorToolbar.COPY);
		updatePasteProcess(selection);
		updateToolbarButton(EEFEditorToolbar.PASTE);
		updateUpProcess(selection);
		updateToolbarButton(EEFEditorToolbar.UP);
		updateDownProcess(selection);
		updateToolbarButton(EEFEditorToolbar.DOWN);
	}
	
	private void updateDeleteProcess(Object selection) {
		if (selection instanceof Resource) {
			final Resource resource = (Resource) selection;
			final Command deleteContentsCommand = DeleteCommand.create(editor.getEditingDomain(), resource.getContents());
			final RemoveCommand removeResourceCommand = new RemoveCommand(editor.getEditingDomain(), editor.getEditingDomain().getResourceSet().getResources(), resource);
			process.put(EEFEditorToolbar.DELETE, new EventProcess(new CompoundCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}

				@Override
				public void execute() {
					appendAndExecute(deleteContentsCommand);
					appendAndExecute(removeResourceCommand);
				}
			}, null));
		} else {
			process.put(EEFEditorToolbar.DELETE, new EventProcess(DeleteCommand.create(editor.getEditingDomain(), selection), null));
		}
	}
	
	private void updateCutProcess(Object selection) {
		process.put(EEFEditorToolbar.CUT, new EventProcess(CutToClipboardCommand.create(editor.getEditingDomain(), selection), null));
	}
 	
	private void updateCopyProcess(Object selection) {
		process.put(EEFEditorToolbar.COPY, new EventProcess(selection instanceof EObject ? CopyToClipboardCommand.create(editor.getEditingDomain(), selection) : UnexecutableCommand.INSTANCE, null));
	}	

	private void updatePasteProcess(Object selection) {
		process.put(EEFEditorToolbar.PASTE, new EventProcess(PasteFromClipboardCommand.create(editor.getEditingDomain(), selection, null), null));
	}	

	private void updateUpProcess(Object selection) {
		Object owner = editor.getEditingDomain().getParent(selection);
		if (owner != null) {
			List<?> children = new ArrayList<Object>(editor.getEditingDomain().getChildren(owner));
			int index = children.indexOf(selection);
			if (index != -1) {
				process.put(EEFEditorToolbar.UP, new EventProcess(MoveCommand.create(editor.getEditingDomain(), owner, null, selection, index - 1), null));
				return;
			}
		}
		process.put(EEFEditorToolbar.UP, new EventProcess(UnexecutableCommand.INSTANCE, null));

	}

	private void updateDownProcess(Object selection) {
		Object owner = editor.getEditingDomain().getParent(selection);
		if (owner != null) {
			List<?> children = new ArrayList<Object>(editor.getEditingDomain().getChildren(owner));
			int index = children.indexOf(selection);
			if (index != -1) {
				process.put(EEFEditorToolbar.DOWN, new EventProcess(MoveCommand.create(editor.getEditingDomain(), owner, null, selection, index + 1), null));
				return;
			}
		}
		process.put(EEFEditorToolbar.DOWN, new EventProcess(UnexecutableCommand.INSTANCE, null));
	}
	
	
	private void updateToolbarButton(int id) {
		editor.getToolbar().setEnabledButton(process.get(id).canExecute(), id);
	}

	@Override
	public void fireToolbarEvent(ToolbarEvent event) {
		EventProcess process = null;
		switch (event.kind) {
		case EEFEditorToolbar.CREATE:
			process = processCreate(event);
			break;
		case EEFEditorToolbar.DELETE:
			process = this.process.get(EEFEditorToolbar.DELETE);
			break;
		case EEFEditorToolbar.VALIDATE:
			process = processValidate(event);
			break;
		case EEFEditorToolbar.SAVE:
			process = processSave(event);
			break;
		case EEFEditorToolbar.UNDO:
			process = processUndo(event);
			break;
		case EEFEditorToolbar.REDO:
			process = processRedo(event);
			break;
		case EEFEditorToolbar.CUT:
			process = this.process.get(EEFEditorToolbar.CUT);
			break;
		case EEFEditorToolbar.COPY:
			process = this.process.get(EEFEditorToolbar.COPY);
			break;
		case EEFEditorToolbar.PASTE:
			process = this.process.get(EEFEditorToolbar.PASTE);
			break;
		case EEFEditorToolbar.UP:
			process = this.process.get(EEFEditorToolbar.UP);
			break;
		case EEFEditorToolbar.DOWN:
			process = this.process.get(EEFEditorToolbar.DOWN);
			break;
		case EEFEditorToolbar.NAVIGATE:
			process = processNavigate(event);
			break;

		default:
			break;
		}
		if (process.command != null) {
			editor.getEditingDomain().getCommandStack().execute(process.command);
		}
		if (process.callback != null) {
			process.callback.process();
		}
	}

	private EventProcess processCreate(ToolbarEvent event) {
		Object selection = editor.getNavigationManager().getSelection();
		EventProcess result = null;
		if (selection instanceof ResourceSet) {
			CreateResourceDialog dialog = new CreateResourceDialog() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateResourceDialog
				 * #defaultValue()
				 */
				@Override
				protected String defaultValue() {
					int count = 1;
					while (editor.getEditingDomain().getResourceSet().getResource(URI.createURI("datastore:/resource" + count), false) != null) {
						++count;
					}
					return "datastore:/resource" + count;
				}

				@Override
				protected boolean valideValue(Object value) {
					return editor.getEditingDomain().getResourceSet().getResource(URI.createURI((String) value), false) == null;
				}

				@Override
				protected EventProcess processOk(final Object value) {
					return new EventProcess(new CreateResourceCommand(editor.getEditingDomain(), (String) value), null);
				}

			};
			dialog.open();
			result = dialog.getResult();
		} else if (selection instanceof Resource) {
			List<Object> input = new ArrayList<Object>();
			final Resource resource = (Resource) selection;
			Registry packageRegistry = editor.getEditingDomain().getResourceSet().getPackageRegistry();
			for (String nsURI : packageRegistry.keySet()) {
				EPackage ePackage = packageRegistry.getEPackage(nsURI);
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						if (!eClass.isAbstract()) {
							EObject eObject = EcoreUtil.create(eClass);
							input.add(eObject);
						}
					}
				}
			}

			CreateObjectDialog dialog = new CreateObjectDialog() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateObjectDialog
				 * #getString(java.lang.Object)
				 */
				@Override
				public String getString(Object object) {
					return "New " + editor.getItemDelegator().getText(object);
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateObjectDialog
				 * #processOk()
				 */
				@Override
				protected Object processOk(final Object selection) {
					return new EventProcess(new CreateObjectCommand(editor.getEditingDomain(), resource, (String) selection), null);
				}

			};

			dialog.setInput(input);
			dialog.open();
			result = (EventProcess) dialog.getResult();

		} else {
			Collection<?> newChildDescriptors = editor.getEditingDomain().getNewChildDescriptors(selection, null);
			final List<Command> commands = new ArrayList<Command>();
			for (Object descriptor : newChildDescriptors) {
				Command command = CreateChildCommand.create(editor.getEditingDomain(), selection, descriptor, Collections.singleton(selection));
				commands.add(command);
			}
			CreateObjectDialog dialog = new CreateObjectDialog() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateObjectDialog
				 * #processOk(java.lang.Object)
				 */
				@Override
				protected Object processOk(Object selection) {
					return new EventProcess((Command) selection, null);
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.emf.eef.runtime.ui.gwt.dialog.CreateObjectDialog
				 * #getString(java.lang.Object)
				 */
				@Override
				public String getString(Object object) {
					return ((Command) object).getLabel();
				}

			};
			dialog.setInput(commands);
			dialog.open();
			result = (EventProcess) dialog.getResult();
		}
		return result;
	}

	private EventProcess processSave(ToolbarEvent event) {
		CompoundCommand result = new CompoundCommand();
		EList<Resource> resources = editor.getEditingDomain().getResourceSet().getResources();
		for (Resource resource : resources) {
			if (resource.isLoaded()) {
				Map<String, Object> options = null;
				if (editor.getOriginalResources().contains(resource)) {
					options = new HashMap<String, Object>();
					options.put(URIConverter.OPTION_UPDATE_ONLY_IF_TIME_STAMP_MATCHES, resource.getTimeStamp());
				}
				result.append(new SaveCommand(resource, options));
			}
		}
		for (Resource resource : editor.getOriginalResources()) {
			if (!resources.contains(resource)) {
				Map<String, Object> options = null;
				if (resource.isLoaded()) {
					options = new HashMap<String, Object>();
					options.put(URIConverter.OPTION_UPDATE_ONLY_IF_TIME_STAMP_MATCHES, resource.getTimeStamp());
				}
				result.append(new UpdateURIConverterCommand(editor.getEditingDomain().getResourceSet().getURIConverter(), resource.getURI(), options));
			}
		}
		return new EventProcess(result, new EventProcess.CallBack() {

			@Override
			public void process() {
				editor.getOriginalResources().clear();
				editor.getOriginalResources().addAll(editor.getEditingDomain().getResourceSet().getResources());
				((BasicCommandStack) editor.getEditingDomain().getCommandStack()).saveIsDone();
				editor.getToolbar().setEnabledButton(false, EEFEditorToolbar.SAVE);
			}
		});
	}

	private EventProcess processUndo(ToolbarEvent event) {
		return new EventProcess(null, new EventProcess.CallBack() {

			@Override
			public void process() {
				editor.getEditingDomain().getCommandStack().undo();
			}
		});
	}

	private EventProcess processRedo(ToolbarEvent event) {
		return new EventProcess(null, new EventProcess.CallBack() {

			@Override
			public void process() {
				editor.getEditingDomain().getCommandStack().redo();
			}
		});
	}

	private EventProcess processValidate(ToolbarEvent event) {
		Diagnostician diagnostician = new Diagnostician() {

			@Override
			public String getObjectLabel(EObject eObject) {
				return !eObject.eIsProxy() ? editor.getItemDelegator().getText(eObject) : super.getObjectLabel(eObject);
			}
		};
		Map<Object, Object> context = diagnostician.createDefaultContext();
		EList<Resource> resources = editor.getEditingDomain().getResourceSet().getResources();
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		for (Resource resource : resources) {
			if (resource.isLoaded()) {
				for (EObject eObject : resource.getContents()) {
					diagnostician.validate(eObject, diagnostics, context);
				}
			}
		}
		final ErrorDialog dialogBox;
		final Object newSelection;
		if (diagnostics.getSeverity() == Diagnostic.OK) {
			dialogBox = new ErrorDialog("Problems", Diagnostic.OK_INSTANCE) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.emf.eef.runtime.ui.gwt.dialog.ErrorDialog#
				 * processError()
				 */
				@Override
				protected Object processError(TreeItem treeItem) {
					if (treeItem != null) {
						return treeItem.getUserObject();
					}
					return null;
				}

			};
			newSelection = dialogBox.getSelection();
		} else {
			dialogBox = new ErrorDialog("Problems", diagnostics.getChildren()) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.emf.eef.runtime.ui.gwt.dialog.ErrorDialog#
				 * processError()
				 */
				@Override
				protected Object processError(TreeItem treeItem) {
					if (treeItem != null) {
						return treeItem.getUserObject();
					}
					return null;
				}

			};
			newSelection = dialogBox.getSelection();
		}
		dialogBox.open();
		return new EventProcess(null, new EventProcess.CallBack() {

			@Override
			public void process() {
				updateTreeSelection(newSelection);
			}
		});
	}

	private EventProcess processNavigate(ToolbarEvent event) {
		return new EventProcess(null, new EventProcess.CallBack() {
			
			@Override
			public void process() {
				editor.getNavigationManager().navigate();
			}
		});
	}

	protected void updateTreeSelection(Object newSelection) {
		editor.getNavigationManager().setSelection(newSelection);
		editor.getNavigationManager().navigate();
	}

}
