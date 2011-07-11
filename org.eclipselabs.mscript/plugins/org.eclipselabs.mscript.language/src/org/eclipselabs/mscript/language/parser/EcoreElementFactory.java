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

package org.eclipselabs.mscript.language.parser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipselabs.mscript.typesystem.NumericLiteral;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class EcoreElementFactory extends DefaultEcoreElementFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.DefaultEcoreElementFactory#create(org.eclipse.emf.ecore.EClassifier)
	 */
	@Override
	public EObject create(EClassifier classifier) {
		EObject eObject = super.create(classifier);
		if (eObject instanceof NumericLiteral) {
			NumericLiteral numericLiteral = (NumericLiteral) eObject;
			numericLiteral.setUnit(TypeSystemUtil.createUnit());
		} else if (eObject instanceof NumericType) {
			NumericType numericType = (NumericType) eObject;
			numericType.setUnit(TypeSystemUtil.createUnit());
		}
		return eObject;
	}
	
}
