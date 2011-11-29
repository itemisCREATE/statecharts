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
package org.yakindu.sct.ui.editor.editor;

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
	public static final IElementType STATECHART = getElementType("org.yakindu.sct.ui.editor.Statechart");
	public static final IElementType REGION = getElementType("org.yakindu.sct.ui.editor.Region");
	public static final IElementType STATE = getElementType("org.yakindu.sct.ui.editor.State");
	public static final IElementType COMPOSITE_STATE = getElementType("org.yakindu.sct.ui.editor.CompositeState");
	public static final IElementType ORTHOGONAL_STATE = getElementType("org.yakindu.sct.ui.editor.OrthogonalState");
	public static final IElementType SUBMACHINE_STATE = getElementType("org.yakindu.sct.ui.editor.SubmachineState");
	public static final IElementType TRANSITION = getElementType("org.yakindu.sct.ui.editor.Transition");
	public static final IElementType CHOICE = getElementType("org.yakindu.sct.ui.editor.Choice");
	public static final IElementType ENTRY = getElementType("org.yakindu.sct.ui.editor.Entry");
	public static final IElementType DEEPHISTORY = getElementType("org.yakindu.sct.ui.editor.DeepHistory");
	public static final IElementType SHALLOWHISTORY = getElementType("org.yakindu.sct.ui.editor.ShallowHistory");
	public static final IElementType FINALSTATE = getElementType("org.yakindu.sct.ui.editor.FinalState");
	public static final IElementType EXIT = getElementType("org.yakindu.sct.ui.editor.Exit");
	public static final IElementType SYNCHRONIZATION = getElementType("org.yakindu.sct.ui.editor.Synchronization");

}
