/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.builder.nature;

import java.util.Optional;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.yakindu.sct.generator.builder.SCTBuilder;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
@SuppressWarnings("restriction")
public class SCTNature implements IProjectNature {

	public static final String NATURE_ID = "org.yakindu.sct.builder.SCTNature";

	private IProject project;

	@Override
	public void configure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(SCTBuilder.BUILDER_ID)) {
				return;
			}
		}

		Optional<Integer> xtextNatureIndex = findXtextNature(commands);

		ICommand[] newCommands = new ICommand[commands.length + 1];
		ICommand command = desc.newCommand();
		command.setBuilderName(SCTBuilder.BUILDER_ID);
		/*
		 * If the Xtext builder has been found, the SCT nature comes next in order.
		 * Else, put it at the end.
		 */
		if (xtextNatureIndex.isPresent()) {
			insertAtIndex(commands, newCommands, command, xtextNatureIndex.get() + 1);
		} else {
			insertAtIndex(commands, newCommands, command, commands.length);
		}
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
	}

	protected void insertAtIndex(ICommand[] src, ICommand[] dest, ICommand newCommand, int index) {
		System.arraycopy(src, 0, dest, 0, index);
		System.arraycopy(src, index, dest, index + 1, src.length - index);
		dest[index] = newCommand;
	}

	protected Optional<Integer> findXtextNature(ICommand[] commands) {
		for (int i = 0; i < commands.length; i++) {
			if (commands[i].getBuilderName().equals(XtextBuilder.BUILDER_ID)) {
				return Optional.of(i);
			}
		}
		return Optional.empty();
	}

	@Override
	public void deconfigure() throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(SCTBuilder.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
				description.setBuildSpec(newCommands);
				project.setDescription(description, null);
				return;
			}
		}
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
