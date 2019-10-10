package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class ConnData {
	public Connection conn;
	public List<PrecisionPoint> initialVisualPoints = new ArrayList<>();
	public List<PrecisionPoint> initialBendpointLocations = new ArrayList<>();
	public List<PrecisionPoint> finalVisualPoints = new ArrayList<>();

	public ConnData(Connection conn) {
		this.conn = conn;
		PointList pl = conn.getPoints();
		for (int i = 0; i < pl.size(); i++) {
			Point p = pl.getPoint(i);
			initialVisualPoints.add(new PrecisionPoint(p));
		}
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
	
	public ConnData() {
		// TODO Auto-generated constructor stub
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
	
	public void printFinalLocations() {
		System.out.println("Final bendpoint locations for " + conn);
		for (Point point : finalVisualPoints) {
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

	public List<PrecisionPoint> getInitialVisualPointsCopy() {
		List<PrecisionPoint> copy = new ArrayList<>();
		for (PrecisionPoint p : initialVisualPoints) { 
			copy.add(new PrecisionPoint(p));
		}
		return copy;
	}
}