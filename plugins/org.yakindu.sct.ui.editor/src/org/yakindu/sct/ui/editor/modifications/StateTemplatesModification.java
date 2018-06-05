/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.modifications;

import static org.eclipse.emf.ecore.util.EcoreUtil.getObjectByType;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 *
 * @author andreas muelder - Initial contribution and API
 * @author terfloth
 *
 */
public abstract class StateTemplatesModification extends AbstractSemanticModification {

	public abstract String getTemplatePath();


	@Override
	protected boolean check(EObject semanticObject, View view) {
		return semanticObject instanceof State && view.getType() == SemanticHints.STATE;
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void execute(EObject semanticObject, View view) {
		State state = (State) semanticObject;
		Resource resource = loadTemplateResource(getTemplatePath());
		Diagram diagram = (Diagram) getObjectByType(resource.getContents(), NotationPackage.Literals.DIAGRAM);
		EList<View> children = diagram.getChildren();

		List<Node> regions = new ArrayList<>();
		for (View child : children) {
			if (child.getType().equals(SemanticHints.REGION)) {
				regions.add((Node) child);
			}
		}
		View figureCompartment = ViewUtil.getChildBySemanticHint(view, SemanticHints.STATE_FIGURE_COMPARTMENT);
		View nextRelatedRegion = getNextRelatedRegion(figureCompartment);
		while (regions.size() > 0) {
			Node child = regions.get(0);
			regions.remove(child);
			setPreferredSize(child);
			figureCompartment.insertChild(child);
			state.getRegions().add((Region) child.getElement());
			setRegionColor(child, nextRelatedRegion);
		}

		EList<Edge> edges = diagram.getEdges();
		while (edges.size() > 0) {
			view.getDiagram().insertEdge(edges.get(0));
		}

		setPreferredSize(view);
	}


	protected Resource loadTemplateResource(String templatePath) {
		ResourceSet set = new ResourceSetImpl();
		return set.getResource(URI.createPlatformPluginURI(getTemplatePath(), true), true);
	}

	protected void setPreferredSize(View view) {
		Bounds bounds = (Bounds) ((Node) view).getLayoutConstraint();
		bounds.setWidth(-1);
		bounds.setHeight(-1);
	}

	protected View getNextRelatedRegion(View view) {
		View state = getEContainerBySemanticHint(view, SemanticHints.STATE);
		View stateFigure = ViewUtil.getChildBySemanticHint(state, SemanticHints.STATE_FIGURE_COMPARTMENT);
		View region = ViewUtil.getChildBySemanticHint(stateFigure, SemanticHints.REGION);
		if (region == null) {
			region = getEContainerBySemanticHint(view, SemanticHints.REGION);
		}
		return region;
	}

	protected void setRegionColor(View region, View otherRegion) {
		if (!(region.getType().equals(SemanticHints.REGION) && otherRegion.getType().equals(SemanticHints.REGION))) {
			return;
		}
		ShapeStyle otherStyle = (ShapeStyle) otherRegion.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		ShapeStyle style = (ShapeStyle) region.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		style.setFillColor(otherStyle.getFillColor());
	}

	protected View getEContainerBySemanticHint(View view, String semanticHint) {
		View eContainer = ViewUtil.getContainerView(view);
		if(eContainer == null) {
			return null;
		}
		if(eContainer.getType().equals(semanticHint)) {
			return eContainer;
		}
		return getEContainerBySemanticHint(eContainer, semanticHint);
	}
}
