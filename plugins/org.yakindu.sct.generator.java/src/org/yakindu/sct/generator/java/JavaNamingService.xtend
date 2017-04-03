/*
 *   Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   	Axel Terfloth - Initial contribution
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.HashSet
import java.util.Set
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.DefaultNamingService
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.base.types.Declaration
import org.yakindu.sct.model.stext.stext.InternalScope

/** 
 * Specific adaption of the default naming service to the needs of the java code generator.
 * 
 * @author axel terfloth (terfloth@itemis.de)
 * @author Markus Mühlbrandt (muehlbrandt@itemis.de)
 */
@Singleton
class JavaNamingService extends DefaultNamingService {
}