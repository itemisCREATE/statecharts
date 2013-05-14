package org.yakindu.scr.simplehierachy;
import org.yakindu.scr.IStatemachine;

public interface ISimpleHierachyStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();

	}

	public SCInterface getSCInterface();

}
