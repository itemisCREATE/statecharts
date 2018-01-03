/** 
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * rbeckmann - initial API and implementation
 */
package org.yakindu.sct.model.sgen.util

import java.net.InetAddress
import java.text.DateFormat
import java.util.Date
import org.osgi.framework.FrameworkUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.interpreter.DefaultExpressionInterpreter
import org.yakindu.base.types.Property

/** 
 * @author rbeckmann
 */
class BuiltinExpressionsInterpreter extends DefaultExpressionInterpreter implements BuiltinDeclarationNames {

	override dispatch Object execute(ElementReferenceExpression expression) {
		if (expression.reference instanceof Property) {
			switch ((expression.reference as Property).name) {
				case SCT_VERSION_VAR: {
					val v = FrameworkUtil.getBundle(getClass()).version
					return '''«v.major».«v.minor».«v.micro»'''.toString
				}
				case TIMESTAMP_VAR: {
					return DateFormat.getDateTimeInstance().format(new Date()).toString
				}
				case USER_VAR: {
					return System.getProperty("user.name").toString
				}
				case HOSTNAME_VAR: {
					return InetAddress.localHost.hostName.toString
				}
				default:
					return executeElementReferenceExpression(expression)
			}

		}
		executeElementReferenceExpression(expression)
	}

}
