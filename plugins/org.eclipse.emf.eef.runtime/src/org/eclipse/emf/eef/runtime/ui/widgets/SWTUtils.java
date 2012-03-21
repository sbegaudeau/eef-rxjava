/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import java.awt.Toolkit;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public final class SWTUtils {

	/**
	 * Image registry key for help image (value <code>"dialog_help_image"</code> ).
	 */
	public static final String DLG_IMG_HELP = "dialog_help_image"; //$NON-NLS-1$

	/**
	 * Create a label describing a properties of the view
	 * 
	 * @param parent
	 *            the parent composite
	 * @param text
	 *            the label text
	 * @param required
	 *            defines if the associated properties is required or not
	 */
	public static Label createPartLabel(Composite parent, String text, boolean required) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		if (required)
			label.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT));
		return label;
	}

	/**
	 * Creates a button with a help image and put the defined tooltip in parameter.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param the
	 *            message to use for tooltip
	 */
	public static Control createHelpButton(final Composite parent, String helpMessage, String helpID) {
		Image image = JFaceResources.getImage(DLG_IMG_HELP);
		if (helpID != null && !"".equals(helpID)) { //$NON-NLS-1$
			ToolBar result = new ToolBar(parent, SWT.FLAT | SWT.NO_FOCUS);
			((GridLayout)parent.getLayout()).numColumns++;
			result.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
			ToolItem item = new ToolItem(result, SWT.NONE);
			item.setImage(image);
			if (helpMessage != null && !"".equals(helpMessage)) //$NON-NLS-1$
				item.setToolTipText(helpMessage);
			return result;
		} else {
			CLabel result = new CLabel(parent, SWT.NONE);
			if (helpMessage != null && !"".equals(helpMessage)) { //$NON-NLS-1$
				result.setImage(image);
				result.setToolTipText(helpMessage);
			}
			return result;
		}
	}

	public static final double HEIGHT = 0.66;

	public static final double WIDTH = 0.66;

	public static int getHeight() {
		return (int)(HEIGHT * Toolkit.getDefaultToolkit().getScreenSize().height) + 1;
	}

	public static int getWidth() {
		return (int)(WIDTH * Toolkit.getDefaultToolkit().getScreenSize().width) + 1;
	}

	public static int getEntireWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
		/** Utility classes don't need default constructors. */
		private SWTUtils() {
			// Hides default constructor.
		}

		/**
		 * Creates a {@link SourceViewer} widget that knows how to hide its scroll bars.
		 * 
		 * @param parent
		 *            The parent composite for this viewer.
		 * @param style
		 *            Style of the created viewer.
		 * @return The created {@link SourceViewer}.
		 */
		public static SourceViewer createScrollableSourceViewer(Composite parent, int style) {
			SourceViewer viewer = new ScrollableSourceViewer(parent, null, style);

			setUpScrollableListener(viewer.getTextWidget());

			return viewer;
		}

		/**
		 * Creates a {@link StyledText} widget that knows how to hide its scroll bars.
		 * 
		 * @param parent
		 *            The parent composite for this text.
		 * @param style
		 *            Style of the created text.
		 * @return The created {@link StyledText} widget.
		 */
		public static StyledText createScrollableStyledText(Composite parent, int style) {
			final StyledText text = new StyledText(parent, style);

			// If this text has no scroll bars, simply return it.
			if ((style & (SWT.H_SCROLL | SWT.V_SCROLL)) == 0) {
				return text;
			}

			// Otherwise, set up its listeners
			setUpScrollableListener(text);

			return text;
		}

		/**
		 * Creates a {@link Text} widget that knows how to hide its scroll bars.
		 * 
		 * @param parent
		 *            The parent composite for this text.
		 * @param style
		 *            Style of the created text.
		 * @return The created {@link Text} widget.
		 */
		public static Text createScrollableText(Composite parent, int style) {
			final Text text = new Text(parent, style);

			// If this text has no scroll bars, simply return it.
			if ((style & (SWT.H_SCROLL | SWT.V_SCROLL)) == 0) {
				return text;
			}

			// Otherwise, set up its listeners
			setUpScrollableListener(text);

			return text;
		}

		/**
		 * Sets up the listeners allowing us to hide the scroll bars of the given scrollable when they are not
		 * needed.
		 * 
		 * @param scrollable
		 *            The scrollable widget to setup.
		 */
		public static void setUpScrollableListener(final Scrollable scrollable) {
			final ControlAdapter resizeListener = new ScrollableResizeListener(scrollable);
			scrollable.addControlListener(resizeListener);

			final ModifyListener modifyListener = new ScrollableModifyListener(scrollable);
			if (scrollable instanceof Text) {
				((Text)scrollable).addModifyListener(modifyListener);
			} else if (scrollable instanceof StyledText) {
				((StyledText)scrollable).addModifyListener(modifyListener);
			}

			scrollable.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					scrollable.removeControlListener(resizeListener);
					if (scrollable instanceof Text) {
						((Text)scrollable).removeModifyListener(modifyListener);
					} else if (scrollable instanceof StyledText) {
						((StyledText)scrollable).removeModifyListener(modifyListener);
					}
				}
			});
		}

		/**
		 * Computes the size of the text displayed by the given {@link Text} widget.
		 * 
		 * @param widget
		 *            The widget on which is displayed the text.
		 * @param text
		 *            The actual displayed text.
		 * @return The actual size of the {@link Text} widget's content.
		 */
		protected static Point computeTextSize(Control widget, String text) {
			String[] lines = text.split("\r\n|\n|\r"); //$NON-NLS-1$

			String longestLine = ""; //$NON-NLS-1$
			if (lines.length > 0) {
				longestLine = lines[0];
				for (int i = 0; i < lines.length; i++) {
					if (lines[i].length() > longestLine.length()) {
						longestLine = lines[i];
					}
				}
			}
			GC gc = new GC(widget);
			gc.setFont(widget.getFont());
			final int textWidth = gc.stringExtent(longestLine).x;
			final int textHeight = gc.stringExtent("W").y * lines.length; //$NON-NLS-1$
			gc.dispose();

			return new Point(textWidth, textHeight);
		}

		/**
		 * This will be used as the resize listener for our scrollable text controls in order to determine whether
		 * the scroll bars are needed.
		 * 
		 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
		 */
		protected static class ScrollableModifyListener implements ModifyListener {
			/** The {@link Scrollable} widget against which this listener has been registered. */
			private final Scrollable text;

			/**
			 * Instantiates our modify listener for the given text widget.
			 * 
			 * @param text
			 *            The text widget to listen to.
			 */
			public ScrollableModifyListener(Scrollable text) {
				this.text = text;
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				final Rectangle clientArea = text.getClientArea();
				final String currentText;
				if (text instanceof Text) {
					currentText = ((Text)text).getText();
				} else if (text instanceof StyledText) {
					currentText = ((StyledText)text).getText();
				} else {
					return;
				}
				final Point textSize = computeTextSize(text, currentText);
				if (clientArea.width > textSize.x && text.getHorizontalBar() != null) {
					text.getHorizontalBar().setVisible(false);
				} else if (text.getHorizontalBar() != null) {
					text.getHorizontalBar().setVisible(true);
				}
				if (clientArea.height > textSize.y && text.getVerticalBar() != null) {
					text.getVerticalBar().setVisible(false);
				} else if (text.getVerticalBar() != null) {
					text.getVerticalBar().setVisible(true);
				}
			}
		}

		/**
		 * This will be used as the resize listener for our scrollable text controls in order to determine whether
		 * the scroll bars are needed.
		 * 
		 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
		 */
		protected static class ScrollableResizeListener extends ControlAdapter {
			/** Keeps a reference to the last size we computed. */
			private Point lastSize;

			/** Keeps a reference to the last text we computed a size for. */
			private String lastText;

			/** The {@link Scrollable} widget against which this listener has been registered. */
			private final Scrollable text;

			/**
			 * Instantiates our resize listener for the given text widget.
			 * 
			 * @param text
			 *            The text widget to listen to.
			 */
			public ScrollableResizeListener(Scrollable text) {
				this.text = text;
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ControlAdapter#controlResized(org.eclipse.swt.events.ControlEvent)
			 */
			@Override
			public void controlResized(ControlEvent e) {
				final Rectangle clientArea = text.getClientArea();
				final String currentText;
				if (text instanceof Text) {
					currentText = ((Text)text).getText();
				} else if (text instanceof StyledText) {
					currentText = ((StyledText)text).getText();
				} else {
					return;
				}
				Point textSize = lastSize;
				if (textSize == null || !lastText.equals(currentText)) {
					textSize = computeTextSize(text, currentText);
					lastText = currentText;
					lastSize = textSize;
				}
				if (clientArea.width > textSize.x && text.getHorizontalBar() != null) {
					text.getHorizontalBar().setVisible(false);
				} else if (text.getHorizontalBar() != null) {
					text.getHorizontalBar().setVisible(true);
				}
				if (clientArea.height > textSize.y && text.getVerticalBar() != null) {
					text.getVerticalBar().setVisible(false);
				} else if (text.getVerticalBar() != null) {
					text.getVerticalBar().setVisible(true);
				}
			}
		}

		/**
		 * This subclass of a source viewer will only show its scroll bars if they are needed.
		 * 
		 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
		 */
		protected static class ScrollableSourceViewer extends SourceViewer {
			/**
			 * Constructs a new source viewer. The vertical ruler is initially visible. The viewer has not yet
			 * been initialized with a source viewer configuration.
			 * 
			 * @param parent
			 *            the parent of the viewer's control.
			 * @param ruler
			 *            the vertical ruler used by this source viewer.
			 * @param styles
			 *            the SWT style bits for the viewer's control,
			 *            <em>if <code>SWT.WRAP</code> is set then a custom document adapter needs to be provided, see {@link #createDocumentAdapter()}.
			 */
			public ScrollableSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
				super(parent, ruler, styles);
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.text.TextViewer#createTextWidget(org.eclipse.swt.widgets.Composite, int)
			 */
			@Override
			protected StyledText createTextWidget(Composite parent, int styles) {
				return super.createTextWidget(parent, styles);
			}
		}
}
