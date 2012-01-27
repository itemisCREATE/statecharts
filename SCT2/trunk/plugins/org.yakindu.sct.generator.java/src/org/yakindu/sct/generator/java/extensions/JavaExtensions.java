package org.yakindu.sct.generator.java.extensions;

import java.util.LinkedList;
import java.util.List;

import org.yakindu.sct.generator.java.features.IJavaFeatureConstants;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;

public class JavaExtensions implements IJavaFeatureConstants {

	public static final String getStatemachineInterfaceTypes(
			ExecutionFlow flow, GeneratorEntry entry) {

		String interfaces = "";

		if (hasGenericInterfaceSupport(entry)) {
			interfaces += "IGenericAccessStatemachine, ";
		}

		if (isTimedStatemachine(flow)) {
			interfaces += "ITimedStatemachine";
		}

		else {
			interfaces += "IStatemachine";
		}

		return interfaces;
	}

	public static final String getInterfaceExtensions(Scope scope, GeneratorEntry entry) {
		String interfaces = "";
		
		List<String> list = new LinkedList<String>();
		
		if ((!scope.getVariables().isEmpty() || hasOutgoingEvents(scope))
				&& hasInterfaceObserverSupport(entry)) {
			list.add("INotificationSender");
		}
		if ((!scope.getVariables().isEmpty() || hasIncomingEvents(scope))
				&& hasGenericInterfaceSupport(entry)) {
			list.add("IGenericAccessInterface");
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				interfaces = " extends ";
			}
			
			interfaces += list.get(i);
			
			if (i < list.size() - 1) {
				interfaces += ", ";
			}
		}
		return interfaces;
	}

	private static final boolean hasOutgoingEvents(Scope scope) {
		for (Event event : scope.getEvents()) {
			if (event instanceof EventDefinition
					&& ((EventDefinition) event).getDirection() == Direction.OUT) {
				return true;
			}
		}
		return false;
	}

	private static final boolean hasIncomingEvents(Scope scope) {
		for (Event event : scope.getEvents()) {
			if (event instanceof EventDefinition
					&& ((EventDefinition) event).getDirection() == Direction.IN) {
				return true;
			}
		}
		return false;
	}

	private static final boolean isTimedStatemachine(ExecutionFlow flow) {
		for (Scope scope : flow.getScopes()) {
			for (Event event : scope.getEvents()) {
				if (event instanceof TimeEvent) {
					return true;
				}
			}
		}
		return false;
	}

	private static final boolean hasGenericInterfaceSupport(GeneratorEntry entry) {
		if (entry.getFeatureConfiguration(GENERAL_FEATURES) != null
				&& entry.getFeatureConfiguration(GENERAL_FEATURES)
						.getParameterValue(GENERIC_INTERFACE_SUPPORT) != null) {
			return entry.getFeatureConfiguration(GENERAL_FEATURES)
					.getParameterValue(GENERIC_INTERFACE_SUPPORT)
					.getBooleanValue();
		}
		return false;
	}

	private static final boolean hasInterfaceObserverSupport(
			GeneratorEntry entry) {
		if (entry.getFeatureConfiguration(GENERAL_FEATURES) != null
				&& entry.getFeatureConfiguration(GENERAL_FEATURES)
						.getParameterValue(INTERFACE_OBSERVER_SUPPORT) != null) {
			return entry.getFeatureConfiguration(GENERAL_FEATURES)
					.getParameterValue(INTERFACE_OBSERVER_SUPPORT)
					.getBooleanValue();
		}
		return false;
	}
}
