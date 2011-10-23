package org.eclipselabs.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.il.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.il.VariableAccess;
import org.eclipselabs.damos.mscript.il.VariableReference;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;

public class VariableAccessGenerator extends ILSwitch<String> {

	private IMscriptGeneratorContext context;
	private VariableAccess variableAccess;
	
	public VariableAccessGenerator(IMscriptGeneratorContext context, VariableAccess variableAccess) {
		this.context = context;
		this.variableAccess = variableAccess;
	}

	public String generate() {
		return doSwitch(variableAccess.getTarget());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseTemplateVariableDeclaration(org.eclipselabs.mscript.language.il.TemplateVariableDeclaration)
	 */
	@Override
	public String caseTemplateVariableDeclaration(TemplateVariableDeclaration templateVariableDeclaration) {
		IValue templateArgument = context.getStaticEvaluationContext().getValue(templateVariableDeclaration);
		return writeLiteral(templateArgument);
	}
	
	private String writeLiteral(IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
			} else if (value.getDataType() instanceof IntegerType) {
				return MscriptGeneratorUtil.getLiteralString(context.getComputationModel(), numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
			}
		} else if (value instanceof IBooleanValue){
			IBooleanValue booleanTemplateArgument = (IBooleanValue) value;
			return booleanTemplateArgument.booleanValue() ? "1" : "0";
		} else if (value instanceof IArrayValue && variableAccess instanceof VariableReference) {
			VariableReference variableReference = (VariableReference) variableAccess;
			IArrayValue arrayValue = (IArrayValue) value;
			int[] indices = new int[variableReference.getArrayIndices().size()];
			for (int i = 0; i < indices.length; ++i) {
				Expression indexExpression = variableReference.getArrayIndices().get(i);
				if (indexExpression instanceof IntegerLiteral) {
					indices[i] = (int) ((IntegerLiteral) indexExpression).getValue();
				} else {
					throw new RuntimeException("indexExpression must be IntegerLiteral");
				}
			}
			IValue elementValue = arrayValue.get(indices);
			return writeLiteral(elementValue);
		}
		throw new IllegalArgumentException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseStatefulVariableDeclaration(org.eclipselabs.mscript.language.il.StatefulVariableDeclaration)
	 */
	@Override
	public String caseStatefulVariableDeclaration(StatefulVariableDeclaration statefulVariableDeclaration) {
		return context.getVariableAccessStrategy().getVariableAccessString(variableAccess);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
	 */
	@Override
	public String caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		return localVariableDeclaration.getName();
	}
	
}
