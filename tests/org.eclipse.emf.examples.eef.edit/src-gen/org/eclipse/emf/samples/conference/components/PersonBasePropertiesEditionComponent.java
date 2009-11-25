/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.GENDER;
import org.eclipse.emf.samples.conference.Person;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author
 */
public class PersonBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private Person person;

	/**
	 * The Base part
	 */
	private PersonPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public PersonBasePropertiesEditionComponent(EObject person, String editing_mode) {
		if (person instanceof Person) {
			this.person = (Person)person;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.person.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					PersonBasePropertiesEditionComponent.this.dispose();
				else {
                    Runnable updateRunnable = new Runnable() {
                        public void run() {
							if (ConferencePackage.eINSTANCE.getPerson_Firstname().equals(msg.getFeature()) && basePart != null){
								if (msg.getNewValue() != null)
									basePart.setFirstname((String)msg.getNewValue());
								else
									basePart.setFirstname("");
							}
							if (ConferencePackage.eINSTANCE.getPerson_Lastname().equals(msg.getFeature()) && basePart != null){
								if (msg.getNewValue() != null)
									basePart.setLastname((String)msg.getNewValue());
								else
									basePart.setLastname("");
							}
							if (ConferencePackage.eINSTANCE.getPerson_Age().equals(msg.getFeature()) && basePart != null){
								if (msg.getNewValue() != null)
									basePart.setAge(((Integer)msg.getNewValue()).toString());
								else
									basePart.setAge("");
							}
							if (ConferencePackage.eINSTANCE.getPerson_EclipseCommiter().equals(msg.getFeature()) && basePart != null)
								basePart.setEclipseCommiter((Boolean)msg.getNewValue());

						if (ConferencePackage.eINSTANCE.getPerson_Gender().equals(msg.getFeature()) && basePart != null)
							basePart.setGender((Enumerator)msg.getNewValue());

							if (ConferencePackage.eINSTANCE.getPerson_IsRegistered().equals(msg.getFeature()) && basePart != null)
								basePart.setIsRegistered((Boolean)msg.getNewValue());



						}
					};
                    if (null == Display.getCurrent()) {
                        PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
                    } else {
                        updateRunnable.run();
                    }
				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return ConferenceViewsRepository.Person.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (person != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ConferenceViewsRepository.class);
				if (provider != null) {
					basePart = (PersonPropertiesEditionPart)provider.getPropertiesEditionPart(ConferenceViewsRepository.Person.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == ConferenceViewsRepository.Person.class)
			this.basePart = (PersonPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ConferenceViewsRepository.Person.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Person person = (Person)elt;
			// init values
			if (person.getFirstname() != null)
				basePart.setFirstname(person.getFirstname());

			if (person.getLastname() != null)
				basePart.setLastname(person.getLastname());

			basePart.setAge(String.valueOf(person.getAge()));

			basePart.setEclipseCommiter(person.isEclipseCommiter());

			basePart.initGender((EEnum) ConferencePackage.eINSTANCE.getPerson_Gender().getEType(), person.getGender());
			basePart.setIsRegistered(person.isIsRegistered());

			
			// init filters






		}
		// init values for referenced views

		// init filters for referenced views

	}










	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (person != null) {
			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Firstname(), basePart.getFirstname()));

			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Lastname(), basePart.getLastname()));

			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Age(), new Integer(basePart.getAge())));

			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_EclipseCommiter(), basePart.getEclipseCommiter()));

			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Gender(), basePart.getGender()));

			cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_IsRegistered(), basePart.getIsRegistered()));



		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof Person) {
			Person personToUpdate = (Person)source;
			personToUpdate.setFirstname(basePart.getFirstname());

			personToUpdate.setLastname(basePart.getLastname());

			personToUpdate.setAge(new Integer(basePart.getAge()).intValue());

			personToUpdate.setEclipseCommiter(new Boolean(basePart.getEclipseCommiter()).booleanValue());

			personToUpdate.setGender((GENDER)basePart.getGender());

			personToUpdate.setIsRegistered(new Boolean(basePart.getIsRegistered()).booleanValue());



			return personToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (ConferenceViewsRepository.Person.firstname == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_Firstname(), event.getNewValue()));

			if (ConferenceViewsRepository.Person.lastname == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_Lastname(), event.getNewValue()));

			if (ConferenceViewsRepository.Person.age == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_Age(), new Integer((String)event.getNewValue())));

			if (ConferenceViewsRepository.Person.eclipseCommiter == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_EclipseCommiter(), event.getNewValue()));

			if (ConferenceViewsRepository.Person.gender == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_Gender(), event.getNewValue()));

			if (ConferenceViewsRepository.Person.isRegistered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, ConferencePackage.eINSTANCE.getPerson_IsRegistered(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (ConferenceViewsRepository.Person.firstname == event.getAffectedEditor())
					basePart.setMessageForFirstname(diag.getMessage(), IMessageProvider.ERROR);
				if (ConferenceViewsRepository.Person.lastname == event.getAffectedEditor())
					basePart.setMessageForLastname(diag.getMessage(), IMessageProvider.ERROR);
				if (ConferenceViewsRepository.Person.age == event.getAffectedEditor())
					basePart.setMessageForAge(diag.getMessage(), IMessageProvider.ERROR);





			} else {
				if (ConferenceViewsRepository.Person.firstname == event.getAffectedEditor())
					basePart.unsetMessageForFirstname();
				if (ConferenceViewsRepository.Person.lastname == event.getAffectedEditor())
					basePart.unsetMessageForLastname();
				if (ConferenceViewsRepository.Person.age == event.getAffectedEditor())
					basePart.unsetMessageForAge();





			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == ConferenceViewsRepository.Person.firstname || key == ConferenceViewsRepository.Person.age;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (ConferenceViewsRepository.Person.firstname == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_Firstname().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_Firstname().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Person.lastname == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_Lastname().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_Lastname().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Person.age == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_Age().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_Age().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Person.eclipseCommiter == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_EclipseCommiter().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_EclipseCommiter().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Person.gender == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_Gender().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_Gender().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Person.isRegistered == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getPerson_IsRegistered().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getPerson_IsRegistered().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate =  Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(person);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			person.eAdapters().remove(semanticAdapter);
	}

}
