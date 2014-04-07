/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.ui.resources.FileModificationValidator;
import org.eclipse.swt.widgets.Shell;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;

/**
 * Checks the file modification flag before updating the model.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ValidatingEMFDatabindingContext extends EMFDataBindingContext {

	private IContextElementProvider elementProvider;
	private Shell shell;

	public ValidatingEMFDatabindingContext(IContextElementProvider elementProvider, Shell shell) {
		this.elementProvider = elementProvider;
		this.shell = shell;
	}

	protected IStatus isWriteable() {
		IFile file = WorkspaceSynchronizer.getFile(elementProvider.getContextObject().eResource());
		return FileModificationValidator.getInstance().validateEdit(new IFile[] { file }, shell);

	}

	@Override
	protected UpdateValueStrategy createTargetToModelUpdateValueStrategy(IObservableValue fromValue,
			IObservableValue toValue) {
		return new EMFUpdateValueStrategy() {
			@Override
			protected IStatus doSet(IObservableValue observableValue, Object value) {
				IStatus writeableStatus = isWriteable();
				if (!writeableStatus.isOK())
					return writeableStatus;
				return super.doSet(observableValue, value);
			}
		};
	}

}
