
package org.yakindu.sct.runtime.java.custom;

import java.util.Collection;

import org.yakindu.sct.runtime.java.custom.ExampleAbstractBaseStatemachine.Events;

public interface Interface {
	public Collection<Events> getOutEvents();
	public Collection<Events> getOccuredEvents();
}

