/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.c.files.StatemachineHeader;
import org.yakindu.sct.generator.c.submodules.StatemachineHeaderFragment;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenStatemachineHeaderFragment;

/**
 * @author rbeckmann
 *
 */
public class HeaderContentFragmentProvider extends AbstractContentFragmentProvider<StatemachineHeader> {
	@Override
	public StatemachineHeader get() {
		StatemachineHeader header = new StatemachineHeader();
		injector.injectMembers(header);

		if (isEventDriven()) {
			header.getContentProviders().add(injector.getInstance(EventDrivenStatemachineHeaderFragment.class));
		}

		header.getContentProviders().add(injector.getInstance(StatemachineHeaderFragment.class));
		return header;
	}
}
