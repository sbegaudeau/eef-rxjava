/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 */
package org.eclipse.emf.eef.EEFGen.components;

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
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenModelPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private EEFGenModel eEFGenModel;

	/**
	 * The Base part
	 */
	private EEFGenModelPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public EEFGenModelPropertiesEditionComponent(EObject eEFGenModel, String editing_mode) {
		if (eEFGenModel instanceof EEFGenModel) {
			this.eEFGenModel = (EEFGenModel)eEFGenModel;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eEFGenModel.eAdapters().add(semanticAdapter);
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
					EEFGenModelPropertiesEditionComponent.this.dispose();
				else {
					if (EEFGenPackage.eINSTANCE.getEEFGenModel_GenDirectory().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null) {
							basePart.setGenerationDirectory((String)msg.getNewValue());
}
						else
							basePart.setGenerationDirectory("");
					}
					if (EEFGenPackage.eINSTANCE.getEEFGenModel_Author().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null) {
							basePart.setAuthor((String)msg.getNewValue());
}
						else
							basePart.setAuthor("");
					}
					if (EEFGenPackage.eINSTANCE.getEEFGenModel_License().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null) 
							basePart.setLicense((String)msg.getNewValue());
						else
							basePart.setLicense((String)"");
					}

					if (EEFGenPackage.eINSTANCE.getEEFGenModel_TestsGenDirectory().equals(msg.getFeature()) && basePart != null){
						if (msg.getNewValue() != null) {
							basePart.setTestsGenerationDirectory((String)msg.getNewValue());
}
						else
							basePart.setTestsGenerationDirectory("");
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
			return EEFGenViewsRepository.EEFGenModel.class;
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
		if (eEFGenModel != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EEFGenViewsRepository.class);
				if (provider != null) {
					basePart = (EEFGenModelPropertiesEditionPart)provider.getPropertiesEditionPart(EEFGenViewsRepository.EEFGenModel.class, kind, this);
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
		if (key == EEFGenViewsRepository.EEFGenModel.class)
			this.basePart = (EEFGenModelPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == EEFGenViewsRepository.EEFGenModel.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final EEFGenModel eEFGenModel = (EEFGenModel)elt;
			// init values
			if (eEFGenModel.getGenDirectory() != null)
				basePart.setGenerationDirectory(eEFGenModel.getGenDirectory());

			if (eEFGenModel.getAuthor() != null)
				basePart.setAuthor(eEFGenModel.getAuthor());

			if (eEFGenModel.getLicense() != null)
				basePart.setLicense(eEFGenModel.getLicense());

			if (eEFGenModel.getTestsGenDirectory() != null)
				basePart.setTestsGenerationDirectory(eEFGenModel.getTestsGenDirectory());

			
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
		if (eEFGenModel != null) {
			cc.append(SetCommand.create(editingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_GenDirectory(), basePart.getGenerationDirectory()));

			cc.append(SetCommand.create(editingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_Author(), basePart.getAuthor()));

			cc.append(SetCommand.create(editingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_License(), basePart.getLicense()));

			cc.append(SetCommand.create(editingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_TestsGenDirectory(), basePart.getTestsGenerationDirectory()));



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
		if (source instanceof EEFGenModel) {
			EEFGenModel eEFGenModelToUpdate = (EEFGenModel)source;
			eEFGenModelToUpdate.setGenDirectory(basePart.getGenerationDirectory());

			eEFGenModelToUpdate.setAuthor(basePart.getAuthor());

			eEFGenModelToUpdate.setLicense(basePart.getLicense());

			eEFGenModelToUpdate.setTestsGenDirectory(basePart.getTestsGenerationDirectory());



			return eEFGenModelToUpdate;
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
			if (EEFGenViewsRepository.EEFGenModel.generationDirectory == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_GenDirectory(), event.getNewValue()));

			if (EEFGenViewsRepository.EEFGenModel.author == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_Author(), event.getNewValue()));

			if (EEFGenViewsRepository.EEFGenModel.license == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_License(), event.getNewValue()));

			if (EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eEFGenModel, EEFGenPackage.eINSTANCE.getEEFGenModel_TestsGenDirectory(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (EEFGenViewsRepository.EEFGenModel.generationDirectory == event.getAffectedEditor())
					basePart.setMessageForGenerationDirectory(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.EEFGenModel.author == event.getAffectedEditor())
					basePart.setMessageForAuthor(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.EEFGenModel.license == event.getAffectedEditor())
					basePart.setMessageForLicense(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory == event.getAffectedEditor())
					basePart.setMessageForTestsGenerationDirectory(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (EEFGenViewsRepository.EEFGenModel.generationDirectory == event.getAffectedEditor())
					basePart.unsetMessageForGenerationDirectory();
				if (EEFGenViewsRepository.EEFGenModel.author == event.getAffectedEditor())
					basePart.unsetMessageForAuthor();
				if (EEFGenViewsRepository.EEFGenModel.license == event.getAffectedEditor())
					basePart.unsetMessageForLicense();
				if (EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory == event.getAffectedEditor())
					basePart.unsetMessageForTestsGenerationDirectory();


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == EEFGenViewsRepository.EEFGenModel.generationDirectory;
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
				if (EEFGenViewsRepository.EEFGenModel.generationDirectory == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getEEFGenModel_GenDirectory().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getEEFGenModel_GenDirectory().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.EEFGenModel.author == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getEEFGenModel_Author().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getEEFGenModel_Author().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.EEFGenModel.license == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getEEFGenModel_License().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getEEFGenModel_License().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getEEFGenModel_TestsGenDirectory().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getEEFGenModel_TestsGenDirectory().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(eEFGenModel);
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
			eEFGenModel.eAdapters().remove(semanticAdapter);
	}

}
