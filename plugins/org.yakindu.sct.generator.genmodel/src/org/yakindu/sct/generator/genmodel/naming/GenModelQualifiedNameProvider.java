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

package org.yakindu.sct.generator.genmodel.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.yakindu.sct.model.sgraph.Statechart;
/**
 * 
 * @author jetzen
 *	
 */
public class GenModelQualifiedNameProvider extends SimpleNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof Statechart) {
			Statechart statechart = (Statechart) obj;
			if (statechart.getNamespace() != null) {
				return QualifiedName.create(statechart.getNamespace(),
						statechart.getName());
			}
		}
		return super.getFullyQualifiedName(obj);
	}

}
