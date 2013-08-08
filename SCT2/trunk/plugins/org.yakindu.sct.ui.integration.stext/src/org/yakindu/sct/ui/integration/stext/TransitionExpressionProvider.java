package org.yakindu.sct.ui.integration.stext;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionProvider extends AbstractSTextExpressionProvider {

	@Override
	protected Class<? extends EObject> getRule() {
		return TransitionSpecification.class;
	}
}