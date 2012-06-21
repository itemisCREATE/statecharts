package org.yakindu.sct.generator.java.extensions;

import static org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator.CONTEXT_INJECTOR_PROPERTY_NAME;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.IExecutionContextAware;
import org.yakindu.sct.generator.java.features.IJavaFeatureConstants;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class JavaExtensions implements IJavaFeatureConstants, IExecutionContextAware {
	
	@Inject
	private StextNameProvider provider;
	
	public void setExecutionContext(ExecutionContext ctx) {
		Injector injector = null;
		if (ctx.getGlobalVariables().get(CONTEXT_INJECTOR_PROPERTY_NAME) != null) {
			injector = (Injector) ctx.getGlobalVariables()
					.get(CONTEXT_INJECTOR_PROPERTY_NAME).getValue();
		} else if (ctx.getGlobalVariables().get(Injector.class.getName()) != null) {
			injector = (Injector) ctx.getGlobalVariables()
					.get(Injector.class.getName()).getValue();
		}
		if (injector != null) {
			injector.injectMembers(this);
		}
	}
	
	public static final String getStatemachineInterfaceTypes(
			ExecutionFlow flow, GeneratorEntry entry) {

		String interfaces = "";
		
		if (hasGenericInterfaceSupport(entry)) {
			interfaces += "IGenericAccessStatemachine, ";
		}
		
//		if (hasDefaultInterface(flow)) {
//			interfaces += "DefaultInterface,";
//		}

		if (isTimedStatemachine(flow)) {
			interfaces += "ITimedStatemachine,";
		}
		
		interfaces += "IStatemachine";
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
	
	private static final boolean hasDefaultInterface(ExecutionFlow flow) {
		for (Scope scope: flow.getScopes()) {
			if (scope instanceof InterfaceScope && ((InterfaceScope) scope).getName() == null) {
				return true;
			}
		}
		return false;
	}
	
	public static final boolean isJavaKeyword(String name) {
		String lowName = name.toLowerCase();
		for (String keyword : Arrays.asList(JAVA_KEYWORDS)) {				
			Pattern pattern= Pattern.compile("^" +keyword+"$");
			Matcher matcher = pattern.matcher(lowName);
			if  (matcher.find()) {
				return true;
			}
		}
		return false;
	}
	
	public static final String getValidStatemachineName(String name) {
		//remove whitespaces;
		String newName = name.replace(" ", "");
		return isJavaKeyword(name) ? newName + "SM" : newName;
	}
	
	public String getFullQualifiedStateName(ExecutionState state) {
		return getFullQualifiedStateName(state.getName());
	}
	
	public String getFullQualifiedStateName(State state) {
		String name = provider.getFullyQualifiedName(state).toString();
		return getFullQualifiedStateName(name);
	}
	
	private String getFullQualifiedStateName(String name) {
		return name.substring(name.indexOf(".")+1).replace(".","_");
	}
}