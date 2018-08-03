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
package org.yakindu.sct.examples.wizard.service.git;

import java.nio.file.Path;
import java.util.List;

import org.yakindu.sct.examples.wizard.service.data.ExampleData;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExampleDataReader {

	List<ExampleData> parse(List<Path> metadata);

}
