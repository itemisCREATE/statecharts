
#ifndef EMPTYTRANSITION_H_
#define EMPTYTRANSITION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'EmptyTransition'.
*/

class EmptyTransition : public StatemachineInterface
{
	
	public:
		
		EmptyTransition();
		
		~EmptyTransition();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			EmptyTransition_last_state
		} EmptyTransitionStates;
		
		
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
		sc_boolean isStateActive(EmptyTransitionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		EmptyTransitionStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		
		// prototypes of all internal functions
		
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_default();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region();
		void react_main_region_A();
		void react_main_region_B();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* EMPTYTRANSITION_H_ */
