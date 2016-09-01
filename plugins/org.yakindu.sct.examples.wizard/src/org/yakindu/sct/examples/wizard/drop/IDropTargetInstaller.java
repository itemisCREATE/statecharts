package org.yakindu.sct.examples.wizard.drop;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Shell;

public interface IDropTargetInstaller {

	public static final int DROP_OPERATIONS = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK | DND.DROP_DEFAULT;
	
	void installDropTarget(final Shell shell);
}
