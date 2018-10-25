/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;

/**
 * @author jonathan thoene - Initial contribution and API
 * 
 */

public class STextExtensions {
	public SpecificationElement getContextElement(EObject context) {
		final ContextElementAdapter provider = getContextElementAdapter(context.eResource());

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, SpecificationElement.class);
		} else {
			return (SpecificationElement) provider.getElement();
		}
	}

	public Statechart getStatechart(EObject context) {
		final ContextElementAdapter provider = getContextElementAdapter(context.eResource());

		if (provider == null || provider.getElement() == null || provider.getElement().eResource() == null) {
			return EcoreUtil2.getContainerOfType(context, Statechart.class);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
	}

	public Statechart getStatechart(Resource context) {
		final ContextElementAdapter provider = getContextElementAdapter(context);
		if (provider == null || provider.getElement() == null) {
			return (Statechart) EcoreUtil2.getObjectByType(context.getContents(), SGraphPackage.Literals.STATECHART);
		} else {
			if (provider.getElement().eResource() == null)
				return null;
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
	}

	protected ContextElementAdapter getContextElementAdapter(Resource context) {
		return (ContextElementAdapter) EcoreUtil.getExistingAdapter(context, ContextElementAdapter.class);
	}
}
