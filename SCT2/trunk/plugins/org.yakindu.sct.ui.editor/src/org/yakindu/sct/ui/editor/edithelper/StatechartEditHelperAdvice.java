package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.sct.model.sgraph.Statechart;

public class StatechartEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(
			CreateRelationshipRequest request) {
		if (request.getSource() instanceof Statechart) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getBeforeCreateRelationshipCommand(request);
	}
}
