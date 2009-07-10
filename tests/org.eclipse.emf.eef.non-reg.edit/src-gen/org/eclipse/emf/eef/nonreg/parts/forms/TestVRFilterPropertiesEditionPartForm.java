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

import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.SubPackageNonRegForFiltersPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.TestVRFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.nonreg.parts.TestFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;


// End of user code
/**
 * 
 */
public class TestVRFilterPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TestVRFilterPropertiesEditionPart {


	private TestFilterPropertiesEditionPart testFilterPropertiesEditionPart;



	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TestVRFilterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createTestFilter(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createTestFilter(FormToolkit widgetFactory, Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
		testFilterPropertiesEditionPart = (TestFilterPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.TestFilter.class, NonregViewsRepository.FORM_KIND, propertiesEditionComponent);
		((IFormPropertiesEditionPart)testFilterPropertiesEditionPart).createControls(widgetFactory, container, messageManager);
	}


	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestFilterReferencedView()
	 */
		public IPropertiesEditionPart getTestFilterReferencedView() {
			return (IPropertiesEditionPart) testFilterPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestEOFCV()
	 */
	public EObject getTestEOFCV() {
		return testFilterPropertiesEditionPart.getTestEOFCV();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestEOFCV(ResourceSet allResources, EObject current)
	 */
	public void initTestEOFCV(ResourceSet allResources, EObject current) {
		testFilterPropertiesEditionPart.initTestEOFCV(allResources, current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestEOFCV(EObject newValue)
	 */
	public void setTestEOFCV(EObject newValue) {
		testFilterPropertiesEditionPart.setTestEOFCV(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestEOFCVButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTestEOFCVButtonMode(ButtonsModeEnum newValue) {
		testFilterPropertiesEditionPart.setTestEOFCVButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestEOFCV(ViewerFilter filter)
	 */
	public void addFilterToTestEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestEOFCV(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestEOFCV(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestEOFCV(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTToAdd()
	 */
	public List getTestARTToAdd() {
		return testFilterPropertiesEditionPart.getTestARTToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTToRemove()
	 */
	public List getTestARTToRemove() {
		return testFilterPropertiesEditionPart.getTestARTToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTTable()
	 */
	public List getTestARTTable() {
		return testFilterPropertiesEditionPart.getTestARTTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestART(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTestART(EObject current, EReference containingFeature, EReference feature) {
		testFilterPropertiesEditionPart.initTestART(current, containingFeature, feature);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#updateTestART(EObject newValue)
	 */
	public void updateTestART(EObject newValue) {
		testFilterPropertiesEditionPart.updateTestART(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestART(ViewerFilter filter)
	 */
	public void addFilterToTestART(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestART(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestART(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestART(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestART(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#isContainedInTestARTTable(EObject element)
	 */
	public boolean isContainedInTestARTTable(EObject element) {
		return testFilterPropertiesEditionPart.isContainedInTestARTTable(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestAEOFCV()
	 */
	public EObject getTestAEOFCV() {
		return testFilterPropertiesEditionPart.getTestAEOFCV();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestAEOFCV(ResourceSet allResources, EObject current)
	 */
	public void initTestAEOFCV(ResourceSet allResources, EObject current) {
		testFilterPropertiesEditionPart.initTestAEOFCV(allResources, current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestAEOFCV(EObject newValue)
	 */
	public void setTestAEOFCV(EObject newValue) {
		testFilterPropertiesEditionPart.setTestAEOFCV(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestAEOFCVButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTestAEOFCVButtonMode(ButtonsModeEnum newValue) {
		testFilterPropertiesEditionPart.setTestAEOFCVButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestAEOFCV(ViewerFilter filter)
	 */
	public void addFilterToTestAEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestAEOFCV(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestAEOFCV(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestAEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestAEOFCV(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTToAdd()
	 */
	public List getTestRTToAdd() {
		return testFilterPropertiesEditionPart.getTestRTToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTToRemove()
	 */
	public List getTestRTToRemove() {
		return testFilterPropertiesEditionPart.getTestRTToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTTable()
	 */
	public List getTestRTTable() {
		return testFilterPropertiesEditionPart.getTestRTTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestRT(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTestRT(EObject current, EReference containingFeature, EReference feature) {
		testFilterPropertiesEditionPart.initTestRT(current, containingFeature, feature);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#updateTestRT(EObject newValue)
	 */
	public void updateTestRT(EObject newValue) {
		testFilterPropertiesEditionPart.updateTestRT(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestRT(ViewerFilter filter)
	 */
	public void addFilterToTestRT(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestRT(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestRT(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestRT(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestRT(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#isContainedInTestRTTable(EObject element)
	 */
	public boolean isContainedInTestRTTable(EObject element) {
		return testFilterPropertiesEditionPart.isContainedInTestRTTable(element);
	}










	
	// Start of user code additional methods
	
	// End of user code
}	
