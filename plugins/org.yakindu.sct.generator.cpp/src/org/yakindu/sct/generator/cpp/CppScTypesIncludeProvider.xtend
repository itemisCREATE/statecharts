/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp

import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.ScTypesIncludeProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import java.util.List

/**
 * @author Robin Herrmann
 */
class CppScTypesIncludeProvider extends ScTypesIncludeProvider{
	override protected addCustomPayloadTypeIncludes(ExecutionFlow it, List<CharSequence> scIncludes, extension IGenArtifactConfigurations artifactConfigs) {
		// Nothing to do..
	}
	
}