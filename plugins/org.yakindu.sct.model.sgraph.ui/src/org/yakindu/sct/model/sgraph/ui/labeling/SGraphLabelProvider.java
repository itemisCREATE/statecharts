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
package org.yakindu.sct.model.sgraph.ui.labeling;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

public class SGraphLabelProvider extends DefaultEObjectLabelProvider {
	@Override
	protected Object doGetText(Object element) {
		if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().toString();
		}
		return super.doGetText(element);
	}
}
