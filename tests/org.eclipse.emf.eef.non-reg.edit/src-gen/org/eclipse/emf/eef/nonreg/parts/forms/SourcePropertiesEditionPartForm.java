/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.nonreg.modelNavigation.SuperCible;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.SourcePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

// End of user code
/**
 * 
 */
public class SourcePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, SourcePropertiesEditionPart {

	protected AdvancedEObjectFlatComboViewer advancedUniqueRef;
	protected ViewerFilter advancedUniqueRefFilter;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SourcePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createAdvancedUniqueRefFlatComboViewer(view, widgetFactory);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	/**
	 * @param view
	 */
	protected void createAdvancedUniqueRefFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		Label advancedUniqueRefLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.FORM_KIND));
		
		advancedUniqueRef = new AdvancedEObjectFlatComboViewer<SuperCible>(NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, 
			resourceSet, advancedUniqueRefFilter, ModelNavigationPackage.eINSTANCE.getSuperCible(), new EObjectFlatComboViewerListener<SuperCible>(){
			public void handleSet(SuperCible element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedUniqueRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(SuperCible element){ }
		}){
			@Override
			protected void browseButtonPressed() {
				TabElementTreeSelectionDialog<SuperCible> dialog = new TabElementTreeSelectionDialog<SuperCible>(input, filters,
						brFilters, NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, ModelNavigationPackage.eINSTANCE.getSuperCible(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						if (selection != null && !selection.isEmpty()) {
							handleSelection((SuperCible) selection.getFirstElement());
						}
					}
				};
				// Select the actual element in dialog
				if (selection != null) {
					dialog.setSelection(new StructuredSelection(selection));
				}
				dialog.open();
			}
		};
		advancedUniqueRef.createControls(parent, widgetFactory);
		GridData advancedUniqueRefData = new GridData(GridData.FILL_HORIZONTAL);
		advancedUniqueRef.setLayoutData(advancedUniqueRefData);
		
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		if (current != null)
			advancedUniqueRef.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#setAdvancedUniqueRef(EObject newValue)
	 */
	public void setAdvancedUniqueRef(EObject newValue) {
		if (newValue != null) {
			advancedUniqueRef.setSelection(newValue);
		} else {
			advancedUniqueRef.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
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











	
	// Start of user code additional methods
	
	// End of user code
}	
