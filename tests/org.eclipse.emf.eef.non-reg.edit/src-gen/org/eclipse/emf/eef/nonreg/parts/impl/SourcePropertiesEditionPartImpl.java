/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationFactory;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.nonreg.modelNavigation.RealCible;
import org.eclipse.emf.eef.nonreg.modelNavigation.SuperCible;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.SourcePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

// End of user code
/**
 * 
 */
public class SourcePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SourcePropertiesEditionPart {

	private AdvancedEObjectFlatComboViewer<SuperCible> advancedUniqueRef;
	protected ViewerFilter advancedUniqueRefFilter;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SourcePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createAdvancedUniqueRefAdvancedFlatComboViewer(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param view
	 */
	protected void createAdvancedUniqueRefAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<SuperCible> listener = new EObjectFlatComboViewerListener<SuperCible>(){
			public void handleSet(SuperCible element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartImpl.this, NonregViewsRepository.Source.advancedUniqueRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(SuperCible element){ }
			
			public SuperCible handleCreate() {
				SuperCible eObject = ModelNavigationFactory.eINSTANCE.createRealCible();
				if (current != null && current instanceof RealCible && ((RealCible)current).getRef() != null)
					eObject = ((RealCible)current).getRef();
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartImpl.this, NonregViewsRepository.Source.advancedUniqueRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
					}
					return (SuperCible)propertiesEditionObject;
				}
				return null;
			}
		};
		//create widget
		advancedUniqueRef = new AdvancedEObjectFlatComboViewer<SuperCible>(NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel,
			resourceSet, advancedUniqueRefFilter, ModelNavigationPackage.eINSTANCE.getSuperCible(), listener);
		advancedUniqueRef.createControls(parent);
		GridData advancedUniqueRefData = new GridData(GridData.FILL_HORIZONTAL);
		advancedUniqueRef.setLayoutData(advancedUniqueRefData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#getAdvancedUniqueRef()
	 */
	public EObject getAdvancedUniqueRef() {
		return advancedUniqueRef.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#initAdvancedUniqueRef(ResourceSet allResources, EObject current)
	 */
	public void initAdvancedUniqueRef(ResourceSet allResources, EObject current) {
		advancedUniqueRef.setInput(allResources);
		if (current != null) {
			advancedUniqueRef.setSelection(new StructuredSelection(current));
			advancedUniqueRef.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#setAdvancedUniqueRef(EObject newValue)
	 */
	public void setAdvancedUniqueRef(EObject newValue) {
		if (newValue != null) {
			advancedUniqueRef.setSelection(new StructuredSelection(newValue));
		} else {
			advancedUniqueRef.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#setAdvancedUniqueRefButtonMode(ButtonsModeEnum newValue)
	 */
	public void setAdvancedUniqueRefButtonMode(ButtonsModeEnum newValue) {
		advancedUniqueRef.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addFilterAdvancedUniqueRef(ViewerFilter filter)
	 */
	public void addFilterToAdvancedUniqueRef(ViewerFilter filter) {
		advancedUniqueRef.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addBusinessFilterAdvancedUniqueRef(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedUniqueRef(ViewerFilter filter) {
		advancedUniqueRef.addBusinessRuleFilter(filter);
	}

	public void setMessageForAdvancedUniqueRef(String msg, int msgLevel) {

	}

	public void unsetMessageForAdvancedUniqueRef() {

	}








	// Start of user code additional methods
	
	// End of user code
}
