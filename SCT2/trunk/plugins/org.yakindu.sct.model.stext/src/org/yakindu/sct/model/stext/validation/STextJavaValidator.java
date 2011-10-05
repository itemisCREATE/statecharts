package org.yakindu.sct.model.stext.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.stext.stext.BuiltinEventSpec;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TransitionReaction;

public class STextJavaValidator extends AbstractSTextJavaValidator {

	@Check(CheckType.FAST)
	public void checkTransitionReactionTrigger(TransitionReaction reaction) {

		Trigger trigger = reaction.getTrigger();
		ReactionTrigger reactionTrigger = (ReactionTrigger) trigger;
		EList<EventSpec> triggers = reactionTrigger.getTriggers();
		for (EventSpec eventSpec : triggers) {
			if (eventSpec instanceof BuiltinEventSpec) {
				error("Buildin event specs are not allowed for transitions.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
			}
		}
	}
}
