
#ifndef GUARD_H_
#define GUARD_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Guard'.
*/

class Guard : public StatemachineInterface
{
	
	public:
		
		Guard();
		
		~Guard();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			Guard_last_state
		} GuardStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'Event1' that is defined in the default interface scope. */
				void raise_event1();
				
				/*! Raises the in event 'Event2' that is defined in the default interface scope. */
				void raise_event2();
				
				/*! Raises the in event 'Return' that is defined in the default interface scope. */
				void raise_return();
				
				/*! Gets the value of the variable 'MyVar' that is defined in the default interface scope. */
				sc_integer get_myVar() const;
				
				/*! Sets the value of the variable 'MyVar' that is defined in the default interface scope. */
				void set_myVar(sc_integer value);
				
				
			private:
				friend class Guard;
				sc_boolean Event1_raised;
				sc_boolean Event2_raised;
				sc_boolean Return_raised;
				sc_integer MyVar;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'Event1' that is defined in the default interface scope. */
		void raise_event1();
		
		/*! Raises the in event 'Event2' that is defined in the default interface scope. */
		void raise_event2();
		
		/*! Raises the in event 'Return' that is defined in the default interface scope. */
		void raise_return();
		
		/*! Gets the value of the variable 'MyVar' that is defined in the default interface scope. */
		sc_integer get_myVar() const;
		
		/*! Sets the value of the variable 'MyVar' that is defined in the default interface scope. */
		void set_myVar(sc_integer value);
		
		
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
		sc_boolean isStateActive(GuardStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		GuardStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_B_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_B_tr0();
		void enact_main_region_B();
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
#endif /* GUARD_H_ */
