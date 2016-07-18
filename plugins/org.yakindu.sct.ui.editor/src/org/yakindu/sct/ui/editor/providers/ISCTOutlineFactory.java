/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public interface ISCTOutlineFactory {
	
	/**
	 * Creates an implementation of an {@link IContentOutlinePage} which will be shown if the editor is active.
	 * 
	 * @param statechartDiagramEditor current editors instance
	 * @return an instance of an outline
	 */
	IContentOutlinePage createOutline(StatechartDiagramEditor statechartDiagramEditor);

}
