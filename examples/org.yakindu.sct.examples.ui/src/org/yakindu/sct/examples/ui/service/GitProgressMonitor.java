package org.yakindu.sct.examples.ui.service;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jgit.lib.BatchingProgressMonitor;

public class GitProgressMonitor extends BatchingProgressMonitor {

	private SubMonitor monitor;
	private String lastValidTaskName = "";

	public GitProgressMonitor(IProgressMonitor monitor) {
		this.monitor = SubMonitor.convert(monitor);
	}

	@Override
	protected void onUpdate(String taskName, int workCurr) {
		formatAndShow(taskName, workCurr);
	}

	@Override
	protected void onEndTask(String taskName, int workCurr) {
		formatAndShow(taskName, workCurr);
	}

	@Override
	protected void onUpdate(String taskName, int workCurr, int workTotal, int percentDone) {
		formatAndShow(taskName, workCurr, workTotal, percentDone);
	}

	@Override
	protected void onEndTask(String taskName, int workCurr, int workTotal, int percentDone) {
		formatAndShow(taskName, workCurr, workTotal, percentDone);
	}

	protected void formatAndShow(String taskName, int workCurr) {
		StringBuilder s = new StringBuilder();
		s.append("\r");
		s.append(taskName);
		s.append(": ");
		while (s.length() < 25) {
			s.append(' ');
		}
		s.append(workCurr);
		show(s, taskName, -1, workCurr);
	}

	protected void formatAndShow(String taskName, int cmp, int totalWork, int pcnt) {
		StringBuilder s = new StringBuilder();
		s.append("\r");
		s.append(taskName);
		s.append(": ");
		while (s.length() < 25) {
			s.append(' ');
		}
		String endStr = String.valueOf(totalWork);
		String curStr = String.valueOf(cmp);
		while (curStr.length() < endStr.length()) {
			curStr = " " + curStr;
		}
		if (pcnt < 100) {
			s.append(' ');
		}
		if (pcnt < 10) {
			s.append(' ');
		}
		s.append(pcnt);
		s.append("% (");
		s.append(curStr);
		s.append("/");
		s.append(endStr);
		s.append(")");
		show(s, taskName, cmp, totalWork);
	}

	protected void show(StringBuilder display, String taskName, int current, int total) {
		if (total > 0 && !lastValidTaskName.equals(taskName)) {
			lastValidTaskName = taskName;
			monitor.beginTask(display.toString(), total);
		}
		if (current > 0) {
			monitor.setTaskName(display.toString());
			monitor.worked(current);
		}
	}
}