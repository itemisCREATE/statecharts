/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Muehlbrandt - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.treelayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author Markus Muehlbrandt
 * 
 */
public class TreeLayoutUtil {

	public static final String TREE_LAYOUT_ANNOTATION = "TreeLayoutAnnotation";

	public static final String TREE_NODE_POSITION = "TreeNodePosition";

	public static final String TREE_NODE_PARENT_URI = "TreeNodeParentURI";

	/**
	 * Util for TreeLayouting
	 */
	private TreeLayoutUtil() {
		// not intended to be instantiated.
	}

	public static List<IGraphicalEditPart> getSiblings(IGraphicalEditPart child) {

		final View parentView = TreeLayoutUtil.getTreeNodeParentView(child
				.getNotationView());

		if (parentView != null) {
			final IGraphicalEditPart parentEditPart = (IGraphicalEditPart) child
					.findEditPart(child.getParent(), parentView.getElement());
			if (parentEditPart != null) {
				final List<IGraphicalEditPart> treeChildren = getOrderedTreeChildren(parentEditPart);
				if (treeChildren.remove(child)) {
					return treeChildren;
				}
			}
		}
		return Collections.emptyList();
	}

	// TODO: Fix fixed isInversed setting
	public static ArrayList<IGraphicalEditPart> getOrderedTreeChildren(
			IGraphicalEditPart parentTreeNodeEditPart) {

		final List<IGraphicalEditPart> children = new ArrayList<IGraphicalEditPart>();

		final DiagramEditPart diagramEditPart = UIUtils.getDiagramEditPart();
		if (diagramEditPart != null) {
			final ConnectionLayer connectionLayer = (ConnectionLayer) diagramEditPart
					.getLayer(LayerConstants.CONNECTION_LAYER);
			for (final Connection connection : getTreeFigureChildrenConnections(
					connectionLayer, parentTreeNodeEditPart.getFigure(), false)) {
				final Object object = parentTreeNodeEditPart.getParent()
						.getViewer().getVisualPartMap()
						.get(connection.getSourceAnchor().getOwner());
				if (object instanceof IGraphicalEditPart) {
					children.add((IGraphicalEditPart) object);
				}
			}
		}

		final IGraphicalEditPart[] orderedChildren = new IGraphicalEditPart[children
				.size()];
		final List<IGraphicalEditPart> unorderedChildren = new ArrayList<IGraphicalEditPart>();

		for (final IGraphicalEditPart editPart : children) {

			final int treePosition = getTreeNodePosition(editPart);
			if (treePosition == -1 || treePosition >= orderedChildren.length
					|| orderedChildren[treePosition] != null) {
				unorderedChildren.add(editPart);
			} else {
				orderedChildren[treePosition] = editPart;
			}
		}

		for (final IGraphicalEditPart editPart : unorderedChildren) {
			orderedChildren[getNextEmptyIndex(orderedChildren)] = editPart;
		}

		return new ArrayList<IGraphicalEditPart>(Arrays.asList(orderedChildren));
	}

	public static int getNextEmptyIndex(IGraphicalEditPart[] list) {
		for (int index = 0; index < list.length; index++) {
			if (list[index] == null) {
				return index;
			}
		}
		return -1;
	}

	public static int getConstrainedTreeNodePosition(IFigure figure) {
		final Object constraint = figure.getParent().getLayoutManager()
				.getConstraint(figure);
		if (constraint instanceof TreeLayoutConstraint) {
			return ((TreeLayoutConstraint) constraint).getTreeInnerRankIndex();
		}
		return -1;
	}

	/**
	 * Returns the parent view of a tree node from the parent view annotation.
	 * 
	 * @param editPart
	 * @return
	 */
	public static View getTreeNodeParentView(View view) {
		final EAnnotation xmiIdAnnotation = view
				.getEAnnotation(TREE_LAYOUT_ANNOTATION);
		if (xmiIdAnnotation != null) {
			return (View) view.eResource().getEObject(
					xmiIdAnnotation.getDetails().get(TREE_NODE_PARENT_URI));
		}
		return null;
	}

	/**
	 * Returns the index of a tree node from the view position annotation.
	 * 
	 * @param editPart
	 * @return
	 */
	public static int getTreeNodePosition(IGraphicalEditPart editPart) {
		final EAnnotation xmiIdAnnotation = editPart.getNotationView()
				.getEAnnotation(TREE_LAYOUT_ANNOTATION);
		if (xmiIdAnnotation != null) {
			final String pos = xmiIdAnnotation.getDetails().get(
					TREE_NODE_POSITION);
			if (pos != null) {
				return Integer.parseInt(pos);
			}
		}
		return getConstrainedTreeNodePosition(editPart.getFigure());
	}

	/**
	 * Returns a list of {@link View} elements of the given edit parts.
	 * 
	 * @param editParts
	 * @return
	 */
	public static List<View> getViews(List<IGraphicalEditPart> editParts) {
		final List<View> viewList = new ArrayList<View>();
		for (final IGraphicalEditPart editPart : editParts) {
			viewList.add(editPart.getNotationView());
		}
		return viewList;
	}

	/**
	 * Calculates the new tree node list index based on the given location.
	 * Currently works only with horizontal tree node alignment!
	 * 
	 * @param location
	 * @param siblings
	 * @return
	 */
	public static int getNewTreeNodePosition(Point location,
			List<IGraphicalEditPart> siblings) {

		int position = -1;

		if (siblings.isEmpty()) {
			return 0;
		}

		if (location != null) {
			int minPosDelta = Integer.MAX_VALUE;
			int minNegDelta = Integer.MIN_VALUE;
			int upperIndex = siblings.size() - 1;
			int lowerIndex = 0;
			for (int i = 0; i < siblings.size(); i++) {

				// convert to absolute coordinates to consider zoom level.
				final IFigure figure = siblings.get(i).getFigure();
				final Rectangle absoluteBounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(absoluteBounds);

				// TODO: Look for Layout settings. Maybe layout is vertical
				// aligned.
				final int deltaY = location.y - absoluteBounds.y;

				if (deltaY > 0 && deltaY < minPosDelta) {
					if (siblings.size() == 1) {
						lowerIndex = 1;
						upperIndex = 1;
					} else {
						minPosDelta = deltaY;
						lowerIndex = i;
					}
				} else if (deltaY < 0 && deltaY > minNegDelta) {
					if (siblings.size() == 1) {
						lowerIndex = 0;
						upperIndex = 0;
					} else {
						minNegDelta = deltaY;
						upperIndex = i;
					}
				}
			}

			if (lowerIndex == 0 && upperIndex == 0) {
				position = 0;
			} else if (lowerIndex < upperIndex
					|| (siblings.size() == 1 && lowerIndex == 1 && upperIndex == 1)) {
				position = upperIndex;
			} else if (lowerIndex == siblings.size() - 1
					&& upperIndex == siblings.size() - 1) {
				position = upperIndex + 1;
			}
		}
		return position;
	}

	public static void setTreeNodesPositionAnnotation(List<View> viewElements) {
		if (viewElements != null) {
			for (int index = 0; index < viewElements.size(); index++) {
				final View view = viewElements.get(index);
				EAnnotation xmiIdAnnotation = view
						.getEAnnotation(TREE_LAYOUT_ANNOTATION);
				if (xmiIdAnnotation == null) {
					xmiIdAnnotation = EcoreFactory.eINSTANCE
							.createEAnnotation();
					xmiIdAnnotation.setSource(TREE_LAYOUT_ANNOTATION);
				}
				xmiIdAnnotation.getDetails().put(TREE_NODE_POSITION,
						Integer.toString(index));
				xmiIdAnnotation.setEModelElement(view);
			}
		}
	}

	public static void setTreeNodeParentAnnotation(View child, View parent) {
		EAnnotation xmiIdAnnotation = child
				.getEAnnotation(TREE_LAYOUT_ANNOTATION);
		if (xmiIdAnnotation == null) {
			xmiIdAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			xmiIdAnnotation.setSource(TREE_LAYOUT_ANNOTATION);
		}
		xmiIdAnnotation.getDetails().put(TREE_NODE_PARENT_URI,
				parent.eResource().getURIFragment(parent));
		xmiIdAnnotation.setEModelElement(child);
	}

	/**
	 * Returns only connections where the parent figure is a direct parent.
	 * Indirect connections are filtered out. Use if children can have many
	 * parents.
	 * 
	 * @param connectionLayer
	 * @param parentFigure
	 * @return
	 */
	public static List<Connection> getTreeFigureChildrenConnections(
			ConnectionLayer connectionLayer, IFigure parentFigure,
			boolean isInversed) {

		final List<Connection> connectionList = isInversed ? getIncomingConnections(
				connectionLayer, parentFigure) : getOutgoingConnections(
				connectionLayer, parentFigure);

		final List<Connection> indirectChildren = new ArrayList<Connection>();

		final int parentFigureTreeLevel = getDeepestTreeLevel(connectionLayer,
				parentFigure, isInversed);

		for (final Connection connection : connectionList) {

			final IFigure childFigure = isInversed ? connection
					.getSourceAnchor().getOwner() : connection
					.getTargetAnchor().getOwner();

			final int childTreeLevel = getDeepestTreeLevel(connectionLayer,
					childFigure, isInversed);

			if (childTreeLevel == parentFigureTreeLevel + 1) {

				// get LayoutConstraint of child Figure;
				Object object = parentFigure.getParent().getLayoutManager()
						.getConstraint(childFigure);
				if (object instanceof TreeLayoutConstraint) {
					TreeLayoutConstraint childConstraint = (TreeLayoutConstraint) object;

					final IFigure constrainedParentFig = childConstraint
							.getTreeParentFigure();

					if (constrainedParentFig == null) {
						childConstraint.setTreeParentFigure(parentFigure);
					} else if (constrainedParentFig != parentFigure) {
						indirectChildren.add(connection);
					}
				}
			} else {
				indirectChildren.add(connection);
			}
		}
		connectionList.removeAll(indirectChildren);
		return connectionList;
	}

	private static int getDeepestTreeLevel(ConnectionLayer connectionLayer,
			IFigure figure, boolean inversed) {

		final List<Connection> connectionList = inversed ? getOutgoingConnections(
				connectionLayer, figure) : getIncomingConnections(
				connectionLayer, figure);

		if (connectionList.size() > 0) {

			final int[] ret = new int[connectionList.size()];

			for (int i = 0; i < connectionList.size(); i++) {

				IFigure fig = inversed ? connectionList.get(i)
						.getTargetAnchor().getOwner() : connectionList.get(i)
						.getSourceAnchor().getOwner();
				ret[i] = 1 + getDeepestTreeLevel(connectionLayer, fig, inversed);
			}
			int maxLevel = ret[0];
			if (ret.length > 1) {
				for (int i = 1; i < ret.length; i++) {
					if (ret[i] > maxLevel) {
						maxLevel = ret[i];
					}
				}
			}
			return maxLevel;
		}
		return 0;
	}

	/**
	 * Returns incoming connection figures of the figure parameter.
	 * 
	 * @param connectionLayer
	 * @param figure
	 * @return
	 */
	public static List<Connection> getIncomingConnections(
			ConnectionLayer connectionLayer, IFigure figure) {

		final List<Connection> incomingConnectionList = new ArrayList<Connection>();

		for (final Object object : connectionLayer.getChildren()) {
			if (object instanceof Connection) {
				final Connection connection = (Connection) object;
				final IFigure source = connection.getSourceAnchor().getOwner();
				if (connection.getTargetAnchor().getOwner() == figure
						&& !isChildFigure(figure, source)
						&& !isIgnoredFigure(source)) {
					incomingConnectionList.add(connection);
				}
			}
		}
		return incomingConnectionList;
	}

	/**
	 * Returns outgoing connection figures of the figure parameter.
	 * 
	 * @param connectionLayer
	 * @param figure
	 * @return
	 */
	public static List<Connection> getOutgoingConnections(
			ConnectionLayer connectionLayer, IFigure figure) {

		final List<Connection> outgoingConnectionList = new ArrayList<Connection>();

		for (final Object object : connectionLayer.getChildren()) {
			if (object instanceof Connection) {
				final Connection connection = (Connection) object;
				final IFigure target = connection.getTargetAnchor().getOwner();
				if (connection.getSourceAnchor().getOwner() == figure
						&& !isChildFigure(figure, target)
						&& !isIgnoredFigure(target)) {
					outgoingConnectionList.add(connection);
				}
			}
		}
		return outgoingConnectionList;
	}

	/**
	 * Iterates over the children and children's children to check if a figure
	 * is a direct child or indirect child of the given parent.
	 * 
	 * @param parent
	 * @param possibleChild
	 * @return
	 */
	public static boolean isChildFigure(IFigure parent, IFigure possibleChild) {
		boolean ret = false;
		for (Object child : parent.getChildren()) {
			if (child == possibleChild) {
				return true;
			}
			if (child instanceof IFigure) {
				ret = isChildFigure((IFigure) child, possibleChild);
				if (ret) {
					break;
				}
			}
		}
		return ret;
	}

	private static boolean isIgnoredFigure(IFigure figure) {
		IFigure parent = figure.getParent();
		if (parent != null && parent.getLayoutManager() != null) {
			return !(parent.getLayoutManager().getConstraint(figure) instanceof TreeLayoutConstraint);
		}
		return false;
	}
}
