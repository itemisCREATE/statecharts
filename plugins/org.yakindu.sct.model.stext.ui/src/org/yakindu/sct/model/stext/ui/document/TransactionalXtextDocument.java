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
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.yakindu.base.xtext.utils.jface.viewers.ParallelReadXtextDocument;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@SuppressWarnings("unchecked")
public class TransactionalXtextDocument extends ParallelReadXtextDocument {

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
		try {
			return (T) getDomain().runExclusive(new RunnableWithResult.Impl<T>() {
				@Override
				public void run() {
					setResult(TransactionalXtextDocument.super.readOnly(work));
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> T priorityReadOnly(IUnitOfWork<T, XtextResource> work) {
		try {
			return (T) getDomain().runExclusive(new RunnableWithResult.Impl<T>() {
				@Override
				public void run() {
					setResult(TransactionalXtextDocument.super.priorityReadOnly(work));
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		try {
			return (T) getDomain().runExclusive(new RunnableWithResult.Impl<T>() {
				@Override
				public void run() {
					setResult(TransactionalXtextDocument.super.modify(work));
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
