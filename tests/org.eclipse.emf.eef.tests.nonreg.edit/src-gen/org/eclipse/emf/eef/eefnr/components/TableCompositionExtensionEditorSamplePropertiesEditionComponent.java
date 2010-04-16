/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.eefnr.AbstractTableCompositionTargetExtensionEditorSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TableCompositionExtensionEditorSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TableCompositionExtensionEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TableCompositionExtensionEditorSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private TableCompositionExtensionEditorSample tableCompositionExtensionEditorSample;

	/**
	 * The Base part
	 * 
	 */
	protected TableCompositionExtensionEditorSamplePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public TableCompositionExtensionEditorSamplePropertiesEditionComponent(EObject tableCompositionExtensionEditorSample, String editing_mode) {
		if (tableCompositionExtensionEditorSample instanceof TableCompositionExtensionEditorSample) {
			this.tableCompositionExtensionEditorSample = (TableCompositionExtensionEditorSample)tableCompositionExtensionEditorSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.tableCompositionExtensionEditorSample.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					TableCompositionExtensionEditorSamplePropertiesEditionComponent.this.dispose();
				else {
					Runnable updateRunnable = new Runnable() {
						public void run() {
							runUpdateRunnable(msg);
						}
					};
					if (null == Display.getCurrent()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
					} else {
						updateRunnable.run();
					}
				}
			}

		};
	}

	/**
	 * Used to update the views
	 * 
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty())) {
			basePart.updateTablecompositionRequiredProperty(tableCompositionExtensionEditorSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty())) {
			basePart.updateTablecompositionOptionalProperty(tableCompositionExtensionEditorSample);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.TableCompositionExtensionEditorSample.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 * 
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (tableCompositionExtensionEditorSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (TableCompositionExtensionEditorSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.TableCompositionExtensionEditorSample.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == EefnrViewsRepository.TableCompositionExtensionEditorSample.class)
			this.basePart = (TableCompositionExtensionEditorSamplePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == EefnrViewsRepository.TableCompositionExtensionEditorSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final TableCompositionExtensionEditorSample tableCompositionExtensionEditorSample = (TableCompositionExtensionEditorSample)elt;
			// init values
			basePart.initTablecompositionRequiredProperty(tableCompositionExtensionEditorSample, null, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty());
			basePart.initTablecompositionOptionalProperty(tableCompositionExtensionEditorSample, null, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty());
			// init filters
			basePart.addFilterToTablecompositionRequiredProperty(new ViewerFilter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof AbstractTableCompositionTargetExtensionEditorSample);
				}

			});
			// Start of user code for additional businessfilters for tablecompositionRequiredProperty
			
			// End of user code

			basePart.addFilterToTablecompositionOptionalProperty(new ViewerFilter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof AbstractTableCompositionTargetExtensionEditorSample);
				}

			});
			// Start of user code for additional businessfilters for tablecompositionOptionalProperty
			
			// End of user code

		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((tableCompositionExtensionEditorSample != null) && (basePart != null)) { 
			List tablecompositionRequiredPropertyToAddFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToAdd();
			for (Iterator iter = tablecompositionRequiredPropertyToAddFromTablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty(), iter.next()));
			Map tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToEdit();
			for (Iterator iter = tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty.keySet().iterator(); iter.hasNext();) {
				AbstractTableCompositionTargetExtensionEditorSample nextElement = (AbstractTableCompositionTargetExtensionEditorSample) iter.next();
				AbstractTableCompositionTargetExtensionEditorSample tablecompositionRequiredProperty = (AbstractTableCompositionTargetExtensionEditorSample) tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionRequiredProperty.eGet(feature)));
					}
				}
			}
			List tablecompositionRequiredPropertyToRemoveFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToRemove();
			for (Iterator iter = tablecompositionRequiredPropertyToRemoveFromTablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionRequiredPropertyToMoveFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToMove();
			for (Iterator iter = tablecompositionRequiredPropertyToMoveFromTablecompositionRequiredProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getAbstractTableCompositionTargetExtensionEditorSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List tablecompositionRequiredPropertyToAddFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToAdd();
			for (Iterator iter = tablecompositionRequiredPropertyToAddFromTablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty(), iter.next()));
			Map tablecompositionRequiredPropertyToRefreshFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToEdit();
			for (Iterator iter = tablecompositionRequiredPropertyToRefreshFromTablecompositionOptionalProperty.keySet().iterator(); iter.hasNext();) {
				AbstractTableCompositionTargetExtensionEditorSample nextElement = (AbstractTableCompositionTargetExtensionEditorSample) iter.next();
				AbstractTableCompositionTargetExtensionEditorSample tablecompositionRequiredProperty = (AbstractTableCompositionTargetExtensionEditorSample) tablecompositionRequiredPropertyToRefreshFromTablecompositionOptionalProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionRequiredProperty.eGet(feature)));
					}
				}
			}
			List tablecompositionRequiredPropertyToRemoveFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToRemove();
			for (Iterator iter = tablecompositionRequiredPropertyToRemoveFromTablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionRequiredPropertyToMoveFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToMove();
			for (Iterator iter = tablecompositionRequiredPropertyToMoveFromTablecompositionOptionalProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getAbstractTableCompositionTargetExtensionEditorSample(), moveElement.getElement(), moveElement.getIndex()));
			}

		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 * 
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof TableCompositionExtensionEditorSample) {
			TableCompositionExtensionEditorSample tableCompositionExtensionEditorSampleToUpdate = (TableCompositionExtensionEditorSample)source;
			tableCompositionExtensionEditorSampleToUpdate.getTablecompositionRequiredProperty().addAll(basePart.getTablecompositionRequiredPropertyToAdd());
			tableCompositionExtensionEditorSampleToUpdate.getTablecompositionRequiredProperty().addAll(basePart.getTablecompositionOptionalPropertyToAdd());

			return tableCompositionExtensionEditorSampleToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (EefnrViewsRepository.TableCompositionExtensionEditorSample.tablecompositionRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					AbstractTableCompositionTargetExtensionEditorSample oldValue = (AbstractTableCompositionTargetExtensionEditorSample)event.getOldValue();
					AbstractTableCompositionTargetExtensionEditorSample newValue = (AbstractTableCompositionTargetExtensionEditorSample)event.getNewValue();
					// TODO: Complete the tableCompositionExtensionEditorSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getAbstractTableCompositionTargetExtensionEditorSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TableCompositionExtensionEditorSample.tablecompositionOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					AbstractTableCompositionTargetExtensionEditorSample oldValue = (AbstractTableCompositionTargetExtensionEditorSample)event.getOldValue();
					AbstractTableCompositionTargetExtensionEditorSample newValue = (AbstractTableCompositionTargetExtensionEditorSample)event.getNewValue();
					// TODO: Complete the tableCompositionExtensionEditorSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionExtensionEditorSample_TablecompositionRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, tableCompositionExtensionEditorSample, EefnrPackage.eINSTANCE.getAbstractTableCompositionTargetExtensionEditorSample(), event.getNewValue(), event.getNewIndex()));
			}

				if (!command.isEmpty() && !command.canExecute()) {
					EEFRuntimePlugin.getDefault().logError("Cannot perform model change command.", null);
				} else {
					liveEditingDomain.getCommandStack().execute(command);
				}
			}
			if (valueDiagnostic.getSeverity() != Diagnostic.OK && valueDiagnostic instanceof BasicDiagnostic)
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, valueDiagnostic));
			else {
				Diagnostic validate = validate();
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, validate));
			}
			super.firePropertiesChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TableCompositionExtensionEditorSample.tablecompositionRequiredProperty || key == EefnrViewsRepository.TableCompositionExtensionEditorSample.tablecompositionOptionalProperty;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(tableCompositionExtensionEditorSample);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(tableCompositionExtensionEditorSample);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			tableCompositionExtensionEditorSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
