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
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * @author Andreas Unger
 *
 */
public class FunctionModelUtil {

	public static EquationPart getFirstLeftHandSideEquationPart(EquationDescriptor equationDescriptor) {
		List<EquationPart> lhsEquationParts = equationDescriptor.getLeftHandSide().getParts();
		return !lhsEquationParts.isEmpty() ? lhsEquationParts.get(0) : null;
	}
	
	public static VariableStep getFirstLeftHandSideVariableStep(EquationDescriptor equationDescriptor) {
		EquationPart lhsEquationPart = getFirstLeftHandSideEquationPart(equationDescriptor);
		return lhsEquationPart != null ? lhsEquationPart.getVariableStep() : null;
	}

	public static EquationDescriptor getDefiningEquation(VariableStep variableStep) {
		for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
			EquationDescriptor equationDescriptor = equationPart.getSide().getDescriptor();
			if (equationPart.getSide() == equationDescriptor.getLeftHandSide()) {
				return equationDescriptor;
			}
		}
		return null;
	}

	public static EquationDescriptor getDefiningEquation(Function function, String variableName, int stepIndex, boolean initial) {
		VariableDescriptor variableDescriptor = function.getVariableDescriptor(variableName);
		if (variableDescriptor != null) {
			VariableStep variableStep = variableDescriptor.getStep(stepIndex, initial);
			if (variableStep != null) {
				return getDefiningEquation(variableStep);
			}
		}
		return null;
	}

	public static TreeIterator<EquationDescriptor> getDefiningEquations(Function function, String variableName, int stepIndex, boolean initial) {
		EquationDescriptor root = getDefiningEquation(function, variableName, stepIndex, initial);
		if (root != null) {
			return new EquationIterator(root);
		}
		return EcoreUtil.getAllContents(ECollections.emptyEList());
	}
	
	public static TreeIterator<EquationDescriptor> getDefiningEquations(VariableStep variableStep) {
		EquationDescriptor root = getDefiningEquation(variableStep);
		if (root != null) {
			return new EquationIterator(root);
		}
		return EcoreUtil.getAllContents(ECollections.emptyEList());
	}
		
	public static class EquationIterator extends AbstractTreeIterator<EquationDescriptor> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 
		 */
		public EquationIterator(EquationDescriptor equationDescriptor) {
			super(equationDescriptor, true);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.util.AbstractTreeIterator#getChildren(java.lang.Object)
		 */
		@Override
		protected Iterator<? extends EquationDescriptor> getChildren(Object object) {
			if (object instanceof EquationDescriptor) {
				List<EquationDescriptor> equations = new ArrayList<EquationDescriptor>();
				for (EquationPart equationPart : ((EquationDescriptor) object).getRightHandSide().getParts()) {
					EquationDescriptor equationDescriptor = getDefiningEquation(equationPart.getVariableStep());
					if (equationDescriptor != null) {
						equations.add(equationDescriptor);
					}
				}
				return equations.iterator();
			}
			return ECollections.<EquationDescriptor>emptyEList().iterator();
		}

	}
	
}
