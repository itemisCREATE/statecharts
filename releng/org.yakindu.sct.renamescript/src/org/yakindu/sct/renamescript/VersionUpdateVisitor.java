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
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class VersionUpdateVisitor implements FileVisitor<Path> {
	
	private int fileCount = 0;
	private int dirCount = 0;
	private String searchPattern = "";
	private List<Path> searchList;
	private String replacePattern = "";
	private String filePattern = "";
	
	/**
	 * Pattern examples: "abc*.*" ;  "abc?fg?.j*"
	 */
	public static List<Path> searchFor(Path startDir, String filePattern, String searchPattern, String replacePattern)
			throws IOException {
		
		VersionUpdateVisitor fileVisitor = new VersionUpdateVisitor(filePattern, searchPattern, replacePattern);
		Files.walkFileTree(startDir, fileVisitor);
		
		return fileVisitor.getResultList();
	}
	
	private VersionUpdateVisitor(String filePattern, String searchPattern, String newValue) {
		this.filePattern = filePattern;
		this.searchPattern = searchPattern;
		this.replacePattern = newValue;
		this.searchList = new ArrayList<>();
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path path, IOException arg1) throws IOException {
		// System.out.println("postVisitDirectory: " + path + " Exception = " + arg1);
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes arg1) throws IOException {
		// System.out.println("preVisitDirectory: " + path + " size = " + arg1.size() +
		// " bytes");
		dirCount++;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:" + filePattern);
		
		if (pathMatcher.matches(path.getFileName())) {
			searchList.add(path);
			String charset = Charset.defaultCharset().name();
			//System.out.println(charset);
			String content = new String(Files.readAllBytes(path), charset);
			content = content.replaceAll(this.searchPattern, this.replacePattern);
			Files.write(path, content.getBytes(charset));
			fileCount++;
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path path, IOException arg1) throws IOException {
		// System.out.println("visitFileFailed " + " Exception = " + arg1);
		return FileVisitResult.CONTINUE;
	}
	
	public int getFileCount() {
		return fileCount;
	}
	
	public int getDirCount() {
		return dirCount;
	}
	
	public List<Path> getResultList() {
		return searchList;
	}
	
}
