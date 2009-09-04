/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 */
public class TopicPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TopicPropertiesEditionPart {

	protected Text description;
	protected Text references;
	protected Button editReferences;
	private EList referencesList;
	protected Text documentation;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TopicPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(ConferenceMessages.TopicPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createDescriptionText(propertiesGroup);
		createReferencesMultiValuedEditor(propertiesGroup);
		createDocumentationTextarea(propertiesGroup);
	}
	protected void createDescriptionText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.TopicPropertiesEditionPart_DescriptionLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Topic.description, ConferenceViewsRepository.SWT_KIND));
		description = new Text(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TopicPropertiesEditionPartImpl.this, ConferenceViewsRepository.Topic.description, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, description.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Topic.description, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createReferencesMultiValuedEditor(Composite parent) {
		references = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData referencesData = new GridData(GridData.FILL_HORIZONTAL);
		referencesData.horizontalSpan = 2;
		references.setLayoutData(referencesData);
		editReferences = new Button(parent, SWT.NONE);
		editReferences.setText(ConferenceMessages.TopicPropertiesEditionPart_ReferencesLabel);
		GridData editReferencesData = new GridData();
		editReferences.setLayoutData(editReferencesData);
		editReferences.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EObject topic = PropertiesContextService.getInstance().lastElement();
				FeatureEditorDialog dialog = new FeatureEditorDialog(Display.getDefault().getActiveShell(), new AdapterFactoryLabelProvider(adapterFactory), topic, ConferencePackage.eINSTANCE.getTopic_References().getEType(), 
						referencesList, "Topic", null, false, false); //$NON-NLS-1$
						
				if (dialog.open() == Window.OK) {
					referencesList = dialog.getResult();
					if (referencesList == null) {
						referencesList = new BasicEList();
					}
					references.setText(referencesList.toString());
					setHasChanged(true);
				}
			}
		});
	}
	protected void createDocumentationTextarea(Composite parent) {
		Label documentationLabel = SWTUtils.createPartLabel(parent, ConferenceMessages.TopicPropertiesEditionPart_DocumentationLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Topic.documentation, ConferenceViewsRepository.SWT_KIND));
		GridData documentationLabelData = new GridData(GridData.FILL_HORIZONTAL);
		documentationLabelData.horizontalSpan = 3;
		documentationLabel.setLayoutData(documentationLabelData);
		documentation = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData documentationData = new GridData(GridData.FILL_HORIZONTAL);
		documentationData.horizontalSpan = 2;
		documentationData.heightHint = 80;
		documentation.setLayoutData(documentationData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Topic.documentation, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#getDescription()
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#setDescription(String newValue)
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForDescription(String msg, int msgLevel) {

	}

	public void unsetMessageForDescription() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#getReferences()
	 */
	public EList getReferences() {
		return referencesList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#setReferences(EList newValue)
	 */
	public void setReferences(EList newValue) {
		referencesList = newValue;
		if (newValue != null) {
			references.setText(referencesList.toString());
		} else {
			references.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForReferences(String msg, int msgLevel) {

	}

	public void unsetMessageForReferences() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart#setDocumentation(String newValue)
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