/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.VariableAccess;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;

/**
 * @author Andreas Unger
 *
 */
public class DefaultVariableAccessStrategy implements IVariableAccessStrategy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy#getVariableAccessString(org.eclipselabs.mscript.language.il.VariableAccess)
	 */
	public String getVariableAccessString(VariableAccess variableAccess) {
		return new VariableAccessSwitch(variableAccess).doSwitch(variableAccess.getTarget());
	}

	public class VariableAccessSwitch extends ILSwitch<String> {

		private VariableAccess variableAccess;
		
		public VariableAccessSwitch(VariableAccess variableAccess) {
			this.variableAccess = variableAccess;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInputVariableDeclaration(org.eclipselabs.mscript.language.il.InputVariableDeclaration)
		 */
		@Override
		public String caseInputVariableDeclaration(InputVariableDeclaration inputVariableDeclaration) {
			if (variableAccess.getStepIndex() == 0) {
				return inputVariableDeclaration.getName();
			}
			return getContextAccess();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseOutputVariableDeclaration(org.eclipselabs.mscript.language.il.OutputVariableDeclaration)
		 */
		@Override
		public String caseOutputVariableDeclaration(OutputVariableDeclaration outputVariableDeclaration) {
			if (variableAccess.getStepIndex() == 0) {
				return String.format("*%s", outputVariableDeclaration.getName());
			}
			return getContextAccess();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInstanceVariableDeclaration(org.eclipselabs.mscript.language.il.InstanceVariableDeclaration)
		 */
		@Override
		public String caseInstanceVariableDeclaration(InstanceVariableDeclaration instanceVariableDeclaration) {
			return getContextAccess();
		}
		
		private String getContextAccess() {
			StatefulVariableDeclaration target = (StatefulVariableDeclaration) variableAccess.getTarget();
			int stepIndex = variableAccess.getStepIndex();

			String name = target.getName();
			int circularBufferSize = ((StatefulVariableDeclaration) target).getCircularBufferSize();
			if (circularBufferSize > 1) {
				if (stepIndex < 0) {
					stepIndex = (stepIndex + circularBufferSize) % circularBufferSize;
				}
				if (stepIndex == 0) {
					return String.format("context->%s[context->%s_index]", name, name, stepIndex, circularBufferSize);
				}
				return String.format("context->%s[(context->%s_index + %d) %% %d]", name, name, stepIndex,
						circularBufferSize);
			}
			return String.format("context->%s", name);
		}
		
	}

}
