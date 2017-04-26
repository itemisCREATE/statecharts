
#ifndef INTEGEREXPRESSIONS_H_
#define INTEGEREXPRESSIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'IntegerExpressions'.
*/

class IntegerExpressions : public StatemachineInterface
{
	
	public:
		
		IntegerExpressions();
		
		~IntegerExpressions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateA,
			main_region_StateB,
			IntegerExpressions_last_state
		} IntegerExpressionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myInt1' that is defined in the default interface scope. */
				sc_integer get_myInt1() const;
				
				/*! Sets the value of the variable 'myInt1' that is defined in the default interface scope. */
				void set_myInt1(sc_integer value);
				
				/*! Gets the value of the variable 'myInt2' that is defined in the default interface scope. */
				sc_integer get_myInt2() const;
				
				/*! Sets the value of the variable 'myInt2' that is defined in the default interface scope. */
				void set_myInt2(sc_integer value);
				
				/*! Gets the value of the variable 'less' that is defined in the default interface scope. */
				sc_boolean get_less() const;
				
				/*! Sets the value of the variable 'less' that is defined in the default interface scope. */
				void set_less(sc_boolean value);
				
				/*! Gets the value of the variable 'greater' that is defined in the default interface scope. */
				sc_boolean get_greater() const;
				
				/*! Sets the value of the variable 'greater' that is defined in the default interface scope. */
				void set_greater(sc_boolean value);
				
				/*! Gets the value of the variable 'equalOrLess' that is defined in the default interface scope. */
				sc_boolean get_equalOrLess() const;
				
				/*! Sets the value of the variable 'equalOrLess' that is defined in the default interface scope. */
				void set_equalOrLess(sc_boolean value);
				
				/*! Gets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */
				sc_boolean get_equalOrGreater() const;
				
				/*! Sets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */
				void set_equalOrGreater(sc_boolean value);
				
				/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */
				sc_boolean get_equal() const;
				
				/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */
				void set_equal(sc_boolean value);
				
				/*! Gets the value of the variable 'notEqual' that is defined in the default interface scope. */
				sc_boolean get_notEqual() const;
				
				/*! Sets the value of the variable 'notEqual' that is defined in the default interface scope. */
				void set_notEqual(sc_boolean value);
				
				/*! Gets the value of the variable 'plus' that is defined in the default interface scope. */
				sc_integer get_plus() const;
				
				/*! Sets the value of the variable 'plus' that is defined in the default interface scope. */
				void set_plus(sc_integer value);
				
				/*! Gets the value of the variable 'minus' that is defined in the default interface scope. */
				sc_integer get_minus() const;
				
				/*! Sets the value of the variable 'minus' that is defined in the default interface scope. */
				void set_minus(sc_integer value);
				
				/*! Gets the value of the variable 'multiply' that is defined in the default interface scope. */
				sc_integer get_multiply() const;
				
				/*! Sets the value of the variable 'multiply' that is defined in the default interface scope. */
				void set_multiply(sc_integer value);
				
				/*! Gets the value of the variable 'division' that is defined in the default interface scope. */
				sc_integer get_division() const;
				
				/*! Sets the value of the variable 'division' that is defined in the default interface scope. */
				void set_division(sc_integer value);
				
				/*! Gets the value of the variable 'modulo' that is defined in the default interface scope. */
				sc_integer get_modulo() const;
				
				/*! Sets the value of the variable 'modulo' that is defined in the default interface scope. */
				void set_modulo(sc_integer value);
				
				/*! Gets the value of the variable 'negat' that is defined in the default interface scope. */
				sc_integer get_negat() const;
				
				/*! Sets the value of the variable 'negat' that is defined in the default interface scope. */
				void set_negat(sc_integer value);
				
				/*! Gets the value of the variable 'complement' that is defined in the default interface scope. */
				sc_boolean get_complement() const;
				
				/*! Sets the value of the variable 'complement' that is defined in the default interface scope. */
				void set_complement(sc_boolean value);
				
				/*! Gets the value of the variable 'multiAssign' that is defined in the default interface scope. */
				sc_integer get_multiAssign() const;
				
				/*! Sets the value of the variable 'multiAssign' that is defined in the default interface scope. */
				void set_multiAssign(sc_integer value);
				
				/*! Gets the value of the variable 'divAssign' that is defined in the default interface scope. */
				sc_integer get_divAssign() const;
				
				/*! Sets the value of the variable 'divAssign' that is defined in the default interface scope. */
				void set_divAssign(sc_integer value);
				
				/*! Gets the value of the variable 'plusAssign' that is defined in the default interface scope. */
				sc_integer get_plusAssign() const;
				
				/*! Sets the value of the variable 'plusAssign' that is defined in the default interface scope. */
				void set_plusAssign(sc_integer value);
				
				/*! Gets the value of the variable 'minusAssign' that is defined in the default interface scope. */
				sc_integer get_minusAssign() const;
				
				/*! Sets the value of the variable 'minusAssign' that is defined in the default interface scope. */
				void set_minusAssign(sc_integer value);
				
				/*! Gets the value of the variable 'moduloAssign' that is defined in the default interface scope. */
				sc_integer get_moduloAssign() const;
				
				/*! Sets the value of the variable 'moduloAssign' that is defined in the default interface scope. */
				void set_moduloAssign(sc_integer value);
				
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				
			private:
				friend class IntegerExpressions;
				sc_integer myInt1;
				sc_integer myInt2;
				sc_boolean less;
				sc_boolean greater;
				sc_boolean equalOrLess;
				sc_boolean equalOrGreater;
				sc_boolean equal;
				sc_boolean notEqual;
				sc_integer plus;
				sc_integer minus;
				sc_integer multiply;
				sc_integer division;
				sc_integer modulo;
				sc_integer negat;
				sc_boolean complement;
				sc_integer multiAssign;
				sc_integer divAssign;
				sc_integer plusAssign;
				sc_integer minusAssign;
				sc_integer moduloAssign;
				sc_boolean e1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myInt1' that is defined in the default interface scope. */
		sc_integer get_myInt1() const;
		
		/*! Sets the value of the variable 'myInt1' that is defined in the default interface scope. */
		void set_myInt1(sc_integer value);
		
		/*! Gets the value of the variable 'myInt2' that is defined in the default interface scope. */
		sc_integer get_myInt2() const;
		
		/*! Sets the value of the variable 'myInt2' that is defined in the default interface scope. */
		void set_myInt2(sc_integer value);
		
		/*! Gets the value of the variable 'less' that is defined in the default interface scope. */
		sc_boolean get_less() const;
		
		/*! Sets the value of the variable 'less' that is defined in the default interface scope. */
		void set_less(sc_boolean value);
		
		/*! Gets the value of the variable 'greater' that is defined in the default interface scope. */
		sc_boolean get_greater() const;
		
		/*! Sets the value of the variable 'greater' that is defined in the default interface scope. */
		void set_greater(sc_boolean value);
		
		/*! Gets the value of the variable 'equalOrLess' that is defined in the default interface scope. */
		sc_boolean get_equalOrLess() const;
		
		/*! Sets the value of the variable 'equalOrLess' that is defined in the default interface scope. */
		void set_equalOrLess(sc_boolean value);
		
		/*! Gets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */
		sc_boolean get_equalOrGreater() const;
		
		/*! Sets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */
		void set_equalOrGreater(sc_boolean value);
		
		/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */
		sc_boolean get_equal() const;
		
		/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */
		void set_equal(sc_boolean value);
		
		/*! Gets the value of the variable 'notEqual' that is defined in the default interface scope. */
		sc_boolean get_notEqual() const;
		
		/*! Sets the value of the variable 'notEqual' that is defined in the default interface scope. */
		void set_notEqual(sc_boolean value);
		
		/*! Gets the value of the variable 'plus' that is defined in the default interface scope. */
		sc_integer get_plus() const;
		
		/*! Sets the value of the variable 'plus' that is defined in the default interface scope. */
		void set_plus(sc_integer value);
		
		/*! Gets the value of the variable 'minus' that is defined in the default interface scope. */
		sc_integer get_minus() const;
		
		/*! Sets the value of the variable 'minus' that is defined in the default interface scope. */
		void set_minus(sc_integer value);
		
		/*! Gets the value of the variable 'multiply' that is defined in the default interface scope. */
		sc_integer get_multiply() const;
		
		/*! Sets the value of the variable 'multiply' that is defined in the default interface scope. */
		void set_multiply(sc_integer value);
		
		/*! Gets the value of the variable 'division' that is defined in the default interface scope. */
		sc_integer get_division() const;
		
		/*! Sets the value of the variable 'division' that is defined in the default interface scope. */
		void set_division(sc_integer value);
		
		/*! Gets the value of the variable 'modulo' that is defined in the default interface scope. */
		sc_integer get_modulo() const;
		
		/*! Sets the value of the variable 'modulo' that is defined in the default interface scope. */
		void set_modulo(sc_integer value);
		
		/*! Gets the value of the variable 'negat' that is defined in the default interface scope. */
		sc_integer get_negat() const;
		
		/*! Sets the value of the variable 'negat' that is defined in the default interface scope. */
		void set_negat(sc_integer value);
		
		/*! Gets the value of the variable 'complement' that is defined in the default interface scope. */
		sc_boolean get_complement() const;
		
		/*! Sets the value of the variable 'complement' that is defined in the default interface scope. */
		void set_complement(sc_boolean value);
		
		/*! Gets the value of the variable 'multiAssign' that is defined in the default interface scope. */
		sc_integer get_multiAssign() const;
		
		/*! Sets the value of the variable 'multiAssign' that is defined in the default interface scope. */
		void set_multiAssign(sc_integer value);
		
		/*! Gets the value of the variable 'divAssign' that is defined in the default interface scope. */
		sc_integer get_divAssign() const;
		
		/*! Sets the value of the variable 'divAssign' that is defined in the default interface scope. */
		void set_divAssign(sc_integer value);
		
		/*! Gets the value of the variable 'plusAssign' that is defined in the default interface scope. */
		sc_integer get_plusAssign() const;
		
		/*! Sets the value of the variable 'plusAssign' that is defined in the default interface scope. */
		void set_plusAssign(sc_integer value);
		
		/*! Gets the value of the variable 'minusAssign' that is defined in the default interface scope. */
		sc_integer get_minusAssign() const;
		
		/*! Sets the value of the variable 'minusAssign' that is defined in the default interface scope. */
		void set_minusAssign(sc_integer value);
		
		/*! Gets the value of the variable 'moduloAssign' that is defined in the default interface scope. */
		sc_integer get_moduloAssign() const;
		
		/*! Sets the value of the variable 'moduloAssign' that is defined in the default interface scope. */
		void set_moduloAssign(sc_integer value);
		
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
		sc_boolean isStateActive(IntegerExpressionsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		IntegerExpressionsStates stateConfVector[maxOrthogonalStates];
		
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
#endif /* INTEGEREXPRESSIONS_H_ */
