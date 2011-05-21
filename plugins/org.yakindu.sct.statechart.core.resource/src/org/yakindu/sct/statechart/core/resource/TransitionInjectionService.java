package org.yakindu.sct.statechart.core.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.sct.statechart.expressions.TransitionReaction;

import de.itemis.xtext.utils.gmf.resource.AbstractXtextMemberInjectionService;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class TransitionInjectionService extends
		AbstractXtextMemberInjectionService<Transition, TransitionReaction> {

	@Override
	public String getParserRule() {
		return TransitionReaction.class.getSimpleName();
	}

	@Override
	public void setFeatures(Transition original, TransitionReaction rootAST) {
		original.setTrigger(rootAST.getTrigger());
		original.setEffect(rootAST.getEffect());

	}

	public boolean isServiceFor(EObject object) {
		return object instanceof Transition;
	}

	public EAttribute getSourceFeature() {
		return StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION;
	}

}
