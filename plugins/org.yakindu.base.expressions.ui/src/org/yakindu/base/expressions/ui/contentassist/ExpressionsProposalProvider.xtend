/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.ui.contentassist

import org.eclipse.emf.common.util.URI
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.resource.ImageRegistry
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString.Styler
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.TextStyle
import org.eclipse.swt.widgets.Display
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport
import org.yakindu.base.expressions.ui.internal.ExpressionsActivator

class ExpressionsProposalProvider extends AbstractExpressionsProposalProvider {

	static class StrikeThroughStyler extends Styler {
		override void applyStyles(TextStyle textStyle) {
			textStyle.strikeout = true
		}
	}

	static class GreyoutStyler extends Styler {
		override void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_GRAY)
		}
	}

	def protected StyledString computePackageStyledString(PackageImport pkgImport) {
		var StyledString firstPart = new StyledString(pkgImport.getName())
		var StyledString secondPart = getPackageImportStyleString(pkgImport.getUri())
		return firstPart.append(secondPart)
	}

	def protected StyledString getPackageImportStyleString(URI uri) {
		var String filePath = if(uri.isPlatform()) uri.toPlatformString(true) else uri.toFileString()
		return new StyledString(''' - «filePath»''', new GreyoutStyler())
	}

	protected static final String ICONS_INCLUDE = "icons/Package.png"

	def protected Image getIncludeImage(PackageImport pkgImport) {
		val ImageRegistry imageRegistry = ExpressionsActivator.getInstance().getImageRegistry()
		val image = imageRegistry.get(ICONS_INCLUDE)
		if (image === null) {
			val descriptor = ImageDescriptor.createFromURL(ExpressionsActivator.instance.bundle.getEntry(ICONS_INCLUDE))
			imageRegistry.put(ICONS_INCLUDE, descriptor)
		}
		return imageRegistry.get(ICONS_INCLUDE)
	}

}
