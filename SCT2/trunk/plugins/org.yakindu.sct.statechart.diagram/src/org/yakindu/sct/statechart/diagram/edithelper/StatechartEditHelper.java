package org.yakindu.sct.statechart.diagram.edithelper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
/**
 * 
 * @author muelder
 *
 */
public class StatechartEditHelper extends AbstractEditHelper {

	
	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		return super.getMoveCommand(req);
	}
}
