package org.yakindu.scr.typealias;

import org.yakindu.scr.IStatemachine;

public interface ITypeAliasStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseMyEvent();
		
		public long getMyVar();
		
		public void setMyVar(long value);
		
		public String getMyString();
		
		public void setMyString(String value);
		
	}
	
	public SCInterface getSCInterface();
	
}
