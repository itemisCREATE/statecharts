package org.yakindu.sct.domain.extension;

import java.net.URL;

public interface IDomainDescriptor {

	String getDomainID();

	String getName();

	String getDescription();

	IDomainInjectorProvider getDomainInjectorProvider();

	URL getImagePath();

}