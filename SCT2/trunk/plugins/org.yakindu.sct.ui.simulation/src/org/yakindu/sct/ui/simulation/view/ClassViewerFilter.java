package org.yakindu.sct.ui.simulation.view;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ClassViewerFilter extends ViewerFilter {

	private final Class<?> clazz;

	public ClassViewerFilter(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return clazz.isAssignableFrom(element.getClass());
	}

}
