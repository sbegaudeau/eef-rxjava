/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A viewer composed of button to handles EEnum as Radio. It will display a radio for each element of the
 * enum.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class RadioViewer extends Composite {

	/**
	 * the map of buttons used.
	 */
	private Map<Object, Button> buttons;

	public RadioViewer(Composite parent, int style) {
		super(parent, style);
		buttons = new HashMap<Object, Button>();
		this.setLayout(new GridLayout());
	}

	private void createButton(Object value) {
		Button b = new Button(this, SWT.RADIO);
		if (value instanceof Enumerator) {
			b.setText(((Enumerator)value).getLiteral());
		}
		GridData data = new GridData(GridData.FILL_BOTH);
		b.setLayoutData(data);
		buttons.put(value, b);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		for (Button button : buttons.values()) {
			button.setEnabled(enabled);
		}
		super.setEnabled(enabled);
	}

	public void setSelection(Object newValue) {
		for (Object value : buttons.keySet()) {
			buttons.get(value).setSelection(false);
			if (value instanceof Enumerator && newValue instanceof Enumerator) {
				if (((Enumerator)value).getValue() == ((Enumerator)newValue).getValue()) {
					buttons.get(value).setSelection(true);
				}
			}
		}

	}

	public Object getSelection() {
		for (Object value : buttons.keySet()) {
			if (buttons.get(value).getSelection())
				return value;
		}
		return null;
	}

	public void setInput(Object input) {
		if (input instanceof Collection) {
			for (Object value : (Collection)input) {
				createButton(value);
			}
		}
		// refresh Layout
		GridLayout l = (GridLayout)this.getLayout();
		l.numColumns = buttons.size() == 0 ? 1 : buttons.size();
		this.setLayout(l);
		layout();
	}

}
