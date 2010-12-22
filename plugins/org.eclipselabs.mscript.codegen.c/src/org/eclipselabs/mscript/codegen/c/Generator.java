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
import java.io.Writer;

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
	private PrintWriter writer;
	
	/**
	 * 
	 */
	public Generator(ILFunctionDefinition functionDefinition, Writer writer) {
		this.functionDefinition = functionDefinition;
		this.writer = new PrintWriter(writer);
	}
	
	public void generateHeaderCode() {
		if (functionDefinition.isStateful()) {
			generateContextStructure();
		}
		generateFunctionPrototypes();
	}
	
	public void generateContextStructure() {
		writer.printf("typedef struct {\n");
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			writeContextStructureMember(inputVariableDeclaration);
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			writeContextStructureMember(outputVariableDeclaration);
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration: functionDefinition.getInstanceVariableDeclarations()) {
			writeContextStructureMember(instanceVariableDeclaration);
		}
		writer.printf("} %s_Context;\n", functionDefinition.getName());
	}
	
	private void writeContextStructureMember(StatefulVariableDeclaration variableDeclaration) {
		if (variableDeclaration.getCircularBufferSize() > 1) {
			writer.printf("%s %s[%d];\n",
					GeneratorUtil.toString(variableDeclaration.getType()),
					variableDeclaration.getName(),
					variableDeclaration.getCircularBufferSize());
			writer.printf("int %s_index;\n", variableDeclaration.getName());
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionDefinition.isStateful()) {
			writer.printf("void %s_initialize(%s_Context *context);\n", functionDefinition.getName(), functionDefinition.getName());
			
			writer.printf("void %s(const %s_Context *context", functionDefinition.getName(), functionDefinition.getName());
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				if (!compound.getOutputs().isEmpty()) {
					for (InputVariableDeclaration inputVariableDeclaration : compound.getInputs()) {
						writer.printf(", const %s *%s", GeneratorUtil.toString(inputVariableDeclaration.getType()), inputVariableDeclaration.getName());
					}
				}
			}
			for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
				writer.printf(", %s *%s", GeneratorUtil.toString(outputVariableDeclaration.getType()), outputVariableDeclaration.getName());
			}
			writer.println(");");
			
			writer.printf("void %s_update(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				if (compound.getOutputs().isEmpty()) {
					for (InputVariableDeclaration inputVariableDeclaration : compound.getInputs()) {
						writer.printf(", const %s *%s", GeneratorUtil.toString(inputVariableDeclaration.getType()), inputVariableDeclaration.getName());
					}
				}
			}
			writer.println(");");
		} else {
			writer.printf("void %s(", functionDefinition.getName(), functionDefinition.getName());
			boolean first = true;
			for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
				if (first) {
					first = false;
				} else {
					writer.print(", ");
				}
				writer.printf("const %s *%s", GeneratorUtil.toString(inputVariableDeclaration.getType()), inputVariableDeclaration.getName());
			}
			for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
				if (first) {
					first = false;
				} else {
					writer.print(", ");
				}
				writer.printf("%s *%s", GeneratorUtil.toString(outputVariableDeclaration.getType()), outputVariableDeclaration.getName());
			}
			writer.println(");");
		}
	}
	
	public void generateImplementationCode() {
		generateIncludes();
		generateFunctionImplementations();
	}
	
	public void generateIncludes() {
		writer.printf("#include \"%s.h\"\n", functionDefinition.getName());
	}
	
	public void generateFunctionImplementations() {
		if (functionDefinition.isStateful()) {
			writer.printf("void %s_initialize(%s_Context *context) {\n", functionDefinition.getName(), functionDefinition.getName());
			new CompoundGenerator(writer).doSwitch(functionDefinition.getInitializationCompound());
			writer.println("}");
		} else {
			
		}
	}

}
