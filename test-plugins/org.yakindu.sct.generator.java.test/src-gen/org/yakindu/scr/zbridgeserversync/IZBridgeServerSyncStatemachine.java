package org.yakindu.scr.zbridgeserversync;
import org.yakindu.scr.IStatemachine;

public interface IZBridgeServerSyncStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseAttemptSync(long value);
		public void raiseContinue();
		public boolean isRaisedSendAttemptSync();
		public long getSendAttemptSyncValue();
		public boolean isRaisedSendAttemptSyncAll();
		public boolean isRaisedSendConfirmSync();
		public void raiseConfirmSync(long value);
		public boolean isRaisedSendAllSync();

	}

	public SCInterface getSCInterface();

}
