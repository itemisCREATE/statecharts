package org.yakindu.sct.generator.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.yakindu.sct.generator.base.util.GeneratorBaseUtil;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenerateCppActionDelegate implements IObjectActionDelegate {

	private ISelection selection;

	private IWorkbenchPart part;

	// TODO: Introduce valdiation plugin
	public static final String SGRAPH_ERROR_TYPE = "org.yakindu.sct.ui.editor.diagnostic";
	public static final String STEXT_ERROR_TYPE = "org.yakindu.sct.ui.editor.xtext.diagnostic";

	public void run(IAction action) {
		try {
			IFile selectedFile = unwrap();
			if (selectedFile != null && isValid(selectedFile)) {
				URI uri = URI.createPlatformResourceURI(selectedFile

				.getFullPath().toString(), true);
				String templatePath = "org::yakindu::sct::generator::cpp::templates::Main::main";
				Statechart statechart = GeneratorBaseUtil.loadStatechart(uri);
				ExecutionFlow executionFlow = GeneratorBaseUtil
						.createExecutionFlowModel(statechart);
				GeneratorBaseUtil.generate(executionFlow, templatePath,
						selectedFile.getProject(), "src-gen");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValid(IFile file) {
		try {
			IMarker[] sgraphMarkers = file.findMarkers(SGRAPH_ERROR_TYPE, true,
					IResource.DEPTH_INFINITE);
			IMarker[] stextMarkers = file.findMarkers(STEXT_ERROR_TYPE, true,
					IResource.DEPTH_INFINITE);
			if (sgraphMarkers.length > 0 || stextMarkers.length > 0) {
				MessageDialog
						.openError(
								part.getSite().getShell(),
								"Error during code generation",
								"The code generator could not be started because the selected resource contains errors");
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private IFile unwrap() {
		if (selection instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) selection)
					.getFirstElement();
			if (firstElement instanceof IFile) {
				return (IFile) firstElement;
			}
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.part = targetPart;
	}

}
