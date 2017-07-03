
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "AssignmentAsExpression.h"
/*! \file Implementation of the state machine 'AssignmentAsExpression'
*/

/* prototypes of all internal functions */
static sc_boolean assignmentAsExpression_check_main_region_Add_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_Multiply_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_Divide_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_Modulo_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_Shift_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_boolean_And_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_boolean_Or_tr0_tr0(const AssignmentAsExpression* handle);
static sc_boolean assignmentAsExpression_check_main_region_Subtract_tr0_tr0(const AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Add_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Multiply_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Divide_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Modulo_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Shift_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_boolean_And_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_boolean_Or_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_effect_main_region_Subtract_tr0(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Add(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Multiply(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Divide(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Modulo(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Shift(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_boolean_And(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_boolean_Or(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_boolean_Xor(AssignmentAsExpression* handle);
static void assignmentAsExpression_enact_main_region_Subtract(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Add_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Multiply_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Divide_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Modulo_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Shift_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_boolean_And_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_boolean_Or_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_boolean_Xor_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_Subtract_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_enseq_main_region_default(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Add(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Multiply(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Divide(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Modulo(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Shift(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_boolean_And(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_boolean_Or(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_boolean_Xor(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region_Subtract(AssignmentAsExpression* handle);
static void assignmentAsExpression_exseq_main_region(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Add(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Multiply(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Divide(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Modulo(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Shift(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_boolean_And(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_boolean_Or(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_boolean_Xor(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region_Subtract(AssignmentAsExpression* handle);
static void assignmentAsExpression_react_main_region__entry_Default(AssignmentAsExpression* handle);
static void assignmentAsExpression_clearInEvents(AssignmentAsExpression* handle);
static void assignmentAsExpression_clearOutEvents(AssignmentAsExpression* handle);


void assignmentAsExpression_init(AssignmentAsExpression* handle)
{
	sc_integer i;

	for (i = 0; i < ASSIGNMENTASEXPRESSION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = AssignmentAsExpression_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	assignmentAsExpression_clearInEvents(handle);
	assignmentAsExpression_clearOutEvents(handle);

	/* Default init sequence for statechart AssignmentAsExpression */
	handle->iface.a = 0;
	handle->iface.b = 0;
	handle->iface.c = 0;
	handle->iface.d = 0;
	handle->iface.e = 1;
	handle->iface.f = 1;
	handle->iface.g = 4;
	handle->iface.h = 32;
	handle->iface.i = 7;
	handle->iface.i1 = 7;
	handle->iface.j = 8;
	handle->iface.j1 = 2;
	handle->iface.k = 8;
	handle->iface.k1 = 4;
	handle->iface.l = 3;
	handle->iface.m = 7;
	handle->iface.n = 5;
	handle->iface.p = 0;
	handle->iface.r = 7;
	handle->iface.t = 10;
	handle->iface.u = 6;
	handle->iface.v = 13;
	handle->iface.w = 7;

}

void assignmentAsExpression_enter(AssignmentAsExpression* handle)
{
	/* Default enter sequence for statechart AssignmentAsExpression */
	assignmentAsExpression_enseq_main_region_default(handle);
}

void assignmentAsExpression_exit(AssignmentAsExpression* handle)
{
	/* Default exit sequence for statechart AssignmentAsExpression */
	assignmentAsExpression_exseq_main_region(handle);
}

sc_boolean assignmentAsExpression_isActive(const AssignmentAsExpression* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < ASSIGNMENTASEXPRESSION_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != AssignmentAsExpression_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean assignmentAsExpression_isFinal(const AssignmentAsExpression* handle)
{
   return bool_false;
}

static void assignmentAsExpression_clearInEvents(AssignmentAsExpression* handle)
{
}

static void assignmentAsExpression_clearOutEvents(AssignmentAsExpression* handle)
{
}

void assignmentAsExpression_runCycle(AssignmentAsExpression* handle)
{
	
	assignmentAsExpression_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ASSIGNMENTASEXPRESSION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case AssignmentAsExpression_main_region_Add :
		{
			assignmentAsExpression_react_main_region_Add(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Multiply :
		{
			assignmentAsExpression_react_main_region_Multiply(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Divide :
		{
			assignmentAsExpression_react_main_region_Divide(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Modulo :
		{
			assignmentAsExpression_react_main_region_Modulo(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Shift :
		{
			assignmentAsExpression_react_main_region_Shift(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_And :
		{
			assignmentAsExpression_react_main_region_boolean_And(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_Or :
		{
			assignmentAsExpression_react_main_region_boolean_Or(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_Xor :
		{
			assignmentAsExpression_react_main_region_boolean_Xor(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Subtract :
		{
			assignmentAsExpression_react_main_region_Subtract(handle);
			break;
		}
		default:
			break;
		}
	}
	
	assignmentAsExpression_clearInEvents(handle);
}


sc_boolean assignmentAsExpression_isStateActive(const AssignmentAsExpression* handle, AssignmentAsExpressionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case AssignmentAsExpression_main_region_Add :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_ADD] == AssignmentAsExpression_main_region_Add
			);
			break;
		case AssignmentAsExpression_main_region_Multiply :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_MULTIPLY] == AssignmentAsExpression_main_region_Multiply
			);
			break;
		case AssignmentAsExpression_main_region_Divide :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_DIVIDE] == AssignmentAsExpression_main_region_Divide
			);
			break;
		case AssignmentAsExpression_main_region_Modulo :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_MODULO] == AssignmentAsExpression_main_region_Modulo
			);
			break;
		case AssignmentAsExpression_main_region_Shift :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_SHIFT] == AssignmentAsExpression_main_region_Shift
			);
			break;
		case AssignmentAsExpression_main_region_boolean_And :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_AND] == AssignmentAsExpression_main_region_boolean_And
			);
			break;
		case AssignmentAsExpression_main_region_boolean_Or :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_OR] == AssignmentAsExpression_main_region_boolean_Or
			);
			break;
		case AssignmentAsExpression_main_region_boolean_Xor :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_BOOLEAN_XOR] == AssignmentAsExpression_main_region_boolean_Xor
			);
			break;
		case AssignmentAsExpression_main_region_Subtract :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ASSIGNMENTASEXPRESSION_MAIN_REGION_SUBTRACT] == AssignmentAsExpression_main_region_Subtract
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer assignmentAsExpressionIface_get_a(const AssignmentAsExpression* handle)
{
	return handle->iface.a;
}
void assignmentAsExpressionIface_set_a(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.a = value;
}
sc_integer assignmentAsExpressionIface_get_b(const AssignmentAsExpression* handle)
{
	return handle->iface.b;
}
void assignmentAsExpressionIface_set_b(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.b = value;
}
sc_integer assignmentAsExpressionIface_get_c(const AssignmentAsExpression* handle)
{
	return handle->iface.c;
}
void assignmentAsExpressionIface_set_c(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.c = value;
}
sc_integer assignmentAsExpressionIface_get_d(const AssignmentAsExpression* handle)
{
	return handle->iface.d;
}
void assignmentAsExpressionIface_set_d(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.d = value;
}
sc_integer assignmentAsExpressionIface_get_e(const AssignmentAsExpression* handle)
{
	return handle->iface.e;
}
void assignmentAsExpressionIface_set_e(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.e = value;
}
sc_integer assignmentAsExpressionIface_get_f(const AssignmentAsExpression* handle)
{
	return handle->iface.f;
}
void assignmentAsExpressionIface_set_f(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.f = value;
}
sc_integer assignmentAsExpressionIface_get_g(const AssignmentAsExpression* handle)
{
	return handle->iface.g;
}
void assignmentAsExpressionIface_set_g(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.g = value;
}
sc_integer assignmentAsExpressionIface_get_h(const AssignmentAsExpression* handle)
{
	return handle->iface.h;
}
void assignmentAsExpressionIface_set_h(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.h = value;
}
sc_integer assignmentAsExpressionIface_get_i(const AssignmentAsExpression* handle)
{
	return handle->iface.i;
}
void assignmentAsExpressionIface_set_i(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.i = value;
}
sc_integer assignmentAsExpressionIface_get_i1(const AssignmentAsExpression* handle)
{
	return handle->iface.i1;
}
void assignmentAsExpressionIface_set_i1(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.i1 = value;
}
sc_integer assignmentAsExpressionIface_get_j(const AssignmentAsExpression* handle)
{
	return handle->iface.j;
}
void assignmentAsExpressionIface_set_j(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.j = value;
}
sc_integer assignmentAsExpressionIface_get_j1(const AssignmentAsExpression* handle)
{
	return handle->iface.j1;
}
void assignmentAsExpressionIface_set_j1(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.j1 = value;
}
sc_integer assignmentAsExpressionIface_get_k(const AssignmentAsExpression* handle)
{
	return handle->iface.k;
}
void assignmentAsExpressionIface_set_k(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.k = value;
}
sc_integer assignmentAsExpressionIface_get_k1(const AssignmentAsExpression* handle)
{
	return handle->iface.k1;
}
void assignmentAsExpressionIface_set_k1(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.k1 = value;
}
sc_integer assignmentAsExpressionIface_get_l(const AssignmentAsExpression* handle)
{
	return handle->iface.l;
}
void assignmentAsExpressionIface_set_l(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.l = value;
}
sc_integer assignmentAsExpressionIface_get_m(const AssignmentAsExpression* handle)
{
	return handle->iface.m;
}
void assignmentAsExpressionIface_set_m(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.m = value;
}
sc_integer assignmentAsExpressionIface_get_n(const AssignmentAsExpression* handle)
{
	return handle->iface.n;
}
void assignmentAsExpressionIface_set_n(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.n = value;
}
sc_integer assignmentAsExpressionIface_get_p(const AssignmentAsExpression* handle)
{
	return handle->iface.p;
}
void assignmentAsExpressionIface_set_p(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.p = value;
}
sc_integer assignmentAsExpressionIface_get_r(const AssignmentAsExpression* handle)
{
	return handle->iface.r;
}
void assignmentAsExpressionIface_set_r(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.r = value;
}
sc_integer assignmentAsExpressionIface_get_t(const AssignmentAsExpression* handle)
{
	return handle->iface.t;
}
void assignmentAsExpressionIface_set_t(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.t = value;
}
sc_integer assignmentAsExpressionIface_get_u(const AssignmentAsExpression* handle)
{
	return handle->iface.u;
}
void assignmentAsExpressionIface_set_u(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.u = value;
}
sc_integer assignmentAsExpressionIface_get_v(const AssignmentAsExpression* handle)
{
	return handle->iface.v;
}
void assignmentAsExpressionIface_set_v(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.v = value;
}
sc_integer assignmentAsExpressionIface_get_w(const AssignmentAsExpression* handle)
{
	return handle->iface.w;
}
void assignmentAsExpressionIface_set_w(AssignmentAsExpression* handle, sc_integer value)
{
	handle->iface.w = value;
}

/* implementations of all internal functions */

static sc_boolean assignmentAsExpression_check_main_region_Add_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_Multiply_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_Divide_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_Modulo_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_Shift_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_boolean_And_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_boolean_Or_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static sc_boolean assignmentAsExpression_check_main_region_Subtract_tr0_tr0(const AssignmentAsExpression* handle)
{
	return bool_true;
}

static void assignmentAsExpression_effect_main_region_Add_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Add(handle);
	assignmentAsExpression_enseq_main_region_Subtract_default(handle);
}

static void assignmentAsExpression_effect_main_region_Multiply_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Multiply(handle);
	assignmentAsExpression_enseq_main_region_Divide_default(handle);
}

static void assignmentAsExpression_effect_main_region_Divide_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Divide(handle);
	assignmentAsExpression_enseq_main_region_Modulo_default(handle);
}

static void assignmentAsExpression_effect_main_region_Modulo_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Modulo(handle);
	assignmentAsExpression_enseq_main_region_Shift_default(handle);
}

static void assignmentAsExpression_effect_main_region_Shift_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Shift(handle);
	assignmentAsExpression_enseq_main_region_boolean_And_default(handle);
}

static void assignmentAsExpression_effect_main_region_boolean_And_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_boolean_And(handle);
	assignmentAsExpression_enseq_main_region_boolean_Or_default(handle);
}

static void assignmentAsExpression_effect_main_region_boolean_Or_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_boolean_Or(handle);
	assignmentAsExpression_enseq_main_region_boolean_Xor_default(handle);
}

static void assignmentAsExpression_effect_main_region_Subtract_tr0(AssignmentAsExpression* handle)
{
	assignmentAsExpression_exseq_main_region_Subtract(handle);
	assignmentAsExpression_enseq_main_region_Multiply_default(handle);
}

/* Entry action for state 'Add'. */
static void assignmentAsExpression_enact_main_region_Add(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Add'. */
	handle->iface.a = (handle->iface.b = 5) + 4;
}

/* Entry action for state 'Multiply'. */
static void assignmentAsExpression_enact_main_region_Multiply(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Multiply'. */
	handle->iface.e *= (handle->iface.f *= 5) * 3;
}

/* Entry action for state 'Divide'. */
static void assignmentAsExpression_enact_main_region_Divide(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Divide'. */
	handle->iface.g /= (handle->iface.h /= 2) / 4;
}

/* Entry action for state 'Modulo'. */
static void assignmentAsExpression_enact_main_region_Modulo(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Modulo'. */
	handle->iface.i %= (handle->iface.i1 %= 4) % 4;
}

/* Entry action for state 'Shift'. */
static void assignmentAsExpression_enact_main_region_Shift(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Shift'. */
	handle->iface.j <<= (handle->iface.j1 >>= 1);
	handle->iface.k >>= (handle->iface.k1 >>= 2);
}

/* Entry action for state 'boolean And'. */
static void assignmentAsExpression_enact_main_region_boolean_And(AssignmentAsExpression* handle)
{
	/* Entry action for state 'boolean And'. */
	handle->iface.l &= (handle->iface.n &= handle->iface.m);
}

/* Entry action for state 'boolean Or'. */
static void assignmentAsExpression_enact_main_region_boolean_Or(AssignmentAsExpression* handle)
{
	/* Entry action for state 'boolean Or'. */
	handle->iface.p |= (handle->iface.r |= handle->iface.t);
}

/* Entry action for state 'boolean Xor'. */
static void assignmentAsExpression_enact_main_region_boolean_Xor(AssignmentAsExpression* handle)
{
	/* Entry action for state 'boolean Xor'. */
	handle->iface.u ^= (handle->iface.v ^= handle->iface.w);
}

/* Entry action for state 'Subtract'. */
static void assignmentAsExpression_enact_main_region_Subtract(AssignmentAsExpression* handle)
{
	/* Entry action for state 'Subtract'. */
	handle->iface.d -= (handle->iface.c -= 5) - 1;
}

/* 'default' enter sequence for state Add */
static void assignmentAsExpression_enseq_main_region_Add_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Add */
	assignmentAsExpression_enact_main_region_Add(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Add;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Multiply */
static void assignmentAsExpression_enseq_main_region_Multiply_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Multiply */
	assignmentAsExpression_enact_main_region_Multiply(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Multiply;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Divide */
static void assignmentAsExpression_enseq_main_region_Divide_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Divide */
	assignmentAsExpression_enact_main_region_Divide(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Divide;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Modulo */
static void assignmentAsExpression_enseq_main_region_Modulo_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Modulo */
	assignmentAsExpression_enact_main_region_Modulo(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Modulo;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Shift */
static void assignmentAsExpression_enseq_main_region_Shift_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Shift */
	assignmentAsExpression_enact_main_region_Shift(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Shift;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean And */
static void assignmentAsExpression_enseq_main_region_boolean_And_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state boolean And */
	assignmentAsExpression_enact_main_region_boolean_And(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_boolean_And;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean Or */
static void assignmentAsExpression_enseq_main_region_boolean_Or_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state boolean Or */
	assignmentAsExpression_enact_main_region_boolean_Or(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_boolean_Or;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean Xor */
static void assignmentAsExpression_enseq_main_region_boolean_Xor_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state boolean Xor */
	assignmentAsExpression_enact_main_region_boolean_Xor(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_boolean_Xor;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Subtract */
static void assignmentAsExpression_enseq_main_region_Subtract_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for state Subtract */
	assignmentAsExpression_enact_main_region_Subtract(handle);
	handle->stateConfVector[0] = AssignmentAsExpression_main_region_Subtract;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void assignmentAsExpression_enseq_main_region_default(AssignmentAsExpression* handle)
{
	/* 'default' enter sequence for region main region */
	assignmentAsExpression_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Add */
static void assignmentAsExpression_exseq_main_region_Add(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Add */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Multiply */
static void assignmentAsExpression_exseq_main_region_Multiply(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Multiply */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Divide */
static void assignmentAsExpression_exseq_main_region_Divide(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Divide */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Modulo */
static void assignmentAsExpression_exseq_main_region_Modulo(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Modulo */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Shift */
static void assignmentAsExpression_exseq_main_region_Shift(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Shift */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean And */
static void assignmentAsExpression_exseq_main_region_boolean_And(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state boolean And */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean Or */
static void assignmentAsExpression_exseq_main_region_boolean_Or(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state boolean Or */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean Xor */
static void assignmentAsExpression_exseq_main_region_boolean_Xor(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state boolean Xor */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Subtract */
static void assignmentAsExpression_exseq_main_region_Subtract(AssignmentAsExpression* handle)
{
	/* Default exit sequence for state Subtract */
	handle->stateConfVector[0] = AssignmentAsExpression_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void assignmentAsExpression_exseq_main_region(AssignmentAsExpression* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of AssignmentAsExpression.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case AssignmentAsExpression_main_region_Add :
		{
			assignmentAsExpression_exseq_main_region_Add(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Multiply :
		{
			assignmentAsExpression_exseq_main_region_Multiply(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Divide :
		{
			assignmentAsExpression_exseq_main_region_Divide(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Modulo :
		{
			assignmentAsExpression_exseq_main_region_Modulo(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Shift :
		{
			assignmentAsExpression_exseq_main_region_Shift(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_And :
		{
			assignmentAsExpression_exseq_main_region_boolean_And(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_Or :
		{
			assignmentAsExpression_exseq_main_region_boolean_Or(handle);
			break;
		}
		case AssignmentAsExpression_main_region_boolean_Xor :
		{
			assignmentAsExpression_exseq_main_region_boolean_Xor(handle);
			break;
		}
		case AssignmentAsExpression_main_region_Subtract :
		{
			assignmentAsExpression_exseq_main_region_Subtract(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Add. */
static void assignmentAsExpression_react_main_region_Add(AssignmentAsExpression* handle)
{
	/* The reactions of state Add. */
	assignmentAsExpression_effect_main_region_Add_tr0(handle);
}

/* The reactions of state Multiply. */
static void assignmentAsExpression_react_main_region_Multiply(AssignmentAsExpression* handle)
{
	/* The reactions of state Multiply. */
	assignmentAsExpression_effect_main_region_Multiply_tr0(handle);
}

/* The reactions of state Divide. */
static void assignmentAsExpression_react_main_region_Divide(AssignmentAsExpression* handle)
{
	/* The reactions of state Divide. */
	assignmentAsExpression_effect_main_region_Divide_tr0(handle);
}

/* The reactions of state Modulo. */
static void assignmentAsExpression_react_main_region_Modulo(AssignmentAsExpression* handle)
{
	/* The reactions of state Modulo. */
	assignmentAsExpression_effect_main_region_Modulo_tr0(handle);
}

/* The reactions of state Shift. */
static void assignmentAsExpression_react_main_region_Shift(AssignmentAsExpression* handle)
{
	/* The reactions of state Shift. */
	assignmentAsExpression_effect_main_region_Shift_tr0(handle);
}

/* The reactions of state boolean And. */
static void assignmentAsExpression_react_main_region_boolean_And(AssignmentAsExpression* handle)
{
	/* The reactions of state boolean And. */
	assignmentAsExpression_effect_main_region_boolean_And_tr0(handle);
}

/* The reactions of state boolean Or. */
static void assignmentAsExpression_react_main_region_boolean_Or(AssignmentAsExpression* handle)
{
	/* The reactions of state boolean Or. */
	assignmentAsExpression_effect_main_region_boolean_Or_tr0(handle);
}

/* The reactions of state boolean Xor. */
static void assignmentAsExpression_react_main_region_boolean_Xor(AssignmentAsExpression* handle)
{
	/* The reactions of state boolean Xor. */
}

/* The reactions of state Subtract. */
static void assignmentAsExpression_react_main_region_Subtract(AssignmentAsExpression* handle)
{
	/* The reactions of state Subtract. */
	assignmentAsExpression_effect_main_region_Subtract_tr0(handle);
}

/* Default react sequence for initial entry  */
static void assignmentAsExpression_react_main_region__entry_Default(AssignmentAsExpression* handle)
{
	/* Default react sequence for initial entry  */
	assignmentAsExpression_enseq_main_region_Add_default(handle);
}


