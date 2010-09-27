package org.yakindu.sct.statechart.diagram.utils;

import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.CHOICE;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.DEEPHISTORY;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.FINALSTATE;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.INITIALSTATE;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.JOIN;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.JUNCTION;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.REGION;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.SHALLOWHISTORY;
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.STATE;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.statechart.statechart.Choice;
import org.yakindu.sct.model.statechart.statechart.DeepHistoryState;
import org.yakindu.sct.model.statechart.statechart.FinalState;
import org.yakindu.sct.model.statechart.statechart.InitialState;
import org.yakindu.sct.model.statechart.statechart.Join;
import org.yakindu.sct.model.statechart.statechart.Junction;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.ShallowHistoryState;
import org.yakindu.sct.model.statechart.statechart.State;
import org.yakindu.sct.model.statechart.statechart.util.StatechartSwitch;

public class SemanticHintUtil {

	private SemanticHintUtil() {
	}

	public static String getSemanticHint(EObject semanticElement) {
		return new StatechartSwitch<String>() {
			@Override
			public String caseState(State object) {
				return STATE;
			}

			@Override
			public String caseRegion(Region object) {
				return REGION;
			}

			@Override
			public String caseJunction(Junction object) {
				return JUNCTION;
			}

			@Override
			public String caseShallowHistoryState(ShallowHistoryState object) {
				return SHALLOWHISTORY;
			}

			@Override
			public String caseDeepHistoryState(DeepHistoryState object) {
				return DEEPHISTORY;
			}

			@Override
			public String caseJoin(Join object) {
				return JOIN;
			}

			@Override
			public String caseInitialState(InitialState object) {
				return INITIALSTATE;
			}

			@Override
			public String caseFinalState(FinalState object) {
				return FINALSTATE;
			}

			@Override
			public String caseChoice(Choice object) {
				return CHOICE;
			};

		}.doSwitch(semanticElement);
	}
}
