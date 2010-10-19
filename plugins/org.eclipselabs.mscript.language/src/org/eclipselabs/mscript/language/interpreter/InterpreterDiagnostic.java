/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterDiagnostic implements Diagnostic {

	private IStatus status;
	
	/**
	 * 
	 */
	public InterpreterDiagnostic(IStatus status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getSeverity()
	 */
	public int getSeverity() {
		return status.getSeverity();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getMessage()
	 */
	public String getMessage() {
		return status.getMessage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 */
	public String getSource() {
		return status.getPlugin();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 */
	public int getCode() {
		return status.getCode();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getException()
	 */
	public Throwable getException() {
		return status.getException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getData()
	 */
	public List<?> getData() {
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.Diagnostic#getChildren()
	 */
	public List<Diagnostic> getChildren() {
		List<Diagnostic> children = new ArrayList<Diagnostic>();
		for (IStatus child : status.getChildren()) {
			if (child instanceof InterpreterStatus) {
				InterpreterStatus interpreterStatus = (InterpreterStatus) child;
				int size = 1;
				if (interpreterStatus.getFeatureId() != null) {
					++size;
				}
				Object[] data = new Object[size];
				data[0] = interpreterStatus.getSource();
				if (interpreterStatus.getFeatureId() != null) {
					data[1] = interpreterStatus.getFeatureId();
				}
				children.add(new BasicDiagnostic(
						child.getSeverity(),
						child.getPlugin(),
						child.getCode(),
						child.getMessage(),
						data));
			} else {
				children.add(BasicDiagnostic.toDiagnostic(child));
			}
		}
		return children;
	}

}
