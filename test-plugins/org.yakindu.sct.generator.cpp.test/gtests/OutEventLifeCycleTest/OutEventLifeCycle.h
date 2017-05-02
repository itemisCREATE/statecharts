
#ifndef OUTEVENTLIFECYCLE_H_
#define OUTEVENTLIFECYCLE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'OutEventLifeCycle'.
*/

class OutEventLifeCycle : public StatemachineInterface
{
	
	public:
		
		OutEventLifeCycle();
		
		~OutEventLifeCycle();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			r1_A,
			r1_B,
			r2_B,
			OutEventLifeCycle_last_state
		} OutEventLifeCycleStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Checks if the out event 'f' that is defined in the default interface scope has been raised. */
				sc_boolean isRaised_f() const;
				
				/*! Gets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */
				sc_boolean get_f_available_in_cycle() const;
				
				/*! Sets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */
				void set_f_available_in_cycle(sc_boolean value);
				
				/*! Gets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */
				sc_boolean get_f_available_in_next_cycle() const;
				
				/*! Sets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */
				void set_f_available_in_next_cycle(sc_boolean value);
				
				
			private:
				friend class OutEventLifeCycle;
				sc_boolean e_raised;
				sc_boolean f_raised;
				sc_boolean f_available_in_cycle;
				sc_boolean f_available_in_next_cycle;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Checks if the out event 'f' that is defined in the default interface scope has been raised. */
		sc_boolean isRaised_f() const;
		
		/*! Gets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */
		sc_boolean get_f_available_in_cycle() const;
		
		/*! Sets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */
		void set_f_available_in_cycle(sc_boolean value);
		
		/*! Gets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */
		sc_boolean get_f_available_in_next_cycle() const;
		
		/*! Sets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */
		void set_f_available_in_next_cycle(sc_boolean value);
		
		
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
		sc_boolean isStateActive(OutEventLifeCycleStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		OutEventLifeCycleStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_r1_A_tr0_tr0();
		sc_boolean check_r1_B_lr0_lr0();
		sc_boolean check_r2_B_lr0_lr0();
		void effect_r1_A_tr0();
		void effect_r1_B_lr0_lr0();
		void effect_r2_B_lr0_lr0();
		void enseq_r1_A_default();
		void enseq_r1_B_default();
		void enseq_r2_B_default();
		void enseq_r1_default();
		void enseq_r2_default();
		void exseq_r1_A();
		void exseq_r1_B();
		void exseq_r2_B();
		void exseq_r1();
		void exseq_r2();
		void react_r1_A();
		void react_r1_B();
		void react_r2_B();
		void react_r1__entry_Default();
		void react_r2__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* OUTEVENTLIFECYCLE_H_ */
