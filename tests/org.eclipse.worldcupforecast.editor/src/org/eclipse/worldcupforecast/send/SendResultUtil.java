/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.worldcupforecast.send;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.worldcupforecast.utils.Urls;

/**
 * Utility class to send the result file.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public final class SendResultUtil {

	public static void sendDialog(final Shell shell, final String username, final File file) {
		shell.setText("Upload current file"); //$NON-NLS-1$
		shell.setBounds(100, 100, 400, 135);
		shell.setLayout(new FormLayout());
		shell.setMinimumSize(700, 135);

		Button okButton = new Button(shell, SWT.PUSH);
		okButton.setText("Upload"); //$NON-NLS-1$
		FormData formData = new FormData();
		formData.right = new FormAttachment(100, -5);
		formData.bottom = new FormAttachment(100, -5);
		okButton.setLayoutData(formData);

		Button cancelButton = new Button(shell, SWT.PUSH);
		cancelButton.setText("Cancel"); //$NON-NLS-1$
		formData = new FormData();
		formData.right = new FormAttachment(okButton, -5);
		formData.bottom = new FormAttachment(100, -5);
		cancelButton.setLayoutData(formData);

		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});

		Composite mainComposite = new Composite(shell, SWT.NONE);
		mainComposite.setLayout(new FillLayout(SWT.VERTICAL));
		
		final Label responseLabel = new Label(mainComposite, SWT.NONE);
		responseLabel.setText("Enter the password you used the first time you played, otherwise enter a new one (and don't forget it! :) )"); //$NON-NLS-1$

		Composite composite = new Composite(mainComposite, SWT.NONE);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite.setLayout(gridLayout);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Password: "); //$NON-NLS-1$

		final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		text.setLayoutData(gridData);

		formData = new FormData();
		formData.top = new FormAttachment(0, 5);
		formData.bottom = new FormAttachment(cancelButton, -5);
		formData.left = new FormAttachment(0, 5);
		formData.right = new FormAttachment(100, -5);
		mainComposite.setLayoutData(formData);

		

		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String response = ""; //$NON-NLS-1$
				try {
					if (checkText(text.getText())) {
						response = sendData(username, text.getText(), file);
					} else {
						response = "invalid password"; //$NON-NLS-1$
					}
				} catch (IOException exception) {
					response = exception.getMessage();
				}

				if (response.startsWith("INFO:")) { //$NON-NLS-1$
					responseLabel.setText(response.substring(5));
					shell.close();
				} else if (response.startsWith("ERROR:")) { //$NON-NLS-1$
					responseLabel.setText(response.substring(6));
				}
			}
		});

		shell.open();
	}

	public static boolean checkText(final String text) {
		boolean result = false;
		result = text.matches("[0-9a-zA-Z-_]+") && text.length() > 2; //$NON-NLS-1$
		return result;
	}

	/**
	 * Send the result file.
	 * 
	 * @param username
	 *            The username
	 * @param password
	 *            The password
	 * @param file
	 *            The file to send
	 * @return The confirmation message from the server
	 * @throws IOException
	 *             In case of error
	 */
	private static String sendData(final String username, final String password, final File file)
			throws IOException {

		String result = ""; //$NON-NLS-1$
		URL url = new URL(Urls.URL_CommitPage);
		//URL url = new URL("http://alex.lagarde.free.fr/worldCup/commitHandler.php");
		ClientHttpRequest httpRequest = new ClientHttpRequest(url);
		httpRequest.setParameter("username", username); //$NON-NLS-1$
		httpRequest.setParameter("password", password); //$NON-NLS-1$
		httpRequest.setParameter("prognosticfile", file); //$NON-NLS-1$
		InputStream stream = httpRequest.post();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		String str = ""; //$NON-NLS-1$
		while ((str = bufferedReader.readLine()) != null) {
			result += str;
		}
		bufferedReader.close();

		return result;
	}
}
