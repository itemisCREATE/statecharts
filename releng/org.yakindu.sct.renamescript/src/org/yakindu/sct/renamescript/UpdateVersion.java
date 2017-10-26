package org.yakindu.sct.renamescript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UpdateVersion {

	public static void main(String[] args) {

		Path f = Paths.get(System.getProperty("user.dir") + "\\..\\..\\");
		String currentVersion = "error";
		String searchPattern = "feature.xml";
		String newVersion = "";
		String featureXML = "feature.xml";
		String pomXML = "pom.xml";
		String manifest = "MANIFEST.MF";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			currentVersion = FeatureXMLGetVersionVisitor.getVersion(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.print(
				"Current Version is " + currentVersion + " Please type the new version (incl. 'qualifier' String!!):");
		try {
			String input = br.readLine();
			// TODO validate correct pattern
			newVersion = input.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Will update to version: " + newVersion);

		System.out.println("Search within folder: " + f + " for " + featureXML + ".");

		try {
			List<Path> result = VersionUpdateVisitor.searchFor(f, searchPattern, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		//MANIFEST.MF
		searchPattern = manifest;
		try {
			List<Path> result = VersionUpdateVisitor.searchFor(f, searchPattern, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		//pom.xml
		searchPattern = pomXML;
		try {
			currentVersion = PomXMLGetVersionVisitor.getVersion(f);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.print(
				"Current Version is " + currentVersion + " Please type the new version (incl. '-SNAPSHOT' String!!):");
		try {
			String input = br.readLine();
			// TODO validate correct pattern
			newVersion = input.trim();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			List<Path> result = VersionUpdateVisitor.searchFor(f, searchPattern, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.exit(0);
	}

}
