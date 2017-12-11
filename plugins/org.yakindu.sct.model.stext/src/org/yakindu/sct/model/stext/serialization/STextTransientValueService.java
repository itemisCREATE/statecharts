/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.serialization;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.yakindu.sct.model.stext.stext.LocalReaction;

/**
 * @author robert rudi - Initial contribution and API
 * 
 */
public class STextTransientValueService extends DefaultTransientValueService {

	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		return (owner instanceof LocalReaction) ? false : super.isTransient(owner, feature, index);
	}

}