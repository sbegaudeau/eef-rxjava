/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ui.generators.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.MtlPackage;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;
import org.eclipse.emf.eef.codegen.core.launcher.AbstractPropertiesGeneratorLauncher;
import org.eclipse.emf.eef.codegen.core.services.PropertiesGeneratorLaunchersServices;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.osgi.framework.Bundle;

/**
 * Main entry point of the 'Codegen' generation module.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateAll {

	/**
	 * The output folder.
	 */
	private File targetFolder;

	/**
	 * The Generation PSM
	 */
	private EEFGenModel eefGenModel;
	
	/**
	 * A set containing the target folder for generation
	 */
	private Set<IContainer> generationTargets;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 */
	public GenerateAll(IContainer targetFolder, EEFGenModel eefGenModel) {
		this.targetFolder = targetFolder.getLocation().toFile();
		this.eefGenModel = eefGenModel;
		this.generationTargets = new HashSet<IContainer>();
		this.generationTargets.add(targetFolder);
	}

	/**
	 * @return the generationTargets
	 */
	public Set<IContainer> getGenerationTargets() {
		return generationTargets;
	}
	
	/**
	 * Launches the generation.
	 * 
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.exists()) {
			monitor.subTask("Creating target folder");
			targetFolder.mkdirs();
		}
		monitor.worked(1);
		EObject model;
		// fixed acceleo's overriding bug
		List<URI> allModulesURI = getAllmodulesURI();
		ResourceSet resourceSet = eefGenModel.eResource().getResourceSet();
		registerResourceFactories(resourceSet);
		registerPackages(resourceSet);
		loadAllModules(allModulesURI, resourceSet);

		for (GenEditionContext genEditionContext : eefGenModel.getEditionContexts()) {
			List<Object> arguments = new ArrayList<Object>();
			arguments.add(getBasePackage(genEditionContext));
			monitor.subTask("Generating simple components");
			final URI template1 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/components/SubPropertiesEditionComponent.emtl"));
			org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent gen1 = new org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent(
					genEditionContext.getPropertiesEditionContext(), targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template1;
				}
			};
			gen1.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);
			monitor.subTask("Generating composed components");
			model = gen1.getModel();
			if (model != null) {
				final URI template0 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/components/PropertiesEditionComponent.emtl"));
				org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent gen0 = new org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template0;
					}
				};
				gen0.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating dynamic composed components");
				final URI template14 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/components/DynamicPropertiesEditionComponent.emtl"));
				org.eclipse.emf.eef.codegen.components.DynamicPropertiesEditionComponent gen14 = new org.eclipse.emf.eef.codegen.components.DynamicPropertiesEditionComponent(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template14;
					}
				};
				gen14.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Policies provider");
				final URI template10 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPolicyProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider gen10 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template10;
					}
				};
				gen10.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Global Edition provider");
				final URI template11 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider gen11 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template11;
					}
				};
				gen11.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Edition provider");
				final URI template12 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/providers/PropertiesEditionProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider gen12 = new org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template12;
					}
				};
				gen12.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				if (genEditionContext.isDescriptorsGenericPropertiesViews()) {
					monitor.subTask("Generating plugin.xml configuration");
					final URI template6 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
							"/org/eclipse/emf/eef/codegen/plugin/plugin_xml.emtl"));
					org.eclipse.emf.eef.codegen.plugin.Plugin_xml gen6 = new org.eclipse.emf.eef.codegen.plugin.Plugin_xml(
							model, targetFolder, arguments) {
						protected URI createTemplateURI(String entry) {
							return template6;
						}
					};
					gen6.doGenerate(BasicMonitor.toMonitor(monitor));
					monitor.worked(1);
				}

				monitor.subTask("Generating 'SWT' parts");
				final URI template4 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/parts/PropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart gen4 = new org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template4;
					}
				};
				gen4.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);
				monitor.subTask("Generating 'Form' parts");
				final URI template2 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
						"/org/eclipse/emf/eef/codegen/parts/FormPropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart gen2 = new org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart(
						model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template2;
					}
				};
				gen2.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

			}
		}
		for (GenViewsRepository genViewsRepository : eefGenModel.getViewsRepositories()) {
			monitor.subTask("Generating parts interfaces");
			List<Object> argumentsEmpty = new ArrayList<Object>();
			List<Object> arguments2 = new ArrayList<Object>();
			arguments2.add(genViewsRepository.getBasePackage());
			final URI template3 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/parts/IPropertiesEditionPart.emtl"));
			org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart gen3 = new org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart(
					genViewsRepository.getViewsRepository(), targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template3;
				}
			};
			gen3.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);
			model = gen3.getModel();
			monitor.subTask("Generating views repository");

			final URI template3b = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/parts/ViewsRepository.emtl"));
			org.eclipse.emf.eef.codegen.parts.ViewsRepository gen3b = new org.eclipse.emf.eef.codegen.parts.ViewsRepository(
					model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template3b;
				}
			};
			gen3b.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating internationalization provider");
			final URI template8 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/providers/ContextMessages.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessages gen8 = new org.eclipse.emf.eef.codegen.providers.ContextMessages(
					model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template8;
				}
			};
			gen8.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating internationalization messages");
			final URI template9 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/providers/ContextMessagesProperties.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties gen9 = new org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties(
					model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template9;
				}
			};
			gen9.doGenerate(BasicMonitor.toMonitor(monitor));
			final URI template91 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/providers/ContextMessagesPropertiesFR.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessagesPropertiesFR gen91 = new org.eclipse.emf.eef.codegen.providers.ContextMessagesPropertiesFR(
					model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template91;
				}
			};
			gen91.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating Part provider");
			final URI template13 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
					"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPartProvider.emtl"));
			org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPartProvider gen13 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPartProvider(
					model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template13;
				}
			};
			gen13.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);
		}
		for (AbstractPropertiesGeneratorLauncher launcher : PropertiesGeneratorLaunchersServices
				.getInstance().getlaunchers()) {
			launcher.doGenerate(eefGenModel, targetFolder, monitor);
			if (!launcher.getTargetContainer().isEmpty())
				generationTargets.addAll(launcher.getTargetContainer());
		}
	}

	/**
	 * Finds the template in the plug-in. Returns the template plug-in URI.
	 * 
	 * @param bundleID
	 *            is the plug-in ID
	 * @param relativePath
	 *            is the relative path of the template in the plug-in
	 * @return the template URI
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private URI getTemplateURI(String bundleID, IPath relativePath) throws IOException {
		Bundle bundle = Platform.getBundle(bundleID);
		if (bundle == null) {
			// no need to go any further
			return URI.createPlatformResourceURI(new Path(bundleID).append(relativePath).toString(), false);
		}
		URL url = bundle.getEntry(relativePath.toString());
		if (url == null && relativePath.segmentCount() > 1) {
			Enumeration<URL> entries = bundle.findEntries("/", "*.emtl", true);
			if (entries != null) {
				String[] segmentsRelativePath = relativePath.segments();
				while (url == null && entries.hasMoreElements()) {
					URL entry = entries.nextElement();
					IPath path = new Path(entry.getPath());
					if (path.segmentCount() > relativePath.segmentCount()) {
						path = path.removeFirstSegments(path.segmentCount() - relativePath.segmentCount());
					}
					String[] segmentsPath = path.segments();
					boolean equals = segmentsPath.length == segmentsRelativePath.length;
					for (int i = 0; equals && i < segmentsPath.length; i++) {
						equals = segmentsPath[i].equals(segmentsRelativePath[i]);
					}
					if (equals) {
						url = bundle.getEntry(entry.getPath());
					}
				}
			}
		}
		URI result;
		if (url != null) {
			result = URI.createPlatformPluginURI(new Path(bundleID).append(new Path(url.getPath()))
					.toString(), false);
		} else {
			result = URI.createPlatformResourceURI(new Path(bundleID).append(relativePath).toString(), false);
		}
		return result;
	}

	public String getBasePackage(GenEditionContext genEditionContext) throws IOException {
		if (genEditionContext != null) {
			if (genEditionContext.getBasePackage() != null)
				return genEditionContext.getBasePackage();
		}
		return "";
	}

	public String getBasePackage(GenViewsRepository genViewsRepository) throws IOException {
		if (genViewsRepository != null) {
			if (genViewsRepository.getBasePackage() != null)
				return genViewsRepository.getBasePackage();
		}
		return "";
	}

	private List<Module> loadAllModules(List<URI> allModulesURI, ResourceSet resourceSet) throws IOException {
		List<Module> modules = new ArrayList<Module>();
		for (URI uri : allModulesURI) {
			modules.add(load(uri, resourceSet));
		}
		return modules;
	}

	private List<URI> getAllmodulesURI() throws IOException {
		ArrayList<URI> list = new ArrayList<URI>();
		// main templates
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/components/SubPropertiesEditionComponent.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/components/PropertiesEditionComponent.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/components/DynamicPropertiesEditionComponent.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/plugin/plugin_xml.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/plugin/GMF_Plugin_xml.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/properties/PropertySection.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/parts/PropertiesEditionPart.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/parts/FormPropertiesEditionPart.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/parts/IPropertiesEditionPart.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/parts/ViewsRepository.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/ContextMessages.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/ContextMessagesProperties.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/ContextMessagesPropertiesFR.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPartProvider.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPolicyProvider.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionProvider.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/providers/PropertiesEditionProvider.emtl")));
		// load common services
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/services/common.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/services/filters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/services/naming.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/services/typeUtils.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/services/viewCommon.emtl")));
		
		// load widgets services
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/api/widgetControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/checkbox/checkboxControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/combo/comboControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/custom/customControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/emfcomboviewer/emfcomboviewerControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/eobjectflatcomboviewer/eobjectflatcomboviewerControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/multivaluededitor/multivaluededitorControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/radio/radioControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/referencetable/referencetableControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/tablecomposition/tablecompositionControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/text/textControl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/textarea/textareaControl.emtl")));

		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/api/widgetSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/checkbox/checkboxSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/combo/comboSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/custom/customSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/emfcomboviewer/emfcomboviewerSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/eobjectflatcomboviewer/eobjectflatcomboviewerSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/multivaluededitor/multivaluededitorSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/radio/radioSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/referencetable/referencetableSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/tablecomposition/tablecompositionSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/text/textSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/textarea/textareaSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/group/groupSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/hbox/hboxSWTImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/vbox/vboxSWTImpl.emtl")));

		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/api/widgetFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/checkbox/checkboxFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/combo/comboFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/custom/customFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/emfcomboviewer/emfcomboviewerFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/eobjectflatcomboviewer/eobjectflatcomboviewerFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/multivaluededitor/multivaluededitorFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/radio/radioFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/referencetable/referencetableFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/tablecomposition/tablecompositionFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/text/textFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/textarea/textareaFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/group/groupFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/hbox/hboxFormImpl.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/vbox/vboxFormImpl.emtl")));

		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/api/widgetGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/checkbox/checkboxGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/combo/comboGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/emfcomboviewer/emfcomboviewerGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/eobjectflatcomboviewer/eobjectflatcomboviewerGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/multivaluededitor/multivaluededitorGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/radio/radioGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/referencetable/referencetableGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/tablecomposition/tablecompositionGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/text/textGettersSetters.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.codegen", new Path(
				"/org/eclipse/emf/eef/codegen/widgets/impl/textarea/textareaGettersSetters.emtl")));
		
		// it becomes urgent to solve the problem

		list.add(getTemplateURI("org.eclipse.emf.eef.tests.codegen", new Path(
			"/org/eclipse/emf/eef/tests/codegen/main/cases/ComponentTests.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.tests.codegen", new Path(
			"/org/eclipse/emf/eef/tests/codegen/services/common/testsNaming.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.tests.codegen", new Path(
			"/org/eclipse/emf/eef/tests/codegen/services/widgets/api/widgetTest.emtl")));
		list.add(getTemplateURI("org.eclipse.emf.eef.tests.codegen", new Path(
			"/org/eclipse/emf/eef/tests/codegen/services/widgets/impl/text/textTest.emtl")));

		return list;
	}

	/**
	 * Loads a model from an {@link org.eclipse.emf.common.util.URI URI} in a given {@link ResourceSet}.
	 * <p>
	 * This will return the first root of the loaded model, other roots can be accessed via the resource's
	 * content.
	 * </p>
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The model loaded from the URI.
	 * @throws IOException
	 *             If the given file does not exist.
	 * @generated
	 */
	private Module load(URI modelURI, ResourceSet resourceSet) throws IOException {
		final Resource modelResource = createResource(modelURI, resourceSet);
		final Map<String, String> options = new HashMap<String, String>();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty("file.encoding"));
		modelResource.load(options);
		if (modelResource.getContents().size() > 0) {
			return (Module)modelResource.getContents().get(0);
		} else {
			// FIXME
			throw new RuntimeException();
		}
	}

	/**
	 * This will create a {@link Resource} given the model extension it is intended for and a ResourceSet.
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The {@link Resource} given the model extension it is intended for.
	 * @generated
	 */
	private Resource createResource(URI modelURI, ResourceSet resourceSet) {
		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}
		final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		final Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
					resourceFactory);
		} else {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
					new XMIResourceFactoryImpl());
		}
		return resourceSet.createResource(modelURI);
	}

	/**
	 * Updates the registry used for looking up a package based namespace, in the resource set.
	 * 
	 * @param resourceSet
	 *            is the resource set
	 * @generated
	 */
	private void registerPackages(ResourceSet resourceSet) {
		resourceSet.getPackageRegistry().put(
				org.eclipse.emf.eef.components.ComponentsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.components.ComponentsPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.emf.eef.views.ViewsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.views.ViewsPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				org.eclipse.emf.eef.toolkits.ToolkitsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.toolkits.ToolkitsPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.emf.eef.mapping.MappingPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.mapping.MappingPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				org.eclipse.emf.eef.mapping.navigation.NavigationPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.mapping.navigation.NavigationPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.emf.eef.EEFGen.EEFGenPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.EEFGen.EEFGenPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getNsURI(),
				org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				org.eclipse.ocl.expressions.ExpressionsPackage.eINSTANCE.getNsURI(),
				org.eclipse.ocl.expressions.ExpressionsPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(MtlPackage.eINSTANCE.getNsURI(), MtlPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore",
				getOCLStdLibPackage());
	}

	/**
	 * Updates the registry used for looking up resources factory in the given resource set.
	 * 
	 * @param resourceSet
	 *            The resource set that is to be updated.
	 * @generated
	 */
	private void registerResourceFactories(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
				new EcoreResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emtl",
				new org.eclipse.acceleo.model.mtl.resource.EMtlResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	/**
	 * Returns the package containing the OCL standard library.
	 * 
	 * @return The package containing the OCL standard library.
	 * @generated
	 */
	private EPackage getOCLStdLibPackage() {
		EcoreEnvironmentFactory factory = new EcoreEnvironmentFactory();
		EcoreEnvironment environment = (EcoreEnvironment)factory.createEnvironment();
		return (EPackage)EcoreUtil.getRootContainer(environment.getOCLStandardLibrary().getBag());
	}
}
