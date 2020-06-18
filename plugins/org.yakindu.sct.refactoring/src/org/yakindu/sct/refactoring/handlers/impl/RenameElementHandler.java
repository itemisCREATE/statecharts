/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.handlers.impl;

import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.extensions.STextExtensions;
import org.yakindu.sct.refactoring.handlers.AbstractRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.RenameRefactoring;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Handler for {@link RenameRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class RenameElementHandler extends AbstractRefactoringHandler<NamedElement> {

	@Inject
	private IResourceValidator validator;

	@Inject
	protected STextExtensions utils;

	public RenameElementHandler() {
		Guice.createInjector().injectMembers(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		NamedElement element = refactoring.getContextObject();
		if (element != null) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

			List<Issue> issues = validator.validate(element.eResource(), CheckMode.NORMAL_AND_FAST,
					CancelIndicator.NullImpl);
			Stream<Issue> errors = issues.stream().filter(issue -> issue.getSeverity() == Severity.ERROR);

			RenameDialog dialog = new RenameDialog(window.getShell(), "Rename..", "Please enter new name: ",
					element.getName(), new NameUniquenessValidator(element), errors.count() > 0);

			if (dialog.open() == Window.OK) {
				String newName = dialog.getNewName();
				if (newName != null) {
					((RenameRefactoring) refactoring).setNewName(newName);
					refactoring.execute();
				}
			}

		}
		return null;
	}

	public NamedElement unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (!(structuredSelection.getFirstElement() instanceof EObject)) {
			return null;
		}
		EObject selectedElement = (EObject) structuredSelection.getFirstElement();

		// The provided element is the one from the fake resource of styled text
		// adapter.
		// We need to find the actual element in our statechart for this fake element.
		if (selectedElement instanceof FeatureCall) {
			return findInStatechart((NamedElement)((FeatureCall) selectedElement).getFeature());
		}
		if (selectedElement instanceof ElementReferenceExpression) {
			return findInStatechart((NamedElement) ((ElementReferenceExpression) selectedElement).getReference());
		}
		if (selectedElement instanceof NamedElement) {
			return findInStatechart((NamedElement) selectedElement);
		}

		return null;
	}

	private NamedElement findInStatechart(NamedElement fakeElement) {
		Resource resource = fakeElement.eResource();
		// only do something if element is really from fake resource
		if (resource instanceof LazyLinkingResource) {
			Statechart sct = utils.getStatechart((LazyLinkingResource) resource);
			EObject elem = utils.findElement(fakeElement, sct);
			if (elem instanceof NamedElement) {
				return (NamedElement) elem;
			}
		}
		return fakeElement;
	}

	@Override
	public boolean isEnabled() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return false;
		}
		IWorkbenchPartSite site = window.getActivePage().getActiveEditor().getSite();
		if (site == null) {
			return false;
		}
		ISelectionProvider selectionProvider = site.getSelectionProvider();
		if (selectionProvider == null) {
			return false;
		}
		ISelection currentSelection = selectionProvider.getSelection();
		setContext(refactoring, currentSelection);
		return refactoring.isExecutable();
	}

	@Override
	public AbstractRefactoring<NamedElement> createRefactoring() {
		return new RenameRefactoring();
	}

	@Override
	public void setContext(AbstractRefactoring<NamedElement> refactoring, ISelection selection) {
		NamedElement element = unwrap(selection);
		if (element != null) {
			refactoring.setContextObjects(Lists.newArrayList(element));
		}
	}

	private class NameUniquenessValidator implements IInputValidator {

		protected List<String> existingNames;

		public NameUniquenessValidator(NamedElement element) {
			existingNames = Lists.newArrayList();
			Scope scope = EcoreUtil2.getContainerOfType(element, Scope.class);
			List<? extends NamedElement> allOfSameType = EcoreUtil2.getAllContentsOfType(scope, NamedElement.class);
			allOfSameType.remove(element);
			for (NamedElement namedElement : allOfSameType) {
				existingNames.add(namedElement.getName());
			}
		}

		public String isValid(String newText) {
			return existingNames.contains(newText) ? "Name '" + newText + "' already exists." : null;
		}

	}

	protected static class RenameDialog extends Dialog {
		private boolean modelContainsErrors;
		private Label messageLabel;
		private Label iconLabel;
		private IInputValidator validator;
		private Text text;
		private String dialogTitle;
		private String dialogMessage;

		private String newName = "";

		public RenameDialog(Shell parentShell, String dialogTitle, String dialogMessage, String initialValue,
				IInputValidator validator, boolean hasDefinitionSectionErrors) {
			super(parentShell);
			this.dialogTitle = dialogTitle;
			this.dialogMessage = dialogMessage;
			this.validator = validator;
			this.modelContainsErrors = hasDefinitionSectionErrors;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			parent.getShell().setText(dialogTitle);
			GridDataFactory.fillDefaults().applyTo(parent);
			GridLayoutFactory.fillDefaults().margins(10, 4).spacing(0, 5).applyTo(parent);
			createStatusComposite(parent);
			createTextComosite(parent);
			return parent;
		}

		private void createStatusComposite(Composite parent) {
			Composite statusComposite = new Composite(parent, SWT.NONE);
			iconLabel = new Label(statusComposite, SWT.NONE);
			messageLabel = new Label(statusComposite, SWT.NONE);

			GridLayoutFactory.fillDefaults().numColumns(2).applyTo(statusComposite);
			GridDataFactory.fillDefaults().grab(true, false).hint(450, -1).applyTo(statusComposite);
			GridDataFactory.fillDefaults().grab(false, false).hint(15, 15).applyTo(iconLabel);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(messageLabel);

		}

		public void createTextComosite(Composite parent) {
			Label lblTxt = new Label(parent, SWT.WRAP);
			lblTxt.setText(dialogMessage);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(lblTxt);
			text = new Text(parent, SWT.BORDER);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
			text.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					validate();
				}
			});
			validate();
		}

		@Override
		protected void okPressed() {
			this.newName = text.getText();
			super.okPressed();
		}

		protected void validate() {
			setErrorMessage(validator.isValid(text.getText()));
		}

		public void setErrorMessage(String errorMessage) {
			messageLabel.setText("");
			iconLabel.setImage(null);
			if (errorMessage == null) {
				activateOKButton();
			} else {
				deactivateOKButton(errorMessage);
			}
			getShell().layout();
		}

		protected void deactivateOKButton(String errorMessage) {
			enableOkButton(false);
			messageLabel.setText(errorMessage);
			iconLabel.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
			messageLabel.setVisible(true);
			iconLabel.setVisible(true);
		}

		protected void activateOKButton() {
			enableOkButton(true);
			if (modelContainsErrors) {
				messageLabel.setText("The model contains errors. The refactoring may not complete successfully.");
				iconLabel.setImage(
						PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK));
				messageLabel.setVisible(true);
				iconLabel.setVisible(true);
			}
		}

		protected void enableOkButton(boolean enable) {
			Control button = getButton(IDialogConstants.OK_ID);
			if (button != null) {
				button.setEnabled(enable);
			}
		}

		public String getNewName() {
			return newName;
		}

	}

}
