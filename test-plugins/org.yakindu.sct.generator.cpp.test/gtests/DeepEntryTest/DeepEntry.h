
#ifndef DEEPENTRY_H_
#define DEEPENTRY_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'DeepEntry'.
*/

class DeepEntry : public StatemachineInterface
{
	
	public:
		
		DeepEntry();
		
		~DeepEntry();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			r_A,
			r_A_r_B,
			r2_B,
			r2_B_r_BA,
			r2_B_r_BA_r_BAA,
			r2_B_r_BB,
			r2_C,
			r3_D,
			r3_D_r_DA,
			r3_D_r_DA_r_DAA,
			DeepEntry_last_state
		} DeepEntryStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'x' that is defined in the default interface scope. */
				sc_integer get_x() const;
				
				/*! Sets the value of the variable 'x' that is defined in the default interface scope. */
				void set_x(sc_integer value);
				
				/*! Gets the value of the variable 'y' that is defined in the default interface scope. */
				sc_integer get_y() const;
				
				/*! Sets the value of the variable 'y' that is defined in the default interface scope. */
				void set_y(sc_integer value);
				
				/*! Gets the value of the variable 'z' that is defined in the default interface scope. */
				sc_integer get_z() const;
				
				/*! Sets the value of the variable 'z' that is defined in the default interface scope. */
				void set_z(sc_integer value);
				
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'f' that is defined in the default interface scope. */
				void raise_f();
				
				
			private:
				friend class DeepEntry;
				sc_integer x;
				sc_integer y;
				sc_integer z;
				sc_boolean e_raised;
				sc_boolean f_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'x' that is defined in the default interface scope. */
		sc_integer get_x() const;
		
		/*! Sets the value of the variable 'x' that is defined in the default interface scope. */
		void set_x(sc_integer value);
		
		/*! Gets the value of the variable 'y' that is defined in the default interface scope. */
		sc_integer get_y() const;
		
		/*! Sets the value of the variable 'y' that is defined in the default interface scope. */
		void set_y(sc_integer value);
		
		/*! Gets the value of the variable 'z' that is defined in the default interface scope. */
		sc_integer get_z() const;
		
		/*! Sets the value of the variable 'z' that is defined in the default interface scope. */
		void set_z(sc_integer value);
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'f' that is defined in the default interface scope. */
		void raise_f();
		
		
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
		sc_boolean isStateActive(DeepEntryStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 3;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 4;
		
		
		DeepEntryStates stateConfVector[maxOrthogonalStates];
		
		DeepEntryStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_r2_B_tr0_tr0();
		sc_boolean check_r2_B_r_BA_tr0_tr0();
		sc_boolean check_r2_C_tr0_tr0();
		void effect_r2_B_tr0();
		void effect_r2_B_r_BA_tr0();
		void effect_r2_C_tr0();
		void enact_r_A();
		void enact_r2_B_r_BA();
		void enact_r3_D();
		void enact_r3_D_r_DA();
		void enseq_r_A_r_B_default();
		void enseq_r2_B_default();
		void enseq_r2_B_r_BA_default();
		void enseq_r2_B_r_BA_r_BAA_default();
		void enseq_r2_B_r_BB_default();
		void enseq_r2_C_default();
		void enseq_r3_D_r_DA_r_DAA_default();
		void enseq_r_default();
		void enseq_r2_default();
		void enseq_r2_B_r_default();
		void shenseq_r2_B_r();
		void enseq_r2_B_r_BA_r_default();
		void enseq_r3_default();
		void dhenseq_r3();
		void dhenseq_r3_D_r();
		void dhenseq_r3_D_r_DA_r();
		void exseq_r_A_r_B();
		void exseq_r2_B();
		void exseq_r2_B_r_BA();
		void exseq_r2_B_r_BA_r_BAA();
		void exseq_r2_B_r_BB();
		void exseq_r2_C();
		void exseq_r3_D_r_DA_r_DAA();
		void exseq_r();
		void exseq_r_A_r();
		void exseq_r2();
		void exseq_r2_B_r();
		void exseq_r2_B_r_BA_r();
		void exseq_r3();
		void exseq_r3_D_r();
		void exseq_r3_D_r_DA_r();
		void react_r_A_r_B();
		void react_r2_B_r_BA_r_BAA();
		void react_r2_B_r_BB();
		void react_r2_C();
		void react_r3_D_r_DA_r_DAA();
		void react_r__entry_Default();
		void react_r2_B_r__entry_Default();
		void react_r2_B_r_BA_r__entry_Default();
		void react_r2__entry_Default();
		void react_r3__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* DEEPENTRY_H_ */
