package org.yakindu.sct.ui.editor.commands;

import org.yakindu.sct.model.sgraph.EntryKind;

public class SetInitialEntryKindCommand extends SetEntryKindCommand {

	public EntryKind getEntryKind() {
		return EntryKind.INITIAL;
	}
	
}
