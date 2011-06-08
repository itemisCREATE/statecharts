package de.itemis.gmf.runtime.commons.highlighting;

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

	/**
	 * Allow user to edit model again
	 */
	void releaseEditor();

	/**
	 * Highlight a model element. Fading time may be zero to indicate that
	 * hightlighting should take place immediately.
	 * 
	 * @param modelElement
	 * @param parameterObject
	 *            TODO
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
	void flash(EObject semanticElement, HighlightingParameters parameters);
}
