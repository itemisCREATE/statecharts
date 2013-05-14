package org.yakindu.scr.namedinterfaceaccess;
import org.yakindu.scr.IStatemachine;

public interface INamedInterfaceAccessStatemachine extends IStatemachine {

	public interface SCISafe {
		public boolean isRaisedOpen();
		public boolean isRaisedClose();

	}

	public SCISafe getSCISafe();

	public interface SCIUser {
		public void raiseNumberPressed(int value);
		public void raiseReset();

	}

	public SCIUser getSCIUser();

}
