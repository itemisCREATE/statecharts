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
import org.eclipse.xtext.serializer.sequencer.TransientValueService;
import org.yakindu.sct.model.stext.stext.LocalReaction;

/**
 * @author robert rudi - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class STextTransientValueService extends TransientValueService {

	@Override
	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature) {
		return (semanticObject instanceof LocalReaction) ? ValueTransient.NO
				: super.isValueTransient(semanticObject, feature);
	}

}