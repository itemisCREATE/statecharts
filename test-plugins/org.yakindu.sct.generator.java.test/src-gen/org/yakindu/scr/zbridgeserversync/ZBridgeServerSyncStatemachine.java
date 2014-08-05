package org.yakindu.scr.zbridgeserversync;

public class ZBridgeServerSyncStatemachine
		implements
			IZBridgeServerSyncStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean attemptSync;

		private long attemptSyncValue;

		public void raiseAttemptSync(long value) {
			attemptSync = true;
			attemptSyncValue = value;
		}

		private long getAttemptSyncValue() {
			if (!attemptSync)
				throw new IllegalStateException(
						"Illegal event value acces. Event AttemptSync is not raised!");
			return attemptSyncValue;
		}

		private boolean continue_ID;

		public void raiseContinue() {
			continue_ID = true;
		}

		private boolean sendAttemptSync;

		private long sendAttemptSyncValue;

		public boolean isRaisedSendAttemptSync() {
			return sendAttemptSync;
		}

		private void raiseSendAttemptSync(long value) {
			sendAttemptSync = true;
			sendAttemptSyncValue = value;
		}

		public long getSendAttemptSyncValue() {
			if (!sendAttemptSync)
				throw new IllegalStateException(
						"Illegal event value acces. Event SendAttemptSync is not raised!");
			return sendAttemptSyncValue;
		}

		private boolean sendAttemptSyncAll;

		public boolean isRaisedSendAttemptSyncAll() {
			return sendAttemptSyncAll;
		}

		private void raiseSendAttemptSyncAll() {
			sendAttemptSyncAll = true;
		}

		private boolean sendConfirmSync;

		public boolean isRaisedSendConfirmSync() {
			return sendConfirmSync;
		}

		private void raiseSendConfirmSync() {
			sendConfirmSync = true;
		}

		private boolean confirmSync;

		private long confirmSyncValue;

		public void raiseConfirmSync(long value) {
			confirmSync = true;
			confirmSyncValue = value;
		}

		private long getConfirmSyncValue() {
			if (!confirmSync)
				throw new IllegalStateException(
						"Illegal event value acces. Event ConfirmSync is not raised!");
			return confirmSyncValue;
		}

		private boolean sendAllSync;

		public boolean isRaisedSendAllSync() {
			return sendAllSync;
		}

		private void raiseSendAllSync() {
			sendAllSync = true;
		}

		public void clearEvents() {
			attemptSync = false;
			continue_ID = false;
			confirmSync = false;
		}

		public void clearOutEvents() {
			sendAttemptSync = false;
			sendAttemptSyncAll = false;
			sendConfirmSync = false;
			sendAllSync = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		entry_SynChronizeServer, entry_SynChronizeServer_West_WaitForAttemptSync, entry_SynChronizeServer_West_waitForConfirmSync, entry_SynChronizeServer_North_WaitForAttemptSync, entry_SynChronizeServer_North_waitForConfirmSync, entry_SynChronizeServer_East_WaitForAttemptSync, entry_SynChronizeServer_East_waitForConfirmSync, entry_SynChronizeServer_South_WaitForAttemptSync, entry_SynChronizeServer_South_waitForConfirmSync, entry_ClientConfirm, entry_ClientConfirm_West_WaitForConfirmSync, entry_ClientConfirm_West_WaitForSync, entry_ClientConfirm_North_WaitForConfirmSync, entry_ClientConfirm_North_WaitForSync, entry_ClientConfirm_East_WaitForConfirmSync, entry_ClientConfirm_East_WaitForSync, entry_ClientConfirm_South_WaitForConfirmSync, entry_ClientConfirm_South_WaitForSync, entry__final_, entry_AttemptSync, $NullState$
	};

	private long w;
	private long n;
	private long e;
	private long s;
	private boolean confirmWest;
	private boolean confirmNorth;
	private boolean confirmEast;
	private boolean confirmSouth;

	private final State[] stateVector = new State[4];

	private int nextStateIndex;

	public ZBridgeServerSyncStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 4; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		w = 0;

		n = 1;

		e = 2;

		s = 3;

		confirmWest = false;

		confirmNorth = false;

		confirmEast = false;

		confirmSouth = false;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.entry_AttemptSync;
	}

	public void exit() {
		switch (stateVector[0]) {
			case entry_SynChronizeServer_West_WaitForAttemptSync :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case entry_SynChronizeServer_West_waitForConfirmSync :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case entry_ClientConfirm_West_WaitForConfirmSync :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case entry_ClientConfirm_West_WaitForSync :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case entry__final_ :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case entry_AttemptSync :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case entry_SynChronizeServer_North_WaitForAttemptSync :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case entry_SynChronizeServer_North_waitForConfirmSync :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case entry_ClientConfirm_North_WaitForConfirmSync :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case entry_ClientConfirm_North_WaitForSync :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case entry_SynChronizeServer_East_WaitForAttemptSync :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case entry_SynChronizeServer_East_waitForConfirmSync :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case entry_ClientConfirm_East_WaitForConfirmSync :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case entry_ClientConfirm_East_WaitForSync :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[3]) {
			case entry_SynChronizeServer_South_WaitForAttemptSync :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			case entry_SynChronizeServer_South_waitForConfirmSync :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			case entry_ClientConfirm_South_WaitForConfirmSync :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			case entry_ClientConfirm_South_WaitForSync :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCInterface.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case entry_SynChronizeServer :
				return stateVector[0].ordinal() >= State.entry_SynChronizeServer
						.ordinal()
						&& stateVector[0].ordinal() <= State.entry_SynChronizeServer_South_waitForConfirmSync
								.ordinal();
			case entry_SynChronizeServer_West_WaitForAttemptSync :
				return stateVector[0] == State.entry_SynChronizeServer_West_WaitForAttemptSync;
			case entry_SynChronizeServer_West_waitForConfirmSync :
				return stateVector[0] == State.entry_SynChronizeServer_West_waitForConfirmSync;
			case entry_SynChronizeServer_North_WaitForAttemptSync :
				return stateVector[1] == State.entry_SynChronizeServer_North_WaitForAttemptSync;
			case entry_SynChronizeServer_North_waitForConfirmSync :
				return stateVector[1] == State.entry_SynChronizeServer_North_waitForConfirmSync;
			case entry_SynChronizeServer_East_WaitForAttemptSync :
				return stateVector[2] == State.entry_SynChronizeServer_East_WaitForAttemptSync;
			case entry_SynChronizeServer_East_waitForConfirmSync :
				return stateVector[2] == State.entry_SynChronizeServer_East_waitForConfirmSync;
			case entry_SynChronizeServer_South_WaitForAttemptSync :
				return stateVector[3] == State.entry_SynChronizeServer_South_WaitForAttemptSync;
			case entry_SynChronizeServer_South_waitForConfirmSync :
				return stateVector[3] == State.entry_SynChronizeServer_South_waitForConfirmSync;
			case entry_ClientConfirm :
				return stateVector[0].ordinal() >= State.entry_ClientConfirm
						.ordinal()
						&& stateVector[0].ordinal() <= State.entry_ClientConfirm_South_WaitForSync
								.ordinal();
			case entry_ClientConfirm_West_WaitForConfirmSync :
				return stateVector[0] == State.entry_ClientConfirm_West_WaitForConfirmSync;
			case entry_ClientConfirm_West_WaitForSync :
				return stateVector[0] == State.entry_ClientConfirm_West_WaitForSync;
			case entry_ClientConfirm_North_WaitForConfirmSync :
				return stateVector[1] == State.entry_ClientConfirm_North_WaitForConfirmSync;
			case entry_ClientConfirm_North_WaitForSync :
				return stateVector[1] == State.entry_ClientConfirm_North_WaitForSync;
			case entry_ClientConfirm_East_WaitForConfirmSync :
				return stateVector[2] == State.entry_ClientConfirm_East_WaitForConfirmSync;
			case entry_ClientConfirm_East_WaitForSync :
				return stateVector[2] == State.entry_ClientConfirm_East_WaitForSync;
			case entry_ClientConfirm_South_WaitForConfirmSync :
				return stateVector[3] == State.entry_ClientConfirm_South_WaitForConfirmSync;
			case entry_ClientConfirm_South_WaitForSync :
				return stateVector[3] == State.entry_ClientConfirm_South_WaitForSync;
			case entry__final_ :
				return stateVector[0] == State.entry__final_;
			case entry_AttemptSync :
				return stateVector[0] == State.entry_AttemptSync;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseAttemptSync(long value) {
		sCInterface.raiseAttemptSync(value);
	}
	public void raiseContinue() {
		sCInterface.raiseContinue();
	}
	public boolean isRaisedSendAttemptSync() {
		return sCInterface.isRaisedSendAttemptSync();
	}
	public long getSendAttemptSyncValue() {
		return sCInterface.getSendAttemptSyncValue();
	}
	public boolean isRaisedSendAttemptSyncAll() {
		return sCInterface.isRaisedSendAttemptSyncAll();
	}
	public boolean isRaisedSendConfirmSync() {
		return sCInterface.isRaisedSendConfirmSync();
	}
	public void raiseConfirmSync(long value) {
		sCInterface.raiseConfirmSync(value);
	}
	public boolean isRaisedSendAllSync() {
		return sCInterface.isRaisedSendAllSync();
	}

	/* Entry action for statechart 'ZBridgeServerSync'. */
	private void entryAction() {
	}

	/* Exit action for state 'ZBridgeServerSync'. */
	private void exitAction() {
	}

	/* The reactions of state WaitForAttemptSync. */
	private void reactEntry_SynChronizeServer_West_WaitForAttemptSync() {
		if (sCInterface.attemptSync && sCInterface.attemptSyncValue == w) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			confirmWest = true;

			sCInterface.raiseSendAttemptSync(w);

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendConfirmSync();
			}

			nextStateIndex = 0;
			stateVector[0] = State.entry_SynChronizeServer_West_waitForConfirmSync;
		}
	}

	/* The reactions of state waitForConfirmSync. */
	private void reactEntry_SynChronizeServer_West_waitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_North_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_East_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_South_waitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_SynChronizeServer_West_WaitForAttemptSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_SynChronizeServer_West_waitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_SynChronizeServer_North_WaitForAttemptSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_SynChronizeServer_North_waitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_SynChronizeServer_East_WaitForAttemptSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_SynChronizeServer_East_waitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_SynChronizeServer_South_WaitForAttemptSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_SynChronizeServer_South_waitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync0();
		}
	}

	/* The reactions of state WaitForAttemptSync. */
	private void reactEntry_SynChronizeServer_North_WaitForAttemptSync() {
		if (sCInterface.attemptSync && sCInterface.attemptSyncValue == n) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			confirmNorth = true;

			sCInterface.raiseSendAttemptSync(n);

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendConfirmSync();
			}

			nextStateIndex = 1;
			stateVector[1] = State.entry_SynChronizeServer_North_waitForConfirmSync;
		}
	}

	/* The reactions of state waitForConfirmSync. */
	private void reactEntry_SynChronizeServer_North_waitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_West_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_East_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_South_waitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_SynChronizeServer_West_WaitForAttemptSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_SynChronizeServer_West_waitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_SynChronizeServer_North_WaitForAttemptSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_SynChronizeServer_North_waitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_SynChronizeServer_East_WaitForAttemptSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_SynChronizeServer_East_waitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_SynChronizeServer_South_WaitForAttemptSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_SynChronizeServer_South_waitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync0();
		}
	}

	/* The reactions of state WaitForAttemptSync. */
	private void reactEntry_SynChronizeServer_East_WaitForAttemptSync() {
		if (sCInterface.attemptSync && sCInterface.attemptSyncValue == e) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			confirmEast = true;

			sCInterface.raiseSendAttemptSync(e);

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendConfirmSync();
			}

			nextStateIndex = 2;
			stateVector[2] = State.entry_SynChronizeServer_East_waitForConfirmSync;
		}
	}

	/* The reactions of state waitForConfirmSync. */
	private void reactEntry_SynChronizeServer_East_waitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_West_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_North_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_South_waitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_SynChronizeServer_West_WaitForAttemptSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_SynChronizeServer_West_waitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_SynChronizeServer_North_WaitForAttemptSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_SynChronizeServer_North_waitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_SynChronizeServer_East_WaitForAttemptSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_SynChronizeServer_East_waitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_SynChronizeServer_South_WaitForAttemptSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_SynChronizeServer_South_waitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync0();
		}
	}

	/* The reactions of state WaitForAttemptSync. */
	private void reactEntry_SynChronizeServer_South_WaitForAttemptSync() {
		if (sCInterface.attemptSync && sCInterface.attemptSyncValue == s) {
			nextStateIndex = 3;
			stateVector[3] = State.$NullState$;

			confirmSouth = true;

			sCInterface.raiseSendAttemptSync(s);

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendConfirmSync();
			}

			nextStateIndex = 3;
			stateVector[3] = State.entry_SynChronizeServer_South_waitForConfirmSync;
		}
	}

	/* The reactions of state waitForConfirmSync. */
	private void reactEntry_SynChronizeServer_South_waitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_West_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_North_waitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_SynChronizeServer_East_waitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_SynChronizeServer_West_WaitForAttemptSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_SynChronizeServer_West_waitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_SynChronizeServer_North_WaitForAttemptSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_SynChronizeServer_North_waitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_SynChronizeServer_East_WaitForAttemptSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_SynChronizeServer_East_waitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_SynChronizeServer_South_WaitForAttemptSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_SynChronizeServer_South_waitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync0();
		}
	}

	/* The reactions of state WaitForConfirmSync. */
	private void reactEntry_ClientConfirm_West_WaitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_North_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_East_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_South_WaitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_ClientConfirm_West_WaitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_ClientConfirm_West_WaitForSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_ClientConfirm_North_WaitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_ClientConfirm_North_WaitForSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_ClientConfirm_East_WaitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_ClientConfirm_East_WaitForSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_ClientConfirm_South_WaitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_ClientConfirm_South_WaitForSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync1();
		}
	}

	/* The reactions of state WaitForSync. */
	private void reactEntry_ClientConfirm_West_WaitForSync() {
		if (sCInterface.confirmSync && sCInterface.confirmSyncValue == w) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			confirmWest = true;

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendAllSync();
			}

			nextStateIndex = 0;
			stateVector[0] = State.entry_ClientConfirm_West_WaitForConfirmSync;
		}
	}

	/* The reactions of state WaitForConfirmSync. */
	private void reactEntry_ClientConfirm_North_WaitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_West_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_East_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_South_WaitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_ClientConfirm_West_WaitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_ClientConfirm_West_WaitForSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_ClientConfirm_North_WaitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_ClientConfirm_North_WaitForSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_ClientConfirm_East_WaitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_ClientConfirm_East_WaitForSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_ClientConfirm_South_WaitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_ClientConfirm_South_WaitForSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync1();
		}
	}

	/* The reactions of state WaitForSync. */
	private void reactEntry_ClientConfirm_North_WaitForSync() {
		if (sCInterface.confirmSync && sCInterface.confirmSyncValue == n) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			confirmNorth = true;

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendAllSync();
			}

			nextStateIndex = 1;
			stateVector[1] = State.entry_ClientConfirm_North_WaitForConfirmSync;
		}
	}

	/* The reactions of state WaitForConfirmSync. */
	private void reactEntry_ClientConfirm_East_WaitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_West_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_North_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_South_WaitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_ClientConfirm_West_WaitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_ClientConfirm_West_WaitForSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_ClientConfirm_North_WaitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_ClientConfirm_North_WaitForSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_ClientConfirm_East_WaitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_ClientConfirm_East_WaitForSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_ClientConfirm_South_WaitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_ClientConfirm_South_WaitForSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync1();
		}
	}

	/* The reactions of state WaitForSync. */
	private void reactEntry_ClientConfirm_East_WaitForSync() {
		if (sCInterface.confirmSync && sCInterface.confirmSyncValue == e) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			confirmEast = true;

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendAllSync();
			}

			nextStateIndex = 2;
			stateVector[2] = State.entry_ClientConfirm_East_WaitForConfirmSync;
		}
	}

	/* The reactions of state WaitForConfirmSync. */
	private void reactEntry_ClientConfirm_South_WaitForConfirmSync() {
		if (sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_West_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_North_WaitForConfirmSync)
				&& sCInterface.continue_ID
				&& isStateActive(State.entry_ClientConfirm_East_WaitForConfirmSync)
				&& sCInterface.continue_ID) {
			switch (stateVector[0]) {
				case entry_ClientConfirm_West_WaitForConfirmSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case entry_ClientConfirm_West_WaitForSync :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case entry_ClientConfirm_North_WaitForConfirmSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case entry_ClientConfirm_North_WaitForSync :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case entry_ClientConfirm_East_WaitForConfirmSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				case entry_ClientConfirm_East_WaitForSync :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[3]) {
				case entry_ClientConfirm_South_WaitForConfirmSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				case entry_ClientConfirm_South_WaitForSync :
					nextStateIndex = 3;
					stateVector[3] = State.$NullState$;
					break;

				default :
					break;
			}

			reactZBridgeServerSync_entry__sync1();
		}
	}

	/* The reactions of state WaitForSync. */
	private void reactEntry_ClientConfirm_South_WaitForSync() {
		if (sCInterface.confirmSync && sCInterface.confirmSyncValue == s) {
			nextStateIndex = 3;
			stateVector[3] = State.$NullState$;

			confirmSouth = true;

			if (confirmWest && confirmNorth && confirmEast && confirmSouth) {
				sCInterface.raiseSendAllSync();
			}

			nextStateIndex = 3;
			stateVector[3] = State.entry_ClientConfirm_South_WaitForConfirmSync;
		}
	}

	/* The reactions of state null. */
	private void reactEntry__final_0() {
	}

	/* The reactions of state AttemptSync. */
	private void reactEntry_AttemptSync() {
		if (sCInterface.continue_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.raiseSendAttemptSyncAll();

			nextStateIndex = 0;
			stateVector[0] = State.entry_SynChronizeServer_West_WaitForAttemptSync;

			nextStateIndex = 1;
			stateVector[1] = State.entry_SynChronizeServer_North_WaitForAttemptSync;

			nextStateIndex = 2;
			stateVector[2] = State.entry_SynChronizeServer_East_WaitForAttemptSync;

			nextStateIndex = 3;
			stateVector[3] = State.entry_SynChronizeServer_South_WaitForAttemptSync;
		}
	}

	/* The reactions of state null. */
	private void reactZBridgeServerSync_entry__sync0() {
		confirmWest = false;

		confirmNorth = false;

		confirmEast = false;

		confirmSouth = false;

		nextStateIndex = 0;
		stateVector[0] = State.entry_ClientConfirm_West_WaitForSync;

		nextStateIndex = 1;
		stateVector[1] = State.entry_ClientConfirm_North_WaitForSync;

		nextStateIndex = 2;
		stateVector[2] = State.entry_ClientConfirm_East_WaitForSync;

		nextStateIndex = 3;
		stateVector[3] = State.entry_ClientConfirm_South_WaitForSync;
	}

	/* The reactions of state null. */
	private void reactZBridgeServerSync_entry__sync1() {
		nextStateIndex = 0;
		stateVector[0] = State.entry__final_;
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case entry_SynChronizeServer_West_WaitForAttemptSync :
					reactEntry_SynChronizeServer_West_WaitForAttemptSync();
					break;
				case entry_SynChronizeServer_West_waitForConfirmSync :
					reactEntry_SynChronizeServer_West_waitForConfirmSync();
					break;
				case entry_SynChronizeServer_North_WaitForAttemptSync :
					reactEntry_SynChronizeServer_North_WaitForAttemptSync();
					break;
				case entry_SynChronizeServer_North_waitForConfirmSync :
					reactEntry_SynChronizeServer_North_waitForConfirmSync();
					break;
				case entry_SynChronizeServer_East_WaitForAttemptSync :
					reactEntry_SynChronizeServer_East_WaitForAttemptSync();
					break;
				case entry_SynChronizeServer_East_waitForConfirmSync :
					reactEntry_SynChronizeServer_East_waitForConfirmSync();
					break;
				case entry_SynChronizeServer_South_WaitForAttemptSync :
					reactEntry_SynChronizeServer_South_WaitForAttemptSync();
					break;
				case entry_SynChronizeServer_South_waitForConfirmSync :
					reactEntry_SynChronizeServer_South_waitForConfirmSync();
					break;
				case entry_ClientConfirm_West_WaitForConfirmSync :
					reactEntry_ClientConfirm_West_WaitForConfirmSync();
					break;
				case entry_ClientConfirm_West_WaitForSync :
					reactEntry_ClientConfirm_West_WaitForSync();
					break;
				case entry_ClientConfirm_North_WaitForConfirmSync :
					reactEntry_ClientConfirm_North_WaitForConfirmSync();
					break;
				case entry_ClientConfirm_North_WaitForSync :
					reactEntry_ClientConfirm_North_WaitForSync();
					break;
				case entry_ClientConfirm_East_WaitForConfirmSync :
					reactEntry_ClientConfirm_East_WaitForConfirmSync();
					break;
				case entry_ClientConfirm_East_WaitForSync :
					reactEntry_ClientConfirm_East_WaitForSync();
					break;
				case entry_ClientConfirm_South_WaitForConfirmSync :
					reactEntry_ClientConfirm_South_WaitForConfirmSync();
					break;
				case entry_ClientConfirm_South_WaitForSync :
					reactEntry_ClientConfirm_South_WaitForSync();
					break;
				case entry__final_ :
					reactEntry__final_0();
					break;
				case entry_AttemptSync :
					reactEntry_AttemptSync();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
