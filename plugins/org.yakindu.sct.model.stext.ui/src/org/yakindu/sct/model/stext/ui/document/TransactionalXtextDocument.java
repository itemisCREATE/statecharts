/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.document;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.yakindu.base.xtext.utils.jface.viewers.ParallelReadXtextDocument;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@SuppressWarnings("unchecked")
public class TransactionalXtextDocument extends ParallelReadXtextDocument {

	
	public class UnitOfWorkOnTransactionalEditingDomain<T> implements IUnitOfWork<T, XtextResource> {

		private IUnitOfWork<T, XtextResource> delegate;

		public UnitOfWorkOnTransactionalEditingDomain(IUnitOfWork<T, XtextResource> delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public T exec(XtextResource state) throws Exception {
			try {
				return (T) getDomain().runExclusive(new RunnableWithResult.Impl<T>() {
					@Override
					public void run() {
						try {
							T result = delegate.exec(state);
							if (result != null) {
								setResult(result);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	public class CancelableUnitOfWorkOnTransactionalEditingDomain<T> extends CancelableUnitOfWork<T, XtextResource> {

		private CancelableUnitOfWork<T, XtextResource> delegate;

		public CancelableUnitOfWorkOnTransactionalEditingDomain(CancelableUnitOfWork<T, XtextResource> delegate) {
			this.delegate = delegate;
		}

		@Override
		public T exec(XtextResource state, CancelIndicator cancelIndicator) throws Exception {
			try {
				return (T) getDomain().runExclusive(new RunnableWithResult.Impl<T>() {
					@Override
					public void run() {
						try {
							T result = delegate.exec(state, cancelIndicator);
							if (result != null) {
								setResult(result);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Inject
	@Named("domain.id")
	protected String domainId;

	@Inject
	public TransactionalXtextDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
	}

	protected TransactionalEditingDomain getDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(domainId);
	}

	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		if (work instanceof CancelableUnitOfWork) {
			return super.readOnly(new CancelableUnitOfWorkOnTransactionalEditingDomain<T>((CancelableUnitOfWork<T, XtextResource>) work));
		}
		return super.readOnly(new UnitOfWorkOnTransactionalEditingDomain<T>(work)); 
	}

	@Override
	public <T> T priorityReadOnly(IUnitOfWork<T, XtextResource> work) {
		if (work instanceof CancelableUnitOfWork) {
			return super.priorityReadOnly(new CancelableUnitOfWorkOnTransactionalEditingDomain<T>((CancelableUnitOfWork<T, XtextResource>) work));
		}
		return super.priorityReadOnly(new UnitOfWorkOnTransactionalEditingDomain<T>(work)); 
	}

	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		if (work instanceof CancelableUnitOfWork) {
			return super.modify(new CancelableUnitOfWorkOnTransactionalEditingDomain<T>((CancelableUnitOfWork<T, XtextResource>) work));
		}
		return super.modify(new UnitOfWorkOnTransactionalEditingDomain<T>(work)); 
	}
}
