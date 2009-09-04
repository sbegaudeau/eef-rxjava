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
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.samples.conference.Topic;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.TopicPropertiesEditionPart;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * @author
 */
public class TopicPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private Topic topic;

	/**
	 * The Base part
	 */
	private TopicPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public TopicPropertiesEditionComponent(EObject topic, String editing_mode) {
		if (topic instanceof Topic) {
			this.topic = (Topic)topic;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.topic.eAdapters().add(semanticAdapter);
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
					TopicPropertiesEditionComponent.this.dispose();
				else {
					if (ConferencePackage.eINSTANCE.getTopic_Description().equals(msg.getFeature()) && basePart != null)
						basePart.setDescription((String)msg.getNewValue());

					if (ConferencePackage.eINSTANCE.getTopic_References().equals(msg.getFeature()) && basePart != null)
						basePart.setReferences((EList)msg.getNewValue());

					if (ConferencePackage.eINSTANCE.getTopic_Documentation().equals(msg.getFeature()) && basePart != null)
						basePart.setDocumentation((String)msg.getNewValue());



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
			return ConferenceViewsRepository.Topic.class;
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
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (topic != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ConferenceViewsRepository.class);
				if (provider != null) {
					basePart = (TopicPropertiesEditionPart)provider.getPropertiesEditionPart(ConferenceViewsRepository.Topic.class, kind, this);
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
		if (key == ConferenceViewsRepository.Topic.class)
			this.basePart = (TopicPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ConferenceViewsRepository.Topic.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Topic topic = (Topic)elt;
			// init values
			if (topic.getDescription() != null)
				basePart.setDescription(topic.getDescription());

			if (topic.getReferences() != null)
				basePart.setReferences(topic.getReferences());
			if (topic.getDocumentation() != null)
				basePart.setDocumentation(topic.getDocumentation());

			
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
		if (topic != null) {
			cc.append(SetCommand.create(editingDomain, topic, ConferencePackage.eINSTANCE.getTopic_Description(), basePart.getDescription()));

			cc.append(SetCommand.create(editingDomain, topic, ConferencePackage.eINSTANCE.getTopic_References(), basePart.getReferences()));

			cc.append(SetCommand.create(editingDomain, topic, ConferencePackage.eINSTANCE.getTopic_Documentation(), basePart.getDocumentation()));



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
		if (source instanceof Topic) {
			Topic topicToUpdate = (Topic)source;
			topicToUpdate.setDescription(basePart.getDescription());

			topicToUpdate.getReferences().addAll(basePart.getReferences());

			topicToUpdate.setDocumentation(basePart.getDocumentation());



			return topicToUpdate;
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
			if (ConferenceViewsRepository.Topic.description == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, topic, ConferencePackage.eINSTANCE.getTopic_Description(), event.getNewValue()));

			if (ConferenceViewsRepository.Topic.references == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, topic, ConferencePackage.eINSTANCE.getTopic_References(), event.getNewValue()));

			if (ConferenceViewsRepository.Topic.documentation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, topic, ConferencePackage.eINSTANCE.getTopic_Documentation(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (ConferenceViewsRepository.Topic.description == event.getAffectedEditor())
					basePart.setMessageForDescription(diag.getMessage(), IMessageProvider.ERROR);

				if (ConferenceViewsRepository.Topic.documentation == event.getAffectedEditor())
					basePart.setMessageForDocumentation(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (ConferenceViewsRepository.Topic.description == event.getAffectedEditor())
					basePart.unsetMessageForDescription();

				if (ConferenceViewsRepository.Topic.documentation == event.getAffectedEditor())
					basePart.unsetMessageForDocumentation();


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == ConferenceViewsRepository.Topic.documentation;
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
				if (ConferenceViewsRepository.Topic.description == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTopic_Description().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTopic_Description().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Topic.references == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTopic_References().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTopic_References().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Topic.documentation == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTopic_Documentation().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTopic_Documentation().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(topic);
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
			topic.eAdapters().remove(semanticAdapter);
	}

}
