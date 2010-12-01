/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.notify;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.command.WizardEditingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class OpenTransactionalWizardOnDoubleClick implements IDoubleClickListener {

	private EditingDomain editingDomain;
	private AdapterFactory adapterFactory;

	/**
	 * @param editingDomain
	 */
	public OpenTransactionalWizardOnDoubleClick(EditingDomain editingDomain, AdapterFactory adapterFactory) {
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 */
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof StructuredSelection) {
			EObject eObject = null;
			Object firstElement = ((StructuredSelection)selection).getFirstElement();
			if (firstElement instanceof EObject) {
				eObject = (EObject)firstElement;
			} else if (firstElement instanceof IAdaptable) {
				if (((IAdaptable)firstElement).getAdapter(EObject.class) != null)
					eObject = (EObject)((IAdaptable)firstElement).getAdapter(EObject.class);
			}
			if (eObject != null) {
				DomainPropertiesEditionContext propertiesEditionContext = new DomainPropertiesEditionContext(null, null, editingDomain, adapterFactory, eObject);
				WizardEditingCommand wizardEditingCommand = new WizardEditingCommand(propertiesEditionContext);
				try {
					((TransactionalCommandStack)editingDomain.getCommandStack()).execute(wizardEditingCommand, specialOptions());
				} catch (InterruptedException e) {
					EEFRuntimePlugin.getDefault().logError("An error occured during an EEF editing session.", e);
				} catch (RollbackException e) {
					EEFRuntimePlugin.getDefault().logError("An error occured during an EEF editing session.", e);
				}
			}
		}
	}
	
    protected Map<Object, Object> specialOptions() {
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(Transaction.OPTION_NO_UNDO, Boolean.TRUE);
        options.put(Transaction.OPTION_NO_TRIGGERS, Boolean.TRUE);
        options.put(Transaction.OPTION_NO_NOTIFICATIONS, Boolean.TRUE);
        options.put(Transaction.OPTION_NO_VALIDATION, Boolean.TRUE);
        return options;
    }

}
