package org.yakindu.sct.simulation.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public enum SimulationImages {

	EVENT("icons/Event.gif"),

	TIMEEVENT("icons/TimeEvent.gif"),

	EVENT_ENABLED("icons/Event_enabled.gif"),

	EVENT_DISABLED("icons/Event_disabled.gif"),

	VARIABLE("icons/Variable.gif"),

	SCOPE("icons/Scope.gif"),

	COLLAPSE_ALL("icons/collapseall.gif"),

	EXPAND_ALL("icons/expandall.gif"),

	BREAKPOINT_ENABLED("icons/brkp_obj.gif"),
	
	BREAKPOINT_DISABLED("icons/brkpd_obj.gif"),

	LAUNCHER_ICON("icons/Statechart-Launcher-16.png"), 
	
	VARIABLE_LOCK("icons/Variable_lock.gif");
	
	private final String path;

	private SimulationImages(String path) {
		this.path = path;
	}

	/**
	 * Returns an image. Clients do not need to dispose the image, it will be
	 * disposed automatically.
	 * 
	 * @return an {@link Image}
	 */
	public Image image() {
		final ImageRegistry imageRegistry = SimulationActivator.getDefault().getImageRegistry();
		Image image = imageRegistry.get(path);
		if (image == null) {
			addImageDescriptor();
			image = imageRegistry.get(path);
		}

		return image;
	}

	/**
	 * Returns an image descriptor.
	 * 
	 * @return an {@link ImageDescriptor}
	 */
	public ImageDescriptor imageDescriptor() {
		final ImageRegistry imageRegistry = SimulationActivator.getDefault().getImageRegistry();
		ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(path);
		if (imageDescriptor == null) {
			addImageDescriptor();
			imageDescriptor = imageRegistry.getDescriptor(path);
		}

		return imageDescriptor;
	}

	private void addImageDescriptor() {
		final SimulationActivator plugin = SimulationActivator.getDefault();
		final ImageDescriptor id = ImageDescriptor.createFromURL(plugin.getBundle().getEntry(path));
		plugin.getImageRegistry().put(path, id);
	}

}
