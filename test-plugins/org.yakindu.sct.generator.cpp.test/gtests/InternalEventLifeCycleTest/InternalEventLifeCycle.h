
#ifndef INTERNALEVENTLIFECYCLE_H_
#define INTERNALEVENTLIFECYCLE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'InternalEventLifeCycle'.
*/

class InternalEventLifeCycle : public StatemachineInterface
{
	
	public:
		
		InternalEventLifeCycle();
		
		~InternalEventLifeCycle();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			r1_A,
			r1_B,
			r2_C,
			r2_D,
			InternalEventLifeCycle_last_state
		} InternalEventLifeCycleStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'f' that is defined in the default interface scope. */
				void raise_f();
				
				
			private:
				friend class InternalEventLifeCycle;
				sc_boolean e_raised;
				sc_boolean f_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'f' that is defined in the default interface scope. */
		void raise_f();
		
		
		
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
		sc_boolean isStateActive(InternalEventLifeCycleStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Raises the in event 'i1' that is defined in the internal scope. */
				void raise_i1();
				
				/*! Checks if the out event 'i1' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_i1() const;
				
				/*! Raises the in event 'i2' that is defined in the internal scope. */
				void raise_i2();
				
				/*! Checks if the out event 'i2' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_i2() const;
				
				
			private:
				friend class InternalEventLifeCycle;
				sc_boolean i1_raised;
				sc_boolean i2_raised;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		InternalEventLifeCycleStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_r1_A_tr0_tr0();
		sc_boolean check_r1_A_lr0_lr0();
		sc_boolean check_r1_B_tr0_tr0();
		sc_boolean check_r2_C_tr0_tr0();
		sc_boolean check_r2_D_tr0_tr0();
		void effect_r1_A_tr0();
		void effect_r1_A_lr0_lr0();
		void effect_r1_B_tr0();
		void effect_r2_C_tr0();
		void effect_r2_D_tr0();
		void enseq_r1_A_default();
		void enseq_r1_B_default();
		void enseq_r2_C_default();
		void enseq_r2_D_default();
		void enseq_r1_default();
		void enseq_r2_default();
		void exseq_r1_A();
		void exseq_r1_B();
		void exseq_r2_C();
		void exseq_r2_D();
		void exseq_r1();
		void exseq_r2();
		void react_r1_A();
		void react_r1_B();
		void react_r2_C();
		void react_r2_D();
		void react_r1__entry_Default();
		void react_r2__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* INTERNALEVENTLIFECYCLE_H_ */
