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

package org.yakindu.sct.test.models;

/**
 * @author rbeckmann
 *
 */
public class ExtensionTestModels extends AbstractTestModelsUtil {
	private static final String TESTMODEL_DIR = "org.yakindu.sct.test.models/testmodels/extensions/";
	
	public static final String PARALLEL_TIME_EVENTS = "ParallelTimeEvents.sct";
	public static final String NO_TIME_EVENTS = "NoTimeEvents.sct";
	@Override
	public String getModelDirectory() {
		return TESTMODEL_DIR;
	}

}
