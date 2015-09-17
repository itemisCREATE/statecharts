package org.yakindu.scr.stextkeywordsinstatesandregions;
import org.yakindu.scr.IStatemachine;

public interface ISTextKeywordsInStatesAndRegionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE1();
		public void raiseE2();

	}

	public SCInterface getSCInterface();

}
