
#ifndef NAMEDINTERFACEACCESS_H_
#define NAMEDINTERFACEACCESS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'NamedInterfaceAccess'.
*/

class NamedInterfaceAccess : public StatemachineInterface
{
	
	public:
		
		NamedInterfaceAccess();
		
		~NamedInterfaceAccess();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			region_1_Idle,
			region_1_Number1Pressed,
			region_1_Number2Pressed,
			region_1_Number3Pressed,
			_region1_Closed,
			_region1_Open,
			NamedInterfaceAccess_last_state
		} NamedInterfaceAccessStates;
		
		//! Inner class for Safe interface scope.
		class SCI_Safe
		{
			
			public:
				/*! Checks if the out event 'open' that is defined in the interface scope 'Safe' has been raised. */
				sc_boolean isRaised_open() const;
				
				/*! Checks if the out event 'close' that is defined in the interface scope 'Safe' has been raised. */
				sc_boolean isRaised_close() const;
				
				
			private:
				friend class NamedInterfaceAccess;
				sc_boolean open_raised;
				sc_boolean close_raised;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Safe'. */
		SCI_Safe* getSCI_Safe();
		
		//! Inner class for User interface scope.
		class SCI_User
		{
			
			public:
				/*! Raises the in event 'numberPressed' that is defined in the interface scope 'User'. */
				void raise_numberPressed(sc_integer value);
				
				/*! Raises the in event 'reset' that is defined in the interface scope 'User'. */
				void raise_reset();
				
				
			private:
				friend class NamedInterfaceAccess;
				sc_boolean numberPressed_raised;
				sc_integer numberPressed_value;
				sc_boolean reset_raised;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_User'. */
		SCI_User* getSCI_User();
		
		
		
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
		sc_boolean isStateActive(NamedInterfaceAccessStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Gets the value of the variable 'number1' that is defined in the internal scope. */
				sc_integer get_number1() const;
				
				/*! Sets the value of the variable 'number1' that is defined in the internal scope. */
				void set_number1(sc_integer value);
				
				/*! Gets the value of the variable 'number2' that is defined in the internal scope. */
				sc_integer get_number2() const;
				
				/*! Sets the value of the variable 'number2' that is defined in the internal scope. */
				void set_number2(sc_integer value);
				
				/*! Gets the value of the variable 'number3' that is defined in the internal scope. */
				sc_integer get_number3() const;
				
				/*! Sets the value of the variable 'number3' that is defined in the internal scope. */
				void set_number3(sc_integer value);
				
				
			private:
				friend class NamedInterfaceAccess;
				sc_integer number1;
				sc_integer number2;
				sc_integer number3;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		
		
		NamedInterfaceAccessStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_Safe ifaceSafe;
		SCI_User ifaceUser;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_region_1_Idle_tr0_tr0();
		sc_boolean check_region_1_Number1Pressed_tr0_tr0();
		sc_boolean check_region_1_Number1Pressed_tr1_tr1();
		sc_boolean check_region_1_Number2Pressed_tr0_tr0();
		sc_boolean check_region_1_Number2Pressed_tr1_tr1();
		sc_boolean check_region_1_Number3Pressed_tr0_tr0();
		sc_boolean check__region1_Closed_tr0_tr0();
		sc_boolean check__region1_Open_tr0_tr0();
		void effect_region_1_Idle_tr0();
		void effect_region_1_Number1Pressed_tr0();
		void effect_region_1_Number1Pressed_tr1();
		void effect_region_1_Number2Pressed_tr0();
		void effect_region_1_Number2Pressed_tr1();
		void effect_region_1_Number3Pressed_tr0();
		void effect__region1_Closed_tr0();
		void effect__region1_Open_tr0();
		void enact_region_1_Idle();
		void enact_region_1_Number3Pressed();
		void enseq_region_1_Idle_default();
		void enseq_region_1_Number1Pressed_default();
		void enseq_region_1_Number2Pressed_default();
		void enseq_region_1_Number3Pressed_default();
		void enseq__region1_Closed_default();
		void enseq__region1_Open_default();
		void enseq_region_1_default();
		void enseq__region1_default();
		void exseq_region_1_Idle();
		void exseq_region_1_Number1Pressed();
		void exseq_region_1_Number2Pressed();
		void exseq_region_1_Number3Pressed();
		void exseq__region1_Closed();
		void exseq__region1_Open();
		void exseq_region_1();
		void exseq__region1();
		void react_region_1_Idle();
		void react_region_1_Number1Pressed();
		void react_region_1_Number2Pressed();
		void react_region_1_Number3Pressed();
		void react__region1_Closed();
		void react__region1_Open();
		void react_region_1__entry_Default();
		void react__region1__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* NAMEDINTERFACEACCESS_H_ */
