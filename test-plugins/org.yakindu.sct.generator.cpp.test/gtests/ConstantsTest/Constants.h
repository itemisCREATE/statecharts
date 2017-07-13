
#ifndef CONSTANTS_H_
#define CONSTANTS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Constants'.
*/

/*! Define indices of states in the StateConfVector */
#define SCVI_MAIN_REGION_A 0
#define SCVI_MAIN_REGION_B 0
#define SCVI_MAIN_REGION_C 0

class Constants : public StatemachineInterface
{
	
	public:
		
		Constants();
		
		~Constants();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			Constants_last_state,
			main_region_A,
			main_region_B,
			main_region_C
		} ConstantsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'e2' that is defined in the default interface scope. */
				void raise_e2(sc_integer value);
				
				/*! Gets the value of the variable 'x' that is defined in the default interface scope. */
				const sc_integer get_x() const;
				
				/*! Gets the value of the variable 'y' that is defined in the default interface scope. */
				const sc_integer get_y() const;
				
				/*! Gets the value of the variable 'result' that is defined in the default interface scope. */
				sc_integer get_result() const;
				
				/*! Sets the value of the variable 'result' that is defined in the default interface scope. */
				void set_result(sc_integer value);
				
				
			private:
				friend class Constants;
				sc_boolean e_raised;
				sc_boolean e2_raised;
				sc_integer e2_value;
				static const sc_integer x;
				static const sc_integer y;
				sc_integer result;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'e2' that is defined in the default interface scope. */
		void raise_e2(sc_integer value);
		
		/*! Gets the value of the variable 'x' that is defined in the default interface scope. */
		const sc_integer get_x() const;
		
		/*! Gets the value of the variable 'y' that is defined in the default interface scope. */
		const sc_integer get_y() const;
		
		/*! Gets the value of the variable 'result' that is defined in the default interface scope. */
		sc_integer get_result() const;
		
		/*! Sets the value of the variable 'result' that is defined in the default interface scope. */
		void set_result(sc_integer value);
		
		//! Inner class for Named interface scope.
		class SCI_Named
		{
			
			public:
				/*! Gets the value of the variable 'y' that is defined in the interface scope 'Named'. */
				const sc_string get_y() const;
				
				/*! Gets the value of the variable 'two' that is defined in the interface scope 'Named'. */
				const sc_integer get_two() const;
				
				
			private:
				friend class Constants;
				static const sc_string y;
				static const sc_integer two;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Named'. */
		SCI_Named* getSCI_Named();
		
		
		
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
		sc_boolean isStateActive(ConstantsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Gets the value of the variable 'internalConstant' that is defined in the internal scope. */
				const sc_integer get_internalConstant() const;
				
				
			private:
				friend class Constants;
				static const sc_integer internalConstant;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ConstantsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		SCI_Named ifaceNamed;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_B_tr0_tr0();
		sc_boolean check_main_region_C_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_B_tr0();
		void effect_main_region_C_tr0();
		void enact_main_region_B();
		void enact_main_region_C();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_C_default();
		void enseq_main_region_default();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region_C();
		void exseq_main_region();
		void react_main_region_A();
		void react_main_region_B();
		void react_main_region_C();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* CONSTANTS_H_ */
