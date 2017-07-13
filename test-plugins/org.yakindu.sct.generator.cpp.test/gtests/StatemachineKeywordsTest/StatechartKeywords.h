
#ifndef STATECHARTKEYWORDS_H_
#define STATECHARTKEYWORDS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"
#include "TimedStatemachineInterface.h"

/*! \file Header of the state machine 'StatechartKeywords'.
*/

/*! Define indices of states in the StateConfVector */
#define SCVI_MAIN_REGION_TIMER 0

class StatechartKeywords : public TimedStatemachineInterface, public StatemachineInterface
{
	
	public:
		
		StatechartKeywords();
		
		~StatechartKeywords();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			StatechartKeywords_last_state,
			main_region_Timer
		} StatechartKeywordsStates;
		
		//! Inner class for if interface scope.
		class SCI_If
		{
			
			public:
				/*! Gets the value of the variable 'timer' that is defined in the interface scope 'if'. */
				sc_integer get_timer() const;
				
				/*! Sets the value of the variable 'timer' that is defined in the interface scope 'if'. */
				void set_timer(sc_integer value);
				
				/*! Gets the value of the variable 'isActive' that is defined in the interface scope 'if'. */
				sc_integer get_isActive() const;
				
				/*! Sets the value of the variable 'isActive' that is defined in the interface scope 'if'. */
				void set_isActive(sc_integer value);
				
				/*! Gets the value of the variable 'init' that is defined in the interface scope 'if'. */
				sc_integer get_init() const;
				
				/*! Sets the value of the variable 'init' that is defined in the interface scope 'if'. */
				void set_init(sc_integer value);
				
				/*! Gets the value of the variable 'enter' that is defined in the interface scope 'if'. */
				sc_integer get_enter() const;
				
				/*! Sets the value of the variable 'enter' that is defined in the interface scope 'if'. */
				void set_enter(sc_integer value);
				
				/*! Gets the value of the variable 'runCycle' that is defined in the interface scope 'if'. */
				sc_integer get_runCycle() const;
				
				/*! Sets the value of the variable 'runCycle' that is defined in the interface scope 'if'. */
				void set_runCycle(sc_integer value);
				
				/*! Checks if the out event 'operationCallback' that is defined in the interface scope 'if' has been raised. */
				sc_boolean isRaised_operationCallback() const;
				
				/*! Checks if the out event 'listeners' that is defined in the interface scope 'if' has been raised. */
				sc_boolean isRaised_listeners() const;
				
				
			private:
				friend class StatechartKeywords;
				sc_integer timer;
				sc_integer isActive;
				sc_integer init;
				sc_integer enter_ID;
				sc_integer runCycle_ID;
				sc_boolean operationCallback_raised;
				sc_boolean listeners_raised;
		};
				
				//! Inner class for if interface scope operation callbacks.
				class SCI_If_OCB
				{
					public:
						virtual ~SCI_If_OCB() = 0;
						
						virtual void myOperation() = 0;
				};
				
				/*! Set the working instance of the operation callback interface 'SCI_If_OCB'. */
				void setSCI_If_OCB(SCI_If_OCB* operationCallback);
		
		/*! Returns an instance of the interface class 'SCI_If'. */
		SCI_If* getSCI_If();
		
		
		//! Inner class for internal interface scope operation callbacks.
		class InternalSCI_OCB
		{
			public:
				virtual ~InternalSCI_OCB() = 0;
				
				virtual void myOperation() = 0;
		};
		
		/*! Set the working instance of the operation callback interface 'InternalSCI_OCB'. */
		void setInternalSCI_OCB(InternalSCI_OCB* operationCallback);
		
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
		sc_boolean isStateActive(StatechartKeywordsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Gets the value of the variable 'timer' that is defined in the internal scope. */
				sc_integer get_timer() const;
				
				/*! Sets the value of the variable 'timer' that is defined in the internal scope. */
				void set_timer(sc_integer value);
				
				/*! Gets the value of the variable 'isActive' that is defined in the internal scope. */
				sc_integer get_isActive() const;
				
				/*! Sets the value of the variable 'isActive' that is defined in the internal scope. */
				void set_isActive(sc_integer value);
				
				/*! Gets the value of the variable 'init' that is defined in the internal scope. */
				sc_integer get_init() const;
				
				/*! Sets the value of the variable 'init' that is defined in the internal scope. */
				void set_init(sc_integer value);
				
				/*! Gets the value of the variable 'enter' that is defined in the internal scope. */
				sc_integer get_enter() const;
				
				/*! Sets the value of the variable 'enter' that is defined in the internal scope. */
				void set_enter(sc_integer value);
				
				/*! Gets the value of the variable 'runCycle' that is defined in the internal scope. */
				sc_integer get_runCycle() const;
				
				/*! Sets the value of the variable 'runCycle' that is defined in the internal scope. */
				void set_runCycle(sc_integer value);
				
				/*! Gets the value of the variable 'sCIIf' that is defined in the internal scope. */
				sc_integer get_sCIIf() const;
				
				/*! Sets the value of the variable 'sCIIf' that is defined in the internal scope. */
				void set_sCIIf(sc_integer value);
				
				/*! Raises the in event 'operationCallback' that is defined in the internal scope. */
				void raise_operationCallback();
				
				/*! Checks if the out event 'operationCallback' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_operationCallback() const;
				
				/*! Raises the in event 'listeners' that is defined in the internal scope. */
				void raise_listeners();
				
				/*! Checks if the out event 'listeners' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_listeners() const;
				
				
			private:
				friend class StatechartKeywords;
				sc_integer timer;
				sc_integer isActive;
				sc_integer init;
				sc_integer enter_ID;
				sc_integer runCycle_ID;
				sc_integer sCIIf;
				sc_boolean operationCallback_raised;
				sc_boolean listeners_raised;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		//! number of time events used by the state machine.
		static const sc_integer timeEventsCount = 1;
		TimerInterface* timer;
		sc_boolean timeEvents[timeEventsCount];
		
		StatechartKeywordsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_If ifaceIf;
		SCI_If_OCB* ifaceIf_OCB;
		InternalSCI ifaceInternalSCI;
		InternalSCI_OCB* ifaceInternalSCI_OCB;
		
		// prototypes of all internal functions
		
		sc_boolean check__lr0();
		void effect__lr0();
		void enact();
		void exact();
		void enseq_main_region_Timer_default();
		void enseq_main_region_default();
		void exseq_main_region_Timer();
		void exseq_main_region();
		void react_main_region_Timer();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
inline StatechartKeywords::SCI_If_OCB::~SCI_If_OCB() {}
inline StatechartKeywords::InternalSCI_OCB::~InternalSCI_OCB() {}
#endif /* STATECHARTKEYWORDS_H_ */
