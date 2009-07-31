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

import org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.ab.abstractnonreg.providers.AbstractnonregMessages;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.emf.eef.nonreg.Person;


import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart;


// End of user code

/**
 * 
 */
public class TalkPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TalkPropertiesEditionPart {

	protected Text title;
	protected EMFComboViewer type;
	protected EObjectFlatComboViewer presenter;
	protected EMFComboViewer creator;

	private DocumentedElementPropertiesEditionPart documentedElementPropertiesEditionPart;



	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TalkPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);
		createDocumentedElement(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(NonregMessages.TalkPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createTitleText(widgetFactory, propertiesGroup);
		createTypeEMFComboViewer(widgetFactory, propertiesGroup);
		createPresenterFlatComboViewer(propertiesGroup, widgetFactory);
		createCreatorEMFComboViewer(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}
	protected void createTitleText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TalkPropertiesEditionPart_TitleLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.title, NonregViewsRepository.FORM_KIND));
		title = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		title.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData titleData = new GridData(GridData.FILL_HORIZONTAL);
		title.setLayoutData(titleData);
		title.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.title, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, title.getText()));
			}

		});
		title.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.title, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title.getText()));
			}

		});
		title.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.title, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.title, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TalkPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.type, NonregViewsRepository.FORM_KIND));
		type = new EMFComboViewer(parent);
		type.setContentProvider(new ArrayContentProvider());
		type.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.type, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createPresenterFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TalkPropertiesEditionPart_PresenterLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.presenter, NonregViewsRepository.FORM_KIND));
		presenter = new EObjectFlatComboViewer(parent, false);
		presenter.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData presenterData = new GridData(GridData.FILL_HORIZONTAL);
		presenter.setLayoutData(presenterData);
		presenter.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.presenter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPresenter()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.presenter, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createCreatorEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TalkPropertiesEditionPart_CreatorLabel, false);
		creator = new EMFComboViewer(parent);
		GridData creatorData = new GridData(GridData.FILL_HORIZONTAL);
		creator.getCombo().setLayoutData(creatorData);
		creator.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		creator.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartForm.this, NonregViewsRepository.Talk.creator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCreator()));
			}

		});
		creator.setContentProvider(new EMFListContentProvider());
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.creator, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createDocumentedElement(FormToolkit widgetFactory, Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(AbstractnonregViewsRepository.class);
		documentedElementPropertiesEditionPart = (DocumentedElementPropertiesEditionPart)provider.getPropertiesEditionPart(AbstractnonregViewsRepository.DocumentedElement.class, AbstractnonregViewsRepository.FORM_KIND, propertiesEditionComponent);
		((IFormPropertiesEditionPart)documentedElementPropertiesEditionPart).createControls(widgetFactory, container, messageManager);
	}


	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return title.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setTitle(String newValue)
	 */
	public void setTitle(String newValue) {
		if (newValue != null) {
			title.setText(newValue);
		} else {
			title.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForTitle(String msg, int msgLevel) {
		messageManager.addMessage("Title_key", msg, null, msgLevel, title);
	}

	public void unsetMessageForTitle() {
		messageManager.removeMessage("Title_key", title);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getType()
	 */
	public Enumerator getType() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) type.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#initType(EEnum eenum, Enumerator current)
	 */
	public void initType(EEnum eenum, Enumerator current) {
		type.setInput(eenum.getELiterals());
		type.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setType(Enumerator newValue)
	 */
	public void setType(Enumerator newValue) {
		type.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getPresenter()
	 */
	public EObject getPresenter() {
		if (presenter.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) presenter.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#initPresenter(ResourceSet allResources, EObject current)
	 */
	public void initPresenter(ResourceSet allResources, EObject current) {
		presenter.setInput(allResources);
		if (current != null) {
			presenter.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setPresenter(EObject newValue)
	 */
	public void setPresenter(EObject newValue) {
		if (newValue != null) {
			presenter.setSelection(new StructuredSelection(newValue));
		} else {
			presenter.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setPresenterButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPresenterButtonMode(ButtonsModeEnum newValue) {
		presenter.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#addFilterPresenter(ViewerFilter filter)
	 */
	public void addFilterToPresenter(ViewerFilter filter) {
		presenter.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#addBusinessFilterPresenter(ViewerFilter filter)
	 */
	public void addBusinessFilterToPresenter(ViewerFilter filter) {
		presenter.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getCreator()
	 */
	public Object getCreator() {
		if (creator.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) creator.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#initCreator(ResourceSet allResources, EObject current)
	 */
	public void initCreator(ResourceSet allResources, EObject current) {
		creator.setInput(allResources);
		if (current != null) {
			creator.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setCreator(Object newValue)
	 */
	public void setCreator(Object newValue) {
		if (newValue != null) {
			creator.modelUpdating(new StructuredSelection(newValue));
		} else {
			creator.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#addFilterCreator(ViewerFilter filter)
	 */
	public void addFilterToCreator(ViewerFilter filter) {
		creator.addFilter(filter);
	}






/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getDocumentedElementReferencedView()
	 */
		public IPropertiesEditionPart getDocumentedElementReferencedView() {
			return (IPropertiesEditionPart) documentedElementPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentedElementPropertiesEditionPart.getDocumentation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TalkPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		documentedElementPropertiesEditionPart.setDocumentation(newValue);
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {
		documentedElementPropertiesEditionPart.setMessageForDocumentation(msg, msgLevel);
	}

	public void unsetMessageForDocumentation() {
		documentedElementPropertiesEditionPart.unsetMessageForDocumentation();
	}






	
	// Start of user code additional methods
	
	// End of user code

}	
