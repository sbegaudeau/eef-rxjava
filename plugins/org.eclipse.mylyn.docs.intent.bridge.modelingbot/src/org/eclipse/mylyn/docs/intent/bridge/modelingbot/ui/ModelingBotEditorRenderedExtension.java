/*******************************************************************************
 * Copyright (c) 2010, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.bridge.modelingbot.ui;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.eef.ModelingBotRuntimeModule;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.Serializer;

public class ModelingBotEditorRenderedExtension implements IEditorRendererExtension {

	private Serializer serializer;

	private Injector injector;

	private IGrammarAccess grammarAccess;

	public ModelingBotEditorRenderedExtension() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension#isRendererFor(org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference)
	 */
	public boolean isRendererFor(ExternalContentReference externalContentReference) {
		return externalContentReference.getExternalContent() instanceof Scenario;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension#openEditor(org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference)
	 */
	public boolean openEditor(ExternalContentReference externalContentReference) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension#getAdditionalTransfers()
	 */
	public Collection<Transfer> getAdditionalTransfers() {
		return new LinkedHashSet<Transfer>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension#getEObjectsFromDropTargetEvent(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public Collection<? extends EObject> getEObjectsFromDropTargetEvent(DropTargetEvent event) {
		return new LinkedHashSet<EObject>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.renderers.IEditorRendererExtension#getImage(org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference)
	 */
	public Image getImage(ExternalContentReference externalContentReference) {
		Image image = null;
		if (externalContentReference.getExternalContent() != null && getModelingBotSerializer() != null) {
			// Step 1: get the xtext serializer to get the text to display
			String text = getModelingBotSerializer().serialize(externalContentReference.getExternalContent());
			// Step 2: initialize image according to text length
			Display display = Display.getDefault();
			int fontHeight = new GC(new Image(display, 1, 1)).getFontMetrics().getHeight();
			int imageHeight = fontHeight * ((text.split("\n").length) + 1);
			image = new Image(display, 500, imageHeight);
			GC gc = new GC(image);

			// Step 3: Render icon
			int iconWidth = 5;
			IItemLabelProvider labeProvider = (IItemLabelProvider)new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE).adapt(
					externalContentReference.getExternalContent(), IItemLabelProvider.class);
			if (labeProvider != null) {
				Object iconURL = labeProvider.getImage(externalContentReference.getExternalContent());
				Image icon = ExtendedImageRegistry.getInstance().getImage(iconURL);

				if (icon != null) {
					gc.drawImage(icon, 0, 5);
					iconWidth += icon.getImageData().width + 2;
				}
			}

			// Step 4: Render text
			gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
			gc.drawText(text, iconWidth, 5, true);
			gc.dispose();
		}
		return image;
	}

	private Injector getInjector() {
		if (this.injector == null) {
			this.injector = Guice.createInjector(new ModelingBotRuntimeModule());
		}
		return this.injector;
	}

	private Serializer getModelingBotSerializer() {
		if (this.serializer == null) {
			this.serializer = getInjector().getInstance(Serializer.class);
		}
		return this.serializer;
	}

}
