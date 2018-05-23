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

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;

import org.yakindu.base.types.Annotation;
import org.yakindu.sct.generator.c.files.StatemachineHeader;
import org.yakindu.sct.generator.c.submodules.StatemachineHeaderContentFragment;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenStatemachineHeaderFragment;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author rbeckmann
 *
 */
public class HeaderContentFragmentProvider implements Provider<StatemachineHeader> {
	@Inject
	Injector injector;

	@Override
	public StatemachineHeader get() {
		StatemachineHeader header = injector.getInstance(StatemachineHeader.class);

		GeneratorEntry entry = injector.getInstance(GeneratorEntry.class);

		if (isEventDriven(entry)) {
			header.getContentProviders().add(injector.getInstance(EventDrivenStatemachineHeaderFragment.class));
		}

		header.getContentProviders().add(injector.getInstance(StatemachineHeaderContentFragment.class));
		return header;
	}

	protected boolean isEventDriven(GeneratorEntry entry) {
		Statechart statechart = (Statechart) entry.getElementRef();
		Annotation eventDrivenAnnotation = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		return eventDrivenAnnotation != null;
	}

}
