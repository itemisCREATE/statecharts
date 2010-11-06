package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.model.statechart.statechart.StatechartPackage;
import org.yakindu.sct.statechart.ExpressionsRuntimeModule;

public class StateTextCompartmentExpressionEditPart extends TextAwareShapeNodeEditPart {

	// TODO Duplicate code
	private final CellEditorLocator editorLocator = new CellEditorLocator() {
		@Override
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle figureRectangle = getFigure().getBounds().getCopy();
			getFigure().translateToAbsolute(figureRectangle);
			text.setBounds(figureRectangle.x, figureRectangle.y, figureRectangle.width, figureRectangle.height);
		}
	};

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view, StatechartPackage.Literals.STATE__EXPRESSION);
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		return new de.itemis.xtext.gmf.integration.directediting.XTextDirectEditManager(this,
				new ExpressionsRuntimeModule(), editorLocator);
	}

	@Override
	protected WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getPrimaryShape();
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.add(getPrimaryShape());
		return figure;
	}

	private IFigure getPrimaryShape() {
		return new WrappingLabel();
	}

}
