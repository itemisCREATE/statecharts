package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editor.StatechartElementTypes;

public class EntryEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (StatechartElementTypes.SHALLOWHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.SHALLOW_HISTORY));
		} else if (StatechartElementTypes.DEEPHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.DEEP_HISTORY));
		} else if (StatechartElementTypes.ENTRY
				.equals(req.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.INITIAL));
		}
		return super.getConfigureCommand(req);
	}
}
