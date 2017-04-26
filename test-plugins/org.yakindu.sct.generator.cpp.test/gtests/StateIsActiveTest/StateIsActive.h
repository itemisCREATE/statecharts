
#ifndef STATEISACTIVE_H_
#define STATEISACTIVE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'StateIsActive'.
*/

class StateIsActive : public StatemachineInterface
{
	
	public:
		
		StateIsActive();
		
		~StateIsActive();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			R1_R1A,
			R1_R1B,
			R2_R2A,
			R2_R2B,
			StateIsActive_last_state
		} StateIsActiveStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'Event1' that is defined in the default interface scope. */
				void raise_event1();
				
				
			private:
				friend class StateIsActive;
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
		sc_boolean isStateActive(StateIsActiveStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		StateIsActiveStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_R1_R1A_tr0_tr0();
		sc_boolean check_R2_R2A_tr0_tr0();
		void effect_R1_R1A_tr0();
		void effect_R2_R2A_tr0();
		void enseq_R1_R1A_default();
		void enseq_R1_R1B_default();
		void enseq_R2_R2A_default();
		void enseq_R2_R2B_default();
		void enseq_R1_default();
		void enseq_R2_default();
		void exseq_R1_R1A();
		void exseq_R1_R1B();
		void exseq_R2_R2A();
		void exseq_R2_R2B();
		void exseq_R1();
		void exseq_R2();
		void react_R1_R1A();
		void react_R1_R1B();
		void react_R2_R2A();
		void react_R2_R2B();
		void react_R1__entry_Default();
		void react_R2__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STATEISACTIVE_H_ */
