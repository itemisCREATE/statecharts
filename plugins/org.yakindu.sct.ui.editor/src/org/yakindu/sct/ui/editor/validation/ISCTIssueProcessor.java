package org.yakindu.sct.ui.editor.validation;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(LiveValidationIssueProcessor.class)
public interface ISCTIssueProcessor {

	public void processIssues(Resource resource, List<Issue> issues, IProgressMonitor monitor);

}
