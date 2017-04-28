
#ifndef EXITONSELFTRANSITION_H_
#define EXITONSELFTRANSITION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ExitOnSelfTransition'.
*/

class ExitOnSelfTransition : public StatemachineInterface
{
	
	public:
		
		ExitOnSelfTransition();
		
		~ExitOnSelfTransition();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			ExitOnSelfTransition_last_state
		} ExitOnSelfTransitionStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'f' that is defined in the default interface scope. */
				void raise_f();
				
				/*! Gets the value of the variable 'entryCount' that is defined in the default interface scope. */
				sc_integer get_entryCount() const;
				
				/*! Sets the value of the variable 'entryCount' that is defined in the default interface scope. */
				void set_entryCount(sc_integer value);
				
				/*! Gets the value of the variable 'exitCount' that is defined in the default interface scope. */
				sc_integer get_exitCount() const;
				
				/*! Sets the value of the variable 'exitCount' that is defined in the default interface scope. */
				void set_exitCount(sc_integer value);
				
				
			private:
				friend class ExitOnSelfTransition;
				sc_boolean e_raised;
				sc_boolean f_raised;
				sc_integer entryCount;
				sc_integer exitCount;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'f' that is defined in the default interface scope. */
		void raise_f();
		
		/*! Gets the value of the variable 'entryCount' that is defined in the default interface scope. */
		sc_integer get_entryCount() const;
		
		/*! Sets the value of the variable 'entryCount' that is defined in the default interface scope. */
		void set_entryCount(sc_integer value);
		
		/*! Gets the value of the variable 'exitCount' that is defined in the default interface scope. */
		sc_integer get_exitCount() const;
		
		/*! Sets the value of the variable 'exitCount' that is defined in the default interface scope. */
		void set_exitCount(sc_integer value);
		
		
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
		sc_boolean isStateActive(ExitOnSelfTransitionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ExitOnSelfTransitionStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_B_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_B_tr0();
		void enact_main_region_A();
		void exact_main_region_A();
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
#endif /* EXITONSELFTRANSITION_H_ */
