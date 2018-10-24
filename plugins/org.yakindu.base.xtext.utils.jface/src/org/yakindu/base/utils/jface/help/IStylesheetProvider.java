/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.utils.jface.help;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author tobias angele - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultStylesheetProvider.class)
public interface IStylesheetProvider {

	String getCSS();

}
