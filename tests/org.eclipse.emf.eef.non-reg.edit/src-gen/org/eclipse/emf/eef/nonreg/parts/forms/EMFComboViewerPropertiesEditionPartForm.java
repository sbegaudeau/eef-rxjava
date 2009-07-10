/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class EMFComboViewerPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EMFComboViewerPropertiesEditionPart {

	protected EMFComboViewer emfcomboviewer;
	protected EMFComboViewer emfcomboviewerRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EMFComboViewerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
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
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createEmfcomboviewerEMFComboViewer(widgetFactory, view);
		createEmfcomboviewerROEMFComboViewer(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createEmfcomboviewerEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.EMFComboViewerPropertiesEditionPart_EmfcomboviewerLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.EMFComboViewer.emfcomboviewer, NonregViewsRepository.FORM_KIND));
		emfcomboviewer = new EMFComboViewer(parent);
		emfcomboviewer.setContentProvider(new ArrayContentProvider());
		emfcomboviewer.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData emfcomboviewerData = new GridData(GridData.FILL_HORIZONTAL);
		emfcomboviewer.getCombo().setLayoutData(emfcomboviewerData);
		emfcomboviewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.EMFComboViewer.emfcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEmfcomboviewer()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.EMFComboViewer.emfcomboviewer, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createEmfcomboviewerROEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.EMFComboViewerPropertiesEditionPart_EmfcomboviewerROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.EMFComboViewer.emfcomboviewerRO, NonregViewsRepository.FORM_KIND));
		emfcomboviewerRO = new EMFComboViewer(parent);
		emfcomboviewerRO.setContentProvider(new ArrayContentProvider());
		emfcomboviewerRO.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		emfcomboviewerRO.setEnabled(false);
		emfcomboviewerRO.setToolTipText(NonregMessages.EMFComboViewer_ReadOnly);
		GridData emfcomboviewerROData = new GridData(GridData.FILL_HORIZONTAL);
		emfcomboviewerRO.getCombo().setLayoutData(emfcomboviewerROData);
		emfcomboviewerRO.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.EMFComboViewer.emfcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEmfcomboviewerRO()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.EMFComboViewer.emfcomboviewerRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#getEmfcomboviewer()
	 */
	public Enumerator getEmfcomboviewer() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) emfcomboviewer.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#initEmfcomboviewer(EEnum eenum, Enumerator current)
	 */
	public void initEmfcomboviewer(EEnum eenum, Enumerator current) {
		emfcomboviewer.setInput(eenum.getELiterals());
		emfcomboviewer.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#setEmfcomboviewer(Enumerator newValue)
	 */
	public void setEmfcomboviewer(Enumerator newValue) {
		emfcomboviewer.modelUpdating(new StructuredSelection(newValue));
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#getEmfcomboviewerRO()
	 */
	public Enumerator getEmfcomboviewerRO() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) emfcomboviewerRO.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#initEmfcomboviewerRO(EEnum eenum, Enumerator current)
	 */
	public void initEmfcomboviewerRO(EEnum eenum, Enumerator current) {
		emfcomboviewerRO.setInput(eenum.getELiterals());
		emfcomboviewerRO.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EMFComboViewerPropertiesEditionPart#setEmfcomboviewerRO(Enumerator newValue)
	 */
	public void setEmfcomboviewerRO(Enumerator newValue) {
		emfcomboviewerRO.modelUpdating(new StructuredSelection(newValue));
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
