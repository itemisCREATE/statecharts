/*copied from  org.eclipse.egit.core;*/
package org.yakindu.sct.examples.wizard.service.git;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;

/** Create a new Git to Eclipse progress monitor. */
public class EclipseGitProgressTransformer implements ProgressMonitor {
	
	private final IProgressMonitor root;
	
	private SubMonitor mainTask;
	private SubMonitor subTask;
	
	private String msg;
	
	private int lastWorked;
	
	private int totalWork;

	/**
	 * Create a new progress monitor.
	 *
	 * @param eclipseMonitor
	 *            the Eclipse monitor we update.
	 */
	public EclipseGitProgressTransformer(final IProgressMonitor eclipseMonitor) {
		root = eclipseMonitor;
	}
	
	@Override
	public void start(final int totalTasks) {
		// the number of sub tasks is 5 in case of a download operation, but we are always called with totalTasks=2
		mainTask = SubMonitor.convert(root, 5);
	}
	
	@Override
	public void beginTask(final String name, final int total) {
		msg = name;
		lastWorked = 0;
		totalWork = total;

		SubMonitor sub;
		if (mainTask != null) {
			// fork a new child from main task to have accumulated progress bar update
			sub = mainTask.newChild(1);
		} else {
			sub = SubMonitor.convert(root);
		}

		if (totalWork == UNKNOWN) {
			subTask = SubMonitor.convert(sub, IProgressMonitor.UNKNOWN);
		} else {
			subTask = SubMonitor.convert(sub, totalWork);
		}
		subTask.subTask(msg);
	}
	
	@Override
	public void update(final int work) {
		if (subTask == null)
			return;
		
		final int cmp = lastWorked + work;
		if (totalWork == UNKNOWN && cmp > 0) {
			if (lastWorked != cmp)
				subTask.subTask(msg + ", " + cmp); //$NON-NLS-1$
		} else if (totalWork <= 0) {
			// Do nothing to update the task.
		} else if (cmp * 100 / totalWork != lastWorked * 100 / totalWork) {
			final StringBuilder m = new StringBuilder();
			m.append(msg);
			m.append(": ");  //$NON-NLS-1$
			while (m.length() < 25)
				m.append(' ');
			
			final String twstr = String.valueOf(totalWork);
			String cmpstr = String.valueOf(cmp);
			while (cmpstr.length() < twstr.length())
				cmpstr = " " + cmpstr; //$NON-NLS-1$
			final int pcnt = (cmp * 100 / totalWork);
			if (pcnt < 100)
				m.append(' ');
			if (pcnt < 10)
				m.append(' ');
			m.append(pcnt);
			m.append("% ("); //$NON-NLS-1$
			m.append(cmpstr);
			m.append("/"); //$NON-NLS-1$
			m.append(twstr);
			m.append(")"); //$NON-NLS-1$
			
			subTask.subTask(m.toString());
		}
		lastWorked = cmp;
		subTask.worked(work);
	}
	
	@Override
	public void endTask() {
		if (subTask != null) {
			try {
				subTask.done();
			} finally {
				subTask = null;
			}
		}
	}
	
	@Override
	public boolean isCancelled() {
		if (subTask != null)
			return subTask.isCanceled();
		return root.isCanceled();
	}
}