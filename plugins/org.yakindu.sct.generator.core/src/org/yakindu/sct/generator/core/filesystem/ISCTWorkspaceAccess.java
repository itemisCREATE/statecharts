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
package org.yakindu.sct.generator.core.filesystem;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(ISCTWorkspaceAccess.NullWorkspaceAccess.class)
public interface ISCTWorkspaceAccess {

	boolean projectExists(String value);

	boolean projectOpened(String value);

	boolean folderExists(String projectName, String folderPath);

	boolean fileExists(String projectName, String folderPath);

	void refreshProject(String projectName);

	/**
	 *
	 * @author Andreas Mülder - Initial contribution and API
	 *
	 */
	public static class NullWorkspaceAccess implements ISCTWorkspaceAccess {

		@Override
		public boolean projectExists(String value) {
			return true;
		}

		@Override
		public boolean projectOpened(String value) {
			return true;
		}

		@Override
		public boolean folderExists(String projectName, String folderPath) {
			return true;
		}

		@Override
		public boolean fileExists(String projectName, String folderPath) {
			return true;
		}

		@Override
		public void refreshProject(String projectName) {
			// Nothing to do
		}

	}
}
