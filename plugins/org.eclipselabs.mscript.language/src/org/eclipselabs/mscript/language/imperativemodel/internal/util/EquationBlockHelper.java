/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.imperativemodel.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil.EquationIterator;

/**
 * @author Andreas Unger
 *
 */
public class EquationBlockHelper {

	private static final EquationComparator EQUATION_COMPARATOR = new EquationComparator();

	public Collection<List<EquationDescriptor>> getEquationBlocks(Function function) {
		List<EquationDescriptor> backlog = new LinkedList<EquationDescriptor>(function.getEquationDescriptors());
		Collection<List<EquationDescriptor>> equationBlocks = new ArrayList<List<EquationDescriptor>>();
		while (!backlog.isEmpty()) {
			List<EquationDescriptor> equationDescriptors = getNextEquationBlock(backlog);
			equationBlocks.add(equationDescriptors);
		}
		return equationBlocks;
	}
	
	private List<EquationDescriptor> getNextEquationBlock(List<EquationDescriptor> backlog) {
		List<EquationDescriptor> equationBlock = new LinkedList<EquationDescriptor>();
		for (Iterator<EquationDescriptor> backlogIt = backlog.iterator(); backlogIt.hasNext();) {
			EquationDescriptor backlogEquationDescriptor = backlogIt.next();
			int compareResult = 1;
			for (ListIterator<EquationDescriptor> it = equationBlock.listIterator(); it.hasNext();) {
				EquationDescriptor next = it.next();
				compareResult = EQUATION_COMPARATOR.compare(backlogEquationDescriptor, next);
				if (compareResult < 0) {
					it.previous();
					it.add(backlogEquationDescriptor);
					it.next();
					backlogIt.remove();
					break;
				}
			}
			if (compareResult > 0) {
				equationBlock.add(backlogEquationDescriptor);
				backlogIt.remove();
			}
		}
		return equationBlock;
	}
	
	private static class EquationComparator implements Comparator<EquationDescriptor> {
		
		public int compare(EquationDescriptor equationDescriptor1, EquationDescriptor equationDescriptor2) {
			TreeIterator<EquationDescriptor> definingEquations = new EquationIterator(equationDescriptor1);
			while (definingEquations.hasNext()) {
				if (definingEquations.next() == equationDescriptor2) {
					return 1;
				}
			}
			definingEquations = new EquationIterator(equationDescriptor2);
			while (definingEquations.hasNext()) {
				if (definingEquations.next() == equationDescriptor1) {
					return -1;
				}
			}
			return 0;
		}

	}

}
