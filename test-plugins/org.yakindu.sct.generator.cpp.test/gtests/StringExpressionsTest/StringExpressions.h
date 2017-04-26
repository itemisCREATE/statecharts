
#ifndef STRINGEXPRESSIONS_H_
#define STRINGEXPRESSIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'StringExpressions'.
*/

class StringExpressions : public StatemachineInterface
{
	
	public:
		
		StringExpressions();
		
		~StringExpressions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_AssignmentChecked,
			main_region_Failed,
			main_region_VarToVarCompareSucceeded,
			main_region_VarToConstCompareSucceeded,
			main_region_ConstToVarCompareSucceeded,
			main_region_ConstToConstCompareSucceeded,
			StringExpressions_last_state
		} StringExpressionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'stringA' that is defined in the default interface scope. */
				sc_string get_stringA() const;
				
				/*! Sets the value of the variable 'stringA' that is defined in the default interface scope. */
				void set_stringA(sc_string value);
				
				/*! Gets the value of the variable 'stringA2' that is defined in the default interface scope. */
				sc_string get_stringA2() const;
				
				/*! Sets the value of the variable 'stringA2' that is defined in the default interface scope. */
				void set_stringA2(sc_string value);
				
				/*! Gets the value of the variable 'stringB' that is defined in the default interface scope. */
				sc_string get_stringB() const;
				
				/*! Sets the value of the variable 'stringB' that is defined in the default interface scope. */
				void set_stringB(sc_string value);
				
				/*! Gets the value of the variable 'quotedStringX' that is defined in the default interface scope. */
				sc_string get_quotedStringX() const;
				
				/*! Sets the value of the variable 'quotedStringX' that is defined in the default interface scope. */
				void set_quotedStringX(sc_string value);
				
				/*! Gets the value of the variable 'quotedStringY' that is defined in the default interface scope. */
				sc_string get_quotedStringY() const;
				
				/*! Sets the value of the variable 'quotedStringY' that is defined in the default interface scope. */
				void set_quotedStringY(sc_string value);
				
				/*! Gets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */
				sc_boolean get_stringVarEqual() const;
				
				/*! Sets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */
				void set_stringVarEqual(sc_boolean value);
				
				/*! Gets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */
				sc_boolean get_stringVarNotEqual() const;
				
				/*! Sets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */
				void set_stringVarNotEqual(sc_boolean value);
				
				/*! Gets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */
				sc_boolean get_guardStringNotEqual() const;
				
				/*! Sets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */
				void set_guardStringNotEqual(sc_boolean value);
				
				/*! Gets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */
				sc_boolean get_guardStringEqual() const;
				
				/*! Sets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */
				void set_guardStringEqual(sc_boolean value);
				
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				
			private:
				friend class StringExpressions;
				sc_string stringA;
				sc_string stringA2;
				sc_string stringB;
				sc_string quotedStringX;
				sc_string quotedStringY;
				sc_boolean stringVarEqual;
				sc_boolean stringVarNotEqual;
				sc_boolean guardStringNotEqual;
				sc_boolean guardStringEqual;
				sc_boolean e_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'stringA' that is defined in the default interface scope. */
		sc_string get_stringA() const;
		
		/*! Sets the value of the variable 'stringA' that is defined in the default interface scope. */
		void set_stringA(sc_string value);
		
		/*! Gets the value of the variable 'stringA2' that is defined in the default interface scope. */
		sc_string get_stringA2() const;
		
		/*! Sets the value of the variable 'stringA2' that is defined in the default interface scope. */
		void set_stringA2(sc_string value);
		
		/*! Gets the value of the variable 'stringB' that is defined in the default interface scope. */
		sc_string get_stringB() const;
		
		/*! Sets the value of the variable 'stringB' that is defined in the default interface scope. */
		void set_stringB(sc_string value);
		
		/*! Gets the value of the variable 'quotedStringX' that is defined in the default interface scope. */
		sc_string get_quotedStringX() const;
		
		/*! Sets the value of the variable 'quotedStringX' that is defined in the default interface scope. */
		void set_quotedStringX(sc_string value);
		
		/*! Gets the value of the variable 'quotedStringY' that is defined in the default interface scope. */
		sc_string get_quotedStringY() const;
		
		/*! Sets the value of the variable 'quotedStringY' that is defined in the default interface scope. */
		void set_quotedStringY(sc_string value);
		
		/*! Gets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */
		sc_boolean get_stringVarEqual() const;
		
		/*! Sets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */
		void set_stringVarEqual(sc_boolean value);
		
		/*! Gets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */
		sc_boolean get_stringVarNotEqual() const;
		
		/*! Sets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */
		void set_stringVarNotEqual(sc_boolean value);
		
		/*! Gets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */
		sc_boolean get_guardStringNotEqual() const;
		
		/*! Sets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */
		void set_guardStringNotEqual(sc_boolean value);
		
		/*! Gets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */
		sc_boolean get_guardStringEqual() const;
		
		/*! Sets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */
		void set_guardStringEqual(sc_boolean value);
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		
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
		sc_boolean isStateActive(StringExpressionsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		StringExpressionsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_AssignmentChecked_tr0_tr0();
		sc_boolean check_main_region_VarToVarCompareSucceeded_tr0_tr0();
		sc_boolean check_main_region_VarToConstCompareSucceeded_tr0_tr0();
		sc_boolean check_main_region_ConstToVarCompareSucceeded_tr0_tr0();
		sc_boolean check_main_region__choice_0_tr1_tr1();
		sc_boolean check_main_region__choice_0_tr0();
		sc_boolean check_main_region__choice_1_tr1_tr1();
		sc_boolean check_main_region__choice_1_tr0();
		sc_boolean check_main_region__choice_2_tr1_tr1();
		sc_boolean check_main_region__choice_2_tr0();
		sc_boolean check_main_region__choice_3_tr0_tr0();
		sc_boolean check_main_region__choice_3_tr1();
		sc_boolean check_main_region__choice_4_tr1_tr1();
		sc_boolean check_main_region__choice_4_tr0();
		sc_boolean check_main_region__choice_5_tr1_tr1();
		sc_boolean check_main_region__choice_5_tr0();
		sc_boolean check_main_region__choice_6_tr0();
		sc_boolean check_main_region__choice_7_tr0_tr0();
		sc_boolean check_main_region__choice_7_tr1();
		sc_boolean check_main_region__choice_8_tr1_tr1();
		sc_boolean check_main_region__choice_8_tr0();
		sc_boolean check_main_region__choice_9_tr1_tr1();
		sc_boolean check_main_region__choice_9_tr0();
		sc_boolean check_main_region__choice_10_tr0();
		sc_boolean check_main_region__choice_11_tr0_tr0();
		sc_boolean check_main_region__choice_11_tr1();
		sc_boolean check_main_region__choice_12_tr1_tr1();
		sc_boolean check_main_region__choice_12_tr0();
		sc_boolean check_main_region__choice_13_tr1_tr1();
		sc_boolean check_main_region__choice_13_tr0();
		sc_boolean check_main_region__choice_14_tr0();
		void effect_main_region_AssignmentChecked_tr0();
		void effect_main_region_VarToVarCompareSucceeded_tr0();
		void effect_main_region_VarToConstCompareSucceeded_tr0();
		void effect_main_region_ConstToVarCompareSucceeded_tr0();
		void effect_main_region__choice_0_tr1();
		void effect_main_region__choice_0_tr0();
		void effect_main_region__choice_1_tr1();
		void effect_main_region__choice_1_tr0();
		void effect_main_region__choice_2_tr1();
		void effect_main_region__choice_2_tr0();
		void effect_main_region__choice_3_tr0();
		void effect_main_region__choice_3_tr1();
		void effect_main_region__choice_4_tr1();
		void effect_main_region__choice_4_tr0();
		void effect_main_region__choice_5_tr1();
		void effect_main_region__choice_5_tr0();
		void effect_main_region__choice_6_tr0();
		void effect_main_region__choice_7_tr0();
		void effect_main_region__choice_7_tr1();
		void effect_main_region__choice_8_tr1();
		void effect_main_region__choice_8_tr0();
		void effect_main_region__choice_9_tr1();
		void effect_main_region__choice_9_tr0();
		void effect_main_region__choice_10_tr0();
		void effect_main_region__choice_11_tr0();
		void effect_main_region__choice_11_tr1();
		void effect_main_region__choice_12_tr1();
		void effect_main_region__choice_12_tr0();
		void effect_main_region__choice_13_tr1();
		void effect_main_region__choice_13_tr0();
		void effect_main_region__choice_14_tr0();
		void enact_main_region_AssignmentChecked();
		void enseq_main_region_AssignmentChecked_default();
		void enseq_main_region_Failed_default();
		void enseq_main_region_VarToVarCompareSucceeded_default();
		void enseq_main_region_VarToConstCompareSucceeded_default();
		void enseq_main_region_ConstToVarCompareSucceeded_default();
		void enseq_main_region_ConstToConstCompareSucceeded_default();
		void enseq_main_region_default();
		void exseq_main_region_AssignmentChecked();
		void exseq_main_region_Failed();
		void exseq_main_region_VarToVarCompareSucceeded();
		void exseq_main_region_VarToConstCompareSucceeded();
		void exseq_main_region_ConstToVarCompareSucceeded();
		void exseq_main_region_ConstToConstCompareSucceeded();
		void exseq_main_region();
		void react_main_region_AssignmentChecked();
		void react_main_region_Failed();
		void react_main_region_VarToVarCompareSucceeded();
		void react_main_region_VarToConstCompareSucceeded();
		void react_main_region_ConstToVarCompareSucceeded();
		void react_main_region_ConstToConstCompareSucceeded();
		void react_main_region__choice_0();
		void react_main_region__choice_1();
		void react_main_region__choice_2();
		void react_main_region__choice_3();
		void react_main_region__choice_4();
		void react_main_region__choice_5();
		void react_main_region__choice_6();
		void react_main_region__choice_7();
		void react_main_region__choice_8();
		void react_main_region__choice_9();
		void react_main_region__choice_10();
		void react_main_region__choice_11();
		void react_main_region__choice_12();
		void react_main_region__choice_13();
		void react_main_region__choice_14();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STRINGEXPRESSIONS_H_ */
