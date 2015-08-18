package org.yakindu.base.xtext.utils.jface.viewers.context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.yakindu.base.xtext.utils.jface.viewers.util.ActiveEditorTracker;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * Context used by {@link XtextStyledTextAdapter} to handle the required
 * underlying (fake) resources.
 * 
 * @author alexander.nyssen@itemis.de
 * 
 */
public class XtextFakeResourceContext {

	@Inject
	private IResourceSetProvider resourceSetProvider;
	private ResourceSet fakeResourceSet;
	@Inject
	private XtextResource fakeResource;
	@Inject
	private @Named(Constants.FILE_EXTENSIONS)
	String fakeResourceFileExtension;

	public XtextFakeResourceContext(Injector injector) {
		injector.injectMembers(this);

		// create resource set
		createXtextFakeResourceSet();

		// initialize fake resource (which was injected and thus does not has to
		// be created)
		initXtextFakeResource();

		// initialize the resource set (the fake resource has to be added)
		initXtextFakeResourceSet();
	}

	protected void initXtextFakeResourceSet() {
		fakeResourceSet.getResources().add(fakeResource);
		// fakeResourceSet.getLoadOptions().put(
		// ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
	}

	protected ResourceSet getFakeResourceSet() {
		return fakeResourceSet;
	}

	protected void createXtextFakeResourceSet() {
		fakeResourceSet = resourceSetProvider.get(getActiveProject());
	}

	protected void initXtextFakeResource() {
		// add the fake resource (add an uri to it, first)
		IProject activeProject = getActiveProject();
		// fallback to avoid dependency on open editor
		String activeProjectName = activeProject != null ? activeProject
				.getName() : "fakeResource";
		fakeResource.setURI(createFakeResourceUri(activeProjectName));
		try {
			fakeResource.load(new StringInputStream(""), Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public XtextResource getFakeResource() {
		return fakeResource;
	}

	private URI createFakeResourceBaseFragment(String activeProject) {
		return URI.createPlatformResourceURI(activeProject + "/embedded", true);
	}

	private URI createFakeResourceUri(String activeProject) {
		return createFakeResourceBaseFragment(activeProject)
				.appendFileExtension(fakeResourceFileExtension);
	}

	protected String getFileExtension() {
		return fakeResourceFileExtension;
	}

	protected IProject getActiveProject() {
		return ActiveEditorTracker.getLastActiveEditorProject();
	}

	public void updateFakeResourceContext(
			IXtextFakeContextResourcesProvider contextProvider) {

		// remove any other resources that may have been created earlier
		// unloading them (to remove all adapters)
		List<Resource> staleResources = new ArrayList<Resource>();
		for (Resource r : fakeResourceSet.getResources()) {
			if (r != fakeResource) {
				staleResources.add(r);
				r.unload();
			}
		}
		fakeResourceSet.getResources().removeAll(staleResources);

		// when populating the fake resource set, the non-existing fake resource
		// contained in the resource set may be problematic, so we temporarily
		// remove it
		fakeResourceSet.getResources().remove(fakeResource);
		contextProvider.populateFakeResourceSet(fakeResourceSet, fakeResource);
		fakeResourceSet.getResources().add(fakeResource);
	}

}
