
#ifndef ASSIGNMENTASEXPRESSION_H_
#define ASSIGNMENTASEXPRESSION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'AssignmentAsExpression'.
*/

class AssignmentAsExpression : public StatemachineInterface
{
	
	public:
		
		AssignmentAsExpression();
		
		~AssignmentAsExpression();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_Add,
			main_region_Multiply,
			main_region_Divide,
			main_region_Modulo,
			main_region_Shift,
			main_region_boolean_And,
			main_region_boolean_Or,
			main_region_boolean_Xor,
			main_region_Subtract,
			AssignmentAsExpression_last_state
		} AssignmentAsExpressionStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'a' that is defined in the default interface scope. */
				sc_integer get_a() const;
				
				/*! Sets the value of the variable 'a' that is defined in the default interface scope. */
				void set_a(sc_integer value);
				
				/*! Gets the value of the variable 'b' that is defined in the default interface scope. */
				sc_integer get_b() const;
				
				/*! Sets the value of the variable 'b' that is defined in the default interface scope. */
				void set_b(sc_integer value);
				
				/*! Gets the value of the variable 'c' that is defined in the default interface scope. */
				sc_integer get_c() const;
				
				/*! Sets the value of the variable 'c' that is defined in the default interface scope. */
				void set_c(sc_integer value);
				
				/*! Gets the value of the variable 'd' that is defined in the default interface scope. */
				sc_integer get_d() const;
				
				/*! Sets the value of the variable 'd' that is defined in the default interface scope. */
				void set_d(sc_integer value);
				
				/*! Gets the value of the variable 'e' that is defined in the default interface scope. */
				sc_integer get_e() const;
				
				/*! Sets the value of the variable 'e' that is defined in the default interface scope. */
				void set_e(sc_integer value);
				
				/*! Gets the value of the variable 'f' that is defined in the default interface scope. */
				sc_integer get_f() const;
				
				/*! Sets the value of the variable 'f' that is defined in the default interface scope. */
				void set_f(sc_integer value);
				
				/*! Gets the value of the variable 'g' that is defined in the default interface scope. */
				sc_integer get_g() const;
				
				/*! Sets the value of the variable 'g' that is defined in the default interface scope. */
				void set_g(sc_integer value);
				
				/*! Gets the value of the variable 'h' that is defined in the default interface scope. */
				sc_integer get_h() const;
				
				/*! Sets the value of the variable 'h' that is defined in the default interface scope. */
				void set_h(sc_integer value);
				
				/*! Gets the value of the variable 'i' that is defined in the default interface scope. */
				sc_integer get_i() const;
				
				/*! Sets the value of the variable 'i' that is defined in the default interface scope. */
				void set_i(sc_integer value);
				
				/*! Gets the value of the variable 'i1' that is defined in the default interface scope. */
				sc_integer get_i1() const;
				
				/*! Sets the value of the variable 'i1' that is defined in the default interface scope. */
				void set_i1(sc_integer value);
				
				/*! Gets the value of the variable 'j' that is defined in the default interface scope. */
				sc_integer get_j() const;
				
				/*! Sets the value of the variable 'j' that is defined in the default interface scope. */
				void set_j(sc_integer value);
				
				/*! Gets the value of the variable 'j1' that is defined in the default interface scope. */
				sc_integer get_j1() const;
				
				/*! Sets the value of the variable 'j1' that is defined in the default interface scope. */
				void set_j1(sc_integer value);
				
				/*! Gets the value of the variable 'k' that is defined in the default interface scope. */
				sc_integer get_k() const;
				
				/*! Sets the value of the variable 'k' that is defined in the default interface scope. */
				void set_k(sc_integer value);
				
				/*! Gets the value of the variable 'k1' that is defined in the default interface scope. */
				sc_integer get_k1() const;
				
				/*! Sets the value of the variable 'k1' that is defined in the default interface scope. */
				void set_k1(sc_integer value);
				
				/*! Gets the value of the variable 'l' that is defined in the default interface scope. */
				sc_integer get_l() const;
				
				/*! Sets the value of the variable 'l' that is defined in the default interface scope. */
				void set_l(sc_integer value);
				
				/*! Gets the value of the variable 'm' that is defined in the default interface scope. */
				sc_integer get_m() const;
				
				/*! Sets the value of the variable 'm' that is defined in the default interface scope. */
				void set_m(sc_integer value);
				
				/*! Gets the value of the variable 'n' that is defined in the default interface scope. */
				sc_integer get_n() const;
				
				/*! Sets the value of the variable 'n' that is defined in the default interface scope. */
				void set_n(sc_integer value);
				
				/*! Gets the value of the variable 'p' that is defined in the default interface scope. */
				sc_integer get_p() const;
				
				/*! Sets the value of the variable 'p' that is defined in the default interface scope. */
				void set_p(sc_integer value);
				
				/*! Gets the value of the variable 'r' that is defined in the default interface scope. */
				sc_integer get_r() const;
				
				/*! Sets the value of the variable 'r' that is defined in the default interface scope. */
				void set_r(sc_integer value);
				
				/*! Gets the value of the variable 't' that is defined in the default interface scope. */
				sc_integer get_t() const;
				
				/*! Sets the value of the variable 't' that is defined in the default interface scope. */
				void set_t(sc_integer value);
				
				/*! Gets the value of the variable 'u' that is defined in the default interface scope. */
				sc_integer get_u() const;
				
				/*! Sets the value of the variable 'u' that is defined in the default interface scope. */
				void set_u(sc_integer value);
				
				/*! Gets the value of the variable 'v' that is defined in the default interface scope. */
				sc_integer get_v() const;
				
				/*! Sets the value of the variable 'v' that is defined in the default interface scope. */
				void set_v(sc_integer value);
				
				/*! Gets the value of the variable 'w' that is defined in the default interface scope. */
				sc_integer get_w() const;
				
				/*! Sets the value of the variable 'w' that is defined in the default interface scope. */
				void set_w(sc_integer value);
				
				
			private:
				friend class AssignmentAsExpression;
				sc_integer a;
				sc_integer b;
				sc_integer c;
				sc_integer d;
				sc_integer e;
				sc_integer f;
				sc_integer g;
				sc_integer h;
				sc_integer i;
				sc_integer i1;
				sc_integer j;
				sc_integer j1;
				sc_integer k;
				sc_integer k1;
				sc_integer l;
				sc_integer m;
				sc_integer n;
				sc_integer p;
				sc_integer r;
				sc_integer t;
				sc_integer u;
				sc_integer v;
				sc_integer w;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'a' that is defined in the default interface scope. */
		sc_integer get_a() const;
		
		/*! Sets the value of the variable 'a' that is defined in the default interface scope. */
		void set_a(sc_integer value);
		
		/*! Gets the value of the variable 'b' that is defined in the default interface scope. */
		sc_integer get_b() const;
		
		/*! Sets the value of the variable 'b' that is defined in the default interface scope. */
		void set_b(sc_integer value);
		
		/*! Gets the value of the variable 'c' that is defined in the default interface scope. */
		sc_integer get_c() const;
		
		/*! Sets the value of the variable 'c' that is defined in the default interface scope. */
		void set_c(sc_integer value);
		
		/*! Gets the value of the variable 'd' that is defined in the default interface scope. */
		sc_integer get_d() const;
		
		/*! Sets the value of the variable 'd' that is defined in the default interface scope. */
		void set_d(sc_integer value);
		
		/*! Gets the value of the variable 'e' that is defined in the default interface scope. */
		sc_integer get_e() const;
		
		/*! Sets the value of the variable 'e' that is defined in the default interface scope. */
		void set_e(sc_integer value);
		
		/*! Gets the value of the variable 'f' that is defined in the default interface scope. */
		sc_integer get_f() const;
		
		/*! Sets the value of the variable 'f' that is defined in the default interface scope. */
		void set_f(sc_integer value);
		
		/*! Gets the value of the variable 'g' that is defined in the default interface scope. */
		sc_integer get_g() const;
		
		/*! Sets the value of the variable 'g' that is defined in the default interface scope. */
		void set_g(sc_integer value);
		
		/*! Gets the value of the variable 'h' that is defined in the default interface scope. */
		sc_integer get_h() const;
		
		/*! Sets the value of the variable 'h' that is defined in the default interface scope. */
		void set_h(sc_integer value);
		
		/*! Gets the value of the variable 'i' that is defined in the default interface scope. */
		sc_integer get_i() const;
		
		/*! Sets the value of the variable 'i' that is defined in the default interface scope. */
		void set_i(sc_integer value);
		
		/*! Gets the value of the variable 'i1' that is defined in the default interface scope. */
		sc_integer get_i1() const;
		
		/*! Sets the value of the variable 'i1' that is defined in the default interface scope. */
		void set_i1(sc_integer value);
		
		/*! Gets the value of the variable 'j' that is defined in the default interface scope. */
		sc_integer get_j() const;
		
		/*! Sets the value of the variable 'j' that is defined in the default interface scope. */
		void set_j(sc_integer value);
		
		/*! Gets the value of the variable 'j1' that is defined in the default interface scope. */
		sc_integer get_j1() const;
		
		/*! Sets the value of the variable 'j1' that is defined in the default interface scope. */
		void set_j1(sc_integer value);
		
		/*! Gets the value of the variable 'k' that is defined in the default interface scope. */
		sc_integer get_k() const;
		
		/*! Sets the value of the variable 'k' that is defined in the default interface scope. */
		void set_k(sc_integer value);
		
		/*! Gets the value of the variable 'k1' that is defined in the default interface scope. */
		sc_integer get_k1() const;
		
		/*! Sets the value of the variable 'k1' that is defined in the default interface scope. */
		void set_k1(sc_integer value);
		
		/*! Gets the value of the variable 'l' that is defined in the default interface scope. */
		sc_integer get_l() const;
		
		/*! Sets the value of the variable 'l' that is defined in the default interface scope. */
		void set_l(sc_integer value);
		
		/*! Gets the value of the variable 'm' that is defined in the default interface scope. */
		sc_integer get_m() const;
		
		/*! Sets the value of the variable 'm' that is defined in the default interface scope. */
		void set_m(sc_integer value);
		
		/*! Gets the value of the variable 'n' that is defined in the default interface scope. */
		sc_integer get_n() const;
		
		/*! Sets the value of the variable 'n' that is defined in the default interface scope. */
		void set_n(sc_integer value);
		
		/*! Gets the value of the variable 'p' that is defined in the default interface scope. */
		sc_integer get_p() const;
		
		/*! Sets the value of the variable 'p' that is defined in the default interface scope. */
		void set_p(sc_integer value);
		
		/*! Gets the value of the variable 'r' that is defined in the default interface scope. */
		sc_integer get_r() const;
		
		/*! Sets the value of the variable 'r' that is defined in the default interface scope. */
		void set_r(sc_integer value);
		
		/*! Gets the value of the variable 't' that is defined in the default interface scope. */
		sc_integer get_t() const;
		
		/*! Sets the value of the variable 't' that is defined in the default interface scope. */
		void set_t(sc_integer value);
		
		/*! Gets the value of the variable 'u' that is defined in the default interface scope. */
		sc_integer get_u() const;
		
		/*! Sets the value of the variable 'u' that is defined in the default interface scope. */
		void set_u(sc_integer value);
		
		/*! Gets the value of the variable 'v' that is defined in the default interface scope. */
		sc_integer get_v() const;
		
		/*! Sets the value of the variable 'v' that is defined in the default interface scope. */
		void set_v(sc_integer value);
		
		/*! Gets the value of the variable 'w' that is defined in the default interface scope. */
		sc_integer get_w() const;
		
		/*! Sets the value of the variable 'w' that is defined in the default interface scope. */
		void set_w(sc_integer value);
		
		
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
		sc_boolean isStateActive(AssignmentAsExpressionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		AssignmentAsExpressionStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Add_tr0_tr0();
		sc_boolean check_main_region_Multiply_tr0_tr0();
		sc_boolean check_main_region_Divide_tr0_tr0();
		sc_boolean check_main_region_Modulo_tr0_tr0();
		sc_boolean check_main_region_Shift_tr0_tr0();
		sc_boolean check_main_region_boolean_And_tr0_tr0();
		sc_boolean check_main_region_boolean_Or_tr0_tr0();
		sc_boolean check_main_region_Subtract_tr0_tr0();
		void effect_main_region_Add_tr0();
		void effect_main_region_Multiply_tr0();
		void effect_main_region_Divide_tr0();
		void effect_main_region_Modulo_tr0();
		void effect_main_region_Shift_tr0();
		void effect_main_region_boolean_And_tr0();
		void effect_main_region_boolean_Or_tr0();
		void effect_main_region_Subtract_tr0();
		void enact_main_region_Add();
		void enact_main_region_Multiply();
		void enact_main_region_Divide();
		void enact_main_region_Modulo();
		void enact_main_region_Shift();
		void enact_main_region_boolean_And();
		void enact_main_region_boolean_Or();
		void enact_main_region_boolean_Xor();
		void enact_main_region_Subtract();
		void enseq_main_region_Add_default();
		void enseq_main_region_Multiply_default();
		void enseq_main_region_Divide_default();
		void enseq_main_region_Modulo_default();
		void enseq_main_region_Shift_default();
		void enseq_main_region_boolean_And_default();
		void enseq_main_region_boolean_Or_default();
		void enseq_main_region_boolean_Xor_default();
		void enseq_main_region_Subtract_default();
		void enseq_main_region_default();
		void exseq_main_region_Add();
		void exseq_main_region_Multiply();
		void exseq_main_region_Divide();
		void exseq_main_region_Modulo();
		void exseq_main_region_Shift();
		void exseq_main_region_boolean_And();
		void exseq_main_region_boolean_Or();
		void exseq_main_region_boolean_Xor();
		void exseq_main_region_Subtract();
		void exseq_main_region();
		void react_main_region_Add();
		void react_main_region_Multiply();
		void react_main_region_Divide();
		void react_main_region_Modulo();
		void react_main_region_Shift();
		void react_main_region_boolean_And();
		void react_main_region_boolean_Or();
		void react_main_region_boolean_Xor();
		void react_main_region_Subtract();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* ASSIGNMENTASEXPRESSION_H_ */
