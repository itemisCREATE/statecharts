package org.yakindu.sct.domain.generic;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.yakindu.sct.domain.extension.IDomainDocumentationProvider;

public class GenericDomainDocumentationProvider implements IDomainDocumentationProvider {

	@Override
	public URL getDocumentationURL() {
		Bundle plugin = GenericDomainActivator.getContext().getBundle();
		IPath relativePagePath = new Path("docu/default_domain.html");
		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
		try {
			return FileLocator.toFileURL(fileInPlugin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
