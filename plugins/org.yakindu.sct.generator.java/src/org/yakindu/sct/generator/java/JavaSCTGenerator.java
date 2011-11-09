/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;

/**
 * Implementation of {@link ISCTGenerator} interface registered via extension
 * point
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class JavaSCTGenerator extends AbstractXpandBasedCodeGenerator {

	@Override
	public String getTemplatePath() {
		return "org::yakindu::sct::generator::java::templates::Main::main";
	}

}
