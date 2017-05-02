
#ifndef PARENTHESIS_H_
#define PARENTHESIS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Parenthesis'.
*/

class Parenthesis : public StatemachineInterface
{
	
	public:
		
		Parenthesis();
		
		~Parenthesis();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			mainRegion_A,
			Parenthesis_last_state
		} ParenthesisStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'erg' that is defined in the default interface scope. */
				sc_integer get_erg() const;
				
				/*! Sets the value of the variable 'erg' that is defined in the default interface scope. */
				void set_erg(sc_integer value);
				
				
			private:
				friend class Parenthesis;
				sc_integer erg;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'erg' that is defined in the default interface scope. */
		sc_integer get_erg() const;
		
		/*! Sets the value of the variable 'erg' that is defined in the default interface scope. */
		void set_erg(sc_integer value);
		
		
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
		sc_boolean isStateActive(ParenthesisStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ParenthesisStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		void enact_mainRegion_A();
		void enseq_mainRegion_A_default();
		void enseq_mainRegion_default();
		void exseq_mainRegion_A();
		void exseq_mainRegion();
		void react_mainRegion_A();
		void react_mainRegion__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* PARENTHESIS_H_ */
