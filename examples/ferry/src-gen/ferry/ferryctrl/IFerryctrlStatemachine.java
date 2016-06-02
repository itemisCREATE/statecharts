/** Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
� */
package ferry.ferryctrl;
import ferry.IStatemachine;
import ferry.ITimerCallback;

public interface IFerryctrlStatemachine extends ITimerCallback, IStatemachine {

	public interface SCIFerry {
		public void raiseLeftBumper();
		public void raiseRightBumper();
		public boolean getMoving();
		public void setMoving(boolean value);
		public boolean getIsLeft();
		public void setIsLeft(boolean value);
		public boolean getIsRight();
		public void setIsRight(boolean value);
		public boolean getFull();
		public void setFull(boolean value);

	}

	public SCIFerry getSCIFerry();

	public interface SCICorn {
		public void raiseLoadleft();
		public void raiseLoadright();

	}

	public SCICorn getSCICorn();

	public interface SCIGoose {
		public void raiseLoadleft();
		public void raiseLoadright();

	}

	public SCIGoose getSCIGoose();

	public interface SCIWolf {
		public void raiseLoadleft();
		public void raiseLoadright();

	}

	public SCIWolf getSCIWolf();

	public interface SCInterface {
		public void raiseLeftShoreButton();
		public void raiseLeftFerryButton();
		public void raiseRightFerryButton();
		public void raiseRightShoreButton();

		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public void synchronize();
	}

	public SCInterface getSCInterface();

}
