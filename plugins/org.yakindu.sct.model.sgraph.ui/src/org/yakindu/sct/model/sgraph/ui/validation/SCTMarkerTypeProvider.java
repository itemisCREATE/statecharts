/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.ui.validation;

import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTMarkerTypeProvider extends MarkerTypeProvider  {

	
	
	@Override
	public String getMarkerType(Issue issue) {
		switch(issue.getType()) {
			case FAST: return SCTMarkerType.FAST_VALIDATION;
			case NORMAL: return SCTMarkerType.NORMAL_VALIDATION;
			case EXPENSIVE: return SCTMarkerType.EXPENSIVE_VALIDATION;
			default: return SCTMarkerType.SUPERTYPE;
		}
	}
	@Override
	public CheckType getCheckType(String markerType) {
		if (SCTMarkerType.FAST_VALIDATION.equals(markerType))
			return CheckType.FAST;
		if (SCTMarkerType.NORMAL_VALIDATION.equals(markerType))
			return CheckType.NORMAL;
		if (SCTMarkerType.EXPENSIVE_VALIDATION.equals(markerType))
			return CheckType.EXPENSIVE;
		// default
		return CheckType.FAST;
	}
}
