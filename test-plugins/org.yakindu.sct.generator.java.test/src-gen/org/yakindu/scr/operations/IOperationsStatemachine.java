package org.yakindu.scr.operations;
import org.yakindu.scr.IStatemachine;

public interface IOperationsStatemachine extends IStatemachine {

	public interface InternalOperationCallback {
		public void internalOperation1();
		public boolean internalOperation2(int param1);
	}

	public void setInternalOperationCallback(
			InternalOperationCallback operationCallback);
	public interface SCIInterface1 {

		public void setSCIInterface1OperationCallback(
				SCIInterface1OperationCallback operationCallback);
	}

	public interface SCIInterface1OperationCallback {
		public void interfaceOperation1();
		public boolean interfaceOperation2(int param1);
	}

	public SCIInterface1 getSCIInterface1();

	public interface SCInterface {

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public void unnamedInterfaceOperation1();
		public boolean unnamedInterfaceOperation2(int param1);
	}

	public SCInterface getSCInterface();

}
