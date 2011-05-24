package org.yakindu.sct.statechart.diagram.actions;

import org.yakindu.model.sct.statechart.EntryKind;
/**
 * 
 * @author muelder
 *
 */
public class SetShallowHistoryEntryKindCommand extends ChangeEntryKindCommand {

	@Override
	public EntryKind getEntryKind() {
		return EntryKind.SHALLOW_HISTORY;
	}

}
