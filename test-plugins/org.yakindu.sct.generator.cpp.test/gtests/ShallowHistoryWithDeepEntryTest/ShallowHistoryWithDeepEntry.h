
#ifndef SHALLOWHISTORYWITHDEEPENTRY_H_
#define SHALLOWHISTORYWITHDEEPENTRY_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ShallowHistoryWithDeepEntry'.
*/

class ShallowHistoryWithDeepEntry : public StatemachineInterface
{
	
	public:
		
		ShallowHistoryWithDeepEntry();
		
		~ShallowHistoryWithDeepEntry();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_Y,
			main_region_Z,
			main_region_Z__region0_A,
			main_region_Z__region0_B,
			main_region_Z__region0_B__region0_C,
			ShallowHistoryWithDeepEntry_last_state
		} ShallowHistoryWithDeepEntryStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'toZ' that is defined in the default interface scope. */
				void raise_toZ();
				
				/*! Raises the in event 'toY' that is defined in the default interface scope. */
				void raise_toY();
				
				/*! Raises the in event 'toC' that is defined in the default interface scope. */
				void raise_toC();
				
				/*! Raises the in event 'toA' that is defined in the default interface scope. */
				void raise_toA();
				
				
			private:
				friend class ShallowHistoryWithDeepEntry;
				sc_boolean toZ_raised;
				sc_boolean toY_raised;
				sc_boolean toC_raised;
				sc_boolean toA_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'toZ' that is defined in the default interface scope. */
		void raise_toZ();
		
		/*! Raises the in event 'toY' that is defined in the default interface scope. */
		void raise_toY();
		
		/*! Raises the in event 'toC' that is defined in the default interface scope. */
		void raise_toC();
		
		/*! Raises the in event 'toA' that is defined in the default interface scope. */
		void raise_toA();
		
		
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
		sc_boolean isStateActive(ShallowHistoryWithDeepEntryStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 1;
		
		
		ShallowHistoryWithDeepEntryStates stateConfVector[maxOrthogonalStates];
		
		ShallowHistoryWithDeepEntryStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Y_tr0_tr0();
		sc_boolean check_main_region_Y_tr1_tr1();
		sc_boolean check_main_region_Z_tr0_tr0();
		sc_boolean check_main_region_Z__region0_A_tr0_tr0();
		sc_boolean check_main_region_Z__region0_B__region0_C_tr0_tr0();
		void effect_main_region_Y_tr0();
		void effect_main_region_Y_tr1();
		void effect_main_region_Z_tr0();
		void effect_main_region_Z__region0_A_tr0();
		void effect_main_region_Z__region0_B__region0_C_tr0();
		void enseq_main_region_Y_default();
		void enseq_main_region_Z_default();
		void enseq_main_region_Z__region0_A_default();
		void enseq_main_region_Z__region0_B_default();
		void enseq_main_region_Z__region0_B__region0_C_default();
		void enseq_main_region_default();
		void enseq_main_region_Z__region0_default();
		void shenseq_main_region_Z__region0();
		void enseq_main_region_Z__region0_B__region0_default();
		void exseq_main_region_Y();
		void exseq_main_region_Z();
		void exseq_main_region_Z__region0_A();
		void exseq_main_region_Z__region0_B();
		void exseq_main_region_Z__region0_B__region0_C();
		void exseq_main_region();
		void exseq_main_region_Z__region0();
		void exseq_main_region_Z__region0_B__region0();
		void react_main_region_Y();
		void react_main_region_Z__region0_A();
		void react_main_region_Z__region0_B__region0_C();
		void react_main_region__entry_Default();
		void react_main_region_Z__region0__entry_Default();
		void react_main_region_Z__region0_B__region0__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* SHALLOWHISTORYWITHDEEPENTRY_H_ */
