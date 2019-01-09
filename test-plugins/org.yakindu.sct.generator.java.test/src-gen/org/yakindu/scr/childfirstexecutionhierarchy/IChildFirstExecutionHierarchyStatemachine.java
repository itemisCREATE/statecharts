package org.yakindu.scr.childfirstexecutionhierarchy;

import org.yakindu.scr.IStatemachine;

public interface IChildFirstExecutionHierarchyStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseE();
		
		public boolean getDisable_a();
		
		public void setDisable_a(boolean value);
		
		public boolean getDisable_aa();
		
		public void setDisable_aa(boolean value);
		
		public boolean getDisable_aaa();
		
		public void setDisable_aaa(boolean value);
		
		public boolean getA_reacted();
		
		public void setA_reacted(boolean value);
		
		public boolean getAa_reacted();
		
		public void setAa_reacted(boolean value);
		
		public boolean getAaa_reacted();
		
		public void setAaa_reacted(boolean value);
		
		public boolean getA_local();
		
		public void setA_local(boolean value);
		
		public boolean getAa_local();
		
		public void setAa_local(boolean value);
		
		public boolean getAaa_local();
		
		public void setAaa_local(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
}
