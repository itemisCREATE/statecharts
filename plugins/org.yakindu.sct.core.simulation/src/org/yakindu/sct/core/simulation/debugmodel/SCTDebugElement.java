package org.yakindu.sct.core.simulation.debugmodel;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class SCTDebugElement extends PlatformObject implements
		IDebugElement {

	protected IDebugTarget target;

	public SCTDebugElement(IDebugTarget target) {
		this.target = target;
	}

	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

	public IDebugTarget getDebugTarget() {
		return target;
	}


	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IDebugElement.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}

	protected void fireEvent(DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
	}

	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	public void fireResumeEvent(int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
	}

	public void fireSuspendEvent(int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
	}

	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}
}
