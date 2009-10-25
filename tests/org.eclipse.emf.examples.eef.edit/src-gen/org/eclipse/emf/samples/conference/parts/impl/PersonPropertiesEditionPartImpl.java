/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author
 */
public class PersonPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PersonPropertiesEditionPart {

	protected Text firstname;
	protected Text lastname;
	protected Text age;
	protected EMFComboViewer gender;
	protected Button eclipseCommiter;
	protected Button isRegistered;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PersonPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createIdentityGroup(view);
		createEclipseStatusGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createIdentityGroup(Composite parent) {
		Group identityGroup = new Group(parent, SWT.NONE);
		identityGroup.setText(ConferenceMessages.PersonPropertiesEditionPart_IdentityGroupLabel);
		GridData identityGroupData = new GridData(GridData.FILL_HORIZONTAL);
		identityGroupData.horizontalSpan = 3;
		identityGroup.setLayoutData(identityGroupData);
		GridLayout identityGroupLayout = new GridLayout();
		identityGroupLayout.numColumns = 3;
		identityGroup.setLayout(identityGroupLayout);
		createFirstnameText(identityGroup);
		createLastnameText(identityGroup);
		createAgeText(identityGroup);
		createGenderEMFComboViewer(identityGroup);
	}
	protected void createFirstnameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.PersonPropertiesEditionPart_FirstnameLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Person.firstname, ConferenceViewsRepository.SWT_KIND));
		firstname = new Text(parent, SWT.BORDER);
		GridData firstnameData = new GridData(GridData.FILL_HORIZONTAL);
		firstname.setLayoutData(firstnameData);
		firstname.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, ConferenceViewsRepository.Person.firstname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, firstname.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.firstname, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createLastnameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.PersonPropertiesEditionPart_LastnameLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Person.lastname, ConferenceViewsRepository.SWT_KIND));
		lastname = new Text(parent, SWT.BORDER);
		GridData lastnameData = new GridData(GridData.FILL_HORIZONTAL);
		lastname.setLayoutData(lastnameData);
		lastname.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, ConferenceViewsRepository.Person.lastname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, lastname.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.lastname, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createAgeText(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.PersonPropertiesEditionPart_AgeLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Person.age, ConferenceViewsRepository.SWT_KIND));
		age = new Text(parent, SWT.BORDER);
		GridData ageData = new GridData(GridData.FILL_HORIZONTAL);
		age.setLayoutData(ageData);
		age.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, ConferenceViewsRepository.Person.age, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, age.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.age, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createGenderEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ConferenceMessages.PersonPropertiesEditionPart_GenderLabel, propertiesEditionComponent.isRequired(ConferenceViewsRepository.Person.gender, ConferenceViewsRepository.SWT_KIND));
		gender = new EMFComboViewer(parent);
		gender.setContentProvider(new ArrayContentProvider());
		gender.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData genderData = new GridData(GridData.FILL_HORIZONTAL);
		gender.getCombo().setLayoutData(genderData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.gender, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createEclipseStatusGroup(Composite parent) {
		Group eclipseStatusGroup = new Group(parent, SWT.NONE);
		eclipseStatusGroup.setText(ConferenceMessages.PersonPropertiesEditionPart_EclipseStatusGroupLabel);
		GridData eclipseStatusGroupData = new GridData(GridData.FILL_HORIZONTAL);
		eclipseStatusGroupData.horizontalSpan = 3;
		eclipseStatusGroup.setLayoutData(eclipseStatusGroupData);
		GridLayout eclipseStatusGroupLayout = new GridLayout();
		eclipseStatusGroupLayout.numColumns = 3;
		eclipseStatusGroup.setLayout(eclipseStatusGroupLayout);
		createEclipseCommiterCheckbox(eclipseStatusGroup);
		createIsRegisteredCheckbox(eclipseStatusGroup);
	}
	protected void createEclipseCommiterCheckbox(Composite parent) {
		eclipseCommiter = new Button(parent, SWT.CHECK);
		eclipseCommiter.setText(ConferenceMessages.PersonPropertiesEditionPart_EclipseCommiterLabel);
		GridData eclipseCommiterData = new GridData(GridData.FILL_HORIZONTAL);
		eclipseCommiterData.horizontalSpan = 2;
		eclipseCommiter.setLayoutData(eclipseCommiterData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.eclipseCommiter, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createIsRegisteredCheckbox(Composite parent) {
		isRegistered = new Button(parent, SWT.CHECK);
		isRegistered.setText(ConferenceMessages.PersonPropertiesEditionPart_IsRegisteredLabel);
		GridData isRegisteredData = new GridData(GridData.FILL_HORIZONTAL);
		isRegisteredData.horizontalSpan = 2;
		isRegistered.setLayoutData(isRegisteredData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Person.isRegistered, ConferenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getFirstname()
	 */
	public String getFirstname() {
		return firstname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setFirstname(String newValue)
	 */
	public void setFirstname(String newValue) {
		if (newValue != null) {
			firstname.setText(newValue);
		} else {
			firstname.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForFirstname(String msg, int msgLevel) {

	}

	public void unsetMessageForFirstname() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getLastname()
	 */
	public String getLastname() {
		return lastname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setLastname(String newValue)
	 */
	public void setLastname(String newValue) {
		if (newValue != null) {
			lastname.setText(newValue);
		} else {
			lastname.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForLastname(String msg, int msgLevel) {

	}

	public void unsetMessageForLastname() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getAge()
	 */
	public String getAge() {
		return age.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setAge(String newValue)
	 */
	public void setAge(String newValue) {
		if (newValue != null) {
			age.setText(newValue);
		} else {
			age.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForAge(String msg, int msgLevel) {

	}

	public void unsetMessageForAge() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getGender()
	 */
	public Enumerator getGender() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) gender.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#initGender(EEnum eenum, Enumerator current)
	 */
	public void initGender(EEnum eenum, Enumerator current) {
		gender.setInput(eenum.getELiterals());
		gender.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setGender(Enumerator newValue)
	 */
	public void setGender(Enumerator newValue) {
		gender.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForGender(String msg, int msgLevel) {

	}

	public void unsetMessageForGender() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getEclipseCommiter()
	 */
	public Boolean getEclipseCommiter() {
		return Boolean.valueOf(eclipseCommiter.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setEclipseCommiter(Boolean newValue)
	 */
	public void setEclipseCommiter(Boolean newValue) {
		if (newValue != null) {
			eclipseCommiter.setSelection(newValue.booleanValue());
		} else {
			eclipseCommiter.setSelection(false);
		}
	}

	public void setMessageForEclipseCommiter(String msg, int msgLevel) {

	}

	public void unsetMessageForEclipseCommiter() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#getIsRegistered()
	 */
	public Boolean getIsRegistered() {
		return Boolean.valueOf(isRegistered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart#setIsRegistered(Boolean newValue)
	 */
	public void setIsRegistered(Boolean newValue) {
		if (newValue != null) {
			isRegistered.setSelection(newValue.booleanValue());
		} else {
			isRegistered.setSelection(false);
		}
	}

	public void setMessageForIsRegistered(String msg, int msgLevel) {

	}

	public void unsetMessageForIsRegistered() {

	}








	// Start of user code additional methods
	
	// End of user code

}
