/**
 * 
 */
package org.eclipse.emf.eef.codegen.core.initializer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.eef.codegen.core.util.EMFHelper;
import org.eclipse.emf.eef.codegen.flow.Workflow;
import org.eclipse.emf.eef.codegen.flow.WorkflowConstants;
import org.eclipse.emf.eef.codegen.flow.impl.AddDependency;
import org.eclipse.emf.eef.codegen.flow.impl.GenerateEEFCode;
import org.eclipse.emf.eef.codegen.flow.impl.GenerateEEFModels;
import org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFEditCode;
import org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFEditorCode;
import org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFModelCode;
import org.eclipse.emf.eef.codegen.flow.impl.InitializeGenModel;
import org.eclipse.emf.eef.codegen.flow.impl.MergePluginXML;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFEditorInitializer extends AbstractPropertiesInitializer {

	private static final String WORKFLOW_NAME = "Generate EEF Editor";
	private static final String GENERATING_THE_GENMODEL = "Generating the GenModel";
	private static final String GENERATE_EMF_MODEL_CODE = "Generate EMF Model Code";
	private static final String GENERATE_EMF_EDIT_CODE = "Generate EMF Edit Code";
	private static final String GENERATE_EMF_EDITOR_CODE = "Generate EMF Editor Code";
	private static final String GENERATE_EEF_MODELS = "Generate EEF models";
	private static final String ADDING_EEF_RUNTIME_DEPENDENCY = "Adding EEF Runtime dependency";
	private static final String GENERATE_EEF_CODE = "Generate EEF code";
	private static final String MERGING_GENERATED_PLUGIN_XML_FILES = "Merging generated plugin.xml files";
	
	private ResourceSet resourceSet;
	private IFile modelFile;

	public EEFEditorInitializer(IFile selectedFile) {
		this.modelFile = selectedFile;
	}

	/**
	 * {@inheritDoc]
	 * @throws Exception 
	 * @see org.eclipse.emf.eef.codegen.core.initializer.IPropertiesInitializer#initialize(org.eclipse.emf.common.util.URI, org.eclipse.core.resources.IContainer)
	 */
	public void initialize(URI modelURI, IContainer targetFolder) throws Exception  {
		resourceSet = new ResourceSetImpl();
		registerResourceFactories(resourceSet);
		registerPackages(resourceSet);
		EObject model = EMFHelper.load(modelURI, resourceSet);
		if (model instanceof EPackage) {
			Workflow workflow = new Workflow(WORKFLOW_NAME);
			workflow.setResourceSet(resourceSet);
			// Step 1 :  Generate GenModel
			InitializeGenModel initializeGenModelStep = new InitializeGenModel(GENERATING_THE_GENMODEL, modelFile, targetFolder) {

				/**
				 * {@inheritDoc]
				 * @see org.eclipse.emf.eef.codegen.flow.impl.InitializeGenModel#configureGenModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel)
				 */
				public void configureGenModel(GenModel genModel) {
					genModel.setModelDirectory(genModel.getModelDirectory() + "-gen");
					genModel.setEditDirectory(genModel.getEditDirectory() + "-gen");
				}
				
			};
			workflow.addStep(GENERATING_THE_GENMODEL, initializeGenModelStep);
			// Step 2 : Generate EMF Code
			GenerateEMFModelCode generateEMFModelCode = new GenerateEMFModelCode(GENERATE_EMF_MODEL_CODE, initializeGenModelStep.genmodel());
			workflow.addStep(GENERATE_EMF_MODEL_CODE, generateEMFModelCode);
			GenerateEMFEditCode generateEMFEditCode = new GenerateEMFEditCode(GENERATE_EMF_EDIT_CODE, initializeGenModelStep.genmodel());
			workflow.addStep(GENERATE_EMF_EDIT_CODE, generateEMFEditCode);
			GenerateEMFEditorCode generateEMFEditorCode = new GenerateEMFEditorCode(GENERATE_EMF_EDITOR_CODE, initializeGenModelStep.genmodel());
			workflow.addStep(GENERATE_EMF_EDITOR_CODE, generateEMFEditorCode);
			// Step 3 : Generate EEF model
			workflow.getContext().add(WorkflowConstants.ECLIPSE_MONITOR, new NullProgressMonitor());
			GenerateEEFModels generateEEFModels = new GenerateEEFModels(GENERATE_EEF_MODELS, modelURI, generateEMFEditCode.genProject(), initializeGenModelStep.getGenModelURI());
			workflow.addStep(GENERATE_EEF_MODELS, generateEEFModels);
			// Step  4 : Add EEF Runtime dependency 
			AddDependency addDependency = new AddDependency(ADDING_EEF_RUNTIME_DEPENDENCY, generateEMFEditCode.genProject(), EEFRuntimePlugin.PLUGIN_ID);
			workflow.addStep(ADDING_EEF_RUNTIME_DEPENDENCY, addDependency);
			GenerateEEFCode generateEEFCode = new GenerateEEFCode(GENERATE_EEF_CODE, generateEEFModels.getEEFGenModel());
			workflow.addStep(GENERATE_EEF_CODE, generateEEFCode);
			// Step 6 : Adding Extension Point
			// bundleHelper.addExtension("org.eclipse.emf.eef.runtime.PropertiesEditionPartProvider");
			MergePluginXML mergePluginXML = new MergePluginXML(MERGING_GENERATED_PLUGIN_XML_FILES, generateEMFEditCode.genProject());
			workflow.addStep(MERGING_GENERATED_PLUGIN_XML_FILES, mergePluginXML);
			workflow.execute();
		}
	}

}
