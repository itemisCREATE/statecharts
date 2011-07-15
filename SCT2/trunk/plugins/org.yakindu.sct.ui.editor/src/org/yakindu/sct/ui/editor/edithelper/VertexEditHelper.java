package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.yakindu.sct.ui.editor.commands.CreateTransitionCommand;

/**
 * Base Edit Helper class for all Vertices
 * 
 * @author andreas muelder
 * 
 */
public class VertexEditHelper extends AbstractEditHelper {

	/**
	 * Returns a custom {@link CreateTransitionCommand} that sets the target
	 * transition
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		return new CreateTransitionCommand(req);
	}
}
