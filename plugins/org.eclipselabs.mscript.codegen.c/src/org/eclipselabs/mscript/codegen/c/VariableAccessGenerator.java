package org.eclipselabs.mscript.codegen.c;

import java.io.PrintWriter;

import org.eclipselabs.mscript.codegen.c.util.GeneratorUtil;
import org.eclipselabs.mscript.computation.engine.value.IBooleanValue;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

public class VariableAccessGenerator extends ILSwitch<Boolean> {

	private IMscriptGeneratorContext context;
	private VariableDeclaration target;
	private int stepIndex;
	
	private PrintWriter writer;
	
	public VariableAccessGenerator(IMscriptGeneratorContext context, VariableAccess variableAccess) {
		this(context, variableAccess.getTarget(), variableAccess.getStepIndex());
	}

	public VariableAccessGenerator(IMscriptGeneratorContext context, VariableDeclaration target, int stepIndex) {
		this.context = context;
		this.target = target;
		this.stepIndex = stepIndex;
		writer = new PrintWriter(context.getWriter());
	}
	
	public void generate() {
		doSwitch(target);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseTemplateVariableDeclaration(org.eclipselabs.mscript.language.il.TemplateVariableDeclaration)
	 */
	@Override
	public Boolean caseTemplateVariableDeclaration(TemplateVariableDeclaration templateVariableDeclaration) {
		IValue templateArgument = templateVariableDeclaration.getValue();
		if (templateArgument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) templateArgument;
			if (templateArgument.getDataType() instanceof RealType) {
				GeneratorUtil.writeLiteral(context, numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
			} else if (templateArgument.getDataType() instanceof IntegerType) {
				GeneratorUtil.writeLiteral(context, numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
			}
		} else if (templateArgument instanceof IBooleanValue){
			IBooleanValue booleanTemplateArgument = (IBooleanValue) templateArgument;
			writer.print(booleanTemplateArgument.booleanValue() ? "1" : "0");
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInputVariableDeclaration(org.eclipselabs.mscript.language.il.InputVariableDeclaration)
	 */
	@Override
	public Boolean caseInputVariableDeclaration(InputVariableDeclaration inputVariableDeclaration) {
		if (stepIndex == 0) {
			writer.print(inputVariableDeclaration.getName());
		} else {
			writeContextAccess();
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseOutputVariableDeclaration(org.eclipselabs.mscript.language.il.OutputVariableDeclaration)
	 */
	@Override
	public Boolean caseOutputVariableDeclaration(OutputVariableDeclaration outputVariableDeclaration) {
		if (stepIndex == 0) {
			writer.printf("*%s", outputVariableDeclaration.getName());
		} else {
			writeContextAccess();
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInstanceVariableDeclaration(org.eclipselabs.mscript.language.il.InstanceVariableDeclaration)
	 */
	@Override
	public Boolean caseInstanceVariableDeclaration(InstanceVariableDeclaration instanceVariableDeclaration) {
		writeContextAccess();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
	 */
	@Override
	public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		writer.print(localVariableDeclaration.getName());
		return true;
	}
	
	private void writeContextAccess() {
		String name = target.getName();
		int circularBufferSize = ((StatefulVariableDeclaration) target).getCircularBufferSize();
		if (circularBufferSize > 1) {
			if (stepIndex == 0) {
				writer.printf("context->%s[context->%s_index]", name, name, stepIndex,
						circularBufferSize);
			} else if (stepIndex < 0) {
				writer.printf("context->%s[(context->%s_index - %d) %% %d]", name, name, -stepIndex,
						circularBufferSize);
			} else {
				writer.printf("context->%s[(context->%s_index + %d) %% %d]", name, name, stepIndex,
						circularBufferSize);
			}
		} else {
			writer.printf("context->%s", name);
		}
	}
	
}
