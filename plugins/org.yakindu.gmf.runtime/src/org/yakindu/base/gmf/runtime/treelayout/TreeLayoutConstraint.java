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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class TreeLayoutConstraint extends Rectangle {

	public static final int DEFAULT_INNER_RANK_INDEX = -1;
	
	private static final long serialVersionUID = 1L;

	private boolean isRoot;

	private int treeInnerRankIndex;

	private IFigure treeParentFigure;

	public TreeLayoutConstraint(Rectangle bounds, boolean isRoot,
			int innerRankIndex) {
		super(bounds);
		this.isRoot = isRoot;
		this.treeInnerRankIndex = innerRankIndex;
	}

	public TreeLayoutConstraint(TreeLayoutConstraint treeLayoutConstraint) {
		this(treeLayoutConstraint, treeLayoutConstraint.isRoot(),
				treeLayoutConstraint.getTreeInnerRankIndex());
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public int getTreeInnerRankIndex() {
		return treeInnerRankIndex;
	}

	public void setTreeInnerRankIndex(int treePosition) {
		this.treeInnerRankIndex = treePosition;
	}

	public IFigure getTreeParentFigure() {
		return treeParentFigure;
	}

	public void setTreeParentFigure(IFigure treeParentFigure) {
		this.treeParentFigure = treeParentFigure;
	}

	public TreeLayoutConstraint getCopy() {

		if (getClass() == TreeLayoutConstraint.class) {
			/* avoid clone() call cost see bug #260740 */
			return new TreeLayoutConstraint(this);
		} else {
			try {
				return (TreeLayoutConstraint) clone();
			} catch (CloneNotSupportedException exc) {
				return new TreeLayoutConstraint(this);
			}
		}
	}
}
