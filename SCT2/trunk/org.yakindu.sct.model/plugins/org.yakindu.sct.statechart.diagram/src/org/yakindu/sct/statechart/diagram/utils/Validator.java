package org.yakindu.sct.statechart.diagram.utils;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;

public class Validator {


	private static Diagnostic runEMFValidator(View target) {
		if (target.isSetElement() && target.getElement() != null) {
			return new Diagnostician() {

				public String getObjectLabel(EObject eObject) {
					return EMFCoreUtil.getQualifiedName(eObject, true);
				}
			}.validate(target.getElement());
		}
		return Diagnostic.OK_INSTANCE;
	}

	public static void validate(DiagramEditPart diagramEditPart, View view) {
		IFile target = view.eResource() != null ? WorkspaceSynchronizer
				.getFile(view.eResource().getResourceSet().getResources().get(0)) : null;
		if (target != null) {
			StatechartMarkerNavigationProvider.deleteMarkers(target);
		}
		Diagnostic diagnostic = runEMFValidator(view);
		List<Diagnostic> children = diagnostic.getChildren();
		for (Diagnostic diagnostic2 : children) {
			System.out.println(diagnostic2);
		}
		createMarkers(target, diagnostic, diagramEditPart);

		IBatchValidator validator = (IBatchValidator) ModelValidationService
				.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		if (view.isSetElement() && view.getElement() != null) {
			IStatus status = validator.validate(view.getElement());

			createMarkers(target, status, diagramEditPart);
		}
	}


	private static void createMarkers(IFile target, IStatus validationStatus,
			DiagramEditPart diagramEditPart) {
		if (validationStatus.isOK()) {
			return;
		}
		//for (IStatus status : validationStatus.getChildren()) {
			System.out.println("CREATING MARKER FOR " + validationStatus.getMessage());
			IConstraintStatus nextStatus = (IConstraintStatus) validationStatus;
			IGraphicalEditPart editPart = (IGraphicalEditPart) diagramEditPart
					.findEditPart(diagramEditPart, nextStatus.getTarget());
			if (editPart == null)
				editPart = findConnectionEditPart(diagramEditPart,
						nextStatus.getTarget());

			View view = editPart.getNotationView();
			StatechartMarkerNavigationProvider.addMarker(target, view
					.eResource().getURIFragment(view), EMFCoreUtil
					.getQualifiedName(nextStatus.getTarget(), true), nextStatus
					.getMessage(), nextStatus.getSeverity());
		//}

	}

	/**
	 * @generated
	 */
	private static void createMarkers(IFile target,
			Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
		if (emfValidationStatus.getSeverity() == Diagnostic.OK) {
			return;
		}
		for (Iterator it = emfValidationStatus.getChildren().iterator(); it
				.hasNext();) {
			Diagnostic nextDiagnostic = (Diagnostic) it.next();
			List data = nextDiagnostic.getData();
			if (data != null && !data.isEmpty()
					&& data.get(0) instanceof EObject) {
				EObject element = (EObject) data.get(0);
				IGraphicalEditPart editPart = (IGraphicalEditPart) diagramEditPart
						.findEditPart(diagramEditPart, element);
				if (editPart == null)
					editPart = findConnectionEditPart(diagramEditPart, element);
				System.out.println("EDITPART IS  " + editPart);
				View view = editPart.getNotationView();
				StatechartMarkerNavigationProvider
						.addMarker(target, view.eResource()
								.getURIFragment(view), EMFCoreUtil
								.getQualifiedName(element, true),
								nextDiagnostic.getMessage(),
								diagnosticToStatusSeverity(nextDiagnostic
										.getSeverity()));
			}
		}
	}

	private static IGraphicalEditPart findConnectionEditPart(
			AbstractGraphicalEditPart epBegin, EObject theElement) {
		if (theElement == null || epBegin == null) {
			return null;
		}

		// check if gmf graphical edit part to be able to get connections
		if (epBegin instanceof GraphicalEditPart) {
			GraphicalEditPart epStart = (GraphicalEditPart) epBegin;

			// source connections
			for (Object obj : epStart.getSourceConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (IGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			// same for target connections
			for (Object obj : epStart.getTargetConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (IGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			ListIterator<?> childLI = epStart.getChildren().listIterator();
			while (childLI.hasNext()) {
				AbstractGraphicalEditPart epChild = (AbstractGraphicalEditPart) childLI
						.next();

				IGraphicalEditPart elementEP = findConnectionEditPart(epChild,
						theElement);
				if (elementEP != null) {
					return elementEP;
				}
			}
		}
		return null;
	}

	private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
		if (diagnosticSeverity == Diagnostic.OK) {
			return IStatus.OK;
		} else if (diagnosticSeverity == Diagnostic.INFO) {
			return IStatus.INFO;
		} else if (diagnosticSeverity == Diagnostic.WARNING) {
			return IStatus.WARNING;
		} else if (diagnosticSeverity == Diagnostic.ERROR
				|| diagnosticSeverity == Diagnostic.CANCEL) {
			return IStatus.ERROR;
		}
		return IStatus.INFO;
	}
}
