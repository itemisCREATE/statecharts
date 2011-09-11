package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISGraphExecutionFacade;
import org.yakindu.sct.simulation.core.ISGraphExecutionListener;
import org.yakindu.sct.simulation.core.SGraphSimulationSession;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugThread extends SCTDebugElement implements IThread,
		ISGraphExecutionListener {

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;
	private Thread thread;
	private SGraphSimulationSession session;
	private final SCTDebugTarget target;
	private final ISGraphExecutionFacade facade;
	private List<Vertex> activeStates = new ArrayList<Vertex>();

	public SCTDebugThread(SCTDebugTarget target, ISGraphExecutionFacade facade,
			String resourceString) {
		super(resourceString);
		this.target = target;
		this.facade = facade;
		session = new SGraphSimulationSession(facade);
		facade.addExecutionListener(this);
		thread = new Thread(session);
		thread.start();
		session.start();
	}

	public int getPriority() throws DebugException {
		return 0;
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		List<IStackFrame> stackFrames = new ArrayList<IStackFrame>();

		for (int i = activeStates.size() - 1; i >= 0; i--) {
			stackFrames.add(new SCTStackFrame(this, activeStates.get(i),
					getResourceString()));
		}
		return stackFrames.toArray(new IStackFrame[] {});
	}

	public boolean hasStackFrames() throws DebugException {
		return true;
	}

	@Override
	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

	@Override
	public void stateEntered(Vertex vertex) {
		activeStates.add(vertex);
	}

	@Override
	public void stateLeft(Vertex vertex) {
		activeStates.remove(vertex);

	}

	@Override
	public void transitionFired(Transition transition) {
		// Nothing to do
	}

	@Override
	public void variableValueChanged(String variableName, Object value) {
		// Nothing to do
	}

	@Override
	public void eventRaised(String eventName) {
		// Nothing to do
	}

	public String getName() throws DebugException {
		return "TODO";
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
		facade.removeExecutionListener(this);
		activeStates = Collections.emptyList();
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

	public IDebugTarget getDebugTarget() {
		return target;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == SGraphSimulationSession.class)
			return session;
		if (adapter == ISGraphExecutionFacade.class)
			return getDebugTarget().getAdapter(ISGraphExecutionFacade.class);
		return super.getAdapter(adapter);
	}

}
