/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.ui.outline

import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sgen.GeneratorEntry

/** 
 * customization of the default outline structure
 */
class SGenOutlineTreeProvider extends DefaultOutlineTreeProvider {

	def protected void _createNode(IOutlineNode parentNode, GeneratorEntry modelElement) {
		var String name = modelElement.getContentType()
		if (modelElement.getElementRef() instanceof NamedElement) {
			name = '''«name» «((modelElement.getElementRef() as NamedElement)).getName()»'''
		}
		createEObjectNode(parentNode, modelElement, imageDispatcher.invoke(modelElement), name,
			isLeafDispatcher.invoke(modelElement))
	}
}
