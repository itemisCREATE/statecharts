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
package org.yakindu.sct.simulation.core.debugmodel;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTStackFrame extends SCTDebugElement implements IStackFrame {

	private final SCTDebugThread thread;
	private final NamedElement element;

	public SCTStackFrame(SCTDebugThread thread, NamedElement element, String resourceString) {
		super(thread.getDebugTarget(), resourceString);
		this.thread = thread;
		this.element = element;
	}

	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	public boolean isStepping() {
		return thread.isStepping();
	}

	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	public boolean canResume() {
		return thread.canResume();
	}

	public boolean canSuspend() {
		return thread.canSuspend();
	}

	public boolean isSuspended() {
		return thread.isSuspended();
	}

	public void resume() throws DebugException {
		thread.resume();
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));

	}

	public void suspend() throws DebugException {
		thread.suspend();
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
	}

	public boolean canTerminate() {
		return thread.canTerminate();
	}

	public boolean isTerminated() {
		return thread.isTerminated();
	}

	public void terminate() throws DebugException {
		thread.terminate();
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	public SCTDebugThread getThread() {
		return thread;
	}

	public IVariable[] getVariables() throws DebugException {
		return new IVariable[] {};
	}

	public boolean hasVariables() throws DebugException {
		return false;
	}

	public int getLineNumber() throws DebugException {
		return -1;
	}

	public int getCharStart() throws DebugException {
		return -1;
	}

	public int getCharEnd() throws DebugException {
		return -1;
	}

	public String getName() throws DebugException {
		return fullQfn(element);

	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[] {};
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public SCTDebugTarget getDebugTarget() {
		return (SCTDebugTarget) thread.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return thread.getLaunch();
	}

	public String getResourceString() {
		return element.eResource().getURI().toPlatformString(true);
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == EObject.class)
			return element;
		return super.getAdapter(adapter);
	}

	public NamedElement getState() {
		return element;
	}

}
