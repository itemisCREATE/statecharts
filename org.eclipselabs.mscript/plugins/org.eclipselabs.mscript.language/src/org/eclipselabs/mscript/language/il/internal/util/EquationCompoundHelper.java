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

package org.eclipselabs.mscript.language.il.internal.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil.EquationIterator;

/**
 * @author Andreas Unger
 *
 */
public class EquationCompoundHelper {

	private static final EquationComparator EQUATION_COMPARATOR = new EquationComparator();

	public Collection<List<EquationDescriptor>> getEquationCompounds(FunctionDescriptor functionDescriptor) {
		List<EquationDescriptor> backlog = new LinkedList<EquationDescriptor>(functionDescriptor.getEquationDescriptors());
		Collection<List<EquationDescriptor>> equationCompounds = new LinkedList<List<EquationDescriptor>>();
		while (!backlog.isEmpty()) {
			List<EquationDescriptor> equationDescriptors = getNextEquationBlock(backlog);
			equationCompounds.add(equationDescriptors);
		}
		return equationCompounds;
	}
	
	private List<EquationDescriptor> getNextEquationBlock(List<EquationDescriptor> backlog) {
		List<EquationDescriptor> equationCompound = new LinkedList<EquationDescriptor>();
		for (Iterator<EquationDescriptor> backlogIt = backlog.iterator(); backlogIt.hasNext();) {
			EquationDescriptor backlogEquationDescriptor = backlogIt.next();
			int compareResult = 1;
			for (ListIterator<EquationDescriptor> it = equationCompound.listIterator(); it.hasNext();) {
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
				equationCompound.add(backlogEquationDescriptor);
				backlogIt.remove();
			}
		}
		return equationCompound;
	}
	
	private static class EquationComparator implements Comparator<EquationDescriptor> {
		
		public int compare(EquationDescriptor equationDescriptor1, EquationDescriptor equationDescriptor2) {
			Set<EquationDescriptor> equations = new HashSet<EquationDescriptor>();
			TreeIterator<EquationDescriptor> definingEquations = new EquationIterator(equationDescriptor1);
			while (definingEquations.hasNext()) {
				EquationDescriptor next = definingEquations.next();
				// Break cycle
				if (!equations.add(next)) {
					return 0;
				}
				if (next == equationDescriptor2) {
					return 1;
				}
			}

			equations = new HashSet<EquationDescriptor>();
			definingEquations = new EquationIterator(equationDescriptor2);
			while (definingEquations.hasNext()) {
				EquationDescriptor next = definingEquations.next();
				// Break cycle
				if (!equations.add(next)) {
					return 0;
				}
				if (next == equationDescriptor1) {
					return -1;
				}
			}
			
			return 0;
		}

	}

}
