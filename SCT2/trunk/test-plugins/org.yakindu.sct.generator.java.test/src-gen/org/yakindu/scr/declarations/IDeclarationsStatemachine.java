package org.yakindu.scr.declarations;
import org.yakindu.scr.IStatemachine;

public interface IDeclarationsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvA();
		public boolean isRaisedEvB();
		public void raiseEvC(boolean value);
		public boolean isRaisedEvD();
		public int getEvDValue();
		public void raiseEvE(double value);
		public boolean isRaisedEvF();
		public String getEvFValue();
		public boolean getVarA();
		public void setVarA(boolean value);
		public int getVarB();
		public void setVarB(int value);
		public double getVarC();
		public void setVarC(double value);
		public String getVarD();
		public void setVarD(String value);

	}

	public SCInterface getSCInterface();

	public interface SCIIfA {
		public void raiseEvA();
		public boolean isRaisedEvB();
		public void raiseEvC(boolean value);
		public boolean isRaisedEvD();
		public int getEvDValue();
		public void raiseEvE(double value);
		public boolean isRaisedEvF();
		public String getEvFValue();
		public boolean getVarA();
		public void setVarA(boolean value);
		public int getVarB();
		public void setVarB(int value);
		public double getVarC();
		public void setVarC(double value);
		public String getVarD();
		public void setVarD(String value);

	}

	public SCIIfA getSCIIfA();

}
