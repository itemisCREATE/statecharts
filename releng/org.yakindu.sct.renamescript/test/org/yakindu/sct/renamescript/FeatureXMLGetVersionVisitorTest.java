package org.yakindu.sct.renamescript;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class FeatureXMLGetVersionVisitorTest {

	@Test
	void test() throws IOException
	{
		Path f = Paths.get(System.getProperty("user.dir")+"\\..\\..\\");
		String currentVersion = "error";
		currentVersion = FeatureXMLGetVersionVisitor.getVersion(f);
		assertEquals("3.1.0.qualifier",currentVersion);
	}

}
