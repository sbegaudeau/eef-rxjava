/**
 * 
 */
package org.eclipse.emf.eef.modelingBot.batch;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.interpreter.EEFInterpreter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class BatchModelingBot implements IModelingBot {

	private IProgressMonitor monitor;
	private EditingDomain editingDomain;
	private AdapterFactory adapterFactory;
	private Resource activeResource;
	private EEFInterpreter interpreter;
	
	/**
	 * 
	 */
	public BatchModelingBot() {
		monitor = new NullProgressMonitor();
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
		interpreter = new EEFInterpreter(editingDomain);
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#runModelingBot(java.lang.String)
	 */
	public void runModelingBot(String path) throws CoreException, IOException {
		interpreter.runModelingBot(path, this);
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createProject(java.lang.String)
	 */
	public void createProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			project.create(new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openProject(java.lang.String)
	 */
	public void openProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeProject(java.lang.String)
	 */
	public void closeProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#removeProject(java.lang.String)
	 */
	public void removeProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			project.delete(true, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openPerspective(java.lang.String)
	 */
	public void openPerspective(String name) {
		// Nothing to do
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openEEFEditor(java.lang.String)
	 */
	public void openEEFEditor(String path) {
		URI uri = URI.createPlatformResourceURI(path, true);
		Resource activeResource = editingDomain.getResourceSet().getResource(uri, true);
		this.activeResource = activeResource;
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeEditor(java.lang.String)
	 */
	public void closeEditor(String path) {
		activeResource.unload();
		activeResource = null;
		editingDomain.getResourceSet().getResources().remove(activeResource);
	}

	
	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#save()
	 */
	public void save() {
		if (activeResource != null) {
			try {
				activeResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//TODO: Error
		}
	}
	
	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#add(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EClass)
	 */
	public EObject add(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature, EClass type) {
		EObject eObjectFromReferenceableEObject = interpreter.getEObjectFromReferenceableEObject(referenceableObject);
		activeResource = eObjectFromReferenceableEObject.eResource();
		EObject value = EcoreUtil.create(type);
		Command command = AddCommand.create(editingDomain, eObjectFromReferenceableEObject, eContainingFeature, value);
		editingDomain.getCommandStack().execute(command);
		return value;
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#remove(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject)
	 */
	public void remove(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject) {
		EObject eObjectFromReferenceableEObject = interpreter.getEObjectFromReferenceableEObject(referenceableObject);
		activeResource = eObjectFromReferenceableEObject.eResource();
		EcoreUtil.remove(eObjectFromReferenceableEObject);
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#set(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.String)
	 */
	public void set(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject,	EStructuralFeature eContainingFeature, String value) {
		EObject eObjectFromReferenceableEObject = interpreter.getEObjectFromReferenceableEObject(referenceableObject);
		if (eContainingFeature instanceof EAttribute) {
			activeResource = eObjectFromReferenceableEObject.eResource();
			Object createFromString = EcoreUtil.createFromString(((EAttribute)eContainingFeature).getEAttributeType(), value);
			Command command = SetCommand.create(editingDomain, eObjectFromReferenceableEObject, eContainingFeature, createFromString);
			editingDomain.getCommandStack().execute(command);
		} else {
			//TODO: Error !
		}
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#set(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.eef.extended.editor.ReferenceableObject)
	 */
	public void set(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject,	EStructuralFeature eContainingFeature, ReferenceableObject value) {
		EObject eObjectFromReferenceableEObject = interpreter.getEObjectFromReferenceableEObject(referenceableObject);
		if (eContainingFeature instanceof EReference) {
			activeResource = eObjectFromReferenceableEObject.eResource();
			Command command = SetCommand.create(editingDomain, eObjectFromReferenceableEObject, eContainingFeature, interpreter.getEObjectFromReferenceableEObject(value));
			editingDomain.getCommandStack().execute(command);
		} else {
			//TODO: Error !
		}
	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#unset(org.eclipse.emf.eef.components.PropertiesEditionElement, org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void unset(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createModel(java.lang.String, java.lang.String, org.eclipse.emf.ecore.EClass)
	 */
	public EObject createModel(String path, String modelName, EClass eClass) {
		try {
			URI uri = URI.createPlatformResourceURI(path + "/" + modelName , true);
			Resource activeResource = editingDomain.getResourceSet().createResource(uri);
			EObject create = EcoreUtil.create(eClass);
			activeResource.getContents().add(create);
			activeResource.save(Collections.EMPTY_MAP);
			this.activeResource = activeResource;
			return create;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public void setSequenceType(SequenceType detailsPage) {
		// TODO Auto-generated method stub
		
	}

	public void validateBatchEditing() {
		// TODO Auto-generated method stub
		
	}

}
