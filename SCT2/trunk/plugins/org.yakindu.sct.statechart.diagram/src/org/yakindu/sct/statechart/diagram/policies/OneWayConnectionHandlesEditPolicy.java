package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;

/**
 * Shows the connection handles only for one direction
 * 
 * @author muelder
 * 
 */
public class OneWayConnectionHandlesEditPolicy extends
		ConnectionHandleEditPolicy {

	private final HandleDirection direction;

	public OneWayConnectionHandlesEditPolicy(HandleDirection direction) {
		this.direction = direction;
	}

	@Override
	protected String buildTooltip(HandleDirection direction) {
		if (direction == this.direction) {
			return super.buildTooltip(direction);
		}
		return null;
	}
}
