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

import org.eclipselabs.mscript.codegen.c.util.GeneratorUtil;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class Generator {
	
	private ILFunctionDefinition functionDefinition;
	
	private IGeneratorContext context;
	
	private PrintWriter writer;
	
	/**
	 * 
	 */
	public Generator(ILFunctionDefinition functionDefinition, IGeneratorContext context) {
		this.functionDefinition = functionDefinition;
		this.context = context;
		this.writer = new PrintWriter(context.getWriter());
	}
	
	public void generateHeaderCode() {
		writer.printf("#ifndef _%s_H\n", functionDefinition.getName().toUpperCase());
		writer.printf("#define _%s_H\n", functionDefinition.getName().toUpperCase());
		writer.println();
		
		generateHeaderIncludes();
		writer.println();
		if (functionDefinition.isStateful()) {
			generateContextStructure();
		}

		writer.println();
		generateFunctionPrototypes();
		writer.println();

		writer.printf("#endif /* _%s_H */\n", functionDefinition.getName().toUpperCase());
	}
	
	public void generateHeaderIncludes() {
		writer.println("#include <stdint.h>");
	}
	
	public void generateContextStructure() {
		writer.printf("typedef struct {\n");
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(inputVariableDeclaration);
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(outputVariableDeclaration);
			}
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration: functionDefinition.getInstanceVariableDeclarations()) {
			writeContextStructureMember(instanceVariableDeclaration);
		}
		writer.printf("} %s_Context;\n", functionDefinition.getName());
	}
	
	private void writeContextStructureMember(StatefulVariableDeclaration variableDeclaration) {
		if (variableDeclaration.getCircularBufferSize() > 1) {
			writer.printf("%s %s[%d];\n",
					GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(variableDeclaration.getType())),
					variableDeclaration.getName(),
					variableDeclaration.getCircularBufferSize());
			writer.printf("int %s_index;\n", variableDeclaration.getName());
		} else {
			writer.printf("%s %s;\n",
					GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(variableDeclaration.getType())),
					variableDeclaration.getName(),
					variableDeclaration.getCircularBufferSize());
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionHeader();
			writer.println(";");
			generateComputationFunctionHeader();
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
		writer.printf("#include \"%s.h\"\n", functionDefinition.getName());
	}
	
	public void generateFunctionImplementations() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionHeader();
			writer.println(" {");
			generateInitializeIndexStatements(functionDefinition.getInputVariableDeclarations());
			generateInitializeIndexStatements(functionDefinition.getOutputVariableDeclarations());
			generateInitializeIndexStatements(functionDefinition.getInstanceVariableDeclarations());
			new CompoundGenerator(context).doSwitch(functionDefinition.getInitializationCompound());
			writer.println("}");

			writer.println();

			generateComputationFunctionHeader();
			writer.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				if (!compound.getOutputs().isEmpty()) {
					new CompoundGenerator(context).doSwitch(compound);
				}
			}
			for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
				if (inputVariableDeclaration.getCircularBufferSize() > 1) {
					String name = inputVariableDeclaration.getName();
					writer.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
				}
			}
			for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
				if (outputVariableDeclaration.getCircularBufferSize() > 1) {
					String name = outputVariableDeclaration.getName();
					writer.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
				}
			}
			writer.println("}");

			writer.println();

			generateUpdateFunctionHeader();
			writer.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				if (compound.getOutputs().isEmpty()) {
					new CompoundGenerator(context).doSwitch(compound);
				}
			}
			generateUpdateIndexStatements(functionDefinition.getInputVariableDeclarations());
			generateUpdateIndexStatements(functionDefinition.getOutputVariableDeclarations());
			generateUpdateIndexStatements(functionDefinition.getInstanceVariableDeclarations());
			writer.println("}");
		} else {
			generateStatelessFunctionHeader();
			writer.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				new CompoundGenerator(context).doSwitch(compound);
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
	private void generateComputationFunctionHeader() {
		writer.printf("void %s(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				for (InputVariableDeclaration inputVariableDeclaration : compound.getInputs()) {
					writer.printf(", %s %s", GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(inputVariableDeclaration.getType())), inputVariableDeclaration.getName());
				}
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			writer.printf(", %s *%s", GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(outputVariableDeclaration.getType())), outputVariableDeclaration.getName());
		}
		writer.print(")");
	}

	/**
	 * 
	 */
	private void generateUpdateFunctionHeader() {
		writer.printf("void %s_update(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				for (InputVariableDeclaration inputVariableDeclaration : compound.getInputs()) {
					writer.printf(", %s %s", GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(inputVariableDeclaration.getType())), inputVariableDeclaration.getName());
				}
			}
		}
		writer.print(")");
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
			writer.printf("%s %s", GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(inputVariableDeclaration.getType())), inputVariableDeclaration.getName());
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				writer.print(", ");
			}
			writer.printf("%s *%s", GeneratorUtil.getCDataType(context.getComputationModel().getNumberFormat(outputVariableDeclaration.getType())), outputVariableDeclaration.getName());
		}
		writer.print(")");
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
	
}
