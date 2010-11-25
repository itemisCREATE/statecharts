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
import static org.yakindu.sct.statechart.diagram.providers.ProviderConstants.TRANSITION;

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
import org.yakindu.sct.model.statechart.statechart.Transition;
import org.yakindu.sct.model.statechart.statechart.util.StatechartSwitch;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public final class SemanticHintUtil {

	private SemanticHintUtil() {
	}

	/**
	 * Returns the semantic hint for a given semantic Element
	 * 
	 * @param semanticElement
	 * @return
	 */
	public static String getSemanticHint(EObject semanticElement) {
		return new StatechartSwitch<String>() {

			
			public String caseTransition(Transition object) {
				return TRANSITION;
			}

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
