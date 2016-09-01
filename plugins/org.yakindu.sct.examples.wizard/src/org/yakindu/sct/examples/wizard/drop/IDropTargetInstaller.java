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
package org.yakindu.sct.examples.wizard.drop;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author Thomas Kutz - Initial Contribution and API
 *
 */
public interface IDropTargetInstaller {

	public static final int DROP_OPERATIONS = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK | DND.DROP_DEFAULT;
	
	void installDropTarget(final Shell shell);
}
