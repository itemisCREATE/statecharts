
#ifndef ENTRYREACTIONACTION_H_
#define ENTRYREACTIONACTION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'EntryReactionAction'.
*/

class EntryReactionAction : public StatemachineInterface
{
	
	public:
		
		EntryReactionAction();
		
		~EntryReactionAction();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			EntryReactionAction_r2_B,
			EntryReactionAction_r2_B_r_BA,
			EntryReactionAction_r2_B_r_BB,
			EntryReactionAction_r2_D,
			EntryReactionAction_r1_A,
			EntryReactionAction_last_state
		} EntryReactionActionStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'enteredR1' that is defined in the default interface scope. */
				sc_boolean get_enteredR1() const;
				
				/*! Sets the value of the variable 'enteredR1' that is defined in the default interface scope. */
				void set_enteredR1(sc_boolean value);
				
				/*! Gets the value of the variable 'enteredR2' that is defined in the default interface scope. */
				sc_boolean get_enteredR2() const;
				
				/*! Sets the value of the variable 'enteredR2' that is defined in the default interface scope. */
				void set_enteredR2(sc_boolean value);
				
				/*! Gets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */
				sc_boolean get_enteredBdefault() const;
				
				/*! Sets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */
				void set_enteredBdefault(sc_boolean value);
				
				/*! Gets the value of the variable 'enteredBother' that is defined in the default interface scope. */
				sc_boolean get_enteredBother() const;
				
				/*! Sets the value of the variable 'enteredBother' that is defined in the default interface scope. */
				void set_enteredBother(sc_boolean value);
				
				/*! Raises the in event 'b' that is defined in the default interface scope. */
				void raise_b();
				
				/*! Raises the in event 'd' that is defined in the default interface scope. */
				void raise_d();
				
				
			private:
				friend class EntryReactionAction;
				sc_boolean enteredR1;
				sc_boolean enteredR2;
				sc_boolean enteredBdefault;
				sc_boolean enteredBother;
				sc_boolean b_raised;
				sc_boolean d_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'enteredR1' that is defined in the default interface scope. */
		sc_boolean get_enteredR1() const;
		
		/*! Sets the value of the variable 'enteredR1' that is defined in the default interface scope. */
		void set_enteredR1(sc_boolean value);
		
		/*! Gets the value of the variable 'enteredR2' that is defined in the default interface scope. */
		sc_boolean get_enteredR2() const;
		
		/*! Sets the value of the variable 'enteredR2' that is defined in the default interface scope. */
		void set_enteredR2(sc_boolean value);
		
		/*! Gets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */
		sc_boolean get_enteredBdefault() const;
		
		/*! Sets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */
		void set_enteredBdefault(sc_boolean value);
		
		/*! Gets the value of the variable 'enteredBother' that is defined in the default interface scope. */
		sc_boolean get_enteredBother() const;
		
		/*! Sets the value of the variable 'enteredBother' that is defined in the default interface scope. */
		void set_enteredBother(sc_boolean value);
		
		/*! Raises the in event 'b' that is defined in the default interface scope. */
		void raise_b();
		
		/*! Raises the in event 'd' that is defined in the default interface scope. */
		void raise_d();
		
		
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
		sc_boolean isStateActive(EntryReactionActionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 2;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 1;
		
		
		EntryReactionActionStates stateConfVector[maxOrthogonalStates];
		
		EntryReactionActionStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_EntryReactionAction_r2_B_tr0_tr0();
		sc_boolean check_EntryReactionAction_r2_B_r_BA_tr0_tr0();
		sc_boolean check_EntryReactionAction_r2_B_r_BB_tr0_tr0();
		sc_boolean check_EntryReactionAction_r2_D_tr0_tr0();
		sc_boolean check_EntryReactionAction_r2_D_tr1_tr1();
		void effect_EntryReactionAction_r2_B_tr0();
		void effect_EntryReactionAction_r2_B_r_BA_tr0();
		void effect_EntryReactionAction_r2_B_r_BB_tr0();
		void effect_EntryReactionAction_r2_D_tr0();
		void effect_EntryReactionAction_r2_D_tr1();
		void enseq_EntryReactionAction_r2_B_default();
		void enseq_EntryReactionAction_r2_B_other();
		void enseq_EntryReactionAction_r2_B_r_BA_default();
		void enseq_EntryReactionAction_r2_B_r_BB_default();
		void enseq_EntryReactionAction_r2_D_default();
		void enseq_EntryReactionAction_r1_A_default();
		void enseq_EntryReactionAction_r2_default();
		void enseq_EntryReactionAction_r2_B_r_default();
		void enseq_EntryReactionAction_r2_B_r_other();
		void shenseq_EntryReactionAction_r2_B_r();
		void enseq_EntryReactionAction_r1_default();
		void exseq_EntryReactionAction_r2_B();
		void exseq_EntryReactionAction_r2_B_r_BA();
		void exseq_EntryReactionAction_r2_B_r_BB();
		void exseq_EntryReactionAction_r2_D();
		void exseq_EntryReactionAction_r1_A();
		void exseq_EntryReactionAction_r2();
		void exseq_EntryReactionAction_r2_B_r();
		void exseq_EntryReactionAction_r1();
		void react_EntryReactionAction_r2_B_r_BA();
		void react_EntryReactionAction_r2_B_r_BB();
		void react_EntryReactionAction_r2_D();
		void react_EntryReactionAction_r1_A();
		void react_EntryReactionAction_r2_default();
		void react_EntryReactionAction_r2_B_r_default();
		void react_EntryReactionAction_r2_B_r_other();
		void react_EntryReactionAction_r1__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* ENTRYREACTIONACTION_H_ */
