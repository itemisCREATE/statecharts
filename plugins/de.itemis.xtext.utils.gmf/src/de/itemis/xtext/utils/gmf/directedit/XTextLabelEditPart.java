package de.itemis.xtext.utils.gmf.directedit;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author muelder
 * 
 */
public abstract class XTextLabelEditPart extends LabelEditPart implements
		IXTextAwareEditPart {

	private DirectEditManager manager;

	public XTextLabelEditPart(View view) {
		super(view);
	}

	@Override
	protected IFigure createFigure() {
		LabelEx label = new LabelEx();
		label.setLabelAlignment(PositionConstants.LEFT);
		label.setTextAlignment(PositionConstants.TOP);
		return label;
	}

	@Override
	public LabelEx getFigure() {
		return (LabelEx) super.getFigure();
	}

	@Override
	public void setLabelText(String text) {
		getFigure().setText(text);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		getFigure().setText(getEditText());
	}

	protected abstract DirectEditManager createXTextDirectEditManager();

	@Override
	protected void performDirectEditRequest(Request request) {
		if (manager == null) {
			manager = createXTextDirectEditManager();
		}
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {
				@Override
				public void run() {
					if (isActive()) {
						if (theRequest.getExtendedData().get(
								REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character
								&& manager instanceof TextDirectEditManager) {
							Character initialChar = (Character) theRequest
									.getExtendedData()
									.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);

							((TextDirectEditManager) manager).show(initialChar);

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
