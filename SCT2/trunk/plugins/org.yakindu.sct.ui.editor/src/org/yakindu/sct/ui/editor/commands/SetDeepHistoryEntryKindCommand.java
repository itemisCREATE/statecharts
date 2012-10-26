package org.yakindu.sct.ui.editor.commands;

import org.yakindu.sct.model.sgraph.EntryKind;

public class SetDeepHistoryEntryKindCommand extends SetEntryKindCommand {

	public EntryKind getEntryKind() {
		return EntryKind.DEEP_HISTORY;
	}

}
