
#ifndef BITEXPRESSIONS_H_
#define BITEXPRESSIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'BitExpressions'.
*/

class BitExpressions : public StatemachineInterface
{
	
	public:
		
		BitExpressions();
		
		~BitExpressions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateA,
			main_region_StateB,
			BitExpressions_last_state
		} BitExpressionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myBit1' that is defined in the default interface scope. */
				sc_integer get_myBit1() const;
				
				/*! Sets the value of the variable 'myBit1' that is defined in the default interface scope. */
				void set_myBit1(sc_integer value);
				
				/*! Gets the value of the variable 'myBit2' that is defined in the default interface scope. */
				sc_integer get_myBit2() const;
				
				/*! Sets the value of the variable 'myBit2' that is defined in the default interface scope. */
				void set_myBit2(sc_integer value);
				
				/*! Gets the value of the variable 'leftBitshift' that is defined in the default interface scope. */
				sc_integer get_leftBitshift() const;
				
				/*! Sets the value of the variable 'leftBitshift' that is defined in the default interface scope. */
				void set_leftBitshift(sc_integer value);
				
				/*! Gets the value of the variable 'rightBitshift' that is defined in the default interface scope. */
				sc_integer get_rightBitshift() const;
				
				/*! Sets the value of the variable 'rightBitshift' that is defined in the default interface scope. */
				void set_rightBitshift(sc_integer value);
				
				/*! Gets the value of the variable 'complementBitshift' that is defined in the default interface scope. */
				sc_integer get_complementBitshift() const;
				
				/*! Sets the value of the variable 'complementBitshift' that is defined in the default interface scope. */
				void set_complementBitshift(sc_integer value);
				
				/*! Gets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */
				sc_integer get_bitwiseAnd() const;
				
				/*! Sets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */
				void set_bitwiseAnd(sc_integer value);
				
				/*! Gets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */
				sc_integer get_bitwiseOr() const;
				
				/*! Sets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */
				void set_bitwiseOr(sc_integer value);
				
				/*! Gets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */
				sc_integer get_bitwiseXor() const;
				
				/*! Sets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */
				void set_bitwiseXor(sc_integer value);
				
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				
			private:
				friend class BitExpressions;
				sc_integer myBit1;
				sc_integer myBit2;
				sc_integer leftBitshift;
				sc_integer rightBitshift;
				sc_integer complementBitshift;
				sc_integer bitwiseAnd;
				sc_integer bitwiseOr;
				sc_integer bitwiseXor;
				sc_boolean e1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myBit1' that is defined in the default interface scope. */
		sc_integer get_myBit1() const;
		
		/*! Sets the value of the variable 'myBit1' that is defined in the default interface scope. */
		void set_myBit1(sc_integer value);
		
		/*! Gets the value of the variable 'myBit2' that is defined in the default interface scope. */
		sc_integer get_myBit2() const;
		
		/*! Sets the value of the variable 'myBit2' that is defined in the default interface scope. */
		void set_myBit2(sc_integer value);
		
		/*! Gets the value of the variable 'leftBitshift' that is defined in the default interface scope. */
		sc_integer get_leftBitshift() const;
		
		/*! Sets the value of the variable 'leftBitshift' that is defined in the default interface scope. */
		void set_leftBitshift(sc_integer value);
		
		/*! Gets the value of the variable 'rightBitshift' that is defined in the default interface scope. */
		sc_integer get_rightBitshift() const;
		
		/*! Sets the value of the variable 'rightBitshift' that is defined in the default interface scope. */
		void set_rightBitshift(sc_integer value);
		
		/*! Gets the value of the variable 'complementBitshift' that is defined in the default interface scope. */
		sc_integer get_complementBitshift() const;
		
		/*! Sets the value of the variable 'complementBitshift' that is defined in the default interface scope. */
		void set_complementBitshift(sc_integer value);
		
		/*! Gets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */
		sc_integer get_bitwiseAnd() const;
		
		/*! Sets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */
		void set_bitwiseAnd(sc_integer value);
		
		/*! Gets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */
		sc_integer get_bitwiseOr() const;
		
		/*! Sets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */
		void set_bitwiseOr(sc_integer value);
		
		/*! Gets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */
		sc_integer get_bitwiseXor() const;
		
		/*! Sets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */
		void set_bitwiseXor(sc_integer value);
		
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
		sc_boolean isStateActive(BitExpressionsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		BitExpressionsStates stateConfVector[maxOrthogonalStates];
		
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
#endif /* BITEXPRESSIONS_H_ */
