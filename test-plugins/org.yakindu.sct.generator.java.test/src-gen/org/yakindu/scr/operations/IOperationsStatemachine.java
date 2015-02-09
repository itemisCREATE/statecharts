package org.yakindu.scr.operations;
import org.yakindu.scr.IStatemachine;

public interface IOperationsStatemachine extends IStatemachine {

	public interface InternalOperationCallback {
		public void internalOperation1();
		public boolean internalOperation2(long param1);
		public double internalOperation3();
		public double internalOperation3a(double param1);
		public long internalOperation4();
		public long internalOperation4a(long param1);
		public String internalOperation5();
		public String internalOperation5a(String param1);
	}

	public void setInternalOperationCallback(
			InternalOperationCallback operationCallback);
	public interface SCIInterface1 {

		public void setSCIInterface1OperationCallback(
				SCIInterface1OperationCallback operationCallback);
	}

	public interface SCIInterface1OperationCallback {
		public void interfaceOperation1();
		public boolean interfaceOperation2(long param1);
		public double interfaceOperation3();
		public double interfaceOperation3a(double param1);
		public long interfaceOperation4();
		public long interfaceOperation4a(long param1);
		public String interfaceOperation5();
		public String interfaceOperation5a(String param1);
	}

	public SCIInterface1 getSCIInterface1();

	public interface SCInterface {
		public void raiseEv();

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public void unnamedInterfaceOperation1();
		public boolean unnamedInterfaceOperation2(long param1);
		public double unnamedOperation3();
		public double unnamedOperation3a(double param1);
		public long unnamedOperation4();
		public long unnamedOperation4a(long param1);
		public String unnamedOperation5();
		public String unnamedOperation5a(String param1);
		public boolean alwaysTrue();
	}

	public SCInterface getSCInterface();

}
