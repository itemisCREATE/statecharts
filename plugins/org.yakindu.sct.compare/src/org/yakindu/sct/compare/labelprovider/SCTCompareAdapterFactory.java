/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.compare.labelprovider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.provider.spec.AttributeChangeItemProviderSpec;
import org.eclipse.emf.compare.provider.spec.CompareItemProviderAdapterFactorySpec;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTCompareAdapterFactory extends CompareItemProviderAdapterFactorySpec {
	@Override
	public Adapter createAttributeChangeAdapter() {
		return new AttributeChangeItemProviderSpec(this) {
			@Override
			protected String getValueText(AttributeChange attChange) {
				String result = super.getValueText(attChange);
				return removeLineFeed(result);
			}

			protected String removeLineFeed(String string) {
				return string.replaceAll("[\\t\\n\\r]", " ").replaceAll("\\s+", " ");
			}
		};
	}
}
