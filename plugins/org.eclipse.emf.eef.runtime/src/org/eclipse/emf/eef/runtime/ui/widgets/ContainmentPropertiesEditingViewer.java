/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.runtime.ui.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionContentProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * 
 */
public class ContainmentPropertiesEditingViewer extends StructuredViewer {

	/**
	 * Image for the add element button.
	 */
	final protected static Image NEW_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16
			+ "Add_16x16.gif"); //$NON-NLS-1$

	/**
	 * Image for the delete element button.
	 */
	final protected static Image DELETE_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16
			+ "Delete_16x16.gif"); //$NON-NLS-1$

	/**
	 * Image for the up button.
	 */
	final protected static Image UP_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16
			+ "ArrowUp_16x16.gif"); //$NON-NLS-1$

	/**
	 * Image for the down button.
	 */
	final protected static Image DOWN_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16
			+ "ArrowDown_16x16.gif"); //$NON-NLS-1$

	private Composite control;

	private int kind;
	private String mode;
	private FormToolkit toolkit;
	private IPropertiesEditionComponent component;
	private Object viewerInput;

	private List<ReferencesTableListener> listeners;

	private boolean scrolledFormSearched;
	private ScrolledForm scrolledForm;
	
	private boolean refreshState;
	private CLabel title;
	private Button addButton;
	private Label helpButton;
	private FormColors colors;




	/**
	 * Default container for SWT mode.
	 * @param parent parent composite
	 * @param kind kind of view
	 */
	public ContainmentPropertiesEditingViewer(Composite parent, int kind) {
		super();
		this.kind = kind;
		this.listeners = new ArrayList<ReferencesTable.ReferencesTableListener>();
		this.scrolledFormSearched = false;
		
		control = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = -4;
		((Composite) control).setLayout(layout);
		title = new CLabel((Composite) control, SWT.NONE);
		title.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addButton = new Button((Composite) control, SWT.PUSH);
		addButton.setImage(NEW_ELEMENT_IMG);
		addButton.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				for (ReferencesTableListener listener : listeners) {
					listener.handleAdd();
				}
			}
			
		
		});
	}

	/**
	 * Constructor with toolkit for Form mode.
	 * @param parent parent composite
	 * @param kind kind of view
	 * @param toolkit toolkit to use
	 */
	public ContainmentPropertiesEditingViewer(Composite parent, int kind, FormToolkit toolkit) {
		super();
		this.kind = kind;
		this.toolkit = toolkit;
		this.listeners = new ArrayList<ReferencesTable.ReferencesTableListener>();
		this.scrolledFormSearched = false;
		
		control = toolkit.createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		layout.marginLeft = -4;
		((Composite) control).setLayout(layout);
		title = new CLabel((Composite) control, SWT.NONE);
		title.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		EditingUtils.setEEFtype(title, "eef::ContainmentPropertiesEditingViewer::title");
		addButton = toolkit.createButton((Composite) control, "", SWT.PUSH);
		addButton.setImage(NEW_ELEMENT_IMG);
		addButton.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				for (ReferencesTableListener listener : listeners) {
					listener.handleAdd();
				}
			}
			
		
		});
		EditingUtils.setEEFtype(addButton, "eef::ContainmentPropertiesEditingViewer::addbutton");
		Control createHelpButton = FormUtils.createHelpButton(toolkit, control, "", "");
		if (createHelpButton instanceof Label) {
			helpButton = (Label)createHelpButton; 
			GridData layoutData = new GridData();
			layoutData.widthHint = 0;
			createHelpButton.setLayoutData(layoutData);
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#doFindInputItem(java.lang.Object)
	 */
	@Override
	protected Widget doFindInputItem(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#doFindItem(java.lang.Object)
	 */
	@Override
	protected Widget doFindItem(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#doUpdateItem(org.eclipse.swt.widgets.Widget,
	 *      java.lang.Object, boolean)
	 */
	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param listener to add.
	 */
	public void addListener(ReferencesTableListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * @param listener to remove.
	 */
	public void removeListener(ReferencesTableListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the component
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent() {
		return component;
	}

	/**
	 * @param component the component to set
	 */
	public void setPropertiesEditingComponent(IPropertiesEditionComponent component) {
		this.component = component;
	}

	/**
	 * @param text title of the widget.
	 */
	public void setText(String text) {
		if (text != null) {
			title.setText(text);
		}
	}

	/**
	 * @param text help of the widget
	 */
	public void setHelpText(String text) {
		if (text != null && !"".equals(text)) {
			((GridData)helpButton.getLayoutData()).widthHint = 25;
			helpButton.setToolTipText(text);
		} else {
			((GridData)helpButton.getLayoutData()).widthHint = 0;			
		}
	}
	
	/**
	 * @param id
	 */
	public void setID(Object id) {
		EditingUtils.setID(control, id);
		EditingUtils.setID(title, id);
		EditingUtils.setID(addButton, id);
	}
	
	/**
	 * @param required whether the feature is required or not.
	 */
	public void setRequired(boolean required) {
		if (required) {
			title.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT));
		} else {
			title.setFont(JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#internalRefresh(java.lang.Object)
	 */
	@Override
	protected void internalRefresh(Object element) {
		clear();
		this.viewerInput = element;
		if (getContentProvider() != null) {
			refreshState = true;
			Object[] elements = getChildrenViewer(element);
			for (Object object : elements) {
				if (object instanceof EObject) {
					Composite controlAsComposite = (Composite) control;
					createChild((EObject) object, controlAsComposite);
				}
			}
			refreshState = false;
		}
		if (control.getLayoutData() instanceof GridData) {
			Composite parent = control.getParent();
			while (parent != null) {
				parent.layout(true);
				if (parent instanceof ScrolledComposite){
					parent = null;
				} else {
					parent = parent.getParent();
				}
			}
			control.layout(true);
			
		}
		ScrolledForm owningScrolledForm = owningScrolledForm(control);
		if (owningScrolledForm != null) {
			owningScrolledForm.reflow(true);
		}

	}

	/**
	 * @param element to process
	 * @return the children of the element.
	 */
	private Object[] getChildrenViewer(Object element) {
		ReferencesTableContentProvider propertiesEditionProvider = (ReferencesTableContentProvider)getContentProvider();
		Object[] elements = propertiesEditionProvider.getElements(element);
		return elements;
	}
	
	/**
	 * @param elements
	 * @param searched
	 * @return
	 */
	private int indexOf(Object searched) {
		Object[] elements = getChildrenViewer(viewerInput); 
		for (int i = 0; i < elements.length; i++) {
			if (searched.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Remove all the children elements of the viewer.
	 */
	protected void clear() {
		for (Control child : control.getChildren()) {
			if (child instanceof ChildComposite) {
				child.dispose();
			}
		}
	}
	
	/**
	 * @param composite
	 * @return the ScrolledForm owning the current viewer <code>null</code> otherwise.
	 */
	private ScrolledForm gettingOwningScrolledForm(Composite composite) {
		if (composite instanceof ScrolledForm) {
			return (ScrolledForm) composite;
		} else if (composite != null) {
			return owningScrolledForm(composite.getParent());
		} else {
			return null;
		}	
	}
	
	/**
	 * Search the ScrolledForm owning the current viewer. 
	 * @param composite current viewer.
	 * @return the ScrolledForm owning the current viewer <code>null</code> otherwise.
	 */
	private ScrolledForm owningScrolledForm(Composite composite) {
		if (!scrolledFormSearched) {
			scrolledForm = gettingOwningScrolledForm(composite);
			scrolledFormSearched = true;
		}
		return scrolledForm;
	}

	/**
	 * Creates a ChildComposite for the given EObject.
	 * @param object EObject to display.
	 * @param parent the viewer control.
	 */
	private void createChild(EObject object, Composite parent) {
		ChildComposite child = new ChildComposite(parent, SWT.NONE);
		child.setInput(object);
	}

	private String labelTitle(Object object) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory().adapt(object, IItemLabelProvider.class);
		String text = null;
		if (labelProvider != null)
			text = labelProvider.getText(object);
		else 
			text = object.toString();
		return text;
	}

	private Image labelImage(Object object) {
		return new AdapterFactoryLabelProvider(adapterFactory()).getImage(object);
	}
	private AdapterFactory adapterFactory() {
		return component.getEditingContext().getAdapterFactory();
	}

	protected IContentProvider getInternContentProvider() {
		if (component != null && component.getEditingContext() != null) {
			if (mode == IPropertiesEditionComponent.LIVE_MODE) {
				return new PropertiesEditionContentProvider(adapterFactory(), mode, EEFUtils.getEditingDomain(component.getEditingContext()));
			} else {
				try {
					return new PropertiesEditionContentProvider(adapterFactory(), mode);
				} catch (InstantiationException e) {
					throw new IllegalStateException("An EditingDomain must be defined for live mode.");
				}				
			}
		} else {
			throw new IllegalStateException("A PropertiesEditingComponent must be defined for this widget.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#reveal(java.lang.Object)
	 */
	@Override
	public void reveal(Object element) {}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#getSelectionFromWidget()
	 */
	@Override
	protected List<?> getSelectionFromWidget() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#setSelectionToWidget(java.util.List,
	 *      boolean)
	 */
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#getControl()
	 */
	@Override
	public Control getControl() {
		return control;
	}

	private Color getColor(String key) {
		if (colors == null) {
			colors = new FormColors(control.getDisplay());
		}
		return colors.getColor(key);
	}
	
	private class ChildComposite extends Composite {

		private CLabel objectTitle;
		private PropertiesEditionViewer viewer;
		private EObject input;
		private IPropertiesEditionListener listener;
		
		public ChildComposite(Composite parent, int style) {
			super(parent, style);
			GridData compositeData = new GridData(GridData.FILL_BOTH);
			compositeData.horizontalSpan= 3;
			setLayoutData(compositeData);
			GridLayout layout = new GridLayout(4, false);
			layout.marginWidth = 5;
			layout.verticalSpacing = 5;
			setLayout(layout);
			Button removeButton;
			Button upButton;
			Button downButton;
			if (kind == 1)  {				
				setBackground(getColor(IFormColors.TB_BG));
				objectTitle = new CLabel(this, SWT.NONE);
				removeButton = toolkit.createButton(this, "", SWT.PUSH);
				upButton = toolkit.createButton(this, "", SWT.PUSH);
				downButton = toolkit.createButton(this, "", SWT.PUSH);
			} else {
				setBackground(JFaceColors.getBannerBackground(getDisplay()));
				objectTitle = new CLabel(this, SWT.NONE);
				objectTitle.setBackground(JFaceColors.getBannerBackground(getDisplay()));
				removeButton = new Button(this, SWT.PUSH);
				upButton = new Button(this, SWT.PUSH);
				downButton = new Button(this, SWT.PUSH);
			}
			EditingUtils.setEEFtype(objectTitle, "eef::ContainmentPropertiesEditingViewer::childtitle");
			EditingUtils.setEEFtype(removeButton, "eef::ContainmentPropertiesEditingViewer::removechildbutton");
			EditingUtils.setEEFtype(upButton, "eef::ContainmentPropertiesEditingViewer::upchildbutton");
			EditingUtils.setEEFtype(downButton, "eef::ContainmentPropertiesEditingViewer::downchildbutton");
			GridData labelData = new GridData(GridData.FILL_HORIZONTAL);
			objectTitle.setLayoutData(labelData);
			removeButton.setImage(DELETE_ELEMENT_IMG);
			removeButton.addSelectionListener(new SelectionAdapter() {

				/**
				 * {@inheritDoc}
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (ReferencesTableListener listener : listeners) {
						listener.handleRemove(input);
					}
				}
				
			});
			upButton.setImage(UP_ELEMENT_IMG);
			upButton.addSelectionListener(new SelectionAdapter() {

				/**
				 * {@inheritDoc}
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (ReferencesTableListener listener : listeners) {
						int indexOf = indexOf(input);
						if (indexOf > 0) {
							listener.handleMove(input, indexOf, indexOf - 1);
						}
					}
				}
				
				
			});
			downButton.setImage(DOWN_ELEMENT_IMG);
			downButton.addSelectionListener(new SelectionAdapter() {

				/**
				 * {@inheritDoc}
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (ReferencesTableListener listener : listeners) {
						int indexOf = indexOf(input);
						if (indexOf > -1 && indexOf < (getChildrenViewer(viewerInput).length - 1)) {
							listener.handleMove(input, indexOf, indexOf + 1);
						}
					}
				}
				
				
			});
			viewer = new PropertiesEditionViewer(this, null, SWT.NONE, kind);
			if (toolkit != null) {
				viewer.setToolkit(toolkit);
			}
			viewer.setContentProvider(getInternContentProvider());
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 4;
			viewer.getControl().setLayoutData(data);
		}

		/**
		 * Defines input of the viewer.
		 * @param object the viewer input
		 */
		public void setInput(EObject object) {
			this.input = object;
			if (component != null && component.getEditingContext() != null) {
				if (mode == IPropertiesEditionComponent.LIVE_MODE) {
					viewer.setInput(new DomainPropertiesEditionContext(component.getEditingContext(), component, EEFUtils.getEditingDomain(component.getEditingContext()), adapterFactory(), (EObject) object));
				} else {
					viewer.setInput(new EObjectPropertiesEditionContext(component.getEditingContext(), component, (EObject) object, adapterFactory()));
				}
			} else {
				viewer.setInput(object);
			}
			listener = new IPropertiesEditionListener() {
				
				public void firePropertiesChanged(IPropertiesEditionEvent event) {
					refreshTitle(input);
				}
			};
			((PropertiesEditionContentProvider)viewer.getContentProvider()).addPropertiesListener(listener);
			refreshTitle(object);
		}
	
		/**
		 * {@inheritDoc}
		 * @see org.eclipse.swt.widgets.Widget#dispose()
		 */
		@Override
		public void dispose() {
			if (listener != null) {
				((PropertiesEditionContentProvider)viewer.getContentProvider()).removePropertiesListener(listener);
			}
			super.dispose();
		}

		/**
		 * @return input of the viewer.
		 */
		public EObject getInput() {
			return input;
		}

		public void refreshTitle(Object object) {
			objectTitle.setText(labelTitle(object));
			Image labelImage = labelImage(object);
			if (labelImage != null) {
				objectTitle.setImage(labelImage);
			}
		}
		
		
		
	}

}
