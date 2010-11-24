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

import java.util.ListIterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.SimpleName;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionHelper;
import org.eclipselabs.mscript.language.internal.functionmodel.util.StepExpressionResult;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private DiagnosticChain diagnostics;
	private IValueFactory valueFactory;
	private boolean staticOnly;
	
	private volatile boolean canceled;
	
	private IFunctor functor;
	
	private MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "", null);
	
	/**
	 * 
	 */
	public InterpreterContext(DiagnosticChain diagnostics, IValueFactory valueFactory, boolean staticOnly) {
		this.diagnostics = diagnostics;
		this.valueFactory = valueFactory;
		this.staticOnly = staticOnly;
	}
	
	/**
	 * @return the diagnosticChain
	 */
	public DiagnosticChain getDiagnostics() {
		return diagnostics;
	}
	
	/**
	 * @return the functor
	 */
	public IFunctor getFunctor() {
		return functor;
	}
	
	/**
	 * @param functor the functor to set
	 */
	public void setFunctor(IFunctor functor) {
		this.functor = functor;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#getValueFactory()
	 */
	public IValueFactory getValueFactory() {
		return valueFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#isStaticOnly()
	 */
	public boolean isStaticOnly() {
		return staticOnly;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#getFeatureValue(org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IValue getFeatureValue(FeatureCall featureCall) {
		if (featureCall.getTarget() instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) featureCall.getTarget();
			IValue value = functor.getTemplateArgument(simpleName.getIdentifier());
			if (value != null) {
				return value;
			}
			if (functor.isInitialized()) {
				IVariable variable = functor.getVariable(simpleName.getIdentifier());
				if (variable != null) {
					ListIterator<FeatureCallPart> partIterator = featureCall.getParts().listIterator();
					StepExpressionResult stepExpressionResult = new StepExpressionHelper().getStepExpression(partIterator, diagnostics);
					if (stepExpressionResult != null) {
						return variable.getValue(stepExpressionResult.getIndex());
					}
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#addStatus(org.eclipse.core.runtime.IStatus)
	 */
	public void addStatus(IStatus status) {
		this.status.add(status);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#isCanceled()
	 */
	public boolean isCanceled() {
		return canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#setCanceled(boolean)
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
}
