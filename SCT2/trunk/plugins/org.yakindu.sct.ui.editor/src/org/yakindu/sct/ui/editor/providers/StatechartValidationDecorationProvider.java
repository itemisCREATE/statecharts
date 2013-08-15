/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.validation.IMarkerType;

import de.itemis.gmf.runtime.commons.decorators.AbstractMarkerBasedDecorationProvider;

public class StatechartValidationDecorationProvider extends AbstractMarkerBasedDecorationProvider implements
		IDecoratorProvider, IMarkerType {

	private static final String KEY = "org.yakindu.sct.ui.editor.validation";

	@Override
	protected boolean shouldInstall(IEditorPart part) {
		return part instanceof StatechartDiagramEditor;
	}

	@Override
	protected String getDecoratorKey() {
		return KEY;
	}

	@Override
	protected StatusDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new ValidationDecorator(decoratorTarget);
	}

	public static class ValidationDecorator extends StatusDecorator {

		public ValidationDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		@Override
		protected void createDecorators(View view, List<IMarker> markers) {
			String elementId = ViewUtil.getIdStr(view);
			if (elementId == null) {
				return;
			}
			int severity = IMarker.SEVERITY_INFO;
			IMarker foundMarker = null;
			Label toolTip = null;
			for (int i = 0; i < markers.size(); i++) {
				IMarker marker = markers.get(i);
				String attribute = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
						"");
				if (attribute.equals(elementId)) {
					int nextSeverity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
					Image nextImage = getImage(nextSeverity);
					if (foundMarker == null) {
						foundMarker = marker;
						toolTip = new Label(marker.getAttribute(IMarker.MESSAGE, ""), //$NON-NLS-1$
								nextImage);
					} else {
						if (toolTip.getChildren().isEmpty()) {
							Label comositeLabel = new Label();
							FlowLayout fl = new FlowLayout(false);
							fl.setMinorSpacing(0);
							comositeLabel.setLayoutManager(fl);
							comositeLabel.add(toolTip);
							toolTip = comositeLabel;
						}
						toolTip.add(new Label(marker.getAttribute(IMarker.MESSAGE, ""), //$NON-NLS-1$
								nextImage));
					}
					severity = (nextSeverity > severity) ? nextSeverity : severity;
				}
			}
			if (foundMarker == null) {
				return;
			}

			if (view instanceof Edge) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(getImage(severity), 50, true));
				getDecoration().setToolTip(toolTip);
			} else {
				int margin = view.getElement() instanceof Pseudostate || view.getElement() instanceof FinalState ? 0
						: -1;
				setDecoration(getDecoratorTarget().addShapeDecoration(getImage(severity),
						IDecoratorTarget.Direction.NORTH_EAST, margin, true));
				getDecoration().setToolTip(toolTip);
			}
		}

		@Override
		protected String getMarkerType() {
			return SCT_MARKER_TYPE;
		}

		private Image getImage(int severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IMarker.SEVERITY_WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
		}
	}
}
