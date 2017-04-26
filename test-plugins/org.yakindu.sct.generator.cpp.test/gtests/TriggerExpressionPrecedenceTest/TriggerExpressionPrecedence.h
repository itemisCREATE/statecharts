
#ifndef TRIGGEREXPRESSIONPRECEDENCE_H_
#define TRIGGEREXPRESSIONPRECEDENCE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'TriggerExpressionPrecedence'.
*/

class TriggerExpressionPrecedence : public StatemachineInterface
{
	
	public:
		
		TriggerExpressionPrecedence();
		
		~TriggerExpressionPrecedence();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			TriggerExpressionPrecedence_main_region_A,
			TriggerExpressionPrecedence_last_state
		} TriggerExpressionPrecedenceStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				/*! Raises the in event 'e2' that is defined in the default interface scope. */
				void raise_e2();
				
				/*! Gets the value of the variable 'c1' that is defined in the default interface scope. */
				sc_boolean get_c1() const;
				
				/*! Sets the value of the variable 'c1' that is defined in the default interface scope. */
				void set_c1(sc_boolean value);
				
				/*! Gets the value of the variable 'c2' that is defined in the default interface scope. */
				sc_boolean get_c2() const;
				
				/*! Sets the value of the variable 'c2' that is defined in the default interface scope. */
				void set_c2(sc_boolean value);
				
				/*! Gets the value of the variable 'e1_transition' that is defined in the default interface scope. */
				sc_boolean get_e1_transition() const;
				
				/*! Sets the value of the variable 'e1_transition' that is defined in the default interface scope. */
				void set_e1_transition(sc_boolean value);
				
				/*! Gets the value of the variable 'e2_transition' that is defined in the default interface scope. */
				sc_boolean get_e2_transition() const;
				
				/*! Sets the value of the variable 'e2_transition' that is defined in the default interface scope. */
				void set_e2_transition(sc_boolean value);
				
				
			private:
				friend class TriggerExpressionPrecedence;
				sc_boolean e1_raised;
				sc_boolean e2_raised;
				sc_boolean c1;
				sc_boolean c2;
				sc_boolean e1_transition;
				sc_boolean e2_transition;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e1' that is defined in the default interface scope. */
		void raise_e1();
		
		/*! Raises the in event 'e2' that is defined in the default interface scope. */
		void raise_e2();
		
		/*! Gets the value of the variable 'c1' that is defined in the default interface scope. */
		sc_boolean get_c1() const;
		
		/*! Sets the value of the variable 'c1' that is defined in the default interface scope. */
		void set_c1(sc_boolean value);
		
		/*! Gets the value of the variable 'c2' that is defined in the default interface scope. */
		sc_boolean get_c2() const;
		
		/*! Sets the value of the variable 'c2' that is defined in the default interface scope. */
		void set_c2(sc_boolean value);
		
		/*! Gets the value of the variable 'e1_transition' that is defined in the default interface scope. */
		sc_boolean get_e1_transition() const;
		
		/*! Sets the value of the variable 'e1_transition' that is defined in the default interface scope. */
		void set_e1_transition(sc_boolean value);
		
		/*! Gets the value of the variable 'e2_transition' that is defined in the default interface scope. */
		sc_boolean get_e2_transition() const;
		
		/*! Sets the value of the variable 'e2_transition' that is defined in the default interface scope. */
		void set_e2_transition(sc_boolean value);
		
		
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
		sc_boolean isStateActive(TriggerExpressionPrecedenceStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		TriggerExpressionPrecedenceStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_TriggerExpressionPrecedence_main_region_A_tr0_tr0();
		sc_boolean check_TriggerExpressionPrecedence_main_region_A_tr1_tr1();
		void effect_TriggerExpressionPrecedence_main_region_A_tr0();
		void effect_TriggerExpressionPrecedence_main_region_A_tr1();
		void enseq_TriggerExpressionPrecedence_main_region_A_default();
		void enseq_TriggerExpressionPrecedence_main_region_default();
		void exseq_TriggerExpressionPrecedence_main_region_A();
		void exseq_TriggerExpressionPrecedence_main_region();
		void react_TriggerExpressionPrecedence_main_region_A();
		void react_TriggerExpressionPrecedence_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* TRIGGEREXPRESSIONPRECEDENCE_H_ */
