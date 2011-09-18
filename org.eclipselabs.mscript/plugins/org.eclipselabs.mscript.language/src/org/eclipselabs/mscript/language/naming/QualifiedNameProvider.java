/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipselabs.mscript.language.ast.Definition;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class QualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.naming.IQualifiedNameProvider#getFullyQualifiedName(org.eclipse.emf.ecore.EObject)
	 */
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof Definition) {
			final String qualifiedName = ((Definition) obj).getName();
			if (qualifiedName == null) {
				return null;
			}
			return qualifiedNameConverter.toQualifiedName(qualifiedName);
		}
		return null;
	}

}
