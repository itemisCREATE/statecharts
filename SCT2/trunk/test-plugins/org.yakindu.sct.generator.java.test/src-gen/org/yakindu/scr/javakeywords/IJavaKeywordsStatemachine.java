package org.yakindu.scr.javakeywords;
import org.yakindu.scr.IStatemachine;

public interface IJavaKeywordsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseWhile();
		public void raiseEv();
		public boolean getAbstract();
		public void setAbstract(boolean value);
		public boolean getAssert();
		public void setAssert(boolean value);
		public boolean getBoolean();
		public void setBoolean(boolean value);
		public boolean getBreak();
		public void setBreak(boolean value);
		public boolean getByte();
		public void setByte(boolean value);
		public boolean getCase();
		public void setCase(boolean value);
		public boolean getCatch();
		public void setCatch(boolean value);
		public boolean getChar();
		public void setChar(boolean value);
		public boolean getClass_ID();
		public void setClass_ID(boolean value);
		public boolean getConst();
		public void setConst(boolean value);
		public boolean getContinue();
		public void setContinue(boolean value);
		public boolean getDo();
		public void setDo(boolean value);
		public boolean getDouble();
		public void setDouble(boolean value);
		public boolean getEnum();
		public void setEnum(boolean value);
		public boolean getExtends();
		public void setExtends(boolean value);
		public boolean getFinal();
		public void setFinal(boolean value);
		public boolean getFinally();
		public void setFinally(boolean value);
		public boolean getFloat();
		public void setFloat(boolean value);
		public boolean getFor();
		public void setFor(boolean value);
		public boolean getGoto();
		public void setGoto(boolean value);
		public boolean getIf();
		public void setIf(boolean value);
		public boolean getImplements();
		public void setImplements(boolean value);
		public boolean getImport();
		public void setImport(boolean value);
		public boolean getInstanceof();
		public void setInstanceof(boolean value);
		public boolean getInt();
		public void setInt(boolean value);
		public boolean getLong();
		public void setLong(boolean value);
		public boolean getNative();
		public void setNative(boolean value);
		public boolean getNew();
		public void setNew(boolean value);
		public boolean getNull();
		public void setNull(boolean value);
		public boolean getPackage();
		public void setPackage(boolean value);
		public boolean getPrivate();
		public void setPrivate(boolean value);
		public boolean getProtected();
		public void setProtected(boolean value);
		public boolean getPublic();
		public void setPublic(boolean value);
		public boolean getReturn();
		public void setReturn(boolean value);
		public boolean getShort();
		public void setShort(boolean value);
		public boolean getStatic();
		public void setStatic(boolean value);
		public boolean getStrictfp();
		public void setStrictfp(boolean value);
		public boolean getSuper();
		public void setSuper(boolean value);
		public boolean getSwitch();
		public void setSwitch(boolean value);
		public boolean getSynchronized();
		public void setSynchronized(boolean value);
		public boolean getThis();
		public void setThis(boolean value);
		public boolean getThrow();
		public void setThrow(boolean value);
		public boolean getThrows();
		public void setThrows(boolean value);
		public boolean getTransient();
		public void setTransient(boolean value);
		public boolean getTry();
		public void setTry(boolean value);
		public boolean getVoid();
		public void setVoid(boolean value);
		public boolean getVolatile();
		public void setVolatile(boolean value);

	}

	public SCInterface getSCInterface();

}
