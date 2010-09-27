package org.yakindu.sct.statechart.diagram.propertysheets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class SheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

	@Override
	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof IGraphicalEditPart) {
			EObject semanticElement = ((IGraphicalEditPart) element).resolveSemanticElement();
			IElementType elementType = ElementTypeRegistry.getInstance().getElementType(semanticElement);
			return elementType.getDisplayName();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		element = unwrap(element);
		// TODO
		return null;
	}

	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

}
