
#ifndef SAMENAMEDIFFERENTREGION_H_
#define SAMENAMEDIFFERENTREGION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'SameNameDifferentRegion'.
*/

class SameNameDifferentRegion : public StatemachineInterface
{
	
	public:
		
		SameNameDifferentRegion();
		
		~SameNameDifferentRegion();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateA,
			main_region_StateB,
			main_region_StateB_r1_StateA,
			main_region_StateB_r1_StateB,
			SameNameDifferentRegion_last_state
		} SameNameDifferentRegionStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				
			private:
				friend class SameNameDifferentRegion;
				sc_boolean e1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e1' that is defined in the default interface scope. */
		void raise_e1();
		
		
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
		sc_boolean isStateActive(SameNameDifferentRegionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		SameNameDifferentRegionStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_StateA_tr0_tr0();
		sc_boolean check_main_region_StateB_r1_StateA_tr0_tr0();
		void effect_main_region_StateA_tr0();
		void effect_main_region_StateB_r1_StateA_tr0();
		void enseq_main_region_StateA_default();
		void enseq_main_region_StateB_default();
		void enseq_main_region_StateB_r1_StateA_default();
		void enseq_main_region_StateB_r1_StateB_default();
		void enseq_main_region_default();
		void enseq_main_region_StateB_r1_default();
		void exseq_main_region_StateA();
		void exseq_main_region_StateB_r1_StateA();
		void exseq_main_region_StateB_r1_StateB();
		void exseq_main_region();
		void exseq_main_region_StateB_r1();
		void react_main_region_StateA();
		void react_main_region_StateB_r1_StateA();
		void react_main_region_StateB_r1_StateB();
		void react_main_region__entry_Default();
		void react_main_region_StateB_r1__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* SAMENAMEDIFFERENTREGION_H_ */
