
#ifndef SIMPLEHIERACHY_H_
#define SIMPLEHIERACHY_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'SimpleHierachy'.
*/

class SimpleHierachy : public StatemachineInterface
{
	
	public:
		
		SimpleHierachy();
		
		~SimpleHierachy();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			main_region_B_subregion1_B1,
			SimpleHierachy_last_state
		} SimpleHierachyStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'Event1' that is defined in the default interface scope. */
				void raise_event1();
				
				
			private:
				friend class SimpleHierachy;
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
		sc_boolean isStateActive(SimpleHierachyStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		SimpleHierachyStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		void effect_main_region_A_tr0();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_B_subregion1_B1_default();
		void enseq_main_region_default();
		void enseq_main_region_B_subregion1_default();
		void exseq_main_region_A();
		void exseq_main_region_B_subregion1_B1();
		void exseq_main_region();
		void exseq_main_region_B_subregion1();
		void react_main_region_A();
		void react_main_region_B_subregion1_B1();
		void react_main_region__entry_Default();
		void react_main_region_B_subregion1__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* SIMPLEHIERACHY_H_ */
