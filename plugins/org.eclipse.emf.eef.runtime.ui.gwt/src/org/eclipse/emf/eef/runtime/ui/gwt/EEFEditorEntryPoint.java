/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.gwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIService;
import org.eclipse.emf.ecore.resource.URIServiceAsync;
import org.eclipse.emf.ecore.resource.URIServiceCallback;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.EEFEditor;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author glefur
 * 
 */
public abstract class EEFEditorEntryPoint implements EntryPoint {

	private AdapterFactoryEditingDomain editingDomain;
	private List<Resource> originalResources;

	public AdapterFactoryEditingDomain initializeEditingDomain() {
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory();
		composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		configureItemProviderAdapterFactories(composedAdapterFactory);
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		final BasicCommandStack commandStack = new BasicCommandStack();
		return new AdapterFactoryEditingDomain(composedAdapterFactory, commandStack);		
	}
	
	public void configureResourceSet(final ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new ResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				return new BinaryResourceImpl(uri);
			}
		});

		final URIServiceAsync uriService = GWT.create(URIService.class);
		URIServiceCallback uriServiceCallback = new URIServiceCallback(uriService);
		resourceSet.getURIConverter().getURIHandlers().add(uriServiceCallback);

		originalResources = new ArrayList<Resource>();

		Resource listingResource = resourceSet.getResource(URI.createURI("datastore:/"), new Callback<Resource>() {
			public void onFailure(Throwable caught) {
				System.err.println("Failed");
				caught.printStackTrace();
			}

			public void onSuccess(Resource result) {
				EAnnotation eAnnotation = (EAnnotation) result.getContents().get(0);
				for (Map.Entry<String, String> entry : eAnnotation.getDetails()) {
					resourceSet.createResource(URI.createURI(entry.getKey()));
				}
				originalResources.clear();
				originalResources.addAll(resourceSet.getResources());
			}
		});
		resourceSet.getResources().remove(listingResource);

		registerPackages(resourceSet.getPackageRegistry());		
	}
	
	public void onModuleLoad() {
		editingDomain = initializeEditingDomain();
		configureResourceSet(editingDomain.getResourceSet());

		EEFEditor mainPanel = new EEFEditor(editingDomain, editingDomain.getAdapterFactory(), getApplicationTitle(), Unit.PX);
		mainPanel.setOriginalResources(originalResources);

		RootPanel.get("main").add(mainPanel);




	}

	protected abstract void registerPackages(EPackage.Registry ePackageRegistry);

	protected void configureItemProviderAdapterFactories(ComposedAdapterFactory adapterFactory) {
		// Do nothing.
	}

	protected abstract String getApplicationTitle();


	


}
