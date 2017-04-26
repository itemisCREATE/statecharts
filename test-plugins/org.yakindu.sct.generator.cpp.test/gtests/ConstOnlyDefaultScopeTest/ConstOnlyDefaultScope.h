
#ifndef CONSTONLYDEFAULTSCOPE_H_
#define CONSTONLYDEFAULTSCOPE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ConstOnlyDefaultScope'.
*/

class ConstOnlyDefaultScope : public StatemachineInterface
{
	
	public:
		
		ConstOnlyDefaultScope();
		
		~ConstOnlyDefaultScope();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			ConstOnlyDefaultScope_main_region_A,
			ConstOnlyDefaultScope_main_region_B,
			ConstOnlyDefaultScope_main_region_C,
			ConstOnlyDefaultScope_last_state
		} ConstOnlyDefaultScopeStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'B' that is defined in the default interface scope. */
				const sc_integer get_b() const;
				
				/*! Gets the value of the variable 'C' that is defined in the default interface scope. */
				const sc_integer get_c() const;
				
				
			private:
				friend class ConstOnlyDefaultScope;
				static const sc_integer B;
				static const sc_integer C;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'B' that is defined in the default interface scope. */
		const sc_integer get_b() const;
		
		/*! Gets the value of the variable 'C' that is defined in the default interface scope. */
		const sc_integer get_c() const;
		
		//! Inner class for A interface scope.
		class SCI_A
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the interface scope 'A'. */
				void raise_e(sc_integer value);
				
				
			private:
				friend class ConstOnlyDefaultScope;
				sc_boolean e_raised;
				sc_integer e_value;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_A'. */
		SCI_A* getSCI_A();
		
		
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
		sc_boolean isStateActive(ConstOnlyDefaultScopeStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ConstOnlyDefaultScopeStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		SCI_A ifaceA;
		
		// prototypes of all internal functions
		
		sc_boolean check_ConstOnlyDefaultScope_main_region_A_tr0_tr0();
		sc_boolean check_ConstOnlyDefaultScope_main_region_A_tr1_tr1();
		void effect_ConstOnlyDefaultScope_main_region_A_tr0();
		void effect_ConstOnlyDefaultScope_main_region_A_tr1();
		void enseq_ConstOnlyDefaultScope_main_region_A_default();
		void enseq_ConstOnlyDefaultScope_main_region_B_default();
		void enseq_ConstOnlyDefaultScope_main_region_C_default();
		void enseq_ConstOnlyDefaultScope_main_region_default();
		void exseq_ConstOnlyDefaultScope_main_region_A();
		void exseq_ConstOnlyDefaultScope_main_region_B();
		void exseq_ConstOnlyDefaultScope_main_region_C();
		void exseq_ConstOnlyDefaultScope_main_region();
		void react_ConstOnlyDefaultScope_main_region_A();
		void react_ConstOnlyDefaultScope_main_region_B();
		void react_ConstOnlyDefaultScope_main_region_C();
		void react_ConstOnlyDefaultScope_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* CONSTONLYDEFAULTSCOPE_H_ */
