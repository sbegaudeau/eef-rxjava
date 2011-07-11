/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.dialog;

import java.util.List;

import org.eclipse.emf.eef.runtime.ui.gwt.editor.util.EventProcess;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author glefur
 * 
 */
public class CreateObjectDialog extends DialogBox {

	private List<?> input;
	private ListBox listBox;
	private Object result;

	/**
	 * 
	 */
	public CreateObjectDialog() {
		super();
		this.setText("Create Object");
		listBox = new ListBox();
		listBox.setVisibleItemCount(1);
		final Button okButton = new Button("OK");
		final Button cancelButton = new Button("Cancel");
		VerticalPanel verticalPanel = new VerticalPanel();
		Grid grid = new Grid();
		grid.setWidth("50em");
		grid.resize(2, 2);
		grid.getColumnFormatter().setWidth(0, "15%");
		grid.getColumnFormatter().setWidth(1, "85%");
		Label classLabel = new Label();
		classLabel.setText("Class");
		grid.setWidget(0, 0, classLabel);
		grid.setWidget(0, 1, listBox);
		verticalPanel.add(grid);
		// verticalPanel.add(okButton);
		grid.setWidget(1, 0, okButton);
		grid.setWidget(1, 1, cancelButton);
		this.setWidget(verticalPanel);
		open();
		okButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				hide();
				result = processOk(input.get(listBox.getSelectedIndex()));
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				processCancel();
			}
		});
	}

	/**
	 * @param input
	 */
	public void setInput(List<?> input) {
		for (Object object : input) {
			listBox.addItem(getString(object));
		}
	}

	/**
	 * open the dialog
	 */
	public void open() {
		this.show();
		listBox.setFocus(true);
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Ok button pressed.
	 * 
	 * @return
	 */
	protected Object processOk(Object selection) {
		return null;
	}

	/**
	 * Cancel button pressed.
	 */
	protected void processCancel() {

	}

	/**
	 * @param object
	 * @return
	 */
	public String getString(Object object) {
		return object.toString();
	}

}
