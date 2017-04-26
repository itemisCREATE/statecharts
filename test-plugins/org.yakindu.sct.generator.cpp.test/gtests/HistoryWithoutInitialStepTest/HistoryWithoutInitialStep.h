
#ifndef HISTORYWITHOUTINITIALSTEP_H_
#define HISTORYWITHOUTINITIALSTEP_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'HistoryWithoutInitialStep'.
*/

class HistoryWithoutInitialStep : public StatemachineInterface
{
	
	public:
		
		HistoryWithoutInitialStep();
		
		~HistoryWithoutInitialStep();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			main_region_B_r1_C,
			main_region_B_r1_D,
			main_region_B_r1_E,
			main_region_B_r1_E__region0_F,
			HistoryWithoutInitialStep_last_state
		} HistoryWithoutInitialStepStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'toA' that is defined in the default interface scope. */
				void raise_toA();
				
				/*! Raises the in event 'toB' that is defined in the default interface scope. */
				void raise_toB();
				
				/*! Raises the in event 'toHistory' that is defined in the default interface scope. */
				void raise_toHistory();
				
				/*! Raises the in event 'next' that is defined in the default interface scope. */
				void raise_next();
				
				
			private:
				friend class HistoryWithoutInitialStep;
				sc_boolean toA_raised;
				sc_boolean toB_raised;
				sc_boolean toHistory_raised;
				sc_boolean next_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'toA' that is defined in the default interface scope. */
		void raise_toA();
		
		/*! Raises the in event 'toB' that is defined in the default interface scope. */
		void raise_toB();
		
		/*! Raises the in event 'toHistory' that is defined in the default interface scope. */
		void raise_toHistory();
		
		/*! Raises the in event 'next' that is defined in the default interface scope. */
		void raise_next();
		
		
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
		sc_boolean isStateActive(HistoryWithoutInitialStepStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 1;
		
		
		HistoryWithoutInitialStepStates stateConfVector[maxOrthogonalStates];
		
		HistoryWithoutInitialStepStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_B_tr0_tr0();
		sc_boolean check_main_region_B_r1_C_tr0_tr0();
		sc_boolean check_main_region_B_r1_D_tr0_tr0();
		sc_boolean check_main_region_B_r1_E_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_B_tr0();
		void effect_main_region_B_r1_C_tr0();
		void effect_main_region_B_r1_D_tr0();
		void effect_main_region_B_r1_E_tr0();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_B_r1_C_default();
		void enseq_main_region_B_r1_D_default();
		void enseq_main_region_B_r1_E_default();
		void enseq_main_region_B_r1_E__region0_F_default();
		void enseq_main_region_default();
		void enseq_main_region_B_r1_default();
		void shenseq_main_region_B_r1();
		void enseq_main_region_B_r1_E__region0_default();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region_B_r1_C();
		void exseq_main_region_B_r1_D();
		void exseq_main_region_B_r1_E();
		void exseq_main_region_B_r1_E__region0_F();
		void exseq_main_region();
		void exseq_main_region_B_r1();
		void exseq_main_region_B_r1_E__region0();
		void react_main_region_A();
		void react_main_region_B_r1_C();
		void react_main_region_B_r1_D();
		void react_main_region_B_r1_E__region0_F();
		void react_main_region__entry_Default();
		void react_main_region_B_r1__entry_Default();
		void react_main_region_B_r1_he();
		void react_main_region_B_r1_E__region0__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* HISTORYWITHOUTINITIALSTEP_H_ */
