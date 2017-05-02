
#ifndef BOOLEANEXPRESSIONS_H_
#define BOOLEANEXPRESSIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'BooleanExpressions'.
*/

class BooleanExpressions : public StatemachineInterface
{
	
	public:
		
		BooleanExpressions();
		
		~BooleanExpressions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateA,
			main_region_StateB,
			BooleanExpressions_last_state
		} BooleanExpressionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myBool1' that is defined in the default interface scope. */
				sc_boolean get_myBool1() const;
				
				/*! Sets the value of the variable 'myBool1' that is defined in the default interface scope. */
				void set_myBool1(sc_boolean value);
				
				/*! Gets the value of the variable 'myBool2' that is defined in the default interface scope. */
				sc_boolean get_myBool2() const;
				
				/*! Sets the value of the variable 'myBool2' that is defined in the default interface scope. */
				void set_myBool2(sc_boolean value);
				
				/*! Gets the value of the variable 'and' that is defined in the default interface scope. */
				sc_boolean get_and() const;
				
				/*! Sets the value of the variable 'and' that is defined in the default interface scope. */
				void set_and(sc_boolean value);
				
				/*! Gets the value of the variable 'or' that is defined in the default interface scope. */
				sc_boolean get_or() const;
				
				/*! Sets the value of the variable 'or' that is defined in the default interface scope. */
				void set_or(sc_boolean value);
				
				/*! Gets the value of the variable 'not' that is defined in the default interface scope. */
				sc_boolean get_not() const;
				
				/*! Sets the value of the variable 'not' that is defined in the default interface scope. */
				void set_not(sc_boolean value);
				
				/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */
				sc_boolean get_equal() const;
				
				/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */
				void set_equal(sc_boolean value);
				
				/*! Gets the value of the variable 'notequal' that is defined in the default interface scope. */
				sc_boolean get_notequal() const;
				
				/*! Sets the value of the variable 'notequal' that is defined in the default interface scope. */
				void set_notequal(sc_boolean value);
				
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				
			private:
				friend class BooleanExpressions;
				sc_boolean myBool1;
				sc_boolean myBool2;
				sc_boolean and_ID;
				sc_boolean or_ID;
				sc_boolean not_ID;
				sc_boolean equal;
				sc_boolean notequal;
				sc_boolean e1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myBool1' that is defined in the default interface scope. */
		sc_boolean get_myBool1() const;
		
		/*! Sets the value of the variable 'myBool1' that is defined in the default interface scope. */
		void set_myBool1(sc_boolean value);
		
		/*! Gets the value of the variable 'myBool2' that is defined in the default interface scope. */
		sc_boolean get_myBool2() const;
		
		/*! Sets the value of the variable 'myBool2' that is defined in the default interface scope. */
		void set_myBool2(sc_boolean value);
		
		/*! Gets the value of the variable 'and' that is defined in the default interface scope. */
		sc_boolean get_and() const;
		
		/*! Sets the value of the variable 'and' that is defined in the default interface scope. */
		void set_and(sc_boolean value);
		
		/*! Gets the value of the variable 'or' that is defined in the default interface scope. */
		sc_boolean get_or() const;
		
		/*! Sets the value of the variable 'or' that is defined in the default interface scope. */
		void set_or(sc_boolean value);
		
		/*! Gets the value of the variable 'not' that is defined in the default interface scope. */
		sc_boolean get_not() const;
		
		/*! Sets the value of the variable 'not' that is defined in the default interface scope. */
		void set_not(sc_boolean value);
		
		/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */
		sc_boolean get_equal() const;
		
		/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */
		void set_equal(sc_boolean value);
		
		/*! Gets the value of the variable 'notequal' that is defined in the default interface scope. */
		sc_boolean get_notequal() const;
		
		/*! Sets the value of the variable 'notequal' that is defined in the default interface scope. */
		void set_notequal(sc_boolean value);
		
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
		sc_boolean isStateActive(BooleanExpressionsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		BooleanExpressionsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_StateA_tr0_tr0();
		void effect_main_region_StateA_tr0();
		void enact_main_region_StateA();
		void enact_main_region_StateB();
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
#endif /* BOOLEANEXPRESSIONS_H_ */
