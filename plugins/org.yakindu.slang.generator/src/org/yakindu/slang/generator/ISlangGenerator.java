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
package org.yakindu.slang.generator;

import java.util.Collection;

import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

public interface ISlangGenerator {
	public void generate(Collection<org.yakindu.base.types.Package> packages, ISCTFileSystemAccess fileSystemAccess);
}
