package org.yakindu.sct.core.simulation.debugmodel;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.yakindu.sct.core.simulation.ISGraphExecutionFacade;
import org.yakindu.sct.core.simulation.SGraphSimulationSession;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SCTDebugThread extends SCTDebugElement implements IThread {

	private boolean stepping = false;
	private boolean terminated;
	private boolean suspended;
	private Thread thread;
	private SGraphSimulationSession session;

	public SCTDebugThread(SCTDebugTarget target, ISGraphExecutionFacade facade) {
		super(target);
		session = new SGraphSimulationSession(facade);
		thread = new Thread(session);
		thread.start();
		session.start();
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		return null;
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
		return suspended;
	}

	public boolean canSuspend() {
		return !suspended && !terminated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		session.resume();
		suspended = false;
	}

	public void suspend() throws DebugException {
		session.suspend();
		suspended = true;
	}

	public boolean canStepInto() {
		return false;
	}

	public boolean canStepOver() {
		return isSuspended();
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
		session.terminate();
		terminated = true;
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		return null;
	}

	@Override
	public ILaunch getLaunch() {
		return getDebugTarget().getLaunch();
	}
}
