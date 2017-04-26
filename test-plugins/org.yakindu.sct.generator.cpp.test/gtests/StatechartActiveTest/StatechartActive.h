
#ifndef STATECHARTACTIVE_H_
#define STATECHARTACTIVE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'StatechartActive'.
*/

class StatechartActive : public StatemachineInterface
{
	
	public:
		
		StatechartActive();
		
		~StatechartActive();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			r_A,
			StatechartActive_last_state
		} StatechartActiveStates;
		
		
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
		sc_boolean isStateActive(StatechartActiveStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		StatechartActiveStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		
		// prototypes of all internal functions
		
		void enseq_r_A_default();
		void enseq_r_default();
		void exseq_r_A();
		void exseq_r();
		void react_r_A();
		void react_r__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STATECHARTACTIVE_H_ */
