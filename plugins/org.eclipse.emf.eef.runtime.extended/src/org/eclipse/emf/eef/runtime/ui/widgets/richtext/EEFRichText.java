package org.eclipse.emf.eef.runtime.ui.widgets.richtext;

import org.eclipse.epf.common.utils.XMLUtil;
import org.eclipse.epf.richtext.RichText;
import org.eclipse.epf.richtext.RichTextPlugin;
import org.eclipse.epf.richtext.actions.FindReplaceAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

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

}
