/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c;

import org.eclipse.core.runtime.Path;

/**
 * 
 * Circumvents relative path computation by just returning the target artifact's simple name.
 * 
 * @author thomas kutz
 *
 */
public class SimpleGenArtifactConfigurations extends DefaultGenArtifactConfigurations {

	
	@Override
	public String relativeTo(String target, String fromArtifact) {
		return new Path(target).lastSegment();
	}
}
