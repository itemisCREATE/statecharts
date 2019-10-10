package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class RelativeBendpointUtil {
	
	public void forceLocation(Connection conn, RelativeBendpoint relbp, double locX, double locY) {
		float w = 0;
		Dimension d2 = new Dimension();
		PrecisionDimension d1 = new PrecisionDimension();
		
		// compute d1 based on source anchor
		PrecisionPoint a1 = new PrecisionPoint(conn
				.getSourceAnchor().getReferencePoint());
		Point a1Copy = a1.getCopy();
		conn.translateToRelative(a1Copy);
		
		//     x = a1.preciseX() + d1.preciseWidth()
		// <=> x - a1.preciseX() = d1.preciseWidth()
		d1.setPreciseWidth(locX - a1Copy.preciseX());
		d1.setPreciseHeight(locY - a1Copy.preciseY());
		
		relbp.setRelativeDimensions(d1, d2);
		relbp.setWeight(w);
		
		// ensure location is correct
		Point location = relbp.getLocation();
		if (Math.abs(location.preciseX() - locX) > 0.1) {
			throw new IllegalStateException("cannot force location-x: expected <" + locX + "> but got <" + location.preciseX() + ">");
		}
		if (Math.abs(location.preciseY() - locY) > 0.1) {
			throw new IllegalStateException("cannot force location-y: expected <" + locY + "> but got <" + location.preciseY() + ">");
		}
	}
	
	public List<Point> convertConstraintToListOfPoint(Connection conn) {
		List<Point> list = new ArrayList<Point>();
		Object routingConstraint = conn.getRoutingConstraint();
		if (routingConstraint instanceof List) {
			List<?> bendpointList = (List<?>) routingConstraint;
			for (Object bpobj : bendpointList) {
				if (bpobj instanceof RelativeBendpoint) {
					list.add(((RelativeBendpoint) bpobj).getLocation());
				} else {
					System.err.println("[ERR] unknown bend point " + bpobj);
				}
			}
		} else if (routingConstraint != null) {
			System.out.println("[ERR] unknown routing constraint " + routingConstraint);
		}
		return list;
	}
}
