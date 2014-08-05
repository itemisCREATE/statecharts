package org.yakindu.scr.declarations;
import org.yakindu.scr.IStatemachine;

public interface IDeclarationsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvA();
		public boolean isRaisedEvB();
		public void raiseEvC(boolean value);
		public boolean isRaisedEvD();
		public long getEvDValue();
		public void raiseEvE(double value);
		public boolean isRaisedEvF();
		public String getEvFValue();
		public boolean getVarA();
		public void setVarA(boolean value);
		public long getVarB();
		public void setVarB(long value);
		public double getVarC();
		public void setVarC(double value);
		public String getVarD();
		public void setVarD(String value);
		public long getVarE();
		public void setVarE(long value);

	}

	public SCInterface getSCInterface();

	public interface SCIIfA {
		public void raiseEvA();
		public boolean isRaisedEvB();
		public void raiseEvC(boolean value);
		public boolean isRaisedEvD();
		public long getEvDValue();
		public void raiseEvE(double value);
		public boolean isRaisedEvF();
		public String getEvFValue();
		public boolean getVarA();
		public void setVarA(boolean value);
		public long getVarB();
		public void setVarB(long value);
		public double getVarC();
		public void setVarC(double value);
		public String getVarD();
		public void setVarD(String value);
		public long getVarE();
		public void setVarE(long value);

	}

	public SCIIfA getSCIIfA();

}
