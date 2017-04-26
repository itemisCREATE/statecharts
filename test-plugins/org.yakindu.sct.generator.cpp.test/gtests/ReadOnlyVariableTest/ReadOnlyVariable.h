
#ifndef READONLYVARIABLE_H_
#define READONLYVARIABLE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ReadOnlyVariable'.
*/

class ReadOnlyVariable : public StatemachineInterface
{
	
	public:
		
		ReadOnlyVariable();
		
		~ReadOnlyVariable();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_StateB,
			main_region_StateA,
			ReadOnlyVariable_last_state
		} ReadOnlyVariableStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
				sc_integer get_myInt() const;
				
				/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
				sc_string get_myString() const;
				
				/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */
				sc_boolean get_myBool() const;
				
				/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */
				sc_real get_myReal() const;
				
				
			private:
				friend class ReadOnlyVariable;
				sc_integer myInt;
				sc_string myString;
				sc_boolean myBool;
				sc_real myReal;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
		sc_integer get_myInt() const;
		
		/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
		sc_string get_myString() const;
		
		/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */
		sc_boolean get_myBool() const;
		
		/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */
		sc_real get_myReal() const;
		
		//! Inner class for A interface scope.
		class SCI_A
		{
			
			public:
				/*! Gets the value of the variable 'myInt' that is defined in the interface scope 'A'. */
				sc_integer get_myInt() const;
				
				/*! Gets the value of the variable 'myString' that is defined in the interface scope 'A'. */
				sc_string get_myString() const;
				
				/*! Gets the value of the variable 'myBool' that is defined in the interface scope 'A'. */
				sc_boolean get_myBool() const;
				
				/*! Gets the value of the variable 'myReal' that is defined in the interface scope 'A'. */
				sc_real get_myReal() const;
				
				
			private:
				friend class ReadOnlyVariable;
				sc_integer myInt;
				sc_string myString;
				sc_boolean myBool;
				sc_real myReal;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_A'. */
		SCI_A* getSCI_A();
		
		
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
		sc_boolean isStateActive(ReadOnlyVariableStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ReadOnlyVariableStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		SCI_A ifaceA;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_StateA_tr0_tr0();
		void effect_main_region_StateA_tr0();
		void enact_main_region_StateB();
		void enseq_main_region_StateB_default();
		void enseq_main_region_StateA_default();
		void enseq_main_region_default();
		void exseq_main_region_StateB();
		void exseq_main_region_StateA();
		void exseq_main_region();
		void react_main_region_StateB();
		void react_main_region_StateA();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* READONLYVARIABLE_H_ */
