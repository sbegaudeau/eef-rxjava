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

import org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.ab.abstractnonreg.providers.AbstractnonregMessages;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.nonreg.Person;


import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart;


// End of user code

/**
 * 
 */
public class TalkPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TalkPropertiesEditionPart {

	protected Text title;
	protected EMFComboViewer type;
	protected EObjectFlatComboViewer presenter;
	protected EMFComboViewer creator;

	private DocumentedElementPropertiesEditionPart documentedElementPropertiesEditionPart;



	
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
		createDocumentedElement(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(NonregMessages.TalkPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createTitleText(propertiesGroup);
		createTypeEMFComboViewer(propertiesGroup);
		createPresenterFlatComboViewer(propertiesGroup);
		createCreatorEMFComboViewer(propertiesGroup);
	}
	protected void createTitleText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TalkPropertiesEditionPart_TitleLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.title, NonregViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, NonregViewsRepository.Talk.title, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, title.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.title, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createTypeEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TalkPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.type, NonregViewsRepository.SWT_KIND));
		type = new EMFComboViewer(parent);
		type.setContentProvider(new ArrayContentProvider());
		type.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.type, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createPresenterFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TalkPropertiesEditionPart_PresenterLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.presenter, NonregViewsRepository.SWT_KIND));
		presenter = new EObjectFlatComboViewer(parent, false);
		presenter.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		presenter.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, NonregViewsRepository.Talk.presenter, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPresenter()));
			}

		});
		GridData presenterData = new GridData(GridData.FILL_HORIZONTAL);
		presenter.setLayoutData(presenterData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.presenter, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createCreatorEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TalkPropertiesEditionPart_CreatorLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Talk.creator, NonregViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TalkPropertiesEditionPartImpl.this, NonregViewsRepository.Talk.creator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCreator()));
			}
			
		});
		creator.setContentProvider(new EMFListContentProvider());
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Talk.creator, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createDocumentedElement(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(AbstractnonregViewsRepository.class);
		documentedElementPropertiesEditionPart = (DocumentedElementPropertiesEditionPart)provider.getPropertiesEditionPart(AbstractnonregViewsRepository.DocumentedElement.class, AbstractnonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)documentedElementPropertiesEditionPart).createControls(container);
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

	}

	public void unsetMessageForTitle() {

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

	public void setMessageForType(String msg, int msgLevel) {

	}

	public void unsetMessageForType() {

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

	public void setMessageForPresenter(String msg, int msgLevel) {

	}

	public void unsetMessageForPresenter() {

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

	public void setMessageForCreator(String msg, int msgLevel) {

	}

	public void unsetMessageForCreator() {

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
