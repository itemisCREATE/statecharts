package org.yakindu.base.expressions.util

import com.google.inject.Singleton
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Visibility

@Singleton
class ExpressionPredicates {
	def isPublic(Declaration it) {
		visibility == Visibility.PUBLIC
	}
}