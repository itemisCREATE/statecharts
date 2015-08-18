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
package org.yakindu.gmf.runtime.treelayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * @author Markus Muehlbrandt
 * 
 */
public class TreeLayout extends FreeformLayout {

	private final int rankSpacing;

	private final ConnectionLayer connectionLayer;

	private Point parentOffset;

	private Dimension graphSize;

	private int maxTreeLevel;

	private int leafSpacing;

	private boolean isReducingLeafSpacing;

	private boolean isVertical;

	private boolean isInversed;

	private boolean isTopLeftAlignment;

	// Represents the minimal needed level width or height.
	private int[] levelOffset;

	protected class TreeNode {

		private List<TreeNode> children;

		private final IFigure figure;

		private int weight;

		private int level;

		public TreeNode(IFigure figure) {
			super();
			this.figure = figure;
			children = new LinkedList<TreeNode>();
			weight = 0;
			level = -1;
		}

		public IFigure getFigure() {
			return figure;
		}
	}

	public TreeLayout(int rankSpacing, ConnectionLayer connectionLayer) {
		super();
		this.rankSpacing = rankSpacing;
		this.connectionLayer = connectionLayer;
		isVertical = true;
		isTopLeftAlignment = true;
		isInversed = false;
		isReducingLeafSpacing = false;
		leafSpacing = 5;
		maxTreeLevel = 0;
		graphSize = new Dimension();
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public boolean isInversed() {
		return isInversed;
	}

	public void setInversed(boolean isInversed) {
		this.isInversed = isInversed;
	}

	public boolean isReducingLeafSpacing() {
		return isReducingLeafSpacing;
	}

	public void setLeafSpacingReduce(boolean isReducingLeafSpacing) {
		this.isReducingLeafSpacing = isReducingLeafSpacing;
	}

	public boolean isTopLeftAlignment() {
		return isTopLeftAlignment;
	}

	public void setTopLeftAlignment(boolean isTopLeftAlignment) {
		this.isTopLeftAlignment = isTopLeftAlignment;
	}

	public int getLeafSpacing() {
		return leafSpacing;
	}

	public void setLeafSpacing(int leafSpacing) {
		this.leafSpacing = leafSpacing;
	}

	@Override
	public void layout(IFigure figure) {

		List<IFigure> figures = new LinkedList<IFigure>();

		for (Object fig : figure.getChildren()) {
			if (fig instanceof IFigure) {
				figures.add((IFigure) fig);
			}
		}

		parentOffset = getOrigin(figure);

		final TreeNode rootTreeNode = createNodeTree(figure);
		Dimension parentSize = figure.getBounds().getSize().getCopy();

		if (graphSize.width > parentSize.width) {
			parentSize.width = graphSize.width;
		}

		if (graphSize.height > parentSize.height) {
			parentSize.height = graphSize.height;
		}

		if (rootTreeNode != null) {
			final int start = 0;
			final double share = isVertical ? new Double(parentSize.width)
					/ new Double(rootTreeNode.weight) : new Double(parentSize.height)
					/ new Double(rootTreeNode.weight);

			layoutTree(rootTreeNode, start, share, figures);

			if (isReducingLeafSpacing) {
				reduceLeafSpacing(rootTreeNode);
			}
		}

		// layout figures not contained in trees
		for (IFigure f : figures) {
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;

			if (bounds.width == -1 || bounds.height == -1) {
				Dimension preferredSize = f.getPreferredSize(bounds.width,
						bounds.height);
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = preferredSize.width;
				if (bounds.height == -1)
					bounds.height = preferredSize.height;
			}
			bounds = bounds.getTranslated(parentOffset);
			f.setBounds(bounds);
		}
	}

	private void layoutTree(TreeNode treeNode, int start, double share,
			List<IFigure> unlayoutedFigures) {

		// final Rectangle constraint = (Rectangle)
		// getConstraint(treeNode.figure);
		Rectangle bounds = getConstrainedBounds(treeNode.figure);
		if (bounds != null) {

			// Calculation for tree level distance assumes that all figures have
			// the same width and/or height;
			final int rankPos = isTopLeftAlignment ? treeNode.level
					: maxTreeLevel - treeNode.level;

			// final int levelPos = (rankPos * (bounds.width + rankSpacing))
			// + (rankSpacing / 2);
			final int levelPos = getlevelPos(rankPos) + (rankSpacing / 2);

			final int cellPos = (int) (start + treeNode.weight * share / 2);

			bounds.x = isVertical ? cellPos - (bounds.width / 2) : levelPos;

			bounds.y = isVertical ? levelPos : cellPos - (bounds.height / 2);

			for (final TreeNode childNode : treeNode.children) {
				layoutTree(childNode, start, share, unlayoutedFigures);
				start += share * childNode.weight;
			}

			// System.out.println("******************************************");
			// //System.out.println("Parent Size: " +
			// treeNode.parent.figure.getSize());
			// System.out.println("Figure " + treeNode.figure + " Tree Level: "
			// + treeNode.level + " Weight: " + treeNode.weight);
			// System.out.println(" X: " + bounds.x + " Y: " + bounds.y
			// + " Width : " + bounds.width + " Height: " + bounds.height);
			// System.out.println("******************************************");

			bounds = bounds.getTranslated(parentOffset);
			treeNode.figure.setBounds(bounds);
			unlayoutedFigures.remove(treeNode.figure);
		}
	}

	private int getlevelPos(int rankPos) {
		int result = 0;

		int startIndex = isTopLeftAlignment ? 0 : levelOffset.length - rankPos;

		int stopIndex = isTopLeftAlignment ? rankPos : levelOffset.length;

		for (int i = startIndex; i < stopIndex; i++) {
			result += levelOffset[i];
		}
		return result;
	}

	private TreeNode createNodeTree(IFigure figure) {
		final TreeNode rootTreeNode = createRootTreeNode(figure);

		if (rootTreeNode != null) {

			graphSize = new Dimension();

			final List<List<TreeNode>> treeLevelList = getTreeLevels(
					Collections.singletonList(rootTreeNode), 0);

			maxTreeLevel = treeLevelList.size() - 1;

			// Algorithm to calculate node weight, level and canvas size. Starts
			// with the leafs and walks up to the root element.
			int largestRankSize = 0;
			int rankSize = 0;
			int rowSize = 0;

			levelOffset = new int[treeLevelList.size()];

			for (int rankIndex = treeLevelList.size() - 1; rankIndex > -1; rankIndex--) {
				rankSize = 0;
				rowSize = 0;
				for (int cellIndex = 0; cellIndex < treeLevelList
						.get(rankIndex).size(); cellIndex++) {

					final TreeNode treeNode = treeLevelList.get(rankIndex).get(
							cellIndex);
					Rectangle nodeBounds = getConstrainedBounds(treeNode.figure);
					// set node weight
					// Case 1: TreeNode is leaf
					if (treeNode.children.isEmpty()) {
						treeNode.weight = (isVertical ? nodeBounds.width
								: nodeBounds.height) + leafSpacing;
					}
					// Case 2: TreeNode has only one child.
					else if (treeNode.children.size() == 1) {
						final TreeNode childGraphNode = treeNode.children
								.get(0);
						int boundsSpanWidth = isVertical ? nodeBounds.width
								: nodeBounds.height;
						treeNode.weight = childGraphNode.weight > boundsSpanWidth ? childGraphNode.weight
								: boundsSpanWidth;
					}
					// Case 3: TreeNode has many children.
					else {
						int childrenSpanWidth = 0;
						for (final TreeNode childGraphNode : treeNode.children) {
							childrenSpanWidth += childGraphNode.weight;
						}
						int boundsSpanWidth = isVertical ? nodeBounds.width
								: nodeBounds.height;
						treeNode.weight = childrenSpanWidth > boundsSpanWidth ? childrenSpanWidth
								: boundsSpanWidth;
					}

					// calculate rank size
					rankSize += isVertical ? treeNode.getFigure().getSize().width
							+ leafSpacing
							: treeNode.getFigure().getSize().height
									+ leafSpacing;

					// get largest row figure
					if (isVertical) {
						if (rowSize < treeNode.getFigure().getSize().height
								+ rankSpacing) {
							rowSize = treeNode.getFigure().getSize().height
									+ rankSpacing;
						}
					} else {
						if (rowSize < treeNode.getFigure().getSize().width
								+ rankSpacing) {
							rowSize = treeNode.getFigure().getSize().width
									+ rankSpacing;
						}
					}
				}

				if (largestRankSize < rankSize) {
					largestRankSize = rankSize;
				}

				levelOffset[rankIndex] = rowSize;
			}

			// set row and rank size
			if (isVertical) {
				graphSize.width = (int) largestRankSize;
				graphSize.height = rootTreeNode.weight;
			} else {
				graphSize.height = (int) largestRankSize;
				graphSize.width = rootTreeNode.weight;
			}
		}

		return rootTreeNode;
	}

	protected TreeNode createRootTreeNode(IFigure parent) {

		final List<IFigure> rootFigures = getGraphRootFigures(parent);

		if (rootFigures.size() > 1) {
			// initializes a "virtual" root
			// tree level (needed for correct size calculations)
			RectangleFigure rootFigure = new RectangleFigure();
			rootFigure.setPreferredSize(1, 1);
			rootFigure.setSize(1, 1);
			setConstraint(rootFigure, new TreeLayoutConstraint(new Rectangle(0,
					0, 0, 0), true, -1));
			TreeNode rootTreeNode = new TreeNode(rootFigure);

			for (IFigure figure : rootFigures) {
				rootTreeNode.children.add(new TreeNode(figure));
			}
			return rootTreeNode;

		} else if (rootFigures.size() == 1) {

			return new TreeNode(rootFigures.get(0));

		}
		return null;

	}

	// Returns the GraphRootFigure
	@SuppressWarnings("unchecked")
	private List<IFigure> getGraphRootFigures(IFigure parent) {
		List<IFigure> figures = new LinkedList<IFigure>();

		final Iterator<IFigure> children = parent.getChildren().iterator();

		while (children.hasNext()) {
			final IFigure figure = children.next();
			final Object constraint = getConstraint(figure);
			if (constraint instanceof TreeLayoutConstraint) {
				final TreeLayoutConstraint bounds = (TreeLayoutConstraint) constraint;
				if (bounds.isRoot()) {
					figures.add(figure);
				}
			}
		}
		return figures;
	}

	protected List<List<TreeNode>> getTreeLevels(List<TreeNode> treeNodeList,
			int level) {
		final List<List<TreeNode>> levelElements = new ArrayList<List<TreeNode>>();
		final List<TreeNode> nextRankElements = new ArrayList<TreeNode>();
		levelElements.add(new ArrayList<TreeNode>());
		levelElements.get(0).addAll(treeNodeList);

		for (final TreeNode treeNode : treeNodeList) {
			// Set level of the treeNode
			treeNode.level = level;

			if (treeNode.children.isEmpty()) {

				// calculate child GraphNodes in next Rank
				final List<Connection> connectionList = TreeLayoutUtil
						.getTreeFigureChildrenConnections(connectionLayer,
								treeNode.getFigure(), isInversed);

				for (int i = 0; i < connectionList.size(); i++) {
					final Connection connection = connectionList.get(i);
					IFigure childFig = isInversed ? connection
							.getSourceAnchor().getOwner() : connection
							.getTargetAnchor().getOwner();
					if (childFig != null) {
						final TreeNode childTreeNode = new TreeNode(childFig);
						treeNode.children.add(childTreeNode);
					}
				}
			}

			treeNode.children = sortTreeNodeList(treeNode.children);
			nextRankElements.addAll(treeNode.children);
		}
		// add ranks for childTreeNodeList
		if (!nextRankElements.isEmpty()) {
			levelElements.addAll(getTreeLevels(nextRankElements, ++level));
		}
		return levelElements;
	}

	private List<TreeNode> sortTreeNodeList(List<TreeNode> treeNodeList) {

		final TreeNode[] sortedTreeNodeList = new TreeNode[treeNodeList.size()];
		final List<TreeNode> notConstrained = new ArrayList<TreeNode>();

		for (int index = 0; index < treeNodeList.size(); index++) {
			final TreeNode treeNode = treeNodeList.get(index);
			final TreeLayoutConstraint constraint = (TreeLayoutConstraint) getConstraint(treeNode.figure);

			if (constraint.getTreeInnerRankIndex() != -1
					&& constraint.getTreeInnerRankIndex() < sortedTreeNodeList.length
					&& sortedTreeNodeList[constraint.getTreeInnerRankIndex()] == null) {
				sortedTreeNodeList[constraint.getTreeInnerRankIndex()] = treeNode;
			} else {
				notConstrained.add(treeNode);
			}
		}

		for (final TreeNode treeNode : notConstrained) {
			final int nextEmptyIndex = getNextEmptyIndex(sortedTreeNodeList);
			final TreeLayoutConstraint constraint = (TreeLayoutConstraint) getConstraint(treeNode.figure);
			constraint.setTreeInnerRankIndex(nextEmptyIndex);
			sortedTreeNodeList[nextEmptyIndex] = treeNode;
		}

		return Arrays.asList(sortedTreeNodeList);
	}

	private int getNextEmptyIndex(TreeNode[] list) {
		for (int index = 0; index < list.length; index++) {
			if (list[index] == null) {
				return index;
			}
		}
		return -1;
	}

	private void reduceLeafSpacing(TreeNode treeNode) {

		if (areLeafs(treeNode.children) && treeNode.children.size() > 1) {

			final TreeNode firstNode = treeNode.children.get(0);
			final TreeNode lastNode = treeNode.children.get(treeNode.children
					.size() - 1);

			final int delta = lastNode.figure.getBounds().y
					- firstNode.figure.getBounds().y;

			final int newDelta = (firstNode.getFigure().getBounds().height + leafSpacing)
					* (treeNode.children.size() - 1);

			if (delta - newDelta > 0) {
				final int offset = delta - newDelta;
				final int start = firstNode.figure.getBounds().y + offset / 2;
				for (final TreeNode childTreeNode : treeNode.children) {
					final int index = treeNode.children.indexOf(childTreeNode);
					final Rectangle bounds = childTreeNode.getFigure()
							.getBounds().getCopy();
					bounds.y = start
							+ (childTreeNode.figure.getSize().height + leafSpacing)
							* index;
					childTreeNode.getFigure().setBounds(bounds);
				}
			}

		} else {
			for (final TreeNode childTreeNode : treeNode.children) {
				reduceLeafSpacing(childTreeNode);
			}
		}
	}

	private boolean areLeafs(List<TreeNode> childTreeNodeList) {
		for (final TreeNode treeNode : childTreeNodeList) {
			if (!treeNode.children.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private Rectangle getConstrainedBounds(IFigure figure) {

		final Rectangle constraint = (Rectangle) getConstraint(figure);
		
		if (constraint != null) {
			
			Rectangle bounds = constraint.getCopy();

			if (bounds.width <= 0 || bounds.height <= 0) {
				final Dimension minimumSize = figure.getMinimumSize();
				final Dimension preferredSize = figure.getPreferredSize(
						bounds.width, bounds.height);

				if (bounds.width <= 0) {
					bounds.width = minimumSize.width > preferredSize.width ? minimumSize.width
							: preferredSize.width;
				}
				if (bounds.height <= 0) {
					bounds.height = minimumSize.height > preferredSize.height ? minimumSize.height
							: preferredSize.height;
				}
			}
			return bounds;
		}
		return null;
	}
}