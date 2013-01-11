/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.commands;

import org.yakindu.sct.model.sgraph.EntryKind;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SetDeepHistoryEntryKindCommand extends SetEntryKindCommand {

	public EntryKind getEntryKind() {
		return EntryKind.DEEP_HISTORY;
	}

}
