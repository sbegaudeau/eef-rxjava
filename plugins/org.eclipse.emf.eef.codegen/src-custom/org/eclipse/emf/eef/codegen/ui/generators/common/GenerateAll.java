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
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.osgi.framework.Bundle;


/**
 * Main entry point of the 'Codegen' generation module.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateAll {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	/**
	 * The output folder.
	 */
	private File targetFolder;

	/**
	 * The other arguments.
	 */
	List<? extends Object> arguments;
	
	/**
	 * The Generation PSM
	 */
	private GenEditionContext context;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @param arguments
	 *            are the other arguments
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated NOT
	 */
	public GenerateAll(URI modelURI, File targetFolder, List<? extends Object> arguments, GenEditionContext context) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
		this.context = context;
	}

	/**
	 * Launches the generation.
	 * 
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated NOT
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.exists()) {
			monitor.subTask("Creating target folder");
			targetFolder.mkdirs();
		}
		monitor.worked(1);
		monitor.subTask("Generating simple components");
		final URI template1 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/components/SubPropertiesEditionComponent.emtl"));
		org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent gen1 = new org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent(context.getPropertiesEditionContext(), targetFolder, arguments) {
			protected URI createTemplateURI(String entry) {
				return template1;
			}
		};
		gen1.doGenerate();
			
		EObject model = gen1.getModel();
		
		monitor.worked(1);
		monitor.subTask("Generating composed components");

		if (model != null) {
			final URI template0 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/components/PropertiesEditionComponent.emtl"));
			org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent gen0 = new org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template0;
				}
			};
			gen0.doGenerate();
			monitor.worked(1);
			monitor.subTask("Generating parts interfaces");
			
			final URI template3 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/IPropertiesEditionPart.emtl"));
			org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart gen3 = new org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template3;
				}
			};
			gen3.doGenerate();
			monitor.worked(1);
			
			monitor.subTask("Generating views repository");
			
			final URI template3b = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/ViewsRepository.emtl"));
			org.eclipse.emf.eef.codegen.parts.ViewsRepository gen3b = new org.eclipse.emf.eef.codegen.parts.ViewsRepository(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template3b;
				}
			};
			gen3b.doGenerate();
			monitor.worked(1);
			
			if (context.isSwtViews()) {
				monitor.subTask("Generating 'SWT' parts");
				final URI template4 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/PropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart gen4 = new org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template4;
					}
				};
				gen4.doGenerate();
				monitor.worked(1);
			}
			
			if (context.isFormViews()) {
				monitor.subTask("Generating 'Form' parts");
				final URI template2 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/parts/FormPropertiesEditionPart.emtl"));
				org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart gen2 = new org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart(model, targetFolder, arguments) {
					protected URI createTemplateURI(String entry) {
						return template2;
					}
				};
				gen2.doGenerate();
				monitor.worked(1);
				
				if (context.isDescriptorsGenericPropertiesViews()) {
					monitor.subTask("Generating plugin.xml configuration");
					final URI template6 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/plugin/plugin_xml.emtl"));
					org.eclipse.emf.eef.codegen.plugin.Plugin_xml gen6 = new org.eclipse.emf.eef.codegen.plugin.Plugin_xml(model, targetFolder, arguments) {
						protected URI createTemplateURI(String entry) {
							return template6;
						}
					};
					gen6.doGenerate();
					monitor.worked(1);
				}
				
				if (context.isGmfPropertiesViews()) {
					monitor.subTask("Generating Properties Section");
					final URI template7 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/properties/PropertySection.emtl"));
					org.eclipse.emf.eef.codegen.properties.PropertySection gen7 = new org.eclipse.emf.eef.codegen.properties.PropertySection(model, targetFolder, arguments) {
						protected URI createTemplateURI(String entry) {
							return template7;
						}
					};
					gen7.doGenerate();
					monitor.worked(1);

					monitor.subTask("Generating plugin.xml for GMF configuration");
					final URI template5 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/plugin/GMF_Plugin_xml.emtl"));
					org.eclipse.emf.eef.codegen.plugin.GMF_Plugin_xml gen5 = new org.eclipse.emf.eef.codegen.plugin.GMF_Plugin_xml(model, targetFolder, arguments) {
						protected URI createTemplateURI(String entry) {
							return template5;
						}
					};
					gen5.doGenerate();
					monitor.worked(1);
				}
			}
			monitor.subTask("Generating internationalization provider");
			final URI template8 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/ContextMessages.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessages gen8 = new org.eclipse.emf.eef.codegen.providers.ContextMessages(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template8;
				}
			};
			gen8.doGenerate();
			monitor.worked(1);
			
			monitor.subTask("Generating internationalization messages");
			final URI template9 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/ContextMessagesProperties.emtl"));
			org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties gen9 = new org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template9;
				}
			};
			gen9.doGenerate();
			monitor.worked(1);
			
			monitor.subTask("Generating Policies provider");
			final URI template10 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionPolicyProvider.emtl"));
			org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider gen10 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template10;
				}
			};
			gen10.doGenerate();
			monitor.worked(1);
			
			monitor.subTask("Generating Global Edition provider");
			final URI template11 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PackagePropertiesEditionProvider.emtl"));
			org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider gen11 = new org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template11;
				}
			};
			gen11.doGenerate();
			monitor.worked(1);
			
			monitor.subTask("Generating Edition provider");
			final URI template12 = getTemplateURI("org.eclipse.emf.eef.codegen", new Path("/org/eclipse/emf/eef/codegen/providers/PropertiesEditionProvider.emtl"));
			org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider gen12 = new org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider(model, targetFolder, arguments) {
				protected URI createTemplateURI(String entry) {
					return template12;
				}
			};
			gen12.doGenerate();
			monitor.worked(1);
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
	 * @generated
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

}
