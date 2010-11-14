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

package org.eclipselabs.mscript.language.imperativemodel.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil.EquationIterator;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeModelConstructor {

	public Subroutine constructSubroutine(Function function) {
		Subroutine subroutine = ImperativeModelFactory.eINSTANCE.createSubroutine();

		List<EquationDescriptor> equationDescriptors = new ArrayList<EquationDescriptor>(function.getEquationDescriptors());
		Collections.sort(equationDescriptors, new Comparator<EquationDescriptor>() {
			
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
			
		});

		System.out.println("+++ Function: " + function.getDefinition().getName());
		for (EquationDescriptor equationDescriptor : equationDescriptors) {
			VariableStep step = equationDescriptor.getLeftHandSide().getParts().get(0).getVariableStep();
			System.out.println(
					step.getDescriptor().getName()
					+ "(" + (step.isInitial() ? "" : "n")
					+ step.getIndex()
					+ ")");
		}
		
		return subroutine;
	}
	
}
