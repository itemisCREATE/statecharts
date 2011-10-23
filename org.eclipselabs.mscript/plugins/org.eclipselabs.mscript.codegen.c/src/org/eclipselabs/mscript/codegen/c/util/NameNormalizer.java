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

package org.eclipselabs.mscript.codegen.c.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.il.Compound;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ForeachStatement;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.VariableDeclaration;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.mscript.common.internal.util.Scope;

/**
 * @author Andreas Unger
 * 
 */
public class NameNormalizer {

	private static final Set<String> RESERVED_WORDS = new HashSet<String>();

	{
		// keywords
		RESERVED_WORDS.add("auto");
		RESERVED_WORDS.add("break");
		RESERVED_WORDS.add("case");
		RESERVED_WORDS.add("char");
		RESERVED_WORDS.add("const");
		RESERVED_WORDS.add("continue");
		RESERVED_WORDS.add("default");
		RESERVED_WORDS.add("do");
		RESERVED_WORDS.add("double");
		RESERVED_WORDS.add("else");
		RESERVED_WORDS.add("enum");
		RESERVED_WORDS.add("extern");
		RESERVED_WORDS.add("float");
		RESERVED_WORDS.add("for");
		RESERVED_WORDS.add("goto");
		RESERVED_WORDS.add("if");
		RESERVED_WORDS.add("int");
		RESERVED_WORDS.add("long");
		RESERVED_WORDS.add("register");
		RESERVED_WORDS.add("return");
		RESERVED_WORDS.add("short");
		RESERVED_WORDS.add("signed");
		RESERVED_WORDS.add("sizeof");
		RESERVED_WORDS.add("static");
		RESERVED_WORDS.add("struct");
		RESERVED_WORDS.add("switch");
		RESERVED_WORDS.add("typedef");
		RESERVED_WORDS.add("union");
		RESERVED_WORDS.add("unsigned");
		RESERVED_WORDS.add("void");
		RESERVED_WORDS.add("volatile");
		RESERVED_WORDS.add("while");
		
		// standard typedefs
		RESERVED_WORDS.add("int8_t");
		RESERVED_WORDS.add("int16_t");
		RESERVED_WORDS.add("int32_t");
		RESERVED_WORDS.add("int64_t");
		RESERVED_WORDS.add("uint8_t");
		RESERVED_WORDS.add("uint16_t");
		RESERVED_WORDS.add("uint32_t");
		RESERVED_WORDS.add("uint64_t");
		RESERVED_WORDS.add("bool");		
	}
	
	public void normalize(ILFunctionDefinition functionDefinition) {
		NormalizerScope scope = new NormalizerScope(null);
		
		normalize(functionDefinition.getInputVariableDeclarations(), scope);
		normalize(functionDefinition.getOutputVariableDeclarations(), scope);
		normalize(functionDefinition.getInstanceVariableDeclarations(), scope);

		CompoundNormalizer compoundNormalizer = new CompoundNormalizer(scope);
		compoundNormalizer.doSwitch(functionDefinition.getInitializationCompound());
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			compoundNormalizer.doSwitch(compound);
		}
	}
	
	private void normalize(List<? extends VariableDeclaration> variableDeclarations, NormalizerScope scope) {
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			String name = variableDeclaration.getName();
			if (isReserved(name)) {
				name += "1";
			}
			variableDeclaration.setName(name);
			scope.add(name, variableDeclaration);
		}
	}
	
	private static boolean isReserved(String name) {
		if (RESERVED_WORDS.contains(name)) {
			return true;
		}
		if (name.endsWith("_i")) {
			return true;
		}
		if (name.endsWith("_index")) {
			return true;
		}
		return false;
	}
	
	private static class CompoundNormalizer extends ILSwitch<Boolean> {
		
		private NormalizerScope scope;
		
		private AstCompoundNormalizer astCompoundNormalizer = new AstCompoundNormalizer();
		
		/**
		 * 
		 */
		public CompoundNormalizer(NormalizerScope scope) {
			this.scope = scope;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.il.Compound)
		 */
		@Override
		public Boolean caseCompound(Compound compound) {
			scope = new NormalizerScope(scope);
			for (Statement statement : compound.getStatements()) {
				doSwitch(statement);
			}
			scope = scope.getOuterScope();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.il.LocalVariableDeclaration)
		 */
		@Override
		public Boolean caseVariableDeclaration(VariableDeclaration variableDeclaration) {
			String preferredName = variableDeclaration.getName();
			if (preferredName == null) {
				preferredName = "temp";
			}
			String name = preferredName;
			if (isReserved(name)) {
				name += "1";
			}
			int n = 1;
			while (scope.findInEnclosingScopes(name) != null) {
				name = preferredName + ++n;
			}
			variableDeclaration.setName(name);
			scope.add(name, variableDeclaration);
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseForeachStatement(org.eclipselabs.mscript.language.il.ForeachStatement)
		 */
		@Override
		public Boolean caseForeachStatement(ForeachStatement foreachStatement) {
			doSwitch(foreachStatement.getIterationVariableDeclaration());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			return astCompoundNormalizer.doSwitch(object);
		}
		
		private class AstCompoundNormalizer extends MscriptSwitch<Boolean> {
			
			@Override
			public Boolean caseIfStatement(IfStatement ifStatement) {
				CompoundNormalizer.this.doSwitch(ifStatement.getThenStatement());
				CompoundNormalizer.this.doSwitch(ifStatement.getElseStatement());
				return true;
			}
			
		}
		
	}
	
	private static class NormalizerScope extends Scope<NormalizerScope, String, VariableDeclaration> {

		/**
		 * @param outerScope
		 */
		public NormalizerScope(NormalizerScope outerScope) {
			super(outerScope);
		}
		
	}

}
