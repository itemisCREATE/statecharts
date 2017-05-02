
#ifndef PRIORITYVALUES_H_
#define PRIORITYVALUES_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'PriorityValues'.
*/

class PriorityValues : public StatemachineInterface
{
	
	public:
		
		PriorityValues();
		
		~PriorityValues();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			someRegion_A,
			someRegion_B,
			main_region_A,
			main_region_B,
			main_region_C,
			main_region_D,
			main_region_E,
			PriorityValues_last_state
		} PriorityValuesStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'event1' that is defined in the default interface scope. */
				void raise_event1();
				
				/*! Raises the in event 'event2' that is defined in the default interface scope. */
				void raise_event2();
				
				
			private:
				friend class PriorityValues;
				sc_boolean event1_raised;
				sc_boolean event2_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'event1' that is defined in the default interface scope. */
		void raise_event1();
		
		/*! Raises the in event 'event2' that is defined in the default interface scope. */
		void raise_event2();
		
		
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
		sc_boolean isStateActive(PriorityValuesStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		PriorityValuesStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_someRegion_A_tr0_tr0();
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_A_tr2_tr2();
		sc_boolean check_main_region_A_tr3_tr3();
		void effect_someRegion_A_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_A_tr2();
		void effect_main_region_A_tr3();
		void enseq_someRegion_A_default();
		void enseq_someRegion_B_default();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_C_default();
		void enseq_main_region_D_default();
		void enseq_main_region_E_default();
		void enseq_someRegion_default();
		void enseq_main_region_default();
		void exseq_someRegion_A();
		void exseq_someRegion_B();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region_C();
		void exseq_main_region_D();
		void exseq_main_region_E();
		void exseq_someRegion();
		void exseq_main_region();
		void react_someRegion_A();
		void react_someRegion_B();
		void react_main_region_A();
		void react_main_region_B();
		void react_main_region_C();
		void react_main_region_D();
		void react_main_region_E();
		void react_someRegion__entry_Default();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* PRIORITYVALUES_H_ */
