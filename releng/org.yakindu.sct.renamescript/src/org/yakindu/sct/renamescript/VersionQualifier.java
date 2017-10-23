package org.yakindu.sct.renamescript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VersionQualifier {

	public static void main(String[] args) {

		
		Path f = Paths.get(System.getProperty("user.dir")+"\\..\\..\\");
		String currentVersion = "error";
		try {
			currentVersion = FeatureXMLGetVersionVisitor.getVersion(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String newVersion = "";
		String featureXML = "feature.xml";
//		String pomXML = "pom.xml"; //TODO add
//		String manifest = "MANIFEST.MF";

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("Current Version is " + currentVersion + " Please type the new version (incl. 'qualifier' String!!):");
		try {
			String input = br.readLine();
			// TODO validate correct pattern
			newVersion = input.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Will update to version: " + newVersion);

		System.out.println("Search within folder: " + f+ " for " + featureXML + ".");
		
		 try
		   {

		      String searchPattern = "feature.xml";;
		      List<Path> result = FeatureXMLVisitor.searchFor(f, searchPattern, currentVersion, newVersion);
		      for(Path path : result)
		      {
		         System.out.println(path + " size = " + Files.size(path) + " bytes" );
		      }
		   }
		   catch(IOException ex)
		   {
		      ex.printStackTrace();
		   }
		
	

		// TODO for all pom.xml
		// TODO Open file, search for OLD String or Place to change, change it and save
		// and close pom.xml
		// TODO for all MANIFEST.MF
		// TODO look for bundle versions of yakindu sct -> change to new VERSION, save
		// and close
		 System.exit(0);
	}

}
