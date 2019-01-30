package org.yakindu.scr.parentfirstlocalreactions;

import org.yakindu.scr.IStatemachine;

public interface IParentFirstLocalReactionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		
		public long getCnt();
		
		public void setCnt(long value);
		
		public boolean getDisable_a();
		
		public void setDisable_a(boolean value);
		
		public boolean getDisable_aa();
		
		public void setDisable_aa(boolean value);
		
		public boolean getDisable_aaa();
		
		public void setDisable_aaa(boolean value);
		
		public long getA_local();
		
		public void setA_local(long value);
		
		public long getAa_local();
		
		public void setAa_local(long value);
		
		public long getAaa_local();
		
		public void setAaa_local(long value);
		
		public long getSm_local();
		
		public void setSm_local(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
