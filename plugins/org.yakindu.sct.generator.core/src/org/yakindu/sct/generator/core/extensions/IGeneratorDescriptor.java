package org.yakindu.sct.generator.core.extensions;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.generator.core.ISCTGenerator;

public interface IGeneratorDescriptor {

	ISCTGenerator createGenerator();

	List<String> getLibraryIDs();

	String getId();

	String getName();

	/**
	 * may return null!!
	 */
	Image getImage();

	String getContentType();

	String getDescription();

	String getElementRefType();

}