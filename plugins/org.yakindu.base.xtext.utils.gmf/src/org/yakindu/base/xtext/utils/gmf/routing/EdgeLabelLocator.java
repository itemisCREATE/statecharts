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
package org.yakindu.base.xtext.utils.gmf.routing;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Vector;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.figures.LabelLocator;

/**
 * Specific {@link LabelLocator} for edge labels to reflect the real label
 * location during the feedback.
 *
 * @author <a href="mailto:laurent.fasani@obeo.fr">Laurent Fasani</a>
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class EdgeLabelLocator extends LabelLocator {

    /** The points list of the edge before to start to move it. */
    private PointList oldPointList;

    /** The offset of the label before to start to move the edge. */
    private Vector oldLabelOffset;

    /** Status of the edge routing style */
    private boolean isEdgeWithObliqueRoutingStyle;

    /**
     * Constructor for figure who are located and sized.
     *
     * @param parent
     *            the parent figure
     * @param bounds
     *            the bounds
     * @param alignment
     *            the alignment
     */
    public EdgeLabelLocator(IFigure parent, Rectangle bounds, int alignment) {
        super(parent, bounds, alignment);
    }

    /**
     * This method must be called before edge feedback creation (
     * {@link org.eclipse.sirius.diagram.ui.graphical.edit.policies.TreeLayoutConnectionLineSegEditPolicy#showMoveLineSegFeedback(BendpointRequest)}
     * or
     * {@link org.eclipse.sirius.diagram.ui.tools.internal.graphical.edit.policies.SiriusConnectionEndPointEditPolicy#showConnectionMoveFeedback(ReconnectRequest)}
     * ) for example), to initialize the data needed to compute the label offset
     * dynamically and draw the label feedback correctly.<BR>
     * The method {@link #eraseFeedbackData()} must be called when edge feedback
     * is erase.
     *
     * @param oldPointList
     *            The points list of the edge before to start to move it.
     * @param oldLabelOffset
     *            The offset of the label before to start to move the edge.
     * @param isEdgeWithObliqueRoutingStyle
     *            The status of the edge routing style
     */
    public void setFeedbackData(PointList oldPointList, Vector oldLabelOffset, boolean isEdgeWithObliqueRoutingStyle) {
        this.oldPointList = oldPointList;
        this.isEdgeWithObliqueRoutingStyle = isEdgeWithObliqueRoutingStyle;
        this.oldLabelOffset = oldLabelOffset;
    }

    /**
     * This method must be called at the end of the edge feedback (
     * {@link org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy.eraseConnectionMoveFeedback(ReconnectRequest)}
     * or
     * {@link org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.ConnectionBendpointEditPolicy.eraseConnectionFeedback(BendpointRequest,
     * boolean)} for example).
     */
    public void eraseFeedbackData() {
        this.oldPointList = null;
        this.oldLabelOffset = null;
        this.isEdgeWithObliqueRoutingStyle = false;
    }

    @Override
    public void relocate(IFigure target) {
        Dimension preferredSize = target.getPreferredSize();
        LabelLocator currentConstraint = (LabelLocator) target.getParent().getLayoutManager().getConstraint(target);
        Dimension currentExtent = currentConstraint.getSize();
        Dimension size = new Dimension(currentExtent);
        if (currentExtent.width == -1) {
            size.width = preferredSize.width;
        }
        if (currentExtent.height == -1) {
            size.height = preferredSize.height;
        }
        target.setSize(size);
        Point offSet = getOffset();
        if (oldPointList != null) {
            // Compute the future offset only if the oldPointList, comes from
            // edge feedback during a move of an edge. In other case, the offset
            // to use is the stored one.
            Vector computedOffSet = computeOffSet(size);
            offSet = new Point((int) computedOffSet.x, (int) computedOffSet.y);
        }

        Point centerLocation = EdgeLabelQuery.relativeCenterCoordinateFromOffset(((Connection) parent).getPoints(), getReferencePoint(), offSet);
        target.setLocation(centerLocation.getTranslated(-1 * size.width / 2, -1 * size.height / 2));
    }

    /**
     * Compute offset taking current figure bendpoints as newBendPoints.
     */
    private Vector computeOffSet(Dimension size) {
        EdgeLabelQuery edgeLabelsComputationUtil = new EdgeLabelQuery(oldPointList, getPointList(), isEdgeWithObliqueRoutingStyle, oldLabelOffset.toPoint(), size, getAlignment(),
               false);
        Point newMethodPoint = edgeLabelsComputationUtil.calculateGMFLabelOffset();
        return new Vector(newMethodPoint.x, newMethodPoint.y);
    }
}
