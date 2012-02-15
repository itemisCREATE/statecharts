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
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SheetLabelProvider extends BaseLabelProvider implements
		ILabelProvider {

	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof IGraphicalEditPart) {
			EObject semanticElement = ((IGraphicalEditPart) element)
					.resolveSemanticElement();
			
			if(semanticElement == null)
				return null;
			
			IElementType elementType = ElementTypeRegistry.getInstance()
					.getElementType(semanticElement);
			StringBuilder builder = new StringBuilder();
			builder.append(elementType.getDisplayName());
			if (semanticElement instanceof NamedElement
					&& ((NamedElement) semanticElement).getName() != null) {
				builder.append(' ');
				builder.append(((NamedElement) semanticElement).getName());
			}
			return builder.toString();
		}
		return null;
	}

	public Image getImage(Object element) {
		element = unwrap(element);
		if (element instanceof IGraphicalEditPart) {
			EObject semanticElement = ((IGraphicalEditPart) element)
					.resolveSemanticElement();
			
			if(semanticElement == null)
				return null;
			
			IElementType elementType = ElementTypeRegistry.getInstance()
					.getElementType(semanticElement);
			Image image = DiagramActivator.getDefault().getImageRegistry()
					.get(elementType.getIconURL().toString());
			if (image == null) {
				ImageDescriptor desc = ImageDescriptor
						.createFromURL(elementType.getIconURL());
				DiagramActivator
						.getDefault()
						.getImageRegistry()
						.put(elementType.getIconURL().toString(),
								desc.createImage());
				return DiagramActivator.getDefault().getImageRegistry()
						.get(elementType.getIconURL().toString());
			}
			return image;
		}
		return null;
	}

	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

}
