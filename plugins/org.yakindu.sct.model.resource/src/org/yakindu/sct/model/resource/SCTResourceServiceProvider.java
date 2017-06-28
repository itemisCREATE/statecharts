package org.yakindu.sct.model.resource;

import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;

import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class SCTResourceServiceProvider extends GenericResourceServiceProvider {

	@Inject
	Injector injector;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> t) {
		T implementer = super.get(t);
		if (implementer == null) {
			if (t.equals(IMarkerContributor.class)) {
				TaskMarkerContributor taskMarkerContributor = new TaskMarkerContributor();
				injector.injectMembers(taskMarkerContributor);
				implementer = (T) taskMarkerContributor;
			}
		}
		return implementer;
	}

}
