/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.impl;

import java.io.PrintWriter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.yakindu.sct.generator.core.GeneratorActivator;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSExecModelGenerator implements ISCTGenerator {

	private static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";

	protected abstract void generate(ExecutionFlow flow, GeneratorEntry entry);

	public final void generate(GeneratorEntry entry) {
		generate(createExecutionFlow(entry.getStatechart()), entry);
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	protected ExecutionFlow createExecutionFlow(Statechart statechart) {
		Injector injector = Guice.createInjector(new SequencerModule());
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow, "Error creation ExecutionFlow");
		return flow;
	}

	protected void showErrorDialog(Throwable t) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		ErrorDialog.openError(shell, "Generator Error",
				"Error executing generator", new Status(IStatus.ERROR,
						GeneratorActivator.PLUGIN_ID, t.getMessage()));
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	private MessageConsoleStream createConsoleStream() {
		MessageConsole console = findConsole(SCT_GENERATOR_CONSOLE);
		MessageConsoleStream out = console.newMessageStream();
		return out;
	}

	protected void writeToConsole(Throwable t) {
		MessageConsoleStream createConsoleStream = createConsoleStream();
		createConsoleStream.setColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		PrintWriter printWriter = new PrintWriter(createConsoleStream);
		t.printStackTrace(printWriter);
		printWriter.flush();
		printWriter.close();
	}

	protected void writeToConsole(String line) {
		createConsoleStream().println(line);
	};

}
