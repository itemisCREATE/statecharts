package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;

public class TimeFramingDynamicNotationHandler extends
		ExecutionPathDynamicNotationHandler {

	enum OnOff { On, Off };
	
	Map<EObject, List<OnOff>> changesMap = new HashMap<EObject, List<OnOff>>();

	@Override
	public void visualizeStep(TraceBeginRunCycle trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}

	@Override
	public void visualizeStep(TraceEndRunCycle trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}

	@Override
	public void visualizeStep(TraceStateEntered trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}

	@Override
	public void visualizeStep(TraceStateExited trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}

	@Override
	public void visualizeStep(ReactionFired trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}

	@Override
	public void visualizeStep(TraceNodeExecuted trace) {
		// TODO Auto-generated method stub
		super.visualizeStep(trace);
	}
	
	
	
}
