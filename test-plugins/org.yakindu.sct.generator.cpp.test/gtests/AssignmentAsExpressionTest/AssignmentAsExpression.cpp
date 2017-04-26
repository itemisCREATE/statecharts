
#include "AssignmentAsExpression.h"
#include <string.h>

/*! \file Implementation of the state machine 'AssignmentAsExpression'
*/

AssignmentAsExpression::AssignmentAsExpression()
{
	
	
	stateConfVectorPosition = 0;
	
}

AssignmentAsExpression::~AssignmentAsExpression()
{
}


void AssignmentAsExpression::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = AssignmentAsExpression_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart AssignmentAsExpression */
	iface.a = 0;
	iface.b = 0;
	iface.c = 0;
	iface.d = 0;
	iface.e = 1;
	iface.f = 1;
	iface.g = 4;
	iface.h = 32;
	iface.i = 7;
	iface.i1 = 7;
	iface.j = 8;
	iface.j1 = 2;
	iface.k = 8;
	iface.k1 = 4;
	iface.l = 3;
	iface.m = 7;
	iface.n = 5;
	iface.p = 0;
	iface.r = 7;
	iface.t = 10;
	iface.u = 6;
	iface.v = 13;
	iface.w = 7;
}

void AssignmentAsExpression::enter()
{
	/* Default enter sequence for statechart AssignmentAsExpression */
	enseq_main_region_default();
}

void AssignmentAsExpression::exit()
{
	/* Default exit sequence for statechart AssignmentAsExpression */
	exseq_main_region();
}

sc_boolean AssignmentAsExpression::isActive() const
{
	return stateConfVector[0] != AssignmentAsExpression_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean AssignmentAsExpression::isFinal() const
{
   return false;}

void AssignmentAsExpression::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_Add :
		{
			react_main_region_Add();
			break;
		}
		case main_region_Multiply :
		{
			react_main_region_Multiply();
			break;
		}
		case main_region_Divide :
		{
			react_main_region_Divide();
			break;
		}
		case main_region_Modulo :
		{
			react_main_region_Modulo();
			break;
		}
		case main_region_Shift :
		{
			react_main_region_Shift();
			break;
		}
		case main_region_boolean_And :
		{
			react_main_region_boolean_And();
			break;
		}
		case main_region_boolean_Or :
		{
			react_main_region_boolean_Or();
			break;
		}
		case main_region_boolean_Xor :
		{
			react_main_region_boolean_Xor();
			break;
		}
		case main_region_Subtract :
		{
			react_main_region_Subtract();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void AssignmentAsExpression::clearInEvents()
{
}

void AssignmentAsExpression::clearOutEvents()
{
}


sc_boolean AssignmentAsExpression::isStateActive(AssignmentAsExpressionStates state) const
{
	switch (state)
	{
		case main_region_Add : 
			return (sc_boolean) (stateConfVector[0] == main_region_Add
			);
		case main_region_Multiply : 
			return (sc_boolean) (stateConfVector[0] == main_region_Multiply
			);
		case main_region_Divide : 
			return (sc_boolean) (stateConfVector[0] == main_region_Divide
			);
		case main_region_Modulo : 
			return (sc_boolean) (stateConfVector[0] == main_region_Modulo
			);
		case main_region_Shift : 
			return (sc_boolean) (stateConfVector[0] == main_region_Shift
			);
		case main_region_boolean_And : 
			return (sc_boolean) (stateConfVector[0] == main_region_boolean_And
			);
		case main_region_boolean_Or : 
			return (sc_boolean) (stateConfVector[0] == main_region_boolean_Or
			);
		case main_region_boolean_Xor : 
			return (sc_boolean) (stateConfVector[0] == main_region_boolean_Xor
			);
		case main_region_Subtract : 
			return (sc_boolean) (stateConfVector[0] == main_region_Subtract
			);
		default: return false;
	}
}

AssignmentAsExpression::DefaultSCI* AssignmentAsExpression::getDefaultSCI()
{
	return &iface;
}


sc_integer AssignmentAsExpression::DefaultSCI::get_a() const
{
	return a;
}

sc_integer AssignmentAsExpression::get_a() const
{
	return iface.a;
}

void AssignmentAsExpression::DefaultSCI::set_a(sc_integer value)
{
	a = value;
}

void AssignmentAsExpression::set_a(sc_integer value)
{
	iface.a = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_b() const
{
	return b;
}

sc_integer AssignmentAsExpression::get_b() const
{
	return iface.b;
}

void AssignmentAsExpression::DefaultSCI::set_b(sc_integer value)
{
	b = value;
}

void AssignmentAsExpression::set_b(sc_integer value)
{
	iface.b = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_c() const
{
	return c;
}

sc_integer AssignmentAsExpression::get_c() const
{
	return iface.c;
}

void AssignmentAsExpression::DefaultSCI::set_c(sc_integer value)
{
	c = value;
}

void AssignmentAsExpression::set_c(sc_integer value)
{
	iface.c = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_d() const
{
	return d;
}

sc_integer AssignmentAsExpression::get_d() const
{
	return iface.d;
}

void AssignmentAsExpression::DefaultSCI::set_d(sc_integer value)
{
	d = value;
}

void AssignmentAsExpression::set_d(sc_integer value)
{
	iface.d = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_e() const
{
	return e;
}

sc_integer AssignmentAsExpression::get_e() const
{
	return iface.e;
}

void AssignmentAsExpression::DefaultSCI::set_e(sc_integer value)
{
	e = value;
}

void AssignmentAsExpression::set_e(sc_integer value)
{
	iface.e = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_f() const
{
	return f;
}

sc_integer AssignmentAsExpression::get_f() const
{
	return iface.f;
}

void AssignmentAsExpression::DefaultSCI::set_f(sc_integer value)
{
	f = value;
}

void AssignmentAsExpression::set_f(sc_integer value)
{
	iface.f = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_g() const
{
	return g;
}

sc_integer AssignmentAsExpression::get_g() const
{
	return iface.g;
}

void AssignmentAsExpression::DefaultSCI::set_g(sc_integer value)
{
	g = value;
}

void AssignmentAsExpression::set_g(sc_integer value)
{
	iface.g = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_h() const
{
	return h;
}

sc_integer AssignmentAsExpression::get_h() const
{
	return iface.h;
}

void AssignmentAsExpression::DefaultSCI::set_h(sc_integer value)
{
	h = value;
}

void AssignmentAsExpression::set_h(sc_integer value)
{
	iface.h = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_i() const
{
	return i;
}

sc_integer AssignmentAsExpression::get_i() const
{
	return iface.i;
}

void AssignmentAsExpression::DefaultSCI::set_i(sc_integer value)
{
	i = value;
}

void AssignmentAsExpression::set_i(sc_integer value)
{
	iface.i = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_i1() const
{
	return i1;
}

sc_integer AssignmentAsExpression::get_i1() const
{
	return iface.i1;
}

void AssignmentAsExpression::DefaultSCI::set_i1(sc_integer value)
{
	i1 = value;
}

void AssignmentAsExpression::set_i1(sc_integer value)
{
	iface.i1 = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_j() const
{
	return j;
}

sc_integer AssignmentAsExpression::get_j() const
{
	return iface.j;
}

void AssignmentAsExpression::DefaultSCI::set_j(sc_integer value)
{
	j = value;
}

void AssignmentAsExpression::set_j(sc_integer value)
{
	iface.j = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_j1() const
{
	return j1;
}

sc_integer AssignmentAsExpression::get_j1() const
{
	return iface.j1;
}

void AssignmentAsExpression::DefaultSCI::set_j1(sc_integer value)
{
	j1 = value;
}

void AssignmentAsExpression::set_j1(sc_integer value)
{
	iface.j1 = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_k() const
{
	return k;
}

sc_integer AssignmentAsExpression::get_k() const
{
	return iface.k;
}

void AssignmentAsExpression::DefaultSCI::set_k(sc_integer value)
{
	k = value;
}

void AssignmentAsExpression::set_k(sc_integer value)
{
	iface.k = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_k1() const
{
	return k1;
}

sc_integer AssignmentAsExpression::get_k1() const
{
	return iface.k1;
}

void AssignmentAsExpression::DefaultSCI::set_k1(sc_integer value)
{
	k1 = value;
}

void AssignmentAsExpression::set_k1(sc_integer value)
{
	iface.k1 = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_l() const
{
	return l;
}

sc_integer AssignmentAsExpression::get_l() const
{
	return iface.l;
}

void AssignmentAsExpression::DefaultSCI::set_l(sc_integer value)
{
	l = value;
}

void AssignmentAsExpression::set_l(sc_integer value)
{
	iface.l = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_m() const
{
	return m;
}

sc_integer AssignmentAsExpression::get_m() const
{
	return iface.m;
}

void AssignmentAsExpression::DefaultSCI::set_m(sc_integer value)
{
	m = value;
}

void AssignmentAsExpression::set_m(sc_integer value)
{
	iface.m = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_n() const
{
	return n;
}

sc_integer AssignmentAsExpression::get_n() const
{
	return iface.n;
}

void AssignmentAsExpression::DefaultSCI::set_n(sc_integer value)
{
	n = value;
}

void AssignmentAsExpression::set_n(sc_integer value)
{
	iface.n = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_p() const
{
	return p;
}

sc_integer AssignmentAsExpression::get_p() const
{
	return iface.p;
}

void AssignmentAsExpression::DefaultSCI::set_p(sc_integer value)
{
	p = value;
}

void AssignmentAsExpression::set_p(sc_integer value)
{
	iface.p = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_r() const
{
	return r;
}

sc_integer AssignmentAsExpression::get_r() const
{
	return iface.r;
}

void AssignmentAsExpression::DefaultSCI::set_r(sc_integer value)
{
	r = value;
}

void AssignmentAsExpression::set_r(sc_integer value)
{
	iface.r = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_t() const
{
	return t;
}

sc_integer AssignmentAsExpression::get_t() const
{
	return iface.t;
}

void AssignmentAsExpression::DefaultSCI::set_t(sc_integer value)
{
	t = value;
}

void AssignmentAsExpression::set_t(sc_integer value)
{
	iface.t = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_u() const
{
	return u;
}

sc_integer AssignmentAsExpression::get_u() const
{
	return iface.u;
}

void AssignmentAsExpression::DefaultSCI::set_u(sc_integer value)
{
	u = value;
}

void AssignmentAsExpression::set_u(sc_integer value)
{
	iface.u = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_v() const
{
	return v;
}

sc_integer AssignmentAsExpression::get_v() const
{
	return iface.v;
}

void AssignmentAsExpression::DefaultSCI::set_v(sc_integer value)
{
	v = value;
}

void AssignmentAsExpression::set_v(sc_integer value)
{
	iface.v = value;
}

sc_integer AssignmentAsExpression::DefaultSCI::get_w() const
{
	return w;
}

sc_integer AssignmentAsExpression::get_w() const
{
	return iface.w;
}

void AssignmentAsExpression::DefaultSCI::set_w(sc_integer value)
{
	w = value;
}

void AssignmentAsExpression::set_w(sc_integer value)
{
	iface.w = value;
}


// implementations of all internal functions

sc_boolean AssignmentAsExpression::check_main_region_Add_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_Multiply_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_Divide_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_Modulo_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_Shift_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_boolean_And_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_boolean_Or_tr0_tr0()
{
	return true;
}

sc_boolean AssignmentAsExpression::check_main_region_Subtract_tr0_tr0()
{
	return true;
}

void AssignmentAsExpression::effect_main_region_Add_tr0()
{
	exseq_main_region_Add();
	enseq_main_region_Subtract_default();
}

void AssignmentAsExpression::effect_main_region_Multiply_tr0()
{
	exseq_main_region_Multiply();
	enseq_main_region_Divide_default();
}

void AssignmentAsExpression::effect_main_region_Divide_tr0()
{
	exseq_main_region_Divide();
	enseq_main_region_Modulo_default();
}

void AssignmentAsExpression::effect_main_region_Modulo_tr0()
{
	exseq_main_region_Modulo();
	enseq_main_region_Shift_default();
}

void AssignmentAsExpression::effect_main_region_Shift_tr0()
{
	exseq_main_region_Shift();
	enseq_main_region_boolean_And_default();
}

void AssignmentAsExpression::effect_main_region_boolean_And_tr0()
{
	exseq_main_region_boolean_And();
	enseq_main_region_boolean_Or_default();
}

void AssignmentAsExpression::effect_main_region_boolean_Or_tr0()
{
	exseq_main_region_boolean_Or();
	enseq_main_region_boolean_Xor_default();
}

void AssignmentAsExpression::effect_main_region_Subtract_tr0()
{
	exseq_main_region_Subtract();
	enseq_main_region_Multiply_default();
}

/* Entry action for state 'Add'. */
void AssignmentAsExpression::enact_main_region_Add()
{
	/* Entry action for state 'Add'. */
	iface.a = (iface.b = 5) + 4;
}

/* Entry action for state 'Multiply'. */
void AssignmentAsExpression::enact_main_region_Multiply()
{
	/* Entry action for state 'Multiply'. */
	iface.e *= (iface.f *= 5) * 3;
}

/* Entry action for state 'Divide'. */
void AssignmentAsExpression::enact_main_region_Divide()
{
	/* Entry action for state 'Divide'. */
	iface.g /= (iface.h /= 2) / 4;
}

/* Entry action for state 'Modulo'. */
void AssignmentAsExpression::enact_main_region_Modulo()
{
	/* Entry action for state 'Modulo'. */
	iface.i %= (iface.i1 %= 4) % 4;
}

/* Entry action for state 'Shift'. */
void AssignmentAsExpression::enact_main_region_Shift()
{
	/* Entry action for state 'Shift'. */
	iface.j <<= (iface.j1 >>= 1);
	iface.k >>= (iface.k1 >>= 2);
}

/* Entry action for state 'boolean And'. */
void AssignmentAsExpression::enact_main_region_boolean_And()
{
	/* Entry action for state 'boolean And'. */
	iface.l &= (iface.n &= iface.m);
}

/* Entry action for state 'boolean Or'. */
void AssignmentAsExpression::enact_main_region_boolean_Or()
{
	/* Entry action for state 'boolean Or'. */
	iface.p |= (iface.r |= iface.t);
}

/* Entry action for state 'boolean Xor'. */
void AssignmentAsExpression::enact_main_region_boolean_Xor()
{
	/* Entry action for state 'boolean Xor'. */
	iface.u ^= (iface.v ^= iface.w);
}

/* Entry action for state 'Subtract'. */
void AssignmentAsExpression::enact_main_region_Subtract()
{
	/* Entry action for state 'Subtract'. */
	iface.d -= (iface.c -= 5) - 1;
}

/* 'default' enter sequence for state Add */
void AssignmentAsExpression::enseq_main_region_Add_default()
{
	/* 'default' enter sequence for state Add */
	enact_main_region_Add();
	stateConfVector[0] = main_region_Add;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Multiply */
void AssignmentAsExpression::enseq_main_region_Multiply_default()
{
	/* 'default' enter sequence for state Multiply */
	enact_main_region_Multiply();
	stateConfVector[0] = main_region_Multiply;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Divide */
void AssignmentAsExpression::enseq_main_region_Divide_default()
{
	/* 'default' enter sequence for state Divide */
	enact_main_region_Divide();
	stateConfVector[0] = main_region_Divide;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Modulo */
void AssignmentAsExpression::enseq_main_region_Modulo_default()
{
	/* 'default' enter sequence for state Modulo */
	enact_main_region_Modulo();
	stateConfVector[0] = main_region_Modulo;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Shift */
void AssignmentAsExpression::enseq_main_region_Shift_default()
{
	/* 'default' enter sequence for state Shift */
	enact_main_region_Shift();
	stateConfVector[0] = main_region_Shift;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean And */
void AssignmentAsExpression::enseq_main_region_boolean_And_default()
{
	/* 'default' enter sequence for state boolean And */
	enact_main_region_boolean_And();
	stateConfVector[0] = main_region_boolean_And;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean Or */
void AssignmentAsExpression::enseq_main_region_boolean_Or_default()
{
	/* 'default' enter sequence for state boolean Or */
	enact_main_region_boolean_Or();
	stateConfVector[0] = main_region_boolean_Or;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state boolean Xor */
void AssignmentAsExpression::enseq_main_region_boolean_Xor_default()
{
	/* 'default' enter sequence for state boolean Xor */
	enact_main_region_boolean_Xor();
	stateConfVector[0] = main_region_boolean_Xor;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Subtract */
void AssignmentAsExpression::enseq_main_region_Subtract_default()
{
	/* 'default' enter sequence for state Subtract */
	enact_main_region_Subtract();
	stateConfVector[0] = main_region_Subtract;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void AssignmentAsExpression::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Add */
void AssignmentAsExpression::exseq_main_region_Add()
{
	/* Default exit sequence for state Add */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Multiply */
void AssignmentAsExpression::exseq_main_region_Multiply()
{
	/* Default exit sequence for state Multiply */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Divide */
void AssignmentAsExpression::exseq_main_region_Divide()
{
	/* Default exit sequence for state Divide */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Modulo */
void AssignmentAsExpression::exseq_main_region_Modulo()
{
	/* Default exit sequence for state Modulo */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Shift */
void AssignmentAsExpression::exseq_main_region_Shift()
{
	/* Default exit sequence for state Shift */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean And */
void AssignmentAsExpression::exseq_main_region_boolean_And()
{
	/* Default exit sequence for state boolean And */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean Or */
void AssignmentAsExpression::exseq_main_region_boolean_Or()
{
	/* Default exit sequence for state boolean Or */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state boolean Xor */
void AssignmentAsExpression::exseq_main_region_boolean_Xor()
{
	/* Default exit sequence for state boolean Xor */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Subtract */
void AssignmentAsExpression::exseq_main_region_Subtract()
{
	/* Default exit sequence for state Subtract */
	stateConfVector[0] = AssignmentAsExpression_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void AssignmentAsExpression::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of AssignmentAsExpression.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Add :
		{
			exseq_main_region_Add();
			break;
		}
		case main_region_Multiply :
		{
			exseq_main_region_Multiply();
			break;
		}
		case main_region_Divide :
		{
			exseq_main_region_Divide();
			break;
		}
		case main_region_Modulo :
		{
			exseq_main_region_Modulo();
			break;
		}
		case main_region_Shift :
		{
			exseq_main_region_Shift();
			break;
		}
		case main_region_boolean_And :
		{
			exseq_main_region_boolean_And();
			break;
		}
		case main_region_boolean_Or :
		{
			exseq_main_region_boolean_Or();
			break;
		}
		case main_region_boolean_Xor :
		{
			exseq_main_region_boolean_Xor();
			break;
		}
		case main_region_Subtract :
		{
			exseq_main_region_Subtract();
			break;
		}
		default: break;
	}
}

/* The reactions of state Add. */
void AssignmentAsExpression::react_main_region_Add()
{
	/* The reactions of state Add. */
	effect_main_region_Add_tr0();
}

/* The reactions of state Multiply. */
void AssignmentAsExpression::react_main_region_Multiply()
{
	/* The reactions of state Multiply. */
	effect_main_region_Multiply_tr0();
}

/* The reactions of state Divide. */
void AssignmentAsExpression::react_main_region_Divide()
{
	/* The reactions of state Divide. */
	effect_main_region_Divide_tr0();
}

/* The reactions of state Modulo. */
void AssignmentAsExpression::react_main_region_Modulo()
{
	/* The reactions of state Modulo. */
	effect_main_region_Modulo_tr0();
}

/* The reactions of state Shift. */
void AssignmentAsExpression::react_main_region_Shift()
{
	/* The reactions of state Shift. */
	effect_main_region_Shift_tr0();
}

/* The reactions of state boolean And. */
void AssignmentAsExpression::react_main_region_boolean_And()
{
	/* The reactions of state boolean And. */
	effect_main_region_boolean_And_tr0();
}

/* The reactions of state boolean Or. */
void AssignmentAsExpression::react_main_region_boolean_Or()
{
	/* The reactions of state boolean Or. */
	effect_main_region_boolean_Or_tr0();
}

/* The reactions of state boolean Xor. */
void AssignmentAsExpression::react_main_region_boolean_Xor()
{
	/* The reactions of state boolean Xor. */
}

/* The reactions of state Subtract. */
void AssignmentAsExpression::react_main_region_Subtract()
{
	/* The reactions of state Subtract. */
	effect_main_region_Subtract_tr0();
}

/* Default react sequence for initial entry  */
void AssignmentAsExpression::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Add_default();
}


