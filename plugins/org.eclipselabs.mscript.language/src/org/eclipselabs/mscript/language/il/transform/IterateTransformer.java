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

package org.eclipselabs.mscript.language.il.transform;

import java.util.Collections;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.il.CompoundStatement;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.ILFactory;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.util.StatusUtil;

/**
 * @author Andreas Unger
 *
 */
public class IterateTransformer implements IIterationCallTransformer {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.transform.IIterationCallTransformer#transform(org.eclipselabs.mscript.language.ast.IterationCall, org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTransformer.Scope)
	 */
	public IIterationCallTransformerResult transform(ITransformerContext context, IterationCall iterationCall, Expression collectionExpression) {
		MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Transform errors", null);
		
		LocalVariableDeclaration accumulatorDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		accumulatorDeclaration.setName(iterationCall.getAccumulator().getName());
		context.getCompound().getStatements().add(accumulatorDeclaration);
		ForeachStatement foreachStatement = ILFactory.eINSTANCE.createForeachStatement();
		
		LocalVariableDeclaration iterationVariableDeclaration = ILFactory.eINSTANCE.createLocalVariableDeclaration();
		iterationVariableDeclaration.setName(iterationCall.getVariables().get(0).getName());

		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getAccumulator().getInitializer(),
				Collections.singletonList(new ExpressionTarget(accumulatorDeclaration, 0))));

		foreachStatement.setIterationVariableDeclaration(iterationVariableDeclaration);
		foreachStatement.setCollectionExpression(collectionExpression);

		CompoundStatement body = ILFactory.eINSTANCE.createCompoundStatement();
		context.enterScope();
		context.setCompound(body);
		context.addVariableDeclaration(accumulatorDeclaration);
		context.addVariableDeclaration(iterationVariableDeclaration);
		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getExpression(),
				Collections.singletonList(new ExpressionTarget(accumulatorDeclaration, 0))));
		context.leaveScope();
		foreachStatement.setBody(body);

		context.getCompound().getStatements().add(foreachStatement);
		
		if (!status.isOK()) {
			return new IterationCallTransformerResult(accumulatorDeclaration, status);
		}
		
		return new IterationCallTransformerResult(accumulatorDeclaration);
	}

}
