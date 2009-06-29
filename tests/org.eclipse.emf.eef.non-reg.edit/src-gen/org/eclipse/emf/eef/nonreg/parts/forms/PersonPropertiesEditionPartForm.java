/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.RadioViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code
/**
 * 
 */
public class PersonPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, PersonPropertiesEditionPart {

	protected Text firstname;
	protected Text lastname;
	protected Text age;
	protected Button eclipseCommiter;
	protected Button isRegistered;
	protected RadioViewer genderRadioViewer;
	protected EMFListEditUtil accreditationsEditUtil;
	protected TableViewer accreditations;
	protected Button addAccreditations;
	protected Button removeAccreditations;
	protected List<ViewerFilter> accreditationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> accreditationsFilters = new ArrayList<ViewerFilter>();
	protected AdvancedEObjectFlatComboViewer<Company> workFor;
	protected ViewerFilter workForFilter;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PersonPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(NonregMessages.PersonPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createFirstnameText(widgetFactory, propertiesGroup);
		createLastnameText(widgetFactory, propertiesGroup);
		createAgeText(widgetFactory, propertiesGroup);
		createEclipseCommiterCheckbox(widgetFactory, propertiesGroup);
		createIsRegisteredCheckbox(widgetFactory, propertiesGroup);
		createGenderRadioViewer(propertiesGroup);
		createAccreditationsReferencesTable(widgetFactory, propertiesGroup);
		createWorkForFlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}
	protected void createFirstnameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.PersonPropertiesEditionPart_FirstnameLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.firstname, NonregViewsRepository.FORM_KIND));
		firstname = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		firstname.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData firstnameData = new GridData(GridData.FILL_HORIZONTAL);
		firstname.setLayoutData(firstnameData);
		firstname.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.firstname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, firstname.getText()));
			}
			
		});
		firstname.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.firstname, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstname.getText()));
			}

		});
		firstname.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.firstname, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, firstname.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.firstname, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createLastnameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.PersonPropertiesEditionPart_LastnameLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.lastname, NonregViewsRepository.FORM_KIND));
		lastname = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		lastname.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData lastnameData = new GridData(GridData.FILL_HORIZONTAL);
		lastname.setLayoutData(lastnameData);
		lastname.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.lastname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, lastname.getText()));
			}
			
		});
		lastname.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.lastname, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lastname.getText()));
			}

		});
		lastname.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.lastname, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lastname.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.lastname, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createAgeText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.PersonPropertiesEditionPart_AgeLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.age, NonregViewsRepository.FORM_KIND));
		age = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		age.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData ageData = new GridData(GridData.FILL_HORIZONTAL);
		age.setLayoutData(ageData);
		age.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.age, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, age.getText()));
			}
			
		});
		age.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.age, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, age.getText()));
			}

		});
		age.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.age, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, age.getText()));
				}
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.age, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$

	}
	protected void createEclipseCommiterCheckbox(FormToolkit widgetFactory, Composite parent) {
		eclipseCommiter = widgetFactory.createButton(parent, NonregMessages.PersonPropertiesEditionPart_EclipseCommiterLabel, SWT.CHECK);
		eclipseCommiter.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.eclipseCommiter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(eclipseCommiter.getSelection())));
			}
			
		});
		GridData eclipseCommiterData = new GridData(GridData.FILL_HORIZONTAL);
		eclipseCommiterData.horizontalSpan = 2;
		eclipseCommiter.setLayoutData(eclipseCommiterData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.eclipseCommiter, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createIsRegisteredCheckbox(FormToolkit widgetFactory, Composite parent) {
		isRegistered = widgetFactory.createButton(parent, NonregMessages.PersonPropertiesEditionPart_IsRegisteredLabel, SWT.CHECK);
		isRegistered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.isRegistered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isRegistered.getSelection())));
			}
			
		});
		GridData isRegisteredData = new GridData(GridData.FILL_HORIZONTAL);
		isRegisteredData.horizontalSpan = 2;
		isRegistered.setLayoutData(isRegisteredData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.isRegistered, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createGenderRadioViewer(Composite parent) {
		genderRadioViewer = new RadioViewer(parent, SWT.CHECK);
		GridData genderData = new GridData(GridData.FILL_HORIZONTAL);
		genderData.horizontalSpan = 2;
		genderRadioViewer.setLayoutData(genderData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.gender, NonregViewsRepository.FORM_KIND), null);
	}
	protected void createAccreditationsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		Label accreditationsLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.PersonPropertiesEditionPart_AccreditationsLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.accreditations, NonregViewsRepository.FORM_KIND));
		GridData accreditationsLabelData = new GridData();
		accreditationsLabelData.horizontalSpan = 3;
		accreditationsLabel.setLayoutData(accreditationsLabelData);
		accreditations = createAccreditationsViewer(parent, widgetFactory, adapterFactory);
		GridData accreditationsData = new GridData(GridData.FILL_HORIZONTAL);
		accreditationsData.horizontalSpan = 2;
		accreditationsData.minimumHeight = 120;
		accreditationsData.heightHint = 120;
		accreditations.getTable().setLayoutData(accreditationsData);
		createAccreditationsControlPanel(parent, widgetFactory);
	}

	protected TableViewer createAccreditationsViewer(Composite container, FormToolkit widgetFactory, AdapterFactory adapter) {
		org.eclipse.swt.widgets.Table table = widgetFactory.createTable(container, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		table.setLayoutData(gd);
		table.setLinesVisible(true);
		// Start of user code for table accreditations s columns definition
		
		TableColumn name = new TableColumn(table, SWT.NONE);
		name.setWidth(80);
		name.setText("Label"); //$NON-NLS-1$
		// End of user code		
		TableViewer result = new TableViewer(table);
		result.setContentProvider(new ArrayContentProvider());
		result.setLabelProvider(new ITableLabelProvider() {
	
			// Start of user code for table accreditations label provider
			
			public String getColumnText(Object object, int columnIndex) {
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				if (object instanceof EObject) {
					switch (columnIndex) {
					case 0:
						return labelProvider.getText(object);
					}
				}
				return ""; //$NON-NLS-1$
			}
			// End of user code
			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

		});
		return result;
	}

	protected void createAccreditationsControlPanel(Composite container, FormToolkit widgetFactory) {
		Composite result = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		result.setLayout(layout);
		addAccreditations = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_AddListViewerLabel, SWT.NONE);
		GridData addData = new GridData(GridData.FILL_HORIZONTAL);
		addAccreditations.setLayoutData(addData);
		addAccreditations.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addAccreditations();
				accreditations.refresh();
			}

		});
		removeAccreditations = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_RemoveListViewerLabel, SWT.NONE);
		GridData removeData = new GridData(GridData.FILL_HORIZONTAL);
		removeAccreditations.setLayoutData(removeData);
		removeAccreditations.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (accreditations.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) accreditations.getSelection();
					removeAccreditations(selection);
					accreditations.refresh();
				}
			}

		});
	}
	
	/**
	 *
	 */
	protected void addAccreditations() {

		EMFModelViewerDialog dialog = new EMFModelViewerDialog(new AdapterFactoryLabelProvider(adapterFactory), resourceSet, accreditationsFilters, accreditationsBusinessFilters, false, true) {
			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					if (!accreditationsEditUtil.getVirtualList().contains(elem)) {
						accreditationsEditUtil.addElement(elem);
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.accreditations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, accreditationsEditUtil.foundCorrespondingEObject(elem)));
					}
				}
			}
	
		};
		dialog.open();
	}
	
	/**
	 * @param selection the accreditations to remove
	 */
	protected void removeAccreditations(IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof EObject) {
			EObject selectedElement = (EObject) selection.getFirstElement();
			accreditationsEditUtil.removeElement(selectedElement);
			propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.accreditations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, accreditationsEditUtil.foundCorrespondingEObject(selectedElement)));
		}
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createWorkForFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.PersonPropertiesEditionPart_WorkForLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.workFor, NonregViewsRepository.FORM_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.workFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }
			
			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company)EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartForm.this, NonregViewsRepository.Person.workFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Company)propertiesEditionObject;
					}
					if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null)
						return eObject;
					return null;
				}
				return null;
			}
			
		};
		//create widget
		workFor = new AdvancedEObjectFlatComboViewer<Company>(NonregMessages.PersonPropertiesEditionPart_WorkForLabel, 
			resourceSet, workForFilter, NonregPackage.eINSTANCE.getCompany(), listener);
		workFor.createControls(parent, widgetFactory);
		GridData workForData = new GridData(GridData.FILL_HORIZONTAL);
		workFor.setLayoutData(workForData);
		
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.workFor, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}


	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getFirstname()
	 */
	public String getFirstname() {
		return firstname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setFirstname(String newValue)
	 */
	public void setFirstname(String newValue) {
		if (newValue != null) {
			firstname.setText(newValue);
		} else {
			firstname.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForFirstname(String msg, int msgLevel) {
		messageManager.addMessage("Firstname_key", msg, null, msgLevel, firstname);
	}

	public void unsetMessageForFirstname() {
		messageManager.removeMessage("Firstname_key", firstname);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getLastname()
	 */
	public String getLastname() {
		return lastname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setLastname(String newValue)
	 */
	public void setLastname(String newValue) {
		if (newValue != null) {
			lastname.setText(newValue);
		} else {
			lastname.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForLastname(String msg, int msgLevel) {
		messageManager.addMessage("Lastname_key", msg, null, msgLevel, lastname);
	}

	public void unsetMessageForLastname() {
		messageManager.removeMessage("Lastname_key", lastname);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAge()
	 */
	public String getAge() {
		return age.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setAge(String newValue)
	 */
	public void setAge(String newValue) {
		if (newValue != null) {
			age.setText(newValue);
		} else {
			age.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForAge(String msg, int msgLevel) {
		messageManager.addMessage("Age_key", msg, null, msgLevel, age);
	}

	public void unsetMessageForAge() {
		messageManager.removeMessage("Age_key", age);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getEclipseCommiter()
	 */
	public Boolean getEclipseCommiter() {
		return Boolean.valueOf(eclipseCommiter.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setEclipseCommiter(Boolean newValue)
	 */
	public void setEclipseCommiter(Boolean newValue) {
		if (newValue != null) {
			eclipseCommiter.setSelection(newValue.booleanValue());
		} else {
			eclipseCommiter.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getIsRegistered()
	 */
	public Boolean getIsRegistered() {
		return Boolean.valueOf(isRegistered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setIsRegistered(Boolean newValue)
	 */
	public void setIsRegistered(Boolean newValue) {
		if (newValue != null) {
			isRegistered.setSelection(newValue.booleanValue());
		} else {
			isRegistered.setSelection(false);
		}
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getGender()
	 */
	public Object getGender() {
		return genderRadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initGender(EEnum eenum, Enumerator current)
	 */
	public void initGender(EEnum eenum, Enumerator current) {
		genderRadioViewer.setInput(eenum.getELiterals());
		genderRadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setGender(Object newValue)
	 */
	public void setGender(Object newValue) {
		genderRadioViewer.setSelection(newValue);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsToAdd()
	 */
	public List getAccreditationsToAdd() {
		return accreditationsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsToRemove()
	 */
	public List getAccreditationsToRemove() {
		return accreditationsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsTable()
	 */
	public List getAccreditationsTable() {
		return accreditationsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initAccreditations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAccreditations(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			accreditationsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			accreditationsEditUtil = new EMFListEditUtil(current, feature);
		this.accreditations.setInput(accreditationsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#updateAccreditations(EObject newValue)
	 */
	public void updateAccreditations(EObject newValue) {
		if(accreditationsEditUtil != null){
			accreditationsEditUtil.reinit(newValue);
			accreditations.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addFilterAccreditations(ViewerFilter filter)
	 */
	public void addFilterToAccreditations(ViewerFilter filter) {
		accreditationsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addBusinessFilterAccreditations(ViewerFilter filter)
	 */
	public void addBusinessFilterToAccreditations(ViewerFilter filter) {
		accreditationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#isContainedInAccreditationsTable(EObject element)
	 */
	public boolean isContainedInAccreditationsTable(EObject element) {
		return accreditationsEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getWorkFor()
	 */
	public EObject getWorkFor() {
		return workFor.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initWorkFor(ResourceSet allResources, EObject current)
	 */
	public void initWorkFor(ResourceSet allResources, EObject current) {
		workFor.setInput(allResources);
		if (current != null) {
			workFor.setSelection(new StructuredSelection(current));
			workFor.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setWorkFor(EObject newValue)
	 */
	public void setWorkFor(EObject newValue) {
		if (newValue != null) {
			workFor.setSelection(new StructuredSelection(newValue));
		} else {
			workFor.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setWorkForButtonMode(ButtonsModeEnum newValue)
	 */
	public void setWorkForButtonMode(ButtonsModeEnum newValue) {
		workFor.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addFilterWorkFor(ViewerFilter filter)
	 */
	public void addFilterToWorkFor(ViewerFilter filter) {
		workFor.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addBusinessFilterWorkFor(ViewerFilter filter)
	 */
	public void addBusinessFilterToWorkFor(ViewerFilter filter) {
		workFor.addBusinessRuleFilter(filter);
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
