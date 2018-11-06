/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.builder.console;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.yakindu.sct.generator.builder.BuilderActivator;
import org.yakindu.sct.generator.core.console.IConsoleLogger;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
public class EclipseConsoleLogger implements IConsoleLogger {

	public static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";

	private MessageConsoleStream info;
	private MessageConsoleStream error;

	public EclipseConsoleLogger() {
		init();
	}

	public void init() {
		if (Platform.isRunning()) {
			info = getConsole().newMessageStream();
			error = getConsole().newMessageStream();
			error.setActivateOnWrite(true);
		}
	}

	private MessageConsole getConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();
		IConsole[] existing = consoleManager.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (SCT_GENERATOR_CONSOLE.equals(existing[i].getName())) {
				MessageConsole console = (MessageConsole) existing[i];
				consoleManager.showConsoleView(console);
			}
		}
		MessageConsole newConsole = new MessageConsole(SCT_GENERATOR_CONSOLE, null);
		consoleManager.addConsoles(new IConsole[] { newConsole });
		consoleManager.showConsoleView(newConsole);
		return newConsole;
	}

	public void close() {
		try {
			info.close();
			error.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void logError(Throwable t) {
		if (error != null && !error.isClosed() && PlatformUI.isWorkbenchRunning()) {
			PrintWriter printWriter = new PrintWriter(error);
			t.printStackTrace(printWriter);
			printWriter.flush();
			printWriter.close();
			BuilderActivator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, BuilderActivator.PLUGIN_ID, t.getMessage(), t));
		}
	}

	@Override
	public void log(String line) {
		if (info != null && !info.isClosed() && PlatformUI.isWorkbenchRunning()) {
			info.println(line);
		}

	}
}