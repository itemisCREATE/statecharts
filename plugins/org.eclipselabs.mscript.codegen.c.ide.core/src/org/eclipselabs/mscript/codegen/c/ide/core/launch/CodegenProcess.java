/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.codegen.c.ide.core.launch;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Writer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipselabs.mscript.codegen.c.Generator;
import org.eclipselabs.mscript.codegen.c.GeneratorContext;
import org.eclipselabs.mscript.codegen.c.ide.core.CodegenCIDECorePlugin;
import org.eclipselabs.mscript.codegen.c.util.NameNormalizer;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;

/**
 * @author Andreas Unger
 *
 */
public class CodegenProcess implements IProcess {

	private ILaunch launch;
	private String name;
	
	private IFolder targetFolder;
	private ILFunctionDefinition functionDefinition;
	private ComputationModel computationModel;

	private boolean terminated;

	/**
	 * 
	 */
	public CodegenProcess(ILaunch launch, String name, IFolder targetFolder, ILFunctionDefinition functionDefinition, ComputationModel computationModel) {
		this.launch = launch;
		this.name = name;
		this.targetFolder = targetFolder;
		this.functionDefinition = functionDefinition;
		this.computationModel = computationModel;
		launch.addProcess(this);
		fireCreationEvent();
	}

	public ILaunch getLaunch() {
		return launch;
	}
	
	public String getLabel() {
		return name;
	}
	
	public void run() {
		Job job = new WorkspaceJob("Generating C code") {
			
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				new NameNormalizer().normalize(functionDefinition);
				
				GeneratorThread thread = new HeaderGeneratorThread();
				executeGenerator(thread, functionDefinition.getName() + ".h", monitor);
				
				thread = new ImplementationGeneratorThread();
				executeGenerator(thread, functionDefinition.getName() + ".c", monitor);

				return Status.OK_STATUS;
			}
			
		};
		job.addJobChangeListener(new JobChangeAdapter() {
			
			@Override
			public void done(IJobChangeEvent event) {
				terminated = true;
				fireTerminateEvent();
			}
			
		});
		job.schedule();
	}
	
	private void executeGenerator(GeneratorThread thread, String fileName, IProgressMonitor monitor) throws CoreException {
		try {
			IFile targetFile = targetFolder.getFile(fileName);

			PipedInputStream pipedInputStream = new PipedInputStream();
			PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
			Writer writer = new OutputStreamWriter(pipedOutputStream);
			
			thread.setWriter(writer);
			
			thread.start();
			
			if (targetFile.exists()) {
				targetFile.setContents(pipedInputStream, true, false, monitor);
			} else {
				targetFile.create(pipedInputStream, true, monitor);
			}
			
			thread.join();
			
			if (!thread.getStatus().isOK()) {
				throw new CoreException(thread.getStatus());
			}
		} catch (IOException e) {
			new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Code generation failed", e));
		} catch (InterruptedException e) {
			new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Code generation thread execution failed", e));
		}
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
	}

	public String getAttribute(String key) {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	/**
	 * Fires a creation event.
	 */
	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	/**
	 * Fires a terminate event.
	 */
	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/**
	 * Fires the given debug event.
	 * 
	 * @param event debug event to fire
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin manager= DebugPlugin.getDefault();
		if (manager != null) {
			manager.fireDebugEventSet(new DebugEvent[] { event });
		}
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}
	
	private abstract class GeneratorThread extends Thread {
		
		protected Writer writer;
		protected IStatus status = Status.OK_STATUS;
		
		public void setWriter(Writer writer) {
			this.writer = writer;
		}
		
		public void run() {
			generate();
			try {
				writer.close();
			} catch (IOException e) {
				status = new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Writing to file failed", e);
			}
		}
		
		protected abstract void generate();

		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}

	}

	private class HeaderGeneratorThread extends GeneratorThread {
		
		public void generate() {
			Generator generator = new Generator(functionDefinition, new GeneratorContext(computationModel, writer));
			generator.generateHeaderCode();
		}
		
	}

	private class ImplementationGeneratorThread extends GeneratorThread {
		
		public void generate() {
			Generator generator = new Generator(functionDefinition, new GeneratorContext(computationModel, writer));
			generator.generateImplementationCode();
		}
		
	}

}
