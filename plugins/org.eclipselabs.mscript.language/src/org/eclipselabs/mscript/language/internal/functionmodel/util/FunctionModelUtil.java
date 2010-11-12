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

package org.eclipselabs.mscript.language.internal.functionmodel.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * @author Andreas Unger
 *
 */
public class FunctionModelUtil {

	public static Equation getDefiningEquation(VariableStep variableStep) {
		for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
			Equation equation = equationPart.getSide().getEquation();
			if (equationPart.getSide() == equation.getLeftHandSide()) {
				return equation;
			}
		}
		return null;
	}

	public static Equation getDefiningEquation(Function function, String variableName, int stepIndex, boolean initial) {
		VariableDescriptor variableDescriptor = function.getVariableDescriptor(variableName);
		if (variableDescriptor != null) {
			VariableStep variableStep = variableDescriptor.getStep(stepIndex, initial);
			if (variableStep != null) {
				return getDefiningEquation(variableStep);
			}
		}
		return null;
	}

	public static TreeIterator<Equation> getDefiningEquations(Function function, String variableName, int stepIndex, boolean initial) {
		Equation root = getDefiningEquation(function, variableName, stepIndex, initial);
		if (root != null) {
			return new EquationIterator(root);
		}
		return EcoreUtil.getAllContents(ECollections.emptyEList());
	}
	
	public static TreeIterator<Equation> getDefiningEquations(VariableStep variableStep) {
		Equation root = getDefiningEquation(variableStep);
		if (root != null) {
			return new EquationIterator(root);
		}
		return EcoreUtil.getAllContents(ECollections.emptyEList());
	}
		
	private static class EquationIterator extends AbstractTreeIterator<Equation> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 
		 */
		public EquationIterator(Equation equation) {
			super(equation, true);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.util.AbstractTreeIterator#getChildren(java.lang.Object)
		 */
		@Override
		protected Iterator<? extends Equation> getChildren(Object object) {
			if (object instanceof Equation) {
				List<Equation> equations = new ArrayList<Equation>();
				for (EquationPart equationPart : ((Equation) object).getRightHandSide().getParts()) {
					Equation equation = getDefiningEquation(equationPart.getVariableStep());
					if (equation != null) {
						equations.add(equation);
					}
				}
				return equations.iterator();
			}
			return ECollections.<Equation>emptyEList().iterator();
		}

	}
	
}
