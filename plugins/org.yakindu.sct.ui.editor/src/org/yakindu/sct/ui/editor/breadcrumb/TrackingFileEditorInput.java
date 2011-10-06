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
