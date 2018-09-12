package org.yakindu.sct.renamescript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UpdateVersion {

	public static final String FEATURE_XML = "feature.xml";
	public static final String POM_XML = "pom.xml";
	public static final String MANIFEST = "MANIFEST.MF";
	public static final String QUALIFIER = ".qualifier";
	public static final String SNAPSHOT = "-SNAPSHOT";

	public static void updateFeatureXMLs(Path f, String currentVersion, String newVersion) {
		try {
			List<Path> result = VersionUpdateVisitor.searchFor(f, FEATURE_XML, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void updateManifestXMLs(Path f, String currentVersion, String newVersion) {
		try {
			List<Path> result = VersionUpdateVisitor.searchFor(f, MANIFEST, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void updatePomXMLs(Path f, String currentVersion, String newVersion) {
		try {
			currentVersion = PomXMLGetVersionVisitor.getVersion(f);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		newVersion = newVersion.replace(QUALIFIER, SNAPSHOT);
		try {

			List<Path> result = VersionUpdateVisitor.searchFor(f, POM_XML, currentVersion, newVersion);
			for (Path path : result) {
				System.out.println(path + " size = " + Files.size(path) + " bytes");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getCurrentVersion() {
		Path searchPath = getSearchPath();
		try {
			return FeatureXMLGetVersionVisitor.getVersion(searchPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return "Error: Could not determine current version!";
	}

	protected static Path getSearchPath() {
		return Paths.get(System.getProperty("user.dir")).getParent().getParent();
	}

	public static String ask4NewVersion(String currentVersion) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String newVersion = "";
		System.out.println(
				"Current Version is " + currentVersion + ". Please type the new version (without .qualifier!!).");
		try {
			String input = br.readLine();
			newVersion = input.trim() + QUALIFIER;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newVersion;
	}

	public static void main(String[] args) {

		Path f = getSearchPath();

		String currentVersion = getCurrentVersion();
		String newVersion = ask4NewVersion(currentVersion);

		System.out.println("Will update to version: " + newVersion);
		System.out.println("Search within folder: " + f + " for " + FEATURE_XML + ".");

		updateFeatureXMLs(f, currentVersion, newVersion);
		updateManifestXMLs(f, currentVersion, newVersion);
		updatePomXMLs(f, currentVersion, newVersion);

		System.exit(0);
	}

}
