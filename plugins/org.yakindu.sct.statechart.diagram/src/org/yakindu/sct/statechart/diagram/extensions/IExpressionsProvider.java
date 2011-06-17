package org.yakindu.sct.statechart.diagram.extensions;

import org.eclipse.swt.SWT;

import com.google.inject.Injector;

/**
 * @author andreas muelder
 * 
 */
public interface IExpressionsProvider extends ISCTProvider {

	String EXPRESSIONS_EXTENSION = "org.yakindu.sct.statechart.diagram.expressions";

	/**
	 * 
	 * @return the Injector
	 */
	public Injector getInjector();

	/**
	 * @return the {@link SWT} styles for the CellEditor
	 */
	public int getStyle();
}
