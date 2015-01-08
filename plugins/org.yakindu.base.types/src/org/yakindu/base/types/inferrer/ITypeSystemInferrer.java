/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.inferrer;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ITypeSystemInferrer {

	public Type inferType(EObject object, IValidationIssueAcceptor acceptor);
	
}
