/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.GENDER;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * 
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
			public void notifyChanged(Notification msg) {
				if (basePart == null)
					PersonBasePropertiesEditionComponent.this.dispose();
				else {
					if (NonregPackage.eINSTANCE.getPerson_Firstname().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null)
							basePart.setFirstname((String)msg.getNewValue());
						else
							basePart.setFirstname("");
					}
					if (NonregPackage.eINSTANCE.getPerson_Lastname().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null)
							basePart.setLastname((String)msg.getNewValue());
						else
							basePart.setLastname("");
					}
					if (NonregPackage.eINSTANCE.getPerson_Age().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null)
							basePart.setAge(((Integer)msg.getNewValue()).toString());
						else
							basePart.setAge("");
					}
					if (NonregPackage.eINSTANCE.getPerson_EclipseCommiter().equals(msg.getFeature()) && basePart != null)
						basePart.setEclipseCommiter((Boolean)msg.getNewValue());

					if (NonregPackage.eINSTANCE.getPerson_IsRegistered().equals(msg.getFeature()) && basePart != null)
						basePart.setIsRegistered((Boolean)msg.getNewValue());

					if (NonregPackage.eINSTANCE.getPerson_Gender().equals(msg.getFeature()) && basePart != null)
						basePart.setGender((Object)msg.getNewValue());

					if (NonregPackage.eINSTANCE.getPerson_WorkFor().equals(msg.getFeature()) && basePart != null)
						basePart.setWorkFor((EObject)msg.getNewValue());



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
			return NonregViewsRepository.Person.class;
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
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					basePart = (PersonPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.Person.class, kind, this);
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
		if (key == NonregViewsRepository.Person.class)
			this.basePart = (PersonPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == NonregViewsRepository.Person.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Person person = (Person)elt;
			// init values
			if (person.getFirstname() != null)
				basePart.setFirstname(person.getFirstname());

			if (person.getLastname() != null)
				basePart.setLastname(person.getLastname());

			basePart.setAge(String.valueOf(person.getAge()));

			basePart.setEclipseCommiter(person.isEclipseCommiter());

			basePart.setIsRegistered(person.isIsRegistered());

			basePart.initGender((EEnum) NonregPackage.eINSTANCE.getPerson_Gender().getEType(), person.getGender());
			basePart.initWorkFor(allResource, person.getWorkFor());
			// set the button mode
			basePart.setWorkForButtonMode(ButtonsModeEnum.BROWSE);
			
			// init filters






			basePart.addFilterToWorkFor(new EObjectFilter(NonregPackage.eINSTANCE.getCompany()));
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
			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Firstname(), basePart.getFirstname()));

			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Lastname(), basePart.getLastname()));

			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Age(), new Integer(basePart.getAge())));

			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_EclipseCommiter(), basePart.getEclipseCommiter()));

			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_IsRegistered(), basePart.getIsRegistered()));

			cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Gender(), ((EEnumLiteral)basePart.getGender()).getInstance()));

			if (person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()) == null || !person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()).equals(basePart.getWorkFor())) {
				cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), basePart.getWorkFor()));
			}



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

			personToUpdate.setIsRegistered(new Boolean(basePart.getIsRegistered()).booleanValue());

			personToUpdate.setGender((GENDER)basePart.getGender());

			personToUpdate.setWorkFor((Company)basePart.getWorkFor());



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
			if (NonregViewsRepository.Person.firstname == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Firstname(), event.getNewValue()));

			if (NonregViewsRepository.Person.lastname == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Lastname(), event.getNewValue()));

			if (NonregViewsRepository.Person.age == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Age(), new Integer((String)event.getNewValue())));

			if (NonregViewsRepository.Person.eclipseCommiter == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_EclipseCommiter(), event.getNewValue()));

			if (NonregViewsRepository.Person.isRegistered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_IsRegistered(), event.getNewValue()));

			if (NonregViewsRepository.Person.gender == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Gender(), event.getNewValue()));

			if (NonregViewsRepository.Person.workFor == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (NonregViewsRepository.Person.firstname == event.getAffectedEditor())
					basePart.setMessageForFirstname(diag.getMessage(), IMessageProvider.ERROR);
				if (NonregViewsRepository.Person.lastname == event.getAffectedEditor())
					basePart.setMessageForLastname(diag.getMessage(), IMessageProvider.ERROR);
				if (NonregViewsRepository.Person.age == event.getAffectedEditor())
					basePart.setMessageForAge(diag.getMessage(), IMessageProvider.ERROR);







			} else {
				if (NonregViewsRepository.Person.firstname == event.getAffectedEditor())
					basePart.unsetMessageForFirstname();
				if (NonregViewsRepository.Person.lastname == event.getAffectedEditor())
					basePart.unsetMessageForLastname();
				if (NonregViewsRepository.Person.age == event.getAffectedEditor())
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
		return key == NonregViewsRepository.Person.firstname || key == NonregViewsRepository.Person.age;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == NonregViewsRepository.Person.firstname)
			return "The firstname of the person"; //$NON-NLS-1$
		if (key == NonregViewsRepository.Person.lastname)
			return "The lastname of the person"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (NonregViewsRepository.Person.firstname == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_Firstname().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_Firstname().getEAttributeType(), newValue);
				}
				if (NonregViewsRepository.Person.lastname == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_Lastname().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_Lastname().getEAttributeType(), newValue);
				}
				if (NonregViewsRepository.Person.age == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_Age().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_Age().getEAttributeType(), newValue);
				}
				if (NonregViewsRepository.Person.eclipseCommiter == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_EclipseCommiter().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_EclipseCommiter().getEAttributeType(), newValue);
				}
				if (NonregViewsRepository.Person.isRegistered == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_IsRegistered().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_IsRegistered().getEAttributeType(), newValue);
				}
				if (NonregViewsRepository.Person.gender == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getPerson_Gender().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getPerson_Gender().getEAttributeType(), newValue);
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
