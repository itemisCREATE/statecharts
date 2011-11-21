package org.yakindu.sct.model.sgraph.ui.labeling;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

public class SGraphLabelProvider extends DefaultEObjectLabelProvider {
	@Override
	protected Object doGetText(Object element) {
		if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().toString();
		}
		return super.doGetText(element);
	}
}
