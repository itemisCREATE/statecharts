package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class ConnData {
	public Connection conn;
	public List<PrecisionPoint> initialVisualPoints = new ArrayList<>();
	public List<PrecisionPoint> initialBendpointLocations = new ArrayList<>();
	public List<PrecisionPoint> finalVisualPoints = new ArrayList<>();
	public boolean isSource;
	public boolean isTarget;
	public boolean isReflexive;
	public int sourceAnchorIndex = -1;
	public int sourceNeighborIndex = -1;
	public int targetAnchorIndex = -1;
	public int targetNeighborIndex = -1;
	public boolean isSourceVertical = false;
	public boolean isTargetVertical = false;
	public int sourceSideIndex = -1;
	public int targetSideIndex = -1;

	public double SideDistance = 10d;

	public ConnData() {
		// FIXME: remove, refactor printPoints() etc.
	}

	public ConnData(Connection conn, boolean isSource, boolean isTarget) {
		this.conn = conn;
		this.isSource = isSource;
		this.isTarget = isTarget;
		this.isReflexive = isSource && isTarget;

		// initial points
		PointList pl = conn.getPoints();
		for (int i = 0; i < pl.size(); i++) {
			Point p = pl.getPoint(i);
			initialVisualPoints.add(new PrecisionPoint(p));
		}

		// anchored segment
		int initialPointsSize = initialVisualPoints.size();
		if (initialPointsSize > 1) {
			if (isSource) {
				sourceAnchorIndex = 0;
				sourceNeighborIndex = 1;
				isSourceVertical = initialVisualPoints.get(sourceAnchorIndex).preciseX() == initialVisualPoints
						.get(sourceNeighborIndex).preciseX();
			}
			if (isTarget) {
				targetAnchorIndex = initialPointsSize - 1;
				targetNeighborIndex = initialPointsSize - 2;
				isTargetVertical = initialVisualPoints.get(targetAnchorIndex).preciseX() == initialVisualPoints
						.get(targetNeighborIndex).preciseX();
			}
		}

		// initial bendpoints
		Object routingConstraint = conn.getRoutingConstraint();
		if (routingConstraint instanceof List) {
			List<?> bendpointList = (List<?>) routingConstraint;
			for (Object bpobj : bendpointList) {
				if (bpobj instanceof RelativeBendpoint) {
					RelativeBendpoint relBp = (RelativeBendpoint) bpobj;
					Point bp = relBp.getLocation();
					initialBendpointLocations.add(new PrecisionPoint(bp));
				} else {
					System.err.println("[ERR] unknown bend point " + bpobj);
				}
			}
		} else if (routingConstraint != null) {
			System.out.println("[ERR] unknown routing constraint " + routingConstraint);
		}
	}

	public List<PrecisionPoint> getInitialVisualPointsCopy() {
		List<PrecisionPoint> copy = new ArrayList<>();
		for (PrecisionPoint p : initialVisualPoints) {
			copy.add(new PrecisionPoint(p));
		}
		return copy;
	}

	private MaxMoveDelta getMaxMoveDelta(Rectangle relBounds, boolean isVertical, PrecisionPoint anchorPoint) {
		if (isVertical) {
			// move in X
			double x = anchorPoint.preciseX();
			double bx = relBounds.preciseX() + SideDistance;
			double bx2 = (bx + relBounds.preciseWidth()) - SideDistance - SideDistance;
			if (x < bx) {
				x = bx;
			}
			if (x > bx2) {
				x = bx2;
			}
			return new MaxMoveDelta(true, x - bx2, x - bx);
		} else {
			// move in Y
			double y = anchorPoint.preciseY();
			double by = relBounds.preciseY() + SideDistance;
			double by2 = (by + relBounds.preciseHeight()) - SideDistance - SideDistance;
			if (y < by) {
				y = by;
			}
			if (y > by2) {
				y = by2;
			}
			return new MaxMoveDelta(false, y - by2, y - by);
		}
	}

	public MaxMoveDelta[] getMaxMoveDeltas(Rectangle relBounds) {
		MaxMoveDelta[] mmds = new MaxMoveDelta[] { new MaxMoveDelta(true), new MaxMoveDelta(), new MaxMoveDelta(true),
				new MaxMoveDelta() };
		if (initialVisualPoints.size() < 2) {
			// need two points for max-move-deltas
			return mmds;
		}
		// merge in deltas for source and/or target
		if (isSource) {
			boolean isVertical = isSourceVertical;
			PrecisionPoint anchorPoint = initialVisualPoints.get(sourceAnchorIndex);
			MaxMoveDelta mmd = getMaxMoveDelta(relBounds, isVertical, anchorPoint);
			sourceSideIndex = getSideIndex(relBounds, isVertical, anchorPoint);
			mmds[sourceSideIndex].merge(mmd);
		}
		if (isTarget) {
			boolean isVertical = isTargetVertical;
			PrecisionPoint anchorPoint = initialVisualPoints.get(targetAnchorIndex);
			MaxMoveDelta mmd = getMaxMoveDelta(relBounds, isVertical, anchorPoint);
			targetSideIndex = getSideIndex(relBounds, isVertical, anchorPoint);
			mmds[targetSideIndex].merge(mmd);
		}
		return mmds;
	}

	private int getSideIndex(Rectangle relBounds, boolean isVertical, PrecisionPoint anchorPoint) {
		int index;
		if (isVertical) {
			if (relBounds.getTop().getDistance(anchorPoint) < relBounds.getBottom().getDistance(anchorPoint)) {
				// top
				index = 0;
			} else {
				// bottom
				index = 2;
			}
		} else {
			if (relBounds.getLeft().getDistance(anchorPoint) < relBounds.getRight().getDistance(anchorPoint)) {
				// left
				index = 1;
			} else {
				// right
				index = 3;
			}
		}
		return index;
	}

	public List<PrecisionPoint> getVisualPoints() {
		List<PrecisionPoint> list = new ArrayList<>();
		PointList pointList = conn.getPoints();
		for (int i = 0; i < pointList.size(); i++) {
			list.add(new PrecisionPoint(pointList.getPoint(i)));
		}
		return list;
	}

	public void printBendpointLocations() {
		System.out.println("Bendpoints for " + conn);
		Object routingConstraint = conn.getRoutingConstraint();
		if (routingConstraint instanceof List) {
			List<?> bendpointList = (List<?>) routingConstraint;
			for (Object bpobj : bendpointList) {
				if (bpobj instanceof RelativeBendpoint) {
					RelativeBendpoint relBp = (RelativeBendpoint) bpobj;
					Point bp = relBp.getLocation();
					System.out.println("- " + bp);
				} else {
					System.err.println("[ERR] unknown bend point " + bpobj);
				}
			}
		} else if (routingConstraint != null) {
			System.out.println("[ERR] unknown routing constraint " + routingConstraint);
		}
	}

	public void printFinalLocations() {
		System.out.println("Final bendpoint locations for " + conn);
		for (Point point : finalVisualPoints) {
			System.out.println("- " + point);
		}
	}

	public void printInitialLocations() {
		System.out.println("Initial bendpoint locations for " + conn);
		for (Point point : initialBendpointLocations) {
			System.out.println("- " + point);
		}
	}

	public void printPoints(List<? extends Point> points) {
		for (Point point : points) {
			System.out.println("- " + point);
		}
	}

	public void printVisualPoints() {
		System.out.println("Visual Points for " + conn);
		PointList pointList = conn.getPoints();
		for (int i = 0; i < pointList.size(); i++) {
			Point p = pointList.getPoint(i);
			System.out.println("- " + p);
		}
	}
}