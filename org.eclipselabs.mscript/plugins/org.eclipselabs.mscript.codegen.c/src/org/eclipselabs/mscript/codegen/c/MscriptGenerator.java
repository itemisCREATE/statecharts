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

import java.io.PrintWriter;
import java.util.List;

import org.eclipselabs.mscript.codegen.c.internal.VariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGenerator {
	
	private final ICompoundGenerator compoundGenerator = new CompoundGenerator();
	
	private ILFunctionDefinition functionDefinition;
	
	private IMscriptGeneratorContext context;
	
	private PrintWriter writer;
	
	/**
	 * 
	 */
	public MscriptGenerator(ILFunctionDefinition functionDefinition, IMscriptGeneratorContext context) {
		this.functionDefinition = functionDefinition;
		this.context = context;
		this.writer = new PrintWriter(context.getWriter());
	}
	
	public void generateHeaderCode() {
		writer.printf("#ifndef %s_H_\n", functionDefinition.getName().toUpperCase());
		writer.printf("#define %s_H_\n", functionDefinition.getName().toUpperCase());
		writer.println();
		generateHeaderIncludes();
		writer.println();
		writer.println("#ifdef __cplusplus");
		writer.println("extern \"C\" {");
		writer.println("#endif /* __cplusplus */");
		writer.println();
		
		if (functionDefinition.isStateful()) {
			generateContextStructure();
		}

		writer.println();
		generateFunctionPrototypes();
		writer.println();

		writer.println("#ifdef __cplusplus");
		writer.println("}");
		writer.println("#endif /* __cplusplus */");
		writer.println();
		writer.printf("#endif /* %s_H_ */\n", functionDefinition.getName().toUpperCase());
	}
	
	public void generateHeaderIncludes() {
		writer.println("#include <stdint.h>");
	}
	
	public void generateContextStructure() {
		writer.printf("typedef struct {\n");
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
		writer.printf("} %s_Context;\n", functionDefinition.getName());
	}
	
	private void writeContextStructureMember(StatefulVariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getName();
		DataType dataType = variableDeclaration.getType();
		if (variableDeclaration.getCircularBufferSize() > 1) {
			int bufferSize = variableDeclaration.getCircularBufferSize();
			writer.printf("%s[%d];\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false),
					bufferSize);
			writer.printf("%s %s_index;\n", MscriptGeneratorUtil.getIndexCDataType(context.getComputationModel(), 2 * bufferSize), name);
		} else {
			writer.printf("%s;\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false));
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionHeader();
			writer.println(";");
			generateComputeOutputsFunctionHeader();
			writer.println(";");
			generateUpdateFunctionHeader();
			writer.println(";");
		} else {
			generateStatelessFunctionHeader();
			writer.println(";");
		}
	}

	public void generateImplementationCode() {
		generateImplementationIncludes();
		writer.println();
		generateFunctionImplementations();
	}
	
	public void generateImplementationIncludes() {
		writer.println("#include <math.h>");
		writer.println("#include <string.h>");
		writer.printf("#include \"%s.h\"\n", functionDefinition.getName());
	}
	
	public void generateFunctionImplementations() {
		IVariableAccessStrategy variableAccessStrategy = new VariableAccessStrategy();
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionImplementation(variableAccessStrategy);

			writer.println();

			generateComputeOutputsImplementation(variableAccessStrategy);

			writer.println();

			generateUpdateFunctionImplementation(variableAccessStrategy);
		} else {
			generateStatelessFunctionHeader();
			writer.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				compoundGenerator.generate(context, variableAccessStrategy, compound);
			}
			writer.println("}");
		}
	}

	/**
	 * 
	 */
	private void generateInitializeFunctionHeader() {
		writer.printf("void %s_initialize(%s_Context *context)", functionDefinition.getName(), functionDefinition.getName());
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateInitializeFunctionImplementation(IVariableAccessStrategy variableAccessStrategy) {
		generateInitializeFunctionHeader();
		writer.println(" {");
		generateInitializeIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		compoundGenerator.generate(context, variableAccessStrategy, functionDefinition.getInitializationCompound());
		writer.println("}");
	}

	private void generateInitializeIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				writer.printf("context->%s_index = 0;\n", statefulVariableDeclaration.getName());
			}
		}
	}

	/**
	 * 
	 */
	private void generateComputeOutputsFunctionHeader() {
		writer.printf("void %s(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (consumesInput(inputVariableDeclaration, true)) {
				writer.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), inputVariableDeclaration.getType(), inputVariableDeclaration.getName(), false));
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			writer.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), outputVariableDeclaration.getType(), outputVariableDeclaration.getName(), true));
		}
		writer.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateComputeOutputsImplementation(IVariableAccessStrategy variableAccessStrategy) {
		generateComputeOutputsFunctionHeader();
		writer.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, variableAccessStrategy, compound);
				for (InputVariableDeclaration inputVariableDeclaration : compound.getInputs()) {
					if (inputVariableDeclaration.getCircularBufferSize() > 1) {
						generateUpdateInputContextStatement(inputVariableDeclaration);
					}
				}
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				String name = outputVariableDeclaration.getName();
				writer.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
			}
		}
		writer.println("}");
	}

	/**
	 * 
	 */
	private void generateUpdateFunctionHeader() {
		writer.printf("void %s_update(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (consumesInput(inputVariableDeclaration, false) || updatesInputContext(inputVariableDeclaration)) {
				writer.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), inputVariableDeclaration.getType(), inputVariableDeclaration.getName(), false));
			}
		}
		writer.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateUpdateFunctionImplementation(IVariableAccessStrategy variableAccessStrategy) {
		generateUpdateFunctionHeader();
		writer.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, variableAccessStrategy, compound);
			}
		}
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (updatesInputContext(inputVariableDeclaration)) {
				generateUpdateInputContextStatement(inputVariableDeclaration);
			}
		}
		generateUpdateIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		writer.println("}");
	}
	
	private boolean consumesInput(InputVariableDeclaration inputVariableDeclaration, boolean feedsOutputs) {
		for (ComputationCompound compound : inputVariableDeclaration.getFeedingCompounds()) {
			if (compound.getOutputs().isEmpty() != feedsOutputs) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param inputVariableDeclaration
	 * @return
	 */
	private boolean updatesInputContext(InputVariableDeclaration inputVariableDeclaration) {
		if (inputVariableDeclaration.getCircularBufferSize() > 1) {
			if (inputVariableDeclaration.getFeedingCompounds().isEmpty()) {
				return true;
			}
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				if (compound.getOutputs().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void generateUpdateInputContextStatement(InputVariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getName();
		writer.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
	}

	/**
	 * 
	 */
	private void generateUpdateIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				String name = statefulVariableDeclaration.getName();
				writer.printf("context->%s_index = (context->%s_index + 1) %% %d;\n", name, name, statefulVariableDeclaration.getCircularBufferSize());
			}
		}
	}

	/**
	 * 
	 */
	private void generateStatelessFunctionHeader() {
		writer.printf("void %s(", functionDefinition.getName(), functionDefinition.getName());
		boolean first = true;
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				writer.print(", ");
			}
			writer.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), inputVariableDeclaration.getType(), inputVariableDeclaration.getName(), false));
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				writer.print(", ");
			}
			writer.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), outputVariableDeclaration.getType(), outputVariableDeclaration.getName(), true));
		}
		writer.print(")");
	}
	
}
