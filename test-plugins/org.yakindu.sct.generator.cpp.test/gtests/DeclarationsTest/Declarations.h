
#ifndef DECLARATIONS_H_
#define DECLARATIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Declarations'.
*/

class Declarations : public StatemachineInterface
{
	
	public:
		
		Declarations();
		
		~Declarations();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			Declarations_last_state
		} DeclarationsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'evA' that is defined in the default interface scope. */
				void raise_evA();
				
				/*! Checks if the out event 'evB' that is defined in the default interface scope has been raised. */
				sc_boolean isRaised_evB() const;
				
				/*! Raises the in event 'evC' that is defined in the default interface scope. */
				void raise_evC(sc_boolean value);
				
				/*! Checks if the out event 'evD' that is defined in the default interface scope has been raised. */
				sc_boolean isRaised_evD() const;
				
				/*! Gets the value of the out event 'evD' that is defined in the default interface scope. */
				sc_integer get_evD_value() const;
				
				/*! Raises the in event 'evE' that is defined in the default interface scope. */
				void raise_evE(sc_real value);
				
				/*! Checks if the out event 'evF' that is defined in the default interface scope has been raised. */
				sc_boolean isRaised_evF() const;
				
				/*! Gets the value of the out event 'evF' that is defined in the default interface scope. */
				sc_string get_evF_value() const;
				
				/*! Gets the value of the variable 'varA' that is defined in the default interface scope. */
				sc_boolean get_varA() const;
				
				/*! Sets the value of the variable 'varA' that is defined in the default interface scope. */
				void set_varA(sc_boolean value);
				
				/*! Gets the value of the variable 'varB' that is defined in the default interface scope. */
				sc_integer get_varB() const;
				
				/*! Sets the value of the variable 'varB' that is defined in the default interface scope. */
				void set_varB(sc_integer value);
				
				/*! Gets the value of the variable 'varC' that is defined in the default interface scope. */
				sc_real get_varC() const;
				
				/*! Sets the value of the variable 'varC' that is defined in the default interface scope. */
				void set_varC(sc_real value);
				
				/*! Gets the value of the variable 'varD' that is defined in the default interface scope. */
				sc_string get_varD() const;
				
				/*! Sets the value of the variable 'varD' that is defined in the default interface scope. */
				void set_varD(sc_string value);
				
				/*! Gets the value of the variable 'varE' that is defined in the default interface scope. */
				sc_integer get_varE() const;
				
				/*! Sets the value of the variable 'varE' that is defined in the default interface scope. */
				void set_varE(sc_integer value);
				
				
			private:
				friend class Declarations;
				sc_boolean evA_raised;
				sc_boolean evB_raised;
				sc_boolean evC_raised;
				sc_boolean evC_value;
				sc_boolean evD_raised;
				sc_integer evD_value;
				sc_boolean evE_raised;
				sc_real evE_value;
				sc_boolean evF_raised;
				sc_string evF_value;
				sc_boolean varA;
				sc_integer varB;
				sc_real varC;
				sc_string varD;
				sc_integer varE;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'evA' that is defined in the default interface scope. */
		void raise_evA();
		
		/*! Checks if the out event 'evB' that is defined in the default interface scope has been raised. */
		sc_boolean isRaised_evB() const;
		
		/*! Raises the in event 'evC' that is defined in the default interface scope. */
		void raise_evC(sc_boolean value);
		
		/*! Checks if the out event 'evD' that is defined in the default interface scope has been raised. */
		sc_boolean isRaised_evD() const;
		
		/*! Gets the value of the out event 'evD' that is defined in the default interface scope. */
		sc_integer get_evD_value() const;
		
		/*! Raises the in event 'evE' that is defined in the default interface scope. */
		void raise_evE(sc_real value);
		
		/*! Checks if the out event 'evF' that is defined in the default interface scope has been raised. */
		sc_boolean isRaised_evF() const;
		
		/*! Gets the value of the out event 'evF' that is defined in the default interface scope. */
		sc_string get_evF_value() const;
		
		/*! Gets the value of the variable 'varA' that is defined in the default interface scope. */
		sc_boolean get_varA() const;
		
		/*! Sets the value of the variable 'varA' that is defined in the default interface scope. */
		void set_varA(sc_boolean value);
		
		/*! Gets the value of the variable 'varB' that is defined in the default interface scope. */
		sc_integer get_varB() const;
		
		/*! Sets the value of the variable 'varB' that is defined in the default interface scope. */
		void set_varB(sc_integer value);
		
		/*! Gets the value of the variable 'varC' that is defined in the default interface scope. */
		sc_real get_varC() const;
		
		/*! Sets the value of the variable 'varC' that is defined in the default interface scope. */
		void set_varC(sc_real value);
		
		/*! Gets the value of the variable 'varD' that is defined in the default interface scope. */
		sc_string get_varD() const;
		
		/*! Sets the value of the variable 'varD' that is defined in the default interface scope. */
		void set_varD(sc_string value);
		
		/*! Gets the value of the variable 'varE' that is defined in the default interface scope. */
		sc_integer get_varE() const;
		
		/*! Sets the value of the variable 'varE' that is defined in the default interface scope. */
		void set_varE(sc_integer value);
		
		//! Inner class for ifA interface scope.
		class SCI_IfA
		{
			
			public:
				/*! Raises the in event 'evA' that is defined in the interface scope 'ifA'. */
				void raise_evA();
				
				/*! Checks if the out event 'evB' that is defined in the interface scope 'ifA' has been raised. */
				sc_boolean isRaised_evB() const;
				
				/*! Raises the in event 'evC' that is defined in the interface scope 'ifA'. */
				void raise_evC(sc_boolean value);
				
				/*! Checks if the out event 'evD' that is defined in the interface scope 'ifA' has been raised. */
				sc_boolean isRaised_evD() const;
				
				/*! Gets the value of the out event 'evD' that is defined in the interface scope 'ifA'. */
				sc_integer get_evD_value() const;
				
				/*! Raises the in event 'evE' that is defined in the interface scope 'ifA'. */
				void raise_evE(sc_real value);
				
				/*! Checks if the out event 'evF' that is defined in the interface scope 'ifA' has been raised. */
				sc_boolean isRaised_evF() const;
				
				/*! Gets the value of the out event 'evF' that is defined in the interface scope 'ifA'. */
				sc_string get_evF_value() const;
				
				/*! Gets the value of the variable 'varA' that is defined in the interface scope 'ifA'. */
				sc_boolean get_varA() const;
				
				/*! Sets the value of the variable 'varA' that is defined in the interface scope 'ifA'. */
				void set_varA(sc_boolean value);
				
				/*! Gets the value of the variable 'varB' that is defined in the interface scope 'ifA'. */
				sc_integer get_varB() const;
				
				/*! Sets the value of the variable 'varB' that is defined in the interface scope 'ifA'. */
				void set_varB(sc_integer value);
				
				/*! Gets the value of the variable 'varC' that is defined in the interface scope 'ifA'. */
				sc_real get_varC() const;
				
				/*! Sets the value of the variable 'varC' that is defined in the interface scope 'ifA'. */
				void set_varC(sc_real value);
				
				/*! Gets the value of the variable 'varD' that is defined in the interface scope 'ifA'. */
				sc_string get_varD() const;
				
				/*! Sets the value of the variable 'varD' that is defined in the interface scope 'ifA'. */
				void set_varD(sc_string value);
				
				/*! Gets the value of the variable 'varE' that is defined in the interface scope 'ifA'. */
				sc_integer get_varE() const;
				
				/*! Sets the value of the variable 'varE' that is defined in the interface scope 'ifA'. */
				void set_varE(sc_integer value);
				
				
			private:
				friend class Declarations;
				sc_boolean evA_raised;
				sc_boolean evB_raised;
				sc_boolean evC_raised;
				sc_boolean evC_value;
				sc_boolean evD_raised;
				sc_integer evD_value;
				sc_boolean evE_raised;
				sc_real evE_value;
				sc_boolean evF_raised;
				sc_string evF_value;
				sc_boolean varA;
				sc_integer varB;
				sc_real varC;
				sc_string varD;
				sc_integer varE;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_IfA'. */
		SCI_IfA* getSCI_IfA();
		
		
		
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
		sc_boolean isStateActive(DeclarationsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Raises the in event 'evInA' that is defined in the internal scope. */
				void raise_evInA();
				
				/*! Checks if the out event 'evInA' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInA() const;
				
				/*! Raises the in event 'evInB' that is defined in the internal scope. */
				void raise_evInB();
				
				/*! Checks if the out event 'evInB' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInB() const;
				
				/*! Raises the in event 'evInC' that is defined in the internal scope. */
				void raise_evInC(sc_boolean value);
				
				/*! Checks if the out event 'evInC' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInC() const;
				
				/*! Gets the value of the out event 'evInC' that is defined in the internal scope. */
				sc_boolean get_evInC_value() const;
				
				/*! Raises the in event 'evInD' that is defined in the internal scope. */
				void raise_evInD(sc_integer value);
				
				/*! Checks if the out event 'evInD' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInD() const;
				
				/*! Gets the value of the out event 'evInD' that is defined in the internal scope. */
				sc_integer get_evInD_value() const;
				
				/*! Raises the in event 'evInE' that is defined in the internal scope. */
				void raise_evInE(sc_real value);
				
				/*! Checks if the out event 'evInE' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInE() const;
				
				/*! Gets the value of the out event 'evInE' that is defined in the internal scope. */
				sc_real get_evInE_value() const;
				
				/*! Raises the in event 'evInF' that is defined in the internal scope. */
				void raise_evInF(sc_string value);
				
				/*! Checks if the out event 'evInF' that is defined in the internal scope has been raised. */
				sc_boolean isRaised_evInF() const;
				
				/*! Gets the value of the out event 'evInF' that is defined in the internal scope. */
				sc_string get_evInF_value() const;
				
				/*! Gets the value of the variable 'varInA' that is defined in the internal scope. */
				sc_boolean get_varInA() const;
				
				/*! Sets the value of the variable 'varInA' that is defined in the internal scope. */
				void set_varInA(sc_boolean value);
				
				/*! Gets the value of the variable 'varInB' that is defined in the internal scope. */
				sc_integer get_varInB() const;
				
				/*! Sets the value of the variable 'varInB' that is defined in the internal scope. */
				void set_varInB(sc_integer value);
				
				/*! Gets the value of the variable 'varInC' that is defined in the internal scope. */
				sc_real get_varInC() const;
				
				/*! Sets the value of the variable 'varInC' that is defined in the internal scope. */
				void set_varInC(sc_real value);
				
				/*! Gets the value of the variable 'varInD' that is defined in the internal scope. */
				sc_string get_varInD() const;
				
				/*! Sets the value of the variable 'varInD' that is defined in the internal scope. */
				void set_varInD(sc_string value);
				
				/*! Gets the value of the variable 'varInE' that is defined in the internal scope. */
				sc_integer get_varInE() const;
				
				/*! Sets the value of the variable 'varInE' that is defined in the internal scope. */
				void set_varInE(sc_integer value);
				
				
			private:
				friend class Declarations;
				sc_boolean evInA_raised;
				sc_boolean evInB_raised;
				sc_boolean evInC_raised;
				sc_boolean evInC_value;
				sc_boolean evInD_raised;
				sc_integer evInD_value;
				sc_boolean evInE_raised;
				sc_real evInE_value;
				sc_boolean evInF_raised;
				sc_string evInF_value;
				sc_boolean varInA;
				sc_integer varInB;
				sc_real varInC;
				sc_string varInD;
				sc_integer varInE;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		DeclarationsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		SCI_IfA ifaceIfA;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_B_tr0_tr0();
		sc_boolean check_main_region_B_tr1_tr1();
		sc_boolean check_main_region_B_tr2_tr2();
		sc_boolean check_main_region_B_tr3_tr3();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_B_tr0();
		void effect_main_region_B_tr1();
		void effect_main_region_B_tr2();
		void effect_main_region_B_tr3();
		void enact_main_region_A();
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
#endif /* DECLARATIONS_H_ */
