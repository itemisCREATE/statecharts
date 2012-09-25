package org.yakindu.scr.assignmentasexpression;

import org.yakindu.scr.IStatemachine;

public interface IAssignmentAsExpressionStatemachine extends IStatemachine {

	public interface SCIDefault {

		public int getA();
		public void setA(int value);
		public int getB();
		public void setB(int value);

	}

	public SCIDefault getSCIDefault();

}
