package org.yakindu.base.expressions.formatting2

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.AbstractFormatter2

abstract class AbstractEObjectBasedFormatter extends AbstractFormatter2 {
	protected def void newLines(IHiddenRegionFormatter it) {
		newLines(1, 2, 3)
	}

	protected def void newLines(IHiddenRegionFormatter it, int lines) {
		newLines(1, lines, 3)
	}

	protected def void newLines(IHiddenRegionFormatter it, int min, int lines, int max) {
		noSpace
		setNewLines(min, lines, max)
	}

	protected def ISemanticRegion previousSemanticRegion(EObject it) {
		return it.regionForEObject.previousSemanticRegion
	}

	protected def ISemanticRegion nextSemanticRegion(EObject it) {
		return it.regionForEObject.nextSemanticRegion
	}

	protected def void indent(EObject it, extension IFormattableDocument document) {
		val Pair<ISemanticRegion, ISemanticRegion> pair = new Pair(previousSemanticRegion, nextSemanticRegion)
		pair.interior[indent]
	}

	protected def ISemanticRegion indent(ISemanticRegion it, extension IFormattableDocument document) {
		val Pair<ISemanticRegion, ISemanticRegion> pair = new Pair(it.previousSemanticRegion, it.nextSemanticRegion)
		pair.interior[indent]
		return it
	}

	protected def Pair<ISemanticRegion, ISemanticRegion> interior(EObject key, EObject value) {
		return new Pair(key.previousSemanticRegion, value.nextSemanticRegion)
	}
}