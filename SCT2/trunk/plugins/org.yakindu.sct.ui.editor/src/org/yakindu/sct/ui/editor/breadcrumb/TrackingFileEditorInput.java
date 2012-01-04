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
package org.yakindu.sct.ui.editor.breadcrumb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.part.FileEditorInput;

public class TrackingFileEditorInput extends FileEditorInput {

	private List<IFile> history;

	public TrackingFileEditorInput(IFile file) {
		super(file);
		history = new ArrayList<IFile>();
	}

	public List<IFile> getHistory() {
		return history;
	}

	public void setHistory(List<IFile> history) {
		this.history = history;
	}
	

}
