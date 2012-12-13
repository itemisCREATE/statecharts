package org.yakindu.scr.stextkeywordsinstatesandregions;
import org.yakindu.scr.IStatemachine;

public interface ISTextKeywordsInStatesAndRegionsStatemachine
		extends
			IStatemachine {

	public interface SCIDefault {
		public void raiseE();

	}

	public SCIDefault getSCIDefault();

}
