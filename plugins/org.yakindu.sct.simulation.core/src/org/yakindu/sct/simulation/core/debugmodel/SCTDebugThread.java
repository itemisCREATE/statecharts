package org.yakindu.sct.simulation.core.debugmodel;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.yakindu.sct.simulation.core.ISGraphExecutionFacade;
import org.yakindu.sct.simulation.core.SGraphSimulationSession;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugThread extends PlatformObject implements IThread {

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;
	private Thread thread;
	private SGraphSimulationSession session;
	private final SCTDebugTarget target;

	public SCTDebugThread(SCTDebugTarget target, ISGraphExecutionFacade facade) {
		this.target = target;
		session = new SGraphSimulationSession(facade);
		thread = new Thread(session);
		thread.start();
		session.start();
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		return new IStackFrame[] {};
	}

	public boolean hasStackFrames() throws DebugException {
		return false;
	}

	public int getPriority() throws DebugException {
		return 0;
	}

	public String getName() throws DebugException {
		return IDebugConstants.DEBUG_THREAD;
	}

	public IBreakpoint[] getBreakpoints() {
		return null;
	}

	public boolean canResume() {
		return suspended && !terminated;
	}

	public boolean canSuspend() {
		return !suspended && !terminated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
		session.resume();
		suspended = false;
	}

	public void suspend() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
		session.suspend();
		suspended = true;
	}

	public boolean canStepInto() {
		return false;
	}

	public boolean canStepOver() {
		return isSuspended() && !isTerminated();
	}

	public boolean canStepReturn() {
		return false;
	}

	public boolean isStepping() {
		return stepping;
	}

	public void stepInto() throws DebugException {
	}

	public void stepOver() throws DebugException {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
		session.singleStep();
	}

	public void stepReturn() throws DebugException {
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE));
		terminated = true;
		session.terminate();
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		return null;
	}

	public ILaunch getLaunch() {
		return getDebugTarget().getLaunch();
	}

	protected void fireEvent(DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
	}

	public String getModelIdentifier() {
		return IDebugConstants.DEBUG_THREAD;
	}

	public IDebugTarget getDebugTarget() {
		return target;
	}
}
