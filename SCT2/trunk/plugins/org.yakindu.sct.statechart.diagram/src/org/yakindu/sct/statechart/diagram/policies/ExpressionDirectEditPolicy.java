package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Variable;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.validation.GMFMarkerUtil;
import org.yakindu.sct.statechart.diagram.validation.IMarkerType;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import de.itemis.xtext.utils.jface.viewers.XtextCellEditor;

/**
 * 
 * @author muelder
 * 
 */
public class ExpressionDirectEditPolicy extends DirectEditPolicy implements
		IMarkerType {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		Assert.isTrue(request.getCellEditor() instanceof XtextCellEditor);
		XtextCellEditor cellEditor = (XtextCellEditor) request.getCellEditor();
		handleIssues(cellEditor.getIssues());
		EObject astRoot = cellEditor.getParseResult().getRootASTElement();
		List<Event> events = EcoreUtil2.getAllContentsOfType(astRoot, Event.class);
		List<Variable> vars =  EcoreUtil2.getAllContentsOfType(astRoot, Variable.class);
		EObject semanticElem = (getHost().resolveSemanticElement());
		 
		SetValueCommand eventCommand = new SetValueCommand(new SetRequest(semanticElem,
				StatechartPackage.Literals.STATECHART__EVENTS,
				events));

		SetValueCommand variableCommand = new SetValueCommand(new SetRequest(semanticElem,
				StatechartPackage.Literals.STATECHART__VARIABLES,
				vars));

		SetValueCommand command = new SetValueCommand(new SetRequest(getHost()
				.resolveSemanticElement(),
				StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				cellEditor.getValue()));
		
		CompoundCommand compoundCommand = new CompoundCommand();
		
		if (semanticElem instanceof Statechart) {
			compoundCommand.add(new ICommandProxy(eventCommand));
			compoundCommand.add(new ICommandProxy(variableCommand));
		}
		
		compoundCommand.add(new ICommandProxy(command));
		
		return compoundCommand;
	}

	private void handleIssues(List<Issue> issues) {
		deleteOldMarkers();
		createNewMarkers(issues);
	}

	private void createNewMarkers(List<Issue> diagnostics) {
		IFile target = GMFMarkerUtil.getTargetFile(getHost().getNotationView());
		for (Issue issue : diagnostics) {
			GMFMarkerUtil.createMarker(target, new Status(getSeverity(issue),
					DiagramActivator.PLUGIN_ID, issue.getMessage()),
					getHost().getNotationView().getDiagram(),
					XTEXT_MARKER_TYPE, getHost().resolveSemanticElement());
		}

	}
	
	private static int getSeverity(Issue issue) {
		switch (issue.getSeverity()) {
			case ERROR : 
				return IStatus.ERROR;
			case WARNING : 
				return IStatus.WARNING;
			case INFO : 
				return IStatus.INFO;
		}
		throw new IllegalArgumentException();
	}

	private void deleteOldMarkers() {
		final IFile target = GMFMarkerUtil.getTargetFile(getHost()
				.getNotationView());
		try {
			IMarker[] markers = target.findMarkers(XTEXT_MARKER_TYPE, true,
					IResource.DEPTH_ZERO);
			for (IMarker iMarker : markers) {
				if (iMarker.getAttribute(IMarker.LOCATION).equals(
						EMFCoreUtil.getQualifiedName(getHost()
								.resolveSemanticElement(), true))) {
					iMarker.delete();
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXtextAwareEditPart) getHost()).setLabelText(value);
	}

}
