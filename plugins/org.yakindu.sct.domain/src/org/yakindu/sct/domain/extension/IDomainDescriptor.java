package org.yakindu.sct.domain.extension;

import org.eclipse.swt.graphics.Image;

public interface IDomainDescriptor {

	String getDomainID();

	String getName();

	String getDescription();

	IDomainInjectorProvider getDomainInjectorProvider();

	Image getImage();

}