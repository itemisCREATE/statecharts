/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SGenCrossReferenceSerializer extends CrossReferenceSerializer {

	@Override
	public String serializeCrossRef(EObject semanticObject,
			CrossReference crossref, EObject target, INode node, Acceptor errors) {
		// for statechart crossreferences, we do not want to check the scope
		if (target instanceof Statechart) {
			return ((Statechart) target).getName();
		}
		return super.serializeCrossRef(semanticObject, crossref, target, node,
				errors);
	}

}
