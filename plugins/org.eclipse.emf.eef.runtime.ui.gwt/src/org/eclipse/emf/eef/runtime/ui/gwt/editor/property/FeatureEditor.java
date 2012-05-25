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
package org.eclipse.emf.eef.runtime.ui.gwt.editor.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public abstract class FeatureEditor extends Composite {
	protected Object object;
	protected boolean isSortChoices;
	protected List<?> values;
	protected List<?> choiceOfValues;
	protected ListBox valueBox;
	protected ListBox choiceBox;
	protected EDataType eDataType;
	protected TextBox textBox;

	protected FeatureEditor(Object object, boolean isSortChoices, final EDataType eDataType) {
		this.object = object;
		this.isSortChoices = isSortChoices;
		this.eDataType = eDataType;

		Grid grid = new Grid();
		grid.resize(1, 3);

		grid.getColumnFormatter().setWidth(0, "40%");
		grid.getColumnFormatter().setWidth(1, "20%");
		grid.getColumnFormatter().setWidth(2, "40%");

		valueBox = new ListBox(true);
		valueBox.setVisibleItemCount(4);
		valueBox.setWidth("100%");
		grid.setWidget(0, 0, valueBox);

		Grid buttonGrid = new Grid();
		buttonGrid.resize(2, 2);
		Button upButton = new Button("Up ^");
		buttonGrid.setWidget(0, 0, upButton);
		Button downButton = new Button("Down v");
		buttonGrid.setWidget(1, 0, downButton);
		Button addButton = new Button("< Add");
		buttonGrid.setWidget(0, 1, addButton);
		Button removeButton = new Button("Remove >");
		buttonGrid.setWidget(1, 1, removeButton);
		grid.setWidget(0, 1, buttonGrid);

		if (eDataType != null) {
			textBox = new TextBox();
			textBox.setWidth("100%");
			grid.setWidget(0, 2, textBox);

			/*
			 * textBox.addValueChangeHandler (new
			 * ValueChangeHandler<String>() { public void
			 * onValueChange(ValueChangeEvent<String> event) { List<Object>
			 * result = isUnique() ? new UniqueEList<Object>(values) : new
			 * ArrayList<Object>(values); try { Object value =
			 * EcoreUtil.createFromString(eDataType, event.getValue());
			 * result.add(value); setValue(result); } catch
			 * (RuntimeException exception) { // Ignore for now } } });
			 */
		} else {
			choiceBox = new ListBox(true);
			choiceBox.setVisibleItemCount(4);
			choiceBox.setWidth("100%");
			grid.setWidget(0, 2, choiceBox);
		}

		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				List<Object> result = isUnique() ? new UniqueEList<Object>(values) : new ArrayList<Object>(values);
				if (eDataType != null) {
					try {
						Object value = EcoreUtil.createFromString(eDataType, textBox.getValue());
						result.add(value);
					} catch (RuntimeException exception) {
						// Ignore for now
					}
				} else {
					for (int i = 0, size = choiceBox.getItemCount(); i < size; ++i) {
						if (choiceBox.isItemSelected(i)) {
							result.add(choiceOfValues.get(i));
						}
					}
				}
				setValue(result);
			}
		});

		removeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				List<Object> result = isUnique() ? new UniqueEList<Object>(values) : new ArrayList<Object>(values);
				for (int i = 0, size = valueBox.getItemCount(); i < size; ++i) {
					if (valueBox.isItemSelected(i)) {
						result.remove(values.get(i));
					}
				}
				setValue(result);
			}
		});
		upButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EList<Object> result = new BasicEList<Object>(values);
				for (int i = 0, size = valueBox.getItemCount(); i < size; ++i) {
					if (valueBox.isItemSelected(i)) {
						if (i != 0) {
							result.move(i, i - 1);
						}
					}
				}
				setValue(result);
			}
		});
		downButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EList<Object> result = new BasicEList<Object>(values);
				for (int i = 0, size = valueBox.getItemCount(); i < size; ++i) {
					if (valueBox.isItemSelected(i)) {
						if (i + 1 < size) {
							result.move(i, i + 1);
						}
					}
				}
				setValue(result);
			}
		});
		initWidget(grid);
	}

	protected void hook(ListBox listBox, List<?> values) {
		// Do nothing.

	}

	public void update() {
		IItemLabelProvider labelProvider = getLabelProvider();
		List<?> oldValues = values;
		values = new ArrayList<Object>(getValues());

		List<Object> oldValueSelection = new ArrayList<Object>();
		int valueBoxItemCount = valueBox.getItemCount();
		if (valueBoxItemCount != 0) {
			for (int i = 0; i < valueBoxItemCount; ++i) {
				if (valueBox.isItemSelected(i)) {
					oldValueSelection.add(oldValues.get(i));
				}
			}
			valueBox.clear();
		}

		for (Object value : values) {
			valueBox.addItem(labelProvider.getText(value));
			if (oldValueSelection.contains(value) || oldValues != null && !oldValues.contains(value)) {
				valueBox.setItemSelected(valueBox.getItemCount() - 1, true);
			}
		}

		hook(valueBox, values);

		if (eDataType != null) {
			textBox.setValue("");
		} else {
			List<Object> oldChoiceSelection = new ArrayList<Object>();
			int choiceBoxItemCount = choiceBox.getItemCount();
			if (choiceBoxItemCount != 0) {
				for (int i = 0; i < choiceBoxItemCount; ++i) {
					if (choiceBox.isItemSelected(i)) {
						oldChoiceSelection.add(choiceOfValues.get(i));
					}
				}
				choiceBox.clear();
			}

			Collection<?> basicChoices = getChoiceOfValues();
			if (basicChoices == null) {
				choiceOfValues = null;
			} else {
				choiceOfValues = new ArrayList<Object>(basicChoices);
				if (isSortChoices) {
					createItems(choiceOfValues, labelProvider, null, true);
				}
				for (Object value : choiceOfValues) {
					choiceBox.addItem(labelProvider.getText(value));
					if (oldChoiceSelection.contains(value) || oldValues != null && oldValues.contains(value) && !values.contains(value)) {
						choiceBox.setItemSelected(choiceBox.getItemCount() - 1, true);
					}
				}
				hook(choiceBox, choiceOfValues);
			}
		}
	}

	public static <T> String[] createItems(List<T> list, IItemLabelProvider labelProvider, String filter, boolean sorted) {
		String[] result;

		if (filter != null && filter.length() > 0) {
			sorted = true;
		}

		// If there are objects to populate...
		//
		if (list != null && list.size() > 0) {
			if (sorted) {
				List<T> unsortedList = new ArrayList<T>(list.size());
				if (filter != null && filter.length() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (select(filter, labelProvider.getText(list.get(i)))) {
							unsortedList.add(list.get(i));
						}
					}
				} else {
					unsortedList.addAll(list);
				}
				list.clear();

				StringPositionPair[] pairs = new StringPositionPair[unsortedList.size()];

				for (int i = 0, size = unsortedList.size(); i < size; ++i) {
					Object object = unsortedList.get(i);
					pairs[i] = new StringPositionPair(labelProvider.getText(object), i);
				}

				Arrays.sort(pairs);

				// Create a new array.
				//
				result = new String[unsortedList.size()];
				// Fill in the result array with labels and re-populate the
				// original list in order.
				//
				for (int i = 0, size = unsortedList.size(); i < size; ++i) {
					result[i] = pairs[i].key;
					list.add(unsortedList.get(pairs[i].position));
				}
			} else {
				// Create a new array.
				//
				result = new String[list.size()];
				// Fill in the array with labels.
				//
				for (int i = 0, size = list.size(); i < size; ++i) {
					Object object = list.get(i);
					result[i] = labelProvider.getText(object);
				}
			}
		} else {
			result = new String[] { "" };
		}

		return result;
	}

	
	protected abstract IItemLabelProvider getLabelProvider();

	protected abstract List<?> getValues();

	protected abstract Collection<?> getChoiceOfValues();

	protected abstract boolean isMultiLine();

	protected abstract boolean isUnique();

	protected abstract void setValue(Object value);
	
	public static boolean select(String filter, String labelValue) {
		if (filter != null && filter.length() > 0) {
			if (filter.length() > labelValue.length()) {
				return false;
			}
			for (int i = 0; i < filter.length(); i++) {
				if (Character.toLowerCase(filter.charAt(i)) != Character.toLowerCase(labelValue.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

	private static class StringPositionPair implements Comparable<StringPositionPair> {
		public String key;
		public int position;

		StringPositionPair(String key, int position) {
			this.key = key;
			this.position = position;
		}

		public int compareTo(StringPositionPair object) {
			if (object == this || key == object.key) {
				return 0;
			} else if (key == null) {
				return -1;
			} else {
				return key.compareTo(object.key);
			}
		}
	}

}
