package org.yakindu.sct.statechart.diagram.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.model.sct.statechart.EntryKind;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes;

public class EntryEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (StatechartElementTypes.SHALLOWHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					StatechartPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.SHALLOW_HISTORY));
		} else if (StatechartElementTypes.DEEPHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					StatechartPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.DEEP_HISTORY));
		} else if (StatechartElementTypes.ENTRY
				.equals(req.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					StatechartPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.INITIAL));
		}
		return super.getConfigureCommand(req);
	}
}
