
#ifndef FEATURECALLS_H_
#define FEATURECALLS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'FeatureCalls'.
*/

class FeatureCalls : public StatemachineInterface
{
	
	public:
		
		FeatureCalls();
		
		~FeatureCalls();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			FeatureCalls_last_state
		} FeatureCallsStates;
		
		//! Inner class for MyInterface interface scope.
		class SCI_MyInterface
		{
			
			public:
				/*! Raises the in event 'Event1' that is defined in the interface scope 'MyInterface'. */
				void raise_event1();
				
				/*! Gets the value of the variable 'myInt' that is defined in the interface scope 'MyInterface'. */
				sc_integer get_myInt() const;
				
				/*! Sets the value of the variable 'myInt' that is defined in the interface scope 'MyInterface'. */
				void set_myInt(sc_integer value);
				
				
			private:
				friend class FeatureCalls;
				sc_boolean Event1_raised;
				sc_integer myInt;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_MyInterface'. */
		SCI_MyInterface* getSCI_MyInterface();
		
		
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
		sc_boolean isStateActive(FeatureCallsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		FeatureCallsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_MyInterface ifaceMyInterface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_B_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_B_tr0();
		void enact_main_region_B();
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
#endif /* FEATURECALLS_H_ */
