
#ifndef ASSIGNMENTASEXPRESSION_H_
#define ASSIGNMENTASEXPRESSION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'AssignmentAsExpression'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	AssignmentAsExpression_last_state,
	AssignmentAsExpression_main_region_Add,
	AssignmentAsExpression_main_region_Multiply,
	AssignmentAsExpression_main_region_Divide,
	AssignmentAsExpression_main_region_Modulo,
	AssignmentAsExpression_main_region_Shift,
	AssignmentAsExpression_main_region_boolean_And,
	AssignmentAsExpression_main_region_boolean_Or,
	AssignmentAsExpression_main_region_boolean_Xor,
	AssignmentAsExpression_main_region_Subtract
} AssignmentAsExpressionStates;

/*! Type definition of the data structure for the AssignmentAsExpressionIface interface scope. */
typedef struct
{
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
} AssignmentAsExpressionIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ASSIGNMENTASEXPRESSION_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_ADD 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_MULTIPLY 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_DIVIDE 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_MODULO 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_SHIFT 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_AND 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_OR 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_XOR 0
#define SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_SUBTRACT 0

/*! 
 * Type definition of the data structure for the AssignmentAsExpression state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	AssignmentAsExpressionStates stateConfVector[ASSIGNMENTASEXPRESSION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	AssignmentAsExpressionIface iface;
} AssignmentAsExpression;

/*! Initializes the AssignmentAsExpression state machine data structures. Must be called before first usage.*/
extern void assignmentAsExpression_init(AssignmentAsExpression* handle);

/*! Activates the state machine */
extern void assignmentAsExpression_enter(AssignmentAsExpression* handle);

/*! Deactivates the state machine */
extern void assignmentAsExpression_exit(AssignmentAsExpression* handle);

/*! Performs a 'run to completion' step. */
extern void assignmentAsExpression_runCycle(AssignmentAsExpression* handle);


/*! Gets the value of the variable 'a' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_a(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'a' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_a(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'b' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_b(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'b' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_b(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'c' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_c(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'c' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_c(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'd' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_d(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'd' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_d(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'e' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_e(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'e' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_e(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'f' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_f(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'f' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_f(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'g' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_g(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'g' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_g(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'h' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_h(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'h' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_h(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'i' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_i(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'i' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_i(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'i1' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_i1(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'i1' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_i1(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'j' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_j(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'j' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_j(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'j1' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_j1(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'j1' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_j1(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'k' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_k(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'k' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_k(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'k1' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_k1(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'k1' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_k1(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'l' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_l(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'l' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_l(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'm' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_m(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'm' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_m(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'n' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_n(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'n' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_n(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'p' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_p(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'p' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_p(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'r' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_r(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'r' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_r(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 't' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_t(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 't' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_t(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'u' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_u(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'u' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_u(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'v' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_v(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'v' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_v(AssignmentAsExpression* handle, sc_integer value);
/*! Gets the value of the variable 'w' that is defined in the default interface scope. */ 
extern sc_integer assignmentAsExpressionIface_get_w(const AssignmentAsExpression* handle);
/*! Sets the value of the variable 'w' that is defined in the default interface scope. */ 
extern void assignmentAsExpressionIface_set_w(AssignmentAsExpression* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean assignmentAsExpression_isActive(const AssignmentAsExpression* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean assignmentAsExpression_isFinal(const AssignmentAsExpression* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean assignmentAsExpression_isStateActive(const AssignmentAsExpression* handle, AssignmentAsExpressionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ASSIGNMENTASEXPRESSION_H_ */
