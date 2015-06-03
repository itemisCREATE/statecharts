/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view.decorator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.render.util.DiagramRenderUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationImageRenderer {
	/**
	 * Renderes an image with highlighted states
	 * 
	 * @param statechart
	 * @param context
	 * @return
	 */

	public Image renderImage(IFile file, ExecutionContext context) {
		Diagram diagram = getDiagramCopy(file);
		return renderImage(diagram, context);
	}

	public Image renderImage(Diagram diagram, ExecutionContext context) {
		highlightActiveStates(context, diagram);
		return renderImage(diagram);
	}

	public Image renderImage(Diagram diagram, List<? extends EObject> objects) {
		highlightElements(objects, diagram);
		return renderImage(diagram);
	}

	protected Image renderImage(Diagram diagram) {
		Assert.isNotNull(diagram);
		return DiagramRenderUtil.renderToSWTImage(diagram);
	}

	public void highlightActiveStates(final ExecutionContext context, final Diagram diagram) {
		highlightElements(context.getActiveStates(), diagram);
	}

	public void highlightElements(final List<? extends EObject> objects, final Diagram diagram) {
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(diagram),
				"", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				// Init colors from preferences
				RGB rgbForeGround = PreferenceConverter.getColor(SimulationActivator.getDefault().getPreferenceStore(),
						SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR);
				RGB rgbBackGround = PreferenceConverter.getColor(SimulationActivator.getDefault().getPreferenceStore(),
						SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR);
				RGB rgbTransitionActive = PreferenceConverter.getColor(SimulationActivator.getDefault()
						.getPreferenceStore(), SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR);

				Color color = new Color(Display.getDefault(), rgbForeGround);
				Integer foreGround = FigureUtilities.colorToInteger(color);
				color.dispose();
				color = new Color(Display.getDefault(), rgbBackGround);
				Integer background = FigureUtilities.colorToInteger(color);
				color.dispose();

				color = new Color(Display.getDefault(), rgbTransitionActive);
				Integer transitionActive = FigureUtilities.colorToInteger(color);
				color.dispose();

				// Set styling
				TreeIterator<EObject> eAllContents = diagram.eAllContents();
				while (eAllContents.hasNext()) {
					EObject next = eAllContents.next();
					if (next instanceof View) {
						for (EObject elementToHighlight : objects) {
							EObject element = null;
							if (next instanceof Node) {
								element = ((Node) next).getElement();
							} else if (next instanceof Edge) {
								element = ((Edge) next).getElement();
							}

							if(element == null){ //next instanceof BasicDecorationNode || next instanceof Shape
								continue;
							}
							
							if (EcoreUtil.getURI(elementToHighlight).equals(EcoreUtil.getURI(element))) {
								if (next instanceof Node) {
									ShapeStyle style = (ShapeStyle) ((Node) next)
											.getStyle(NotationPackage.Literals.SHAPE_STYLE);
									if (style != null) {
										style.setFillColor(background);
										style.setLineColor(foreGround);
									}

								} else if (next instanceof Edge) {
									ConnectorStyle style = (ConnectorStyle) ((View) next)
											.getStyle(NotationPackage.Literals.CONNECTOR_STYLE);
									if (style != null) {
										style.setLineColor(transitionActive);
									}

								}
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			cmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public Diagram getDiagramCopy(IFile file) {
		Resource resource = reload(file);
		Diagram diagram = (Diagram) resource.getContents().get(1);
		return diagram;
	}

	private Resource reload(IFile file) {
		final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		resourceSet.getResources().add(resource);
		try {
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			throw new IllegalStateException("Error loading resource", e);
		}
		return resource;
	}

	public Diagram getDiagramCopy(Diagram diagram) {
		Resource resource = reload(WorkspaceSynchronizer.getFile(diagram.eResource()));
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (EcoreUtil.getURI(diagram).equals(EcoreUtil.getURI(eObject)))
				return (Diagram) eObject;
		}
		// Fall back return the first diagram
		return (Diagram) resource.getContents().get(1);
	}
}
