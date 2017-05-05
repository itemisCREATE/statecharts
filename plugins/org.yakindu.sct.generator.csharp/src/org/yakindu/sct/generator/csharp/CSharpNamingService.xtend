/*
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Axel Terfloth - Initial contribution
*/
package org.yakindu.sct.generator.csharp

import java.util.Arrays
import org.yakindu.sct.model.sexec.naming.DefaultNamingService

/** 
 * Specific adaption of the default naming service to the needs of the C# code generator.
 * 
 * @author axel terfloth (terfloth@itemis.de)
 */
class CSharpNamingService extends DefaultNamingService implements CSharpKeywords {
}