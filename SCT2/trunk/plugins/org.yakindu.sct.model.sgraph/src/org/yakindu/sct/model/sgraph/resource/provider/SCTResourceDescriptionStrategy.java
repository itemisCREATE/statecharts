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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * This implementation of {@link IDefaultResourceDescriptionStrategy} avoids the
 * export of elements from GMF notation model.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	public static final String IS_COMPLEX_TYPE = "IS_COMPLEX_TYPE";

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (EcoreUtil.getRootContainer(eObject) instanceof Statechart)
			return super.createEObjectDescriptions(eObject, acceptor);
		return false;
	}

}
