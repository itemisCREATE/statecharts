
#ifndef ALWAYSONCYCLE_H_
#define ALWAYSONCYCLE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'AlwaysOncycle'.
*/

/*! Define indices of states in the StateConfVector */
#define SCVI_MAIN_REGION_STATEA 0
#define SCVI_MAIN_REGION_STATEB 0

class AlwaysOncycle : public StatemachineInterface
{
	
	public:
		
		AlwaysOncycle();
		
		~AlwaysOncycle();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			AlwaysOncycle_last_state,
			main_region_StateA,
			main_region_StateB
		} AlwaysOncycleStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'value' that is defined in the default interface scope. */
				sc_integer get_value() const;
				
				/*! Sets the value of the variable 'value' that is defined in the default interface scope. */
				void set_value(sc_integer value);
				
				/*! Gets the value of the variable 'v2' that is defined in the default interface scope. */
				sc_boolean get_v2() const;
				
				/*! Sets the value of the variable 'v2' that is defined in the default interface scope. */
				void set_v2(sc_boolean value);
				
				
			private:
				friend class AlwaysOncycle;
				sc_integer value;
				sc_boolean v2;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'value' that is defined in the default interface scope. */
		sc_integer get_value() const;
		
		/*! Sets the value of the variable 'value' that is defined in the default interface scope. */
		void set_value(sc_integer value);
		
		/*! Gets the value of the variable 'v2' that is defined in the default interface scope. */
		sc_boolean get_v2() const;
		
		/*! Sets the value of the variable 'v2' that is defined in the default interface scope. */
		void set_v2(sc_boolean value);
		
		
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
		sc_boolean isStateActive(AlwaysOncycleStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		AlwaysOncycleStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_StateA_lr1_lr1();
		sc_boolean check_main_region_StateA_tr0_tr0();
		sc_boolean check_main_region_StateB_lr0_lr0();
		sc_boolean check_main_region_StateB_tr0_tr0();
		void effect_main_region_StateA_lr1_lr1();
		void effect_main_region_StateA_tr0();
		void effect_main_region_StateB_lr0_lr0();
		void effect_main_region_StateB_tr0();
		void enact_main_region_StateA();
		void exact_main_region_StateA();
		void enseq_main_region_StateA_default();
		void enseq_main_region_StateB_default();
		void enseq_main_region_default();
		void exseq_main_region_StateA();
		void exseq_main_region_StateB();
		void exseq_main_region();
		void react_main_region_StateA();
		void react_main_region_StateB();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* ALWAYSONCYCLE_H_ */
