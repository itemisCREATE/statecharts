/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.builder;

import org.yakindu.sct.generator.builder.console.EclipseConsoleLogger;
import org.yakindu.sct.generator.builder.efs.EFSResourceFileSystemAccess;
import org.yakindu.sct.generator.core.console.IConsoleLogger;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 */
public class EclipseContextModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IConsoleLogger.class).to(EclipseConsoleLogger.class);
		binder.bind(ISCTFileSystemAccess.class).to(EFSResourceFileSystemAccess.class);

	}
}
