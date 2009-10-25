/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author
 */
public class TalkPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TalkPropertiesEditionPart {

	protected Text title;
	protected EObjectFlatComboViewer topic;
	protected EMFComboViewer type;
	protected EObjectFlatComboViewer presenter;
	protected EObjectFlatComboViewer creator;
	protected Text documentation;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TalkPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ConferenceMessages.TalkPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createTitleText(propertiesGroup);
		createTopicFlatComboViewer(propertiesGroup);
		createTypeEMFComboViewer(propertiesGroup);
		createPresenterFlatComboViewer(propertiesGroup);
		createCreatorFlatComboViewer(propertiesGroup);
		createDocumentationTextarea(propertiesGroup);
	}
	protected void createTitleText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_TitleLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.title, ConferenceViewsRepository.SWT_KIND));
		title = new Text(parent, SWT.BORDER);
		GridData titleData = new GridData(GridData.FILL_HORIZONTAL);
		title.setLayoutData(titleData);
		title.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, ConferenceViewsRepository.Talk.title, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, title.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.title, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createTopicFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_TopicLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.topic, ConferenceViewsRepository.SWT_KIND));
		topic = new EObjectFlatComboViewer(parent, false);
		topic.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		topic.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, ConferenceViewsRepository.Talk.topic, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTopic()));
			}

		});
		GridData topicData = new GridData(GridData.FILL_HORIZONTAL);
		topic.setLayoutData(topicData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.topic, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createTypeEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.type, ConferenceViewsRepository.SWT_KIND));
		type = new EMFComboViewer(parent);
		type.setContentProvider(new ArrayContentProvider());
		type.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.type, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createPresenterFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_PresenterLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.presenter, ConferenceViewsRepository.SWT_KIND));
		presenter = new EObjectFlatComboViewer(parent, false);
		presenter.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		presenter.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, ConferenceViewsRepository.Talk.presenter, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPresenter()));
			}

		});
		GridData presenterData = new GridData(GridData.FILL_HORIZONTAL);
		presenter.setLayoutData(presenterData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.presenter, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createCreatorFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_CreatorLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.creator, ConferenceViewsRepository.SWT_KIND));
		creator = new EObjectFlatComboViewer(parent, true);
		creator.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		creator.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, ConferenceViewsRepository.Talk.creator, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getCreator()));
			}

		});
		GridData creatorData = new GridData(GridData.FILL_HORIZONTAL);
		creator.setLayoutData(creatorData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.creator, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createDocumentationTextarea(Composite parent) {
		Label documentationLabel = SWTUtils.createPartLabel(parent, ConferenceMessages.TalkPropertiesEditionPart_DocumentationLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Talk.documentation, ConferenceViewsRepository.SWT_KIND));
		GridData documentationLabelData = new GridData(GridData.FILL_HORIZONTAL);
		documentationLabelData.horizontalSpan = 3;
		documentationLabel.setLayoutData(documentationLabelData);
		documentation = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData documentationData = new GridData(GridData.FILL_HORIZONTAL);
		documentationData.horizontalSpan = 2;
		documentationData.heightHint = 80;
		documentation.setLayoutData(documentationData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Talk.documentation, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return title.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setTitle(String newValue)
	 */
	public void setTitle(String newValue) {
		if (newValue != null) {
			title.setText(newValue);
		} else {
			title.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForTitle(String msg, int msgLevel) {

	}

	public void unsetMessageForTitle() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getTopic()
	 */
	public EObject getTopic() {
		if (topic.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) topic.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#initTopic(ResourceSet allResources, EObject current)
	 */
	public void initTopic(ResourceSet allResources, EObject current) {
		topic.setInput(allResources);
		if (current != null) {
			topic.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setTopic(EObject newValue)
	 */
	public void setTopic(EObject newValue) {
		if (newValue != null) {
			topic.setSelection(new StructuredSelection(newValue));
		} else {
			topic.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setTopicButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTopicButtonMode(ButtonsModeEnum newValue) {
		topic.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addFilterTopic(ViewerFilter filter)
	 */
	public void addFilterToTopic(ViewerFilter filter) {
		topic.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addBusinessFilterTopic(ViewerFilter filter)
	 */
	public void addBusinessFilterToTopic(ViewerFilter filter) {
		topic.addBusinessRuleFilter(filter);
	}

	public void setMessageForTopic(String msg, int msgLevel) {

	}

	public void unsetMessageForTopic() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getType()
	 */
	public Enumerator getType() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) type.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#initType(EEnum eenum, Enumerator current)
	 */
	public void initType(EEnum eenum, Enumerator current) {
		type.setInput(eenum.getELiterals());
		type.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setType(Enumerator newValue)
	 */
	public void setType(Enumerator newValue) {
		type.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForType(String msg, int msgLevel) {

	}

	public void unsetMessageForType() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getPresenter()
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
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#initPresenter(ResourceSet allResources, EObject current)
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
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setPresenter(EObject newValue)
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
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setPresenterButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPresenterButtonMode(ButtonsModeEnum newValue) {
		presenter.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addFilterPresenter(ViewerFilter filter)
	 */
	public void addFilterToPresenter(ViewerFilter filter) {
		presenter.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addBusinessFilterPresenter(ViewerFilter filter)
	 */
	public void addBusinessFilterToPresenter(ViewerFilter filter) {
		presenter.addBusinessRuleFilter(filter);
	}

	public void setMessageForPresenter(String msg, int msgLevel) {

	}

	public void unsetMessageForPresenter() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getCreator()
	 */
	public EObject getCreator() {
		if (creator.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) creator.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#initCreator(ResourceSet allResources, EObject current)
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
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setCreator(EObject newValue)
	 */
	public void setCreator(EObject newValue) {
		if (newValue != null) {
			creator.setSelection(new StructuredSelection(newValue));
		} else {
			creator.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setCreatorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCreatorButtonMode(ButtonsModeEnum newValue) {
		creator.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addFilterCreator(ViewerFilter filter)
	 */
	public void addFilterToCreator(ViewerFilter filter) {
		creator.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#addBusinessFilterCreator(ViewerFilter filter)
	 */
	public void addBusinessFilterToCreator(ViewerFilter filter) {
		creator.addBusinessRuleFilter(filter);
	}

	public void setMessageForCreator(String msg, int msgLevel) {

	}

	public void unsetMessageForCreator() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		if (newValue != null) {
			documentation.setText(newValue);
		} else {
			documentation.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {

	}

	public void unsetMessageForDocumentation() {

	}








	// Start of user code additional methods
	
	// End of user code

}
