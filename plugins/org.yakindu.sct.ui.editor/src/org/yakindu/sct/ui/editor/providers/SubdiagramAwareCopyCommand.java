/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardManager;
import org.eclipse.gmf.runtime.common.ui.util.CustomData;
import org.eclipse.gmf.runtime.common.ui.util.CustomDataTransfer;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.CopyCommand;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * Copy command that also copies the corresponding sub diagram for a state, if existing.
 *
 * @author kutz
 *
 */
@SuppressWarnings({"restriction", "rawtypes"})
public class SubdiagramAwareCopyCommand extends CopyCommand implements ICommand {
	
	public SubdiagramAwareCopyCommand(TransactionalEditingDomain editingDomain, String label, View viewContext,
			List source) {
		super(editingDomain, label, viewContext, source);
	}
	
	@Override
	protected void copyToClipboard(List source) {
		/* Check if the source has elements */
		if (source == null || source.size() == 0) {
			return;
		}
		CustomData data = copyViews(source);
		addToClipboardManager(data);
	}
	
	protected void addToClipboardManager(CustomData data) {
		if (data != null) {
			ClipboardManager.getInstance().addToCache(new ICustomData[]{data}, CustomDataTransfer.getInstance());
		}
	}
	
	protected CustomData copyViews(List source) {
		String copy = copyWithSubdiagrams(source);
		return new CustomData(DRAWING_SURFACE, copy.getBytes());
	}
	
	/**
	 * This is basically a copy of
	 * {@link org.eclipse.gmf.runtime.diagram.ui.internal.commands.ClipboardCommand.copyViewsToString(List)}
	 * which is static and therefore not exchangeable. Only difference is adding of sub diagrams.
	 */
	protected String copyWithSubdiagrams(List views) {
		Assert.isNotNull(views);
		Assert.isTrue(views.size() > 0);
		
		List<EObject> selection = new ArrayList<>();
		Iterator iter = views.iterator();
		while (iter.hasNext()) {
			EObject viewElement = (View) iter.next();
			if (viewElement != null) {
				selection.add(viewElement);
			}
		}
		
		/*
		 * We must append all inner edges of a node being copied. Edges are
		 * non-containment references, hence they won't be copied for free.
		 * Therefore, we add them here to the list of views to copy.
		 */
		selection.addAll(getInnerEdges(views));
		
		// add the measurement unit in an annotation. Put it in the last
		// position
		// to work around a limitation in the copy/paste infrastructure, that
		// selects the ClipboardSupportFactory based on the first element in
		// the copy list. If the annotation is first, then we get the wrong
		// clipboard support instance
		selection.add(getMeasurementUnitAnnotation(views));
		
		// PATCH START
		// add all sub diagrams of selected states
		List<Diagram> subDiagrams = getSubDiagrams(views);
		selection.addAll(subDiagrams);
		for (Diagram diagram : subDiagrams) {
			selection.addAll(getInnerEdges(diagram.getChildren()));
		}
		// PATCH END
		
		/* Copy the selection to the string */
		return ClipboardUtil.copyElementsToString(selection, new HashMap(), new NullProgressMonitor());
	}
	
	protected EAnnotation getMeasurementUnitAnnotation(List views) {
		View firstView = (View) views.get(0);
		Diagram dgrm = firstView.getDiagram();
		EAnnotation measureUnitAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		measureUnitAnnotation.setSource(dgrm.getMeasurementUnit().getName());
		return measureUnitAnnotation;
	}
	
	protected List<Edge> getInnerEdges(List views) {
		List<Edge> innerEdges = new LinkedList<>();
		for (Iterator itr = views.iterator(); itr.hasNext();) {
			View view = (View) itr.next();
			if (!(view instanceof Diagram)) {
				innerEdges.addAll(ViewUtil.getAllInnerEdges(view));
			}
		}
		return innerEdges;
	}
	
	protected List<Diagram> getSubDiagrams(List views) {
		List<Diagram> subDiagrams = new ArrayList<>();
		Iterator iter = views.iterator();
		while (iter.hasNext()) {
			View viewElement = (View) iter.next();
			if (viewElement != null) {
				EObject semanticElement = viewElement.getElement();
				if (semanticElement instanceof State) {
					collectSubdiagramsInState(subDiagrams, (State) semanticElement);
				} else if (semanticElement instanceof Region) {
					collectSubdiagramsInRegion(subDiagrams, (Region) semanticElement);
				}
			}
		}
		return subDiagrams;
	}
	
	protected void collectSubdiagramsInRegion(List<Diagram> subDiagrams, Region region) {
		for (Vertex vertex : region.getVertices()) {
			if (vertex instanceof State) {
				collectSubdiagramsInState(subDiagrams, (State) vertex);
			}
		}
	}
	
	protected void collectSubdiagramsInState(List<Diagram> subDiagrams, State state) {
		if (state.isComposite()) {
			subDiagrams.addAll(getAllSubDiagrams(state));
		}
	}
	
	protected Collection<? extends Diagram> getAllSubDiagrams(State semanticState) {
		List<Diagram> subDiagrams = new ArrayList<>();
		addSubDiagram(semanticState, subDiagrams);
		
		TreeIterator<EObject> iter = semanticState.eAllContents();
		while (iter.hasNext()) {
			EObject next = iter.next();
			if (next instanceof State) {
				State subState = (State) next;
				if (subState.isComposite()) {
					addSubDiagram(subState, subDiagrams);
				} else {
					iter.prune();
				}
			}
		}
		return subDiagrams;
	}
	
	protected void addSubDiagram(State semanticState, List<Diagram> subDiagrams) {
		Diagram subDiagram = DiagramPartitioningUtil.getSubDiagram(semanticState);
		if (subDiagram != null) {
			subDiagrams.add(subDiagram);
		}
	}
	
}
