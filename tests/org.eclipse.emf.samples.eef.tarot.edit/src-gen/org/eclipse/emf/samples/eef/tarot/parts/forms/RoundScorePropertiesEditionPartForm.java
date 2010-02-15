/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * 
 */
public class RoundScorePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RoundScorePropertiesEditionPart {

	protected Text score;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RoundScorePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createTotalGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createTotalGroup(FormToolkit widgetFactory, final Composite view) {
		Section totalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		totalSection.setText(TarotMessages.RoundScorePropertiesEditionPart_TotalGroupLabel);
		GridData totalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		totalSectionData.horizontalSpan = 3;
		totalSection.setLayoutData(totalSectionData);
		Composite totalGroup = widgetFactory.createComposite(totalSection);
		GridLayout totalGroupLayout = new GridLayout();
		totalGroupLayout.numColumns = 3;
		totalGroup.setLayout(totalGroupLayout);
		createScoreText(widgetFactory, totalGroup);
		totalSection.setClient(totalGroup);
	}

	protected void createScoreText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.RoundScorePropertiesEditionPart_ScoreLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundScore.score, TarotViewsRepository.FORM_KIND));
		score = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		score.setEnabled(false);
		score.setToolTipText(TarotMessages.RoundScore_ReadOnly);
		score.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData scoreData = new GridData(GridData.FILL_HORIZONTAL);
		score.setLayoutData(scoreData);
		score.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundScorePropertiesEditionPartForm.this, TarotViewsRepository.RoundScore.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
			}
		});
		score.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundScorePropertiesEditionPartForm.this, TarotViewsRepository.RoundScore.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundScore.score, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart#getScore()
	 */
	public String getScore() {
		return score.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart#setScore(String newValue)
	 */
	public void setScore(String newValue) {
		if (newValue != null) {
			score.setText(newValue);
		} else {
			score.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForScore(String msg, int msgLevel) {
		messageManager.addMessage("Score_key", msg, null, msgLevel, score);
	}

	public void unsetMessageForScore() {
		messageManager.removeMessage("Score_key", score);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return TarotMessages.RoundScore_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
