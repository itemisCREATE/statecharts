
package org.yakindu.sct.runtime.java.custom;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.yakindu.sct.runtime.java.base.DataType;
import org.yakindu.sct.runtime.java.base.IStatemachine;

public abstract class ExampleAbstractBaseStatemachine implements IStatemachine {

	public enum Event {
		
  		e1,
		
  		e2,
		
  		e3,
		
  		e4,
		
  		e5,
		
  		e6,
		
  		i1,
		
	};

	public enum State {
	      S1,
	      S2,
	      S3,
	      S4,
	    
	};

	private Set<State> activeStates = EnumSet.noneOf(State.class);


  
private bool condition_S1_tr0(Collection<Event> occuredEvents) {
  return (	 eventSet.check( ev_e1)  );
}
  

  
private bool condition_S2_tr0(Collection<Event> occuredEvents) {
  return (	 eventSet.check( ev_e2)  );
}
  

  
private bool condition_S3_tr0(Collection<Event> occuredEvents) {
  return (	 eventSet.check( ev_e3)  );
}
  

  
private bool condition_S4_tr0(Collection<Event> occuredEvents) {
  return (	 eventSet.check( ev_e4)  );
}
  



  
private void actions_S1_tr0() {
  
  
activeStates.remove(S1);

activeStates.add(S2);


}
  

  
private void actions_S2_tr0() {
  
  
activeStates.remove(S2);

activeStates.add(S1);


}
  

  
private void actions_S3_tr0() {
  
  
activeStates.remove(S3);

activeStates.add(S4);


}
  

  
private void actions_S4_tr0() {
  
  
activeStates.remove(S4);

activeStates.add(S3);


}
  



private void cycle_S1(Collection<Event> occuredEvents)
{
	 

if (    condition_S1_tr0(Collection<Event> occuredEvents) ) { 
  
actions_S1_tr0();

}
else {
  
}


}

private void cycle_S2(Collection<Event> occuredEvents)
{
	
}

private void cycle_S3(Collection<Event> occuredEvents)
{
	 

if (    condition_S3_tr0(Collection<Event> occuredEvents) ) { 
  
actions_S3_tr0();

}
else {
  
}


}

private void cycle_S4(Collection<Event> occuredEvents)
{
	 

if (    condition_S4_tr0(Collection<Event> occuredEvents) ) { 
  
actions_S4_tr0();

}
else {
  
}


}





















	
	public void init() {
		
activeStates.add(S1);

	}
	
	protected abstract Collection<Event> getOccuredEvents();

	public void raiseEvent(DataType event) {
		getOccuredEvents().add(Event.valueOf(event.getName()));
	}

	public boolean eventOccured(DataType event) {
		return getOccuredEvents().contains(Event.valueOf(event.getName()));
	}

	public boolean eventOccured() {
		return !getOccuredEvents().isEmpty();
	}

	public void runCycle(Collection<Event> events) {
		for (State state : activeStates) {
			switch (state) {
			
    		case S1:
        		cycle_S1(events);
        		break;
			
    		case S2:
        		cycle_S2(events);
        		break;
			
    		case S3:
        		cycle_S3(events);
        		break;
			
    		case S4:
        		cycle_S4(events);
        		break;
			
			default:
				// no state found
			}
		}
	}
}

