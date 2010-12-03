package org.eclipse.emf.eef.runtime.ui.widgets.richtext;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epf.common.utils.XMLUtil;
import org.eclipse.epf.richtext.RichText;
import org.eclipse.epf.richtext.RichTextCommand;
import org.eclipse.epf.richtext.RichTextPlugin;
import org.eclipse.epf.richtext.actions.CutAction;
import org.eclipse.epf.richtext.actions.FindReplaceAction;
import org.eclipse.epf.richtext.actions.PasteAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mika�l Barbero</a>
 */
public class EEFRichText extends RichText {

	public EEFRichText(Composite parent, int style) {
		super(parent, style);
		debug = RichTextPlugin.getDefault().isDebugging();
		logger = RichTextPlugin.getDefault().getLogger();
		findReplaceAction = new FindReplaceAction(this);
		rteFolder = RichTextPlugin.getDefault().getInstallPath() + "rte/"; //$NON-NLS-1$		
		rteURL = XMLUtil.escape("file://" + rteFolder); //$NON-NLS-1$
		setBasePath(basePath);

		try {
			editor = new Browser(parent, SWT.BORDER);
			if (debug) {
				printDebugMessage("RichText", "basePath=" + basePath); //$NON-NLS-1$ //$NON-NLS-2$
			}
			editor.setLayoutData(new GridData(GridData.FILL_BOTH));
			editor.setData(PROPERTY_NAME, this);
			init(parent, style);
		} catch (Exception e) {
			editor = null;
			String msg = "Failed to create RichText with basePath=" + basePath; //$NON-NLS-1$
			logger.logError(msg, e);
			if (debug) {
				System.out.println(msg);
				e.printStackTrace();
			}
		}
	}

	public EEFRichText(Composite parent, int style, String basePath) {
		super(parent, style, basePath);
	}

	protected void init(Composite parent, int style) throws Exception {
		addProgressListener();
		super.init(parent, style);
	}
	
	protected void addProgressListener() {
		editor.addProgressListener(new ProgressListener() {
			public void completed(ProgressEvent event) {
				if (!initialized) {
					initialized = true;
					if (debug) {
						printDebugMessage(
								"statusTextListener", "STATUS_INITIALIZED"); //$NON-NLS-1$ //$NON-NLS-2$
					}
					if (!Platform.getOS().equals("win32")) { //$NON-NLS-1$
						// Workaround Mozilla'a IFRAME
						// height issue.
						executeCommand(RichTextCommand.SET_HEIGHT,
								"" + editor.getBounds().height); //$NON-NLS-1$
					}
					executeCommand(RichTextCommand.SET_TEXT,
							currentText);
					editor.redraw();
					if (initializedWithFocus) {
						setFocus();
					}
					if (!editable) {
						executeCommand(
								RichTextCommand.SET_EDITABLE,
								"" + editable); //$NON-NLS-1$
					}
				}
			}
			
			public void changed(ProgressEvent event) {
				// do nothing
			}
		});
	}
	
	/**
	 * Adds the listener to monitor events and status sent by the underlying
	 * DHTML editor.
	 */
	protected void addStatusTextListener() {
		editor.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				String eventText = event.text;
				int eventTextLength = eventText.length();
				if (eventText.startsWith(STATUS_PREFIX)
						&& eventTextLength > STATUS_PREFIX_LENGTH) {
					try {
						processingJSEvent = true;
						int endStatusIndex = STATUS_PREFIX_LENGTH + 1;
						if (eventText.length() > STATUS_PREFIX_LENGTH + 1
								&& Character.isDigit(eventText
										.charAt(endStatusIndex))) {
							endStatusIndex++;
						}
						int statusType = Integer.parseInt(eventText.substring(
								STATUS_PREFIX_LENGTH, endStatusIndex));
						switch (statusType) {
						case STATUS_NOP:
							break;
						case STATUS_INITIALIZED:
							break;
						case STATUS_MODIFIED:
							if (debug) {
								printDebugMessage(
										"statusTextListener", "STATUS_MODIFIED"); //$NON-NLS-1$ //$NON-NLS-2$
							}
							checkModify();
							break;
						case STATUS_GET_TEXT:
							if (eventTextLength >= STATUS_PREFIX_LENGTH + 2) {
								currentText = eventText
										.substring(STATUS_PREFIX_LENGTH + 2);
							} else {
								currentText = ""; //$NON-NLS-1$
							}
							if (debug) {
								printDebugMessage(
										"statusTextListener", //$NON-NLS-1$
										"STATUS_GET_TEXT, currentText=", currentText); //$NON-NLS-1$
							}
							break;
						case STATUS_KEY_DOWN:
							if (eventTextLength >= STATUS_PREFIX_LENGTH + 2) {
								String cmd = eventText
										.substring(STATUS_PREFIX_LENGTH + 2);
								if (debug) {
									printDebugMessage("statusTextListener", //$NON-NLS-1$
											"STATUS_KEY_DOWN, cmd=" + cmd); //$NON-NLS-1$
								}
								if (cmd.equals(RichTextCommand.COPY)) {
									setCopyURL();
								} else if (cmd.equals(RichTextCommand.CUT)) {
									setCopyURL();
									CutAction action = new CutAction(
											EEFRichText.this);
									action.execute(EEFRichText.this);
								} else if (cmd
										.equals(RichTextCommand.FIND_TEXT)) {
									getFindReplaceAction().execute(
											EEFRichText.this);
								} else if (cmd.equals(RichTextCommand.PASTE)) {
									PasteAction action = new PasteAction(
											EEFRichText.this);
									action.execute(EEFRichText.this);
								} else if (cmd.equals(RichTextCommand.SAVE)) {
									PlatformUI.getWorkbench()
											.getActiveWorkbenchWindow()
											.getActivePage().getActiveEditor()
											.doSave(null);
								} else if (cmd.equals(RichTextCommand.SAVE_ALL)) {
									PlatformUI.getWorkbench()
											.getActiveWorkbenchWindow()
											.getActivePage().saveAllEditors(
													false);
								}
							}
							break;
						case STATUS_KEY_UP:
							if (debug) {
								printDebugMessage("statusTextListener", //$NON-NLS-1$
										"STATUS_KEY_UP, modified=" + modified); //$NON-NLS-1$
							}
							checkModify();
							break;
						case STATUS_SELECT_TEXT:
							if (eventTextLength >= STATUS_PREFIX_LENGTH + 2) {
								String[] strings = eventText.substring(
										STATUS_PREFIX_LENGTH + 2).split(
										"\\$", 5); //$NON-NLS-1$
								try {
									richTextSelection.setFontName(strings[0]);
									richTextSelection.setFontSize(strings[1]);
									richTextSelection.setBlockStyle(strings[2]);
									richTextSelection.setFlags(Integer
											.parseInt(strings[3]));
									richTextSelection.setText(strings[4]);
								} catch (NumberFormatException e) {
									logger.logError(e);
								}
								if (debug) {
									printDebugMessage(
											"selectionStatusListener", //$NON-NLS-1$
											"current selection is=" + richTextSelection); //$NON-NLS-1$
								}

								hasSelection = true;
								if (hasFocus())
									notifyListeners(SWT.SELECTED, new Event());
							} else {
								richTextSelection.setText(""); //$NON-NLS-1$
								hasSelection = false;
							}
							if (debug) {
								printDebugMessage(
										"statusTextListener", //$NON-NLS-1$
										"STATUS_SELECT_TEXT, selectedText=", richTextSelection.getText()); //$NON-NLS-1$
							}
							break;
						case STATUS_SELECT_CONTROL:
							if (debug) {
								printDebugMessage("statusTextListener", //$NON-NLS-1$
										"STATUS_SELECT_CONTROL, control selected"); //$NON-NLS-1$
							}
							hasSelection = true;
							break;
						case STATUS_SELECT_NONE:
							if (debug) {
								printDebugMessage("statusTextListener", //$NON-NLS-1$
										"STATUS_SELECT_NONE, no selection"); //$NON-NLS-1$
							}
							hasSelection = false;
							break;
						case STATUS_EXEC_CMD:
							if (eventTextLength >= STATUS_PREFIX_LENGTH + 3) {
								try {
									status = Integer.parseInt(eventText
											.substring(
													STATUS_PREFIX_LENGTH + 2,
													STATUS_PREFIX_LENGTH + 3));
								} catch (Exception e) {
									status = -1;
								}
							}
							if (debug && status != 1) {
								printDebugMessage("statusTextListener", //$NON-NLS-1$
										"STATUS_EXEC_CMD, status=" + status); //$NON-NLS-1$
							}
							break;
						case STATUS_REFORMAT_LINKS:
							if (debug) {
								printDebugMessage(
										"statusTextListener", "STATUS_REFORMAT_LINKS"); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (Platform.getOS().equals("win32")) { //$NON-NLS-1$ 
								// Workaround the drag and drop issue with DBCS
								// characters.
								if (modified) {
									setText(getText());
									modified = true;
								}
							}
							checkModify();
							break;
						}
					} catch (Exception e) {
					} finally {
						processingJSEvent = false;
					}
				}
			}
		});
	}
	
	private static final String STATUS_PREFIX = "$$$"; //$NON-NLS-1$

	private static final int STATUS_PREFIX_LENGTH = STATUS_PREFIX.length();

	private static final int STATUS_NOP = 0;

	private static final int STATUS_INITIALIZED = 1;

	private static final int STATUS_MODIFIED = 2;

	private static final int STATUS_GET_TEXT = 3;

	private static final int STATUS_KEY_DOWN = 4;

	private static final int STATUS_KEY_UP = 5;

	private static final int STATUS_SELECT_TEXT = 6;

	private static final int STATUS_SELECT_CONTROL = 7;

	private static final int STATUS_SELECT_NONE = 8;

	private static final int STATUS_EXEC_CMD = 9;

	private static final int STATUS_REFORMAT_LINKS = 10;
}
