/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.intro;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Version;
import org.osgi.service.prefs.BackingStoreException;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ReleaseNotes implements IStartup {

	protected static final String RELEASE_NOTES = "https://www.itemis.com/en/yakindu/state-machine/documentation/user-guide/release_notes_{0}?source=product";

	public void earlyStartup() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
				if (window != null) {
					String currentVersion = getCurrentVersion();
					String lastVersion = getLastVersion();
					if (lastVersion.isEmpty()) {
						setLastVersion(currentVersion);
						return;
					}
					if (!currentVersion.equals(lastVersion)) {
						setLastVersion(currentVersion);
						openReleaseNotes(currentVersion);
					}
				}
			}
		});
	}

	protected String getLastVersion() {
		IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(ReleaseNotes.class.getName());
		return node.get(Version.class.getSimpleName(), "");
	}

	protected void setLastVersion(String version) {
		IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(ReleaseNotes.class.getName());
		node.put(Version.class.getSimpleName(), version);
		try {
			node.flush();
			return;
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	protected void openReleaseNotes(String installationVersion) {
		try {
			URL url = new URL(MessageFormat.format(RELEASE_NOTES, installationVersion));
			PlatformUI.getWorkbench().getBrowserSupport().createBrowser("org.yakindu.sct").openURL(url);
		} catch (PartInitException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	protected String getCurrentVersion() {
		Version currentVersion = Activator.getDefault().getBundle().getVersion();
		return "" + currentVersion.getMajor() + "." + currentVersion.getMinor() + "." + currentVersion.getMicro();
	}
}
