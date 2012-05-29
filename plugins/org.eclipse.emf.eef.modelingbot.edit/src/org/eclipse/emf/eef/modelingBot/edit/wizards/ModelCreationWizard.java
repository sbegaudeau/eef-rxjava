/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.edit.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.eef.modelingBot.provider.MbotEditPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * The wizard for creating modelingBots models.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ModelCreationWizard extends Wizard implements INewWizard {

	private List<EClass> initialObjects = new ArrayList<EClass>();

	protected static final int CONTROL_OFFSET = 10;

	/**
	 * This is the metamodel selection page.
	 */
	private MetamodelSelectionWizardPage metamodelSelectionPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 */
	protected List<String> initialObjectNames;

	/**
	 * This is the file creation page.
	 */
	protected ModelCreationWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page.
	 */
	protected ModelingBotModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * ResourceSet to use.
	 */
	protected ResourceSet resourceSet = new ResourceSetImpl();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						final ResourceSet wResourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						final URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						// Create a resource for this file.
						final Resource resource = wResourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						final EObject rootObject = createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						final Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
						resource.save(options);
					} catch (IOException exception) {
						MbotEditPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			final IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			final IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}

			// Open an editor on the new file.
			try {
				page.openEditor(new FileEditorInput(modelFile), MbotEditPlugin.INTERACTIVE_EEF_EDITOR_ID);
				return true;
			} catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(),
						MbotEditPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
			}
		} catch (InterruptedException exception) {
			MbotEditPlugin.INSTANCE.log(exception);
		} catch (InvocationTargetException exception) {
			MbotEditPlugin.INSTANCE.log(exception);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(MbotEditPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(MbotEditPlugin.INSTANCE
				.getImage("full/wizban/NewModelingBot")));
	}

	/**
	 * Get the file from the page.
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

	/**
	 * Create a new model.
	 */
	protected EObject createInitialModel() {
		final EClass eClass = getEClassifier(initialObjectCreationPage.getInitialObjectName());
		final EObject rootObject = EcoreUtil.create(eClass);
		return rootObject;
	}

	private EClass getEClassifier(String initialObjectName) {
		for (EClass eClass : initialObjects) {
			if (eClass.getName().equals(initialObjectName))
				return eClass;
		}
		return null;
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 */
	protected Collection<String> getInitialObjectNames() {
		initialObjectNames = new ArrayList<String>();
		for (EClass eClass : initialObjects) {
			if (!eClass.isAbstract()) {
				initialObjectNames.add(eClass.getName());
			}
		}
		Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		return initialObjectNames;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	public void addPages() {
		metamodelSelectionPage = new MetamodelSelectionWizardPage("Whatever0");
		metamodelSelectionPage.setTitle(MbotEditPlugin.INSTANCE.getString("_UI_EEFActionsModelWizard_label"));
		metamodelSelectionPage.setDescription(MbotEditPlugin.INSTANCE
				.getString("_UI_ModelCreationMetamodelSelection_description"));
		addPage(metamodelSelectionPage);

		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new ModelCreationWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(MbotEditPlugin.INSTANCE.getString("_UI_EEFActionsModelWizard_label"));
		newFileCreationPage.setDescription(MbotEditPlugin.INSTANCE.getString("_UI_EEFActionsModelWizard_description"));
		newFileCreationPage.setFileName(MbotEditPlugin.INSTANCE.getString("_UI_ModelingBotEditorFilenameDefaultBase"));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			final Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					final String defaultModelBaseFilename = MbotEditPlugin.INSTANCE
							.getString("_UI_ModelingBotEditorFilenameDefaultBase");
					String modelFilename = defaultModelBaseFilename;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new ModelingBotModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(MbotEditPlugin.INSTANCE.getString("_UI_EEFActionsModelWizard_label"));
		initialObjectCreationPage.setDescription(MbotEditPlugin.INSTANCE
				.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	private void updateObjectField() {
		initialObjectCreationPage.getInitialObjectField().removeAll();
		for (String objectName : getInitialObjectNames()) {
			initialObjectCreationPage.getInitialObjectField().add(objectName);
		}

		if (initialObjectCreationPage.getInitialObjectField().getItemCount() == 1) {
			initialObjectCreationPage.getInitialObjectField().select(0);
		}
	}

	public class MetamodelSelectionWizardPage extends WizardPage {

		protected Text uriField;

		/**
		 * @param pageName
		 */
		public MetamodelSelectionWizardPage(String pageName) {
			super(pageName);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			final Composite composite = new Composite(parent, SWT.NONE);
			final FormLayout layout = new FormLayout();
			composite.setLayout(layout);
			final GridData gData = new GridData();
			gData.verticalAlignment = GridData.FILL;
			gData.grabExcessVerticalSpace = true;
			gData.horizontalAlignment = GridData.FILL;
			gData.grabExcessHorizontalSpace = true;
			if (!EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
				gData.widthHint = 330;
			}
			composite.setLayoutData(gData);
			// buttonComposite has to be the first child of composite because subclasses are expecting this.
			final Composite buttonComposite = new Composite(composite, SWT.NONE);

			final Label resourceURILabel = new Label(composite, SWT.LEFT);
			resourceURILabel.setText(CommonUIPlugin.INSTANCE.getString("_UI_ResourceURI_label"));
			FormData fData = new FormData();
			fData.left = new FormAttachment(0, CONTROL_OFFSET);
			fData.top = new FormAttachment(0, CONTROL_OFFSET);
			resourceURILabel.setLayoutData(fData);
			fData = new FormData();
			fData.top = new FormAttachment(resourceURILabel, CONTROL_OFFSET, SWT.CENTER);
			fData.left = new FormAttachment(resourceURILabel, CONTROL_OFFSET);
			fData.right = new FormAttachment(100, -CONTROL_OFFSET);
			buttonComposite.setLayoutData(fData);
			buttonComposite.setLayout(new FormLayout());
			uriField = new Text(composite, SWT.BORDER);
			fData = new FormData();
			fData.top = new FormAttachment(buttonComposite, CONTROL_OFFSET);
			fData.left = new FormAttachment(0, CONTROL_OFFSET);
			fData.right = new FormAttachment(100, -CONTROL_OFFSET);
			uriField.setLayoutData(fData);
			uriField.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					updateMetamodel();
					setPageComplete(validatePage());
				}

			});
			final Button browseFileSystemButton = new Button(buttonComposite, SWT.PUSH);
			browseFileSystemButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_BrowseFileSystem_label"));
			prepareBrowseFileSystemButton(browseFileSystemButton);

			if (EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
				final Button browseWorkspaceButton = new Button(buttonComposite, SWT.PUSH);
				fData = new FormData();
				fData.right = new FormAttachment(100);
				browseWorkspaceButton.setLayoutData(fData);
				fData = new FormData();
				fData.right = new FormAttachment(browseWorkspaceButton, -CONTROL_OFFSET);
				browseFileSystemButton.setLayoutData(fData);
				browseWorkspaceButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_BrowseWorkspace_label"));
				prepareBrowseWorkspaceButton(browseWorkspaceButton);
			} else {
				fData = new FormData();
				fData.right = new FormAttachment(100);
				browseFileSystemButton.setLayoutData(fData);
			}

			final Label separatorLabel = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
			fData = new FormData();
			fData.top = new FormAttachment(uriField, (int)(1.5 * CONTROL_OFFSET));
			fData.left = new FormAttachment(0, -CONTROL_OFFSET);
			fData.right = new FormAttachment(100, CONTROL_OFFSET);
			separatorLabel.setLayoutData(fData);
			composite.setTabList(new Control[] {uriField, buttonComposite});
			final Button browseRegisteredPackagesButton = new Button(buttonComposite, SWT.PUSH);
			browseRegisteredPackagesButton.setText(MbotEditPlugin.INSTANCE
					.getString("_UI_BrowseRegisteredPackages_label"));
			prepareBrowseRegisteredPackagesButton(browseRegisteredPackagesButton);
			fData = new FormData();
			Control[] children = buttonComposite.getChildren();
			fData.left = new FormAttachment(0, 0);
			fData.right = new FormAttachment(children[0], -CONTROL_OFFSET);
			browseRegisteredPackagesButton.setLayoutData(fData);
			setControl(composite);
			setPageComplete(validatePage());
		}

		public String getURIText() {
			return uriField.getText();
		}

		private void updateMetamodel() {
			final List<URI> uris = new ArrayList<URI>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(getURIText()); stringTokenizer.hasMoreTokens();) {
				final String uri = stringTokenizer.nextToken();
				uris.add(URI.createURI(uri));
			}
			final List<EClass> newInitialObjects = new ArrayList<EClass>();
			for (URI uri : uris) {
				try {
					final Resource resource = resourceSet.getResource(uri, true);
					if (resource.getContents() != null) {
						final List<EClass> allClasses = getAllClasses(resource);
						if (!allClasses.isEmpty()) {
							newInitialObjects.addAll(allClasses);
						}
					}
				} catch (Exception e) {
					// Silent catch malformed protocol
				}
			}
			if (!newInitialObjects.isEmpty()) {
				initialObjects.clear();
				initialObjects.addAll(newInitialObjects);
				updateObjectField();
			}
		}

		private List<EClass> getAllClasses(Resource resource) {
			final List<EClass> eclasses = new ArrayList<EClass>();
			for (Iterator<?> iterator = resource.getAllContents(); iterator.hasNext();) {
				final Object next = iterator.next();
				if (next instanceof EClass) {
					eclasses.add((EClass)next);
				}
			}
			return eclasses;
		}

		private boolean validatePage() {
			return !initialObjects.isEmpty();
		}

		/**
		 * Called to prepare the Browse File System button, this implementation adds a selection listener that
		 * creates an appropriate {@link FileDialog}.
		 */
		protected void prepareBrowseFileSystemButton(Button browseFileSystemButton) {
			browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					final FileDialog fileDialog = new FileDialog(getShell(), SWT.NONE);
					fileDialog.open();

					final String filterPath = fileDialog.getFilterPath();
					final String fileName = fileDialog.getFileName();
					if (fileName != null) {
						uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
					}
				}
			});
		}

		/**
		 * Called to prepare the Browse Workspace button, this implementation adds a selection listener that
		 * creates an appropriate {@link WorkspaceResourceDialog}.
		 */
		protected void prepareBrowseWorkspaceButton(Button browseWorkspaceButton) {
			browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					IFile file = null;
					final IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false,
							null, null);
					if (files.length != 0) {
						file = files[0];
					}
					if (file != null) {
						uriField.setText(URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString());
					}
				}
			});
		}

		protected void prepareBrowseRegisteredPackagesButton(Button browseRegisteredPackagesButton) {
			browseRegisteredPackagesButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					final RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
					registeredPackageDialog.open();
					final Object[] result = registeredPackageDialog.getResult();
					if (result != null) {
						final List<?> nsURIs = Arrays.asList(result);
						if (registeredPackageDialog.isDevelopmentTimeVersion()) {
							final ResourceSet resourceSet = new ResourceSetImpl();
							resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
							final StringBuffer uris = new StringBuffer();
							final Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
									.getEPackageNsURIToGenModelLocationMap();
							for (int i = 0, length = result.length; i < length; i++) {
								final URI location = ePackageNsURItoGenModelLocationMap.get(result[i]);
								final Resource resource = resourceSet.getResource(location, true);
								EcoreUtil.resolveAll(resource);
							}
							for (Resource resource : resourceSet.getResources()) {
								for (EPackage ePackage : getAllPackages(resource)) {
									if (nsURIs.contains(ePackage.getNsURI())) {
										uris.append(resource.getURI());
										uris.append("  ");
										break;
									}
								}
							}
							uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
						} else {
							final StringBuffer uris = new StringBuffer();
							for (int i = 0, length = result.length; i < length; i++) {
								uris.append(result[i]);
								uris.append("  ");
							}
							uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
						}
					}
				}
			});
		}

		protected Collection<EPackage> getAllPackages(Resource resource) {
			final List<EPackage> result = new ArrayList<EPackage>();
			for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {
				private static final long serialVersionUID = 1L;

				@Override
				protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
					return eObject instanceof EPackage ? ((EPackage)eObject).getESubpackages().iterator() : Collections
							.<EObject> emptyList().iterator();
				}
			}; j.hasNext();) {
				final Object content = j.next();
				if (content instanceof EPackage) {
					result.add((EPackage)content);
				}
			}
			return result;
		}
	}

	/**
	 * This is the one page of the wizard.
	 */
	public class ModelCreationWizardNewFileCreationPage extends WizardNewFileCreationPage {

		/**
		 * Pass in the selection.
		 */
		public ModelCreationWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 */
	public class ModelingBotModelWizardInitialObjectCreationPage extends WizardPage {

		protected Combo initialObjectField;

		protected List<String> encodings;

		protected Combo encodingField;

		/**
		 * Pass in the selection.
		 */
		public ModelingBotModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		public void createControl(Composite parent) {
			final Composite composite = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);
			GridData gData = new GridData();
			gData.verticalAlignment = GridData.FILL;
			gData.grabExcessVerticalSpace = true;
			gData.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(gData);
			final Label containerLabel = new Label(composite, SWT.LEFT);
			containerLabel.setText(MbotEditPlugin.INSTANCE.getString("_UI_ModelObject"));
			gData = new GridData();
			gData.horizontalAlignment = GridData.FILL;
			containerLabel.setLayoutData(gData);
			initialObjectField = new Combo(composite, SWT.BORDER);
			gData = new GridData();
			gData.horizontalAlignment = GridData.FILL;
			gData.grabExcessHorizontalSpace = true;
			initialObjectField.setLayoutData(gData);
			updateObjectField();
			initialObjectField.addModifyListener(validator);

			final Label encodingLabel = new Label(composite, SWT.LEFT);
			encodingLabel.setText(MbotEditPlugin.INSTANCE.getString("_UI_XMLEncoding"));
			gData = new GridData();
			gData.horizontalAlignment = GridData.FILL;
			encodingLabel.setLayoutData(gData);
			encodingField = new Combo(composite, SWT.BORDER);
			gData = new GridData();
			gData.horizontalAlignment = GridData.FILL;
			gData.grabExcessHorizontalSpace = true;
			encodingField.setLayoutData(gData);
			for (String encoding : getEncodings()) {
				encodingField.add(encoding);
			}

			encodingField.select(0);
			encodingField.addModifyListener(validator);

			setPageComplete(validatePage());
			setControl(composite);
		}

		protected ModifyListener validator = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(validatePage());
			}
		};

		/**
		 * @return the initialObjectField
		 */
		public Combo getInitialObjectField() {
			return initialObjectField;
		}

		protected boolean validatePage() {
			return getInitialObjectName() != null && !getInitialObjectName().equals("")
					&& getEncodings().contains(encodingField.getText());
		}

		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible) {
				if (initialObjectField.getItemCount() == 1) {
					initialObjectField.clearSelection();
					encodingField.setFocus();
				} else {
					encodingField.clearSelection();
					initialObjectField.setFocus();
				}
			}
		}

		public String getInitialObjectName() {
			return initialObjectField.getText();
		}

		public String getEncoding() {
			return encodingField.getText();
		}

		protected Collection<String> getEncodings() {
			if (encodings == null) {
				encodings = new ArrayList<String>();
				for (StringTokenizer stringTokenizer = new StringTokenizer(
						MbotEditPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens();) {
					encodings.add(stringTokenizer.nextToken());
				}
			}
			return encodings;
		}
	}

	public static class RegisteredPackageDialog extends ElementListSelectionDialog {
		protected boolean isDevelopmentTimeVersion = true;

		public RegisteredPackageDialog(Shell parent) {
			super(parent, new LabelProvider() {
				@Override
				public Image getImage(Object element) {
					return ExtendedImageRegistry.getInstance().getImage(
							EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage"));
				}
			});

			setMultipleSelection(true);
			setMessage(MbotEditPlugin.INSTANCE.getString("_UI_SelectRegisteredPackageURI"));
			setFilter("*");
			setTitle(MbotEditPlugin.INSTANCE.getString("_UI_PackageSelection_label"));
		}

		public boolean isDevelopmentTimeVersion() {
			return isDevelopmentTimeVersion;
		}

		protected void updateElements() {
			if (isDevelopmentTimeVersion) {
				final Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
						.getEPackageNsURIToGenModelLocationMap();
				final Object[] result = ePackageNsURItoGenModelLocationMap.keySet().toArray(
						new Object[ePackageNsURItoGenModelLocationMap.size()]);
				Arrays.sort(result);
				setListElements(result);
			} else {
				final Object[] result = EPackage.Registry.INSTANCE.keySet().toArray(
						new Object[EPackage.Registry.INSTANCE.size()]);
				Arrays.sort(result);
				setListElements(result);
			}
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			final Composite result = (Composite)super.createDialogArea(parent);
			final Composite buttonGroup = new Composite(result, SWT.NONE);
			final GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			buttonGroup.setLayout(layout);
			final Button developmentTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
			developmentTimeVersionButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					isDevelopmentTimeVersion = developmentTimeVersionButton.getSelection();
					updateElements();
				}
			});
			developmentTimeVersionButton.setText(MbotEditPlugin.INSTANCE.getString("_UI_DevelopmentTimeVersion_label"));
			final Button runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
			runtimeTimeVersionButton.setText(MbotEditPlugin.INSTANCE.getString("_UI_RuntimeVersion_label"));
			developmentTimeVersionButton.setSelection(true);

			updateElements();

			return result;
		}
	}

}
