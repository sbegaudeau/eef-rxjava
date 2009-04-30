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
package org.eclipse.emf.eef.codegen.core.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.eef.codegen.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.codegen.components.SubPropertiesEditionComponent;
import org.eclipse.emf.eef.codegen.parts.FormPropertiesEditionPart;
import org.eclipse.emf.eef.codegen.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.codegen.parts.PropertiesEditionPart;
import org.eclipse.emf.eef.codegen.plugin.GMF_Plugin_xml;
import org.eclipse.emf.eef.codegen.properties.PropertySection;
import org.eclipse.emf.eef.codegen.providers.ContextMessages;
import org.eclipse.emf.eef.codegen.providers.ContextMessagesProperties;
import org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.codegen.providers.PackagePropertiesEditionProvider;
import org.eclipse.emf.eef.codegen.providers.PropertiesEditionProvider;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EMFPropertiesLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try {
	        if (args.length != 3) {
	          System.out.println("Arguments not valid : {model, folder, basePackage}.");
	        } else {
	          URI modelURI = URI.createFileURI(args[0]);
	          File folder = new File(args[1]);
	          List<Object> arguments = new ArrayList<Object>();
	          arguments.add(args[2]);
	          PropertiesEditionComponent propertiesEditionComponent = new PropertiesEditionComponent(modelURI, folder, arguments);
	          propertiesEditionComponent.doGenerate();
	          SubPropertiesEditionComponent subPropertiesEditionComponent = new SubPropertiesEditionComponent(modelURI, folder, arguments);
	          subPropertiesEditionComponent.doGenerate();
	          IPropertiesEditionPart ipropertiesEditionPart = new IPropertiesEditionPart(modelURI, folder, arguments);
	          ipropertiesEditionPart.doGenerate();
	          PropertiesEditionPart propertiesEditionPart = new PropertiesEditionPart(modelURI, folder, arguments);
	          propertiesEditionPart.doGenerate();
	          FormPropertiesEditionPart formPropertiesEditionPart = new FormPropertiesEditionPart(modelURI, folder, arguments);
	          formPropertiesEditionPart.doGenerate();
	          ContextMessages contextMessages = new ContextMessages(modelURI, folder, arguments);
	          contextMessages.doGenerate();
	          ContextMessagesProperties contextMessagesProperties = new ContextMessagesProperties(modelURI, folder, arguments);
	          contextMessagesProperties.doGenerate();
	          PackagePropertiesEditionProvider packagePropertiesEditionProvider = new PackagePropertiesEditionProvider(modelURI, folder, arguments);
	          packagePropertiesEditionProvider.doGenerate();
	          PackagePropertiesEditionPolicyProvider packagePropertiesEditionPolicyProvider = new PackagePropertiesEditionPolicyProvider(modelURI, folder, arguments);
	          packagePropertiesEditionPolicyProvider.doGenerate();
	          PropertiesEditionProvider propertiesEditionProvider = new PropertiesEditionProvider(modelURI, folder, arguments);
	          propertiesEditionProvider.doGenerate();
	          GMF_Plugin_xml plugin_xml = new GMF_Plugin_xml(modelURI, folder, arguments);
	          plugin_xml.doGenerate();
	          PropertySection propertiesSection = new PropertySection(modelURI, folder, arguments);
	          propertiesSection.doGenerate();
	        }
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	}

}
