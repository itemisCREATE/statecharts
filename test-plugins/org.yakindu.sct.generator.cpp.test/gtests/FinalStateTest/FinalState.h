
#ifndef FINALSTATE_H_
#define FINALSTATE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'FinalState'.
*/

class FinalState : public StatemachineInterface
{
	
	public:
		
		FinalState();
		
		~FinalState();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_myState,
			main_region__final_,
			FinalState_last_state
		} FinalStateStates;
		
		
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
		sc_boolean isStateActive(FinalStateStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		FinalStateStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_myState_tr0_tr0();
		void effect_main_region_myState_tr0();
		void enseq_main_region_myState_default();
		void enseq_main_region__final__default();
		void enseq_main_region_default();
		void exseq_main_region_myState();
		void exseq_main_region__final_();
		void exseq_main_region();
		void react_main_region_myState();
		void react_main_region__final_();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* FINALSTATE_H_ */
