/** Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
� */
package ferry.ferryctrl;
import ferry.ITimer;

public class FerryctrlStatemachine implements IFerryctrlStatemachine {

	protected class SCIFerryImpl implements SCIFerry {

		private boolean leftBumper;

		public void raiseLeftBumper() {
			leftBumper = true;
		}

		private boolean rightBumper;

		public void raiseRightBumper() {
			rightBumper = true;
		}

		private boolean moving;

		public boolean getMoving() {
			return moving;
		}

		public void setMoving(boolean value) {
			this.moving = value;
		}

		private boolean isLeft;

		public boolean getIsLeft() {
			return isLeft;
		}

		public void setIsLeft(boolean value) {
			this.isLeft = value;
		}

		private boolean isRight;

		public boolean getIsRight() {
			return isRight;
		}

		public void setIsRight(boolean value) {
			this.isRight = value;
		}

		private boolean full;

		public boolean getFull() {
			return full;
		}

		public void setFull(boolean value) {
			this.full = value;
		}

		protected void clearEvents() {
			leftBumper = false;
			rightBumper = false;
		}

	}

	protected SCIFerryImpl sCIFerry;

	protected class SCICornImpl implements SCICorn {

		private boolean loadleft;

		public void raiseLoadleft() {
			loadleft = true;
		}

		private boolean loadright;

		public void raiseLoadright() {
			loadright = true;
		}

		protected void clearEvents() {
			loadleft = false;
			loadright = false;
		}

	}

	protected SCICornImpl sCICorn;

	protected class SCIGooseImpl implements SCIGoose {

		private boolean loadleft;

		public void raiseLoadleft() {
			loadleft = true;
		}

		private boolean loadright;

		public void raiseLoadright() {
			loadright = true;
		}

		protected void clearEvents() {
			loadleft = false;
			loadright = false;
		}

	}

	protected SCIGooseImpl sCIGoose;

	protected class SCIWolfImpl implements SCIWolf {

		private boolean loadleft;

		public void raiseLoadleft() {
			loadleft = true;
		}

		private boolean loadright;

		public void raiseLoadright() {
			loadright = true;
		}

		protected void clearEvents() {
			loadleft = false;
			loadright = false;
		}

	}

	protected SCIWolfImpl sCIWolf;

	protected class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private boolean leftShoreButton;

		public void raiseLeftShoreButton() {
			leftShoreButton = true;
		}

		private boolean leftFerryButton;

		public void raiseLeftFerryButton() {
			leftFerryButton = true;
		}

		private boolean rightFerryButton;

		public void raiseRightFerryButton() {
			rightFerryButton = true;
		}

		private boolean rightShoreButton;

		public void raiseRightShoreButton() {
			rightShoreButton = true;
		}

		protected void clearEvents() {
			leftShoreButton = false;
			leftFerryButton = false;
			rightFerryButton = false;
			rightShoreButton = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_Stop___Safe, main_region_Stopped_Left, main_region_StoppedRight, main_region_Moving_Right, main_region_Moving_Left, gameplay_region_Playing_State, gameplay_region_Playing_State_wolf_region_Wolf_Left, gameplay_region_Playing_State_wolf_region_Wolf_Onboard, gameplay_region_Playing_State_wolf_region_Wolf_Right, gameplay_region_Playing_State_goose_region_Goose_Left, gameplay_region_Playing_State_goose_region_Goose_Onboard, gameplay_region_Playing_State_goose_region_Goose_Right, gameplay_region_Playing_State_corn_region_Corn_Right, gameplay_region_Playing_State_corn_region_Corn_Onboard, gameplay_region_Playing_State_corn_region_Corn_Left, gameplay_region_End_of_Game, gameplay_region_End_of_Game_endgame_region_Win, gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn, gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose, $NullState$
	};

	private final State[] stateVector = new State[4];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[1];

	public FerryctrlStatemachine() {

		sCIFerry = new SCIFerryImpl();
		sCICorn = new SCICornImpl();
		sCIGoose = new SCIGooseImpl();
		sCIWolf = new SCIWolfImpl();
		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 4; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIFerry.setMoving(false);

		sCIFerry.setIsLeft(false);

		sCIFerry.setIsRight(false);

		sCIFerry.setFull(false);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		enterSequence_main_region_default();

		enterSequence_gameplay_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitSequence_gameplay_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$
				|| stateVector[2] != State.$NullState$ || stateVector[3] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal()
	 */
	public boolean isFinal() {
		return false;
	}

	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCIFerry.clearEvents();
		sCICorn.clearEvents();
		sCIGoose.clearEvents();
		sCIWolf.clearEvents();
		sCInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_Stop___Safe :
				return stateVector[0] == State.main_region_Stop___Safe;
			case main_region_Stopped_Left :
				return stateVector[0] == State.main_region_Stopped_Left;
			case main_region_StoppedRight :
				return stateVector[0] == State.main_region_StoppedRight;
			case main_region_Moving_Right :
				return stateVector[0] == State.main_region_Moving_Right;
			case main_region_Moving_Left :
				return stateVector[0] == State.main_region_Moving_Left;
			case gameplay_region_Playing_State :
				return stateVector[1].ordinal() >= State.gameplay_region_Playing_State.ordinal() && stateVector[1]
						.ordinal() <= State.gameplay_region_Playing_State_corn_region_Corn_Left.ordinal();
			case gameplay_region_Playing_State_wolf_region_Wolf_Left :
				return stateVector[1] == State.gameplay_region_Playing_State_wolf_region_Wolf_Left;
			case gameplay_region_Playing_State_wolf_region_Wolf_Onboard :
				return stateVector[1] == State.gameplay_region_Playing_State_wolf_region_Wolf_Onboard;
			case gameplay_region_Playing_State_wolf_region_Wolf_Right :
				return stateVector[1] == State.gameplay_region_Playing_State_wolf_region_Wolf_Right;
			case gameplay_region_Playing_State_goose_region_Goose_Left :
				return stateVector[2] == State.gameplay_region_Playing_State_goose_region_Goose_Left;
			case gameplay_region_Playing_State_goose_region_Goose_Onboard :
				return stateVector[2] == State.gameplay_region_Playing_State_goose_region_Goose_Onboard;
			case gameplay_region_Playing_State_goose_region_Goose_Right :
				return stateVector[2] == State.gameplay_region_Playing_State_goose_region_Goose_Right;
			case gameplay_region_Playing_State_corn_region_Corn_Right :
				return stateVector[3] == State.gameplay_region_Playing_State_corn_region_Corn_Right;
			case gameplay_region_Playing_State_corn_region_Corn_Onboard :
				return stateVector[3] == State.gameplay_region_Playing_State_corn_region_Corn_Onboard;
			case gameplay_region_Playing_State_corn_region_Corn_Left :
				return stateVector[3] == State.gameplay_region_Playing_State_corn_region_Corn_Left;
			case gameplay_region_End_of_Game :
				return stateVector[1].ordinal() >= State.gameplay_region_End_of_Game.ordinal() && stateVector[1]
						.ordinal() <= State.gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose.ordinal();
			case gameplay_region_End_of_Game_endgame_region_Win :
				return stateVector[1] == State.gameplay_region_End_of_Game_endgame_region_Win;
			case gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn :
				return stateVector[1] == State.gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn;
			case gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose :
				return stateVector[1] == State.gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose;
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

	public SCIFerry getSCIFerry() {
		return sCIFerry;
	}
	public SCICorn getSCICorn() {
		return sCICorn;
	}
	public SCIGoose getSCIGoose() {
		return sCIGoose;
	}
	public SCIWolf getSCIWolf() {
		return sCIWolf;
	}
	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseLeftShoreButton() {
		sCInterface.raiseLeftShoreButton();
	}
	public void raiseLeftFerryButton() {
		sCInterface.raiseLeftFerryButton();
	}
	public void raiseRightFerryButton() {
		sCInterface.raiseRightFerryButton();
	}
	public void raiseRightShoreButton() {
		sCInterface.raiseRightShoreButton();
	}

	private boolean check__lr0() {
		return timeEvents[0];
	}

	private boolean check_main_region_Stop___Safe_tr0_tr0() {
		return sCInterface.leftShoreButton || sCInterface.leftFerryButton;
	}

	private boolean check_main_region_Stop___Safe_tr1_tr1() {
		return sCInterface.rightShoreButton || sCInterface.rightFerryButton;
	}

	private boolean check_main_region_Stopped_Left_tr0_tr0() {
		return sCInterface.rightShoreButton || sCInterface.rightFerryButton;
	}

	private boolean check_main_region_StoppedRight_tr0_tr0() {
		return sCInterface.leftShoreButton || sCInterface.leftFerryButton;
	}

	private boolean check_main_region_Moving_Right_tr0_tr0() {
		return sCInterface.leftFerryButton;
	}

	private boolean check_main_region_Moving_Right_tr1_tr1() {
		return sCIFerry.rightBumper;
	}

	private boolean check_main_region_Moving_Left_tr0_tr0() {
		return sCIFerry.leftBumper;
	}

	private boolean check_main_region_Moving_Left_tr1_tr1() {
		return sCInterface.rightFerryButton;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr0_tr0() {
		return sCIWolf.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr1_tr1() {
		return sCIFerry.isLeft == false && isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Left)
				&& sCIFerry.isLeft == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr0_tr0() {
		return sCIWolf.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr1_tr1() {
		return sCIWolf.loadright;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr0_tr0() {
		return sCIWolf.loadright;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr1_tr1() {
		return sCIFerry.isRight == false && isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Right)
				&& sCIFerry.isRight == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr2_ferryctrl_gameplay_region__sync5join_check() {
		return isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Right)
				&& isStateActive(State.gameplay_region_Playing_State_corn_region_Corn_Right);
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Left_tr0_tr0() {
		return sCIGoose.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Left_tr1_tr1() {
		return sCIFerry.isLeft == false && isStateActive(State.gameplay_region_Playing_State_corn_region_Corn_Left)
				&& sCIFerry.isLeft == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Left_tr2_tr2() {
		return sCIFerry.isLeft == false && isStateActive(State.gameplay_region_Playing_State_wolf_region_Wolf_Left)
				&& sCIFerry.isLeft == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr0_tr0() {
		return sCIGoose.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr1_tr1() {
		return sCIGoose.loadright;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Right_tr0_tr0() {
		return sCIGoose.loadright;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Right_tr1_tr1() {
		return sCIFerry.isRight == false && isStateActive(State.gameplay_region_Playing_State_corn_region_Corn_Right)
				&& sCIFerry.isRight == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Right_tr2_tr2() {
		return sCIFerry.isRight == false && isStateActive(State.gameplay_region_Playing_State_wolf_region_Wolf_Right)
				&& sCIFerry.isRight == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region_Goose_Right_tr3_ferryctrl_gameplay_region__sync5join_check() {
		return isStateActive(State.gameplay_region_Playing_State_wolf_region_Wolf_Right)
				&& isStateActive(State.gameplay_region_Playing_State_corn_region_Corn_Right);
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Right_tr0_tr0() {
		return sCICorn.loadright;
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Right_tr1_tr1() {
		return sCIFerry.isRight == false && isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Right)
				&& sCIFerry.isRight == false;
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Right_tr2_ferryctrl_gameplay_region__sync5join_check() {
		return isStateActive(State.gameplay_region_Playing_State_wolf_region_Wolf_Right)
				&& isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Right);
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr0_tr0() {
		return sCICorn.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr1_tr1() {
		return sCICorn.loadright;
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Left_tr0_tr0() {
		return sCICorn.loadleft;
	}

	private boolean check_gameplay_region_Playing_State_corn_region_Corn_Left_tr1_tr1() {
		return sCIFerry.isLeft == false && isStateActive(State.gameplay_region_Playing_State_goose_region_Goose_Left)
				&& sCIFerry.isLeft == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_0_tr0_tr0() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_0_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_1_tr1_tr1() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_1_tr0_tr0() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_2_tr1_tr1() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_2_tr0_tr0() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_3_tr0_tr0() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_wolf_region__choice_3_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_0_tr1_tr1() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_0_tr0_tr0() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_1_tr0_tr0() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_1_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_2_tr1_tr1() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_2_tr0_tr0() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_3_tr0_tr0() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_goose_region__choice_3_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_0_tr0_tr0() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_0_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_1_tr0_tr0() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_1_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_2_tr0_tr0() {
		return sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_2_tr1_tr1() {
		return true;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_3_tr1_tr1() {
		return sCIFerry.full == false && sCIFerry.moving == false;
	}

	private boolean check_gameplay_region_Playing_State_corn_region__choice_3_tr0_tr0() {
		return true;
	}

	private void effect__lr0() {
		sCInterface.operationCallback.synchronize();
	}

	private void effect_main_region_Stop___Safe_tr0() {
		exitSequence_main_region_Stop___Safe();

		enterSequence_main_region_Moving_Left_default();
	}

	private void effect_main_region_Stop___Safe_tr1() {
		exitSequence_main_region_Stop___Safe();

		enterSequence_main_region_Moving_Right_default();
	}

	private void effect_main_region_Stopped_Left_tr0() {
		exitSequence_main_region_Stopped_Left();

		enterSequence_main_region_Moving_Right_default();
	}

	private void effect_main_region_StoppedRight_tr0() {
		exitSequence_main_region_StoppedRight();

		enterSequence_main_region_Moving_Left_default();
	}

	private void effect_main_region_Moving_Right_tr0() {
		exitSequence_main_region_Moving_Right();

		enterSequence_main_region_Moving_Left_default();
	}

	private void effect_main_region_Moving_Right_tr1() {
		exitSequence_main_region_Moving_Right();

		enterSequence_main_region_StoppedRight_default();
	}

	private void effect_main_region_Moving_Left_tr0() {
		exitSequence_main_region_Moving_Left();

		enterSequence_main_region_Stopped_Left_default();
	}

	private void effect_main_region_Moving_Left_tr1() {
		exitSequence_main_region_Moving_Left();

		enterSequence_main_region_Moving_Right_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr0() {
		exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left();

		react_gameplay_region_Playing_State_wolf_region__choice_1();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync2();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr0() {
		exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();

		react_gameplay_region_Playing_State_wolf_region__choice_0();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr1() {
		exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();

		react_gameplay_region_Playing_State_wolf_region__choice_2();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr0() {
		exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right();

		react_gameplay_region_Playing_State_wolf_region__choice_3();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync4();
	}

	private void effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr2() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync5();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr0() {
		exitSequence_gameplay_region_Playing_State_goose_region_Goose_Left();

		react_gameplay_region_Playing_State_goose_region__choice_0();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync1();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr2() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync2();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr0() {
		exitSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard();

		react_gameplay_region_Playing_State_goose_region__choice_1();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr1() {
		exitSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard();

		react_gameplay_region_Playing_State_goose_region__choice_2();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr0() {
		exitSequence_gameplay_region_Playing_State_goose_region_Goose_Right();

		react_gameplay_region_Playing_State_goose_region__choice_3();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync3();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr2() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync4();
	}

	private void effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr3() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync5();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr0() {
		exitSequence_gameplay_region_Playing_State_corn_region_Corn_Right();

		react_gameplay_region_Playing_State_corn_region__choice_0();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync3();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr2() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync5();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr0() {
		exitSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard();

		react_gameplay_region_Playing_State_corn_region__choice_2();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr1() {
		exitSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard();

		react_gameplay_region_Playing_State_corn_region__choice_1();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Left_tr0() {
		exitSequence_gameplay_region_Playing_State_corn_region_Corn_Left();

		react_gameplay_region_Playing_State_corn_region__choice_3();
	}

	private void effect_gameplay_region_Playing_State_corn_region_Corn_Left_tr1() {
		exitSequence_gameplay_region_Playing_State();

		react_gameplay_region__sync1();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_0_tr0() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_0_tr1() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_1_tr1() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_1_tr0() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_2_tr1() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_2_tr0() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_3_tr0() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_wolf_region__choice_3_tr1() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_0_tr1() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_0_tr0() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Left_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_1_tr0() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Left_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_1_tr1() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_2_tr1() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Right_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_2_tr0() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_3_tr0() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_goose_region__choice_3_tr1() {
		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Right_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_0_tr0() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_0_tr1() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Right_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_1_tr0() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Right_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_1_tr1() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_2_tr0() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Left_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_2_tr1() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_3_tr1() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard_default();
	}

	private void effect_gameplay_region_Playing_State_corn_region__choice_3_tr0() {
		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Left_default();
	}

	/* Entry action for statechart 'ferryctrl'. */
	private void entryAction() {

		timer.setTimer(this, 0, 50, true);
	}

	/* Entry action for state 'Stop / Safe'. */
	private void entryAction_main_region_Stop___Safe() {
		sCIFerry.setIsLeft(true);
	}

	/* Entry action for state 'Stopped Left'. */
	private void entryAction_main_region_Stopped_Left() {
		sCIFerry.setIsLeft(true);

		sCIFerry.setMoving(false);
	}

	/* Entry action for state 'StoppedRight'. */
	private void entryAction_main_region_StoppedRight() {
		sCIFerry.setIsRight(true);

		sCIFerry.setMoving(false);
	}

	/* Entry action for state 'Moving Right'. */
	private void entryAction_main_region_Moving_Right() {
		sCIFerry.setIsLeft(false);

		sCIFerry.setMoving(true);
	}

	/* Entry action for state 'Moving Left'. */
	private void entryAction_main_region_Moving_Left() {
		sCIFerry.setIsRight(false);

		sCIFerry.setMoving(true);
	}

	/* Entry action for state 'Wolf Left'. */
	private void entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Left() {
		sCIFerry.setFull(false);
	}

	/* Entry action for state 'Wolf Onboard'. */
	private void entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Onboard() {
		sCIFerry.setFull(true);
	}

	/* Entry action for state 'Wolf Right'. */
	private void entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Right() {
		sCIFerry.setFull(false);
	}

	/* Entry action for state 'Goose Left'. */
	private void entryAction_gameplay_region_Playing_State_goose_region_Goose_Left() {
		sCIFerry.setFull(false);
	}

	/* Entry action for state 'Goose Onboard'. */
	private void entryAction_gameplay_region_Playing_State_goose_region_Goose_Onboard() {
		sCIFerry.setFull(true);
	}

	/* Entry action for state 'Goose Right'. */
	private void entryAction_gameplay_region_Playing_State_goose_region_Goose_Right() {
		sCIFerry.setFull(false);
	}

	/* Entry action for state 'Corn Right'. */
	private void entryAction_gameplay_region_Playing_State_corn_region_Corn_Right() {
		sCIFerry.setFull(false);
	}

	/* Entry action for state 'Corn Onboard'. */
	private void entryAction_gameplay_region_Playing_State_corn_region_Corn_Onboard() {
		sCIFerry.setFull(true);
	}

	/* Entry action for state 'Corn Left'. */
	private void entryAction_gameplay_region_Playing_State_corn_region_Corn_Left() {
		sCIFerry.setFull(false);
	}

	/* Exit action for state 'ferryctrl'. */
	private void exitAction() {
		timer.unsetTimer(this, 0);
	}

	/* 'default' enter sequence for state Stop / Safe */
	private void enterSequence_main_region_Stop___Safe_default() {
		entryAction_main_region_Stop___Safe();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Stop___Safe;
	}

	/* 'default' enter sequence for state Stopped Left */
	private void enterSequence_main_region_Stopped_Left_default() {
		entryAction_main_region_Stopped_Left();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Stopped_Left;
	}

	/* 'default' enter sequence for state StoppedRight */
	private void enterSequence_main_region_StoppedRight_default() {
		entryAction_main_region_StoppedRight();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StoppedRight;
	}

	/* 'default' enter sequence for state Moving Right */
	private void enterSequence_main_region_Moving_Right_default() {
		entryAction_main_region_Moving_Right();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Moving_Right;
	}

	/* 'default' enter sequence for state Moving Left */
	private void enterSequence_main_region_Moving_Left_default() {
		entryAction_main_region_Moving_Left();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Moving_Left;
	}

	/* 'default' enter sequence for state Wolf Left */
	private void enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left_default() {
		entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Left();

		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_Playing_State_wolf_region_Wolf_Left;
	}

	/* 'default' enter sequence for state Wolf Onboard */
	private void enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_default() {
		entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();

		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_Playing_State_wolf_region_Wolf_Onboard;
	}

	/* 'default' enter sequence for state Wolf Right */
	private void enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right_default() {
		entryAction_gameplay_region_Playing_State_wolf_region_Wolf_Right();

		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_Playing_State_wolf_region_Wolf_Right;
	}

	/* 'default' enter sequence for state Goose Left */
	private void enterSequence_gameplay_region_Playing_State_goose_region_Goose_Left_default() {
		entryAction_gameplay_region_Playing_State_goose_region_Goose_Left();

		nextStateIndex = 2;
		stateVector[2] = State.gameplay_region_Playing_State_goose_region_Goose_Left;
	}

	/* 'default' enter sequence for state Goose Onboard */
	private void enterSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard_default() {
		entryAction_gameplay_region_Playing_State_goose_region_Goose_Onboard();

		nextStateIndex = 2;
		stateVector[2] = State.gameplay_region_Playing_State_goose_region_Goose_Onboard;
	}

	/* 'default' enter sequence for state Goose Right */
	private void enterSequence_gameplay_region_Playing_State_goose_region_Goose_Right_default() {
		entryAction_gameplay_region_Playing_State_goose_region_Goose_Right();

		nextStateIndex = 2;
		stateVector[2] = State.gameplay_region_Playing_State_goose_region_Goose_Right;
	}

	/* 'default' enter sequence for state Corn Right */
	private void enterSequence_gameplay_region_Playing_State_corn_region_Corn_Right_default() {
		entryAction_gameplay_region_Playing_State_corn_region_Corn_Right();

		nextStateIndex = 3;
		stateVector[3] = State.gameplay_region_Playing_State_corn_region_Corn_Right;
	}

	/* 'default' enter sequence for state Corn Onboard */
	private void enterSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard_default() {
		entryAction_gameplay_region_Playing_State_corn_region_Corn_Onboard();

		nextStateIndex = 3;
		stateVector[3] = State.gameplay_region_Playing_State_corn_region_Corn_Onboard;
	}

	/* 'default' enter sequence for state Corn Left */
	private void enterSequence_gameplay_region_Playing_State_corn_region_Corn_Left_default() {
		entryAction_gameplay_region_Playing_State_corn_region_Corn_Left();

		nextStateIndex = 3;
		stateVector[3] = State.gameplay_region_Playing_State_corn_region_Corn_Left;
	}

	/* 'default' enter sequence for state End of Game */
	private void enterSequence_gameplay_region_End_of_Game_default() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_default();
	}

	/* 'lost_gc' enter sequence for state End of Game */
	private void enterSequence_gameplay_region_End_of_Game_lost_gc() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_lost_gc();
	}

	/* 'lost_gw' enter sequence for state End of Game */
	private void enterSequence_gameplay_region_End_of_Game_lost_gw() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_lost_gw();
	}

	/* 'default' enter sequence for state Win */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_Win_default() {
		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_End_of_Game_endgame_region_Win;
	}

	/* 'default' enter sequence for state Lost Goose Corn */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn_default() {
		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn;
	}

	/* 'default' enter sequence for state Lost Wolf Goose */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose_default() {
		nextStateIndex = 1;
		stateVector[1] = State.gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region gameplay region */
	private void enterSequence_gameplay_region_default() {
		react_gameplay_region__entry_Default();
	}

	/* 'lost_gc' enter sequence for region endgame region */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_lost_gc() {
		react_gameplay_region_End_of_Game_endgame_region_lost_gc();
	}

	/* 'default' enter sequence for region endgame region */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_default() {
		react_gameplay_region_End_of_Game_endgame_region__entry_Default();
	}

	/* 'lost_gw' enter sequence for region endgame region */
	private void enterSequence_gameplay_region_End_of_Game_endgame_region_lost_gw() {
		react_gameplay_region_End_of_Game_endgame_region_lost_gw();
	}

	/* Default exit sequence for state Stop / Safe */
	private void exitSequence_main_region_Stop___Safe() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Stopped Left */
	private void exitSequence_main_region_Stopped_Left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StoppedRight */
	private void exitSequence_main_region_StoppedRight() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Moving Right */
	private void exitSequence_main_region_Moving_Right() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Moving Left */
	private void exitSequence_main_region_Moving_Left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Playing State */
	private void exitSequence_gameplay_region_Playing_State() {
		exitSequence_gameplay_region_Playing_State_wolf_region();

		exitSequence_gameplay_region_Playing_State_goose_region();

		exitSequence_gameplay_region_Playing_State_corn_region();
	}

	/* Default exit sequence for state Wolf Left */
	private void exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Wolf Onboard */
	private void exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Wolf Right */
	private void exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Goose Left */
	private void exitSequence_gameplay_region_Playing_State_goose_region_Goose_Left() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Goose Onboard */
	private void exitSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Goose Right */
	private void exitSequence_gameplay_region_Playing_State_goose_region_Goose_Right() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Corn Right */
	private void exitSequence_gameplay_region_Playing_State_corn_region_Corn_Right() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state Corn Onboard */
	private void exitSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state Corn Left */
	private void exitSequence_gameplay_region_Playing_State_corn_region_Corn_Left() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state Win */
	private void exitSequence_gameplay_region_End_of_Game_endgame_region_Win() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Lost Goose Corn */
	private void exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Lost Wolf Goose */
	private void exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_Stop___Safe :
				exitSequence_main_region_Stop___Safe();
				break;

			case main_region_Stopped_Left :
				exitSequence_main_region_Stopped_Left();
				break;

			case main_region_StoppedRight :
				exitSequence_main_region_StoppedRight();
				break;

			case main_region_Moving_Right :
				exitSequence_main_region_Moving_Right();
				break;

			case main_region_Moving_Left :
				exitSequence_main_region_Moving_Left();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region gameplay region */
	private void exitSequence_gameplay_region() {
		switch (stateVector[1]) {
			case gameplay_region_Playing_State_wolf_region_Wolf_Left :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left();
				break;

			case gameplay_region_Playing_State_wolf_region_Wolf_Onboard :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();
				break;

			case gameplay_region_Playing_State_wolf_region_Wolf_Right :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right();
				break;

			case gameplay_region_End_of_Game_endgame_region_Win :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Win();
				break;

			case gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn();
				break;

			case gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose();
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case gameplay_region_Playing_State_goose_region_Goose_Left :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Left();
				break;

			case gameplay_region_Playing_State_goose_region_Goose_Onboard :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard();
				break;

			case gameplay_region_Playing_State_goose_region_Goose_Right :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Right();
				break;

			default :
				break;
		}

		switch (stateVector[3]) {
			case gameplay_region_Playing_State_corn_region_Corn_Right :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Right();
				break;

			case gameplay_region_Playing_State_corn_region_Corn_Onboard :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard();
				break;

			case gameplay_region_Playing_State_corn_region_Corn_Left :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Left();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region wolf region */
	private void exitSequence_gameplay_region_Playing_State_wolf_region() {
		switch (stateVector[1]) {
			case gameplay_region_Playing_State_wolf_region_Wolf_Left :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left();
				break;

			case gameplay_region_Playing_State_wolf_region_Wolf_Onboard :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();
				break;

			case gameplay_region_Playing_State_wolf_region_Wolf_Right :
				exitSequence_gameplay_region_Playing_State_wolf_region_Wolf_Right();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region goose region */
	private void exitSequence_gameplay_region_Playing_State_goose_region() {
		switch (stateVector[2]) {
			case gameplay_region_Playing_State_goose_region_Goose_Left :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Left();
				break;

			case gameplay_region_Playing_State_goose_region_Goose_Onboard :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Onboard();
				break;

			case gameplay_region_Playing_State_goose_region_Goose_Right :
				exitSequence_gameplay_region_Playing_State_goose_region_Goose_Right();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region corn region */
	private void exitSequence_gameplay_region_Playing_State_corn_region() {
		switch (stateVector[3]) {
			case gameplay_region_Playing_State_corn_region_Corn_Right :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Right();
				break;

			case gameplay_region_Playing_State_corn_region_Corn_Onboard :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Onboard();
				break;

			case gameplay_region_Playing_State_corn_region_Corn_Left :
				exitSequence_gameplay_region_Playing_State_corn_region_Corn_Left();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region endgame region */
	private void exitSequence_gameplay_region_End_of_Game_endgame_region() {
		switch (stateVector[1]) {
			case gameplay_region_End_of_Game_endgame_region_Win :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Win();
				break;

			case gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn();
				break;

			case gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose :
				exitSequence_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Stop / Safe. */
	private void react_main_region_Stop___Safe() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_Stop___Safe_tr0_tr0()) {
			effect_main_region_Stop___Safe_tr0();
		} else {
			if (check_main_region_Stop___Safe_tr1_tr1()) {
				effect_main_region_Stop___Safe_tr1();
			}
		}
	}

	/* The reactions of state Stopped Left. */
	private void react_main_region_Stopped_Left() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_Stopped_Left_tr0_tr0()) {
			effect_main_region_Stopped_Left_tr0();
		}
	}

	/* The reactions of state StoppedRight. */
	private void react_main_region_StoppedRight() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_StoppedRight_tr0_tr0()) {
			effect_main_region_StoppedRight_tr0();
		}
	}

	/* The reactions of state Moving Right. */
	private void react_main_region_Moving_Right() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_Moving_Right_tr0_tr0()) {
			effect_main_region_Moving_Right_tr0();
		} else {
			if (check_main_region_Moving_Right_tr1_tr1()) {
				effect_main_region_Moving_Right_tr1();
			}
		}
	}

	/* The reactions of state Moving Left. */
	private void react_main_region_Moving_Left() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_Moving_Left_tr0_tr0()) {
			effect_main_region_Moving_Left_tr0();
		} else {
			if (check_main_region_Moving_Left_tr1_tr1()) {
				effect_main_region_Moving_Left_tr1();
			}
		}
	}

	/* The reactions of state Wolf Left. */
	private void react_gameplay_region_Playing_State_wolf_region_Wolf_Left() {
		if (check_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr0_tr0()) {
			effect_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr0();
		} else {
			if (check_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr1_tr1()) {
				effect_gameplay_region_Playing_State_wolf_region_Wolf_Left_tr1();
			}
		}
	}

	/* The reactions of state Wolf Onboard. */
	private void react_gameplay_region_Playing_State_wolf_region_Wolf_Onboard() {
		if (check_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr0_tr0()) {
			effect_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr0();
		} else {
			if (check_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr1_tr1()) {
				effect_gameplay_region_Playing_State_wolf_region_Wolf_Onboard_tr1();
			}
		}
	}

	/* The reactions of state Wolf Right. */
	private void react_gameplay_region_Playing_State_wolf_region_Wolf_Right() {
		if (check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr0_tr0()) {
			effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr0();
		} else {
			if (check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr1_tr1()) {
				effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr1();
			} else {
				if (check_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr2_ferryctrl_gameplay_region__sync5join_check()) {
					effect_gameplay_region_Playing_State_wolf_region_Wolf_Right_tr2();
				}
			}
		}
	}

	/* The reactions of state Goose Left. */
	private void react_gameplay_region_Playing_State_goose_region_Goose_Left() {
		if (check_gameplay_region_Playing_State_goose_region_Goose_Left_tr0_tr0()) {
			effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr0();
		} else {
			if (check_gameplay_region_Playing_State_goose_region_Goose_Left_tr1_tr1()) {
				effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr1();
			} else {
				if (check_gameplay_region_Playing_State_goose_region_Goose_Left_tr2_tr2()) {
					effect_gameplay_region_Playing_State_goose_region_Goose_Left_tr2();
				}
			}
		}
	}

	/* The reactions of state Goose Onboard. */
	private void react_gameplay_region_Playing_State_goose_region_Goose_Onboard() {
		if (check_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr0_tr0()) {
			effect_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr0();
		} else {
			if (check_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr1_tr1()) {
				effect_gameplay_region_Playing_State_goose_region_Goose_Onboard_tr1();
			}
		}
	}

	/* The reactions of state Goose Right. */
	private void react_gameplay_region_Playing_State_goose_region_Goose_Right() {
		if (check_gameplay_region_Playing_State_goose_region_Goose_Right_tr0_tr0()) {
			effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr0();
		} else {
			if (check_gameplay_region_Playing_State_goose_region_Goose_Right_tr1_tr1()) {
				effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr1();
			} else {
				if (check_gameplay_region_Playing_State_goose_region_Goose_Right_tr2_tr2()) {
					effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr2();
				} else {
					if (check_gameplay_region_Playing_State_goose_region_Goose_Right_tr3_ferryctrl_gameplay_region__sync5join_check()) {
						effect_gameplay_region_Playing_State_goose_region_Goose_Right_tr3();
					}
				}
			}
		}
	}

	/* The reactions of state Corn Right. */
	private void react_gameplay_region_Playing_State_corn_region_Corn_Right() {
		if (check_gameplay_region_Playing_State_corn_region_Corn_Right_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr0();
		} else {
			if (check_gameplay_region_Playing_State_corn_region_Corn_Right_tr1_tr1()) {
				effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr1();
			} else {
				if (check_gameplay_region_Playing_State_corn_region_Corn_Right_tr2_ferryctrl_gameplay_region__sync5join_check()) {
					effect_gameplay_region_Playing_State_corn_region_Corn_Right_tr2();
				}
			}
		}
	}

	/* The reactions of state Corn Onboard. */
	private void react_gameplay_region_Playing_State_corn_region_Corn_Onboard() {
		if (check_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr0();
		} else {
			if (check_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr1_tr1()) {
				effect_gameplay_region_Playing_State_corn_region_Corn_Onboard_tr1();
			}
		}
	}

	/* The reactions of state Corn Left. */
	private void react_gameplay_region_Playing_State_corn_region_Corn_Left() {
		if (check_gameplay_region_Playing_State_corn_region_Corn_Left_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region_Corn_Left_tr0();
		} else {
			if (check_gameplay_region_Playing_State_corn_region_Corn_Left_tr1_tr1()) {
				effect_gameplay_region_Playing_State_corn_region_Corn_Left_tr1();
			}
		}
	}

	/* The reactions of state Win. */
	private void react_gameplay_region_End_of_Game_endgame_region_Win() {
	}

	/* The reactions of state Lost Goose Corn. */
	private void react_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn() {
	}

	/* The reactions of state Lost Wolf Goose. */
	private void react_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose() {
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_wolf_region__choice_0() {
		if (check_gameplay_region_Playing_State_wolf_region__choice_0_tr0_tr0()) {
			effect_gameplay_region_Playing_State_wolf_region__choice_0_tr0();
		} else {
			effect_gameplay_region_Playing_State_wolf_region__choice_0_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_wolf_region__choice_1() {
		if (check_gameplay_region_Playing_State_wolf_region__choice_1_tr1_tr1()) {
			effect_gameplay_region_Playing_State_wolf_region__choice_1_tr1();
		} else {
			effect_gameplay_region_Playing_State_wolf_region__choice_1_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_wolf_region__choice_2() {
		if (check_gameplay_region_Playing_State_wolf_region__choice_2_tr1_tr1()) {
			effect_gameplay_region_Playing_State_wolf_region__choice_2_tr1();
		} else {
			effect_gameplay_region_Playing_State_wolf_region__choice_2_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_wolf_region__choice_3() {
		if (check_gameplay_region_Playing_State_wolf_region__choice_3_tr0_tr0()) {
			effect_gameplay_region_Playing_State_wolf_region__choice_3_tr0();
		} else {
			effect_gameplay_region_Playing_State_wolf_region__choice_3_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_goose_region__choice_0() {
		if (check_gameplay_region_Playing_State_goose_region__choice_0_tr1_tr1()) {
			effect_gameplay_region_Playing_State_goose_region__choice_0_tr1();
		} else {
			effect_gameplay_region_Playing_State_goose_region__choice_0_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_goose_region__choice_1() {
		if (check_gameplay_region_Playing_State_goose_region__choice_1_tr0_tr0()) {
			effect_gameplay_region_Playing_State_goose_region__choice_1_tr0();
		} else {
			effect_gameplay_region_Playing_State_goose_region__choice_1_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_goose_region__choice_2() {
		if (check_gameplay_region_Playing_State_goose_region__choice_2_tr1_tr1()) {
			effect_gameplay_region_Playing_State_goose_region__choice_2_tr1();
		} else {
			effect_gameplay_region_Playing_State_goose_region__choice_2_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_goose_region__choice_3() {
		if (check_gameplay_region_Playing_State_goose_region__choice_3_tr0_tr0()) {
			effect_gameplay_region_Playing_State_goose_region__choice_3_tr0();
		} else {
			effect_gameplay_region_Playing_State_goose_region__choice_3_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_corn_region__choice_0() {
		if (check_gameplay_region_Playing_State_corn_region__choice_0_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region__choice_0_tr0();
		} else {
			effect_gameplay_region_Playing_State_corn_region__choice_0_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_corn_region__choice_1() {
		if (check_gameplay_region_Playing_State_corn_region__choice_1_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region__choice_1_tr0();
		} else {
			effect_gameplay_region_Playing_State_corn_region__choice_1_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_corn_region__choice_2() {
		if (check_gameplay_region_Playing_State_corn_region__choice_2_tr0_tr0()) {
			effect_gameplay_region_Playing_State_corn_region__choice_2_tr0();
		} else {
			effect_gameplay_region_Playing_State_corn_region__choice_2_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_gameplay_region_Playing_State_corn_region__choice_3() {
		if (check_gameplay_region_Playing_State_corn_region__choice_3_tr1_tr1()) {
			effect_gameplay_region_Playing_State_corn_region__choice_3_tr1();
		} else {
			effect_gameplay_region_Playing_State_corn_region__choice_3_tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Stop___Safe_default();
	}

	/* Default react sequence for initial entry  */
	private void react_gameplay_region__entry_Default() {
		react_gameplay_region__sync0();
	}

	/* Default react sequence for initial entry lost_gc */
	private void react_gameplay_region_End_of_Game_endgame_region_lost_gc() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn_default();
	}

	/* Default react sequence for initial entry  */
	private void react_gameplay_region_End_of_Game_endgame_region__entry_Default() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_Win_default();
	}

	/* Default react sequence for initial entry lost_gw */
	private void react_gameplay_region_End_of_Game_endgame_region_lost_gw() {
		enterSequence_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose_default();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync0() {
		enterSequence_gameplay_region_Playing_State_wolf_region_Wolf_Left_default();

		enterSequence_gameplay_region_Playing_State_goose_region_Goose_Left_default();

		enterSequence_gameplay_region_Playing_State_corn_region_Corn_Left_default();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync1() {
		enterSequence_gameplay_region_End_of_Game_lost_gc();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync2() {
		enterSequence_gameplay_region_End_of_Game_lost_gw();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync3() {
		enterSequence_gameplay_region_End_of_Game_lost_gc();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync4() {
		enterSequence_gameplay_region_End_of_Game_lost_gw();
	}

	/* The reactions of state null. */
	private void react_gameplay_region__sync5() {
		enterSequence_gameplay_region_End_of_Game_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Stop___Safe :
					react_main_region_Stop___Safe();
					break;
				case main_region_Stopped_Left :
					react_main_region_Stopped_Left();
					break;
				case main_region_StoppedRight :
					react_main_region_StoppedRight();
					break;
				case main_region_Moving_Right :
					react_main_region_Moving_Right();
					break;
				case main_region_Moving_Left :
					react_main_region_Moving_Left();
					break;
				case gameplay_region_Playing_State_wolf_region_Wolf_Left :
					react_gameplay_region_Playing_State_wolf_region_Wolf_Left();
					break;
				case gameplay_region_Playing_State_wolf_region_Wolf_Onboard :
					react_gameplay_region_Playing_State_wolf_region_Wolf_Onboard();
					break;
				case gameplay_region_Playing_State_wolf_region_Wolf_Right :
					react_gameplay_region_Playing_State_wolf_region_Wolf_Right();
					break;
				case gameplay_region_Playing_State_goose_region_Goose_Left :
					react_gameplay_region_Playing_State_goose_region_Goose_Left();
					break;
				case gameplay_region_Playing_State_goose_region_Goose_Onboard :
					react_gameplay_region_Playing_State_goose_region_Goose_Onboard();
					break;
				case gameplay_region_Playing_State_goose_region_Goose_Right :
					react_gameplay_region_Playing_State_goose_region_Goose_Right();
					break;
				case gameplay_region_Playing_State_corn_region_Corn_Right :
					react_gameplay_region_Playing_State_corn_region_Corn_Right();
					break;
				case gameplay_region_Playing_State_corn_region_Corn_Onboard :
					react_gameplay_region_Playing_State_corn_region_Corn_Onboard();
					break;
				case gameplay_region_Playing_State_corn_region_Corn_Left :
					react_gameplay_region_Playing_State_corn_region_Corn_Left();
					break;
				case gameplay_region_End_of_Game_endgame_region_Win :
					react_gameplay_region_End_of_Game_endgame_region_Win();
					break;
				case gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn :
					react_gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn();
					break;
				case gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose :
					react_gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
