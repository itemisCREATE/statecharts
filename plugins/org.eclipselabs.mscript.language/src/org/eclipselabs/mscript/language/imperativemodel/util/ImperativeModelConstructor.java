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

import java.util.Collection;
import java.util.List;

import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.imperativemodel.internal.util.EquationCompoundHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.FunctionModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeModelConstructor {
	
	public Subroutine constructSubroutine(Function function) {
		Subroutine subroutine = ImperativeModelFactory.eINSTANCE.createSubroutine();

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(function);
		
		constructInitializationCompound(subroutine, equationCompounds);
		
		System.out.println("+++ Function: " + function.getDefinition().getName());
		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			System.out.println("---");
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep step = equationDescriptor.getLeftHandSide().getParts().get(0).getVariableStep();
				System.out.println(
						step.getDescriptor().getName()
						+ "(" + (step.isInitial() ? "" : "n")
						+ step.getIndex()
						+ ")");
			}
		}
		
		return subroutine;
	}
	
	private void constructInitializationCompound(Subroutine subroutine, Collection<List<EquationDescriptor>> equationCompounds) {
		Compound compound = ImperativeModelFactory.eINSTANCE.createCompound();
		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					
				}
			}
		}
		subroutine.setInitializationCompound(compound);
	}
	
}
