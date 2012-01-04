/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

/**
 * Action that toggles the alignment flag in the notation view element
 * 
 * @author andreas muelder
 * @author terfloth
 * 
 */
public class ToggleSubRegionLayoutCommand implements IActionDelegate {

	private View view;

	public void run(IAction arg0) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(view);
		ToggleCommand toggleCommand = new ToggleCommand(editingDomain, view);
		
		try {
			OperationHistoryFactory.getOperationHistory().execute(toggleCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	protected View unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((StateEditPart) firstElement).getNotationView();
	}

	public void selectionChanged(IAction arg0, ISelection selection) {
		view = unwrap(selection);
	}

	
	/**
	 * GMF command class...
	 * 
	 * @author terfloth
	 */
	protected static class ToggleCommand extends AbstractTransactionalCommand {
		
		protected static final String TOGGLE_REGION_ALIGNMENT = "Toggle Region Alignment";

		protected View view; 
		
		public ToggleCommand(TransactionalEditingDomain editingDomain, View view) {
			super(editingDomain, TOGGLE_REGION_ALIGNMENT, null);
			this.view = view;
		}

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public List getAffectedFiles() {
	    	
	        if (view != null) {
	            List result = new ArrayList();
	            IFile file = WorkspaceSynchronizer.getFile(view.eResource());
	            
	            if (file != null) {
	                result.add(file);
	            }
	            return result;
	        }
	        
	        return super.getAffectedFiles();
	    }

		/** 
		 * Executes the command that switches the subregion layout orientation.
		 */
		@SuppressWarnings("unchecked")
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
	            IAdaptable info)
	        throws ExecutionException {
	        
			BooleanValueStyle style = (BooleanValueStyle) view
					.getStyle(NotationPackage.Literals.BOOLEAN_VALUE_STYLE);
			
			if (style == null) {
				style = NotationFactory.eINSTANCE.createBooleanValueStyle();
				style.setBooleanValue(true);
				view.getStyles().add(style);
			} else {
				style.setBooleanValue(! style.isBooleanValue());
			}
			
			return CommandResult.newOKCommandResult(view);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.common.core.command.ICommand#getLabel()
		 */
		public String getLabel() {
			return TOGGLE_REGION_ALIGNMENT;
		}
		
	}
}
