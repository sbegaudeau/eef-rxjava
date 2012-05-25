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
package org.eclipse.emf.eef.runtime.ui.gwt.dialog;

import org.eclipse.emf.eef.runtime.ui.gwt.editor.util.EventProcess;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author glefur
 *
 */
public class CreateResourceDialog extends DialogBox {

	private TextBox uriText;
	private EventProcess result;

	/**
	 * 
	 */
	public CreateResourceDialog() {
		super();
		this.setText("Create Resource");
		final Button okButton = new Button("OK");
		final Button cancelButton = new Button("Cancel");
		VerticalPanel verticalPanel = new VerticalPanel();
		Grid grid = new Grid();
		grid.setWidth("50em");
		grid.resize(3, 2);
		grid.getColumnFormatter().setWidth(0, "15%");
		grid.getColumnFormatter().setWidth(1, "85%");
		Label uriLabel = new Label();
		uriLabel.setText("URI");
		uriText = new TextBox();
		uriText.setWidth("90%");
		uriText.setValue(defaultValue());
		uriText.selectAll();
		final Label message = new Label();
		uriText.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String value = event.getValue();
				if (valideValue(value)) {
					message.setText("");
					okButton.setEnabled(true);
				} else {
					message.setText("Invalid value.");
					okButton.setEnabled(false);					
				}
			}
		});
		grid.setWidget(0, 0, uriLabel);
		grid.setWidget(0, 1, uriText);
		verticalPanel.add(grid);
		grid.setWidget(1, 1, message);
		grid.setWidget(2, 0, okButton);
		grid.setWidget(2, 1, cancelButton);
		this.setWidget(verticalPanel);
		okButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				hide();
				result = processOk(uriText.getValue());
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				processCancel();
			}
		});
		open();
		// dialogBox.setWidth("50em");
	}
	
	/**
	 * @return the processOk
	 */
	public EventProcess getResult() {
		return result;
	}



	protected EventProcess processOk(Object value) {
		return new EventProcess(null, null);
	}

	protected void processCancel() {
		
	}

	protected String defaultValue() {
		return "";
	}
	
	protected boolean valideValue(Object value) {
		return true;
	}
	
	public void open() {
		show();
		uriText.setFocus(true);
	}
	

}
