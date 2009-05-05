/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.emf.eef.nonreg.EclipseSummit;



import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.parts.EclipseSummitPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * 
 */
public class EclipseSummitPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private EclipseSummit eclipseSummit;
	
	/**
	 * The Base part
	 */
	private EclipseSummitPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public EclipseSummitPropertiesEditionComponent(EObject eclipseSummit, String editing_mode) {
		if (eclipseSummit instanceof EclipseSummit) {
			this.eclipseSummit = (EclipseSummit)eclipseSummit;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eclipseSummit.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
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
				if (NonregPackage.eINSTANCE.getEclipseSummit_Place().equals(msg.getFeature()) && basePart != null)
					basePart.setPlace((String)msg.getNewValue());

				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == NonregPackage.eINSTANCE.getEclipseSummit_Sites()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == NonregPackage.eINSTANCE.getSite())) {
					basePart.updateSites(eclipseSummit);
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
			return NonregViewsRepository.EclipseSummit.class;
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
		if (eclipseSummit != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					basePart = (EclipseSummitPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.EclipseSummit.class, kind, this);
					listeners.add(basePart);
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
		if (basePart != null && key == NonregViewsRepository.EclipseSummit.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			EclipseSummit eclipseSummit = (EclipseSummit)elt;
			if (eclipseSummit.getPlace() != null)
				basePart.setPlace(eclipseSummit.getPlace());

			basePart.initSites(eclipseSummit, null, NonregPackage.eINSTANCE.getEclipseSummit_Sites());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (eclipseSummit != null) {
			cc.append(SetCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Place(), basePart.getPlace()));

			List sitesToAdd = basePart.getSitesToAdd();
			for (Iterator iter = sitesToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), iter.next()));
			Map sitesToRefresh = basePart.getSitesToEdit();
			for (Iterator iter = sitesToRefresh.keySet().iterator(); iter.hasNext();) {
				
				// Start of user code for sites reference refreshment
				
				Site nextElement = (Site) iter.next();
				Site sites = (Site) sitesToRefresh.get(nextElement);
				
				// End of user code				
			}
			List sitesToRemove = basePart.getSitesToRemove();
			for (Iterator iter = sitesToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List sitesToMove = basePart.getSitesToMove();
			for (Iterator iter = sitesToMove.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), moveElement.getElement(), moveElement.getIndex()));
			}


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
		if (source instanceof EclipseSummit) {
			EclipseSummit eclipseSummitToUpdate = (EclipseSummit)source;
			eclipseSummitToUpdate.setPlace(basePart.getPlace());

			eclipseSummitToUpdate.getSites().addAll(basePart.getSitesToAdd());


			return eclipseSummitToUpdate;
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
			if (NonregViewsRepository.EclipseSummit.place == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Place(), event.getNewValue()));

			if (NonregViewsRepository.EclipseSummit.sites == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Site oldValue = (Site)event.getOldValue();
					Site newValue = (Site)event.getNewValue();
					
					// Start of user code for sites live update command
					// TODO: Complete the eclipseSummit update command
					// End of user code					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (NonregViewsRepository.EclipseSummit.place == event.getAffectedEditor())
					basePart.setMessageForPlace(diag.getMessage(), IMessageProvider.ERROR);
				


			} else {
				if (NonregViewsRepository.EclipseSummit.place == event.getAffectedEditor())
					basePart.unsetMessageForPlace();
				


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == NonregViewsRepository.EclipseSummit.place;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == NonregViewsRepository.EclipseSummit.place)
			return "Where the summit take place"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
			if (NonregViewsRepository.EclipseSummit.place == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(NonregPackage.eINSTANCE.getEclipseSummit_Place().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(NonregPackage.eINSTANCE.getEclipseSummit_Place().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(eclipseSummit);
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
			eclipseSummit.eAdapters().remove(semanticAdapter);
	}

}

