package org.yakindu.scr.nullcheck;
import org.yakindu.scr.IStatemachine;

public interface INullCheckStatemachine extends IStatemachine {

	public interface SCInterface {

	}

	public SCInterface getSCInterface();

}
