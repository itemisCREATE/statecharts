/*******************************************************************************
 * Copyright (c) 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/

package org.yakindu.base.xtext.utils.gmf.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.yakindu.base.xtext.utils.gmf.routing.EdgeLabelQuery;

/**
 * Operation concerning the label offset. Used to delegate from the
 * {@link SetLabelsOffsetCommmand} and from the
 * {@link SetConnectionBendpointsAndLabelCommmand}.
 *
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class SetLabelsOffsetOperation {
	public static boolean isEdgeWithObliqueRoutingStyle(org.eclipse.gef.ConnectionEditPart part) {
		Edge edge = (Edge) part.getModel();
		ConnectorStyle style = (ConnectorStyle) edge.getStyle(NotationPackage.Literals.CONNECTOR_STYLE);
		if (style != null) {
			return Routing.MANUAL_LITERAL == style.getRouting();
		}
		return false;
	}

	/**
	 * The labels with their offset computed during the call to
	 * {@link #setLabelsToUpdate(ConnectionEditPart)}. This list is then used during
	 * the execution of the operations to update the label location.
	 */
	private Map<Node, Point> labelsWithNewOffset;

	/** The old points list, used in case of feedback that impacts the edge. */
	private PointList oldBendPointsList;

	/** The new points list. */
	private PointList newPointList;

	/**
	 * Update {@link Bounds} of a label {@link Node}.
	 *
	 * @param labelEdgeEditPart  the editPart of the edge label to be updated
	 * @param connectionEditPart The connection having these labels
	 */
	private void computeGMFLabelOffset(LabelEditPart labelEditPartToUpdate, ConnectionEditPart connectionEditPart) {
		Point newLabelOffset = null;
		Node labelNodeToUpdate = (Node) labelEditPartToUpdate.getModel();
		if (connectionEditPart.getModel() instanceof Edge) {
			PointList oldBendpoints = oldBendPointsList;
			if (oldBendpoints == null) {
//				System.out.println("read current points");
				oldBendpoints = connectionEditPart.getConnectionFigure().getPoints();
			}
			boolean isEdgeWithObliqueRoutingStyle = isEdgeWithObliqueRoutingStyle(connectionEditPart);
			LayoutConstraint layoutConstraint = labelNodeToUpdate.getLayoutConstraint();
			if (layoutConstraint instanceof Location) {
				Location point = (Location) layoutConstraint;
				newLabelOffset = new EdgeLabelQuery(oldBendpoints, newPointList, isEdgeWithObliqueRoutingStyle,
						new Point(point.getX(), point.getY()), labelEditPartToUpdate.getFigure().getSize(),
						labelEditPartToUpdate.getKeyPoint(), false).calculateGMFLabelOffset();
//				System.out.println("queried label offset = " + newLabelOffset);
				if ((newLabelOffset.x == 0) && (newLabelOffset.y == 0)) {
					newLabelOffset = null;
				}
			}
		}

		if (newLabelOffset != null) {
//			System.out.println("store label offset");
			labelsWithNewOffset.put(labelNodeToUpdate, newLabelOffset);
		}
	}

	/**
	 * Update {@link Bounds} of the labels {@link Node}.
	 *
	 * @param labelEditPartsToUpdate List of labels to update
	 * @param connectionEditPart     The connection having these labels
	 */
	private void computeGMFLabelsOffset(List<LabelEditPart> labelEditPartsToUpdate,
			ConnectionEditPart connectionEditPart) {
		labelsWithNewOffset = new HashMap<>();
		// For each label, compute the new offset
		for (LabelEditPart labelEditPartToUpdate : labelEditPartsToUpdate) {
			computeGMFLabelOffset(labelEditPartToUpdate, connectionEditPart);
		}

	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). <BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList)} method.
	 *
	 * @param connectionEditPart The connection from which to get the potential
	 *                           three labels to update
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart) {
		List<LabelEditPart> labelEditPartsToUpdate = new ArrayList<>();
		List<?> children = connectionEditPart.getChildren();
		for (Object child : children) {
			if (child instanceof LabelEditPart) {
				Object view = ((LabelEditPart) child).getModel();
				if (view instanceof Node) {
					labelEditPartsToUpdate.add((LabelEditPart) child);
				}
			}
		}

		computeGMFLabelsOffset(labelEditPartsToUpdate, connectionEditPart);
	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). This method must be used if the edge figure is
	 * updated (through feedback) during the move. Indeed, in this case, we can not
	 * use the figure to retrieve the old points.<BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList)} method.
	 *
	 * @param connectionEditPart The connection from which to get the potential
	 *                           three labels to update
	 * @param originalPoints     The points of the edge before the move.
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart, PointList originalPoints) {
		oldBendPointsList = originalPoints;
		setLabelsToUpdate(connectionEditPart);
//		System.out.println("set labels to update");
	}

	/**
	 * Method to set the newPointList.
	 *
	 * @param newPointList The new points list
	 */
	public void setNewPointList(PointList newPointList) {
		this.newPointList = new PointList(newPointList.size());
		for (int i = 0; i < newPointList.size(); i++) {
			this.newPointList.addPoint(newPointList.getPoint(i));
		}
	}

	/**
	 * Update the offset ({@link Bounds}) of the labels {@link Node}. This method
	 * must be called after setting the newPointList and the labelToUpdate. If the
	 * methods {@link #setLabelsToUpdate(ConnectionEditPart)} or
	 * {@link #setLabelsToUpdate(ConnectionEditPart, PointList)} are not called,
	 * this method has no effect.
	 */
	public void updateGMFLabelsOffset() {
//		System.out.println("update label offsets");
		if (labelsWithNewOffset != null) {
			// Update Bounds of the three labels Node (Center, Begin and End)
			Set<Entry<Node, Point>> entries = labelsWithNewOffset.entrySet();
			for (Entry<Node, Point> entry : entries) {
				LayoutConstraint layoutConstraint = entry.getKey().getLayoutConstraint();
				if (layoutConstraint instanceof Location) {
					Location bounds = (Location) layoutConstraint;
					bounds.setX(entry.getValue().x);
					bounds.setY(entry.getValue().y);
				}
			}
		}
	}
}
