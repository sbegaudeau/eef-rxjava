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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.TableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TableCompositionEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TableCompositionEditorSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	/**
	 * The EObject to edit
	 * 
	 */
	private TableCompositionEditorSample tableCompositionEditorSample;

	/**
	 * The Base part
	 * 
	 */
	protected TableCompositionEditorSamplePropertiesEditionPart basePart;
	
	/**
	 * Settings for tablecompositionRequiredProperty ReferencesTable
	 */
	private	ReferencesTableSettings tablecompositionRequiredPropertySettings;
	
	/**
	 * Settings for tablecompositionOptionalProperty ReferencesTable
	 */
	private	ReferencesTableSettings tablecompositionOptionalPropertySettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public TableCompositionEditorSamplePropertiesEditionComponent(EObject tableCompositionEditorSample, String editing_mode) {
		if (tableCompositionEditorSample instanceof TableCompositionEditorSample) {
			this.tableCompositionEditorSample = (TableCompositionEditorSample)tableCompositionEditorSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter((IPropertiesEditionPart)basePart);
				this.tableCompositionEditorSample.eAdapters().add(semanticAdapter);
			}
		}
		parts = new String[] { BASE_PART };
		this.editing_mode = editing_mode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.TableCompositionEditorSample.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (tableCompositionEditorSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (TableCompositionEditorSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.TableCompositionEditorSample.class, kind, this);
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
		if (key == EefnrViewsRepository.TableCompositionEditorSample.class)
			this.basePart = (TableCompositionEditorSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EefnrViewsRepository.TableCompositionEditorSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final TableCompositionEditorSample tableCompositionEditorSample = (TableCompositionEditorSample)elt;
			// init values
								tablecompositionRequiredPropertySettings = new ReferencesTableSettings(tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty());
								basePart.initTablecompositionRequiredProperty(tablecompositionRequiredPropertySettings);
								tablecompositionOptionalPropertySettings = new ReferencesTableSettings(tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty());
								basePart.initTablecompositionOptionalProperty(tablecompositionOptionalPropertySettings);
			// init filters
			basePart.addFilterToTablecompositionRequiredProperty(new ViewerFilter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Sample);
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
						return (element instanceof String && element.equals("")) || (element instanceof Sample); //$NON-NLS-1$ 
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
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		if (EefnrViewsRepository.TableCompositionEditorSample.tablecompositionRequiredProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof Sample) {
						tablecompositionRequiredPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						tablecompositionRequiredPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
		if (EefnrViewsRepository.TableCompositionEditorSample.tablecompositionOptionalProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof Sample) {
						tablecompositionOptionalPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						tablecompositionOptionalPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty().equals(msg.getFeature()))
			basePart.updateTablecompositionRequiredProperty(tableCompositionEditorSample);
		if (EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty().equals(msg.getFeature()))
			basePart.updateTablecompositionOptionalProperty(tableCompositionEditorSample);
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TableCompositionEditorSample.tablecompositionRequiredProperty;
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(tableCompositionEditorSample);
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
			tableCompositionEditorSample.eAdapters().remove(semanticAdapter);
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
