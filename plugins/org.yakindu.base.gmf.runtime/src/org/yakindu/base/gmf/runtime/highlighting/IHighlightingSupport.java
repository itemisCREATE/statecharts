/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.gmf.runtime.highlighting;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Alexander Nyssen
 * @author Andreas Muelder
 * 
 */
public interface IHighlightingSupport {

	void lockEditor();

	boolean isLocked();

	void releaseEditor();
	
	void releaseAndLockEditor();

	void highlight(List<? extends EObject> semanticElement, HighlightingParameters parameters);

	void flash(List<? extends EObject> semanticElemesnt, HighlightingParameters parameters);

	void executeAsync(List<Action> actions);

	public static interface Action {
		public void execute(IHighlightingSupport hs);
	}

	public static class Highlight implements Action {

		protected List<? extends EObject> semanticElements;
		protected HighlightingParameters highligtingParams;

		public Highlight(EObject semanticElement, HighlightingParameters parameters) {
			this(Collections.singletonList(semanticElement), parameters);
		}

		public Highlight(List<? extends EObject> semanticElements, HighlightingParameters parameters) {
			this.semanticElements = semanticElements;
			this.highligtingParams = parameters;
		}

		public void execute(IHighlightingSupport hs) {
			hs.highlight(semanticElements, highligtingParams);
		}
	}

	public static class Flash implements Action {

		protected List<? extends EObject> semanticElements;
		protected HighlightingParameters highligtingParams;

		public Flash(EObject semanticElement, HighlightingParameters parameters) {
			this(Collections.singletonList(semanticElement), parameters);
		}

		public Flash(List<? extends EObject> semanticElements, HighlightingParameters parameters) {
			this.semanticElements = semanticElements;
			this.highligtingParams = parameters;
		}

		public void execute(IHighlightingSupport hs) {
			hs.flash(semanticElements, highligtingParams);
		}

	}

	public static class HighlightingSupportNullImpl implements IHighlightingSupport {

		@Override
		public void lockEditor() {
		}

		@Override
		public boolean isLocked() {
			return false;
		}

		@Override
		public void releaseEditor() {
		}

		@Override
		public void releaseAndLockEditor() {
		}

		@Override
		public void executeAsync(List<Action> actions) {
		}

		@Override
		public void highlight(List<? extends EObject> semanticElement, HighlightingParameters parameters) {
		}

		@Override
		public void flash(List<? extends EObject> semanticElemesnt, HighlightingParameters parameters) {
		}
	}
}
