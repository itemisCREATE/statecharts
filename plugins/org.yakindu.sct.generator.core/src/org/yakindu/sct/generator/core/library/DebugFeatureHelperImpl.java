/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.library;

import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.DEBUG_FEATURE;
import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.DEBUG_FEATURE_DUMP_SEXEC;

import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class DebugFeatureHelperImpl implements IDebugFeatureHelper {
	
	@Override
	public boolean isDumpSexec(GeneratorEntry entry) {
		FeatureParameterValue dumpSexec = entry.getFeatureParameterValue(DEBUG_FEATURE, DEBUG_FEATURE_DUMP_SEXEC);
		if (dumpSexec == null) {
			return false;
		}
		return dumpSexec.getBooleanValue();
	}
}
