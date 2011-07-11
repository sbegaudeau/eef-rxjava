/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.editor.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.EEFEditor;
import org.eclipse.emf.eef.runtime.ui.gwt.editor.property.ItemPropertyDescriptorFeatureEditor;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * @author glefur
 *
 */
public class EEFPropertiesPanel extends DockLayoutPanel {

	private Grid properties;
	private Object oldSelection;
	private Collection<Runnable> propertyUpdater;
	private EEFEditor editor;

	/**
	 * @param unit
	 */
	public EEFPropertiesPanel(EEFEditor editor, Unit unit) {
		super(unit);
		this.editor = editor;
		propertyUpdater = new HashSet<Runnable>();
		this.setStyleName("Properties", true);
		this.setHeight("100%");

		FlowPanel propertiesTitlePanel = new FlowPanel();
		propertiesTitlePanel.setStyleName("PropertiesTitle", true);

		final Label title = new Label("Properties");
		title.setStyleName("PropertiesTitleLabel", true);

		propertiesTitlePanel.add(title);

		this.addNorth(propertiesTitlePanel, 28.0);

		properties = new Grid();
		properties.setWidth("100%");
		ScrollPanel propertiesScrollPanel = new ScrollPanel();
		propertiesScrollPanel.add(properties);

		this.add(propertiesScrollPanel);
	}
	
	/**
	 * @return the propertyUpdater
	 */
	public Collection<Runnable> getPropertyUpdater() {
		return propertyUpdater;
	}

	public void updateProperties(final Object newSelection) {
		if (oldSelection == newSelection) {
			for (Runnable runnable : propertyUpdater) {
				runnable.run();
			}
		} else {
			editor.getNavigationManager().setSelection(null);

			oldSelection = newSelection;

			List<IItemPropertyDescriptor> propertyDescriptors = editor.getItemDelegator().getPropertyDescriptors(newSelection);
			if (propertyDescriptors != null) {
				properties.clear();
				propertyUpdater.clear();
				int size = propertyDescriptors.size();
				properties.resize(size, 2);
				properties.getColumnFormatter().setWidth(0, "10%");
				properties.getColumnFormatter().setWidth(1, "90%");
				for (int i = 0; i < size; ++i) {
					final IItemPropertyDescriptor propertyDescriptor = propertyDescriptors.get(i);
					properties.setText(i, 0, propertyDescriptor.getDisplayName(newSelection));
					Widget widget = null;
					final IItemLabelProvider itemLabelProvider = propertyDescriptor.getLabelProvider(newSelection);
					final Object feature = propertyDescriptor.getFeature(newSelection);
					if (feature instanceof EReference[]) {
						final ItemPropertyDescriptorFeatureEditor dialog = new ItemPropertyDescriptorFeatureEditor(newSelection, true, propertyDescriptor) {
							@Override
							protected void hook(ListBox listBox, List<?> values) {
								editor.getNavigationManager().listenTo(listBox, values);
							}
						};
						dialog.update();
						widget = dialog;
						propertyUpdater.add(new Runnable() {
							public void run() {
								dialog.update();
							}
						});
					} else if (feature instanceof EStructuralFeature) {
						final EStructuralFeature eStructureFeature = (EStructuralFeature) feature;
						final EClassifier eType = eStructureFeature.getEType();
						final Collection<?> choiceOfValues = propertyDescriptor.getChoiceOfValues(newSelection);
						if (choiceOfValues != null) {
							final List<?> listOfValues = new ArrayList<Object>(propertyDescriptor.getChoiceOfValues(newSelection));
							if (propertyDescriptor.isMany(newSelection)) {
								boolean valid = true;
								for (Object choice : choiceOfValues) {
									if (!eType.isInstance(choice)) {
										valid = false;
										break;
									}
								}

								if (valid) {
									final ItemPropertyDescriptorFeatureEditor dialog = new ItemPropertyDescriptorFeatureEditor(newSelection, true, propertyDescriptor) {
										@Override
										protected void hook(ListBox listBox, List<?> values) {
											editor.getNavigationManager().listenTo(listBox, values);
										}
									};
									dialog.update();
									widget = dialog;
									propertyUpdater.add(new Runnable() {
										public void run() {
											dialog.update();
										}
									});
								}
							}
							if (widget == null) {
								final ListBox listBox = new ListBox();
								widget = listBox;
								listBox.setVisibleItemCount(1);
								Runnable runnable = new Runnable() {
									public void run() {
										listBox.clear();
										editor.getNavigationManager().listenTo(listBox, listOfValues);
										Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
										for (Object value : choiceOfValues) {
											listBox.addItem(itemLabelProvider.getText(value));
											if (value == null ? propertyValue == null : value.equals(propertyValue)) {
												listBox.setSelectedIndex(listBox.getItemCount() - 1);
											}
										}
									}
								};
								listBox.addChangeHandler(new ChangeHandler() {
									public void onChange(ChangeEvent event) {
										Object value = listOfValues.get(listBox.getSelectedIndex());
										propertyDescriptor.setPropertyValue(newSelection, value);
									}
								});
								runnable.run();
								propertyUpdater.add(runnable);
							}
						} else if (eType instanceof EDataType) {
							final EDataType eDataType = (EDataType) eType;
							if (eDataType.isSerializable()) {
								if (propertyDescriptor.isMany(newSelection)) {
									final ItemPropertyDescriptorFeatureEditor dialog = new ItemPropertyDescriptorFeatureEditor(newSelection, propertyDescriptor) {
										@Override
										protected void hook(ListBox listBox, List<?> values) {
											editor.getNavigationManager().listenTo(listBox, values);
										}
									};
									dialog.update();
									widget = dialog;
									propertyUpdater.add(new Runnable() {
										public void run() {
											dialog.update();
										}
									});
								} else {
									if (eDataType.getInstanceClass() == Date.class) {
										final DateBox dateBox = new DateBox();
										widget = dateBox;
										Runnable runnable = new Runnable() {
											public void run() {
												Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
												dateBox.setValue((Date) propertyValue);
											}
										};
										dateBox.addValueChangeHandler(new ValueChangeHandler<Date>() {
											public void onValueChange(ValueChangeEvent<Date> event) {
												propertyDescriptor.setPropertyValue(newSelection, event.getValue());
											}
										});
										runnable.run();
										propertyUpdater.add(runnable);

									} else if (eDataType.getInstanceClass() == Boolean.class || eDataType.getInstanceClass() == boolean.class) {
										final CheckBox checkBox = new CheckBox();
										widget = checkBox;
										Runnable runnable = new Runnable() {
											public void run() {
												Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
												checkBox.setValue(Boolean.TRUE.equals(propertyValue));
											}
										};
										checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
											public void onValueChange(ValueChangeEvent<Boolean> event) {
												propertyDescriptor.setPropertyValue(newSelection, event.getValue());
											}
										});
										runnable.run();
										propertyUpdater.add(runnable);
									} else if (propertyDescriptor.isMultiLine(newSelection)) {
										final TextArea textArea = new TextArea();
										widget = textArea;
										Runnable runnable = new Runnable() {
											public void run() {
												Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
												textArea.setText(EcoreUtil.convertToString(eDataType, propertyValue));
											}
										};
										textArea.addValueChangeHandler(new ValueChangeHandler<String>() {
											public void onValueChange(ValueChangeEvent<String> event) {
												propertyDescriptor.setPropertyValue(newSelection, EcoreUtil.createFromString(eDataType, event.getValue()));
											}
										});
										runnable.run();
										propertyUpdater.add(runnable);
									} else {
										final TextBox textBox = new TextBox();
										widget = textBox;
										textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
											public void onValueChange(ValueChangeEvent<String> event) {
												String value = event.getValue();
												propertyDescriptor.setPropertyValue(newSelection, EcoreUtil.createFromString(eDataType, value));
												// TOD0
												// commandStack.execute(SetCommand.create(editingDomain,
												// object, feature,
												// EcoreUtil.createFromString(eDataType,
												// value)));
											}
										});
										Runnable runnable = new Runnable() {
											public void run() {
												Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
												String stringValue = EcoreUtil.convertToString(eDataType, propertyValue);
												if (!textBox.getText().equals(stringValue)) {
													textBox.setText(stringValue);
												}
											}
										};
										runnable.run();
										propertyUpdater.add(runnable);
									}
								}
							}
						}
					} else {
						final TextBox textBox = new TextBox();
						widget = textBox;
						textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
							public void onValueChange(ValueChangeEvent<String> event) {
								String value = event.getValue();
								propertyDescriptor.setPropertyValue(newSelection, value);
							}
						});
						Runnable runnable = new Runnable() {
							public void run() {
								Object propertyValue = editor.getItemDelegator().getEditableValue(propertyDescriptor.getPropertyValue(newSelection));
								String stringValue = propertyValue == null ? null : propertyDescriptor.getLabelProvider(newSelection).getText(propertyValue);
								if (!textBox.getText().equals(stringValue)) {
									textBox.setText(stringValue);
								}
							}
						};
						runnable.run();
						propertyUpdater.add(runnable);
					}
					if (widget != null) {
						widget.setWidth("95%");
						properties.setWidget(i, 1, widget);
						if (!propertyDescriptor.canSetProperty(newSelection) && widget instanceof FocusWidget) {
							((FocusWidget) widget).setEnabled(false);

						}
					}
				}
			}
		}
	}
	

}
