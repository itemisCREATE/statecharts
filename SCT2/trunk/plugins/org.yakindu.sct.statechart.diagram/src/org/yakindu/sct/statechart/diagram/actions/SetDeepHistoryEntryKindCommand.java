package org.yakindu.sct.statechart.diagram.actions;

import org.yakindu.model.sct.statechart.EntryKind;

/**
 * 
 * @author muelder
 * 
 */
public class SetDeepHistoryEntryKindCommand extends ChangeEntryKindCommand {

	@Override
	public EntryKind getEntryKind() {
		return EntryKind.DEEP_HISTORY;
	}

}
