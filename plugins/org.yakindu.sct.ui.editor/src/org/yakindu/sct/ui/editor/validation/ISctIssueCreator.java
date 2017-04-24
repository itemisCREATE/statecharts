/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.validation;

import org.eclipse.core.resources.IMarker;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;

import com.google.inject.ImplementedBy;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
@ImplementedBy(SctIssueCreator.class)
public interface ISctIssueCreator {

    SCTIssue createFromMarker(IMarker marker, String elementID);
    
}
