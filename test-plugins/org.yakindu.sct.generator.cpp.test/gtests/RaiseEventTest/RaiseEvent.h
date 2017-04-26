
#ifndef RAISEEVENT_H_
#define RAISEEVENT_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'RaiseEvent'.
*/

class RaiseEvent : public StatemachineInterface
{
	
	public:
		
		RaiseEvent();
		
		~RaiseEvent();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateA,
			main_region_StateB,
			second_region_SateA,
			second_region_StateB,
			RaiseEvent_last_state
		} RaiseEventStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Checks if the out event 'e1' that is defined in the default interface scope has been raised. */
				sc_boolean isRaised_e1() const;
				
				/*! Raises the in event 'e2' that is defined in the default interface scope. */
				void raise_e2();
				
				
			private:
				friend class RaiseEvent;
				sc_boolean e1_raised;
				sc_boolean e2_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Checks if the out event 'e1' that is defined in the default interface scope has been raised. */
		sc_boolean isRaised_e1() const;
		
		/*! Raises the in event 'e2' that is defined in the default interface scope. */
		void raise_e2();
		
		
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
		sc_boolean isStateActive(RaiseEventStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		RaiseEventStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_StateA_tr0_tr0();
		sc_boolean check_second_region_SateA_tr0_tr0();
		void effect_main_region_StateA_tr0();
		void effect_second_region_SateA_tr0();
		void enact_main_region_StateB();
		void enseq_main_region_StateA_default();
		void enseq_main_region_StateB_default();
		void enseq_second_region_SateA_default();
		void enseq_second_region_StateB_default();
		void enseq_main_region_default();
		void enseq_second_region_default();
		void exseq_main_region_StateA();
		void exseq_main_region_StateB();
		void exseq_second_region_SateA();
		void exseq_second_region_StateB();
		void exseq_main_region();
		void exseq_second_region();
		void react_main_region_StateA();
		void react_main_region_StateB();
		void react_second_region_SateA();
		void react_second_region_StateB();
		void react_main_region__entry_Default();
		void react_second_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* RAISEEVENT_H_ */
