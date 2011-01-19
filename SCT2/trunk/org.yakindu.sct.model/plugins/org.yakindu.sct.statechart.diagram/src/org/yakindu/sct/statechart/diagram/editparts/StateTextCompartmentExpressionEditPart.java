package org.yakindu.sct.statechart.diagram.editparts;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.parser.AttributeParser;
import org.yakindu.sct.statechart.diagram.xtext.integration.XTextDirectEditManager;

public class StateTextCompartmentExpressionEditPart extends ShapeNodeEditPart
		implements ITextAwareEditPart {

	private final XTextDirectEditManager manager;

	private EAttribute feature;

	private final CellEditorLocator editorLocator = new CellEditorLocator() {
		@Override
		public void relocate(CellEditor celleditor) {
			Rectangle figureRectangle = getFigure().getBounds().getCopy();
			getFigure().translateToAbsolute(figureRectangle);
			celleditor.getControl().setBounds(figureRectangle.x,
					figureRectangle.y, figureRectangle.width,
					figureRectangle.height);
		}
	};

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view);
		manager = createDirectEditManager();
		feature = StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION;
	}

	protected XTextDirectEditManager createDirectEditManager() {
		return new XTextDirectEditManager(this, DiagramActivator.getDefault()
				.getExpressionsInjector(), editorLocator, SWT.MULTI);
	}

	@Override
	public String getEditText() {
		return getParser().getEditString(
				new EObjectAdapter(resolveSemanticElement()), -1);
	}

	@Override
	public void setLabelText(String text) {
		getWrappingLabel().setText(text);
	}

	private WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getFigure().getChildren().get(0);
	}

	@Override
	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	@Override
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	@Override
	public IParser getParser() {
		return new AttributeParser(
				StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION);
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure nodeFigure = new NodeFigure();
		nodeFigure.setBackgroundColor(ColorConstants.white);
		nodeFigure.setLayoutManager(new StackLayout());
		WrappingLabel label = new WrappingLabel();
		label.setBackgroundColor(ColorConstants.white);
		nodeFigure.add(label);
		return nodeFigure;
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() == feature) {
			updateLabelText();
		}
		super.handleNotificationEvent(event);
	}

	private void updateLabelText() {
		getWrappingLabel().setText(getEditText());
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {
				@Override
				public void run() {
					if (isActive()) {
						if (theRequest.getExtendedData().get(
								REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character
								&& manager instanceof XTextDirectEditManager) {
							Character initialChar = (Character) theRequest
									.getExtendedData()
									.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							(manager).show(initialChar);
						} else {
							manager.show();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
