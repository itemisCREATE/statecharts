package org.yakindu.sct.statechart.diagram.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public interface FontConstants {

	static final Font DEFAULT = new Font(Display.getCurrent(), "Verdana", 8, SWT.NONE);

}
