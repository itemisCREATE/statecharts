package org.yakindu.base.gmf.runtime.router;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

// XXX: Code copied from GEF 5 Geometry API (and adjusted).
// XXX: Non-OO API due to Draw2d integration (cannot modify Point).
// FIXME: Use GEF 5 Geometry API in order to profit from well-tested and maintained geometry computations ;-)
public class GeometryUtil {

	public static class Line {
		public PrecisionPoint source;
		public PrecisionPoint target;

		public Line(PrecisionPoint source, PrecisionPoint target) {
			this.source = source;
			this.target = target;
		}

		@Override
		public String toString() {
			return "[" + source + "--" + target + "]";
		}
	}

	public static class Rectangle {
		public double x;
		public double y;
		public double w;
		public double h;

		public Rectangle(double x, double y, double w, double h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}

	public static class Straight {
		public PrecisionPoint position;
		public PrecisionPoint direction;

		public Straight(PrecisionPoint start, PrecisionPoint direction) {
			this.position = start;
			this.direction = direction;
		}
	}

	public static class Straight3d {
		public V3 sp;
		public V3 line;
		public double f;

		public Straight3d(V3 sp, V3 line, double f) {
			this.sp = sp;
			this.line = line;
			this.f = f;
		}
	}

	public static class V3 {
		public double x;
		public double y;
		public double z;

		public V3(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public V3(Point p) {
			this(p.preciseX(), p.preciseY(), 1);
		}

		public PrecisionPoint toPoint() {
			if (z == 0) {
				return null;
			}
			return new PrecisionPoint(x / z, y / z);
		}
	}

	public boolean contains(Line line, Point p) {
		if (p == null) {
			return false;
		}
		if (equalsImprecise(line.source, p) || equalsImprecise(line.target, p)) {
			return true;
		}

		double distance = Math.abs(getSignedDistanceCCW(through(line.source, line.target), p));
		return equalsImprecise(distance, 0) && contains(getBounds(line), p);
	}

	public boolean contains(Rectangle r, Point p) {
		return (equalsImprecise(p.preciseY(), r.y) || (p.preciseY() > r.y))
				&& (equalsImprecise(p.preciseY(), r.y + r.h) || (p.preciseY() < (r.y + r.h)))
				&& (equalsImprecise(p.preciseX(), r.x) || (p.preciseX() > r.x))
				&& (equalsImprecise(p.preciseX(), r.x + r.w) || (p.preciseX() < (r.x + r.w)));
	}

	public boolean contains(Straight s, PrecisionPoint v) {
		return equalsImprecise(getDistance(s, v), 0d);
	}

	public boolean equalsImprecise(double a, double b) {
		return Math.abs(a - b) < getEpsilon();
	}

	public boolean equalsImprecise(Point p, Point q) {
		return equalsImprecise(p.preciseX(), q.preciseX()) && equalsImprecise(p.preciseY(), q.preciseY());
	}

	public PrecisionPoint findNearestIntersection(Line line, List<Line> segs, PrecisionPoint reference) {
		PrecisionPoint nearestPoi = null;
		double nearestDistance = Double.MAX_VALUE;
		for (final Line seg : segs) {
			final PrecisionPoint poi = getIntersection(seg, line);
			if (poi == null) {
				continue;
			}
			if (nearestPoi == null) {
				nearestPoi = poi;
				nearestDistance = getDistance(nearestPoi, reference);
			} else {
				final double distance = getDistance(poi, reference);
				if (distance < nearestDistance) {
					nearestPoi = poi;
					nearestDistance = distance;
				}
			}
		}
		return nearestPoi;
	}

	public PrecisionPoint getAdded(Point v, Point w) {
		return new PrecisionPoint(v.preciseX() + w.preciseX(), v.preciseY() + w.preciseY());
	}

	public PrecisionPoint getAdded(PrecisionPoint p, double dx, double dy) {
		return new PrecisionPoint(p.preciseX() + dx, p.preciseY() + dy);
	}

	public double getAngleRad(Point p, Point other) {
		double length = getLength(p) * getLength(other);
		if (length == 0) {
			throw new ArithmeticException("Division by zero.");
		}

		double cosAlpha = getDotProduct(p, other) / length;

		// compensate rounding effects
		if (cosAlpha > 1) {
			cosAlpha = 1;
		} else if (cosAlpha < -1) {
			cosAlpha = -1;
		}

		return Math.acos(cosAlpha);
	}

	public Rectangle getBounds(Line line) {
		double xmin = Math.min(line.source.x, line.target.x);
		double xmax = Math.max(line.source.x, line.target.x);
		double ymin = Math.min(line.source.y, line.target.y);
		double ymax = Math.max(line.source.y, line.target.y);
		return new Rectangle(xmin, ymin, xmax - xmin, ymax - ymin);
	}

	private V3 getCrossProduct(V3 v, V3 w) {
		return new V3((v.y * w.z) - (v.z * w.y), (v.z * w.x) - (v.x * w.z), (v.x * w.y) - (v.y * w.x));
	}

	public double getDistance(PrecisionPoint p, PrecisionPoint q) {
		return getLength(getSubtracted(p, q));
	}

	public double getDistance(Straight s, PrecisionPoint v) {
		return getDistance(getProjection(s, v), v);
	}

	public double getDotProduct(Point p, Point other) {
		return (p.preciseX() * other.preciseX()) + (p.preciseY() * other.preciseY());
	}

	public double getEpsilon() {
		return 0.00001;
	}

	public PrecisionPoint getIntersection(Line a, Line b) {
		PrecisionPoint p1 = a.source;
		PrecisionPoint p2 = a.target;

		// degenerated case
		if (equalsImprecise(p1, p2)) {
			if (contains(b, p1)) {
				return p1;
			} else if (contains(b, p2)) {
				return p2;
			}
			return null;
		}

		PrecisionPoint lp1 = b.source;
		PrecisionPoint lp2 = b.target;

		// degenerated case
		if (equalsImprecise(lp1, lp2)) {
			if (contains(a, lp1)) {
				return lp1;
			} else if (contains(a, lp2)) {
				return lp2;
			}
			return null;
		}

		Straight s1 = through(p1, p2);
		Straight s2 = through(lp1, lp2);

		if (isParallelTo(s1.direction, s2.direction)) {
			if (contains(s1, lp1) && contains(s1, lp2)) {
				// end-point-intersection? (no overlap)
				double u1 = getParameterAt(s1, lp1);
				double u2 = getParameterAt(s1, lp2);
				if ((equalsImprecise(u1, 0) && (u2 < u1)) || (equalsImprecise(u1, 1) && (u2 > u1))) {
					return lp1;
				} else if ((equalsImprecise(u2, 0) && (u1 < u2)) || (equalsImprecise(u2, 1) && (u1 > u2))) {
					return lp2;
				}
			}
			return null;
		}

		PrecisionPoint intersection = getIntersection(s1, s2);
		return contains(a, intersection) && contains(b, intersection) ? intersection : null;
	}

	public PrecisionPoint getIntersection(Straight s1, Straight s2) {
		PrecisionPoint p1 = getAdded(s1.position, s1.direction);
		PrecisionPoint p2 = getAdded(s2.position, s2.direction);
		V3 l1 = getCrossProduct(new V3(s1.position.x, s1.position.y, 1), new V3(p1));
		V3 l2 = getCrossProduct(new V3(s2.position.x, s2.position.y, 1), new V3(p2));
		PrecisionPoint poi = getCrossProduct(l1, l2).toPoint();
		return poi;
	}

	public double getLength(Point vector) {
		return Math.sqrt(getDotProduct(vector, vector));
	}

	public PrecisionPoint getNormalized(Point vector) {
		double f = 1 / getLength(vector);
		return new PrecisionPoint(f * vector.preciseX(), f * vector.preciseY());
	}

	public PrecisionPoint getOrthogonalComplement(Point vector) {
		return new PrecisionPoint(-vector.preciseY(), vector.preciseX());
	}

	public List<Line> getOutlineSegments(Rectangle rect) {
		List<Line> segs = new ArrayList<>();
		segs.add(new Line(new PrecisionPoint(rect.x, rect.y), new PrecisionPoint(rect.x + rect.w, rect.y)));
		segs.add(new Line(new PrecisionPoint(rect.x + rect.w, rect.y),
				new PrecisionPoint(rect.x + rect.w, rect.y + rect.h)));
		segs.add(new Line(new PrecisionPoint(rect.x + rect.w, rect.y + rect.h),
				new PrecisionPoint(rect.x, rect.y + rect.h)));
		segs.add(new Line(new PrecisionPoint(rect.x, rect.y + rect.h), new PrecisionPoint(rect.x, rect.y)));
		return segs;
	}

	public double getParameterAt(Straight s, PrecisionPoint p) {
		if (!contains(s, p)) {
			throw new IllegalArgumentException(
					"The given position Vector has to be on this Straight: getParameterAt(" + s + ", " + p + ")");
		}

		if (Math.abs(s.direction.preciseX()) > Math.abs(s.direction.preciseY())) {
			return (p.preciseX() - s.position.preciseX()) / s.direction.preciseX();
		}
		if (s.direction.preciseY() != 0) {
			return (p.preciseY() - s.position.preciseY()) / s.direction.preciseY();
		}

		throw new IllegalStateException(
				"The direction Vector of this Straight may not be (0, 0) for this computation: getParameterAt(" + s
						+ ", " + p + ")");
	}

	public PrecisionPoint getProjection(Straight s, PrecisionPoint vector) {
		// calculate with a normalized direction vector to prevent rounding
		// effects
		PrecisionPoint normalized = getNormalized(s.direction);

		// to compensate rounding problems with large vectors, we shift
		// straight and given vector by the straight's position vector before
		// the computation and back before returning the computed projection.
		Straight s1 = new Straight(new PrecisionPoint(0d, 0d), normalized);
		Straight s2 = new Straight(getSubtracted(vector, s.position), getOrthogonalComplement(normalized));
		return getAdded(getIntersection(s1, s2), s.position);
	}

	public double getSignedDistanceCCW(Straight s, Point p) {
		// XXX: code is a little strange, but kept close to original GEF 5
		// implementation
		Point r = p;
		p = s.position;
		Point q = getAdded(s.position, s.direction);
		Straight3d s3d = through3d(p, q);
		if (s3d == null) {
			return 0d;
		}
		double sd = -getSignedDistanceCW(s3d, new V3(r.preciseX(), r.preciseY(), 1));
		return sd;
	}

	public double getSignedDistanceCW(Straight3d s3d, V3 v3) {
		return ((s3d.line.x * v3.x) + (s3d.line.y * v3.y) + s3d.line.z) / s3d.f;
	}

	public PrecisionPoint getSubtracted(PrecisionPoint v, PrecisionPoint w) {
		return new PrecisionPoint(v.preciseX() - w.preciseX(), v.preciseY() - w.preciseY());
	}

	public boolean isParallelTo(Point v, Point w) {
		double rad = getAngleRad(v, w);
		rad *= 2d;
		rad = normalizeRad(rad);
		return equalsImprecise(rad, 0d);
	}

	public double normalizeRad(double rad) {
		rad -= 2 * Math.PI * Math.floor(rad / (2 * Math.PI));
		return rad;
	}

	public Straight through(PrecisionPoint p, PrecisionPoint q) {
		return new Straight(p, getSubtracted(q, p));
	}

	public Straight3d through3d(Point p, Point q) {
		V3 sp = new V3(p);
		V3 line = getCrossProduct(sp, new V3(q));

		double f = Math.sqrt((line.x * line.x) + (line.y * line.y));
		if (f == 0d) {
			return null;
		}

		Straight3d self = new Straight3d(sp, line, f);
		return self;
	}

	public PrecisionPoint toPP(Point point) {
		return point instanceof PrecisionPoint ? (PrecisionPoint) point
				: new PrecisionPoint(point.preciseX(), point.preciseY());
	}

	public Rectangle toRectangle(org.eclipse.draw2d.geometry.Rectangle rect) {
		return new Rectangle(rect.preciseX(), rect.preciseY(), rect.preciseWidth(), rect.preciseHeight());
	}
}
