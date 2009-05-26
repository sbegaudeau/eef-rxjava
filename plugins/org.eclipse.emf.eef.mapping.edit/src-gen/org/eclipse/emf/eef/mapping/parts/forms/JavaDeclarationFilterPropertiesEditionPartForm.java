/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.mapping.parts.FilterPropertiesPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.JavaDeclarationFilterPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class JavaDeclarationFilterPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, JavaDeclarationFilterPropertiesEditionPart {

	private Text methodName;

	private FilterPropertiesPropertiesEditionPart filterPropertiesPropertiesEditionPart;



	
	public JavaDeclarationFilterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createFilterExpressionGroup(widgetFactory, view);
		createFilterProperties(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createFilterExpressionGroup(FormToolkit widgetFactory, final Composite view) {
		Section filterExpressionSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		filterExpressionSection.setText(MappingMessages.JavaDeclarationFilterPropertiesEditionPart_FilterExpressionGroupLabel);
		GridData filterExpressionSectionData = new GridData(GridData.FILL_HORIZONTAL);
		filterExpressionSectionData.horizontalSpan = 3;
		filterExpressionSection.setLayoutData(filterExpressionSectionData);
		Composite filterExpressionGroup = widgetFactory.createComposite(filterExpressionSection);
		GridLayout filterExpressionGroupLayout = new GridLayout();
		filterExpressionGroupLayout.numColumns = 3;
		filterExpressionGroup.setLayout(filterExpressionGroupLayout);
		createMethodNameText(widgetFactory, filterExpressionGroup);
		filterExpressionSection.setClient(filterExpressionGroup);
	}
	protected void createMethodNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.JavaDeclarationFilterPropertiesEditionPart_MethodNameLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.JavaDeclarationFilter.methodName, MappingViewsRepository.FORM_KIND));
		methodName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		methodName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData methodNameData = new GridData(GridData.FILL_HORIZONTAL);
		methodName.setLayoutData(methodNameData);
		methodName.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JavaDeclarationFilterPropertiesEditionPartForm.this, MappingViewsRepository.JavaDeclarationFilter.methodName, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, methodName.getText()));
			}
			
		});
		methodName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JavaDeclarationFilterPropertiesEditionPartForm.this, MappingViewsRepository.JavaDeclarationFilter.methodName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, methodName.getText()));
			}

		});
		methodName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JavaDeclarationFilterPropertiesEditionPartForm.this, MappingViewsRepository.JavaDeclarationFilter.methodName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, methodName.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.JavaDeclarationFilter.methodName, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createFilterProperties(FormToolkit widgetFactory, Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
		filterPropertiesPropertiesEditionPart = (FilterPropertiesPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, MappingViewsRepository.FORM_KIND, propertiesEditionComponent);
		((IFormPropertiesEditionPart)filterPropertiesPropertiesEditionPart).createControls(widgetFactory, container, messageManager);
	}


	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#getMethodName()
	 */
	public String getMethodName() {
		return methodName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#setMethodName(String newValue)
	 */
	public void setMethodName(String newValue) {
		methodName.setText(newValue);
	}

	public void setMessageForMethodName(String msg, int msgLevel) {
		messageManager.addMessage("MethodName_key", msg, null, msgLevel, methodName);
	}

	public void unsetMessageForMethodName() {
		messageManager.removeMessage("MethodName_key", methodName);
	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#getFilterPropertiesReferencedView()
	 */
		public IPropertiesEditionPart getFilterPropertiesReferencedView() {
			return (IPropertiesEditionPart) filterPropertiesPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#getName()
	 */
	public String getName() {
		return filterPropertiesPropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		filterPropertiesPropertiesEditionPart.setName(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {
		filterPropertiesPropertiesEditionPart.setMessageForName(msg, msgLevel);
	}

	public void unsetMessageForName() {
		filterPropertiesPropertiesEditionPart.unsetMessageForName();
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#getMandatory()
	 */
	public Boolean getMandatory() {
		return filterPropertiesPropertiesEditionPart.getMandatory();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaDeclarationFilterPropertiesEditionPart#setMandatory(Boolean newValue)
	 */
	public void setMandatory(Boolean newValue) {
		filterPropertiesPropertiesEditionPart.setMandatory(newValue);
	}










	
	// Start of user code additional methods
	
	// End of user code
}	
