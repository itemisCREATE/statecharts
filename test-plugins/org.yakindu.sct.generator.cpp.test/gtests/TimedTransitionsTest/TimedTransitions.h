
#ifndef TIMEDTRANSITIONS_H_
#define TIMEDTRANSITIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"
#include "TimedStatemachineInterface.h"

/*! \file Header of the state machine 'TimedTransitions'.
*/

/*! Define indices of states in the StateConfVector */
#define SCVI_MAIN_REGION_START 0
#define SCVI_MAIN_REGION_END 0

class TimedTransitions : public TimedStatemachineInterface, public StatemachineInterface
{
	
	public:
		
		TimedTransitions();
		
		~TimedTransitions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			TimedTransitions_last_state,
			main_region_Start,
			main_region_End
		} TimedTransitionsStates;
		
		
		
		/*
		 * Functions inherited from StatemachineInterface
		 */
		virtual void init();
		
		virtual void enter();
		
		virtual void exit();
		
		virtual void runCycle();
		
		/*!
		* Checks if the state machine is active (until 2.4.1 this method was used for states).
		* A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
		*/
		virtual sc_boolean isActive() const;
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		*/
		virtual sc_boolean isFinal() const;
		
		/*
		 * Functions inherited from TimedStatemachineInterface
		 */
		virtual void setTimer(TimerInterface* timer);
		
		virtual TimerInterface* getTimer();
		
		virtual void raiseTimeEvent(sc_eventid event);
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(TimedTransitionsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Gets the value of the variable 'x' that is defined in the internal scope. */
				sc_integer get_x() const;
				
				/*! Sets the value of the variable 'x' that is defined in the internal scope. */
				void set_x(sc_integer value);
				
				/*! Gets the value of the variable 'y' that is defined in the internal scope. */
				sc_integer get_y() const;
				
				/*! Sets the value of the variable 'y' that is defined in the internal scope. */
				void set_y(sc_integer value);
				
				
			private:
				friend class TimedTransitions;
				sc_integer x;
				sc_integer y;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		//! number of time events used by the state machine.
		static const sc_integer timeEventsCount = 2;
		TimerInterface* timer;
		sc_boolean timeEvents[timeEventsCount];
		
		TimedTransitionsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check__lr0();
		sc_boolean check__lr1();
		sc_boolean check_main_region_Start_tr0_tr0();
		void effect__lr0();
		void effect__lr1();
		void effect_main_region_Start_tr0();
		void enact();
		void enact_main_region_Start();
		void exact();
		void exact_main_region_Start();
		void enseq_main_region_Start_default();
		void enseq_main_region_End_default();
		void enseq_main_region_default();
		void exseq_main_region_Start();
		void exseq_main_region_End();
		void exseq_main_region();
		void react_main_region_Start();
		void react_main_region_End();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* TIMEDTRANSITIONS_H_ */
