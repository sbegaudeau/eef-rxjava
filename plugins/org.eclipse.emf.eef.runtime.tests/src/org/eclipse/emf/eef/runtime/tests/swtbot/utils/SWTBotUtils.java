/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.runtime.tests.swtbot.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SWTBotUtils {
	/**
	 * SWTWorkbenchBot
	 */
	private static SWTWorkbenchBot bot = new SWTWorkbenchBot();


	/**
	 * Press the enter key
	 * 
	 * @param widget
	 * @throws Exception
	 */
	public static void pressEnterKey(final Widget widget) {
		UIThreadRunnable.asyncExec(new VoidResult() {
			public void run() {
				widget.notifyListeners(SWT.Traverse, keyEvent(SWT.NONE, SWT.CR,
						SWT.Selection, widget));
			}
		});
	}

	/**
	 * @param c
	 *            the character.
	 * @param modificationKey
	 *            the modification key.
	 * @param keyCode
	 *            the keycode.
	 * @return a key event with the specified keys.
	 * @see Event#keyCode
	 * @see Event#character
	 * @see Event#stateMask
	 * @since 1.2
	 */
	private static Event keyEvent(int modificationKey, char c, int keyCode,
			Widget widget) {
		Event keyEvent = createEvent(widget);
		keyEvent.stateMask = modificationKey;
		keyEvent.character = c;
		keyEvent.keyCode = keyCode;

		return keyEvent;
	}

	private static Event createEvent(Widget widget) {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = widget;
		event.display = bot.getDisplay();
		return event;
	}




}
