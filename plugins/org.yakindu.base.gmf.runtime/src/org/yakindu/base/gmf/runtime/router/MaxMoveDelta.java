package org.yakindu.base.gmf.runtime.router;

public class MaxMoveDelta {

	public boolean isVerticalMove;
	public double minDeltaPos;
	public double maxDeltaPos;

	public MaxMoveDelta() {
	}

	public MaxMoveDelta(boolean isVertical) {
		this.isVerticalMove = isVertical;
	}

	public MaxMoveDelta(boolean isVerticalMove, double minDelta, double maxDelta) {
		if (minDelta > 0) {
			minDelta = 0;
		}
		if (maxDelta < 0) {
			maxDelta = 0;
		}
		this.isVerticalMove = isVerticalMove;
		this.minDeltaPos = minDelta;
		this.maxDeltaPos = maxDelta;
	}

	public MaxMoveDelta(double minDelta, double maxDelta) {
		this(true, minDelta, maxDelta);
	}

	public void merge(MaxMoveDelta mmd) {
		if (isVerticalMove != mmd.isVerticalMove) {
			throw new IllegalArgumentException("Cannot merge MaxMoveDelta with different direction.");
		}
		if ((minDeltaPos == 0) || ((mmd.minDeltaPos < 0) && (mmd.minDeltaPos > minDeltaPos))) {
			minDeltaPos = mmd.minDeltaPos;
		}
		if ((maxDeltaPos == 0) || ((mmd.maxDeltaPos > 0) && (mmd.maxDeltaPos < maxDeltaPos))) {
			maxDeltaPos = mmd.maxDeltaPos;
		}
	}

	public double reqDelta(double deltaPos, double deltaSize) {
		double dt = deltaPos + (deltaSize < 0 ? deltaSize : 0);
		if (dt < minDeltaPos) {
			return dt - minDeltaPos;
		}
		if (dt > maxDeltaPos) {
			return dt - maxDeltaPos;
		}
		// TODO: special cases
		return 0;
	}

	@Override
	public String toString() {
		return isVerticalMove ? "{minDy=" + minDeltaPos + ",maxDy=" + maxDeltaPos + "}"
				: "{minDx=" + minDeltaPos + ",maxDx=" + maxDeltaPos + "}";
	}
}
