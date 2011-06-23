package org.eclipselabs.mscript.codegen.c.internal;

import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.core.value.IArrayValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

public class VariableAccessGenerator extends ILSwitch<String> {

	private ComputationModel computationModel;
	private IVariableAccessStrategy variableAccessStrategy;
	private VariableAccess variableAccess;
	
	public VariableAccessGenerator(ComputationModel computationModel, IVariableAccessStrategy variableAccessStrategy, VariableAccess variableAccess) {
		this.computationModel = computationModel;
		this.variableAccessStrategy = variableAccessStrategy;
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
		IValue templateArgument = templateVariableDeclaration.getValue();
		return writeLiteral(templateArgument);
	}
	
	private String writeLiteral(IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return MscriptGeneratorUtil.getLiteralString(computationModel, numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
			} else if (value.getDataType() instanceof IntegerType) {
				return MscriptGeneratorUtil.getLiteralString(computationModel, numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
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
		return variableAccessStrategy.getVariableAccessString(variableAccess);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
	 */
	@Override
	public String caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		return localVariableDeclaration.getName();
	}
	
}
