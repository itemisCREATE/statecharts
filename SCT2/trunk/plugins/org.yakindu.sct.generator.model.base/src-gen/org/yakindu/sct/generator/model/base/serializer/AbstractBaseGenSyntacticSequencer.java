package org.yakindu.sct.generator.model.base.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.yakindu.sct.generator.model.base.services.BaseGenGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractBaseGenSyntacticSequencer extends AbstractSyntacticSequencer {

	protected BaseGenGrammarAccess grammarAccess;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (BaseGenGrammarAccess) access;
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		acceptNodes(transition, fromNode, toNode);
	}

}
