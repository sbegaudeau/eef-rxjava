/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.middle.middlenonreg.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.middle.middlenonreg.NamedElement;

import org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregPackage;
import org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.middle.middlenonreg.parts.MiddlenonregViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * 
 */
public class NamedElementBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private NamedElement namedElement;
	
	/**
	 * The Base part
	 */
	private NamedElementPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public NamedElementBasePropertiesEditionComponent(EObject namedElement, String editing_mode) {
		if (namedElement instanceof NamedElement) {
			this.namedElement = (NamedElement)namedElement;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.namedElement.eAdapters().add(semanticAdapter);
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
				if (MiddlenonregPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());


				if (AbstractnonregPackage.eINSTANCE.getDocumentedElement_Documentation().equals(msg.getFeature()) && basePart != null)
					basePart.setDocumentation((String)msg.getNewValue());


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
			return MiddlenonregViewsRepository.NamedElement.class;
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
		if (namedElement != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MiddlenonregViewsRepository.class);
				if (provider != null) {
					basePart = (NamedElementPropertiesEditionPart)provider.getPropertiesEditionPart(MiddlenonregViewsRepository.NamedElement.class, kind, this);
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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == MiddlenonregViewsRepository.NamedElement.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			NamedElement namedElement = (NamedElement)elt;
			// init values
			if (namedElement.getName() != null)
				basePart.setName(namedElement.getName());

			
			// init filters
			
		}
		// init values for referenced views
		if (namedElement.getDocumentation() != null)
				basePart.setDocumentation(namedElement.getDocumentation());


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
		if (namedElement != null) {
			cc.append(SetCommand.create(editingDomain, namedElement, MiddlenonregPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));


			cc.append(SetCommand.create(editingDomain, namedElement, AbstractnonregPackage.eINSTANCE.getDocumentedElement_Documentation(), basePart.getDocumentation()));


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof NamedElement) {
			NamedElement namedElementToUpdate = (NamedElement)source;
			namedElementToUpdate.setName(basePart.getName());


			namedElementToUpdate.setDocumentation(basePart.getDocumentation());	


			return namedElementToUpdate;
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
			if (MiddlenonregViewsRepository.NamedElement.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, namedElement, MiddlenonregPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));


			if (AbstractnonregViewsRepository.DocumentedElement.documentation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, namedElement, AbstractnonregPackage.eINSTANCE.getDocumentedElement_Documentation(), event.getNewValue()));


			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (MiddlenonregViewsRepository.NamedElement.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

				if (AbstractnonregViewsRepository.DocumentedElement.documentation == event.getAffectedEditor())
					basePart.setMessageForDocumentation(diag.getMessage(), IMessageProvider.ERROR);

			} else {
				if (MiddlenonregViewsRepository.NamedElement.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

				if (AbstractnonregViewsRepository.DocumentedElement.documentation == event.getAffectedEditor())
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
		return key == MiddlenonregViewsRepository.NamedElement.name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (MiddlenonregViewsRepository.NamedElement.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(MiddlenonregPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(MiddlenonregPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}

			if (AbstractnonregViewsRepository.DocumentedElement.documentation == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(AbstractnonregPackage.eINSTANCE.getDocumentedElement_Documentation().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(AbstractnonregPackage.eINSTANCE.getDocumentedElement_Documentation().getEAttributeType(), newValue);
			}
		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			return Diagnostician.INSTANCE.validate(namedElement);
		else
			return null;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			namedElement.eAdapters().remove(semanticAdapter);
	}

}

