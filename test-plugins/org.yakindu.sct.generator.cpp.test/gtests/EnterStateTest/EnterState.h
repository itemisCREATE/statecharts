
#ifndef ENTERSTATE_H_
#define ENTERSTATE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'EnterState'.
*/

class EnterState : public StatemachineInterface
{
	
	public:
		
		EnterState();
		
		~EnterState();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			r_A,
			r_B,
			r_B_r_E,
			r_B_r_F,
			EnterState_last_state
		} EnterStateStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'f' that is defined in the default interface scope. */
				void raise_f();
				
				/*! Raises the in event 'g' that is defined in the default interface scope. */
				void raise_g();
				
				
			private:
				friend class EnterState;
				sc_boolean e_raised;
				sc_boolean f_raised;
				sc_boolean g_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'f' that is defined in the default interface scope. */
		void raise_f();
		
		/*! Raises the in event 'g' that is defined in the default interface scope. */
		void raise_g();
		
		
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
		sc_boolean isStateActive(EnterStateStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		EnterStateStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_r_A_tr0_tr0();
		sc_boolean check_r_A_tr1_tr1();
		sc_boolean check_r_A_tr2_tr2();
		void effect_r_A_tr0();
		void effect_r_A_tr1();
		void effect_r_A_tr2();
		void enseq_r_A_default();
		void enseq_r_B_default();
		void enseq_r_B_f();
		void enseq_r_B_g();
		void enseq_r_B_r_E_default();
		void enseq_r_B_r_F_default();
		void enseq_r_default();
		void enseq_r_B_r_default();
		void enseq_r_B_r_f();
		void exseq_r_A();
		void exseq_r_B_r_E();
		void exseq_r_B_r_F();
		void exseq_r();
		void exseq_r_B_r();
		void react_r_A();
		void react_r_B_r_E();
		void react_r_B_r_F();
		void react_r__entry_Default();
		void react_r_B_r__entry_Default();
		void react_r_B_r_f();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* ENTERSTATE_H_ */
