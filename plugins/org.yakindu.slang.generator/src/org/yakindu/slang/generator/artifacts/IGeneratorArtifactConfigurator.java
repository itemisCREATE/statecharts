/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.slang.generator.artifacts;

import java.util.Collection;

import org.yakindu.base.types.Package;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

/**
 * This class transforms a {@link org.yakindu.base.types.Package} into a
 * {@link GeneratorArtifactConfiguration}.
 *
 */
public interface IGeneratorArtifactConfigurator {
	public GeneratorArtifactConfiguration configure(Collection<Package> packages,
			ISCTFileSystemAccess fileSystemAccess);
}
