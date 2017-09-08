/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view.actions;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.internal.ui.commands.actions.DisconnectCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.ResumeCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepIntoCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepOverCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepReturnCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.SuspendCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.TerminateCommandAction;
import org.eclipse.jface.action.IAction;

/**
 * 
 * @author robert rudi - Initial contribution and API
 * 
 */
public final class DebugActions {
	
	public static class StepReturn extends StepReturnCommandAction implements IAction, IDebugEventSetListener {

		public StepReturn() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			
		}
	}
	
	public static class StepOver extends StepOverCommandAction implements IAction, IDebugEventSetListener {

		public StepOver() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
		
		}
	}
	
	public static class StepInto extends StepIntoCommandAction implements IAction, IDebugEventSetListener {

		public StepInto() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
		
		}
	}
	
	public static class Disconnect extends DisconnectCommandAction implements IAction, IDebugEventSetListener {

		public Disconnect() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {

		}
	}
	
	public static class Terminate extends TerminateCommandAction implements IAction, IDebugEventSetListener{
		public Terminate() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			boolean enableAction = false;
			for (DebugEvent debugEvent : events) {
				int kind = debugEvent.getKind();
				if (kind == DebugEvent.RESUME || kind == DebugEvent.SUSPEND
						|| (isEnabled() && kind == DebugEvent.CHANGE && debugEvent.getDetail() == DebugEvent.CONTENT))
					enableAction = true;
			}
			setEnabled(enableAction);
		}
	}
	
	public static class Suspend extends SuspendCommandAction implements IAction, IDebugEventSetListener {

		public Suspend() {
			DebugPlugin.getDefault().addDebugEventListener(this);
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			boolean enableAction = false;
			for (DebugEvent debugEvent : events) {
				int kind = debugEvent.getKind();
				if (kind == DebugEvent.RESUME || (isEnabled() && kind == DebugEvent.CHANGE && debugEvent.getDetail() == DebugEvent.CONTENT))
					enableAction = true;
				if(kind == DebugEvent.SUSPEND) setEnabled(false);
			}
			setEnabled(enableAction);
		}
	}
	
	public static class Resume extends ResumeCommandAction implements IAction, IDebugEventSetListener {
		
		public Resume() {
			DebugPlugin.getDefault().addDebugEventListener(this);	
		}

		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			boolean enableAction = false;
			for (DebugEvent debugEvent : events) {
				int kind = debugEvent.getKind();
				if (kind == DebugEvent.SUSPEND || (isEnabled() && kind == DebugEvent.CHANGE && debugEvent.getDetail() == DebugEvent.CONTENT))
					enableAction = true;
				if (kind == DebugEvent.RESUME) setEnabled(false);
			}
			setEnabled(enableAction);
		}
	}
}

