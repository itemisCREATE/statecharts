package org.yakindu.sct.ui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public enum StatechartImages {

	SUB_STATECHART_PICTOGRAM("icons/obj16/Statechart-Pictogram-16.png"),

	LOGO("icons/obj16/logo-16.png"),
	
	MENU("icons/obj16/Menu-16.png");
	

	private final String path;

	private StatechartImages(String path) {
		this.path = path;
	}

	/**
	 * Returns an image. Clients do not need to dispose the image, it will be
	 * disposed automatically.
	 * 
	 * @return an {@link Image}
	 */
	public Image image() {
		final ImageRegistry imageRegistry = DiagramActivator.getDefault()
				.getImageRegistry();
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
		final ImageRegistry imageRegistry = DiagramActivator.getDefault()
				.getImageRegistry();
		ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(path);
		if (imageDescriptor == null) {
			addImageDescriptor();
			imageDescriptor = imageRegistry.getDescriptor(path);
		}

		return imageDescriptor;
	}

	private void addImageDescriptor() {
		final DiagramActivator plugin = DiagramActivator.getDefault();
		final ImageDescriptor id = ImageDescriptor.createFromURL(plugin
				.getBundle().getEntry(path));
		plugin.getImageRegistry().put(path, id);
	}

}
