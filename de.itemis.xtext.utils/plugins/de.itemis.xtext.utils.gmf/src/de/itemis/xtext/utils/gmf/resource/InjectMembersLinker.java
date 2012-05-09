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
package de.itemis.xtext.utils.gmf.resource;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

/**
 * 
 * Customized implementation of the Xtext {@link Linker} that ensures that only
 * crossreferences which are described by Xtext are cleared. If the default
 * linker is used all crossreferences of the whole model are checked.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersLinker extends Linker implements
		IInjectMembersResourceAnnotations {

	@Override
	protected void clearReference(EObject obj, EReference ref) {
		// If the CompositeNodeWithSemanticElement adapter exists, we know that
		// this is an Xtext model element.
		if (EcoreUtil.getAdapter(obj.eAdapters(),
				CompositeNodeWithSemanticElement.class) != null) {
			super.clearReference(obj, ref);
		}
	}

	@Override
	protected void ensureModelLinked(EObject model,
			final IDiagnosticProducer producer) {
		// The order of link resolution have to be changed here.
		// The FeatureCall is a container of the TypedElementReference,
		// but the child have to be resolved to determine the correct
		// for the FeatureCall
		List<EObject> contents = model.eContents();
		for (EObject current : contents) {
			EAnnotation eAnnotation = current.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation == null) {
				ensureModelLinked(current, producer);
			}
		}
		ensureLinked(model, producer);
	}

}
