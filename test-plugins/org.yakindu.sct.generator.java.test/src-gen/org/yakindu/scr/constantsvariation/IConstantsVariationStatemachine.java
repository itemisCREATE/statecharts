package org.yakindu.scr.constantsvariation;

import org.yakindu.scr.IStatemachine;

public interface IConstantsVariationStatemachine extends IStatemachine {
	public static final boolean b = true;
	
	public static final String str = "String";
	
	public static final double r = 5;
	
	public static final long i = 5;
	
	public interface SCInterface {
	
	public static final boolean b2 = true;
	
	public static final String str2 = "String";
	
	public static final double r2 = 5;
	
	public static final long i2 = 5;
	
		public boolean getB2();
		
		public String getStr2();
		
		public double getR2();
		
		public long getI2();
		
	}
	
	public SCInterface getSCInterface();
	
	public interface SCINamed {
	
	public static final boolean b = true;
	
	public static final String str = "String";
	
	public static final double r = 5;
	
	public static final long i = 5;
	
		public boolean getB();
		
		public String getStr();
		
		public double getR();
		
		public long getI();
		
	}
	
	public SCINamed getSCINamed();
	
}
