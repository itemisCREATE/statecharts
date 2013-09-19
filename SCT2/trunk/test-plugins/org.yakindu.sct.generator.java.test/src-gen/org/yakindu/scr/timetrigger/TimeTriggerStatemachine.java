package org.yakindu.scr.timetrigger;
import org.yakindu.scr.ITimer;

public class TimeTriggerStatemachine implements ITimeTriggerStatemachine {

	private boolean x7;

	private final boolean[] timeEvents = new boolean[2];

	private final class SCInterfaceImpl implements SCInterface {

		private boolean x3;

		public void raiseX3() {
			x3 = true;
		}

		private boolean x4;

		public boolean isRaisedX4() {
			return x4;
		}

		private void raiseX4() {
			x4 = true;
		}

		private int y0;

		public int getY0() {
			return y0;
		}

		public void setY0(int value) {
			this.y0 = value;
		}

		private String y1;

		public String getY1() {
			return y1;
		}

		public void setY1(String value) {
			this.y1 = value;
		}

		private boolean y2;

		public boolean getY2() {
			return y2;
		}

		public void setY2(boolean value) {
			this.y2 = value;
		}

		public void clearEvents() {
			x3 = false;
		}

		public void clearOutEvents() {
			x4 = false;
		}
	}

	private SCInterfaceImpl sCInterface;
	private final class SCIBImpl implements SCIB {

		private boolean x5;

		public void raiseX5() {
			x5 = true;
		}

		private boolean x6;

		public boolean isRaisedX6() {
			return x6;
		}

		private void raiseX6() {
			x6 = true;
		}

		public void clearEvents() {
			x5 = false;
		}

		public void clearOutEvents() {
			x6 = false;
		}
	}

	private SCIBImpl sCIB;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private int z1;
	private String z2;
	private boolean z3;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	public TimeTriggerStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCIB = new SCIBImpl();
	}

	public void init() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.y0 = 0;

		sCInterface.y1 = "";

		sCInterface.y2 = false;

		z1 = 0;

		z2 = "";

		z3 = false;
	}

	public void enter() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		timer.setTimer(this, 0, 1 * 1000, false);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);
				break;

			case main_region_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 1);
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCInterface.clearEvents();
		sCIB.clearEvents();
		x7 = false;

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
		sCInterface.clearOutEvents();
		sCIB.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	/**
	 * Set the {@link ITimer} for the state machine. It must be set
	 * externally on a timed state machine before a run cycle can be correct
	 * executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	/**
	 * Returns the currently used timer.
	 * 
	 * @return {@link ITimer}
	 */
	public ITimer getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCIB getSCIB() {
		return sCIB;
	}

	private void raiseX7() {
		x7 = true;
	}

	public void raiseX3() {
		sCInterface.raiseX3();
	}
	public boolean isRaisedX4() {
		return sCInterface.isRaisedX4();
	}

	public int getY0() {
		return sCInterface.getY0();
	}

	public void setY0(int value) {
		sCInterface.setY0(value);
	}
	public String getY1() {
		return sCInterface.getY1();
	}

	public void setY1(String value) {
		sCInterface.setY1(value);
	}
	public boolean getY2() {
		return sCInterface.getY2();
	}

	public void setY2(boolean value) {
		sCInterface.setY2(value);
	}

	/* Entry action for statechart 'TimeTrigger'. */
	private void entryAction() {
	}

	/* Exit action for state 'TimeTrigger'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (timeEvents[0]) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 0);

			timer.setTimer(this, 1, 1 * 1000, false);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (timeEvents[1]) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 1);

			timer.setTimer(this, 0, 1 * 1000, false);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
