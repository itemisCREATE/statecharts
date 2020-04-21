/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */

package org.yakindu.sct.simulation.core.sexec.container;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.types.Direction;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.CompositeSlot;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.SRuntimePackage;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IEventRaiser;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.SubchartInterpreterProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Event Driven implementation of the {@link ISimulationEngine}.
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class EventDrivenSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	private EventDrivenCycleAdapter cycleAdapter;
	private ShadowEventMappingAdapter shadowEventAdapter;
	
	@Inject private SubchartInterpreterProvider interpreterProvider;

	public EventDrivenSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		cycleAdapter = new EventDrivenCycleAdapter(interpreter);
		context.eAdapters().add(cycleAdapter);

		shadowEventAdapter = new ShadowEventMappingAdapter(interpreter, interpreterProvider);
		context.eAdapters().add(shadowEventAdapter);
	}

	@Override
	public void terminate() {
		context.eAdapters().remove(cycleAdapter);
		context.eAdapters().remove(shadowEventAdapter);
		super.terminate();
	}

	@Override
	public void suspend() {
		cycleAdapter.suspend();
		super.suspend();
	}

	@Override
	public void resume() {
		super.resume();
		cycleAdapter.resume();
	}

	@Override
	public void stepForward() {
		try {
			interpreter.runCycle();
		} catch (Exception ex) {
			handleException(ex);
		}
		super.stepForward();
	}

	@Override
	protected boolean useInternalEventQueue() {
		return true;
	}

	public static class EventDrivenCycleAdapter extends EContentAdapter {

		private IExecutionFlowInterpreter interpreter;

		private boolean suspended = false;
		private boolean cycleAfterResume = false;

		public EventDrivenCycleAdapter(IExecutionFlowInterpreter interpreter) {
			this.interpreter = interpreter;
		}

		@Override
		public void notifyChanged(Notification notification) {
			// Only run cycle if responsible for this kind of notification
			if (EcoreUtil2.getContainerOfType((EObject) notification.getNotifier(),
					ExecutionContext.class) != interpreter.getExecutionContext()) {
				return;
			}
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED) {
				ExecutionEvent event = (ExecutionEvent) notification.getNotifier();
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					if (notification.getNewBooleanValue() && event.getDirection() != Direction.OUT) {
						if (!suspended)
							interpreter.runCycle();
						else {
							cycleAfterResume = true;
						}
					}
				}
			}

		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == EventDrivenCycleAdapter.class;
		}

		public void suspend() {
			suspended = true;
		}

		public void resume() {
			suspended = false;
			if (cycleAfterResume)
				interpreter.runCycle();
			cycleAfterResume = false;
		}
	}

	public static class ShadowEventMappingAdapter extends EContentAdapter {

		private IExecutionFlowInterpreter interpreter;
		private SubchartInterpreterProvider interpreterProvider;

		public ShadowEventMappingAdapter(IExecutionFlowInterpreter interpreter, SubchartInterpreterProvider provider) {
			this.interpreter = interpreter;
			this.interpreterProvider = provider;
		}

		@Override
		public void notifyChanged(Notification notification) {
			// Only run cycle if responsible for this kind of notification
			if (EcoreUtil2.getContainerOfType((EObject) notification.getNotifier(),
					ExecutionContext.class) != interpreter.getExecutionContext()) {
				return;
			}
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED) {
				ExecutionEvent event = (ExecutionEvent) notification.getNotifier();
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					if (notification.getNewBooleanValue() && event.getDirection() == Direction.OUT) {
						// an out event was raised => check if there is a parent execution context that
						// contains a corresponding shadow event
						ExecutionContext thisContext = interpreter.getExecutionContext();
						if (thisContext.getName() == null || thisContext.getName().isEmpty()) {
							return;
						}
						ExecutionContext parentContext = EcoreUtil2.getContainerOfType(thisContext.eContainer(),
								ExecutionContext.class);
						if (parentContext == null) {
							return;
						}
						ExecutionEvent shadowEvent = findShadowEvent(event, parentContext);
						if (shadowEvent == null) {
							return;
						}
						// raise shadow event
						Optional<IExecutionFlowInterpreter> parentInterpreter = interpreterProvider
								.findInterpreter(parentContext);
						if (parentInterpreter.isPresent() && parentInterpreter.get() instanceof IEventRaiser) {
							((IEventRaiser) parentInterpreter.get()).raise(shadowEvent, event.getValue());
						}
					}
				}
			}
		}

		protected ExecutionEvent findShadowEvent(ExecutionEvent event, ExecutionContext parentContext) {
			List<String> shadowEventFqn = Lists.newArrayList();
			shadowEventFqn.add(event.getName());
			for (EObject container : EcoreUtil2.getAllContainers(event)) {
				if (container == parentContext) break;
				
				if (container instanceof CompositeSlot) {
					CompositeSlot slot = (CompositeSlot) container;
					if (!slot.getName().isEmpty() && !slot.getName().equals("default")) {
						shadowEventFqn.add(0, slot.getName());
					}
				}
			}
			String shadowEventName = String.join("_", shadowEventFqn);
			return parentContext.getEvent(shadowEventName);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ShadowEventMappingAdapter.class;
		}

	}
}
