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
import org.eclipse.emf.samples.conference.Site;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.SitePropertiesEditionPart;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * 
 */
public class SitePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private Site site;

	/**
	 * The Base part
	 */
	private SitePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public SitePropertiesEditionComponent(EObject site, String editing_mode) {
		if (site instanceof Site) {
			this.site = (Site)site;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.site.eAdapters().add(semanticAdapter);
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
					SitePropertiesEditionComponent.this.dispose();
				else {
					if (ConferencePackage.eINSTANCE.getSite_Name().equals(msg.getFeature()) && basePart != null)
						basePart.setName((String)msg.getNewValue());

					if (ConferencePackage.eINSTANCE.getSite_Documentation().equals(msg.getFeature()) && basePart != null)
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
			return ConferenceViewsRepository.Site.class;
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
		if (site != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ConferenceViewsRepository.class);
				if (provider != null) {
					basePart = (SitePropertiesEditionPart)provider.getPropertiesEditionPart(ConferenceViewsRepository.Site.class, kind, this);
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
		if (key == ConferenceViewsRepository.Site.class)
			this.basePart = (SitePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ConferenceViewsRepository.Site.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Site site = (Site)elt;
			// init values
			if (site.getName() != null)
				basePart.setName(site.getName());

			if (site.getDocumentation() != null)
				basePart.setDocumentation(site.getDocumentation());

			
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
		if (site != null) {
			cc.append(SetCommand.create(editingDomain, site, ConferencePackage.eINSTANCE.getSite_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, site, ConferencePackage.eINSTANCE.getSite_Documentation(), basePart.getDocumentation()));



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
		if (source instanceof Site) {
			Site siteToUpdate = (Site)source;
			siteToUpdate.setName(basePart.getName());

			siteToUpdate.setDocumentation(basePart.getDocumentation());



			return siteToUpdate;
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
			if (ConferenceViewsRepository.Site.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, site, ConferencePackage.eINSTANCE.getSite_Name(), event.getNewValue()));

			if (ConferenceViewsRepository.Site.documentation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, site, ConferencePackage.eINSTANCE.getSite_Documentation(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (ConferenceViewsRepository.Site.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				if (ConferenceViewsRepository.Site.documentation == event.getAffectedEditor())
					basePart.setMessageForDocumentation(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (ConferenceViewsRepository.Site.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				if (ConferenceViewsRepository.Site.documentation == event.getAffectedEditor())
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
		return key == ConferenceViewsRepository.Site.name || key == ConferenceViewsRepository.Site.documentation;
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
				if (ConferenceViewsRepository.Site.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getSite_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getSite_Name().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Site.documentation == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getSite_Documentation().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getSite_Documentation().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(site);
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
			site.eAdapters().remove(semanticAdapter);
	}

}
