/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code	

/**
 * 
 * 
 */
public class RoundScorePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RoundScorePropertiesEditionPart {

	protected Text score;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RoundScorePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		createTotalGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createTotalGroup(Composite parent) {
		Group totalGroup = new Group(parent, SWT.NONE);
		totalGroup.setText(TarotMessages.RoundScorePropertiesEditionPart_TotalGroupLabel);
		GridData totalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		totalGroupData.horizontalSpan = 3;
		totalGroup.setLayoutData(totalGroupData);
		GridLayout totalGroupLayout = new GridLayout();
		totalGroupLayout.numColumns = 3;
		totalGroup.setLayout(totalGroupLayout);
		createScoreText(totalGroup);
	}

	
	protected void createScoreText(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.RoundScorePropertiesEditionPart_ScoreLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.RoundScore.score, TarotViewsRepository.SWT_KIND));
		score = new Text(parent, SWT.BORDER);
		score.setEnabled(false);
		score.setToolTipText(TarotMessages.RoundScore_ReadOnly);
		GridData scoreData = new GridData(GridData.FILL_HORIZONTAL);
		score.setLayoutData(scoreData);
		score.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundScorePropertiesEditionPartImpl.this, TarotViewsRepository.RoundScore.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
			}

		});
		score.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RoundScorePropertiesEditionPartImpl.this, TarotViewsRepository.RoundScore.score, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, score.getText()));
				}
			}

		});
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.RoundScore.score, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart#getScore()
	 * 
	 */
	public String getScore() {
		return score.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart#setScore(String newValue)
	 * 
	 */
	public void setScore(String newValue) {
		if (newValue != null) {
			score.setText(newValue);
		} else {
			score.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForScore(String msg, int msgLevel) {

	}

	public void unsetMessageForScore() {

	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.RoundScore_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
