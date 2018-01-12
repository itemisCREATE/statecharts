/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets.util;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.google.common.collect.Lists;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public abstract class SelectionUnwrapperUtil {

	@SuppressWarnings("unchecked")
	public static ISelection unwrapSelectionForType(ISelection selection, Class<?> type) {
		List<Object> editParts = Lists.newArrayList();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection != null) {
				((List<EditPart>) structuredSelection.toList()).forEach(editPart -> {
					while (editPart != null && editPart.getParent().getClass().isAssignableFrom(type)
							&& type.isAssignableFrom(editPart.getParent().getClass())) {
						editPart = editPart.getParent();
					}
					editParts.add(editPart);
					if (editPart.getChildren() != null && !editPart.getChildren().isEmpty())
						editParts.addAll(editPart.getChildren());
				});
			}
		}
		return new StructuredSelection(editParts);
	}

}
