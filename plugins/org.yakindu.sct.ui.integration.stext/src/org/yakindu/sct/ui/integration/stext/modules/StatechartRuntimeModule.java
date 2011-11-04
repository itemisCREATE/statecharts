/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.ui.integration.stext.parsers.StatechartAntlrParser;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartRuntimeModule extends STextRuntimeModule {
	@Override
	public Class<? extends IParser> bindIParser() {
		return StatechartAntlrParser.class;
	}
}
