package org.yakindu.sct.core.simulation;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.core.simulation.extensions.Extensions;
import org.yakindu.sct.core.simulation.extensions.IExtensionPoints;

/**
 * 
 * @author andreas muelder
 * 
 */
public class SGraphSimulationSessionRegistry implements IExtensionPoints {

	public static final SGraphSimulationSessionRegistry INSTANCE = new SGraphSimulationSessionRegistry();

	private List<SGraphSimulationSession> sessions;

	private SGraphSimulationSessionRegistry() {
		sessions = new ArrayList<SGraphSimulationSession>();
	}

	public void registerSimulationSession(SGraphSimulationSession session) {
		session.getListeners().addAll(getListeners());
		sessions.add(session);

	}

	protected List<ISimulationSessionListener> getListeners() {
		Extensions<ISimulationSessionListener> extensions = new Extensions<ISimulationSessionListener>(
				SESSION_LISTENER);
		return extensions.getExtensions();
	}

	public SGraphSimulationSession getActiveSession() {
		if (sessions.isEmpty())
			return null;
		return sessions.get(0);
	}

}
