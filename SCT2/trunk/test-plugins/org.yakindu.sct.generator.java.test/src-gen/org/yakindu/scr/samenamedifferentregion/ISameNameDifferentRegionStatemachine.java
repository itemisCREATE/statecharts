package org.yakindu.scr.samenamedifferentregion;

import org.yakindu.scr.IStatemachine;

public interface ISameNameDifferentRegionStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseE1();

	}

	public SCIDefault getSCIDefault();

}
