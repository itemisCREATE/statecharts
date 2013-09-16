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
package org.yakindu.sct.ui.editor.utils;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.util.SGraphSwitch;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder
 * 
 */
public final class SemanticHintUtil implements SemanticHints {

	private SemanticHintUtil() {
	}

	/**
	 * Returns the semantic hint for a given semantic Element
	 * 
	 * @param semanticElement
	 * @return
	 */
	public static String getSemanticHint(EObject semanticElement) {
		return new SGraphSwitch<String>() {

			@Override
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
			public String caseEntry(Entry object) {
				return ENTRY;
			}

			@Override
			public String caseFinalState(FinalState object) {
				return FINALSTATE;
			}

			public String caseExit(Exit object) {
				return EXIT;
			};

			@Override
			public String caseChoice(Choice object) {
				return CHOICE;
			};

			public String caseSynchronization(Synchronization object) {
				return SYNCHRONIZATION;
			};

			public String defaultCase(EObject object) {
				throw new IllegalStateException(
						"No Semantic Hint found for object " + object);
			};
		}.doSwitch(semanticElement);
	}
}
