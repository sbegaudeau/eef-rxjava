/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
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

import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;



import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.parts.AdvancedReferencesTablePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

// End of user code
/**
 * 
 */
public class AdvancedReferencesTablePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private Person person;

	/**
	 * The Base part
	 */
	private AdvancedReferencesTablePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public AdvancedReferencesTablePropertiesEditionComponent(EObject person, String editing_mode) {
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
					AdvancedReferencesTablePropertiesEditionComponent.this.dispose();
				else {
					if (NonregPackage.eINSTANCE.getPerson_Assists().equals(msg.getFeature()))
						basePart.updateAdvancedreferencestable(person);
					if (NonregPackage.eINSTANCE.getPerson_Assists().equals(msg.getFeature()))
						basePart.updateAdvancedreferencestableRO(person);


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
			return NonregViewsRepository.AdvancedReferencesTable.class;
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
		if (person != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					basePart = (AdvancedReferencesTablePropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.AdvancedReferencesTable.class, kind, this);
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
		if (key == NonregViewsRepository.AdvancedReferencesTable.class)
			this.basePart = (AdvancedReferencesTablePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == NonregViewsRepository.AdvancedReferencesTable.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			Person person = (Person)elt;
			// init values
			basePart.initAdvancedreferencestable(person, null, NonregPackage.eINSTANCE.getPerson_Assists());
			basePart.initAdvancedreferencestableRO(person, null, NonregPackage.eINSTANCE.getPerson_Assists());
			
			// init filters
			basePart.addFilterToAdvancedreferencestable(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestable(new EObjectFilter(NonregPackage.eINSTANCE.getTalk()));
			// Start of user code for additional businessfilters for advancedreferencestable
			
			// End of user code
			basePart.addFilterToAdvancedreferencestableRO(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableROTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestableRO(new EObjectFilter(NonregPackage.eINSTANCE.getTalk()));
			// Start of user code for additional businessfilters for advancedreferencestableRO
			
			// End of user code
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
			List assistsToAddFromAdvancedreferencestable = basePart.getAdvancedreferencestableToAdd();
			for (Iterator iter = assistsToAddFromAdvancedreferencestable.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), iter.next()));
			List assistsToRemoveFromAdvancedreferencestable = basePart.getAdvancedreferencestableToRemove();
			for (Iterator iter = assistsToRemoveFromAdvancedreferencestable.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), iter.next()));
			//List assistsToMoveFromAdvancedreferencestable = basePart.getAdvancedreferencestableToMove();
			//for (Iterator iter = assistsToMoveFromAdvancedreferencestable.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getTalk(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List assistsToAddFromAdvancedreferencestableRO = basePart.getAdvancedreferencestableROToAdd();
			for (Iterator iter = assistsToAddFromAdvancedreferencestableRO.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), iter.next()));
			List assistsToRemoveFromAdvancedreferencestableRO = basePart.getAdvancedreferencestableROToRemove();
			for (Iterator iter = assistsToRemoveFromAdvancedreferencestableRO.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), iter.next()));
			//List assistsToMoveFromAdvancedreferencestableRO = basePart.getAdvancedreferencestableROToMove();
			//for (Iterator iter = assistsToMoveFromAdvancedreferencestableRO.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getTalk(), moveElement.getElement(), moveElement.getIndex()));
			//}


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
			personToUpdate.getAssists().addAll(basePart.getAdvancedreferencestableToAdd());
			personToUpdate.getAssists().addAll(basePart.getAdvancedreferencestableROToAdd());


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
			if (NonregViewsRepository.AdvancedReferencesTable.advancedreferencestable == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue(), event.getNewIndex()));
			}
			if (NonregViewsRepository.AdvancedReferencesTable.advancedreferencestableRO == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_Assists(), event.getNewValue(), event.getNewIndex()));
			}


			if (!command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {




			} else {




			}
		}
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

