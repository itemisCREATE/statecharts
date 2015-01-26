package org.yakindu.scr.operationswithoutbraces;
import org.yakindu.scr.IStatemachine;

public interface IOperationsWithoutBracesStatemachine extends IStatemachine {

	public interface SCInterface {

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public boolean myBoolOp();
		public long myIntOp();
		public double myRealOp();
	}

	public SCInterface getSCInterface();

}
