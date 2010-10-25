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

package org.eclipselabs.mscript.language.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Mscript;
import org.eclipselabs.mscript.language.ast.NamespaceDefinition;
import org.eclipselabs.mscript.language.ast.NamespaceMember;
import org.eclipselabs.mscript.language.ast.QualifiedName;
import org.eclipselabs.mscript.language.ast.TypeDefinition;

/**
 * @author Andreas Unger
 *
 */
public class LanguageUtil {

	public static String toString(QualifiedName qualifiedName) {
		StringBuilder sb = new StringBuilder();
		for (String identifier : qualifiedName.getIdentifiers()) {
			if (sb.length() > 0) {
				sb.append(".");
			}
			sb.append(identifier);
		}
		return sb.toString();
	}

	public static String getQualifiedNameString(TypeDefinition typeDefinition) {
		StringBuilder sb = new StringBuilder(typeDefinition.getName());
		EObject container = typeDefinition.eContainer();
		while (container instanceof NamespaceDefinition) {
			sb.insert(0, toString(((NamespaceDefinition) container).getName()) + ".");
			container = container.eContainer();
		}
		return sb.toString();
	}
	
	public static FunctionDefinition getFunctionDefinition(Mscript mscript, String qualifiedName) {
		for (NamespaceDefinition namespaceDefinition : mscript.getNamespaces()) {
			FunctionDefinition functionDefinition = getFunctionDefinition(namespaceDefinition, qualifiedName);
			if (functionDefinition != null) {
				return functionDefinition;
			}
		}
		return null;
	}
		
	public static FunctionDefinition getFunctionDefinition(NamespaceDefinition namespaceDefinition, String qualifiedName) {
		for (NamespaceMember member : namespaceDefinition.getMembers()) {
			if (member instanceof NamespaceDefinition) {
				FunctionDefinition functionDefinition = getFunctionDefinition((NamespaceDefinition) member, qualifiedName);
				if (functionDefinition != null) {
					return functionDefinition;
				}
			} else if (member instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) member;
				if (qualifiedName.equals(getQualifiedNameString(functionDefinition))) {
					return functionDefinition;
				}
			}
		}
		return null;
	}

}
