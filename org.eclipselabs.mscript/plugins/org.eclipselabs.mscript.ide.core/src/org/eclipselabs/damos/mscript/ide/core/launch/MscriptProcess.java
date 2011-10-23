/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.ide.core.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipselabs.damos.mscript.interpreter.IFunctionObject;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;

/**
 * @author Andreas Unger
 *
 */
public class MscriptProcess implements IProcess {

	private ILaunch launch;
	private String name;

	private MscriptThread executionThread;
	private boolean terminated;
	private IStatus status;

	/**
	 * 
	 */
	public MscriptProcess(ILaunch launch, String name) {
		this.launch = launch;
		this.name = name;
		launch.addProcess(this);
		fireCreationEvent();
	}

	public ILaunch getLaunch() {
		return launch;
	}
	
	public String getLabel() {
		return name;
	}

	public void run(IInterpreterContext interpreterContext, IFunctionObject functionObject, IFile inputFile, IFile outputFile) {
		executionThread = new MscriptThread(interpreterContext, functionObject, inputFile, outputFile);
		executionThread.addExecutionListener(new IMscriptExecutionListener() {
			
			public void handleSimulationEvent(MscriptExecutionEvent event) {
				status = event.getStatus();
				terminated = true;
				fireTerminateEvent();
			}
			
		});
		executionThread.start();
	}
	
	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		executionThread.getInterpreterContext().setCanceled(true);
		executionThread.interrupt();
	}

	public String getAttribute(String key) {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public int getExitValue() throws DebugException {
		return status.isOK() ? 0 : 1;
	}

	/**
	 * Fires a creation event.
	 */
	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	/**
	 * Fires a terminate event.
	 */
	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/**
	 * Fires the given debug event.
	 * 
	 * @param event debug event to fire
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin manager= DebugPlugin.getDefault();
		if (manager != null) {
			manager.fireDebugEventSet(new DebugEvent[] { event });
		}
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

}
