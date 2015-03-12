/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.resource.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.TypedElement;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * This implementation of {@link IDefaultResourceDescriptionStrategy} avoids the
 * export of elements from GMF notation model.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTResourceDescriptionStrategy extends
		DefaultResourceDescriptionStrategy {

	public static final String IS_COMPLEX_TYPE = "IS_COMPLEX_TYPE";

	@Override
	public boolean createEObjectDescriptions(EObject eObject,
			IAcceptor<IEObjectDescription> acceptor) {
		if (EcoreUtil.getRootContainer(eObject) instanceof Statechart)
			return createDescriptions(eObject, acceptor);
		return false;
	}

	protected boolean createDescriptions(EObject eObject,
			IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider()
					.getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = new HashMap<String, String>();
//				if (eObject instanceof TypedElement
//						&& ((TypedElement) eObject).getType() instanceof ComplexType) {
					userData.put(IS_COMPLEX_TYPE, "true");
//				}
				acceptor.accept(EObjectDescription.create(qualifiedName,
						eObject, userData));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return true;
	}

}
