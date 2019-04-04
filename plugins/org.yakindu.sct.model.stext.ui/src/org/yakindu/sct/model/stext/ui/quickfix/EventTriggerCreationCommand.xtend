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

import java.util.Collections
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.gmf.runtime.common.core.command.CommandResult
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.types.Direction
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.StextFactory

class EventTriggerCreationCommand extends AbstractTransactionalCommand {

	protected extension StextFactory factory = StextFactory.eINSTANCE
	protected extension TypesFactory typesFactory = TypesFactory.eINSTANCE

	protected EObject contextElement;
	protected Issue issue;
	Direction desiredDirection

	new(EObject element, Issue issue, Direction desiredDirection) {
		super(TransactionUtil.getEditingDomain(element), "Create missing event", Collections.emptyList);
		this.contextElement = element;
		this.issue = issue;
		this.desiredDirection = Direction.IN
		this.desiredDirection = desiredDirection;
	}

	def testExec() {
		return this.doExecuteWithResult(null, null);
	}

	override protected doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		try {
			val createdEvent = createEventDefinition() => [
				direction = desiredDirection
				annotationInfo = createAnnotatableElement;
			]
			val sc = EcoreUtil.getRootContainer(contextElement) as Statechart

			val eventName = this.issue.data.get(1);

			val parts = eventName.split("\\.");
			if (parts.size > 1) {
				val ifaceName = parts.get(0)
				val eName = parts.get(1)
				sc.getOrCreateInterface(ifaceName) => [
					members += createdEvent => [name = eName]
				]
			} else {
				val eName = parts.head
				sc.getOrCreateInterface(null) => [
					members += createdEvent => [name = eName]
				]
			}
			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			e.printStackTrace
			return CommandResult.newErrorCommandResult(e);
		}
	}

	protected def InterfaceScope getOrCreateInterface(Statechart sc, String name) {
		var iface = sc.scopes.filter(InterfaceScope).findFirst[it.name == name]
		if (iface === null) {
			iface = createInterfaceScope => [it.name = name]
			sc.scopes += iface
		}
		iface
	}
}
