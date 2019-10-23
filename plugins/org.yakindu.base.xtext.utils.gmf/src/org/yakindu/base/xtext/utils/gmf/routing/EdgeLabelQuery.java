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

import java.util.List;
import java.util.Optional;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Straight;
import org.eclipse.draw2d.geometry.Transform;
import org.eclipse.draw2d.geometry.Vector;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.util.LabelViewConstants;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.notation.Bounds;

/**
 * Utility class used to compute the position of a label according to its edge
 * move (old points and new points list).
 *
 * @author <a href="mailto:laurent.fasani@obeo.fr">Laurent Fasani</a>
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
@SuppressWarnings("restriction")
public class EdgeLabelQuery {

	private final static double DISTANCE_TOLERANCE = 0.001;

	/** Status for {@link #getSameLineStatus(Vector, LineSeg)} method. */
	private static final int NOT_ON_SAME_LINE = 0;

	/** Status for {@link #getSameLineStatus(Vector, LineSeg)} method. */
	private static final int ON_SAME_LINE_SAME_DIRECTION = 1;

	/** Status for {@link #getSameLineStatus(Vector, LineSeg)} method. */
	private static final int ON_SAME_LINE_OPPOSITE_DIRECTION = 2;

	/**
	 * Get the signed angle between two segments.
	 *
	 * @param line1
	 * @param line2
	 * @return the signed angle in radian.
	 */
	private static double angleBetween2Lines(LineSeg line1, LineSeg line2) {
		if ((line1 == null) || (line2 == null)) {
			return 0;
		}
		double angle1 = Math.atan2(line1.getOrigin().y - line1.getTerminus().y,
				line1.getOrigin().x - line1.getTerminus().x);
		double angle2 = Math.atan2(line2.getOrigin().y - line2.getTerminus().y,
				line2.getOrigin().x - line2.getTerminus().x);
		return angle1 - angle2;
	}

	/**
	 * Get the signed angle between two vectors.
	 *
	 * @param vector1 The first vector
	 * @param vector2 The second vector
	 * @return the signed angle in radian.
	 */
	private static double angleBetween2Lines(Vector vector1, Vector vector2) {
		if ((vector1 == null) || (vector2 == null)) {
			return 0;
		}
		double angle1 = Math.atan2(vector1.y, vector1.x);
		double angle2 = Math.atan2(vector2.y, vector2.x);
		return angle1 - angle2;
	}

	/**
	 * Get the location among {@link LabelViewConstants} constants where to relocate
	 * the label figure.
	 *
	 * @return the location among {@link LabelViewConstants} constants
	 */
	private static int getLocation(Integer keyPoint) {
		int location = LabelViewConstants.MIDDLE_LOCATION;
		switch (keyPoint) {
		case ConnectionLocator.SOURCE:
			location = LabelViewConstants.TARGET_LOCATION;
			break;
		case ConnectionLocator.TARGET:
			location = LabelViewConstants.SOURCE_LOCATION;
			break;
		case ConnectionLocator.MIDDLE:
			location = LabelViewConstants.MIDDLE_LOCATION;
			break;
		default:
			location = LabelViewConstants.MIDDLE_LOCATION;
			break;
		}
		return location;
	}

	/**
	 * Get the rotated vector according to the segment orientation.
	 *
	 * @param vector          vector to be rotated
	 * @param segment         reference segment
	 * @param inverseRotation if true, inverse rotation
	 * @return the rotated Vector
	 */
	private static Vector getRotatedVector(Vector vector, LineSeg segment, boolean inverseRotation) {
		Vector result = new Vector(vector.x, vector.y);
		if ((vector.x != 0) || (vector.y != 0)) {
			double angle = angleBetween2Lines(new LineSeg(new Point(0, 0), new Point(1, 0)), segment)
					* (inverseRotation ? -1 : 1);
			Transform rotateTransform = new Transform();
			rotateTransform.setRotation(angle);
			Point rotatedPoint = rotateTransform.getTransformed(vector.toPoint());

			result.x = rotatedPoint.x;
			result.y = rotatedPoint.y;
		}
		return result;
	}

	/**
	 * Return the default snap back position according to the keyPoint of the label.
	 *
	 * @param keyPoint The keyPoint of the label (
	 *                 {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 *                 ).
	 * @return the default snap back position according to the keyPoint.
	 */
	public static Point getSnapBackPosition(Integer keyPoint) {
		return new Point();
	}

	/**
	 * Calculates the label offset from the reference point given the label center
	 * and a points list.<BR>
	 * {@link org.eclipse.gmf.runtime.diagram.ui.internal.figures.LabelHelper#offsetFromRelativeCoordinate(org.eclipse.draw2d.IFigure, org.eclipse.draw2d.geometry.Rectangle, Point)}
	 *
	 * @param labelCenter the label center for the <code>IFigure</code> to calculate
	 *                    the offset for
	 * @param points      the <code>PointList</code> of the edge that contains the
	 *                    label. The label offset is relative to this
	 *                    <code>PointList</code>.
	 * @param ref         the <code>Point</code> that is the reference point that
	 *                    the offset is based on.
	 * @return a <code>Point</code> which represents a value offset from the
	 *         <code>ref</code> point oriented based on the nearest line segment.
	 */
	public static Point offsetFromRelativeCoordinate(Point labelCenter, PointList points, Point ref) {
		Vector fromAnchorToLabelCenterPointVector = new Vector(labelCenter.x - ref.x, labelCenter.y - ref.y);
		@SuppressWarnings("rawtypes")
		List lineSegments = PointListUtilities.getLineSegments(points);
		LineSeg segmentContainingLabelAnchor = PointListUtilities.getNearestSegment(lineSegments, ref.x, ref.y);
		Vector rotatedVector = getRotatedVector(fromAnchorToLabelCenterPointVector, segmentContainingLabelAnchor,
				false);
		return new PrecisionPoint(rotatedVector.x, rotatedVector.y);
	}

	/**
	 * Calculates the relative coordinate that is equivalent to the offset from the
	 * reference point, that can be used to set the label center location. <BR>
	 *
	 * This is another implementation of
	 * {@link org.eclipse.gmf.runtime.diagram.ui.internal.figures.LabelHelper#relativeCoordinateFromOffset(org.eclipse.draw2d.IFigure, Point, Point)}
	 * . See bugzilla 476305 for more detail.
	 *
	 * @param points the <code>PointList</code> of the edge that contains the label.
	 *               The label offset is relative to this <code>PointList</code>.
	 * @param ref    a <code>Point</code> located on the parent which the offset
	 *               value is relative to.
	 * @param offset a <code>Point</code> which represents a value offset from the
	 *               <code>ref</code> point oriented based on the nearest line
	 *               segment.
	 * @return a <code>Point</code> that is the relative coordinate of the label
	 *         that can be used to set it's center location.
	 */
	public static Point relativeCenterCoordinateFromOffset(PointList points, Point ref, Point offset) {
		Vector fromAnchorToLabelCenterPointVector = new Vector(offset.x, offset.y);
		@SuppressWarnings("rawtypes")
		List lineSegments = PointListUtilities.getLineSegments(points);
		LineSeg segmentContainingLabelAnchor = PointListUtilities.getNearestSegment(lineSegments, ref.x, ref.y);
		Vector rotatedVector = getRotatedVector(fromAnchorToLabelCenterPointVector, segmentContainingLabelAnchor, true);

		return new PrecisionPoint(ref.x + rotatedVector.x, ref.y + rotatedVector.y);
	}

	/** BendPoint list before the edge modification. */
	private PointList oldBendPointList;

	/** BendPoint list corresponding to the edge modification. */
	private PointList newBendPointList;

	/** The routing status of edge on which the label is. */
	private boolean isEdgeWithObliqueRoutingStyle;

	/** The old offset of the label */
	private Point oldLabelOffset;

	/**
	 * The keyPoint of the label (
	 * {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 * ).
	 */
	private Integer keyPoint;

	private List<LineSeg> oldEdgeSegments;

	private List<LineSeg> newEdgeSegments;

	/**
	 * True if the parent's label is a bracketEdge (specific locator for center
	 * label and possibility to rotate the middle segment), false otherwise.
	 */
	private boolean isOnBracketEdge;

	/** The size of the label. */
	private Dimension labelSize;

	/**
	 * Default constructor.
	 *
	 * @param oldBendPointList              Bendpoint list before the edge
	 *                                      modification
	 * @param newBendPointList              Bendpoint list after the edge
	 *                                      modification
	 * @param isEdgeWithObliqueRoutingStyle status of the edge from which to get the
	 *                                      previous position of the bendpoints and
	 *                                      from which to get the three labels
	 * @param oldLabelOffset                The old offset.
	 * @param labelSize                     The size of the label
	 * @param keyPoint                      The keyPoint of the label (
	 *                                      {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 *                                      )
	 * @param isOnBracketEdge               True if the parent's label is a
	 *                                      bracketEdge (specific locator for center
	 *                                      label and possibility to rotate the
	 *                                      middle segment), false otherwise.
	 */
	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public EdgeLabelQuery(PointList oldBendPointList, PointList newBendPointList, boolean isEdgeWithObliqueRoutingStyle,
			Point oldLabelOffset, Dimension labelSize, Integer keyPoint, boolean isOnBracketEdge) {
		this.isEdgeWithObliqueRoutingStyle = isEdgeWithObliqueRoutingStyle;

		this.oldBendPointList = oldBendPointList;
		this.newBendPointList = newBendPointList;
		this.oldLabelOffset = oldLabelOffset;
		this.labelSize = labelSize;
		this.keyPoint = keyPoint;
		this.isOnBracketEdge = isOnBracketEdge;

		// compute lineSegments from bendPoints
		oldEdgeSegments = PointListUtilities.getLineSegments(oldBendPointList);
		newEdgeSegments = PointListUtilities.getLineSegments(newBendPointList);
	}

	private Vector applyOldRatioOnNewOrthogonalSegment(LineSeg oldRefSeg, Point oldRefPoint, Point oldCenterLabel,
			LineSeg newRefSeg, boolean is90Angle) {
		double oldRatio = oldRefSeg.projection(oldCenterLabel.x, oldCenterLabel.y);
		Transform rotateTransform = new Transform();
		// Get the new reference point and the rotation to apply
		Point newRefPoint;
		if (is90Angle) {
			// As GMF coordinates system is reversed (y positive orientation is
			// from top to bottom), we reverse the rotation to apply
			rotateTransform.setRotation(Math.toRadians(-90));
			if ((0 <= oldRatio) && (oldRatio <= 1)) {
				// Apply same ratio on the new segment to compute the new
				// reference point
				newRefPoint = new PrecisionPoint(
						newRefSeg.getOrigin().x - (oldRatio * (newRefSeg.getOrigin().x - newRefSeg.getTerminus().x)),
						newRefSeg.getOrigin().y - (oldRatio * (newRefSeg.getOrigin().y - newRefSeg.getTerminus().y)));
			} else if (oldRatio > 1) {
				// Just apply the vector from old terminus to old reference
				// point to the new terminus
				Vector vectorFromOldTerminusToOldRefPoint = new Vector(oldRefPoint.x - oldRefSeg.getTerminus().x,
						oldRefPoint.y - oldRefSeg.getTerminus().y);
				Point vectorFromNewTerminusToNewRefPoint = rotateTransform
						.getTransformed(vectorFromOldTerminusToOldRefPoint.toPoint());
				newRefPoint = newRefSeg.getTerminus().getTranslated(vectorFromNewTerminusToNewRefPoint);
			} else {
				Vector vectorFromOldOriginToOldRefPoint = new Vector(oldRefPoint.x - oldRefSeg.getOrigin().x,
						oldRefPoint.y - oldRefSeg.getOrigin().y);
				Point vectorFromNewOriginToNewRefPoint = rotateTransform
						.getTransformed(vectorFromOldOriginToOldRefPoint.toPoint());
				newRefPoint = newRefSeg.getOrigin().getTranslated(vectorFromNewOriginToNewRefPoint);
			}
		} else {
			// As GMF coordinates system is reversed (y positive orientation is
			// from top to bottom), we reverse the rotation to apply
			rotateTransform.setRotation(Math.toRadians(90));
			if ((0 <= oldRatio) && (oldRatio <= 1)) {
				// Apply same ratio on the new segment to compute the new
				// reference point (but inverse the origin and the terminus)
				newRefPoint = new PrecisionPoint(
						newRefSeg.getOrigin().x + (oldRatio * (newRefSeg.getTerminus().x - newRefSeg.getOrigin().x)),
						newRefSeg.getOrigin().y + (oldRatio * (newRefSeg.getTerminus().y - newRefSeg.getOrigin().y)));
			} else if (oldRatio > 1) {
				// Just apply the vector from old terminus to old reference
				// point to the new terminus
				Vector vectorFromOldTerminusToOldRefPoint = new Vector(oldRefPoint.x - oldRefSeg.getTerminus().x,
						oldRefPoint.y - oldRefSeg.getTerminus().y);
				Point vectorFromNewTerminusToNewRefPoint = rotateTransform
						.getTransformed(vectorFromOldTerminusToOldRefPoint.toPoint());
				newRefPoint = newRefSeg.getTerminus().getTranslated(vectorFromNewTerminusToNewRefPoint);
			} else {
				Vector vectorFromOldOriginToOldRefPoint = new Vector(oldRefPoint.x - oldRefSeg.getOrigin().x,
						oldRefPoint.y - oldRefSeg.getOrigin().y);
				Point vectorFromNewOriginToNewRefPoint = rotateTransform
						.getTransformed(vectorFromOldOriginToOldRefPoint.toPoint());
				newRefPoint = newRefSeg.getOrigin().getTranslated(vectorFromNewOriginToNewRefPoint);
			}
		}
		Vector vectorFromOldRefPointToOldCenterLabel = new Vector(oldCenterLabel.x - oldRefPoint.x,
				oldCenterLabel.y - oldRefPoint.y);
		Point fromNewRefPointToNewCenterLabel = rotateTransform
				.getTransformed(vectorFromOldRefPointToOldCenterLabel.toPoint());
		// Adjust the vector to apply according to orientation change (width
		// becomes height and conversely)
		if (newRefSeg.isHorizontal()) {
			if ((0 <= oldRatio) && (oldRatio <= 1)) {
				int invertedWidthHeight = labelSize.width - labelSize.height;
				if (newRefSeg.getOrigin().x > newRefSeg.getTerminus().x) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(0, invertedWidthHeight / 2);
			} else if (oldRatio > 1) {
				int invertedWidthHeight = labelSize.width - labelSize.height;
				if (newRefSeg.getOrigin().x > newRefSeg.getTerminus().x) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(invertedWidthHeight / 2, 0);
			} else {
				fromNewRefPointToNewCenterLabel.translate(0, 0);
				int invertedWidthHeight = labelSize.width - labelSize.height;
				if (newRefSeg.getOrigin().x < newRefSeg.getTerminus().x) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(invertedWidthHeight / 2, 0);
			}
		} else {
			if ((0 <= oldRatio) && (oldRatio <= 1)) {
				int invertedWidthHeight = labelSize.width - labelSize.height;
				if (newRefSeg.getOrigin().y > newRefSeg.getTerminus().y) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(invertedWidthHeight / 2, 0);
			} else if (oldRatio > 1) {
				int invertedWidthHeight = labelSize.height - labelSize.width;
				if (newRefSeg.getOrigin().y > newRefSeg.getTerminus().y) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(0, invertedWidthHeight / 2);
			} else {
				int invertedWidthHeight = labelSize.height - labelSize.width;
				if (newRefSeg.getOrigin().y < newRefSeg.getTerminus().y) {
					invertedWidthHeight = -invertedWidthHeight;
				}
				fromNewRefPointToNewCenterLabel.translate(0, invertedWidthHeight / 2);
			}
		}
		// Apply the rotated vector on new reference point to have the new
		// center
		Point newCenterLabel = newRefPoint.getTranslated(fromNewRefPointToNewCenterLabel);
		// Compute the vector from old center to new center
		return new Vector(newCenterLabel.x - oldCenterLabel.x, newCenterLabel.y - oldCenterLabel.y);
	}

	private Vector applyOldRatioOnNewSegment(LineSeg oldRefSeg, Point oldRefPoint, Point oldCenterLabel,
			LineSeg newRefSeg, boolean oppositeDirection, boolean sameLine) {
		Vector result;
		double newRatio = newRefSeg.projection(oldCenterLabel.x, oldCenterLabel.y);
		if (sameLine && (newRatio >= 0) && (newRatio <= 1)) {
			// If the orthogonal projection is inside segment (between 0 and
			// 1), the reference point does not move.
			result = new Vector(0, 0);
		} else {
			Point newRefPoint;
			double oldRatio = oldRefSeg.projection(oldCenterLabel.x, oldCenterLabel.y);
			if (!oppositeDirection) {
				newRefPoint = new PrecisionPoint(
						newRefSeg.getOrigin().x + (oldRatio * (newRefSeg.getTerminus().x - newRefSeg.getOrigin().x)),
						newRefSeg.getOrigin().y + (oldRatio * (newRefSeg.getTerminus().y - newRefSeg.getOrigin().y)));
			} else {
				newRefPoint = new PrecisionPoint(
						newRefSeg.getOrigin().x - (oldRatio * (newRefSeg.getOrigin().x - newRefSeg.getTerminus().x)),
						newRefSeg.getOrigin().y - (oldRatio * (newRefSeg.getOrigin().y - newRefSeg.getTerminus().y)));
			}
			if (!sameLine && (newRatio >= 0) && (newRatio <= 1)) {
				// If the orthogonal projection is inside segment (between 0 and
				// 1), we keep the oldRefPoint one axis
				if (newRefSeg.isHorizontal()) {
					newRefPoint.setX(oldRefPoint.x);
				} else {
					newRefPoint.setY(oldRefPoint.y);
				}
			}
			Vector vectorFromOldToNewRefPoint = new Vector(newRefPoint.x - oldRefPoint.x,
					newRefPoint.y - oldRefPoint.y);
			if ((oldRatio >= 0) && (oldRatio <= 1)) {
				// Keep ratio on segment for newRefPoint (if it was
				// previously inside segment)
				result = vectorFromOldToNewRefPoint;
			} else {
				// If the label is previously outside of the segment, we
				// keep the shortest point (new or old one).
				Point potentialNewCenter = oldCenterLabel.getTranslated(vectorFromOldToNewRefPoint.x,
						vectorFromOldToNewRefPoint.y);
				if (((newRatio > 1) && (newRatio < newRefSeg.projection(potentialNewCenter.x, potentialNewCenter.y)))
						|| ((newRatio < 0)
								&& (newRatio > newRefSeg.projection(potentialNewCenter.x, potentialNewCenter.y)))) {
					result = new Vector(0, 0);
				} else {
					result = vectorFromOldToNewRefPoint;
				}
			}
		}
		return result;
	}

	/**
	 * Check if the old points and the new one are the same.
	 *
	 * @return true if the old points are the same as the new, false otherwise.
	 */
	private boolean areBendpointsIdentical() {
		boolean areBendpointsIdentical = true;
		if (newBendPointList.size() == oldBendPointList.size()) {
			for (int i = 0; i < newBendPointList.size(); i++) {
				Point newPoint = newBendPointList.getPoint(i);
				Point oldPoint = oldBendPointList.getPoint(i);
				if (!newPoint.equals(oldPoint)) {
					areBendpointsIdentical = false;
					break;
				}
			}
		} else {
			areBendpointsIdentical = false;
		}

		return areBendpointsIdentical;
	}

	/**
	 * Check if all segments of new and old points are valid (no segment with same
	 * origin and terminus).
	 *
	 * @return true if segments are valid, false otherwise.
	 */
	private boolean areSegmentsValid() {
		boolean areSegmentsValid = true;
		for (LineSeg lineSeg : newEdgeSegments) {
			if (lineSeg.getOrigin().equals(lineSeg.getTerminus())) {
				areSegmentsValid = false;
				break;
			}
		}

		if (areSegmentsValid) {
			for (LineSeg lineSeg : oldEdgeSegments) {
				if (lineSeg.getOrigin().equals(lineSeg.getTerminus())) {
					areSegmentsValid = false;
					break;
				}
			}
		}
		return areSegmentsValid;
	}

	/**
	 * Calculate the new GMF label offset: the label offset defines the position of
	 * the label compared to labelAnchor point. <br>
	 * The new Label offset is computed taking into account:<br>
	 * <ul>
	 * <li>the label anchor point move (start, center or end)</li>
	 * <li>the orientation of the segment owning the label anchor. Indeed, the label
	 * offset is displayed by draw2D relatively to the direction of the edge segment
	 * including the anchor of the label</li>
	 * <li>the expected move of the label according to the functional
	 * specification</li>
	 * </ul>
	 * .
	 *
	 * @return the new offset of the label
	 */
	public Point calculateGMFLabelOffset() {
		if (areBendpointsIdentical() && areSegmentsValid()) {
			return oldLabelOffset;
		} else {
			int anchorPointRatio = getLocation(keyPoint);
			Point oldAnchorPoint = getAnchorPoint(oldBendPointList, anchorPointRatio);
			Point oldLabelCenter = relativeCenterCoordinateFromOffset(oldBendPointList, oldAnchorPoint, oldLabelOffset);
			Point newAnchorPoint = getAnchorPoint(newBendPointList, anchorPointRatio);
			Point newLabelCenter = calculateNewCenterLocation(oldLabelCenter,
					getStandardLabelCenterLocation(newBendPointList, keyPoint));
			Point newOffset = offsetFromRelativeCoordinate(newLabelCenter, newBendPointList, newAnchorPoint);
			if ((newLabelCenter.x != oldLabelCenter.x) && (newLabelCenter.y != oldLabelCenter.y)) {
				// rectilinear & both coordinates change => newOffset is 0,0
//				System.out.println("[ERR] Label JUMP oldLabelCenter=" + oldLabelCenter + ", oldAnchorPoint="
//						+ oldAnchorPoint + ", oldOffset=" + oldLabelOffset + ", newAnchorPoint=" + newAnchorPoint
//						+ ", newLabelCenter=" + newLabelCenter + ", newOffset=" + newOffset);
			}
			return newOffset;
		}
	}

	/**
	 * Calculate the new center location of the label according to functional
	 * specification.
	 *
	 * @param oldCenterLabel     The old center location of the label.
	 * @param newDefaultLocation The standard center location according to the label
	 *                           keyPoint (
	 *                           {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 *                           and the default snap back position (
	 *                           {@link LabelEditPart#getSnapBackPosition(String)}.
	 * @return
	 */
	private Point calculateNewCenterLocation(Point oldCenterLabel, Point newDefaultLocation) {
		Vector fromOldToNewCenterVector = null;

		// Step 1 : Calculate old reference point (the nearest point on the edge
		// from the center of the label).
		LineSeg oldNearestSeg = PointListUtilities.getNearestSegment(oldEdgeSegments, oldCenterLabel.x,
				oldCenterLabel.y);
		Point oldNearestPoint = oldNearestSeg.perpIntersect(oldCenterLabel.x, oldCenterLabel.y);

		boolean case0 = false;
		boolean case1 = false;
		boolean case2 = false;
		boolean opt1 = false;
		boolean opt2 = false;
		boolean cond1 = false;
		boolean cond2 = false;
		boolean cond3 = false;

		// Step 2 : Is there a new segment and an old segment on the same line?
		// Case of segment increased or decreased (and eventually inverted)
		Optional<Vector> fromOldToNewRefPoint = getVectorFromOldToNewForSegmentsOnSameLine(oldNearestSeg,
				oldNearestPoint, oldCenterLabel);
		if (fromOldToNewRefPoint.isPresent()) {
			case0 = true;
			// In this case the vector for the reference point is the same than
			// for the label center.
			fromOldToNewCenterVector = fromOldToNewRefPoint.get();
		} else { // No identical segment line has been found
			// RECTILINEAR and TREE routing
			if (!isEdgeWithObliqueRoutingStyle) {
				// Get projection of oldNearestPoint on newSegments along
				// oldRefVector
				LineSeg oldRefVectorIntoSegment = null;
				if (oldCenterLabel.equals(oldNearestPoint)) {
					// Get a segment perpendicular to oldRefSegment going
					// through oldNearestPoint
					opt1 = true;
					oldRefVectorIntoSegment = new LineSeg(oldNearestPoint,
							new PrecisionPoint(
									oldNearestPoint.x + (oldNearestSeg.getOrigin().y - oldNearestSeg.getTerminus().y),
									oldNearestPoint.y - (oldNearestSeg.getOrigin().x - oldNearestSeg.getTerminus().x)));
				} else {
					opt2 = true;
					oldRefVectorIntoSegment = new LineSeg(oldCenterLabel, oldNearestPoint);
				}

				// Is there a new segment at the same index as old segment and
				// with same axis? Case of rectilinear segment move.
				fromOldToNewCenterVector = getVectorForSegmentMoveCase(oldNearestSeg, oldNearestPoint, oldCenterLabel);
				if ((fromOldToNewCenterVector == null) && isOnBracketEdge) {
					case1 = true;
					// Is there a new segment at the same index as old segment
					// and with opposite axis? Case of change orientation of the
					// bracket edge
					fromOldToNewCenterVector = getVectorForBracketEdgeOrientationChangeCase(oldNearestSeg,
							oldNearestPoint, oldCenterLabel);
				}
				if (fromOldToNewCenterVector == null) {
					for (LineSeg lineSeg : newEdgeSegments) {
						PointList linesIntersections = oldRefVectorIntoSegment.getLinesIntersections(lineSeg);
						// intersection should be, at more, one point
						if ((linesIntersections.size() == 1)
								&& (lineSeg.distanceToPoint(linesIntersections.getPoint(0).x,
										linesIntersections.getPoint(0).y) <= Math.sqrt(2))) {
							cond1 = true;
							Vector tempLabelMove = new Vector(linesIntersections.getPoint(0).x - oldNearestPoint.x,
									linesIntersections.getPoint(0).y - oldNearestPoint.y);
							if ((fromOldToNewCenterVector == null)
									|| (tempLabelMove.getLength() < fromOldToNewCenterVector.getLength())) {
								cond2 = true;
								fromOldToNewCenterVector = tempLabelMove;
							}
						}
					}
					// Compare the minimalLabelMove with the default location.
					// If the default location is nearer reset the labelMove.
					Vector fromOldNearestPointToStandardLocation = new Vector(newDefaultLocation.x - oldNearestPoint.x,
							newDefaultLocation.y - oldNearestPoint.y);
					if ((fromOldToNewCenterVector == null) || (fromOldNearestPointToStandardLocation
							.getLength() < fromOldToNewCenterVector.getLength())) {
						cond3 = true;
//						System.out.println("COND 3");
//						System.out.println("[WARN] Label relocation: prevent fallback to anchor point.");
//						fromOldToNewCenterVector = null;
					} else {
						case2 = true;
					}
				}
			} else if (newEdgeSegments.size() == oldEdgeSegments.size()) {
				// The newNearestSegment as the same index in
				// newEdgeSegments than oldNearestSegment in oldEdgeSegments
				LineSeg newRefSeg = newEdgeSegments.get(oldEdgeSegments.indexOf(oldNearestSeg));
				// Keep ratio on segment for newRefPoint
				double oldRatio = oldNearestSeg.projection(oldCenterLabel.x, oldCenterLabel.y);
				Point newRefPoint = new PrecisionPoint(
						newRefSeg.getOrigin().x + (oldRatio * (newRefSeg.getTerminus().x - newRefSeg.getOrigin().x)),
						newRefSeg.getOrigin().y + (oldRatio * (newRefSeg.getTerminus().y - newRefSeg.getOrigin().y)));
				fromOldToNewCenterVector = new Vector(newRefPoint.x - oldNearestPoint.x,
						newRefPoint.y - oldNearestPoint.y);

			}
		}
		if (fromOldToNewCenterVector == null) {
//			System.out.println("[WARN] Fallback to anchor point. Case0=" + case0 + ", Case1=" + case1 + ", Case2="
//					+ case2 + ", Opt1=" + opt1 + ", Opt2=" + opt2 + " Cond1=" + cond1 + ", Cond2=" + cond2 + ", Cond3="
//					+ cond3);
			return newDefaultLocation;
		} else {
			return oldCenterLabel.getTranslated(fromOldToNewCenterVector.x, fromOldToNewCenterVector.y);
		}
	}

	private Point getAnchorPoint(PointList pointList, int anchorPointRatio) {
		return PointListUtilities.calculatePointRelativeToLine(pointList, 0, anchorPointRatio, true);
	}

	/**
	 * Check if the <code>segment</code> is on the same line as the
	 * <code>referenceSegment</code> and if it is in the same direction or not.
	 *
	 * @param referenceSegment The reference segment.
	 * @param segment          The segment to test
	 * @return one of these statuses {@link #NOT_ON_SAME_LINE},
	 *         {@link #ON_SAME_LINE_SAME_DIRECTION} or
	 *         {@link #ON_SAME_LINE_OPPOSITE_DIRECTION}.
	 */
	private int getSameLineStatus(LineSeg referenceSegment, LineSeg segment) {
		int result = NOT_ON_SAME_LINE;
		if (segment.length() != 0) {
			Vector referenceVector = new Vector(referenceSegment.getTerminus().x - referenceSegment.getOrigin().x,
					referenceSegment.getTerminus().y - referenceSegment.getOrigin().y);
			Vector vector = new Vector(segment.getTerminus().x - segment.getOrigin().x,
					segment.getTerminus().y - segment.getOrigin().y);
			double angle = referenceVector.getAngle(vector);
			if ((angle == 0) || (angle == 180)) {
				Straight straight = new Straight(new PrecisionPoint(segment.getOrigin()),
						new PrecisionPoint(segment.getTerminus()));
				double distToInfiniteLine = straight
						.getDistance(new Vector(referenceSegment.getOrigin().x, referenceSegment.getOrigin().y));
				if (distToInfiniteLine < DISTANCE_TOLERANCE) {
					if (angle == 180) {
						result = ON_SAME_LINE_OPPOSITE_DIRECTION;
					} else {
						result = ON_SAME_LINE_SAME_DIRECTION;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Get the standard center location according to the label keyPoint (
	 * {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 * ) and the default snap back position (
	 * {@link LabelEditPart#getSnapBackPosition(String)}
	 *
	 * @param pointsList The points of the edge of the label.
	 * @param keyPoint   The keyPoint of the label (
	 *                   {@link org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getKeyPoint()}
	 *                   ).
	 * @return The center of the label {@link Bounds} if this label is located by
	 *         default.
	 */
	private Point getStandardLabelCenterLocation(PointList pointsList, Integer keyPoint) {
		int percentage = getLocation(keyPoint);
		Point newAnchorPoint = getAnchorPoint(pointsList, percentage);
		Point snapBackPosition = getSnapBackPosition(keyPoint);
		Point standardLabelCenter = newAnchorPoint.getTranslated(snapBackPosition);
		return standardLabelCenter;
	}

	/**
	 * Check if we are in case of a orientation segment change: there is a new
	 * segment at the same index as old nearest segment and with apposite axis.
	 * Return the corresponding vector from old to new center in this case, null
	 * otherwise.
	 *
	 * @param oldNearestSeg The segment that is the nearest from the center of the
	 *                      label in the old points list.
	 * @return the corresponding vector from old to new center in case of
	 *         orientation segment change, null otherwise.
	 */
	private Vector getVectorForBracketEdgeOrientationChangeCase(LineSeg oldNearestSeg, Point oldNearestPoint,
			Point oldCenterLabel) {
		Vector fromOldToNewCenterVector = null;
		if (newEdgeSegments.size() == oldEdgeSegments.size()) {
			int index = oldEdgeSegments.indexOf(oldNearestSeg);
			LineSeg newNearestSegment = newEdgeSegments.get(index);
			if (oldNearestSeg.isHorizontal() != newNearestSegment.isHorizontal()) {
				Vector oldVector = new Vector(oldNearestSeg.getTerminus().x - oldNearestSeg.getOrigin().x,
						oldNearestSeg.getTerminus().y - oldNearestSeg.getOrigin().y);
				Vector newVector = new Vector(newNearestSegment.getTerminus().x - newNearestSegment.getOrigin().x,
						newNearestSegment.getTerminus().y - newNearestSegment.getOrigin().y);
				double angleInDegree = Math.toDegrees(angleBetween2Lines(oldVector, newVector));
				fromOldToNewCenterVector = applyOldRatioOnNewOrthogonalSegment(oldNearestSeg, oldNearestPoint,
						oldCenterLabel, newNearestSegment, (angleInDegree == 90) || (angleInDegree == -270));
			}
		}
		return fromOldToNewCenterVector;
	}

	/**
	 * Check if we are in case of a rectilinear segment move: there is a new segment
	 * at the same index as old nearest segment and with the same axis. Return the
	 * corresponding vector from old to new center in this case, null otherwise.
	 *
	 * @param oldNearestSeg The segment that is the nearest from the center of the
	 *                      label in the old points list.
	 * @return the corresponding vector from old to new center in case of
	 *         rectilinear segment move, null otherwise.
	 */
	private Vector getVectorForSegmentMoveCase(LineSeg oldNearestSeg, Point oldNearestPoint, Point oldCenterLabel) {
		Vector fromOldToNewCenterVector = null;
		if (newEdgeSegments.size() == oldEdgeSegments.size()) {
			int index = oldEdgeSegments.indexOf(oldNearestSeg);
			LineSeg newNearestSegment = newEdgeSegments.get(index);
			if (oldNearestSeg.isHorizontal() == newNearestSegment.isHorizontal()) {
				Vector oldVector = new Vector(oldNearestSeg.getTerminus().x - oldNearestSeg.getOrigin().x,
						oldNearestSeg.getTerminus().y - oldNearestSeg.getOrigin().y);
				Vector newVector = new Vector(newNearestSegment.getTerminus().x - newNearestSegment.getOrigin().x,
						newNearestSegment.getTerminus().y - newNearestSegment.getOrigin().y);
				fromOldToNewCenterVector = applyOldRatioOnNewSegment(oldNearestSeg, oldNearestPoint, oldCenterLabel,
						newNearestSegment, oldVector.getAngle(newVector) == 180, false);
			}
		}
		return fromOldToNewCenterVector;
	}

	private Optional<Vector> getVectorFromOldToNewForSegmentsOnSameLine(LineSeg oldRefSeg, Point oldRefPoint,
			Point oldCenterLabel) {
		Optional<Vector> result = Optional.empty();
		LineSeg newSegmentOnSameLineWithSameDirection = null;
		LineSeg newSegmentOnSameLineWithOppositeDirection = null;
		// Firstly, for points lists with same nb of segments, search if the
		// vector, at
		// the same index, is on the same line
		int sameLineStatus = NOT_ON_SAME_LINE;
		if (newEdgeSegments.size() == oldEdgeSegments.size()) {
			LineSeg newSegAtSameIndex = newEdgeSegments.get(oldEdgeSegments.indexOf(oldRefSeg));
			sameLineStatus = getSameLineStatus(oldRefSeg, newSegAtSameIndex);
			if (ON_SAME_LINE_SAME_DIRECTION == sameLineStatus) {
				newSegmentOnSameLineWithSameDirection = newSegAtSameIndex;
			} else if (ON_SAME_LINE_OPPOSITE_DIRECTION == sameLineStatus) {
				newSegmentOnSameLineWithOppositeDirection = newSegAtSameIndex;
			}
		}
		if (NOT_ON_SAME_LINE == sameLineStatus) {
			// If this is not the case search on all new segments.
			for (LineSeg newSeg : newEdgeSegments) {
				sameLineStatus = getSameLineStatus(oldRefSeg, newSeg);
				if (ON_SAME_LINE_SAME_DIRECTION == sameLineStatus) {
					newSegmentOnSameLineWithSameDirection = newSeg;
					break;
				} else if (ON_SAME_LINE_OPPOSITE_DIRECTION == sameLineStatus) {
					newSegmentOnSameLineWithOppositeDirection = newSeg;
					// Continue to search a potential segment in the same
					// direction.
				}
			}
		}

		LineSeg newRefSeg = newSegmentOnSameLineWithSameDirection;
		if (newRefSeg == null) {
			newRefSeg = newSegmentOnSameLineWithOppositeDirection;
		}

		if (newRefSeg != null) {
			result = Optional.of(applyOldRatioOnNewSegment(oldRefSeg, oldRefPoint, oldCenterLabel, newRefSeg,
					newSegmentOnSameLineWithOppositeDirection != null, true));
		}
		return result;
	}
}
