/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.utils.jface.help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import org.yakindu.base.xtext.utils.jface.JFaceUtilsActivator;

/**
 * 
 * @author tobias angele - Initial contribution and API
 * 
 */
public class DefaultStylesheetProvider implements IStylesheetProvider {

	private String styleSheetFileName = "HoverStyleSheet.css";

	protected URL getPath() {
		return JFaceUtilsActivator.getInstance().getBundle().getEntry(styleSheetFileName);
	}

	@Override
	public String getCSS() {
		URL styleSheetURL = getPath();

		if (styleSheetURL != null) {
			try {
				InputStreamReader inputStreamReader = new InputStreamReader(styleSheetURL.openStream());
				BufferedReader reader = new BufferedReader(inputStreamReader);
				String ret = reader.lines().collect(Collectors.joining("\n"));
				reader.close();
				inputStreamReader.close();
				return ret;
			} catch (IOException e) {
				return null;
			}
		}
		return null;
	}

}
