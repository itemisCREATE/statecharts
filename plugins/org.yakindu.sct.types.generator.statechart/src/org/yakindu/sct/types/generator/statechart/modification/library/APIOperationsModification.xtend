/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.statechart.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.Visibility
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class APIOperationsModification implements IModification {

    @Inject protected extension SCTGeneratorAnnotationLibrary
    @Inject protected extension TypeBuilder

    val APIOperations = #[
        "init",
        "enter",
        "exit",
        "runCycle",
        "isActive",
        "isFinal",
        "isStateActive"
    ]

    override modify(Collection<Package> packages) {
        packages.forEach[modify]
        packages
    }

    def modify(Package p) {
        val ops = p.eAllContents.filter(Operation).filter[body !== null].toList
        ops.filter[APIOperations.contains(name)].forEach [
            visibility = Visibility.PUBLIC
            static = false
            _annotateWith(APIAnnotation)
        ]
        ops.filter[!APIOperations.contains(name)].filter[!isAPI].forEach [
            static = true
            visibility = Visibility.PROTECTED
        ]
        return p
    }

}
