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

package org.eclipselabs.mscript.codegen.c;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.common.util.PrintAppendable;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGenerator {
	
	private final ICompoundGenerator compoundGenerator = new CompoundGenerator();
	
	private ILFunctionDefinition functionDefinition;
	
	private IMscriptGeneratorContext context;
	
	private PrintAppendable out;
	
	/**
	 * 
	 */
	public MscriptGenerator(ILFunctionDefinition functionDefinition, IMscriptGeneratorContext context) {
		this.functionDefinition = functionDefinition;
		this.context = context;
		out = new PrintAppendable(context.getAppendable());
	}
	
	public void generateHeaderCode() {
		out.printf("#ifndef %s_H_\n", functionDefinition.getName().toUpperCase());
		out.printf("#define %s_H_\n", functionDefinition.getName().toUpperCase());
		out.println();
		generateHeaderIncludes();
		out.println();
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		if (functionDefinition.isStateful()) {
			generateContextStructure();
		}

		out.println();
		generateFunctionPrototypes();
		out.println();

		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s_H_ */\n", functionDefinition.getName().toUpperCase());
	}
	
	public void generateHeaderIncludes() {
		out.println("#include <stdint.h>");
	}
	
	public void generateContextStructure() {
		out.printf("typedef struct {\n");
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(inputVariableDeclaration);
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(outputVariableDeclaration);
			}
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration : functionDefinition.getInstanceVariableDeclarations()) {
			writeContextStructureMember(instanceVariableDeclaration);
		}
		out.printf("} %s_Context;\n", functionDefinition.getName());
	}
	
	private void writeContextStructureMember(StatefulVariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getName();
		DataType dataType = getDataType(variableDeclaration);
		if (variableDeclaration.getCircularBufferSize() > 1) {
			int bufferSize = variableDeclaration.getCircularBufferSize();
			out.printf("%s[%d];\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false),
					bufferSize);
			out.printf("%s %s_index;\n", MscriptGeneratorUtil.getIndexCDataType(context.getComputationModel(), 2 * bufferSize), name);
		} else {
			out.printf("%s;\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false));
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionHeader();
			out.println(";");
			generateComputeOutputsFunctionHeader();
			out.println(";");
			generateUpdateFunctionHeader();
			out.println(";");
		} else {
			generateStatelessFunctionHeader();
			out.println(";");
		}
	}

	public void generateImplementationCode() {
		generateImplementationIncludes();
		out.println();
		generateFunctionImplementations();
	}
	
	public void generateImplementationIncludes() {
		out.println("#include <math.h>");
		out.println("#include <string.h>");
		out.printf("#include \"%s.h\"\n", functionDefinition.getName());
	}
	
	public void generateFunctionImplementations() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionImplementation();

			out.println();

			generateComputeOutputsImplementation();

			out.println();

			generateUpdateFunctionImplementation();
		} else {
			generateStatelessFunctionHeader();
			out.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				compoundGenerator.generate(context, compound);
			}
			out.println("}");
		}
	}

	/**
	 * 
	 */
	private void generateInitializeFunctionHeader() {
		out.printf("void %s_initialize(%s_Context *context)", functionDefinition.getName(), functionDefinition.getName());
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateInitializeFunctionImplementation() {
		generateInitializeFunctionHeader();
		out.println(" {");
		generateInitializeIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		compoundGenerator.generate(context, functionDefinition.getInitializationCompound());
		out.println("}");
	}

	private void generateInitializeIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				out.printf("context->%s_index = 0;\n", statefulVariableDeclaration.getName());
			}
		}
	}

	/**
	 * 
	 */
	private void generateComputeOutputsFunctionHeader() {
		out.printf("void %s(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputVariableDeclaration inputVariableDeclaration : ILUtil.getDirectFeedthroughInputs(functionDefinition)) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputVariableDeclaration), inputVariableDeclaration.getName(), false));
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(outputVariableDeclaration), outputVariableDeclaration.getName(), true));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateComputeOutputsImplementation() {
		generateComputeOutputsFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		
		for (InputVariableDeclaration inputVariableDeclaration : ILUtil.getDirectFeedthroughInputs(functionDefinition)) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				generateUpdateInputContextStatement(inputVariableDeclaration);
			}
		}
		
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				String name = outputVariableDeclaration.getName();
				out.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
			}
		}
		out.println("}");
	}

	/**
	 * 
	 */
	private void generateUpdateFunctionHeader() {
		out.printf("void %s_update(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputVariableDeclaration inputVariableDeclaration : getUpdateCodeInputs()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputVariableDeclaration), inputVariableDeclaration.getName(), false));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateUpdateFunctionImplementation() {
		generateUpdateFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		for (InputVariableDeclaration inputVariableDeclaration : getUpdateCodeInputs()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				generateUpdateInputContextStatement(inputVariableDeclaration);
			}
		}
		generateUpdateIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		out.println("}");
	}
	
	private List<InputVariableDeclaration> getUpdateCodeInputs() {
		List<InputVariableDeclaration> inputs = new ArrayList<InputVariableDeclaration>(functionDefinition.getInputVariableDeclarations());
		inputs.removeAll(ILUtil.getDirectFeedthroughInputs(functionDefinition));
		return inputs;
	}

	private void generateUpdateInputContextStatement(InputVariableDeclaration inputVariableDeclaration) {
		String name = inputVariableDeclaration.getName();
		out.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
	}

	/**
	 * 
	 */
	private void generateUpdateIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				String name = statefulVariableDeclaration.getName();
				out.printf("context->%s_index = (context->%s_index + 1) %% %d;\n", name, name, statefulVariableDeclaration.getCircularBufferSize());
			}
		}
	}

	/**
	 * 
	 */
	private void generateStatelessFunctionHeader() {
		out.printf("void %s(", functionDefinition.getName(), functionDefinition.getName());
		boolean first = true;
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputVariableDeclaration), inputVariableDeclaration.getName(), false));
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(outputVariableDeclaration), outputVariableDeclaration.getName(), true));
		}
		out.print(")");
	}

	/**
	 * @param eObject
	 * @return
	 */
	private DataType getDataType(EObject eObject) {
		IValue value = context.getStaticEvaluationContext().getValue(eObject);
		return value != null ? value.getDataType() : null;
	}

}
