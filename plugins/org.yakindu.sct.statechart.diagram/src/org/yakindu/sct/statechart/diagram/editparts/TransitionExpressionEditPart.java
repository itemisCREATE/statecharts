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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

import de.itemis.xtext.utils.gmf.directedit.IXTextAwareEditPart;

/**
 * 
 * @author muelder
 *
 */
public class TransitionExpressionEditPart extends PlugableXTextLabelEditPart implements
		IXTextAwareEditPart {


	public TransitionExpressionEditPart(View view) {
		super(view);
	}

	@Override
	protected int getEditorStyles() {
		return SWT.SINGLE;
	}

}
