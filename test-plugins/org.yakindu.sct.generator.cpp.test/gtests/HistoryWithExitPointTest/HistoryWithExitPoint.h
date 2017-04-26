
#ifndef HISTORYWITHEXITPOINT_H_
#define HISTORYWITHEXITPOINT_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'HistoryWithExitPoint'.
*/

class HistoryWithExitPoint : public StatemachineInterface
{
	
	public:
		
		HistoryWithExitPoint();
		
		~HistoryWithExitPoint();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			mr_A,
			mr_A_r_X1,
			mr_A_r_X2,
			mr_B,
			HistoryWithExitPoint_last_state
		} HistoryWithExitPointStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'push' that is defined in the default interface scope. */
				void raise_push();
				
				/*! Raises the in event 'back' that is defined in the default interface scope. */
				void raise_back();
				
				/*! Raises the in event 'next' that is defined in the default interface scope. */
				void raise_next();
				
				
			private:
				friend class HistoryWithExitPoint;
				sc_boolean push_raised;
				sc_boolean back_raised;
				sc_boolean next_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'push' that is defined in the default interface scope. */
		void raise_push();
		
		/*! Raises the in event 'back' that is defined in the default interface scope. */
		void raise_back();
		
		/*! Raises the in event 'next' that is defined in the default interface scope. */
		void raise_next();
		
		
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
		sc_boolean isStateActive(HistoryWithExitPointStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 1;
		
		
		HistoryWithExitPointStates stateConfVector[maxOrthogonalStates];
		
		HistoryWithExitPointStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_mr_A_r_X1_tr0_tr0();
		sc_boolean check_mr_A_r_X1_tr1_tr1();
		sc_boolean check_mr_A_r_X2_tr0_tr0();
		sc_boolean check_mr_A_r_X2_tr1_tr1();
		sc_boolean check_mr_B_tr0_tr0();
		void effect_mr_A_tr0();
		void effect_mr_A_r_X1_tr0();
		void effect_mr_A_r_X1_tr1();
		void effect_mr_A_r_X2_tr0();
		void effect_mr_A_r_X2_tr1();
		void effect_mr_B_tr0();
		void enseq_mr_A_default();
		void enseq_mr_A_r_X1_default();
		void enseq_mr_A_r_X2_default();
		void enseq_mr_B_default();
		void enseq_mr_default();
		void enseq_mr_A_r_default();
		void shenseq_mr_A_r();
		void exseq_mr_A();
		void exseq_mr_A_r_X1();
		void exseq_mr_A_r_X2();
		void exseq_mr_B();
		void exseq_mr();
		void exseq_mr_A_r();
		void react_mr_A_r_X1();
		void react_mr_A_r_X2();
		void react_mr_B();
		void react_mr__entry_Default();
		void react_mr_A_r__entry_Default();
		void react_mr_A_r_exit_to_B();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* HISTORYWITHEXITPOINT_H_ */
