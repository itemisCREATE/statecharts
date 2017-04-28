
#ifndef STATECHARTLOCALREACTIONS_H_
#define STATECHARTLOCALREACTIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'StatechartLocalReactions'.
*/

class StatechartLocalReactions : public StatemachineInterface
{
	
	public:
		
		StatechartLocalReactions();
		
		~StatechartLocalReactions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_S1,
			main_region_S2,
			region2_a,
			StatechartLocalReactions_last_state
		} StatechartLocalReactionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
				sc_integer get_myInt() const;
				
				/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */
				void set_myInt(sc_integer value);
				
				
			private:
				friend class StatechartLocalReactions;
				sc_integer myInt;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
		sc_integer get_myInt() const;
		
		/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */
		void set_myInt(sc_integer value);
		
		
		
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
		sc_boolean isStateActive(StatechartLocalReactionsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				
			private:
				friend class StatechartLocalReactions;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		StatechartLocalReactionsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check__lr0();
		sc_boolean check__lr1();
		sc_boolean check_main_region_S1_tr0_tr0();
		sc_boolean check_main_region_S2_tr0_tr0();
		void effect__lr0();
		void effect__lr1();
		void effect_main_region_S1_tr0();
		void effect_main_region_S2_tr0();
		void enseq_main_region_S1_default();
		void enseq_main_region_S2_default();
		void enseq_region2_a_default();
		void enseq_main_region_default();
		void enseq_region2_default();
		void exseq_main_region_S1();
		void exseq_main_region_S2();
		void exseq_region2_a();
		void exseq_main_region();
		void exseq_region2();
		void react_main_region_S1();
		void react_main_region_S2();
		void react_region2_a();
		void react_main_region__entry_Default();
		void react_region2__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STATECHARTLOCALREACTIONS_H_ */
