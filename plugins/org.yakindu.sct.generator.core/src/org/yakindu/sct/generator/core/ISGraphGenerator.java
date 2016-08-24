/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.core;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * Basic interface for all CodeGenerators that are build for {@link Statechart}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphGenerator extends ISCTGenerator {

	void generate(Statechart statechart, GeneratorEntry entry, IFileSystemAccess fsa);

}
