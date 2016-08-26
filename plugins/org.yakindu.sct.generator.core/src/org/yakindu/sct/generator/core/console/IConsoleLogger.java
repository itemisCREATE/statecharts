/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.core.console;

import org.yakindu.sct.generator.core.console.IConsoleLogger.DefaultConsoleLogger;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultConsoleLogger.class)
public interface IConsoleLogger {

	void logError(Throwable t);

	void log(String line);

	void close();

	public class DefaultConsoleLogger implements IConsoleLogger {

		@Override
		public void logError(Throwable t) {
			System.err.println(t);
		}

		@Override
		public void log(String line) {
			System.out.println(line);
		}

		@Override
		public void close() {
			// Nothing to do
		}

	}

}