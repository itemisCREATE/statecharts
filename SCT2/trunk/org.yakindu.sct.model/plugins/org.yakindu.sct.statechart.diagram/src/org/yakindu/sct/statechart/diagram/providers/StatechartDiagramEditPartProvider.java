/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.providers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;
import org.yakindu.sct.statechart.diagram.editparts.StatechartDiagramEditPart;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartDiagramEditPartProvider extends AbstractEditPartProvider {

	public final Map<String, Class<? extends IGraphicalEditPart>> editParts;

	private static final String EDITPART_PACKAGE = "org.yakindu.sct.statechart.diagram.editparts.";

	public StatechartDiagramEditPartProvider() {
		editParts = new HashMap<String, Class<? extends IGraphicalEditPart>>();
		init();
	}

	@SuppressWarnings("unchecked")
	private void init() {
		editParts.put(StatechartDiagramEditor.ID, StatechartDiagramEditPart.class);
		Field[] elements = ProviderConstants.class.getFields();
		for (Field field : elements) {
			String elementName = null;
			try {
				elementName = (String) field.get(null);
				editParts.put(elementName,
						(Class<IGraphicalEditPart>) Class.forName(EDITPART_PACKAGE + elementName + "EditPart"));
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProviderException("EditPart for ProviderConstant " + elementName + " not found");
			}
		}
	}

	private Class<? extends IGraphicalEditPart> getClass(String semanticHint) {
		Class<? extends IGraphicalEditPart> editPart = editParts.get(semanticHint);
		if (editPart == null) {
			System.err.println("No EditPart found for semanticHint " + semanticHint);
			throw new ProviderException("No EditPart found for semanticHint " + semanticHint);
		}
		return editPart;
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getNodeEditPartClass(View view) {
		return getClass(view.getType());
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getDiagramEditPartClass(View view) {
		return getClass(view.getType());
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getEdgeEditPartClass(View view) {
		return getClass(view.getType());
	}

}
