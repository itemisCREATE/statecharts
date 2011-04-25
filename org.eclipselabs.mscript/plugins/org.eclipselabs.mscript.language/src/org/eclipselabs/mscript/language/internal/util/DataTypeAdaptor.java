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

package org.eclipselabs.mscript.language.internal.util;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ExpressionDataTypeAdaptor;
import org.eclipselabs.mscript.language.il.util.IExpressionDataTypeAdaptor;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeAdaptor extends ILSwitch<Boolean> {
	
	private IExpressionDataTypeAdaptor expressionAdaptor = new ExpressionDataTypeAdaptor();
	
	private MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Data type adaptor errors", null);
	
	public IStatus adapt(ILFunctionDefinition functionDefinition) {
		boolean finished;
		
		do {
			finished = doSwitch(functionDefinition.getInitializationCompound());
			if (finished) {
				for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
					finished = doSwitch(compound);
					if (!finished) {
						break;
					}
				}
			}
		} while (!finished && status.isOK());
		
		return status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.il.Compound)
	 */
	@Override
	public Boolean caseCompound(Compound compound) {
		for (Statement statement : compound.getStatements()) {
			if (!doSwitch(statement)) {
				return false;
			}
		}
		return true;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
	 */
	@Override
	public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		Expression initializer = localVariableDeclaration.getInitializer();
		if (initializer != null) {
			expressionAdaptor.adapt(initializer);
			DataType dataType = ILUtil.getDataType(initializer);
			return updateDataType(localVariableDeclaration, dataType);
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.il.Assignment)
	 */
	@Override
	public Boolean caseAssignment(Assignment assignment) {
		Expression assignedExpression = assignment.getAssignedExpression();
		expressionAdaptor.adapt(assignedExpression);
		DataType dataType = ILUtil.getDataType(assignedExpression);
		return updateDataType(assignment.getTarget(), dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.il.IfStatement)
	 */
	@Override
	public Boolean caseIfStatement(IfStatement ifStatement) {
		Expression condition = ifStatement.getCondition();
		expressionAdaptor.adapt(condition);
		return status.isOK() && doSwitch(ifStatement.getThenStatement()) && doSwitch(ifStatement.getElseStatement());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseForeachStatement(org.eclipselabs.mscript.language.il.ForeachStatement)
	 */
	@Override
	public Boolean caseForeachStatement(ForeachStatement foreachStatement) {
		Expression collectionExpression = foreachStatement.getCollectionExpression();
		expressionAdaptor.adapt(collectionExpression);
		DataType collectionType = ILUtil.getDataType(collectionExpression);
		if (!status.isOK()) {
			return false;
		}
		
		if (!(collectionType instanceof ArrayType)) {
			status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, "Collection type must be array type"));
			return false;
		}
		
		ArrayType arrayType = (ArrayType) collectionType;
		
		return updateDataType(foreachStatement.getIterationVariableDeclaration(), arrayType.getElementType()) && doSwitch(foreachStatement.getBody());
	}
		
	private boolean updateDataType(VariableDeclaration variableDeclaration, DataType dataType) {
		if (variableDeclaration.getDataType() == null) {
			variableDeclaration.setDataType(dataType);
			return true;
		}
		
		if (variableDeclaration.getDataType() == dataType) {
			return true;
		}

		DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(variableDeclaration.getDataType(), dataType);
		if (leftHandDataType == null) {
			status.add(new Status(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, "Incompatible data types"));
			return false;
		}
		
		if (leftHandDataType == dataType) {
			variableDeclaration.setDataType(leftHandDataType);
			return false;
		}
		
		return true;
	}
			
}
