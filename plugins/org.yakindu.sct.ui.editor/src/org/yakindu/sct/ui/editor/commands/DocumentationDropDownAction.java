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

import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
/**
 * 
 * @author oliver bohl - Initial contribution and API
 * 
 */
public class DocumentationDropDownAction extends Action{
	
	private String typeLiteral;
	
	public  DocumentationDropDownAction(String text, String typeLiteral){
		setImageDescriptor(StatechartImages.MENU.imageDescriptor());
		setText(text);
		this.typeLiteral = typeLiteral;
	}
	
	public void run() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (activeEditor instanceof StatechartDiagramEditor) {
			Diagram diagram = ((StatechartDiagramEditor) activeEditor).getDiagram();
			List<View> result = EcoreUtil2.getAllContentsOfType(diagram, View.class);
			show(result);
		}
	}
	
	private void show(List<View> views){
		CompositeCommand command = new CompositeCommand("toggle documentation");
		for (View view : views) {
			StringValueStyle style = GMFNotationUtil.getStringValueStyle(view, ToggleShowDocumentationCommand.FEATURE_TO_SHOW);
			if (style == null) {
				style = ToggleShowDocumentationCommand.createInitialStyle(view);
			}
			command.add(new SetValueCommand(new SetRequest(style,
					NotationPackage.Literals.STRING_VALUE_STYLE__STRING_VALUE, typeLiteral)));
		}
		ToggleShowDocumentationCommand.executeCommand(command);
	}
}
