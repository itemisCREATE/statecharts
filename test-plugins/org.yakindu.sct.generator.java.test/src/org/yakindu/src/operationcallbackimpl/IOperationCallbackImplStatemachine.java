package org.yakindu.src.operationcallbackimpl;

import org.yakindu.scr.IStatemachine;

public interface IOperationCallbackImplStatemachine extends IStatemachine {

	public interface InternalOperationCallback {
	
		public void operation1();
		
	}
	
	public void setInternalOperationCallback(InternalOperationCallback operationCallback);
	
	public interface SCInterface {
	
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCInterfaceOperationCallback {
	
		public void operation2();
		
	}
	
	public SCInterface getSCInterface();
	
	public interface SCINamed {
	
		public void setSCINamedOperationCallback(SCINamedOperationCallback operationCallback);
	
	}
	
	public interface SCINamedOperationCallback {
	
		public void operation3();
		
	}
	
	public SCINamed getSCINamed();
	
}
