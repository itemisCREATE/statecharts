/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

/**
 * @author andreas muelder
 * 
 */
public class SCTLinker extends LazyLinker {

	@Override
	protected void clearReference(EObject obj, EReference ref) {
		// If the CompositeNodeWithSemanticElement adapter exists, we know that
		// this is an Xtext model element.
		if (EcoreUtil.getAdapter(obj.eAdapters(),
				CompositeNodeWithSemanticElement.class) != null) {
			super.clearReference(obj, ref);
		}
	}
}
