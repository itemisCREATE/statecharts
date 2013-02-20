/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.partitioning;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.MEditingDomainElement;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.FileEditorInput;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DiagramEditorInput extends FileEditorInput implements IDiagramEditorInput, MEditingDomainElement {

	private Diagram diagram;

	public DiagramEditorInput(Diagram diagram) {
		super(WorkspaceSynchronizer.getFile(diagram.eResource()));
		this.diagram = diagram;

	}

	public Diagram getDiagram() {
		return diagram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((diagram == null) ? 0 : diagram.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiagramEditorInput other = (DiagramEditorInput) obj;
		if (diagram == null) {
			if (other.diagram != null)
				return false;
		} else if (!diagram.equals(other.diagram))
			return false;
		return true;
	}

	public TransactionalEditingDomain getEditingDomain() {
		return DiagramPartitioningUtil.getSharedDomain();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO: It is currently not possible to restore Editors with open
		// DiagramEditorInput cause they will not act on the shared editing
		// domain
		return null;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IStorage.class) {
			return WorkspaceSynchronizer.getFile(diagram.eResource());
		}
		return super.getAdapter(adapter);
	}

}
