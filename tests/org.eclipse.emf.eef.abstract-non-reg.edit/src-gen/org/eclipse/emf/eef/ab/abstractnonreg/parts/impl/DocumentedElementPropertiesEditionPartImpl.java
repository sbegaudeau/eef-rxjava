/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.ab.abstractnonreg.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.ab.abstractnonreg.providers.AbstractnonregMessages;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart;


import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;

// End of user code
/**
 * 
 */
public class DocumentedElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DocumentedElementPropertiesEditionPart {

	private Text documentation;




	
	public DocumentedElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}
	
	public void createControls(Composite view) { 
		createDocumentationGroup(view);
		
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createDocumentationGroup(Composite parent) {
		Group documentationGroup = new Group(parent, SWT.NONE);
		documentationGroup.setText(AbstractnonregMessages.DocumentedElementPropertiesEditionPart_DocumentationGroupLabel);
		GridData documentationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		documentationGroupData.horizontalSpan = 3;
		documentationGroup.setLayoutData(documentationGroupData);
		GridLayout documentationGroupLayout = new GridLayout();
		documentationGroupLayout.numColumns = 3;
		documentationGroup.setLayout(documentationGroupLayout);
		createDocumentationTextarea(documentationGroup);
	}
	protected void createDocumentationTextarea(Composite parent) {
		Label documentationLabel = SWTUtils.createPartLabel(parent, AbstractnonregMessages.DocumentedElementPropertiesEditionPart_DocumentationLabel, propertiesEditionComponent.isRequired(AbstractnonregViewsRepository.DocumentedElement.documentation, AbstractnonregViewsRepository.SWT_KIND));
		GridData documentationLabelData = new GridData(GridData.FILL_HORIZONTAL);
		documentationLabelData.horizontalSpan = 3;
		documentationLabel.setLayoutData(documentationLabelData);
		documentation = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData documentationData = new GridData(GridData.FILL_HORIZONTAL);
		documentationData.horizontalSpan = 2;
		documentationData.heightHint = 80;
		documentation.setLayoutData(documentationData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(AbstractnonregViewsRepository.DocumentedElement.documentation, AbstractnonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		documentation.setText(newValue);
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {

	}

	public void unsetMessageForDocumentation() {

	}








	// Start of user code additional methods
 	
	// End of user code
}
