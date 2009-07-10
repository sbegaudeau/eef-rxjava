/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.NonregFactory;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AdvancedEObjectFlatComboViewerPropertiesEditionPart {

	private AdvancedEObjectFlatComboViewer<Company> advancedeobjectflatcomboviewer;
	protected ViewerFilter advancedeobjectflatcomboviewerFilter;
	private AdvancedEObjectFlatComboViewer<Company> advancedeobjectflatcomboviewerRO;
	protected ViewerFilter advancedeobjectflatcomboviewerROFilter;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createAdvancedeobjectflatcomboviewerAdvancedFlatComboViewer(view);
		createAdvancedeobjectflatcomboviewerROAdvancedFlatComboViewer(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param view
	 */
	protected void createAdvancedeobjectflatcomboviewerAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, NonregViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }
			
			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company) EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Company)propertiesEditionObject;
					}
					if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null)
						return eObject;
					return null;
				}
				return null;
			}
		};
		//create widget
		advancedeobjectflatcomboviewer = new AdvancedEObjectFlatComboViewer<Company>(NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerLabel,
			resourceSet, advancedeobjectflatcomboviewerFilter, NonregPackage.eINSTANCE.getCompany(), listener);
		advancedeobjectflatcomboviewer.createControls(parent);
		GridData advancedeobjectflatcomboviewerData = new GridData(GridData.FILL_HORIZONTAL);
		advancedeobjectflatcomboviewer.setLayoutData(advancedeobjectflatcomboviewerData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param view
	 */
	protected void createAdvancedeobjectflatcomboviewerROAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, NonregViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }
			
			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company) EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartImpl.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Company)propertiesEditionObject;
					}
					if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null)
						return eObject;
					return null;
				}
				return null;
			}
		};
		//create widget
		advancedeobjectflatcomboviewerRO = new AdvancedEObjectFlatComboViewer<Company>(NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerROLabel,
			resourceSet, advancedeobjectflatcomboviewerROFilter, NonregPackage.eINSTANCE.getCompany(), listener);
		advancedeobjectflatcomboviewerRO.createControls(parent);
		advancedeobjectflatcomboviewerRO.setEnabled(false);
		advancedeobjectflatcomboviewerRO.setToolTipText(NonregMessages.AdvancedEObjectFlatComboViewer_ReadOnly);
		GridData advancedeobjectflatcomboviewerROData = new GridData(GridData.FILL_HORIZONTAL);
		advancedeobjectflatcomboviewerRO.setLayoutData(advancedeobjectflatcomboviewerROData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#getAdvancedeobjectflatcomboviewer()
	 */
	public EObject getAdvancedeobjectflatcomboviewer() {
		return advancedeobjectflatcomboviewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#initAdvancedeobjectflatcomboviewer(ResourceSet allResources, EObject current)
	 */
	public void initAdvancedeobjectflatcomboviewer(ResourceSet allResources, EObject current) {
		advancedeobjectflatcomboviewer.setInput(allResources);
		if (current != null) {
			advancedeobjectflatcomboviewer.setSelection(new StructuredSelection(current));
			advancedeobjectflatcomboviewer.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#setAdvancedeobjectflatcomboviewer(EObject newValue)
	 */
	public void setAdvancedeobjectflatcomboviewer(EObject newValue) {
		if (newValue != null) {
			advancedeobjectflatcomboviewer.setSelection(new StructuredSelection(newValue));
		} else {
			advancedeobjectflatcomboviewer.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#setAdvancedeobjectflatcomboviewerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setAdvancedeobjectflatcomboviewerButtonMode(ButtonsModeEnum newValue) {
		advancedeobjectflatcomboviewer.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#addFilterAdvancedeobjectflatcomboviewer(ViewerFilter filter)
	 */
	public void addFilterToAdvancedeobjectflatcomboviewer(ViewerFilter filter) {
		advancedeobjectflatcomboviewer.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#addBusinessFilterAdvancedeobjectflatcomboviewer(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewer(ViewerFilter filter) {
		advancedeobjectflatcomboviewer.addBusinessRuleFilter(filter);
	}

	public void setMessageForAdvancedeobjectflatcomboviewer(String msg, int msgLevel) {

	}

	public void unsetMessageForAdvancedeobjectflatcomboviewer() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#getAdvancedeobjectflatcomboviewerRO()
	 */
	public EObject getAdvancedeobjectflatcomboviewerRO() {
		return advancedeobjectflatcomboviewerRO.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#initAdvancedeobjectflatcomboviewerRO(ResourceSet allResources, EObject current)
	 */
	public void initAdvancedeobjectflatcomboviewerRO(ResourceSet allResources, EObject current) {
		advancedeobjectflatcomboviewerRO.setInput(allResources);
		if (current != null) {
			advancedeobjectflatcomboviewerRO.setSelection(new StructuredSelection(current));
			advancedeobjectflatcomboviewerRO.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#setAdvancedeobjectflatcomboviewerRO(EObject newValue)
	 */
	public void setAdvancedeobjectflatcomboviewerRO(EObject newValue) {
		if (newValue != null) {
			advancedeobjectflatcomboviewerRO.setSelection(new StructuredSelection(newValue));
		} else {
			advancedeobjectflatcomboviewerRO.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#setAdvancedeobjectflatcomboviewerROButtonMode(ButtonsModeEnum newValue)
	 */
	public void setAdvancedeobjectflatcomboviewerROButtonMode(ButtonsModeEnum newValue) {
		advancedeobjectflatcomboviewerRO.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#addFilterAdvancedeobjectflatcomboviewerRO(ViewerFilter filter)
	 */
	public void addFilterToAdvancedeobjectflatcomboviewerRO(ViewerFilter filter) {
		advancedeobjectflatcomboviewerRO.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart#addBusinessFilterAdvancedeobjectflatcomboviewerRO(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedeobjectflatcomboviewerRO(ViewerFilter filter) {
		advancedeobjectflatcomboviewerRO.addBusinessRuleFilter(filter);
	}

	public void setMessageForAdvancedeobjectflatcomboviewerRO(String msg, int msgLevel) {

	}

	public void unsetMessageForAdvancedeobjectflatcomboviewerRO() {

	}








	// Start of user code additional methods
	
	// End of user code
}
