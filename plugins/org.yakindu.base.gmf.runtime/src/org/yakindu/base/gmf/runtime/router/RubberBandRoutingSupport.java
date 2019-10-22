package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.yakindu.base.gmf.runtime.router.GeometryUtil.Line;

public class RubberBandRoutingSupport {

	// TODO: injection
	protected RelativeBendpointUtil relbpUtil = new RelativeBendpointUtil();
	protected GeometryUtil geom = new GeometryUtil();
	protected Map<Connection, ConnData> conn = new HashMap<>();
	private Rectangle origDraggedBoundsAbs;
	private MaxMoveDelta[] mmds = new MaxMoveDelta[4];

	public void abortBoxDrag() {
		clearState();
	}

	protected void clearState() {
		// conn.clear();
	}

	public void commitBoxDrag() {
		clearState();
	}

	protected List<RelativeBendpoint> createConstraint(Connection conn, List<PrecisionPoint> list) {
		List<RelativeBendpoint> constraint = new ArrayList<>();
		for (Point p : list) {
			RelativeBendpoint relbp = new RelativeBendpoint();
			relbp.setConnection(conn);
			relbpUtil.forceLocation(conn, relbp, p.preciseX(), p.preciseY());
			constraint.add(relbp);
		}
		return constraint;
	}

	/**
	 * Find first intersection with target box, walking from start to end.
	 *
	 * @param points
	 * @param rect
	 * @param isSelfAssoc
	 */
	protected void cutOffEnd(List<PrecisionPoint> points, Rectangle rect, boolean isSelfAssoc) {
		// determine top, right, bottom, and left sides
		final List<Line> segs = geom.getOutlineSegments(geom.toRectangle(rect));

		// need four points for self-associations
		int startIndex = isSelfAssoc ? 3 : 1;
		if (startIndex >= points.size()) {
			return;
		}

		// walk from start to end
		PrecisionPoint p1 = geom.toPP(points.get(startIndex - 1));
		for (int i = startIndex; i < points.size(); i++) {
			final PrecisionPoint p2 = geom.toPP(points.get(i));
			final Line line = new Line(p1, p2);
			final PrecisionPoint poi = geom.findNearestIntersection(line, segs, p1);
			if (poi != null) {
				for (int j = points.size() - 1; j >= i; j--) {
					points.remove(j);
				}
				if (p1.preciseX() == p2.preciseX()) {
					poi.setPreciseX(p1.preciseX());
				} else {
					poi.setPreciseY(p1.preciseY());
				}
				points.add(poi);
				return;
			}
			p1 = p2;
		}
	}

	/**
	 * Find first intersection with source box, walking from end to start.
	 *
	 * @param points
	 * @param rect
	 * @param isSelfAssoc
	 */
	protected void cutOffStart(List<PrecisionPoint> points, Rectangle rect, boolean isSelfAssoc) {
		// determine top, right, bottom, and left sides
		final List<Line> segs = geom.getOutlineSegments(geom.toRectangle(rect));

		// need at least four points for self-assocs
		int startIndex = isSelfAssoc ? points.size() - 4 : points.size() - 2;
		if ((startIndex < 0) || ((startIndex + 1) >= points.size())) {
			return;
		}

		// walk from end to start
		PrecisionPoint p2 = geom.toPP(points.get(startIndex + 1));
		for (int i = startIndex; i >= 0; i--) {
			final PrecisionPoint p1 = geom.toPP(points.get(i));
			final Line line = new Line(p1, p2);
			final PrecisionPoint poi = geom.findNearestIntersection(line, segs, p2);
			if (poi != null) {
				for (int j = i; j >= 0; j--) {
					points.remove(j);
				}
				if (p1.preciseX() == p2.preciseX()) {
					poi.setPreciseX(p1.preciseX());
				} else {
					poi.setPreciseY(p1.preciseY());
				}
				points.add(0, poi);
				return;
			}
			p2 = p1;
		}
	}

	protected void cutOutLoops(List<PrecisionPoint> points) {
		// loops are only possible with at least five points
		final int minLoopSize = 5;
		if (points.size() < minLoopSize) {
			return;
		}

		// search from start so that removals can happen without having to adjust
		// indices
		for (int i = points.size() - 1; i >= (minLoopSize - 1); i--) {
			final Line rearLine = new Line(geom.toPP(points.get(i - 1)), geom.toPP(points.get(i)));
			for (int j = 0; j <= ((i - minLoopSize) + 1); j++) {
				final Line frontLine = new Line(geom.toPP(points.get(j)), geom.toPP(points.get(j + 1)));
				final PrecisionPoint poi = geom.getIntersection(rearLine, frontLine);
//				System.out.println("intersect " + rearLine + " with " + frontLine + " yields " + poi);
				if (poi != null) {
					// replace all points from j + 1 ... i - 1 with the point of intersection
					for (int k = i - 1; k >= (j + 1); k--) {
						points.remove(k);
					}
					points.add(j + 1, poi);
					// XXX: due to continuous loop-removal, there should always be at most one loop
					return;
				}
			}
		}
	}

	protected void forceInitialLocations(ConnData cd) {
		Object routingConstraint = cd.conn.getRoutingConstraint();
		if (routingConstraint instanceof List) {
			List<?> bendpointList = (List<?>) routingConstraint;
			int index = 0;
			for (Object bpobj : bendpointList) {
				if (bpobj instanceof RelativeBendpoint) {
					RelativeBendpoint relBp = (RelativeBendpoint) bpobj;
					Point location = cd.initialBendpointLocations.get(index++);
					relbpUtil.forceLocation(cd.conn, relBp, location.preciseX(), location.preciseY());
				} else {
					System.err.println("[ERR] unknown bend point " + bpobj);
				}
			}
		} else if (routingConstraint != null) {
			System.out.println("[ERR] unknown routing constraint " + routingConstraint);
		}
		// request visual update
		cd.conn.invalidate();
	}

	private Rectangle getBounds(Connection conn, IFigure sourceOwner) {
		Rectangle sourceBox = sourceOwner.getBounds().getCopy();
		sourceOwner.translateToAbsolute(sourceBox);
		conn.translateToRelative(sourceBox);
		return sourceBox;
	}

	public void initBoxDrag(Rectangle originalAbs, List<Connection> sourceConnections,
			List<Connection> targetConnections) {
		// save original bounds in asbolute coordinates
		origDraggedBoundsAbs = originalAbs.getCopy();

		// clear connection data (FIXME: do this at the end of interaction, not at the
		// start)
		conn.clear();

		for (int i = 0; i < mmds.length; i++) {
			mmds[i] = new MaxMoveDelta((i % 2) != 0);
		}

		Map<Connection, Boolean> isSource = new IdentityHashMap<>();
		for (Connection c : sourceConnections) {
			isSource.put(c, true);
		}
		Map<Connection, Boolean> isTarget = new IdentityHashMap<>();
		for (Connection c : targetConnections) {
			isTarget.put(c, true);
		}
		List<Connection> pureSource = new ArrayList<>();
		List<Connection> reflexive = new ArrayList<>();
		for (Connection c : sourceConnections) {
			if (!isTarget.containsKey(c)) {
				pureSource.add(c);
			} else {
				reflexive.add(c);
			}
		}
		List<Connection> pureTarget = new ArrayList<>();
		for (Connection c : targetConnections) {
			if (!isSource.containsKey(c)) {
				pureTarget.add(c);
			}
		}
		initDrag(originalAbs, pureSource, true, false);
		initDrag(originalAbs, pureTarget, false, true);
		initDrag(originalAbs, reflexive, true, true);
	}

	private void initDrag(Rectangle originalAbc, List<Connection> connections, boolean isSource, boolean isTarget) {
		for (Connection connection : connections) {
			// disable repaint so that first drag does not let connection jump
//			((TransitionFigure) connection).disableRepaint();

			// save connection points
			ConnData cd = new ConnData(connection, isSource, isTarget);
			conn.put(connection, cd);

			// compute max move deltas
			MaxMoveDelta[] mmds = cd.getMaxMoveDeltas(originalAbc);

			// merge with current mmds
			for (int i = 0; i < this.mmds.length; i++) {
				this.mmds[i].merge(mmds[i]);
			}
		}
	}

	public void updateBoxDrag(Rectangle newBoundsAbs) {
		double dx = newBoundsAbs.preciseX() - origDraggedBoundsAbs.preciseX();
		double dy = newBoundsAbs.preciseY() - origDraggedBoundsAbs.preciseY();
		double dw = newBoundsAbs.preciseWidth() - origDraggedBoundsAbs.preciseWidth();
		double dh = newBoundsAbs.preciseHeight() - origDraggedBoundsAbs.preciseHeight();

		if ((dx == 0) && (dy == 0) && (dw == 0) && (dh == 0)) {
			return;
		} else {
//			System.out.println("bounds changed " + dx + ", " + dy + ", " + dw + ", " + dh);
		}

		for (ConnData cd : conn.values()) {
			// compute deltas in local coordinate system
			Rectangle brel = origDraggedBoundsAbs.getCopy();
			cd.conn.translateToRelative(brel);
			Rectangle bnrel = newBoundsAbs.getCopy();
			cd.conn.translateToRelative(bnrel);
			double localDx = bnrel.preciseX() - brel.preciseX();
			double localDy = bnrel.preciseY() - brel.preciseY();
			double localDw = bnrel.preciseWidth() - brel.preciseWidth();
			double localDh = bnrel.preciseHeight() - brel.preciseHeight();

			// drag anchored segment if necessary
			List<PrecisionPoint> pointsCopy = cd.getInitialVisualPointsCopy();
			if (cd.isSource) {
				if (cd.isSourceVertical) {
					double reqDx = mmds[cd.sourceSideIndex].reqDelta(localDx, localDw);
					if (reqDx != 0) {
						PrecisionPoint ap = pointsCopy.get(cd.sourceAnchorIndex);
						ap.setPreciseX(ap.preciseX() + reqDx);
						PrecisionPoint np = pointsCopy.get(cd.sourceNeighborIndex);
						np.setPreciseX(np.preciseX() + reqDx);
					}
				} else {
					double reqDy = mmds[cd.sourceSideIndex].reqDelta(localDy, localDh);
					if (reqDy != 0) {
						PrecisionPoint ap = pointsCopy.get(cd.sourceAnchorIndex);
						ap.setPreciseY(ap.preciseY() + reqDy);
						PrecisionPoint np = pointsCopy.get(cd.sourceNeighborIndex);
						np.setPreciseY(np.preciseY() + reqDy);
					}
				}
			}
			if (cd.isTarget) {
				if (cd.isTargetVertical) {
					double reqDx = mmds[cd.targetSideIndex].reqDelta(localDx, localDw);
					if (reqDx != 0) {
						PrecisionPoint ap = pointsCopy.get(cd.targetAnchorIndex);
						ap.setPreciseX(ap.preciseX() + reqDx);
						PrecisionPoint np = pointsCopy.get(cd.targetNeighborIndex);
						np.setPreciseX(np.preciseX() + reqDx);
					}
				} else {
					double reqDy = mmds[cd.targetSideIndex].reqDelta(localDy, localDh);
					if (reqDy != 0) {
						PrecisionPoint ap = pointsCopy.get(cd.targetAnchorIndex);
						ap.setPreciseY(ap.preciseY() + reqDy);
						PrecisionPoint np = pointsCopy.get(cd.targetNeighborIndex);
						np.setPreciseY(np.preciseY() + reqDy);
					}
				}
			}

//			cd.printVisualPoints();
//			cd.printPoints(pointsCopy);

			List<RelativeBendpoint> constraint = createConstraint(cd.conn, pointsCopy);
			ConnectionRouter router = cd.conn.getConnectionRouter();

			// disable repaint to prevent flickering when restoring original constraint
			// (hard to reproduce but happens)
//			((TransitionFigure) cd.conn).disableRepaint();
			router.setConstraint(cd.conn, constraint);
			router.route(cd.conn);

			// cut source, target, and loops
			List<PrecisionPoint> list = cd.getVisualPoints();

			IFigure targetOwner = cd.conn.getTargetAnchor().getOwner();
			IFigure sourceOwner = cd.conn.getSourceAnchor().getOwner();
			Rectangle targetBox = getBounds(cd.conn, targetOwner);
			boolean isSelfAssoc = targetOwner == sourceOwner;
			Rectangle sourceBox = isSelfAssoc ? targetBox : getBounds(cd.conn, sourceOwner);

			cutOffEnd(list, targetBox, isSelfAssoc);
			cutOffStart(list, sourceBox, isSelfAssoc);

			cutOutLoops(list);

			List<RelativeBendpoint> updatedConstraint = createConstraint(cd.conn, list);

//			((TransitionFigure) cd.conn).enableRepaint();
			router.setConstraint(cd.conn, updatedConstraint);
			router.route(cd.conn);

//			System.out.println("after all");
//			cd.printVisualPoints();
//			System.out.println();
		}
	}
}
