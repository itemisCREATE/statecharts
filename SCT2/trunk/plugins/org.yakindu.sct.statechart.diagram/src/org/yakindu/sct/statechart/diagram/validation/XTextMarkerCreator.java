package org.yakindu.sct.statechart.diagram.validation;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

public class XTextMarkerCreator {
	
	public static void createMarker(Issue issue, IResource resource, String markerType,String elementId) throws CoreException {
		IMarker marker = resource.createMarker(markerType);
		String lineNR = "";
		if (issue.getLineNumber() != null) {
			lineNR = "line: " + issue.getLineNumber() + " ";
		}
		marker.setAttribute(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
		marker.setAttribute(IMarker.CHAR_START, issue.getOffset());
		if(issue.getOffset() != null && issue.getLength() != null)
			marker.setAttribute(IMarker.CHAR_END, issue.getOffset()+issue.getLength());
		marker.setAttribute(IMarker.LINE_NUMBER, issue.getLineNumber());
		marker.setAttribute(IMarker.MESSAGE, issue.getMessage());
		marker.setAttribute(IMarker.SEVERITY, getSeverity(issue));
		marker.setAttribute(Issue.CODE_KEY, issue.getCode());
//		marker.setAttribute(
//				org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
//		elementId);
		if (issue.getUriToProblem()!=null) 
			marker.setAttribute(Issue.URI_KEY, issue.getUriToProblem().toString());
		if(issue.getData() != null && issue.getData().length > 0) {
			marker.setAttribute(Issue.DATA_KEY, Strings.pack(issue.getData()));
		}
	}

	private static Object getSeverity(Issue issue) {
		switch (issue.getSeverity()) {
			case ERROR : 
				return IMarker.SEVERITY_ERROR;
			case WARNING : 
				return IMarker.SEVERITY_WARNING;
			case INFO : 
				return IMarker.SEVERITY_INFO;
		}
		throw new IllegalArgumentException();
	}
}