/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import java.util.Comparator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.Annotation
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.sct.types.modification.IModification

/**
 * Reorder enums to the top. They cannot be forward declared and need to be defined first.
 */
class ReorderComplexTypesModification implements IModification {
	@Inject protected extension PackageNavigationExtensions

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val allTypes = p.member.filter(ComplexType).sortWith(new MemberComparator)
		p.member.removeAll(allTypes)
		p.member.addAll(0, allTypes)
		return p
	}

	static class MemberComparator implements Comparator<Declaration> {
		override compare(Declaration o1, Declaration o2) {
			val o1Contents = o1.contents
			val o2Contents = o2.contents
			if (o1Contents.contains(o2)) {
				return 1
			}
			if (o2Contents.contains(o1)) {
				return -1
			}
			return 0
		}

		def protected mapTypeSpecifierToType(EObject o) {
			if (o instanceof TypeSpecifier) {
				return o.type
			}
			return o
		}
		
		def protected getContents(Declaration decl) {
			decl.eAllContents.filter[!annotationDescendant].map[mapTypeSpecifierToType].filter[!(it instanceof Annotation)].filterNull.toList
		}
		
		def protected isAnnotationDescendant(EObject it) {
			EcoreUtil2.getContainerOfType(it, Annotation) !== null
		}
		
	}

}
