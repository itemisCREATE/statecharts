package org.yakindu.sct.ui.editor.editor;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.ViewportAwareConnectionLayerClippingStrategy;
import org.eclipse.draw2d.ViewportUtilities;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

//TODO: Remove me when the following bug is rolled out with 3.8
//@see Eclipse GEF Bug 374413 - ViewportAwareConnectionLayerClippingStrategy
//should not rely on anchor points of connections being inside source and target bounds.

public class FixedViewportAwareConnectionLayerClippingStrategy extends
		ViewportAwareConnectionLayerClippingStrategy {
	public FixedViewportAwareConnectionLayerClippingStrategy(
			ConnectionLayer connectionLayer) {
		super(connectionLayer);
	}

	private final Insets PRIVATE_INSETS = new Insets(0, 0, 1, 1);

	/**
	 * Computes clipping rectangle(s) for a given connection. Will consider all
	 * enclosing viewports, excluding the root viewport.
	 */
	protected Rectangle[] getEdgeClippingRectangle(Connection connection) {
		// start with clipping the connection at its original bounds
		Rectangle clipRect = getAbsoluteBoundsAsCopy(connection);

		// in case we cannot infer source and target of the connection (e.g.
		// if XYAnchors are used), returning the bounds is all we can do
		ConnectionAnchor sourceAnchor = connection.getSourceAnchor();
		ConnectionAnchor targetAnchor = connection.getTargetAnchor();
		if (sourceAnchor == null || sourceAnchor.getOwner() == null
				|| targetAnchor == null || targetAnchor.getOwner() == null) {
			return new Rectangle[] { clipRect };
		}

		// source and target figure are known, see if there is common
		// viewport
		// the connection has to be clipped at.
		IFigure sourceFigure = sourceAnchor.getOwner();
		IFigure targetFigure = targetAnchor.getOwner();
		Viewport nearestEnclosingCommonViewport = ViewportUtilities
				.getNearestCommonViewport(sourceFigure, targetFigure);
		if (nearestEnclosingCommonViewport == null) {
			return new Rectangle[] { clipRect };
		}

		// if the nearest common viewport is not the root viewport, we may
		// start with clipping the connection at this viewport.
		if (nearestEnclosingCommonViewport != getRootViewport()) {
			clipRect.intersect(getNodeClippingRectangle(nearestEnclosingCommonViewport));
		}

		// if the nearest common viewport of source and target is not
		// simultaneously
		// the nearest enclosing viewport of source and target respectively, the
		// connection has to be further clipped (the connection may even not be
		// visible at all)
		Viewport nearestEnclosingSourceViewport = ViewportUtilities
				.getNearestEnclosingViewport(sourceFigure);
		Viewport nearestEnclosingTargetViewport = ViewportUtilities
				.getNearestEnclosingViewport(targetFigure);
		if (nearestEnclosingSourceViewport != nearestEnclosingTargetViewport) {
			// compute if source and target anchor are visible
			// within the nearest common enclosing viewport (which may
			// itself be nested in other viewports).
			Rectangle sourceClipRect = getAbsoluteBoundsAsCopy(connection);
			if (nearestEnclosingSourceViewport != nearestEnclosingCommonViewport) {
				clipAtViewports(sourceClipRect,
						ViewportUtilities.getViewportsPath(
								nearestEnclosingSourceViewport,
								nearestEnclosingCommonViewport, false));
			}
			Rectangle targetClipRect = getAbsoluteBoundsAsCopy(connection);
			if (nearestEnclosingTargetViewport != nearestEnclosingCommonViewport) {
				clipAtViewports(targetClipRect,
						ViewportUtilities.getViewportsPath(
								nearestEnclosingTargetViewport,
								nearestEnclosingCommonViewport, false));
			}
			PointList absolutePointsAsCopy = getAbsolutePointsAsCopy(connection);
			boolean sourceAnchorVisible = sourceClipRect.getExpanded(
					PRIVATE_INSETS).contains(
					absolutePointsAsCopy.getFirstPoint());
			boolean targetAnchorVisible = targetClipRect.getExpanded(
					PRIVATE_INSETS).contains(
					absolutePointsAsCopy.getLastPoint());

			if (!sourceAnchorVisible || !targetAnchorVisible) {
				// one (or both) of source or target anchor is invisible
				// within the nearest common viewport, so up to now
				// we regard the edge as invisible.
				return new Rectangle[] {};
				// TODO: We could come up with a more decent strategy here,
				// which also computes clipping fragments in those cases
				// where source/target are not visible but the edge
				// intersects with the enclosing source/target viewport's
				// parents bounds.

			} else {
				// both ends are visible, so just return what we have
				// computed before
				// (clipping at nearest enclosing viewport)
				return new Rectangle[] { clipRect };
			}
		} else {
			// source and target share the same enclosing viewport, so just
			// return what we have computed before (clipping at nearest
			// enclosing viewport)
			return new Rectangle[] { clipRect };
		}
	}
}
