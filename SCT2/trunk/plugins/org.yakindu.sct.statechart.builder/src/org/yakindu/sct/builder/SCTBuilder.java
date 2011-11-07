package org.yakindu.sct.builder;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.yakindu.sct.builder.subscriber.IBuilderSubscriber;
import org.yakindu.sct.builder.subscriber.SubscriberExtensions;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBuilder extends IncrementalProjectBuilder {

	class DeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				doIt(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				doIt(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SampleResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			doIt(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	public static final String BUILDER_ID = "org.yakindu.sct.builder.SCTBuilder";

	@Override
	protected IProject[] build(int kind,
			@SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	public void doIt(IResource resource) {
		List<IBuilderSubscriber> subscriber = SubscriberExtensions
				.getSubscriber(resource.getLocation().toOSString());
		// System.out.println("try to build: " + resource.getLocationURI());
		for (IBuilderSubscriber builderSubscriber : subscriber) {
			try {
				builderSubscriber.doBuild(resource);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// try {
		// new SCTGenerator().doBuild(resource);
		// } catch (CoreException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new SampleResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		delta.accept(new DeltaVisitor());
	}
}
