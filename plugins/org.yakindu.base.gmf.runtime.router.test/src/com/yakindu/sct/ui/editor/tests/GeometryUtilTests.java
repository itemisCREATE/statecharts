package com.yakindu.sct.ui.editor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.junit.Test;
import org.yakindu.base.gmf.runtime.router.GeometryUtil;
import org.yakindu.base.gmf.runtime.router.GeometryUtil.Line;

public class GeometryUtilTests {

	private GeometryUtil geom = new GeometryUtil();

	@Test
	public void test_line_intersection() {
		PrecisionPoint p1 = new PrecisionPoint(306.0, 258.0);
		PrecisionPoint p2 = new PrecisionPoint(540.0, 258.0);
		Line l1 = new GeometryUtil.Line(p1, p2);

		PrecisionPoint q1 = new PrecisionPoint(434.0, 63.0);
		PrecisionPoint q2 = new PrecisionPoint(434.0, 348.0);
		Line l2 = new GeometryUtil.Line(q1, q2);

		Point poi = geom.getIntersection(l1, l2);
		assertNotNull(poi);
		assertEquals(434.0, poi.preciseX(), 0.1);
		assertEquals(258.0, poi.preciseY(), 0.1);
	}

	@Test
	public void test_line_intersection_2() {
		PrecisionPoint p1 = new PrecisionPoint(434.0, 63.0);
		PrecisionPoint p2 = new PrecisionPoint(434.0, 348.0);
		Line l1 = new GeometryUtil.Line(p1, p2);

		PrecisionPoint q1 = new PrecisionPoint(244.0, 194.0);
		PrecisionPoint q2 = new PrecisionPoint(520.0, 194.0);
		Line l2 = new GeometryUtil.Line(q1, q2);

		Point poi = geom.getIntersection(l1, l2);
		assertNotNull(poi);
		assertEquals(434.0, poi.preciseX(), 0.1);
		assertEquals(194.0, poi.preciseY(), 0.1);
	}
}
