/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
public class AdvancedEObjectFlatComboViewerPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, AdvancedEObjectFlatComboViewerPropertiesEditionPart {

	protected AdvancedEObjectFlatComboViewer<Company> advancedeobjectflatcomboviewer;
	protected ViewerFilter advancedeobjectflatcomboviewerFilter;
	protected AdvancedEObjectFlatComboViewer<Company> advancedeobjectflatcomboviewerRO;
	protected ViewerFilter advancedeobjectflatcomboviewerROFilter;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AdvancedEObjectFlatComboViewerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createAdvancedeobjectflatcomboviewerFlatComboViewer(view, widgetFactory);
		createAdvancedeobjectflatcomboviewerROFlatComboViewer(view, widgetFactory);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	/**
	 * @param view
	 */
	protected void createAdvancedeobjectflatcomboviewerFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, NonregViewsRepository.FORM_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }

			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company)EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
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
		advancedeobjectflatcomboviewer.createControls(parent, widgetFactory);
		GridData advancedeobjectflatcomboviewerData = new GridData(GridData.FILL_HORIZONTAL);
		advancedeobjectflatcomboviewer.setLayoutData(advancedeobjectflatcomboviewerData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param view
	 */
	protected void createAdvancedeobjectflatcomboviewerROFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.AdvancedEObjectFlatComboViewerPropertiesEditionPart_AdvancedeobjectflatcomboviewerROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, NonregViewsRepository.FORM_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }

			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company)EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedEObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
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
		advancedeobjectflatcomboviewerRO.createControls(parent, widgetFactory);
		advancedeobjectflatcomboviewerRO.setEnabled(false);
		advancedeobjectflatcomboviewerRO.setToolTipText(NonregMessages.AdvancedEObjectFlatComboViewer_ReadOnly);
		GridData advancedeobjectflatcomboviewerROData = new GridData(GridData.FILL_HORIZONTAL);
		advancedeobjectflatcomboviewerRO.setLayoutData(advancedeobjectflatcomboviewerROData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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











	
	// Start of user code additional methods
	
	// End of user code

}	
