package org.yakindu.sct.model.sgraph.resource;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.resources.GMFLoad;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphLoad extends GMFLoad {

	private static final String NS_URI_TO_MIGRATE = "http://www.yakindu.org/sct/2.0.0";

	public SGraphLoad(XMLHelper helper) {
		super(helper);
	}

	@Override
	public void load(XMLResource r, InputStream s,
			@SuppressWarnings("rawtypes") Map o) throws IOException {
		IFile file = WorkspaceSynchronizer.getFile(r);
		if (file != null) {
			String osString = file.getLocation().makeAbsolute().toOSString();
			String filecontent = readFileAsString(osString);
			// TODO: on check the first line for old ns uri, not neccessary to
			// read
			// the whole file content
			if (filecontent.contains(NS_URI_TO_MIGRATE)) {
				filecontent = migratePreM10Models(filecontent);
				BufferedWriter writer = new BufferedWriter(new FileWriter(
						osString));
				writer.write(filecontent);
				writer.flush();
				writer.close();
			}
		}
		super.load(r, s, o);
	}

	/**
	 * Migrate the following Model changes:
	 * 
	 * <pre>
	 * 		1. NS URI changed from http://www.yakindu.org/sct/2.0.0 to  http://www.yakindu.org/sct/sgraph/2.0.0
	 * 		2. State->subRegions renamed to State->regions
	 * 		3. ExpressionElement#expression renamed to SpecificationElement.specification
	 * 		4. Scopes, triggers, effects are transient now
	 * </pre>
	 * 
	 */
	private String migratePreM10Models(String content) {
		content = content.replace(NS_URI_TO_MIGRATE,
				"http://www.yakindu.org/sct/sgraph/2.0.0");
		content = content.replaceAll("expression=\"", "specification=\"");
		content = content.replaceAll("<subRegions", "<regions");
		content = content.replaceAll(" </subRegions", "</regions");
		return content;
	}

	private String readFileAsString(String filePath) throws java.io.IOException {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = new BufferedInputStream(new FileInputStream(
				filePath));
		f.read(buffer);
		return new String(buffer);
	}
}
