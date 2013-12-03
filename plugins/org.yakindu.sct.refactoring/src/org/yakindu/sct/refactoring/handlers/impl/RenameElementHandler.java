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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.refactoring.handlers.AbstractRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.RenameRefactoring;

import com.google.common.collect.Lists;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
/**
 * Handler for {@link RenameRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class RenameElementHandler extends AbstractRefactoringHandler<NamedElement> {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		NamedElement element = refactoring.getContextObject();
		if (element != null) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			InputDialog dialog = new InputDialog(window.getShell(), "Rename..", "Please enter new name:", element.getName(), new NameUniquenessValidator(element));
			if (dialog.open() == Window.OK) {
				String newName = dialog.getValue();
				if (newName != null) {					
					((RenameRefactoring)refactoring).setNewName(newName);
					refactoring.execute();
				}
			}
			
		}
		return null;
	}
	
	/**
	 * Unwraps the given selection into a state sgraph element
	 * 
	 * @param selection the current selection
	 * @return the state sgraph element for the given selection
	 */
	public NamedElement unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		EObject selectedElement = (EObject) structuredSelection.getFirstElement();
				
		// The provided element is the one from the fake resource of styled text adapter.
		// We need to find the actual element in our statechart for this fake element
		if (selectedElement instanceof FeatureCall) {
			return findElementForFakeInStatechart((NamedElement)((FeatureCall)selectedElement).getFeature());
		}
		else if (selectedElement instanceof ElementReferenceExpression) {
			return findElementForFakeInStatechart((NamedElement)((ElementReferenceExpression)selectedElement).getReference());
		}
		if (selectedElement instanceof NamedElement)
			return findElementForFakeInStatechart((NamedElement)selectedElement);
		
		return null;
	}

	
	private NamedElement findElementForFakeInStatechart(NamedElement fakeElement) {
		Resource resource = fakeElement.eResource();
		// only do something if element is really from fake resource
		if (resource instanceof LazyLinkingResource) {
			Statechart sct = getStatechartFromFakeResource((LazyLinkingResource)resource);
			
			EList<Scope> scopes = sct.getScopes();
			for (Scope scope : scopes) {
				// check all declarations
				EList<Declaration> declarations = scope.getDeclarations();
				for (Declaration decl : declarations) {
					if (decl.eClass().getName().equals(fakeElement.eClass().getName())
							&& decl.getName().equals(fakeElement.getName())) {
						return decl;
					}
				}
				// check scope itself it is a named one
				if (scope instanceof NamedElement) {
					NamedElement namedScope = (NamedElement) scope;
					if (namedScope.eClass().getName().equals(fakeElement.eClass().getName())
							&& namedScope.getName().equals(fakeElement.getName())) {
						return namedScope;
					}
				}
				
			}
		}
		return fakeElement;
	}
	
	protected Statechart getStatechartFromFakeResource(LazyLinkingResource resource) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof ContextElementAdapter) {
				EObject elem = ((ContextElementAdapter)adapter).getElement();
				if (elem instanceof Statechart) {
					return (Statechart) elem;
				}
			}
		}
		return null;
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
	public void setContext(AbstractRefactoring<NamedElement> refactoring,
			ISelection selection) {
		NamedElement element = unwrap(selection);
		refactoring.setContextObjects(Lists.newArrayList(element));
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
			return existingNames.contains(newText)? "Name already exists!": null;
		}
		
	}

}
