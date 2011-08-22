package org.yakindu.sct.ui.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

@SuppressWarnings("rawtypes")
public class NavigatorItem extends AbstractNavigatorItem {

	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof NavigatorItem
						&& (adapterType == View.class || adapterType == EObject.class)) {
					return ((NavigatorItem) adaptableObject).getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, NavigatorItem.class);
	}

	private View myView;

	private boolean myLeaf = false;

	public NavigatorItem(View view, Object parent, boolean isLeaf) {
		super(parent);
		myView = view;
		myLeaf = isLeaf;
	}

	public View getView() {
		return myView;
	}

	public boolean isLeaf() {
		return myLeaf;
	}

	public boolean equals(Object obj) {
		if (obj instanceof NavigatorItem) {
			return EcoreUtil.getURI(getView()).equals(
					EcoreUtil.getURI(((NavigatorItem) obj).getView()));
		}
		return super.equals(obj);
	}

	public int hashCode() {
		return EcoreUtil.getURI(getView()).hashCode();
	}

}
