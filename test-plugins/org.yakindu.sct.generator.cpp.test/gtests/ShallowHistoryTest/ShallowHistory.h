
#ifndef SHALLOWHISTORY_H_
#define SHALLOWHISTORY_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ShallowHistory'.
*/

class ShallowHistory : public StatemachineInterface
{
	
	public:
		
		ShallowHistory();
		
		~ShallowHistory();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			mainRegion_State1,
			mainRegion_State2,
			mainRegion_State2__region0_State3,
			mainRegion_State2__region0_State4,
			mainRegion_State2__region0_State4__region0_State6,
			mainRegion_State2__region0_State4__region0_State7,
			mainRegion_State2__region0_State4__region0_State7__region0_State8,
			mainRegion_State2__region0_State4__region0_State7__region0_State9,
			mainRegion_State2__region0_State5,
			ShallowHistory_last_state
		} ShallowHistoryStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'event1' that is defined in the default interface scope. */
				void raise_event1();
				
				/*! Raises the in event 'event2' that is defined in the default interface scope. */
				void raise_event2();
				
				/*! Raises the in event 'event3' that is defined in the default interface scope. */
				void raise_event3();
				
				/*! Raises the in event 'event4' that is defined in the default interface scope. */
				void raise_event4();
				
				/*! Raises the in event 'event5' that is defined in the default interface scope. */
				void raise_event5();
				
				/*! Raises the in event 'event6' that is defined in the default interface scope. */
				void raise_event6();
				
				/*! Raises the in event 'event7' that is defined in the default interface scope. */
				void raise_event7();
				
				/*! Raises the in event 'event8' that is defined in the default interface scope. */
				void raise_event8();
				
				
			private:
				friend class ShallowHistory;
				sc_boolean event1_raised;
				sc_boolean event2_raised;
				sc_boolean event3_raised;
				sc_boolean event4_raised;
				sc_boolean event5_raised;
				sc_boolean event6_raised;
				sc_boolean event7_raised;
				sc_boolean event8_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'event1' that is defined in the default interface scope. */
		void raise_event1();
		
		/*! Raises the in event 'event2' that is defined in the default interface scope. */
		void raise_event2();
		
		/*! Raises the in event 'event3' that is defined in the default interface scope. */
		void raise_event3();
		
		/*! Raises the in event 'event4' that is defined in the default interface scope. */
		void raise_event4();
		
		/*! Raises the in event 'event5' that is defined in the default interface scope. */
		void raise_event5();
		
		/*! Raises the in event 'event6' that is defined in the default interface scope. */
		void raise_event6();
		
		/*! Raises the in event 'event7' that is defined in the default interface scope. */
		void raise_event7();
		
		/*! Raises the in event 'event8' that is defined in the default interface scope. */
		void raise_event8();
		
		
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
		sc_boolean isStateActive(ShallowHistoryStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 2;
		
		
		ShallowHistoryStates stateConfVector[maxOrthogonalStates];
		
		ShallowHistoryStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_mainRegion_State1_tr0_tr0();
		sc_boolean check_mainRegion_State2_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State3_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State4_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0();
		sc_boolean check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0();
		void effect_mainRegion_State1_tr0();
		void effect_mainRegion_State2_tr0();
		void effect_mainRegion_State2__region0_State3_tr0();
		void effect_mainRegion_State2__region0_State4_tr0();
		void effect_mainRegion_State2__region0_State4__region0_State6_tr0();
		void effect_mainRegion_State2__region0_State4__region0_State7_tr0();
		void effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0();
		void effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0();
		void enseq_mainRegion_State1_default();
		void enseq_mainRegion_State2_default();
		void enseq_mainRegion_State2__region0_State3_default();
		void enseq_mainRegion_State2__region0_State4_default();
		void enseq_mainRegion_State2__region0_State4__region0_State6_default();
		void enseq_mainRegion_State2__region0_State4__region0_State7_default();
		void enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
		void enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default();
		void enseq_mainRegion_State2__region0_State5_default();
		void enseq_mainRegion_default();
		void enseq_mainRegion_State2__region0_default();
		void shenseq_mainRegion_State2__region0();
		void enseq_mainRegion_State2__region0_State4__region0_default();
		void enseq_mainRegion_State2__region0_State4__region0_State7__region0_default();
		void shenseq_mainRegion_State2__region0_State4__region0_State7__region0();
		void exseq_mainRegion_State1();
		void exseq_mainRegion_State2();
		void exseq_mainRegion_State2__region0_State3();
		void exseq_mainRegion_State2__region0_State4();
		void exseq_mainRegion_State2__region0_State4__region0_State6();
		void exseq_mainRegion_State2__region0_State4__region0_State7();
		void exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
		void exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
		void exseq_mainRegion_State2__region0_State5();
		void exseq_mainRegion();
		void exseq_mainRegion_State2__region0();
		void exseq_mainRegion_State2__region0_State4__region0();
		void exseq_mainRegion_State2__region0_State4__region0_State7__region0();
		void react_mainRegion_State1();
		void react_mainRegion_State2__region0_State3();
		void react_mainRegion_State2__region0_State4__region0_State6();
		void react_mainRegion_State2__region0_State4__region0_State7__region0_State8();
		void react_mainRegion_State2__region0_State4__region0_State7__region0_State9();
		void react_mainRegion_State2__region0_State5();
		void react_mainRegion__entry_Default();
		void react_mainRegion_State2__region0__entry_Default();
		void react_mainRegion_State2__region0_State4__region0__entry_Default();
		void react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* SHALLOWHISTORY_H_ */
