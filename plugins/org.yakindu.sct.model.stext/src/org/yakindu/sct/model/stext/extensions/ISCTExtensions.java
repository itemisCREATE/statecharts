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
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * @author jonathan thoene - Initial contribution and API
 * 
 */

public interface ISCTExtensions {
	public SpecificationElement getContextElement(EObject context);
	
	public ScopedElement getScopedElement(EObject context);
	
	public Statechart getStatechart(EObject context);
	
	public Statechart getStatechart(final Resource context);
}
