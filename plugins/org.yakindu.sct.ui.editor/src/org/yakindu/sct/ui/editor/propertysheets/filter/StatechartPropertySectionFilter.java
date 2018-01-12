/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets.filter;

import org.eclipse.jface.viewers.IFilter;
import org.yakindu.sct.ui.editor.editparts.StatechartDiagramEditPart;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public class StatechartPropertySectionFilter implements IFilter {
	
	@Override
	public boolean select(Object selection) {
		if (selection instanceof StatechartDiagramEditPart)
			return true;
		return false;
	}
}
