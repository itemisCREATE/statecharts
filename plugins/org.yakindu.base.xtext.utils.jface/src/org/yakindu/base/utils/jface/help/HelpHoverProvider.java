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
package org.yakindu.base.utils.jface.help;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IXtextBrowserInformationControl;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Removes the first line, since the documentation already contains a header. It
 * also removes the open declaration action
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HelpHoverProvider extends DefaultEObjectHoverProvider {

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.editor.hover.XtextEditorHover.font")
	protected String fontSymbolicName = "org.eclipse.jdt.ui.javadocfont";

	protected CustomHoverControlCreator hoverControlCreator;
	protected PresenterControlCreator presenterControlCreator;

	@Inject(optional = true)
	protected IStylesheetProvider styleSheetProvider;
	
	protected String loadStyleSheet() {
		if (styleSheetProvider == null) {
			return null;
		} else {
			return styleSheetProvider.getCSS();
		}
	}

	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof Keyword)
			return true;
		return super.hasHover(o);
	}

	protected String getHoverInfoAsHtml(EObject o) {
		StringBuffer buffer = new StringBuffer();
		String documentation = getDocumentation(o);
		if (documentation != null && !documentation.isEmpty()) {
			buffer.append(documentation);
		}
		String hover = buffer.toString();
		if (hover == null || AbstractUserHelpDocumentationProvider.EMPTY_DOCUMENTATION.equals(hover))
			return null;
		return hover;
	}

	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null)
			presenterControlCreator = new CustomPresenterControlCreator();
		return presenterControlCreator;
	}

	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null)
			hoverControlCreator = new CustomHoverControlCreator(getInformationPresenterControlCreator());
		return hoverControlCreator;
	}

	public final class CustomHoverControlCreator extends AbstractReusableInformationControlCreator {

		private final IInformationControlCreator fInformationPresenterControlCreator;

		public CustomHoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				String font = "org.eclipse.jdt.ui.javadocfont";

				boolean areHoverDocsScrollable = true;

				// resizable flag of BrowserInformationControl causes the scrollbar to be always
				// enabled.
				BrowserInformationControl iControl = new BrowserInformationControl(parent, font,
						areHoverDocsScrollable) {
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}
	}

	public class CustomPresenterControlCreator extends PresenterControlCreator {

		protected void configureControl(IXtextBrowserInformationControl control, ToolBarManager tbm, String font) {
			OpenInHelpAction openHelpAction = new OpenInHelpAction();
			openHelpAction.setEnabled(true);
			tbm.add(openHelpAction);
			tbm.update(true);
		};

	}

	protected static final class OpenInHelpAction extends Action {

		public OpenInHelpAction() {
			setText("Open user guide");
			setImageDescriptor(ImageDescriptor.createFromImage(
					PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_LCL_LINKTO_HELP)));
		}

		@Override
		public void run() {
			final IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
			helpSystem.displayHelp("org.yakindu.sct.ui.editor.stext_keyword");
		};
	}
}
