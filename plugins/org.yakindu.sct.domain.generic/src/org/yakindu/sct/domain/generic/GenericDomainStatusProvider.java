/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.domain.generic;

import java.util.Map;

import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;
import org.yakindu.sct.domain.extension.IDomainStatusProvider;

/**
 * @author Thomas Kutz - Initial contribution and API
 * 
 */
public class GenericDomainStatusProvider implements IDomainStatusProvider {

	private static IDomainStatusProvider delegate;
	
	@Override
	public DomainStatus getDomainStatus() {
		if (delegate != null) {
			return delegate.getDomainStatus();
		}
		return new DomainStatus(Severity.ERROR, "Installation is currupt. License feature is missing.");
	}
	
	public void bindProvider(IDomainStatusProvider provider, Map<String, Object> properties) {
		delegate = provider;
	}
	
	public void unbindProvider(IDomainStatusProvider provider) {
		delegate = null;
	}

}
