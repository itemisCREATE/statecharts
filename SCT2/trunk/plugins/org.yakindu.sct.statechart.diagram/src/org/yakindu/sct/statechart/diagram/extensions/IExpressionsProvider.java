package org.yakindu.sct.statechart.diagram.extensions;

import org.eclipse.swt.SWT;

import com.google.inject.Injector;

/**
 * @author muelder
 * 
 */
public interface IExpressionsProvider extends ISCTProvider {
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
