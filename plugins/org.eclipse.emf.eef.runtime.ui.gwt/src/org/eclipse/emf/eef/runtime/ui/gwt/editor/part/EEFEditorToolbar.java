/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.editor.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author glefur
 *
 */
public class EEFEditorToolbar extends FlowPanel {

	public final static int CREATE = 0;
	public final static int DELETE = 1;
	public final static int VALIDATE = 2;
	public final static int SAVE = 3;
	public final static int UNDO = 4;
	public final static int REDO = 5;
	public final static int CUT = 6;
	public final static int COPY = 7;
	public final static int PASTE = 8;
	public final static int UP = 9;
	public final static int DOWN = 10;
	public final static int NAVIGATE = 11;

	private Collection<ToolbarListener> listeners;
	private Map<Integer, Button> buttons;
	
	/**
	 * 
	 */
	public EEFEditorToolbar() {
		super();
		
		listeners = new ArrayList<EEFEditorToolbar.ToolbarListener>();
		buttons = new HashMap<Integer, Button>();
		
		this.setStyleName("ToolBar", true);

		addButton(CREATE, "Create...");
		addButton(DELETE, "Delete");
		addButton(VALIDATE, "Validate");
		addButton(SAVE, "Save");
		addButton(UNDO, "Undo");
		addButton(REDO, "Redo");
		addButton(CUT, "Cut");
		addButton(COPY, "Copy");
		addButton(PASTE, "Paste");
		addButton(UP, "Up");
		addButton(DOWN, "Down");
		addButton(NAVIGATE, "Navigate");


	}


	protected void addButton(final int id, final String buttonText) {
		final Button button = new Button();
		button.setText(buttonText);
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ToolbarEvent tbEvent = new ToolbarEvent();
				tbEvent.kind = id;
				fireToolbarEvent(tbEvent);
			}
		});
		button.setStyleName("ToolBarButtonLeftMargin");

		this.add(button);
		buttons.put(id, button);
	}
	
	
	/**
	 * Add a toolbar listener.
	 * @param listener 
	 */
	public void addListener(final ToolbarListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Remove a toolbar listener.
	 * @param listener
	 */
	public void removeListener(final ToolbarListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * @param id
	 */
	public void setEnabledButton(boolean state ,int... id) {
		for (int i : id) {
			if (buttons.get(i) != null) {
				buttons.get(i).setEnabled(false);
			}
		}
	}
	
	
	/**
	 * Fire all the toolbar listeners for an event.
	 * @param event the event to propagate.
	 */
	private void fireToolbarEvent(final ToolbarEvent event) {
		for (ToolbarListener listener : listeners) {
			listener.fireToolbarEvent(event);
		}
	}

	/**
	 * Interface for toolbar listeners
	 * @author glefur
	 *
	 */
	public interface ToolbarListener {
		
		public void fireToolbarEvent(ToolbarEvent event);
		
	}
	
	/**
	 * Event throw by the toolbar.
	 * @author glefur
	 *
	 */
	public class ToolbarEvent {
			
		public int kind;
		
	}
	
}
