/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.breakpoints;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;
import org.yakindu.sct.simulation.ui.SimulationImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

import de.itemis.gmf.runtime.commons.decorators.AbstractMarkerBasedDecorationProvider;

/**
 * Provides breakpoint decoration.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BreakpointDecorationProvider extends AbstractMarkerBasedDecorationProvider {

	@Override
	protected boolean shouldInstall(IEditorPart part) {
		return part instanceof StatechartDiagramEditor;
	}

	@Override
	protected String getDecoratorKey() {
		return "org.yakindu.sct.simulation.ui.breakpoints";
	}

	@Override
	protected StatusDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new BreakpointStatusDecorator(decoratorTarget);
	}

	public static class BreakpointStatusDecorator extends StatusDecorator {

		public BreakpointStatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		private Image getImage(IMarker marker) {
			boolean enabled = marker.getAttribute(IBreakpoint.ENABLED, false);
			return enabled ? SimulationImages.BREAKPOINT_ENABLED.image() : SimulationImages.BREAKPOINT_DISABLED.image();
		}

		@Override
		protected String getMarkerType() {
			return SCTBreakpoint.MARKER_ID;
		}

		@Override
		protected void createDecorators(View view, List<IMarker> markers) {
			String elementId = ViewUtil.getIdStr(view);
			if (elementId == null) {
				return;
			}
			for (IMarker marker : markers) {
				String attribute = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
						"");
				if (attribute.equals(elementId)) {
					if (view instanceof Edge) {
						setDecoration(getDecoratorTarget().addConnectionDecoration(getImage(marker), 75, true));
					} else {
						setDecoration(getDecoratorTarget().addShapeDecoration(getImage(marker),
								IDecoratorTarget.Direction.NORTH_WEST, 0, true));
					}
					Label toolTip = new Label(marker.getAttribute(IMarker.MESSAGE, ""), getImage(marker));
					getDecoration().setToolTip(toolTip);
				}
			}
		}
	}
}
