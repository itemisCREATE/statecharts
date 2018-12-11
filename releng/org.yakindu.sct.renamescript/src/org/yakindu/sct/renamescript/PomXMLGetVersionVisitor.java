/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.renamescript;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class PomXMLGetVersionVisitor implements FileVisitor<Path> {
	
	private String version;
	private String filePattern = "pom.xml";
	
	public static String getVersion(Path startDir) throws IOException {
		PomXMLGetVersionVisitor fileVisitor = new PomXMLGetVersionVisitor();
		Files.walkFileTree(startDir, fileVisitor);
		
		return fileVisitor.getVersion();
	}
	
	private String getVersion() {
		return this.version;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path path, IOException arg1) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes arg1) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:" + filePattern);
		
		if (pathMatcher.matches(path.getFileName())) {
			System.out.println("File: "+path.toAbsolutePath());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(path.toFile());
				
				XPathFactory xpathfactory = XPathFactory.newInstance();
				XPath xpath = xpathfactory.newXPath();
				
				XPathExpression expr = xpath.compile("//project[1]/version/text()");
				Object result = expr.evaluate(doc, XPathConstants.STRING);
				if (result instanceof String && !((String)result).isEmpty()) {
					this.version = result.toString();
				} else {
					//try in parent tag
					expr = xpath.compile("//project[1]/parent/version/text()");
					result = expr.evaluate(doc, XPathConstants.STRING);
					if (result instanceof String && !((String)result).isEmpty()) {
						this.version = result.toString();
					} else {
						System.out.println("Error: Unable to find version within pom.xmls.");
						version = null;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return FileVisitResult.TERMINATE;
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path path, IOException arg1) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
}
