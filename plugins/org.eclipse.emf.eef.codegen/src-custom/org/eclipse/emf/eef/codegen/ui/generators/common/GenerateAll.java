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
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;
import org.eclipse.emf.eef.codegen.core.launcher.AbstractPropertiesGeneratorLauncher;
import org.eclipse.emf.eef.codegen.core.services.PropertiesGeneratorLaunchersServices;
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
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 */
	public GenerateAll(File targetFolder, EEFGenModel eefGenModel) {
		this.targetFolder = targetFolder;
		this.eefGenModel = eefGenModel;
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
		for (GenEditionContext genEditionContext : eefGenModel.getEditionContexts()) {
			List arguments = new ArrayList<Object>();
			arguments.add(getBasePackage(genEditionContext));
			monitor.subTask("Generating simple components");
			final URI template1 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/components/SubPropertiesEditionComponent.emtl"));
			org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent gen1 = new org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent(genEditionContext.getPropertiesEditionContext(), targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template1;
				}
			};
			gen1.doGenerate(BasicMonitor.toMonitor(monitor));

			model = gen1.getModel();

			monitor.worked(1);
			monitor.subTask("Generating composed components");

			if (model != null) {
				final URI template0 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/components/PropertiesEditionComponent.emtl"));
				org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent gen0 = new org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template0;
					}
				};
				gen0.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating dynamic composed components");
				final URI template14 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/components/DynamicPropertiesEditionComponent.emtl"));
				org.eclipse.emf.eef.codegen.components.DynamicPropertiesEditionComponent gen14 = new org.eclipse.emf.eef.codegen.components.DynamicPropertiesEditionComponent(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template14;
					}
				};
				gen14.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Policies provider");
				final URI template10 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPolicyProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider gen10 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template10;
					}
				};
				gen10.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Global Edition provider");
				final URI template11 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider gen11 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template11;
					}
				};
				gen11.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				monitor.subTask("Generating Edition provider");
				final URI template12 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PropertiesEditionProvider.emtl"));
				org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider gen12 = new org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template12;
					}
				};
				gen12.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);

				if (genEditionContext.isDescriptorsGenericPropertiesViews()) {
					monitor.subTask("Generating plugin.xml configuration");
					final URI template6 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/plugin/plugin_xml.emtl"));
					org.eclipse.emf.eef.codegen.plugin.Plugin_xml gen6 = new org.eclipse.emf.eef.codegen.plugin.Plugin_xml(model, targetFolder, arguments) {
						protected URI createTemplateURI(String entry) {
							return template6;
						}
					};
					gen6.doGenerate(BasicMonitor.toMonitor(monitor));
					monitor.worked(1);
				}

				monitor.subTask("Generating 'SWT' parts");
				final URI template4 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/PropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart gen4 = new org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template4;
					}
				};
				gen4.doGenerate(BasicMonitor.toMonitor(monitor));
				monitor.worked(1);
				monitor.subTask("Generating 'Form' parts");
				final URI template2 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/FormPropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart gen2 = new org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart(model, targetFolder, arguments) {
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
			List argumentsEmpty = new ArrayList();
			List arguments2 = new ArrayList();
			arguments2.add(genViewsRepository.getBasePackage());
			final URI template3 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/IPropertiesEditionPart.emtl"));
			org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart gen3 = new org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart(genViewsRepository.getViewsRepository(), targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template3;
				}
			};
			gen3.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);
			model = gen3.getModel();
			monitor.subTask("Generating views repository");

			final URI template3b = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/ViewsRepository.emtl"));
			org.eclipse.emf.eef.codegen.parts.ViewsRepository gen3b = new org.eclipse.emf.eef.codegen.parts.ViewsRepository(model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template3b;
				}
			};
			gen3b.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating internationalization provider");
			final URI template8 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/ContextMessages.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessages gen8 = new org.eclipse.emf.eef.codegen.providers.ContextMessages(model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template8;
				}
			};
			gen8.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating internationalization messages");
			final URI template9 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/ContextMessagesProperties.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties gen9 = new org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties(model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template9;
				}
			};
			gen9.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);

			monitor.subTask("Generating Part provider");
			final URI template13 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPartProvider.emtl"));
			org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPartProvider gen13 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPartProvider(model, targetFolder, argumentsEmpty) {
				protected URI createTemplateURI(String entry) {
					return template13;
				}
			};
			gen13.doGenerate(BasicMonitor.toMonitor(monitor));
			monitor.worked(1);
		}
		for (AbstractPropertiesGeneratorLauncher launcher : PropertiesGeneratorLaunchersServices.getInstance().getlaunchers()) {
			launcher.doGenerate(eefGenModel, targetFolder, monitor);
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
			result = URI.createPlatformPluginURI(new Path(bundleID).append(new Path(url.getPath())).toString(), false);
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
}
