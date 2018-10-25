package org.yakindu.sct.renamescript;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class FeatureXMLGetVersionVisitorTest {

	@Test
	void test() throws IOException
	{
		Path f = UpdateVersion.getSearchPath();
		String currentVersion = "error";
		currentVersion = FeatureXMLGetVersionVisitor.getVersion(f);
		assertEquals("3.1.0.qualifier",currentVersion);
	}

}
