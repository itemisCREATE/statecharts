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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Alexander Nyssen
 * @author Andreas Muelder
 * 
 */
public interface IHighlightingSupport {

	/**
	 * Prevent user from editing
	 */
	void lockEditor();

	boolean isLocked();
	/**
	 * Allow user to edit model again
	 */
	void releaseEditor();

	void highlight(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Highlight a model element. Fading time may be zero to indicate that
	 * hightlighting should take place immediately.
	 * 
	 * @param modelElement
	 * @param parameterObject
	 */
	void fadeIn(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Unhighlight a model element. Fading time may be zero to indicate that
	 * hightlighting should be directly removed.
	 * 
	 * @param modelElement
	 * @param fadeOutTime
	 */
	void fadeOut(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Shortly highlight the given model element. The given fading time will be
	 * used for entering and leaving the highlighted state.
	 * 
	 * @param modelElement
	 * @param parameters
	 */
	void flash(EObject semanticElemesnt, HighlightingParameters parameters);

	/**
	 * 
	 * @param actions
	 */
	void executeBatch(List<Action> actions);
	
	
	public static interface Action {
		public void execute(IHighlightingSupport hs);
	}
	

	public static class Highlight implements Action {

		protected EObject semanticElement;
		protected HighlightingParameters highligtingParams;
		
		public Highlight(EObject semanticElement, HighlightingParameters parameters) {
			this.semanticElement = semanticElement;
			this.highligtingParams = parameters;
		}
		
		public void execute(IHighlightingSupport hs) {
			hs.highlight(semanticElement, highligtingParams);
		}
		
	}

	
	public static class HighlightingSupportNullImpl implements
			IHighlightingSupport {

		public void lockEditor() {
		}

		public void releaseEditor() {
		}

		public void fadeIn(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void fadeOut(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void flash(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void highlight(EObject semanticElement,
				HighlightingParameters parameters) {
			
		}

		public boolean isLocked() {
			return false;
		}

		public void executeBatch(List<Action> actions) {
		}
		
		
	}
}
