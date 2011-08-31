package org.yakindu.sct.ui.editor.clipboardsupport;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;


/**
 * Implementation of the extension point for creating clipboard support
 * utilities.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ClipboardSupportFactory
	implements IClipboardSupportFactory {

	private final IClipboardSupport clipHelper =
		new NotationClipboardOperationHelper();

	/**
	 * Initializes me.
	 */
	public ClipboardSupportFactory() {
		super();
	}

	/* (non-Javadoc)
	 * Implements the interface method.
	 */
	public IClipboardSupport newClipboardSupport(EPackage ePackage) {
		return clipHelper;
	}

}
