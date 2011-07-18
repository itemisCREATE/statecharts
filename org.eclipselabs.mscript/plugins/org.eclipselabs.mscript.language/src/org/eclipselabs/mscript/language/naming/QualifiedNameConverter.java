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

import org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl;

/**
 * @author Andreas Unger
 *
 */
public class QualifiedNameConverter extends DefaultImpl {
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl#getDelimiter()
	 */
	@Override
	public String getDelimiter() {
		return "::";
	}

}
