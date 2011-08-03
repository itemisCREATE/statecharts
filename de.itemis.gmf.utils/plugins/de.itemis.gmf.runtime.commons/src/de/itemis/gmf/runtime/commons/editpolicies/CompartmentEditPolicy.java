package de.itemis.gmf.runtime.commons.editpolicies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.RepositionEObjectCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.itemis.gmf.runtime.commons.commands.CompartmentChildCreateCommand;
import de.itemis.gmf.runtime.commons.commands.CompartmentRepositionEObjectCommand;

/**
 * @see http://wiki.eclipse.org/GMF/Recipes
 * 
 */
public class CompartmentEditPolicy extends
		org.eclipse.gef.editpolicies.FlowLayoutEditPolicy {

	private EStructuralFeature feature = null;

	@Override
	protected Command createAddCommand(EditPart child, EditPart after) {
//		int index = getHost().getChildren().indexOf(after);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		AddCommand command = new AddCommand(editingDomain, new EObjectAdapter(
				(View) getHost().getModel()), new EObjectAdapter(
				(View) child.getModel()), ViewUtil.APPEND);
		return new ICommandProxy(command);
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		ResizableEditPolicyEx policy = new ResizableEditPolicyEx();
		policy.setResizeDirections(0);
		return policy;
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected Command createMoveChildCommand(EditPart child, EditPart after) {

		int newIndex;
		int displacement;

		int childIndex = getHost().getChildren().indexOf(child);
		int afterIndex = getHost().getChildren().indexOf(after);

		if (afterIndex == -1) {
			newIndex = getHost().getChildren().size() - 1;
			displacement = newIndex - childIndex;
		} else {
			newIndex = afterIndex;
			displacement = afterIndex - childIndex;
			if (childIndex <= afterIndex) {
				newIndex--;
				displacement--;
			}
		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		RepositionEObjectCommand command = new CompartmentRepositionEObjectCommand(
				child, editingDomain, "", (EList) ((View) child.getParent()
						.getModel()).getElement().eGet(feature),
				((View) child.getModel()).getElement(), displacement, newIndex);

		eraseLayoutTargetFeedback(null);

		return new ICommandProxy(command);
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest viewAndElementRequest = (CreateViewAndElementRequest) request;
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
					.getEditingDomain();
			CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
					editingDomain, DiagramUIMessages.AddCommand_Label);

			Iterator<?> descriptors = viewAndElementRequest.getViewDescriptors().iterator();

			while (descriptors.hasNext()) {
				CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptors
						.next();

				CreateCommand createCommand = new CompartmentChildCreateCommand(
						editingDomain, descriptor, (View) (getHost().getModel()),
						getFeedbackIndexFor(viewAndElementRequest));

				cc.compose(createCommand);
			}
			return new ICommandProxy(cc.reduce());
		}
		return null;
	}

	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	@Override
	protected Command getOrphanChildrenCommand(Request request) {
		return null;
	}

	/**
	 * @param feature
	 *            has to be an EList
	 */
	public CompartmentEditPolicy(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

	@Override
	protected boolean isHorizontal() {
		IFigure figure = ((IGraphicalEditPart) getHost()).getContentPane();
		if (figure.getLayoutManager() instanceof OrderedLayout) {
			return ((OrderedLayout) figure.getLayoutManager()).isHorizontal();
		}
		return true;
	}

	protected int getFeedbackIndexFor(CreateViewAndElementRequest request) {
		List<?> children = getHost().getChildren();
		if (children.isEmpty())
			return -1;

		Transposer transposer = new Transposer();
		transposer.setEnabled(!isHorizontal());

		Point p = transposer.t(request.getLocation());

		// Current row bottom, initialize to above the top.
		int rowBottom = Integer.MIN_VALUE;
		int candidate = -1;
		for (int i = 0; i < children.size(); i++) {
			EditPart child = (EditPart) children.get(i);
			Rectangle rect = transposer
					.t(getAbsoluteBounds(((IGraphicalEditPart) child)));
			if (rect.y > rowBottom) {
				/*
				 * We are in a new row, so if we don't have a candidate but yet
				 * are within the previous row, then the current entry becomes
				 * the candidate. This is because we know we must be to the
				 * right of center of the last Figure in the previous row, so
				 * this Figure (which is at the start of a new row) is the
				 * candidate.
				 */
				if (p.y <= rowBottom) {
					if (candidate == -1)
						candidate = i;
					break;
				} else
					candidate = -1; // Mouse's Y is outside the row, so reset
									// the candidate
			}
			rowBottom = Math.max(rowBottom, rect.bottom());
			if (candidate == -1) {
				/*
				 * See if we have a possible candidate. It is a candidate if the
				 * cursor is left of the center of this candidate.
				 */
				if (p.x <= rect.x + (rect.width / 2))
					candidate = i;
			}
			if (candidate != -1) {
				// We have a candidate, see if the rowBottom has grown to
				// include the mouse Y.
				if (p.y <= rowBottom) {
					/*
					 * Now we have determined that the cursor.Y is above the
					 * bottom of the current row of figures. Stop now, to
					 * prevent the next row from being searched
					 */
					break;
				}
			}
		}
		return candidate;
	}

	private Rectangle getAbsoluteBounds(GraphicalEditPart ep) {
		Rectangle bounds = ep.getFigure().getBounds().getCopy();
		ep.getFigure().translateToAbsolute(bounds);
		return bounds;
	}

}
