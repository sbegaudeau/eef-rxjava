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
import org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregPackage;
import org.eclipse.emf.eef.middle.middlenonreg.providers.MiddlenonregMessages;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart;
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
import org.eclipse.emf.eef.nonreg.Adress;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.NonregFactory;


import org.eclipse.emf.eef.middle.middlenonreg.parts.MiddlenonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart;


// End of user code
/**
 * 
 */
public class CompanyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CompanyPropertiesEditionPart {

	private AdvancedEObjectFlatComboViewer<Adress> adress;
	protected ViewerFilter adressFilter;

	private NamedElementPropertiesEditionPart namedElementPropertiesEditionPart;



	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public CompanyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(view);
		createNamedElement(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(NonregMessages.CompanyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createAdressAdvancedFlatComboViewer(propertiesGroup);
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createAdressAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.CompanyPropertiesEditionPart_AdressLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Company.adress, NonregViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Adress> listener = new EObjectFlatComboViewerListener<Adress>(){
			public void handleSet(Adress element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CompanyPropertiesEditionPartImpl.this, NonregViewsRepository.Company.adress, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Adress element){ }
			
			public Adress handleCreate() {
				Adress eObject = NonregFactory.eINSTANCE.createAdress();
				if (current != null && current instanceof Company && ((Company)current).getAdress() != null) {
					eObject = (Adress) EcoreUtil.copy(((Company)current).getAdress());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CompanyPropertiesEditionPartImpl.this, NonregViewsRepository.Company.adress, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Adress)propertiesEditionObject;
					}
					if (current != null && current instanceof Company && ((Company)current).getAdress() != null)
						return eObject;
					return null;
				}
				return null;
			}
		};
		//create widget
		adress = new AdvancedEObjectFlatComboViewer<Adress>(NonregMessages.CompanyPropertiesEditionPart_AdressLabel,
			resourceSet, adressFilter, NonregPackage.eINSTANCE.getAdress(), listener);
		adress.createControls(parent);
		GridData adressData = new GridData(GridData.FILL_HORIZONTAL);
		adress.setLayoutData(adressData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Company.adress, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createNamedElement(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MiddlenonregViewsRepository.class);
		namedElementPropertiesEditionPart = (NamedElementPropertiesEditionPart)provider.getPropertiesEditionPart(MiddlenonregViewsRepository.NamedElement.class, MiddlenonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)namedElementPropertiesEditionPart).createControls(container);
	}



	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#getAdress()
	 */
	public EObject getAdress() {
		return adress.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#initAdress(ResourceSet allResources, EObject current)
	 */
	public void initAdress(ResourceSet allResources, EObject current) {
		adress.setInput(allResources);
		if (current != null) {
			adress.setSelection(new StructuredSelection(current));
			adress.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#setAdress(EObject newValue)
	 */
	public void setAdress(EObject newValue) {
		if (newValue != null) {
			adress.setSelection(new StructuredSelection(newValue));
		} else {
			adress.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#setAdressButtonMode(ButtonsModeEnum newValue)
	 */
	public void setAdressButtonMode(ButtonsModeEnum newValue) {
		adress.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#addFilterAdress(ViewerFilter filter)
	 */
	public void addFilterToAdress(ViewerFilter filter) {
		adress.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#addBusinessFilterAdress(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdress(ViewerFilter filter) {
		adress.addBusinessRuleFilter(filter);
	}

	public void setMessageForAdress(String msg, int msgLevel) {

	}

	public void unsetMessageForAdress() {

	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#getNamedElementReferencedView()
	 */
		public IPropertiesEditionPart getNamedElementReferencedView() {
			return (IPropertiesEditionPart) namedElementPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#getName()
	 */
	public String getName() {
		return namedElementPropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CompanyPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		namedElementPropertiesEditionPart.setName(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {
		namedElementPropertiesEditionPart.setMessageForName(msg, msgLevel);
	}

	public void unsetMessageForName() {
		namedElementPropertiesEditionPart.unsetMessageForName();
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.NamedElementPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return namedElementPropertiesEditionPart.getDocumentation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.NamedElementPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		namedElementPropertiesEditionPart.setDocumentation(newValue);
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {
		namedElementPropertiesEditionPart.setMessageForDocumentation(msg, msgLevel);
	}

	public void unsetMessageForDocumentation() {
		namedElementPropertiesEditionPart.unsetMessageForDocumentation();
	}








	// Start of user code additional methods
	
	// End of user code
}
