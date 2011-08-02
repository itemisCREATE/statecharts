package org.yakindu.sct.simulation.core;

import java.util.List;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphExecutionScope {

	public ScopeSlot getVariable(String varName);

	public List<ScopeVariable> getVariables();

	public List<ScopeEvent> getEvents();

	public void setSlotValue(ScopeSlot variable, Object object);

	public void call(String procedureId);

	public void raise(ScopeEvent event);

	public static abstract class ScopeSlot {

		protected String name;
		protected Class<?> type;
		protected Object value;

		public ScopeSlot(String name, Class<?> type, Object value) {
			super();
			this.name = name;
			this.type = type;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Class<?> getType() {
			return type;
		}

		public Object getValue() {
			return value;
		}

	}

	/**
	 * Read only access to ScopeVariables. Value can only be changed via
	 * {@link ISGraphExecutionScope}#setVariableValue
	 * 
	 */
	public class ScopeVariable extends ScopeSlot {

		public ScopeVariable(String name, Class<?> type, Object value) {
			super(name, type, value);
		}

	}

	/**
	 * Read only access to ScopeEvents. Value can only be changed via
	 * {@link ISGraphExecutionScope}#setVariableValue
	 * 
	 */
	public class ScopeEvent extends ScopeSlot {

		public ScopeEvent(String name) {
			this(name, null, null);
		}

		public ScopeEvent(String name, Class<?> type, Object value) {
			super(name, type, value);
		}

	}
}
