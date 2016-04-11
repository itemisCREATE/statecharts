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
package com.yakindu.sct.standalone.generator;

import java.nio.charset.Charset;

import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.generator.core.impl.IGeneratorLog;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class StandaloneGeneratorModule implements Module {
	
	public static final String BASE_DIR = "filesystemAccess.absolute.baseDir";
	public static final String ENCODING = "filesystemAccess.encoding";
	
	
	private String baseDir;
	private Charset encoding;
	private Class<? extends StandaloneFileSystemAccess> fsaImpl;
	private Class<? extends IGeneratorLog> gLogImpl;
	
	
	
	public StandaloneGeneratorModule(String baseDir, Charset encoding,Class<? extends StandaloneFileSystemAccess> fsaImpl,Class<? extends IGeneratorLog> gLogImpl) {
		this.baseDir = baseDir;
		this.encoding = encoding;
		this.fsaImpl = fsaImpl;
		this.gLogImpl = gLogImpl;
	}

	@Override
	public void configure(Binder binder) {
		binder.bind(ISCTFileSystemAccess.class).to(fsaImpl);
		binder.bind(IGeneratorLog.class).to(gLogImpl);
		binder.bind(String.class).annotatedWith(Names.named(BASE_DIR)).toInstance(baseDir);
		binder.bind(Charset.class).annotatedWith(Names.named(ENCODING)).toInstance(encoding);
	}
}