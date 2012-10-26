package org.yakindu.sct.ui.editor.commands;

import org.yakindu.sct.model.sgraph.EntryKind;

public class SetShallowHistoryEntryKindCommand extends SetEntryKindCommand {

	@Override
	public EntryKind getEntryKind() {
		return EntryKind.SHALLOW_HISTORY;
	}

}
