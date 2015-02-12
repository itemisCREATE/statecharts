package org.yakindu.sct.domain.default_.modules;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.stext.stext.StateSpecification;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateExpressionProvider extends AbstractSTextExpressionProvider {

	@Override
	protected Class<? extends EObject> getRule() {
		return StateSpecification.class;
	}
}
