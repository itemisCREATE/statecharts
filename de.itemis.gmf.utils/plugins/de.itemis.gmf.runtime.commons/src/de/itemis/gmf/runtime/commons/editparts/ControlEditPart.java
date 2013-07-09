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
package de.itemis.gmf.runtime.commons.editparts;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class ControlEditPart extends ShapeEditPart {

	private ControlWrapper wrapper;

	public abstract Control createControl(Composite parent);

	public ControlEditPart(View view) {
		super(view);
	}

	@Override
	protected IFigure getLayer(Object layer) {
		return super.getLayer(layer);
	}

	@Override
	protected IFigure createFigure() {
		Composite composite = (Composite) getViewer().getControl();
		wrapper = new ControlWrapper(createControl(composite));
		return wrapper;
	}

	public class ControlWrapper extends Figure {

		private Control control;

		public ControlWrapper(Control control) {
			this.control = control;
		}

		public Dimension getPreferredSize(int wHint, int hHint) {
			Point p = control.computeSize(wHint, hHint);
			return new Dimension(p.x, p.y);
		}

		@Override
		public void setBounds(Rectangle rect) {
			super.setBounds(rect);
			rect = rect.getCopy();
			translateToAbsolute(rect);
			control.setBounds(rect.x, rect.y, rect.width, rect.height);
			super.setBounds(rect);
		}
	}

}
