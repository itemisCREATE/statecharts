package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.HashMap;
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

	public void initBoxDrag(Rectangle original, List<Connection> connections) {
		conn.clear(); // only temporary for debugging
		for (Connection connection : connections) {
//			((TransitionFigure) connection).disableRepaint();
			conn.put(connection, new ConnData(connection));
		}
	}

	public void updateBoxDrag(Rectangle newBounds) {
//		if (1 < 2) return;
		for (ConnData cd : conn.values()) {
			List<RelativeBendpoint> constraint = createConstraint(cd.conn, cd.initialVisualPoints);
			ConnectionRouter router = cd.conn.getConnectionRouter();
			
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
		}
	}

	private Rectangle getBounds(Connection conn, IFigure sourceOwner) {
		Rectangle sourceBox = sourceOwner.getBounds().getCopy();
		sourceOwner.translateToAbsolute(sourceBox);
		conn.translateToRelative(sourceBox);
		return sourceBox;
	}
	
	protected List<RelativeBendpoint> createConstraint(Connection conn, List<PrecisionPoint> list) {
		List<RelativeBendpoint> constraint = new ArrayList<RelativeBendpoint>();
		for (Point p : list) {
			RelativeBendpoint relbp = new RelativeBendpoint();
			relbp.setConnection(conn);
			relbpUtil.forceLocation(conn, relbp, p.preciseX(), p.preciseY());
			constraint.add(relbp);
		}
		return constraint;
	}

	public void commitBoxDrag() {
		clearState();
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

	public void abortBoxDrag() {
		clearState();
	}

	protected void clearState() {
		//conn.clear();
	}
	
	// TODO: reflexive transitions
	
	protected void cutOutLoops(List<PrecisionPoint> points) {
		// loops are only possible with at least five points
		final int minLoopSize = 5;
		if (points.size() < minLoopSize) {
			return;
		}

		// search from start so that removals can happen without having to adjust indices
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
	
	protected void cutOffEnd(List<PrecisionPoint> points, Rectangle rect, boolean isSelfAssoc) {
		// find first intersection with target box, walking from start to end
		final List<Line> segs = geom.getOutlineSegments(geom.toRectangle(rect));
		
		PrecisionPoint p1 = geom.toPP(points.get(0));
		for (int i = 1; i < points.size(); i++) {
			final PrecisionPoint p2 = geom.toPP(points.get(i));
			final Line line = new Line(p1, p2);
			final PrecisionPoint poi = geom.findNearestIntersection(line, segs, p1);
			if (poi != null) {
				if (isSelfAssoc) {
					// need at least four points when laying out self-associations
					if (i < 3) {
						p1 = p2;
						continue;
					}
				}
				for (int j = points.size() - 1; j >= i; j--) {
					points.remove(j);
				}
				if (p1.x==p2.x) {
					poi.x = p1.x;
				} else {
					poi.y = p1.y;
				}
				points.add(poi);
				return;
			}
			p1 = p2;
		}
	}

	protected void cutOffStart(List<PrecisionPoint> points, Rectangle rect, boolean isSelfAssoc) {
		// find first intersection with source box, walking from end to start
		final List<Line> segs = geom.getOutlineSegments(geom.toRectangle(rect));
		PrecisionPoint p2 = geom.toPP(points.get(points.size() - 1));
		for (int i = points.size() - 2; i >= 0; i--) {
			final PrecisionPoint p1 = geom.toPP(points.get(i));
			final Line line = new Line(p1, p2);
			final PrecisionPoint poi = geom.findNearestIntersection(line, segs, p2);
			if (poi != null) {
				if (isSelfAssoc) {
					// need at least four points when laying out self-associations
					if (points.size() - 1 - i < 3) {
						p2 = p1;
						continue;
					}
				}
				for (int j = i; j >= 0; j--) {
					points.remove(j);
				}
				if (p1.x==p2.x) {
					poi.x = p1.x;
				} else {
					poi.y = p1.y;
				}
				points.add(0, poi);
				return;
			}
			p2 = p1;
		}
	}
}
