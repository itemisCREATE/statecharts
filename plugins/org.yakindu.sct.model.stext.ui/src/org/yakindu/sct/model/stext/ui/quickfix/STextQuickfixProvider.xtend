/** 
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.model.stext.ui.quickfix

import com.google.inject.Inject
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.operations.IOperationHistory
import org.eclipse.core.commands.operations.IUndoableOperation
import org.eclipse.core.commands.operations.OperationHistoryFactory
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider
import org.yakindu.base.types.Direction
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource
import org.yakindu.sct.model.stext.extensions.STextExtensions
import org.yakindu.sct.model.stext.validation.STextValidationMessages

class STextQuickfixProvider extends ExpressionsQuickfixProvider {

	@Inject
	protected STextExtensions extensions

	def validateIssueData(Issue issue) {
		if (issue.data.length < 2) {
			throw new IllegalArgumentException(
				"issue.data is expected to have two entries: (1) an URI to the statechart resource and (2) the name of the unresolved reference."
			)
		}
	}

	def executeCommand(IUndoableOperation command, Resource resource) {
		val IOperationHistory history = OperationHistoryFactory.getOperationHistory();

		if (resource instanceof AbstractSCTResource) {
			var AbstractSCTResource res = resource;
			try {
				// --> for specification regeneration (default is false)
				res.setSerializerEnabled(true);
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				res.setSerializerEnabled(false);
			}
		} else {
			throw new Exception();
		}
	}

	@Fix(STextValidationMessages.TRIGGER_IS_NO_EVENT)
	def createInEvent(Issue issue, IssueResolutionAcceptor acceptor) {
		validateIssueData(issue);
		acceptor.accept(
			issue,
			"create missing in-event",
			"create missing in-event",
			null,
			new UriToContextElementModificationWrapper(issue, [ EObject element, IModificationContext context |
				val AbstractTransactionalCommand command = new EventTriggerCreationCommand(element, issue,
					Direction.IN);
				executeCommand(command, element.eResource)
			])
		)
	}

	@Fix(STextValidationMessages.ERROR_CODE_EXPRESSION_IS_NO_EVENT)
	def createOutEvent(Issue issue, IssueResolutionAcceptor acceptor) {
		validateIssueData(issue);
		acceptor.accept(
			issue,
			"create missing out-event",
			"create missing out-event",
			null,
			new UriToContextElementModificationWrapper(issue, [ EObject element, IModificationContext context |
				val AbstractTransactionalCommand command = new EventTriggerCreationCommand(element, issue,
					Direction.OUT);
				executeCommand(command, element.eResource)
			])
		)
	}

}
