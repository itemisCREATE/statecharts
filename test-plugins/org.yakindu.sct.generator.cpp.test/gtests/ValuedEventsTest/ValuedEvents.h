
#ifndef VALUEDEVENTS_H_
#define VALUEDEVENTS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'ValuedEvents'.
*/

class ValuedEvents : public StatemachineInterface
{
	
	public:
		
		ValuedEvents();
		
		~ValuedEvents();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region1_A,
			integer_region_B,
			integer_region_C,
			integer_region_D,
			boolean_region_B,
			boolean_region_C,
			boolean_region_D,
			real_region_B,
			real_region_C,
			real_region_D,
			string_region_B,
			string_region_C,
			string_region_D,
			ValuedEvents_last_state
		} ValuedEventsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'integerEvent' that is defined in the default interface scope. */
				void raise_integerEvent(sc_integer value);
				
				/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
				sc_integer get_myInt() const;
				
				/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */
				void set_myInt(sc_integer value);
				
				/*! Raises the in event 'booleanEvent' that is defined in the default interface scope. */
				void raise_booleanEvent(sc_boolean value);
				
				/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */
				sc_boolean get_myBool() const;
				
				/*! Sets the value of the variable 'myBool' that is defined in the default interface scope. */
				void set_myBool(sc_boolean value);
				
				/*! Raises the in event 'realEvent' that is defined in the default interface scope. */
				void raise_realEvent(sc_real value);
				
				/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */
				sc_real get_myReal() const;
				
				/*! Sets the value of the variable 'myReal' that is defined in the default interface scope. */
				void set_myReal(sc_real value);
				
				/*! Raises the in event 'stringEvent' that is defined in the default interface scope. */
				void raise_stringEvent(sc_string value);
				
				/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
				sc_string get_myString() const;
				
				/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */
				void set_myString(sc_string value);
				
				
			private:
				friend class ValuedEvents;
				sc_boolean integerEvent_raised;
				sc_integer integerEvent_value;
				sc_integer myInt;
				sc_boolean booleanEvent_raised;
				sc_boolean booleanEvent_value;
				sc_boolean myBool;
				sc_boolean realEvent_raised;
				sc_real realEvent_value;
				sc_real myReal;
				sc_boolean stringEvent_raised;
				sc_string stringEvent_value;
				sc_string myString;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'integerEvent' that is defined in the default interface scope. */
		void raise_integerEvent(sc_integer value);
		
		/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */
		sc_integer get_myInt() const;
		
		/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */
		void set_myInt(sc_integer value);
		
		/*! Raises the in event 'booleanEvent' that is defined in the default interface scope. */
		void raise_booleanEvent(sc_boolean value);
		
		/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */
		sc_boolean get_myBool() const;
		
		/*! Sets the value of the variable 'myBool' that is defined in the default interface scope. */
		void set_myBool(sc_boolean value);
		
		/*! Raises the in event 'realEvent' that is defined in the default interface scope. */
		void raise_realEvent(sc_real value);
		
		/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */
		sc_real get_myReal() const;
		
		/*! Sets the value of the variable 'myReal' that is defined in the default interface scope. */
		void set_myReal(sc_real value);
		
		/*! Raises the in event 'stringEvent' that is defined in the default interface scope. */
		void raise_stringEvent(sc_string value);
		
		/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
		sc_string get_myString() const;
		
		/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */
		void set_myString(sc_string value);
		
		
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
		sc_boolean isStateActive(ValuedEventsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 5;
		
		
		ValuedEventsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_integer_region_B_tr0_tr0();
		sc_boolean check_integer_region_C_tr0_tr0();
		sc_boolean check_boolean_region_B_tr0_tr0();
		sc_boolean check_boolean_region_C_tr0_tr0();
		sc_boolean check_real_region_B_tr0_tr0();
		sc_boolean check_real_region_C_tr0_tr0();
		sc_boolean check_string_region_B_tr0_tr0();
		sc_boolean check_string_region_C_tr0_tr0();
		void effect_integer_region_B_tr0();
		void effect_integer_region_C_tr0();
		void effect_boolean_region_B_tr0();
		void effect_boolean_region_C_tr0();
		void effect_real_region_B_tr0();
		void effect_real_region_C_tr0();
		void effect_string_region_B_tr0();
		void effect_string_region_C_tr0();
		void enact_main_region1_A();
		void enseq_main_region1_A_default();
		void enseq_integer_region_B_default();
		void enseq_integer_region_C_default();
		void enseq_integer_region_D_default();
		void enseq_boolean_region_B_default();
		void enseq_boolean_region_C_default();
		void enseq_boolean_region_D_default();
		void enseq_real_region_B_default();
		void enseq_real_region_C_default();
		void enseq_real_region_D_default();
		void enseq_string_region_B_default();
		void enseq_string_region_C_default();
		void enseq_string_region_D_default();
		void enseq_main_region1_default();
		void enseq_integer_region_default();
		void enseq_boolean_region_default();
		void enseq_real_region_default();
		void enseq_string_region_default();
		void exseq_main_region1_A();
		void exseq_integer_region_B();
		void exseq_integer_region_C();
		void exseq_integer_region_D();
		void exseq_boolean_region_B();
		void exseq_boolean_region_C();
		void exseq_boolean_region_D();
		void exseq_real_region_B();
		void exseq_real_region_C();
		void exseq_real_region_D();
		void exseq_string_region_B();
		void exseq_string_region_C();
		void exseq_string_region_D();
		void exseq_main_region1();
		void exseq_integer_region();
		void exseq_boolean_region();
		void exseq_real_region();
		void exseq_string_region();
		void react_main_region1_A();
		void react_integer_region_B();
		void react_integer_region_C();
		void react_integer_region_D();
		void react_boolean_region_B();
		void react_boolean_region_C();
		void react_boolean_region_D();
		void react_real_region_B();
		void react_real_region_C();
		void react_real_region_D();
		void react_string_region_B();
		void react_string_region_C();
		void react_string_region_D();
		void react_main_region1__entry_Default();
		void react_integer_region__entry_Default();
		void react_boolean_region__entry_Default();
		void react_real_region__entry_Default();
		void react_string_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* VALUEDEVENTS_H_ */
