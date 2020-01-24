package org.yakindu.sct.simulation.ui.view;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.internal.ui.DebugPluginImages;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.ui.SimulationImages;

@SuppressWarnings("all")
public class SimulationSessionViewerFactory {

	public static TreeViewer createViewer(Composite parent) {

		Composite comp = new Composite(parent, SWT.NONE);
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		comp.setLayoutData(layoutData);
		TreeColumnLayout layout = new TreeColumnLayout();
		comp.setLayout(layout);

		TreeViewer simulationSessionViewer = new TreeViewer(comp);
		simulationSessionViewer.setContentProvider(new LaunchContentProvider());
		simulationSessionViewer.setLabelProvider(new LaunchLabelProvider());
		return simulationSessionViewer;
	}

	private static final class LaunchLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof ILaunch) {
				return ((ILaunch) element).getLaunchConfiguration().getName();
			}
			try {
				return ((SCTDebugTarget) element).getName();
			} catch (DebugException e) {
				e.printStackTrace();
			}
			return element.toString();
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof Launch) {
				if (((Launch) element).getDebugTarget().isSuspended()) {
					return DebugPluginImages.getImage(IInternalDebugUIConstants.IMG_ELCL_SUSPEND);
				}
				return SimulationImages.LAUNCHER_ICON.image();
			}
			return SimulationImages.SUB_STATECHART_PICTOGRAM.image();
		}
	}

	private static final class LaunchContentProvider implements ITreeContentProvider {
		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof Launch) {
				return ((Launch) element).getDebugTargets().length > 0;
			}
			return false;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Launch) {
				return ((Launch) parentElement).getDebugTargets();
			}
			return null;
		}
	}

}
