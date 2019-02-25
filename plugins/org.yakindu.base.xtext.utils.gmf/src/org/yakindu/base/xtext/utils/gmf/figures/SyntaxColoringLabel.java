/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.xtext.utils.gmf.figures;

import java.util.concurrent.ExecutionException;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.text.FlowUtilitiesEx;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextUtilitiesEx;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SyntaxColoringLabel extends WrappingLabel implements MouseMotionListener {

	private static final MarginBorder NO_FOCUS_BORDER = new MarginBorder(new Insets(1, 1, 1, 1));
	private static final LineBorder FOCUS_BORDER = new LineBorder(ColorConstants.lightGray);
	private StyledTextFlow textFlow;

	public SyntaxColoringLabel() {
		setBorder(NO_FOCUS_BORDER);
		addMouseMotionListener(this);
		setTextFlow();
	}

	@SuppressWarnings("unchecked")
	protected void setTextFlow() {
		textFlow = new StyledTextFlow();
		textFlow.setParent(getTextFigure());
		getTextFigure().getChildren().set(0, textFlow);
		setLayoutManager(textFlow, false);
	}

	public void setZoom(double zoom) {
		textFlow.zoom = zoom;
	}

	public void setHighlight(boolean highlight) {
		textFlow.setHighlight(highlight);
	}

	public boolean isHighlight() {
		return textFlow.isHighlight();
	}

	public void setRanges(StyleRange[] ranges) {
		textFlow.setRanges(ranges);
	}

	public void mouseEntered(MouseEvent me) {
		setBorder(FOCUS_BORDER);
	}

	public void mouseExited(MouseEvent me) {
		setBorder(NO_FOCUS_BORDER);
	}

	public void mouseDragged(MouseEvent me) {
		// Nothing to do
	}

	public void mouseHover(MouseEvent me) {
		// Nothing to do
	}

	public void mouseMoved(MouseEvent me) {
		// Nothing to do
	}

	protected static class StyledTextFlow extends TextFlowEx {

		private FlowUtilitiesEx flowUtilities;
		private StyleTextUtilities textUtilities;
		private static final Image dummy = new Image(Display.getDefault(), 1, 1);
		private static final GC gc = new GC(dummy);
		private Font boldFont;
		private double zoom = 1.0;
		private boolean highlight = true;
		private int fromIndex = 0;

		public void setHighlight(boolean highlight) {
			this.highlight = highlight;
		}

		public boolean isHighlight() {
			return highlight;
		}

		private StyleRange[] ranges = new StyleRange[0];

		public StyleRange[] getRanges() {
			return ranges;
		}

		public void setRanges(StyleRange[] ranges) {
			this.ranges = ranges;
		}

		@Override
		protected void layout() {
			super.layout();
		}

		@Override
		public void setFont(Font f) {
			super.setFont(f);
			setBoldFont(f);
		}

		protected void setBoldFont(Font f) {
			if (boldFont != null)
				boldFont.dispose();
			FontDescriptor boldDescriptor = FontDescriptor.createFrom(getFont()).setStyle(SWT.BOLD);
			boldFont = boldDescriptor.createFont(Display.getDefault());
		}

		@Override
		protected void paintFigure(Graphics g) {
			fromIndex = 0;
			super.paintFigure(g);
		}

		@Override
		protected void paintText(Graphics g, String draw, int x, int y, int bidiLevel) {
			if (!highlight) {
				super.paintText(g, draw, x, y, bidiLevel);
				return;
			}
			if (ranges.length == 0) {
				draw = replaceTabs(draw);
				super.paintText(g, draw, x, y, bidiLevel);
				return;
			}
			if (bidiLevel == -1) {
				String originalDraw = draw;
				int paintOffset = 0;
				int lineOffset = getText().indexOf(originalDraw, Math.min(fromIndex, getText().length() - 1));
				fromIndex += originalDraw.length();
				if (lineOffset == -1) {
					// This may happen if the string is truncated with '..'
					originalDraw = replaceTabs(originalDraw);
					super.paintText(g, originalDraw, x, y, bidiLevel);
					return;
				}
				try {
					g.pushState();
					g.setFont(getFont());
					for (StyleRange range : ranges) {
						int beginIndex = range.start - lineOffset;
						if (beginIndex > draw.length()) {
							break;
						}
						Font font = SWT.BOLD == (range.fontStyle & SWT.BOLD) ? boldFont : getFont();
						if (font != g.getFont()) {
							g.setFont(font);
						}
						g.setForegroundColor(range.foreground != null ? range.foreground : getForegroundColor());
						g.setBackgroundColor(range.background != null ? range.background : getBackgroundColor());
						int endIndex = beginIndex + range.length;
						String substring = draw.substring(beginIndex > 0 ? beginIndex : 0,
								Math.min(endIndex > 0 ? endIndex : 0, draw.length()));
						substring = replaceTabs(substring);
						g.drawText(substring, x + paintOffset, y);

						int offset = getTextExtend(g.getFont(), substring);
						paintOffset += offset;
					}
				} finally {
					g.popState();
				}
			} else {
				super.paintText(g, draw, x, y, bidiLevel);
			}
		}

		protected String replaceTabs(String draw) {
			return draw.replaceAll("\t", "    ");
		}

		protected int getTextExtend(Font font, String string) {
			if (string.isEmpty())
				return 0;
			if (zoom != 1.0) {
				FontData data = font.getFontData()[0];
				FontDescriptor newFontDescriptor = FontDescriptor.createFrom(font)
						.setHeight((int) (data.getHeight() * zoom));
				font = newFontDescriptor.createFont(Display.getDefault());
			}
			if (gc.getFont() != font)
				gc.setFont(font);
			int offset = gc.textExtent(string).x;
			if (zoom != 1.0) {
				font.dispose();
			}
			return (int) Math.ceil((offset / zoom));
		}

		@Override
		public FlowUtilitiesEx getFlowUtilities() {
			if (flowUtilities == null) {
				flowUtilities = new FlowUtilitiesEx(MapModeUtil.getMapMode(this)) {
					@Override
					protected TextUtilities getTextUtilities() {
						if (textUtilities == null) {
							textUtilities = new StyleTextUtilities(MapModeUtil.getMapMode(StyledTextFlow.this));
						}
						return textUtilities;
					}
				};
			}
			return flowUtilities;
		}

		@Override
		public void invalidate() {
			if (textUtilities != null) {
				textUtilities.invalidate();
			}
			super.invalidate();
		}

		protected class StyleTextUtilities extends TextUtilitiesEx {

			protected LoadingCache<String, Dimension> cache;

			public StyleTextUtilities(IMapMode mapmode) {
				super(mapmode);
				cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Dimension>() {
					@Override
					public Dimension load(String key) throws Exception {
						return getTextExtentsInternal(key, getFont());
					}
				});
			}

			@Override
			public Dimension getTextExtents(String draw, Font f) {
				try {
					return cache.get(draw);
				} catch (ExecutionException e) {
					e.printStackTrace();
					return super.getTextExtents(draw, f);
				}
			}

			/**
			 * Add bold font size to label dimension
			 */
			protected Dimension getTextExtentsInternal(String draw, Font f) {
				draw = replaceTabs(draw);
				Dimension d = super.getTextExtents(draw, f).getCopy();
				int paintOffset = 0;
				int lineOffset = getText().indexOf(draw);
				for (StyleRange range : ranges) {
					int beginIndex = range.start - lineOffset;
					if (beginIndex > draw.length()) {
						break;
					}
					int endIndex = beginIndex + range.length;
					String substring = draw.substring(beginIndex > 0 ? beginIndex : 0,
							Math.min(endIndex > 0 ? endIndex : 0, draw.length()));
					Font font = SWT.BOLD == (range.fontStyle & SWT.BOLD) ? boldFont : getFont();
					int offset = getTextExtend(font, substring);
					paintOffset += offset;
				}
				d.width = Math.max(d.width, paintOffset);
				return d;

			}

			public void invalidate() {
				cache.invalidateAll();
			}
		}
	}
}
