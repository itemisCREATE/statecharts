/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation (http://www.statecharts.org)
 * 
 */
package org.yakindu.sct.ui.editor.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

/**
 * 
 * @author oliver bohl - Initial contribution and API
 * 
 */
public class DocumentationMenuAction extends Action implements IMenuCreator {

	private Menu fMenu;
	private List<Action> actions;

	public DocumentationMenuAction() {
		super("Toggle Documentation", IAction.AS_DROP_DOWN_MENU);
		setMenuCreator(this);
		setImageDescriptor(StatechartImages.MENU.imageDescriptor());
		actions = new ArrayList<Action>();
		createActions();
	}

	private void createActions() {
		Action action = new DocumentationDropDownAction("Show expressions", SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION.getName());
		actions.add(action);
		action = new DocumentationDropDownAction("Show documentation", BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION.getName());
		actions.add(action);
	}

	@Override
	public void run() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (activeEditor instanceof StatechartDiagramEditor) {
			Diagram diagram = ((StatechartDiagramEditor) activeEditor).getDiagram();
			List<View> result = EcoreUtil2.getAllContentsOfType(diagram, View.class);
			ToggleShowDocumentationCommand.toggleDocumentation(result);
		}
	}

	@Override
	public void dispose() {
		if (fMenu != null && !fMenu.isDisposed()) {
			fMenu.dispose();
		}
	}

	@Override
	public Menu getMenu(Control parent) {
		if (fMenu != null && !fMenu.isDisposed())
			fMenu.dispose();
		fMenu = new Menu(parent);
		for (IAction action : actions) {
			addActionToMenu(fMenu, action);
		}
		return fMenu;
	}

	@Override
	public Menu getMenu(Menu parent) {
		return null;
	}

	protected void addActionToMenu(Menu parent, IAction action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

}
