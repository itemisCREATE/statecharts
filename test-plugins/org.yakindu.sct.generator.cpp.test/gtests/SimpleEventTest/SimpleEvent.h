
#ifndef SIMPLEEVENT_H_
#define SIMPLEEVENT_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'SimpleEvent'.
*/

class SimpleEvent : public StatemachineInterface
{
	
	public:
		
		SimpleEvent();
		
		~SimpleEvent();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			main_region__final_,
			SimpleEvent_last_state
		} SimpleEventStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'Event1' that is defined in the default interface scope. */
				void raise_event1();
				
				
			private:
				friend class SimpleEvent;
				sc_boolean Event1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'Event1' that is defined in the default interface scope. */
		void raise_event1();
		
		
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
		
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(SimpleEventStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		SimpleEventStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_B_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_B_tr0();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region__final__default();
		void enseq_main_region_default();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region__final_();
		void exseq_main_region();
		void react_main_region_A();
		void react_main_region_B();
		void react_main_region__final_();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* SIMPLEEVENT_H_ */
