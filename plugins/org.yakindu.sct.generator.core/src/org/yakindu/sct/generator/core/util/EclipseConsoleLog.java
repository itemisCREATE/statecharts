package org.yakindu.sct.generator.core.util;

import java.io.PrintWriter;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.yakindu.sct.generator.core.impl.IGeneratorLog;

public class EclipseConsoleLog implements IGeneratorLog {
	
	public static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";
	
	private MessageConsoleStream info;
	private MessageConsoleStream error;
	
	public EclipseConsoleLog() {
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
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (SCT_GENERATOR_CONSOLE.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			} 
		}
		MessageConsole myConsole = new MessageConsole(SCT_GENERATOR_CONSOLE, null);
		conMan.addConsoles(new IConsole[]{myConsole});
		return myConsole;
	}
	public void close() throws Throwable {
		info.close();
		error.close();

	}

	@Override
	public void writeToConsole(Throwable t) {
		if (error != null && !error.isClosed() && PlatformUI.isWorkbenchRunning()) {
			PrintWriter printWriter = new PrintWriter(error);
			t.printStackTrace(printWriter);
			printWriter.flush();
			printWriter.close();
		}

	}

	@Override
	public void writeToConsole(String line) {
		if (info != null && !info.isClosed() && PlatformUI.isWorkbenchRunning()) {
			info.println(line);
		}

	}
}