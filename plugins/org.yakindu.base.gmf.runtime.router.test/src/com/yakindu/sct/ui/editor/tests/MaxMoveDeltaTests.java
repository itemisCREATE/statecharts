package com.yakindu.sct.ui.editor.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.yakindu.base.gmf.runtime.router.MaxMoveDelta;

public class MaxMoveDeltaTests {

	@Test
	public void test_dx_dw_simple() {
		MaxMoveDelta mmd = new MaxMoveDelta(false, -10, 10);

		// moved/resized until the edge
		assertEquals(0, mmd.reqDelta(10, 0), 0);
		assertEquals(0, mmd.reqDelta(-10, 0), 0);
		assertEquals(0, mmd.reqDelta(0, -10), 0);

		// growing further is OK
		assertEquals(0, mmd.reqDelta(0, 11), 0);

		// shrinking further needs adjustment
		assertEquals(-1, mmd.reqDelta(0, -11), 0);

		// moving out of range
		assertEquals(-1, mmd.reqDelta(-11, 0), 0);
		assertEquals(1, mmd.reqDelta(11, 0), 0);

		// (move + resize) out of range
		assertEquals(-1, mmd.reqDelta(-10, -1), 0);
	}

	@Test
	public void test_dy_dh_simple() {
		MaxMoveDelta mmd = new MaxMoveDelta(true, -10, 10);

		// moved/resized until the edge
		assertEquals(0, mmd.reqDelta(10, 0), 0);
		assertEquals(0, mmd.reqDelta(-10, 0), 0);
		assertEquals(0, mmd.reqDelta(0, -10), 0);

		// growing further is OK
		assertEquals(0, mmd.reqDelta(0, 11), 0);

		// shrinking further needs adjustment
		assertEquals(-1, mmd.reqDelta(0, -11), 0);

		// moving out of range
		assertEquals(-1, mmd.reqDelta(-11, 0), 0);
		assertEquals(1, mmd.reqDelta(11, 0), 0);

		// (move + resize) out of range
		assertEquals(-1, mmd.reqDelta(-10, -1), 0);
	}
}
