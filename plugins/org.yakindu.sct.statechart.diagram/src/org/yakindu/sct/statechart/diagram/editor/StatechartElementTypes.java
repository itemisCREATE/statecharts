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
package org.yakindu.sct.statechart.diagram.editor;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * Helper class with {@link IElementType}s for the semantic elements and some
 * convenience methods.
 * 
 * @author muelder
 * 
 */
public final class StatechartElementTypes extends AbstractElementTypeEnumerator {

	/** Element Types **/
	public static final IElementType STATECHART = getElementType("org.yakindu.sct.statechart.diagram.Statechart");
	public static final IElementType REGION = getElementType("org.yakindu.sct.statechart.diagram.Region");
	public static final IElementType STATE = getElementType("org.yakindu.sct.statechart.diagram.State");
	public static final IElementType TRANSITION = getElementType("org.yakindu.sct.statechart.diagram.Transition");
	public static final IElementType CHOICE = getElementType("org.yakindu.sct.statechart.diagram.Choice");
	public static final IElementType JUNCTION = getElementType("org.yakindu.sct.statechart.diagram.Junction");
	public static final IElementType ENTRY = getElementType("org.yakindu.sct.statechart.diagram.Entry");
	public static final IElementType DEEPHISTORY = getElementType("org.yakindu.sct.statechart.diagram.DeepHistory");
	public static final IElementType SHALLOWHISTORY = getElementType("org.yakindu.sct.statechart.diagram.ShallowHistory");
	public static final IElementType FINALSTATE = getElementType("org.yakindu.sct.statechart.diagram.FinalState");
	public static final IElementType EXIT = getElementType("org.yakindu.sct.statechart.diagram.Exit");

}
