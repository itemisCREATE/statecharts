package org.yakindu.sct.model.stext.expressions;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.Scope;

import com.google.inject.ImplementedBy;

@ImplementedBy(STextExpressionParser.class)
public interface IExpressionParser {

	public EObject parseExpression(String expression, String ruleName);

	public EObject parseExpression(String expression, String ruleName, Scope... context);

}
