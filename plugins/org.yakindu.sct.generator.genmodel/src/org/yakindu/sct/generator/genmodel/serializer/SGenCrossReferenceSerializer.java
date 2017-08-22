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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SGenCrossReferenceSerializer extends CrossReferenceSerializer {
	
	@Inject 
	private IQualifiedNameProvider provider;
	
	@Override
	public String serializeCrossRef(EObject semanticObject,
			CrossReference crossref, EObject target, INode node, Acceptor errors) {
		Resource res = target.eResource();
		URI uri = res.getURI();
		// for statechart crossreferences and SCTUnitElement crossreferences, we do not want to check the scope
		/*
		 * Checking the ending of the uri is necessary if a project contains a Statechart and a SCTUnitElement with the same name.
		 * Because the super method of serializeCrossRef checks the Scope by getting the elements by name it takes the first Object that 
		 * has a matching name, this is always the Statechart and not the testclass. So it is impossible to get the SCTUnitElement object from the scope.
		 * Therefore we return the FQN if a target is a SCTUnitElement.
		 */
		if (target instanceof Statechart || uri.lastSegment().endsWith(".sctunit")) {
			return provider.getFullyQualifiedName(target).toString();
			
		}
		return super.serializeCrossRef(semanticObject, crossref, target, node,
				errors);
	}

}
