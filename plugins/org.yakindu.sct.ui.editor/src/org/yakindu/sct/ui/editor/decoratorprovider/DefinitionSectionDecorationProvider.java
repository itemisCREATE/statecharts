/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.decoratorprovider;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.yakindu.base.gmf.runtime.decorators.AbstractDecoratorProvider;
import org.yakindu.base.gmf.runtime.decorators.InteractiveDecorator;
import org.yakindu.base.xtext.utils.jface.viewers.util.ActiveEditorTracker;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author robert rudi - Initial contribution and API
 * 
 */
public class DefinitionSectionDecorationProvider extends AbstractDecoratorProvider implements IDecoratorProvider {

	protected static final String DECORATOR_KEY = DefinitionSectionDecorator.class.getSimpleName();

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Object adapter = decoratorTarget.getAdapter(EObject.class);
		if (adapter instanceof SpecificationElement)
			decoratorTarget.installDecorator(DECORATOR_KEY, new DefinitionSectionDecorator(decoratorTarget));
	}

	public static class DefinitionSectionDecorator extends InteractiveDecorator {

		private static final Insets HIGHLIGHTING_BORDER_INSETS = new Insets(1, 1, 1, 1);
		private static final String TOOLTIP_TEXT = "Pin statechart definition section";
		protected static final IPreferenceStore preferenceStore = DiagramActivator.getDefault().getPreferenceStore();

		public DefinitionSectionDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		@Override
		protected Direction getDecoratorPosition() {
			return IDecoratorTarget.Direction.NORTH_WEST;
		}

		@Override
		protected Image getDecorationImage(EObject element) {
			return StatechartImages.PIN.image();
		}

		@Override
		protected boolean shouldDecorate(EObject element) {
			if (preferenceStore.getBoolean(StatechartPreferenceConstants.PREF_DEFINITION_SECTION)) {
				if (getDecoratorTarget().getAdapter(IPrimaryEditPart.class) instanceof StatechartTextEditPart) {
					StatechartTextEditPart adapter = (StatechartTextEditPart) getDecoratorTarget()
							.getAdapter(IPrimaryEditPart.class);
					BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(adapter.getNotationView(),
							DiagramPartitioningUtil.INLINE_DEFINITION_SECTION_STYLE);
					return style == null ? true : style.isBooleanValue();
				}
			}
			return false;
		}

		@Override
		protected Decoration createDecoration(EObject semanticElement) {
			Decoration decoration = super.createDecoration(semanticElement);
			installIconHighlighting(decoration, semanticElement);
			return decoration;
		}

		protected void installIconHighlighting(Decoration decoration, final EObject semanticElement) {
			decoration.getBounds().expand(HIGHLIGHTING_BORDER_INSETS);
			decoration.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(org.eclipse.draw2d.MouseEvent me) {
				}

				@Override
				public void mouseEntered(org.eclipse.draw2d.MouseEvent me) {
					decoration.setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_HAND));
					decoration.setBorder(new LineBorder(ColorConstants.lightGray));
				}

				@Override
				public void mouseExited(org.eclipse.draw2d.MouseEvent me) {
					decoration.setBorder(new MarginBorder(HIGHLIGHTING_BORDER_INSETS));
				}

				@Override
				public void mouseHover(org.eclipse.draw2d.MouseEvent me) {
				}

				@Override
				public void mouseMoved(org.eclipse.draw2d.MouseEvent me) {
				}
			});
		}

		@Override
		protected void mousePressed(Decoration decoration, EObject element) {
			if (getDecoratorTarget().getAdapter(IPrimaryEditPart.class) instanceof StatechartTextEditPart) {
				StatechartTextEditPart editPart = (StatechartTextEditPart) getDecoratorTarget()
						.getAdapter(IPrimaryEditPart.class);
				Diagram diagramReference = getDiagramReference(editPart);
				BooleanValueStyle inlineStyle = GMFNotationUtil.getBooleanValueStyle(diagramReference,
						DiagramPartitioningUtil.INLINE_DEFINITION_SECTION_STYLE);
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(diagramReference);
				if (inlineStyle == null) {
					inlineStyle = DiagramPartitioningUtil.createInlineDefinitionSectionStyle();
					inlineStyle.setBooleanValue(true);
					// add boolean value view style if no one exists
					AddCommand command = addBooleanValueStyle(editPart, inlineStyle, domain);
					domain.getCommandStack().execute(command);
				}
				// set the new value for the boolean value style
				SetCommand command = setBooleanValueStyle(inlineStyle, domain);
				domain.getCommandStack().execute(command);
				editPart.refresh();
				updateActiveEditor();
			}
		}

		protected Diagram getDiagramReference(EditPart editPart) {
			return ((View) editPart.getRoot().getContents().getModel()).getDiagram();
		}

		protected void updateActiveEditor() {
			IEditorPart lastActiveEditor = ActiveEditorTracker.getLastActiveEditor();
			if (lastActiveEditor instanceof StatechartDiagramEditor) {
				((StatechartDiagramEditor) lastActiveEditor).toggleDefinitionSection();
			}
		}

		protected SetCommand setBooleanValueStyle(BooleanValueStyle inlineStyle, TransactionalEditingDomain domain) {
			SetCommand command = new SetCommand(domain, inlineStyle,
					NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE, !inlineStyle.isBooleanValue());
			return command;
		}

		protected AddCommand addBooleanValueStyle(EditPart editPart, BooleanValueStyle inlineStyle,
				TransactionalEditingDomain domain) {
			AddCommand command = new AddCommand(domain, getDiagramReference(editPart),
					NotationPackage.Literals.VIEW__STYLES, inlineStyle);
			return command;
		}

		@Override
		protected IFigure getToolTipFigure(EObject element) {
			return new Label(TOOLTIP_TEXT);
		}

	}

}
