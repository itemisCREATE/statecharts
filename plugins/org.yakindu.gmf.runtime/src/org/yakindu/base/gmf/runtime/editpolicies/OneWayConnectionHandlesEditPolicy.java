/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.gmf.runtime.editpolicies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;

/**
 * Shows the connection handles only for one direction
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
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
