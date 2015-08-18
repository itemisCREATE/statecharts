package org.yakindu.base.xtext.utils.gmf.directedit;

import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

/**
 * Base class for XTextDirectEdit.
 * 
 * @author andreas muelder 
 * 
 */
public abstract class XtextDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected void showCurrentEditValue(final DirectEditRequest request) {
		final String value = (String) request.getCellEditor().getValue();
		((IXtextAwareEditPart) getHost()).setLabelText(value);
	}

}
