/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */

package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class ColorHelper {
	public static double getShadePercentage(Color color) {
		HSL hsl = HSL.fromRGB(color.getRGB());
		return hsl.getL();
	}

	public static Color getColorShade(Color color, double shade) {
		HSL hsl = HSL.fromRGB(color.getRGB());

		hsl.setL(shade);

		RGB rgb = hsl.getRGB();

		return new Color(color.getDevice(), rgb.red, rgb.green, rgb.blue, color.getAlpha());
	}

	public static Color modifyColorShade(Color color, double factor) {
		HSL hsl = HSL.fromRGB(color.getRGB());

		double l = hsl.getL() * factor;
		l = Math.max(Math.min(l, 1), 0);
		hsl.setL(l);

		RGB rgb = hsl.getRGB();
		return new Color(color.getDevice(), rgb.red, rgb.green, rgb.blue, color.getAlpha());
	}

	/**
	 * Calculates from and to HSL color space.
	 *
	 * Source of all calculations:
	 * <a>http://www.niwa.nu/2013/05/math-behind-colorspace-conversions-rgb-hsl/</a>
	 *
	 * @author rbeckmann
	 *
	 */
	public static class HSL {
		protected double h, s, l;

		public HSL(double h, double s, double l) {
			super();
			this.h = h;
			this.s = s;
			this.l = l;
		}

		public double getH() {
			return h;
		}

		public double getS() {
			return s;
		}

		public double getL() {
			return l;
		}

		public void setL(double l) {
			this.l = l;
		}

		public static HSL fromRGB(RGB rgb) {
			double h, s, l, r, g, b, min, max;

			r = (double) rgb.red / 255f;
			g = (double) rgb.green / 255f;
			b = (double) rgb.blue / 255f;

			min = min(r, g, b);
			max = max(r, g, b);

			l = (min + max) / 2;

			if (rgb.red == rgb.green && rgb.red == rgb.blue) {
				s = 0;
				h = 0;
			} else {
				if (l < 0.5) {
					s = (max - min) / (max + min);
				} else {
					s = (max - min) / (2.0 - max - min);
				}

				if (r == max) {
					h = (g - b) / (max - min);
				} else if (g == max) {
					h = 2.0 + ((b - r) / (max - min));
				} else if (b == max) {
					h = 4.0 + ((r - g) / (max - min));
				} else {
					h = 0;
				}
				h = h * 60;
				if (h < 0) {
					h += 360;
				}
			}

			return new HSL(h, s, l);
		}

		public RGB getRGB() {
			int r, g, b;
			double t1, t2, tR, tG, tB, h;

			if (s == 0.0) {
				r = g = b = (int) Math.round(l * 255);
				return new RGB(r, g, b);
			}

			if (l < 0.5) {
				t1 = l * (1.0 + s);
			} else {
				t1 = l + s - (l * s);
			}

			t2 = 2 * l - t1;

			h = this.h / 360;

			tR = normalize(h + 0.333);
			tG = normalize(h);
			tB = normalize(h - 0.333);

			r = getColorBand(tR, t1, t2);
			g = getColorBand(tG, t1, t2);
			b = getColorBand(tB, t1, t2);

			return new RGB(r, g, b);
		}

		protected static int getColorBand(double tC, double t1, double t2) {
			double c;
			if (6 * tC < 1.0) {
				c = t2 + (t1 - t2) * 6 * tC;
			} else if (2 * tC < 1.0) {
				c = t1;
			} else if (3 * tC < 2.0) {
				c = t2 + (t1 - t2) * (0.666 - tC) * 6;
			} else {
				c = t2;
			}
			return (int) Math.round(c * 255f);
		}

		protected static double min(double a, double b, double c) {
			return Math.min(a, Math.min(b, c));
		}

		protected static double max(double a, double b, double c) {
			return Math.max(a, Math.max(b, c));
		}

		protected static double normalize(double d) {
			while (d > 1.0) {
				d -= 1.0;
			}
			while (d < 0.0) {
				d += 1.0;
			}
			return d;
		}
	}

}
