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
package org.yakindu.sct.examples.wizard.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.browser.DefaultWorkbenchBrowserSupport;
import org.yakindu.sct.examples.wizard.service.data.ExampleData;

import com.google.common.collect.Lists;

/**
 * 
 * @author robin herrmann - Initial API and contribution
 *
 */
public class ExampleModelOpener {

	private static final String SCT_FILE_EXTENSION = ".sct";

	public void openModelFiles(IProject project) {
		List<IFile> filesToOpen = Lists.newArrayList();
		addStatecharts(project, filesToOpen);

		if (filesToOpen == null || getPage() == null) {
			return;
		}
		Display.getDefault().asyncExec(() -> {
			try {
				for (IFile file : filesToOpen) {
					IDE.openEditor(getPage(), file, false);
				}

				if (online()) {
					String browserid = "org.eclipse.ui.browser.editor";
					String baseURL = "https://itemis.com/en/yakindu/state-machine/documentation/examples/example/";
					URL url = new URL((baseURL + project.getName().replace(".", "-")));
					final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser(browserid);
					browser.openURL(url);
				} else {
					openExampleReadme(project);
				}
			} catch (PartInitException | MalformedURLException e) {
				e.printStackTrace();
				return;
			}
		});
	}

	protected void openExampleReadme(IProject project) throws PartInitException {
		if (ExampleData.DESC_FILE != null) {
			IResource indexFile = project.findMember(ExampleData.DESC_FILE);
			if (indexFile != null) {
				IDE.openEditor(getPage(), (IFile) indexFile, true);
			}
		}
	}

	private boolean online() {
		try (Socket socket = new Socket()) {
			InetSocketAddress socketAddress = new InetSocketAddress("itemis.com", 80);
			socket.connect(socketAddress, 500);
			socket.close();
			return true;
		} catch (IOException unknownHost) {
			return false;
		}
	}

	protected IWorkbenchPage getPage() {
		IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
		if (workbenchWindows.length > 0) {
			IWorkbenchWindow workbenchWindow = workbenchWindows[0];
			IWorkbenchPage[] pages = workbenchWindow.getPages();
			if (pages.length > 0) {
				return pages[0];
			}
		}
		return null;
	}

	protected void addStatecharts(IProject project, List<IFile> filesToOpen) {
		try {
			filesToOpen.addAll(findAllFilesRecursively(project, SCT_FILE_EXTENSION));
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public List<IFile> findAllFilesRecursively(IContainer container, String fileEnding) throws CoreException {
		List<IFile> files = Lists.newArrayList();
		for (IResource r : container.members()) {
			if (r instanceof IContainer) {
				files.addAll(findAllFilesRecursively((IContainer) r, fileEnding));
			} else if (r instanceof IFile && r.getName().endsWith(fileEnding)) {
				files.add((IFile) r);
			}
		}
		return files;
	}

}
