package org.yakindu.sct.core.simulation;

import java.util.List;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphExecutionScope {

	public ScopeVariable getVariable(String varName);

	public List<ScopeVariable> getVariables();

	public void setVariableValue(ScopeVariable variable, Object object);

	public void createVariable(String varName, Object value, Class<?> type);

	public void call(String procedureId);

	public void raise(String signal);

	/**
	 * Read only access to ScopeVariables. Value can only be changed via
	 * {@link ISGraphExecutionScope}#setVariableValue
	 * 
	 */
	public class ScopeVariable {
		private String name;
		private Class<?> type;
		private Object value;

		public ScopeVariable(String name, Class<?> type, Object value) {
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
}
