
#ifndef TYPEALIAS_H_
#define TYPEALIAS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'TypeAlias'.
*/

class TypeAlias : public StatemachineInterface
{
	
	public:
		
		TypeAlias();
		
		~TypeAlias();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_Start,
			main_region_Mid,
			main_region_Mid2,
			main_region_End,
			TypeAlias_last_state
		} TypeAliasStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'myVar' that is defined in the default interface scope. */
				sc_integer get_myVar() const;
				
				/*! Sets the value of the variable 'myVar' that is defined in the default interface scope. */
				void set_myVar(sc_integer value);
				
				/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
				sc_string get_myString() const;
				
				/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */
				void set_myString(sc_string value);
				
				/*! Raises the in event 'myEvent' that is defined in the default interface scope. */
				void raise_myEvent();
				
				
			private:
				friend class TypeAlias;
				sc_integer myVar;
				sc_string myString;
				sc_boolean myEvent_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'myVar' that is defined in the default interface scope. */
		sc_integer get_myVar() const;
		
		/*! Sets the value of the variable 'myVar' that is defined in the default interface scope. */
		void set_myVar(sc_integer value);
		
		/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */
		sc_string get_myString() const;
		
		/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */
		void set_myString(sc_string value);
		
		/*! Raises the in event 'myEvent' that is defined in the default interface scope. */
		void raise_myEvent();
		
		
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
		sc_boolean isStateActive(TypeAliasStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		TypeAliasStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Start_tr0_tr0();
		sc_boolean check_main_region_Mid_tr0_tr0();
		sc_boolean check_main_region_Mid2_tr0_tr0();
		void effect_main_region_Start_tr0();
		void effect_main_region_Mid_tr0();
		void effect_main_region_Mid2_tr0();
		void enact_main_region_Start();
		void enact_main_region_Mid();
		void enseq_main_region_Start_default();
		void enseq_main_region_Mid_default();
		void enseq_main_region_Mid2_default();
		void enseq_main_region_End_default();
		void enseq_main_region_default();
		void exseq_main_region_Start();
		void exseq_main_region_Mid();
		void exseq_main_region_Mid2();
		void exseq_main_region_End();
		void exseq_main_region();
		void react_main_region_Start();
		void react_main_region_Mid();
		void react_main_region_Mid2();
		void react_main_region_End();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* TYPEALIAS_H_ */
