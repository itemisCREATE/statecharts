package org.yakindu.sct.ui.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

@SuppressWarnings("rawtypes")
public abstract class AbstractNavigatorItem extends PlatformObject {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	static {
		final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
		final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
			public String getContributorId() {
				return ID;
			}
		};
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof AbstractNavigatorItem
						&& adapterType == ITabbedPropertySheetPageContributor.class) {
					return propertySheetPageContributor;
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, AbstractNavigatorItem.class);
	}

	private Object myParent;

	protected AbstractNavigatorItem(Object parent) {
		myParent = parent;
	}

	public Object getParent() {
		return myParent;
	}

}
