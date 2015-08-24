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
package org.yakindu.base.gmf.runtime.treelayout;

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
import org.eclipse.draw2d.LayoutManager;
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

	private boolean isVertical;

	private boolean isTopLeftAlignment;

	// Represents the minimal needed level width or height.
	private int[] levelOffset;

	protected class TreeNode {

		private final TreeNode parent;

		private List<TreeNode> children;

		private final IFigure figure;

		private int weight;

		private int level;
		
		private int cell;
		
		private boolean isLayouted;

		public TreeNode(TreeNode parent, IFigure figure) {
			super();
			this.parent = parent;
			this.figure = figure;
			children = new LinkedList<TreeNode>();
			weight = 0;
			level = -1;
			cell = -1;
			isLayouted = false;
		}

		public IFigure getFigure() {
			return figure;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public int getCell() {
			return cell;
		}

		public void setCell(int cell) {
			this.cell = cell;
		}

		public TreeNode getParent() {
			return parent;
		}

		public List<TreeNode> getChildren() {
			return children;
		}

		public boolean isLayouted() {
			return isLayouted;
		}

		public void setLayouted(boolean isLayouted) {
			this.isLayouted = isLayouted;
		}
	}

	public TreeLayout(int rankSpacing, ConnectionLayer connectionLayer) {
		super();
		this.rankSpacing = rankSpacing;
		this.connectionLayer = connectionLayer;
		isVertical = true;
		isTopLeftAlignment = true;
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
			final double share = isVertical ? parentSize.width
					/ rootTreeNode.weight : parentSize.height
					/ rootTreeNode.weight;

			layoutTree(rootTreeNode, start, share);
			reduceLeafSpacing(rootTreeNode);
		}
	}

	private void layoutTree(TreeNode treeNode, int start, double share) {

		final Rectangle constraint = (Rectangle) getConstraint(treeNode.figure);

		if (constraint != null) {
			Rectangle bounds = constraint.getCopy();

			if (bounds.width <= 0 || bounds.height <= 0) {
				final Dimension preferredSize = treeNode.figure
						.getPreferredSize(bounds.width, bounds.height);

				if (bounds.width <= 0) {
					bounds.width = preferredSize.width;
				}
				if (bounds.height <= 0) {
					bounds.height = preferredSize.height;
				}
			}

			// Calculation for tree level distance assumes that all figures have
			// the same width and/or height;
			final int rankPos = isTopLeftAlignment ? treeNode.level
					: maxTreeLevel - treeNode.level;

//			final int levelPos = (rankPos * (bounds.width + rankSpacing))
//					+ (rankSpacing / 2);
			final int levelPos = getlevelPos(rankPos) + (rankSpacing / 2) ;
			
			final int cellPos = (int) (start + treeNode.weight * share / 2);

			bounds.x = isVertical ? cellPos - (bounds.width / 2) : levelPos;

			bounds.y = isVertical ? levelPos : cellPos - (bounds.height / 2);

			for (final TreeNode childNode : treeNode.children) {
				layoutTree(childNode, start, share);
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
			treeNode.setLayouted(true);
		}
	}

	private int getlevelPos(int rankPos) {
		int pos = 0;
		for (int i = levelOffset.length - rankPos; i < levelOffset.length; i++) {
			//Rankspacing is already included.
			pos += levelOffset[i];
		}
		return pos;
	}

	/**
	 * @see LayoutManager#getConstraint(IFigure) Transforms a Rectangle
	 *      constraint to a TreeLayoutConstraint if necessary
	 */
	@Override
	public TreeLayoutConstraint getConstraint(IFigure figure) {

		Rectangle constraint = (Rectangle) super.getConstraint(figure);

		if (constraint != null && !(constraint instanceof TreeLayoutConstraint)) {

			setConstraint(figure, new TreeLayoutConstraint(
					constraint.getCopy(), false, -1));
		}

		return (TreeLayoutConstraint) super.getConstraint(figure);
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
			int requiredSize = 0;
			int largestRankSize = 0;
			int rankSize = 0;
			int rowSize = 0;

			levelOffset = new int[treeLevelList.size()];

			for (int rankIndex = treeLevelList.size() - 1; rankIndex > -1; rankIndex--) {
				rankSize = 0;
				rowSize = 0;
				for (int cellIndex = 0; cellIndex < treeLevelList.get(rankIndex)
						.size(); cellIndex++) {

					final TreeNode treeNode = treeLevelList.get(rankIndex).get(
							cellIndex);
					treeNode.setCell(cellIndex);
					// set node weight
					// Case 1: TreeNode is leaf
					if (treeNode.children.isEmpty()) {
						treeNode.weight = 1;
					}
					// Case 2: TreeNode has only one child.
					else if (treeNode.children.size() == 1) {
						final TreeNode childGraphNode = treeNode.children
								.get(0);
						treeNode.weight = childGraphNode.weight;
					}
					// Case 3: TreeNode has many children.
					else {
						treeNode.weight = 0;
						for (final TreeNode childGraphNode : treeNode.children) {
							treeNode.weight += childGraphNode.weight;
						}
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
//					System.out.println("Set new Ranksize for Rank " + rankIndex
//							+ " Size : " + rankSize);
					largestRankSize = rankSize;
				}

				levelOffset[rankIndex] = rowSize;
				requiredSize += rowSize;
			}
			
			// set row and rank size
			if (isVertical) {
				graphSize.width = (int) (largestRankSize * 3);
				graphSize.height = requiredSize;
			} else {
				graphSize.height = (int) (largestRankSize * 3);
				graphSize.width = requiredSize;
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
			setConstraint(rootFigure, new Rectangle(0, 0, 0, 0));
			TreeNode rootTreeNode = new TreeNode(null, rootFigure);

			for (IFigure figure : rootFigures) {
				rootTreeNode.children.add(new TreeNode(null, figure));
			}
			return rootTreeNode;

		} else if (rootFigures.size() == 1) {

			return new TreeNode(null, rootFigures.get(0));

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
						.getTreeFigureIncomingConnections(connectionLayer,
								treeNode.getFigure());
				
				for (int i = 0; i < connectionList.size(); i++) {
					final Connection connection = connectionList.get(i);
					if (connection.getSourceAnchor().getOwner() != null) {
						final IFigure childFig = connection.getSourceAnchor()
								.getOwner();
						final TreeNode childTreeNode = new TreeNode(treeNode,
								childFig);
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
			final TreeLayoutConstraint constraint = getConstraint(treeNode.figure);

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
			final TreeLayoutConstraint constraint = getConstraint(treeNode.figure);
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

		if (areLeafs(treeNode.children)
				&& treeNode.children.size() > 1) {

			final TreeNode firstNode = treeNode.children.get(0);
			final TreeNode lastNode = treeNode.children
					.get(treeNode.children.size() - 1);

			final int delta = lastNode.figure.getBounds().y
					- firstNode.figure.getBounds().y;

			final int newDelta = (firstNode.getFigure().getBounds().height + leafSpacing)
					* (treeNode.children.size() - 1);

			if (delta - newDelta > 0) {
				final int offset = delta - newDelta;
				final int start = firstNode.figure.getBounds().y + offset / 2;
				for (final TreeNode childTreeNode : treeNode.children) {
					final int index = treeNode.children
							.indexOf(childTreeNode);
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
}