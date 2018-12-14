/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.ui.labeling

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Inject

/** 
 * Provides labels for a EObjects.
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
class STextLabelProvider extends DefaultEObjectLabelProvider {
	@Inject new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	// Labels and icons can be computed like this:
	def package String text(Statechart ele) {
		return ele.getName()
	}

	def package String text(IEObjectDescription ele) {
		return ele.getName().toString()
	}
	/*
	 * String image(MyModel ele) { return "MyModel.gif"; }
	 */

}
