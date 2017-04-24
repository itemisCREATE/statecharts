
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "STextKeywordsInStatesAndRegions.h"
/*! \file Implementation of the state machine 'STextKeywordsInStatesAndRegions'
*/

/* prototypes of all internal functions */
static sc_boolean sTextKeywordsInStatesAndRegions_check_operation_interface_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_namespace_event_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_local_in_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_interface_var_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_internal_external_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_event_default_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_in_entry_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_out_always_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_var_raise_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_readonly_active_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_external_interface_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_else_event_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_entry_in_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_exit_var_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_always_external_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_oncycle_default_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_raise_entry_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_valueof_always_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static sc_boolean sTextKeywordsInStatesAndRegions_check_active_raise_tr0_tr0(const STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_operation_interface_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_namespace_event_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_local_in_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_interface_var_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_internal_external_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_event_default_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_in_entry_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_out_always_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_var_raise_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_readonly_active_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_external_interface_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_else_event_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_entry_in_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_exit_var_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_always_external_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_oncycle_default_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_raise_entry_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_valueof_always_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_effect_active_raise_tr0(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_default_namespace_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_operation_interface_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_operation_internal_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_namespace_event_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_namespace_local_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_local_in_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_local_out_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_interface_var_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_interface_readonly_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_internal_external_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_internal_operation_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_event_default_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_event_else_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_in_entry_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_in_exit_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_out_always_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_out_oncycle_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_var_raise_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_var_valueof_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_readonly_active_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_readonly_namespace_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_external_interface_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_external_internal_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_else_event_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_else_local_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_entry_in_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_entry_out_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_exit_var_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_exit_readonly_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_always_external_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_always_operation_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_default_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_else_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_raise_entry_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_raise_exit_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_valueof_always_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_valueof_oncycle_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_active_raise_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_active_valueof_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_default_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_operation_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_namespace_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_local_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_interface_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_internal_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_event_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_in_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_out_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_var_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_readonly_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_external_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_else_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_entry_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_exit_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_always_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_raise_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_valueof_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_enseq_active_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_default_namespace(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_operation_interface(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_operation_internal(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_namespace_event(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_namespace_local(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_local_in(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_local_out(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_interface_var(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_interface_readonly(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_internal_external(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_internal_operation(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_event_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_event_else(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_in_entry(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_in_exit(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_out_always(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_out_oncycle(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_var_raise(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_var_valueof(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_readonly_active(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_readonly_namespace(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_external_interface(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_external_internal(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_else_event(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_else_local(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_entry_in(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_entry_out(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_exit_var(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_exit_readonly(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_always_external(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_always_operation(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_oncycle_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_oncycle_else(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_raise_entry(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_raise_exit(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_valueof_always(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_valueof_oncycle(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_active_raise(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_active_valueof(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_operation(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_namespace(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_local(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_interface(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_internal(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_event(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_in(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_out(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_var(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_readonly(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_external(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_else(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_entry(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_exit(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_always(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_oncycle(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_raise(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_valueof(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_exseq_active(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_default_namespace(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_operation_interface(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_operation_internal(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_namespace_event(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_namespace_local(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_local_in(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_local_out(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_interface_var(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_interface_readonly(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_internal_external(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_internal_operation(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_event_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_event_else(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_in_entry(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_in_exit(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_out_always(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_out_oncycle(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_var_raise(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_var_valueof(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_readonly_active(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_readonly_namespace(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_external_interface(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_external_internal(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_else_event(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_else_local(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_entry_in(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_entry_out(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_exit_var(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_exit_readonly(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_always_external(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_always_operation(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_oncycle_default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_oncycle_else(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_raise_entry(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_raise_exit(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_valueof_always(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_valueof_oncycle(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_active_raise(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_active_valueof(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_default__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_operation__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_namespace__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_local__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_interface__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_internal__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_event__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_in__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_out__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_var__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_readonly__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_external__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_else__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_entry__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_exit__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_always__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_oncycle__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_raise__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_valueof__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_react_active__entry_Default(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_clearInEvents(STextKeywordsInStatesAndRegions* handle);
static void sTextKeywordsInStatesAndRegions_clearOutEvents(STextKeywordsInStatesAndRegions* handle);


void sTextKeywordsInStatesAndRegions_init(STextKeywordsInStatesAndRegions* handle)
{
	sc_integer i;

	for (i = 0; i < STEXTKEYWORDSINSTATESANDREGIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = STextKeywordsInStatesAndRegions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	sTextKeywordsInStatesAndRegions_clearInEvents(handle);
	sTextKeywordsInStatesAndRegions_clearOutEvents(handle);


}

void sTextKeywordsInStatesAndRegions_enter(STextKeywordsInStatesAndRegions* handle)
{
	/* Default enter sequence for statechart STextKeywordsInStatesAndRegions */
	sTextKeywordsInStatesAndRegions_enseq_default_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_operation_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_namespace_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_local_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_interface_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_internal_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_event_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_in_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_out_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_var_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_readonly_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_external_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_else_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_entry_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_exit_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_always_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_oncycle_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_raise_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_valueof_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_active_default(handle);
}

void sTextKeywordsInStatesAndRegions_exit(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for statechart STextKeywordsInStatesAndRegions */
	sTextKeywordsInStatesAndRegions_exseq_default(handle);
	sTextKeywordsInStatesAndRegions_exseq_operation(handle);
	sTextKeywordsInStatesAndRegions_exseq_namespace(handle);
	sTextKeywordsInStatesAndRegions_exseq_local(handle);
	sTextKeywordsInStatesAndRegions_exseq_interface(handle);
	sTextKeywordsInStatesAndRegions_exseq_internal(handle);
	sTextKeywordsInStatesAndRegions_exseq_event(handle);
	sTextKeywordsInStatesAndRegions_exseq_in(handle);
	sTextKeywordsInStatesAndRegions_exseq_out(handle);
	sTextKeywordsInStatesAndRegions_exseq_var(handle);
	sTextKeywordsInStatesAndRegions_exseq_readonly(handle);
	sTextKeywordsInStatesAndRegions_exseq_external(handle);
	sTextKeywordsInStatesAndRegions_exseq_else(handle);
	sTextKeywordsInStatesAndRegions_exseq_entry(handle);
	sTextKeywordsInStatesAndRegions_exseq_exit(handle);
	sTextKeywordsInStatesAndRegions_exseq_always(handle);
	sTextKeywordsInStatesAndRegions_exseq_oncycle(handle);
	sTextKeywordsInStatesAndRegions_exseq_raise(handle);
	sTextKeywordsInStatesAndRegions_exseq_valueof(handle);
	sTextKeywordsInStatesAndRegions_exseq_active(handle);
}

sc_boolean sTextKeywordsInStatesAndRegions_isActive(const STextKeywordsInStatesAndRegions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[1] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[2] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[3] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[4] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[5] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[6] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[7] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[8] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[9] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[10] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[11] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[12] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[13] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[14] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[15] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[16] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[17] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[18] != STextKeywordsInStatesAndRegions_last_state || handle->stateConfVector[19] != STextKeywordsInStatesAndRegions_last_state)
	{
		result =  bool_true;
	}
	else
	{
		result = bool_false;
	}
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean sTextKeywordsInStatesAndRegions_isFinal(const STextKeywordsInStatesAndRegions* handle)
{
   return bool_false;
}

static void sTextKeywordsInStatesAndRegions_clearInEvents(STextKeywordsInStatesAndRegions* handle)
{
	handle->iface.e1_raised = bool_false;
	handle->iface.e2_raised = bool_false;
}

static void sTextKeywordsInStatesAndRegions_clearOutEvents(STextKeywordsInStatesAndRegions* handle)
{
}

void sTextKeywordsInStatesAndRegions_runCycle(STextKeywordsInStatesAndRegions* handle)
{
	
	sTextKeywordsInStatesAndRegions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STEXTKEYWORDSINSTATESANDREGIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case STextKeywordsInStatesAndRegions_default_namespace :
		{
			sTextKeywordsInStatesAndRegions_react_default_namespace(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_operation_interface :
		{
			sTextKeywordsInStatesAndRegions_react_operation_interface(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_operation_internal :
		{
			sTextKeywordsInStatesAndRegions_react_operation_internal(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_namespace_event :
		{
			sTextKeywordsInStatesAndRegions_react_namespace_event(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_namespace_local :
		{
			sTextKeywordsInStatesAndRegions_react_namespace_local(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_local_in :
		{
			sTextKeywordsInStatesAndRegions_react_local_in(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_local_out :
		{
			sTextKeywordsInStatesAndRegions_react_local_out(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_interface_var :
		{
			sTextKeywordsInStatesAndRegions_react_interface_var(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_interface_readonly :
		{
			sTextKeywordsInStatesAndRegions_react_interface_readonly(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_internal_external :
		{
			sTextKeywordsInStatesAndRegions_react_internal_external(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_internal_operation :
		{
			sTextKeywordsInStatesAndRegions_react_internal_operation(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_event_default :
		{
			sTextKeywordsInStatesAndRegions_react_event_default(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_event_else :
		{
			sTextKeywordsInStatesAndRegions_react_event_else(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_in_entry :
		{
			sTextKeywordsInStatesAndRegions_react_in_entry(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_in_exit :
		{
			sTextKeywordsInStatesAndRegions_react_in_exit(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_out_always :
		{
			sTextKeywordsInStatesAndRegions_react_out_always(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_out_oncycle :
		{
			sTextKeywordsInStatesAndRegions_react_out_oncycle(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_var_raise :
		{
			sTextKeywordsInStatesAndRegions_react_var_raise(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_var_valueof :
		{
			sTextKeywordsInStatesAndRegions_react_var_valueof(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_readonly_active :
		{
			sTextKeywordsInStatesAndRegions_react_readonly_active(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_readonly_namespace :
		{
			sTextKeywordsInStatesAndRegions_react_readonly_namespace(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_external_interface :
		{
			sTextKeywordsInStatesAndRegions_react_external_interface(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_external_internal :
		{
			sTextKeywordsInStatesAndRegions_react_external_internal(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_else_event :
		{
			sTextKeywordsInStatesAndRegions_react_else_event(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_else_local :
		{
			sTextKeywordsInStatesAndRegions_react_else_local(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_entry_in :
		{
			sTextKeywordsInStatesAndRegions_react_entry_in(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_entry_out :
		{
			sTextKeywordsInStatesAndRegions_react_entry_out(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_exit_var :
		{
			sTextKeywordsInStatesAndRegions_react_exit_var(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_exit_readonly :
		{
			sTextKeywordsInStatesAndRegions_react_exit_readonly(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_always_external :
		{
			sTextKeywordsInStatesAndRegions_react_always_external(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_always_operation :
		{
			sTextKeywordsInStatesAndRegions_react_always_operation(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_oncycle_default :
		{
			sTextKeywordsInStatesAndRegions_react_oncycle_default(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_oncycle_else :
		{
			sTextKeywordsInStatesAndRegions_react_oncycle_else(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_raise_entry :
		{
			sTextKeywordsInStatesAndRegions_react_raise_entry(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_raise_exit :
		{
			sTextKeywordsInStatesAndRegions_react_raise_exit(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_valueof_always :
		{
			sTextKeywordsInStatesAndRegions_react_valueof_always(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_valueof_oncycle :
		{
			sTextKeywordsInStatesAndRegions_react_valueof_oncycle(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_active_raise :
		{
			sTextKeywordsInStatesAndRegions_react_active_raise(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_active_valueof :
		{
			sTextKeywordsInStatesAndRegions_react_active_valueof(handle);
			break;
		}
		default:
			break;
		}
	}
	
	sTextKeywordsInStatesAndRegions_clearInEvents(handle);
}


sc_boolean sTextKeywordsInStatesAndRegions_isStateActive(const STextKeywordsInStatesAndRegions* handle, STextKeywordsInStatesAndRegionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case STextKeywordsInStatesAndRegions_default_namespace :
			result = (sc_boolean) (handle->stateConfVector[0] == STextKeywordsInStatesAndRegions_default_namespace
			);
			break;
		case STextKeywordsInStatesAndRegions_operation_interface :
			result = (sc_boolean) (handle->stateConfVector[1] == STextKeywordsInStatesAndRegions_operation_interface
			);
			break;
		case STextKeywordsInStatesAndRegions_operation_internal :
			result = (sc_boolean) (handle->stateConfVector[1] == STextKeywordsInStatesAndRegions_operation_internal
			);
			break;
		case STextKeywordsInStatesAndRegions_namespace_event :
			result = (sc_boolean) (handle->stateConfVector[2] == STextKeywordsInStatesAndRegions_namespace_event
			);
			break;
		case STextKeywordsInStatesAndRegions_namespace_local :
			result = (sc_boolean) (handle->stateConfVector[2] == STextKeywordsInStatesAndRegions_namespace_local
			);
			break;
		case STextKeywordsInStatesAndRegions_local_in :
			result = (sc_boolean) (handle->stateConfVector[3] == STextKeywordsInStatesAndRegions_local_in
			);
			break;
		case STextKeywordsInStatesAndRegions_local_out :
			result = (sc_boolean) (handle->stateConfVector[3] == STextKeywordsInStatesAndRegions_local_out
			);
			break;
		case STextKeywordsInStatesAndRegions_interface_var :
			result = (sc_boolean) (handle->stateConfVector[4] == STextKeywordsInStatesAndRegions_interface_var
			);
			break;
		case STextKeywordsInStatesAndRegions_interface_readonly :
			result = (sc_boolean) (handle->stateConfVector[4] == STextKeywordsInStatesAndRegions_interface_readonly
			);
			break;
		case STextKeywordsInStatesAndRegions_internal_external :
			result = (sc_boolean) (handle->stateConfVector[5] == STextKeywordsInStatesAndRegions_internal_external
			);
			break;
		case STextKeywordsInStatesAndRegions_internal_operation :
			result = (sc_boolean) (handle->stateConfVector[5] == STextKeywordsInStatesAndRegions_internal_operation
			);
			break;
		case STextKeywordsInStatesAndRegions_event_default :
			result = (sc_boolean) (handle->stateConfVector[6] == STextKeywordsInStatesAndRegions_event_default
			);
			break;
		case STextKeywordsInStatesAndRegions_event_else :
			result = (sc_boolean) (handle->stateConfVector[6] == STextKeywordsInStatesAndRegions_event_else
			);
			break;
		case STextKeywordsInStatesAndRegions_in_entry :
			result = (sc_boolean) (handle->stateConfVector[7] == STextKeywordsInStatesAndRegions_in_entry
			);
			break;
		case STextKeywordsInStatesAndRegions_in_exit :
			result = (sc_boolean) (handle->stateConfVector[7] == STextKeywordsInStatesAndRegions_in_exit
			);
			break;
		case STextKeywordsInStatesAndRegions_out_always :
			result = (sc_boolean) (handle->stateConfVector[8] == STextKeywordsInStatesAndRegions_out_always
			);
			break;
		case STextKeywordsInStatesAndRegions_out_oncycle :
			result = (sc_boolean) (handle->stateConfVector[8] == STextKeywordsInStatesAndRegions_out_oncycle
			);
			break;
		case STextKeywordsInStatesAndRegions_var_raise :
			result = (sc_boolean) (handle->stateConfVector[9] == STextKeywordsInStatesAndRegions_var_raise
			);
			break;
		case STextKeywordsInStatesAndRegions_var_valueof :
			result = (sc_boolean) (handle->stateConfVector[9] == STextKeywordsInStatesAndRegions_var_valueof
			);
			break;
		case STextKeywordsInStatesAndRegions_readonly_active :
			result = (sc_boolean) (handle->stateConfVector[10] == STextKeywordsInStatesAndRegions_readonly_active
			);
			break;
		case STextKeywordsInStatesAndRegions_readonly_namespace :
			result = (sc_boolean) (handle->stateConfVector[10] == STextKeywordsInStatesAndRegions_readonly_namespace
			);
			break;
		case STextKeywordsInStatesAndRegions_external_interface :
			result = (sc_boolean) (handle->stateConfVector[11] == STextKeywordsInStatesAndRegions_external_interface
			);
			break;
		case STextKeywordsInStatesAndRegions_external_internal :
			result = (sc_boolean) (handle->stateConfVector[11] == STextKeywordsInStatesAndRegions_external_internal
			);
			break;
		case STextKeywordsInStatesAndRegions_else_event :
			result = (sc_boolean) (handle->stateConfVector[12] == STextKeywordsInStatesAndRegions_else_event
			);
			break;
		case STextKeywordsInStatesAndRegions_else_local :
			result = (sc_boolean) (handle->stateConfVector[12] == STextKeywordsInStatesAndRegions_else_local
			);
			break;
		case STextKeywordsInStatesAndRegions_entry_in :
			result = (sc_boolean) (handle->stateConfVector[13] == STextKeywordsInStatesAndRegions_entry_in
			);
			break;
		case STextKeywordsInStatesAndRegions_entry_out :
			result = (sc_boolean) (handle->stateConfVector[13] == STextKeywordsInStatesAndRegions_entry_out
			);
			break;
		case STextKeywordsInStatesAndRegions_exit_var :
			result = (sc_boolean) (handle->stateConfVector[14] == STextKeywordsInStatesAndRegions_exit_var
			);
			break;
		case STextKeywordsInStatesAndRegions_exit_readonly :
			result = (sc_boolean) (handle->stateConfVector[14] == STextKeywordsInStatesAndRegions_exit_readonly
			);
			break;
		case STextKeywordsInStatesAndRegions_always_external :
			result = (sc_boolean) (handle->stateConfVector[15] == STextKeywordsInStatesAndRegions_always_external
			);
			break;
		case STextKeywordsInStatesAndRegions_always_operation :
			result = (sc_boolean) (handle->stateConfVector[15] == STextKeywordsInStatesAndRegions_always_operation
			);
			break;
		case STextKeywordsInStatesAndRegions_oncycle_default :
			result = (sc_boolean) (handle->stateConfVector[16] == STextKeywordsInStatesAndRegions_oncycle_default
			);
			break;
		case STextKeywordsInStatesAndRegions_oncycle_else :
			result = (sc_boolean) (handle->stateConfVector[16] == STextKeywordsInStatesAndRegions_oncycle_else
			);
			break;
		case STextKeywordsInStatesAndRegions_raise_entry :
			result = (sc_boolean) (handle->stateConfVector[17] == STextKeywordsInStatesAndRegions_raise_entry
			);
			break;
		case STextKeywordsInStatesAndRegions_raise_exit :
			result = (sc_boolean) (handle->stateConfVector[17] == STextKeywordsInStatesAndRegions_raise_exit
			);
			break;
		case STextKeywordsInStatesAndRegions_valueof_always :
			result = (sc_boolean) (handle->stateConfVector[18] == STextKeywordsInStatesAndRegions_valueof_always
			);
			break;
		case STextKeywordsInStatesAndRegions_valueof_oncycle :
			result = (sc_boolean) (handle->stateConfVector[18] == STextKeywordsInStatesAndRegions_valueof_oncycle
			);
			break;
		case STextKeywordsInStatesAndRegions_active_raise :
			result = (sc_boolean) (handle->stateConfVector[19] == STextKeywordsInStatesAndRegions_active_raise
			);
			break;
		case STextKeywordsInStatesAndRegions_active_valueof :
			result = (sc_boolean) (handle->stateConfVector[19] == STextKeywordsInStatesAndRegions_active_valueof
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void sTextKeywordsInStatesAndRegionsIface_raise_e1(STextKeywordsInStatesAndRegions* handle)
{
	handle->iface.e1_raised = bool_true;
}
void sTextKeywordsInStatesAndRegionsIface_raise_e2(STextKeywordsInStatesAndRegions* handle)
{
	handle->iface.e2_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean sTextKeywordsInStatesAndRegions_check_operation_interface_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_default_namespace))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_namespace_event_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_operation_internal))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_local_in_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_namespace_local))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_interface_var_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_local_out))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_internal_external_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_interface_readonly))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_event_default_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_internal_operation))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_in_entry_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_event_else))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_out_always_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_in_exit))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_var_raise_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_out_oncycle))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_readonly_active_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_var_valueof))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_external_interface_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_readonly_namespace))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_else_event_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_external_internal))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_entry_in_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_else_local))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_exit_var_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_entry_out))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_always_external_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_exit_readonly))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_oncycle_default_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_always_operation))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_raise_entry_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_oncycle_else))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_valueof_always_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e2_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_raise_exit))) ? bool_true : bool_false;
}

static sc_boolean sTextKeywordsInStatesAndRegions_check_active_raise_tr0_tr0(const STextKeywordsInStatesAndRegions* handle)
{
	return ((handle->iface.e1_raised) && (sTextKeywordsInStatesAndRegions_isStateActive(handle, STextKeywordsInStatesAndRegions_valueof_oncycle))) ? bool_true : bool_false;
}

static void sTextKeywordsInStatesAndRegions_effect_operation_interface_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_operation_interface(handle);
	sTextKeywordsInStatesAndRegions_enseq_operation_internal_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_namespace_event_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_namespace_event(handle);
	sTextKeywordsInStatesAndRegions_enseq_namespace_local_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_local_in_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_local_in(handle);
	sTextKeywordsInStatesAndRegions_enseq_local_out_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_interface_var_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_interface_var(handle);
	sTextKeywordsInStatesAndRegions_enseq_interface_readonly_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_internal_external_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_internal_external(handle);
	sTextKeywordsInStatesAndRegions_enseq_internal_operation_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_event_default_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_event_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_event_else_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_in_entry_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_in_entry(handle);
	sTextKeywordsInStatesAndRegions_enseq_in_exit_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_out_always_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_out_always(handle);
	sTextKeywordsInStatesAndRegions_enseq_out_oncycle_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_var_raise_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_var_raise(handle);
	sTextKeywordsInStatesAndRegions_enseq_var_valueof_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_readonly_active_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_readonly_active(handle);
	sTextKeywordsInStatesAndRegions_enseq_readonly_namespace_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_external_interface_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_external_interface(handle);
	sTextKeywordsInStatesAndRegions_enseq_external_internal_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_else_event_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_else_event(handle);
	sTextKeywordsInStatesAndRegions_enseq_else_local_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_entry_in_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_entry_in(handle);
	sTextKeywordsInStatesAndRegions_enseq_entry_out_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_exit_var_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_exit_var(handle);
	sTextKeywordsInStatesAndRegions_enseq_exit_readonly_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_always_external_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_always_external(handle);
	sTextKeywordsInStatesAndRegions_enseq_always_operation_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_oncycle_default_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_oncycle_default(handle);
	sTextKeywordsInStatesAndRegions_enseq_oncycle_else_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_raise_entry_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_raise_entry(handle);
	sTextKeywordsInStatesAndRegions_enseq_raise_exit_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_valueof_always_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_valueof_always(handle);
	sTextKeywordsInStatesAndRegions_enseq_valueof_oncycle_default(handle);
}

static void sTextKeywordsInStatesAndRegions_effect_active_raise_tr0(STextKeywordsInStatesAndRegions* handle)
{
	sTextKeywordsInStatesAndRegions_exseq_active_raise(handle);
	sTextKeywordsInStatesAndRegions_enseq_active_valueof_default(handle);
}

/* 'default' enter sequence for state namespace */
static void sTextKeywordsInStatesAndRegions_enseq_default_namespace_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state namespace */
	handle->stateConfVector[0] = STextKeywordsInStatesAndRegions_default_namespace;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state interface */
static void sTextKeywordsInStatesAndRegions_enseq_operation_interface_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state interface */
	handle->stateConfVector[1] = STextKeywordsInStatesAndRegions_operation_interface;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state internal */
static void sTextKeywordsInStatesAndRegions_enseq_operation_internal_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state internal */
	handle->stateConfVector[1] = STextKeywordsInStatesAndRegions_operation_internal;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state event */
static void sTextKeywordsInStatesAndRegions_enseq_namespace_event_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state event */
	handle->stateConfVector[2] = STextKeywordsInStatesAndRegions_namespace_event;
	handle->stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state local */
static void sTextKeywordsInStatesAndRegions_enseq_namespace_local_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state local */
	handle->stateConfVector[2] = STextKeywordsInStatesAndRegions_namespace_local;
	handle->stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state in */
static void sTextKeywordsInStatesAndRegions_enseq_local_in_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state in */
	handle->stateConfVector[3] = STextKeywordsInStatesAndRegions_local_in;
	handle->stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state out */
static void sTextKeywordsInStatesAndRegions_enseq_local_out_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state out */
	handle->stateConfVector[3] = STextKeywordsInStatesAndRegions_local_out;
	handle->stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state var */
static void sTextKeywordsInStatesAndRegions_enseq_interface_var_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state var */
	handle->stateConfVector[4] = STextKeywordsInStatesAndRegions_interface_var;
	handle->stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state readonly */
static void sTextKeywordsInStatesAndRegions_enseq_interface_readonly_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state readonly */
	handle->stateConfVector[4] = STextKeywordsInStatesAndRegions_interface_readonly;
	handle->stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state external */
static void sTextKeywordsInStatesAndRegions_enseq_internal_external_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state external */
	handle->stateConfVector[5] = STextKeywordsInStatesAndRegions_internal_external;
	handle->stateConfVectorPosition = 5;
}

/* 'default' enter sequence for state operation */
static void sTextKeywordsInStatesAndRegions_enseq_internal_operation_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state operation */
	handle->stateConfVector[5] = STextKeywordsInStatesAndRegions_internal_operation;
	handle->stateConfVectorPosition = 5;
}

/* 'default' enter sequence for state default */
static void sTextKeywordsInStatesAndRegions_enseq_event_default_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state default */
	handle->stateConfVector[6] = STextKeywordsInStatesAndRegions_event_default;
	handle->stateConfVectorPosition = 6;
}

/* 'default' enter sequence for state else */
static void sTextKeywordsInStatesAndRegions_enseq_event_else_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state else */
	handle->stateConfVector[6] = STextKeywordsInStatesAndRegions_event_else;
	handle->stateConfVectorPosition = 6;
}

/* 'default' enter sequence for state entry */
static void sTextKeywordsInStatesAndRegions_enseq_in_entry_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state entry */
	handle->stateConfVector[7] = STextKeywordsInStatesAndRegions_in_entry;
	handle->stateConfVectorPosition = 7;
}

/* 'default' enter sequence for state exit */
static void sTextKeywordsInStatesAndRegions_enseq_in_exit_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state exit */
	handle->stateConfVector[7] = STextKeywordsInStatesAndRegions_in_exit;
	handle->stateConfVectorPosition = 7;
}

/* 'default' enter sequence for state always */
static void sTextKeywordsInStatesAndRegions_enseq_out_always_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state always */
	handle->stateConfVector[8] = STextKeywordsInStatesAndRegions_out_always;
	handle->stateConfVectorPosition = 8;
}

/* 'default' enter sequence for state oncycle */
static void sTextKeywordsInStatesAndRegions_enseq_out_oncycle_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state oncycle */
	handle->stateConfVector[8] = STextKeywordsInStatesAndRegions_out_oncycle;
	handle->stateConfVectorPosition = 8;
}

/* 'default' enter sequence for state raise */
static void sTextKeywordsInStatesAndRegions_enseq_var_raise_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state raise */
	handle->stateConfVector[9] = STextKeywordsInStatesAndRegions_var_raise;
	handle->stateConfVectorPosition = 9;
}

/* 'default' enter sequence for state valueof */
static void sTextKeywordsInStatesAndRegions_enseq_var_valueof_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state valueof */
	handle->stateConfVector[9] = STextKeywordsInStatesAndRegions_var_valueof;
	handle->stateConfVectorPosition = 9;
}

/* 'default' enter sequence for state active */
static void sTextKeywordsInStatesAndRegions_enseq_readonly_active_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state active */
	handle->stateConfVector[10] = STextKeywordsInStatesAndRegions_readonly_active;
	handle->stateConfVectorPosition = 10;
}

/* 'default' enter sequence for state namespace */
static void sTextKeywordsInStatesAndRegions_enseq_readonly_namespace_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state namespace */
	handle->stateConfVector[10] = STextKeywordsInStatesAndRegions_readonly_namespace;
	handle->stateConfVectorPosition = 10;
}

/* 'default' enter sequence for state interface */
static void sTextKeywordsInStatesAndRegions_enseq_external_interface_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state interface */
	handle->stateConfVector[11] = STextKeywordsInStatesAndRegions_external_interface;
	handle->stateConfVectorPosition = 11;
}

/* 'default' enter sequence for state internal */
static void sTextKeywordsInStatesAndRegions_enseq_external_internal_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state internal */
	handle->stateConfVector[11] = STextKeywordsInStatesAndRegions_external_internal;
	handle->stateConfVectorPosition = 11;
}

/* 'default' enter sequence for state event */
static void sTextKeywordsInStatesAndRegions_enseq_else_event_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state event */
	handle->stateConfVector[12] = STextKeywordsInStatesAndRegions_else_event;
	handle->stateConfVectorPosition = 12;
}

/* 'default' enter sequence for state local */
static void sTextKeywordsInStatesAndRegions_enseq_else_local_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state local */
	handle->stateConfVector[12] = STextKeywordsInStatesAndRegions_else_local;
	handle->stateConfVectorPosition = 12;
}

/* 'default' enter sequence for state in */
static void sTextKeywordsInStatesAndRegions_enseq_entry_in_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state in */
	handle->stateConfVector[13] = STextKeywordsInStatesAndRegions_entry_in;
	handle->stateConfVectorPosition = 13;
}

/* 'default' enter sequence for state out */
static void sTextKeywordsInStatesAndRegions_enseq_entry_out_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state out */
	handle->stateConfVector[13] = STextKeywordsInStatesAndRegions_entry_out;
	handle->stateConfVectorPosition = 13;
}

/* 'default' enter sequence for state var */
static void sTextKeywordsInStatesAndRegions_enseq_exit_var_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state var */
	handle->stateConfVector[14] = STextKeywordsInStatesAndRegions_exit_var;
	handle->stateConfVectorPosition = 14;
}

/* 'default' enter sequence for state readonly */
static void sTextKeywordsInStatesAndRegions_enseq_exit_readonly_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state readonly */
	handle->stateConfVector[14] = STextKeywordsInStatesAndRegions_exit_readonly;
	handle->stateConfVectorPosition = 14;
}

/* 'default' enter sequence for state external */
static void sTextKeywordsInStatesAndRegions_enseq_always_external_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state external */
	handle->stateConfVector[15] = STextKeywordsInStatesAndRegions_always_external;
	handle->stateConfVectorPosition = 15;
}

/* 'default' enter sequence for state operation */
static void sTextKeywordsInStatesAndRegions_enseq_always_operation_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state operation */
	handle->stateConfVector[15] = STextKeywordsInStatesAndRegions_always_operation;
	handle->stateConfVectorPosition = 15;
}

/* 'default' enter sequence for state default */
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_default_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state default */
	handle->stateConfVector[16] = STextKeywordsInStatesAndRegions_oncycle_default;
	handle->stateConfVectorPosition = 16;
}

/* 'default' enter sequence for state else */
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_else_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state else */
	handle->stateConfVector[16] = STextKeywordsInStatesAndRegions_oncycle_else;
	handle->stateConfVectorPosition = 16;
}

/* 'default' enter sequence for state entry */
static void sTextKeywordsInStatesAndRegions_enseq_raise_entry_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state entry */
	handle->stateConfVector[17] = STextKeywordsInStatesAndRegions_raise_entry;
	handle->stateConfVectorPosition = 17;
}

/* 'default' enter sequence for state exit */
static void sTextKeywordsInStatesAndRegions_enseq_raise_exit_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state exit */
	handle->stateConfVector[17] = STextKeywordsInStatesAndRegions_raise_exit;
	handle->stateConfVectorPosition = 17;
}

/* 'default' enter sequence for state always */
static void sTextKeywordsInStatesAndRegions_enseq_valueof_always_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state always */
	handle->stateConfVector[18] = STextKeywordsInStatesAndRegions_valueof_always;
	handle->stateConfVectorPosition = 18;
}

/* 'default' enter sequence for state oncycle */
static void sTextKeywordsInStatesAndRegions_enseq_valueof_oncycle_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state oncycle */
	handle->stateConfVector[18] = STextKeywordsInStatesAndRegions_valueof_oncycle;
	handle->stateConfVectorPosition = 18;
}

/* 'default' enter sequence for state raise */
static void sTextKeywordsInStatesAndRegions_enseq_active_raise_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state raise */
	handle->stateConfVector[19] = STextKeywordsInStatesAndRegions_active_raise;
	handle->stateConfVectorPosition = 19;
}

/* 'default' enter sequence for state valueof */
static void sTextKeywordsInStatesAndRegions_enseq_active_valueof_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for state valueof */
	handle->stateConfVector[19] = STextKeywordsInStatesAndRegions_active_valueof;
	handle->stateConfVectorPosition = 19;
}

/* 'default' enter sequence for region default */
static void sTextKeywordsInStatesAndRegions_enseq_default_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region default */
	sTextKeywordsInStatesAndRegions_react_default__entry_Default(handle);
}

/* 'default' enter sequence for region operation */
static void sTextKeywordsInStatesAndRegions_enseq_operation_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region operation */
	sTextKeywordsInStatesAndRegions_react_operation__entry_Default(handle);
}

/* 'default' enter sequence for region namespace */
static void sTextKeywordsInStatesAndRegions_enseq_namespace_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region namespace */
	sTextKeywordsInStatesAndRegions_react_namespace__entry_Default(handle);
}

/* 'default' enter sequence for region local */
static void sTextKeywordsInStatesAndRegions_enseq_local_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region local */
	sTextKeywordsInStatesAndRegions_react_local__entry_Default(handle);
}

/* 'default' enter sequence for region interface */
static void sTextKeywordsInStatesAndRegions_enseq_interface_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region interface */
	sTextKeywordsInStatesAndRegions_react_interface__entry_Default(handle);
}

/* 'default' enter sequence for region internal */
static void sTextKeywordsInStatesAndRegions_enseq_internal_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region internal */
	sTextKeywordsInStatesAndRegions_react_internal__entry_Default(handle);
}

/* 'default' enter sequence for region event */
static void sTextKeywordsInStatesAndRegions_enseq_event_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region event */
	sTextKeywordsInStatesAndRegions_react_event__entry_Default(handle);
}

/* 'default' enter sequence for region in */
static void sTextKeywordsInStatesAndRegions_enseq_in_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region in */
	sTextKeywordsInStatesAndRegions_react_in__entry_Default(handle);
}

/* 'default' enter sequence for region out */
static void sTextKeywordsInStatesAndRegions_enseq_out_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region out */
	sTextKeywordsInStatesAndRegions_react_out__entry_Default(handle);
}

/* 'default' enter sequence for region var */
static void sTextKeywordsInStatesAndRegions_enseq_var_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region var */
	sTextKeywordsInStatesAndRegions_react_var__entry_Default(handle);
}

/* 'default' enter sequence for region readonly */
static void sTextKeywordsInStatesAndRegions_enseq_readonly_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region readonly */
	sTextKeywordsInStatesAndRegions_react_readonly__entry_Default(handle);
}

/* 'default' enter sequence for region external */
static void sTextKeywordsInStatesAndRegions_enseq_external_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region external */
	sTextKeywordsInStatesAndRegions_react_external__entry_Default(handle);
}

/* 'default' enter sequence for region else */
static void sTextKeywordsInStatesAndRegions_enseq_else_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region else */
	sTextKeywordsInStatesAndRegions_react_else__entry_Default(handle);
}

/* 'default' enter sequence for region entry */
static void sTextKeywordsInStatesAndRegions_enseq_entry_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region entry */
	sTextKeywordsInStatesAndRegions_react_entry__entry_Default(handle);
}

/* 'default' enter sequence for region exit */
static void sTextKeywordsInStatesAndRegions_enseq_exit_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region exit */
	sTextKeywordsInStatesAndRegions_react_exit__entry_Default(handle);
}

/* 'default' enter sequence for region always */
static void sTextKeywordsInStatesAndRegions_enseq_always_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region always */
	sTextKeywordsInStatesAndRegions_react_always__entry_Default(handle);
}

/* 'default' enter sequence for region oncycle */
static void sTextKeywordsInStatesAndRegions_enseq_oncycle_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region oncycle */
	sTextKeywordsInStatesAndRegions_react_oncycle__entry_Default(handle);
}

/* 'default' enter sequence for region raise */
static void sTextKeywordsInStatesAndRegions_enseq_raise_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region raise */
	sTextKeywordsInStatesAndRegions_react_raise__entry_Default(handle);
}

/* 'default' enter sequence for region valueof */
static void sTextKeywordsInStatesAndRegions_enseq_valueof_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region valueof */
	sTextKeywordsInStatesAndRegions_react_valueof__entry_Default(handle);
}

/* 'default' enter sequence for region active */
static void sTextKeywordsInStatesAndRegions_enseq_active_default(STextKeywordsInStatesAndRegions* handle)
{
	/* 'default' enter sequence for region active */
	sTextKeywordsInStatesAndRegions_react_active__entry_Default(handle);
}

/* Default exit sequence for state namespace */
static void sTextKeywordsInStatesAndRegions_exseq_default_namespace(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state namespace */
	handle->stateConfVector[0] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state interface */
static void sTextKeywordsInStatesAndRegions_exseq_operation_interface(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state interface */
	handle->stateConfVector[1] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state internal */
static void sTextKeywordsInStatesAndRegions_exseq_operation_internal(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state internal */
	handle->stateConfVector[1] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state event */
static void sTextKeywordsInStatesAndRegions_exseq_namespace_event(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state event */
	handle->stateConfVector[2] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for state local */
static void sTextKeywordsInStatesAndRegions_exseq_namespace_local(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state local */
	handle->stateConfVector[2] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for state in */
static void sTextKeywordsInStatesAndRegions_exseq_local_in(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state in */
	handle->stateConfVector[3] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 3;
}

/* Default exit sequence for state out */
static void sTextKeywordsInStatesAndRegions_exseq_local_out(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state out */
	handle->stateConfVector[3] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 3;
}

/* Default exit sequence for state var */
static void sTextKeywordsInStatesAndRegions_exseq_interface_var(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state var */
	handle->stateConfVector[4] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 4;
}

/* Default exit sequence for state readonly */
static void sTextKeywordsInStatesAndRegions_exseq_interface_readonly(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state readonly */
	handle->stateConfVector[4] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 4;
}

/* Default exit sequence for state external */
static void sTextKeywordsInStatesAndRegions_exseq_internal_external(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state external */
	handle->stateConfVector[5] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 5;
}

/* Default exit sequence for state operation */
static void sTextKeywordsInStatesAndRegions_exseq_internal_operation(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state operation */
	handle->stateConfVector[5] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 5;
}

/* Default exit sequence for state default */
static void sTextKeywordsInStatesAndRegions_exseq_event_default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state default */
	handle->stateConfVector[6] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 6;
}

/* Default exit sequence for state else */
static void sTextKeywordsInStatesAndRegions_exseq_event_else(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state else */
	handle->stateConfVector[6] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 6;
}

/* Default exit sequence for state entry */
static void sTextKeywordsInStatesAndRegions_exseq_in_entry(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state entry */
	handle->stateConfVector[7] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 7;
}

/* Default exit sequence for state exit */
static void sTextKeywordsInStatesAndRegions_exseq_in_exit(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state exit */
	handle->stateConfVector[7] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 7;
}

/* Default exit sequence for state always */
static void sTextKeywordsInStatesAndRegions_exseq_out_always(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state always */
	handle->stateConfVector[8] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 8;
}

/* Default exit sequence for state oncycle */
static void sTextKeywordsInStatesAndRegions_exseq_out_oncycle(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state oncycle */
	handle->stateConfVector[8] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 8;
}

/* Default exit sequence for state raise */
static void sTextKeywordsInStatesAndRegions_exseq_var_raise(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state raise */
	handle->stateConfVector[9] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 9;
}

/* Default exit sequence for state valueof */
static void sTextKeywordsInStatesAndRegions_exseq_var_valueof(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state valueof */
	handle->stateConfVector[9] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 9;
}

/* Default exit sequence for state active */
static void sTextKeywordsInStatesAndRegions_exseq_readonly_active(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state active */
	handle->stateConfVector[10] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 10;
}

/* Default exit sequence for state namespace */
static void sTextKeywordsInStatesAndRegions_exseq_readonly_namespace(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state namespace */
	handle->stateConfVector[10] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 10;
}

/* Default exit sequence for state interface */
static void sTextKeywordsInStatesAndRegions_exseq_external_interface(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state interface */
	handle->stateConfVector[11] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 11;
}

/* Default exit sequence for state internal */
static void sTextKeywordsInStatesAndRegions_exseq_external_internal(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state internal */
	handle->stateConfVector[11] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 11;
}

/* Default exit sequence for state event */
static void sTextKeywordsInStatesAndRegions_exseq_else_event(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state event */
	handle->stateConfVector[12] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 12;
}

/* Default exit sequence for state local */
static void sTextKeywordsInStatesAndRegions_exseq_else_local(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state local */
	handle->stateConfVector[12] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 12;
}

/* Default exit sequence for state in */
static void sTextKeywordsInStatesAndRegions_exseq_entry_in(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state in */
	handle->stateConfVector[13] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 13;
}

/* Default exit sequence for state out */
static void sTextKeywordsInStatesAndRegions_exseq_entry_out(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state out */
	handle->stateConfVector[13] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 13;
}

/* Default exit sequence for state var */
static void sTextKeywordsInStatesAndRegions_exseq_exit_var(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state var */
	handle->stateConfVector[14] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 14;
}

/* Default exit sequence for state readonly */
static void sTextKeywordsInStatesAndRegions_exseq_exit_readonly(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state readonly */
	handle->stateConfVector[14] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 14;
}

/* Default exit sequence for state external */
static void sTextKeywordsInStatesAndRegions_exseq_always_external(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state external */
	handle->stateConfVector[15] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 15;
}

/* Default exit sequence for state operation */
static void sTextKeywordsInStatesAndRegions_exseq_always_operation(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state operation */
	handle->stateConfVector[15] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 15;
}

/* Default exit sequence for state default */
static void sTextKeywordsInStatesAndRegions_exseq_oncycle_default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state default */
	handle->stateConfVector[16] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 16;
}

/* Default exit sequence for state else */
static void sTextKeywordsInStatesAndRegions_exseq_oncycle_else(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state else */
	handle->stateConfVector[16] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 16;
}

/* Default exit sequence for state entry */
static void sTextKeywordsInStatesAndRegions_exseq_raise_entry(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state entry */
	handle->stateConfVector[17] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 17;
}

/* Default exit sequence for state exit */
static void sTextKeywordsInStatesAndRegions_exseq_raise_exit(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state exit */
	handle->stateConfVector[17] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 17;
}

/* Default exit sequence for state always */
static void sTextKeywordsInStatesAndRegions_exseq_valueof_always(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state always */
	handle->stateConfVector[18] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 18;
}

/* Default exit sequence for state oncycle */
static void sTextKeywordsInStatesAndRegions_exseq_valueof_oncycle(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state oncycle */
	handle->stateConfVector[18] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 18;
}

/* Default exit sequence for state raise */
static void sTextKeywordsInStatesAndRegions_exseq_active_raise(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state raise */
	handle->stateConfVector[19] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 19;
}

/* Default exit sequence for state valueof */
static void sTextKeywordsInStatesAndRegions_exseq_active_valueof(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for state valueof */
	handle->stateConfVector[19] = STextKeywordsInStatesAndRegions_last_state;
	handle->stateConfVectorPosition = 19;
}

/* Default exit sequence for region default */
static void sTextKeywordsInStatesAndRegions_exseq_default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region default */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.default) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case STextKeywordsInStatesAndRegions_default_namespace :
		{
			sTextKeywordsInStatesAndRegions_exseq_default_namespace(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region operation */
static void sTextKeywordsInStatesAndRegions_exseq_operation(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region operation */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.operation) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case STextKeywordsInStatesAndRegions_operation_interface :
		{
			sTextKeywordsInStatesAndRegions_exseq_operation_interface(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_operation_internal :
		{
			sTextKeywordsInStatesAndRegions_exseq_operation_internal(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region namespace */
static void sTextKeywordsInStatesAndRegions_exseq_namespace(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region namespace */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.namespace) at position 2... */
	switch(handle->stateConfVector[ 2 ])
	{
		case STextKeywordsInStatesAndRegions_namespace_event :
		{
			sTextKeywordsInStatesAndRegions_exseq_namespace_event(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_namespace_local :
		{
			sTextKeywordsInStatesAndRegions_exseq_namespace_local(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region local */
static void sTextKeywordsInStatesAndRegions_exseq_local(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region local */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.local) at position 3... */
	switch(handle->stateConfVector[ 3 ])
	{
		case STextKeywordsInStatesAndRegions_local_in :
		{
			sTextKeywordsInStatesAndRegions_exseq_local_in(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_local_out :
		{
			sTextKeywordsInStatesAndRegions_exseq_local_out(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region interface */
static void sTextKeywordsInStatesAndRegions_exseq_interface(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region interface */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.interface) at position 4... */
	switch(handle->stateConfVector[ 4 ])
	{
		case STextKeywordsInStatesAndRegions_interface_var :
		{
			sTextKeywordsInStatesAndRegions_exseq_interface_var(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_interface_readonly :
		{
			sTextKeywordsInStatesAndRegions_exseq_interface_readonly(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region internal */
static void sTextKeywordsInStatesAndRegions_exseq_internal(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region internal */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.internal) at position 5... */
	switch(handle->stateConfVector[ 5 ])
	{
		case STextKeywordsInStatesAndRegions_internal_external :
		{
			sTextKeywordsInStatesAndRegions_exseq_internal_external(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_internal_operation :
		{
			sTextKeywordsInStatesAndRegions_exseq_internal_operation(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region event */
static void sTextKeywordsInStatesAndRegions_exseq_event(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region event */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.event) at position 6... */
	switch(handle->stateConfVector[ 6 ])
	{
		case STextKeywordsInStatesAndRegions_event_default :
		{
			sTextKeywordsInStatesAndRegions_exseq_event_default(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_event_else :
		{
			sTextKeywordsInStatesAndRegions_exseq_event_else(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region in */
static void sTextKeywordsInStatesAndRegions_exseq_in(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region in */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.in) at position 7... */
	switch(handle->stateConfVector[ 7 ])
	{
		case STextKeywordsInStatesAndRegions_in_entry :
		{
			sTextKeywordsInStatesAndRegions_exseq_in_entry(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_in_exit :
		{
			sTextKeywordsInStatesAndRegions_exseq_in_exit(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region out */
static void sTextKeywordsInStatesAndRegions_exseq_out(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region out */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.out) at position 8... */
	switch(handle->stateConfVector[ 8 ])
	{
		case STextKeywordsInStatesAndRegions_out_always :
		{
			sTextKeywordsInStatesAndRegions_exseq_out_always(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_out_oncycle :
		{
			sTextKeywordsInStatesAndRegions_exseq_out_oncycle(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region var */
static void sTextKeywordsInStatesAndRegions_exseq_var(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region var */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.var) at position 9... */
	switch(handle->stateConfVector[ 9 ])
	{
		case STextKeywordsInStatesAndRegions_var_raise :
		{
			sTextKeywordsInStatesAndRegions_exseq_var_raise(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_var_valueof :
		{
			sTextKeywordsInStatesAndRegions_exseq_var_valueof(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region readonly */
static void sTextKeywordsInStatesAndRegions_exseq_readonly(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region readonly */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.readonly) at position 10... */
	switch(handle->stateConfVector[ 10 ])
	{
		case STextKeywordsInStatesAndRegions_readonly_active :
		{
			sTextKeywordsInStatesAndRegions_exseq_readonly_active(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_readonly_namespace :
		{
			sTextKeywordsInStatesAndRegions_exseq_readonly_namespace(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region external */
static void sTextKeywordsInStatesAndRegions_exseq_external(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region external */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.external) at position 11... */
	switch(handle->stateConfVector[ 11 ])
	{
		case STextKeywordsInStatesAndRegions_external_interface :
		{
			sTextKeywordsInStatesAndRegions_exseq_external_interface(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_external_internal :
		{
			sTextKeywordsInStatesAndRegions_exseq_external_internal(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region else */
static void sTextKeywordsInStatesAndRegions_exseq_else(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region else */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.else) at position 12... */
	switch(handle->stateConfVector[ 12 ])
	{
		case STextKeywordsInStatesAndRegions_else_event :
		{
			sTextKeywordsInStatesAndRegions_exseq_else_event(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_else_local :
		{
			sTextKeywordsInStatesAndRegions_exseq_else_local(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region entry */
static void sTextKeywordsInStatesAndRegions_exseq_entry(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region entry */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.entry) at position 13... */
	switch(handle->stateConfVector[ 13 ])
	{
		case STextKeywordsInStatesAndRegions_entry_in :
		{
			sTextKeywordsInStatesAndRegions_exseq_entry_in(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_entry_out :
		{
			sTextKeywordsInStatesAndRegions_exseq_entry_out(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region exit */
static void sTextKeywordsInStatesAndRegions_exseq_exit(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region exit */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.exit) at position 14... */
	switch(handle->stateConfVector[ 14 ])
	{
		case STextKeywordsInStatesAndRegions_exit_var :
		{
			sTextKeywordsInStatesAndRegions_exseq_exit_var(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_exit_readonly :
		{
			sTextKeywordsInStatesAndRegions_exseq_exit_readonly(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region always */
static void sTextKeywordsInStatesAndRegions_exseq_always(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region always */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.always) at position 15... */
	switch(handle->stateConfVector[ 15 ])
	{
		case STextKeywordsInStatesAndRegions_always_external :
		{
			sTextKeywordsInStatesAndRegions_exseq_always_external(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_always_operation :
		{
			sTextKeywordsInStatesAndRegions_exseq_always_operation(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region oncycle */
static void sTextKeywordsInStatesAndRegions_exseq_oncycle(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region oncycle */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.oncycle) at position 16... */
	switch(handle->stateConfVector[ 16 ])
	{
		case STextKeywordsInStatesAndRegions_oncycle_default :
		{
			sTextKeywordsInStatesAndRegions_exseq_oncycle_default(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_oncycle_else :
		{
			sTextKeywordsInStatesAndRegions_exseq_oncycle_else(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region raise */
static void sTextKeywordsInStatesAndRegions_exseq_raise(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region raise */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.raise) at position 17... */
	switch(handle->stateConfVector[ 17 ])
	{
		case STextKeywordsInStatesAndRegions_raise_entry :
		{
			sTextKeywordsInStatesAndRegions_exseq_raise_entry(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_raise_exit :
		{
			sTextKeywordsInStatesAndRegions_exseq_raise_exit(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region valueof */
static void sTextKeywordsInStatesAndRegions_exseq_valueof(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region valueof */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.valueof) at position 18... */
	switch(handle->stateConfVector[ 18 ])
	{
		case STextKeywordsInStatesAndRegions_valueof_always :
		{
			sTextKeywordsInStatesAndRegions_exseq_valueof_always(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_valueof_oncycle :
		{
			sTextKeywordsInStatesAndRegions_exseq_valueof_oncycle(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region active */
static void sTextKeywordsInStatesAndRegions_exseq_active(STextKeywordsInStatesAndRegions* handle)
{
	/* Default exit sequence for region active */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.active) at position 19... */
	switch(handle->stateConfVector[ 19 ])
	{
		case STextKeywordsInStatesAndRegions_active_raise :
		{
			sTextKeywordsInStatesAndRegions_exseq_active_raise(handle);
			break;
		}
		case STextKeywordsInStatesAndRegions_active_valueof :
		{
			sTextKeywordsInStatesAndRegions_exseq_active_valueof(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state namespace. */
static void sTextKeywordsInStatesAndRegions_react_default_namespace(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state namespace. */
}

/* The reactions of state interface. */
static void sTextKeywordsInStatesAndRegions_react_operation_interface(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state interface. */
	if (sTextKeywordsInStatesAndRegions_check_operation_interface_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_operation_interface_tr0(handle);
	} 
}

/* The reactions of state internal. */
static void sTextKeywordsInStatesAndRegions_react_operation_internal(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state event. */
static void sTextKeywordsInStatesAndRegions_react_namespace_event(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state event. */
	if (sTextKeywordsInStatesAndRegions_check_namespace_event_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_namespace_event_tr0(handle);
	} 
}

/* The reactions of state local. */
static void sTextKeywordsInStatesAndRegions_react_namespace_local(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state in. */
static void sTextKeywordsInStatesAndRegions_react_local_in(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state in. */
	if (sTextKeywordsInStatesAndRegions_check_local_in_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_local_in_tr0(handle);
	} 
}

/* The reactions of state out. */
static void sTextKeywordsInStatesAndRegions_react_local_out(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state var. */
static void sTextKeywordsInStatesAndRegions_react_interface_var(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state var. */
	if (sTextKeywordsInStatesAndRegions_check_interface_var_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_interface_var_tr0(handle);
	} 
}

/* The reactions of state readonly. */
static void sTextKeywordsInStatesAndRegions_react_interface_readonly(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state external. */
static void sTextKeywordsInStatesAndRegions_react_internal_external(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state external. */
	if (sTextKeywordsInStatesAndRegions_check_internal_external_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_internal_external_tr0(handle);
	} 
}

/* The reactions of state operation. */
static void sTextKeywordsInStatesAndRegions_react_internal_operation(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state default. */
static void sTextKeywordsInStatesAndRegions_react_event_default(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state default. */
	if (sTextKeywordsInStatesAndRegions_check_event_default_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_event_default_tr0(handle);
	} 
}

/* The reactions of state else. */
static void sTextKeywordsInStatesAndRegions_react_event_else(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state entry. */
static void sTextKeywordsInStatesAndRegions_react_in_entry(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state entry. */
	if (sTextKeywordsInStatesAndRegions_check_in_entry_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_in_entry_tr0(handle);
	} 
}

/* The reactions of state exit. */
static void sTextKeywordsInStatesAndRegions_react_in_exit(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state always. */
static void sTextKeywordsInStatesAndRegions_react_out_always(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state always. */
	if (sTextKeywordsInStatesAndRegions_check_out_always_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_out_always_tr0(handle);
	} 
}

/* The reactions of state oncycle. */
static void sTextKeywordsInStatesAndRegions_react_out_oncycle(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state raise. */
static void sTextKeywordsInStatesAndRegions_react_var_raise(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state raise. */
	if (sTextKeywordsInStatesAndRegions_check_var_raise_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_var_raise_tr0(handle);
	} 
}

/* The reactions of state valueof. */
static void sTextKeywordsInStatesAndRegions_react_var_valueof(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state active. */
static void sTextKeywordsInStatesAndRegions_react_readonly_active(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state active. */
	if (sTextKeywordsInStatesAndRegions_check_readonly_active_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_readonly_active_tr0(handle);
	} 
}

/* The reactions of state namespace. */
static void sTextKeywordsInStatesAndRegions_react_readonly_namespace(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state interface. */
static void sTextKeywordsInStatesAndRegions_react_external_interface(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state interface. */
	if (sTextKeywordsInStatesAndRegions_check_external_interface_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_external_interface_tr0(handle);
	} 
}

/* The reactions of state internal. */
static void sTextKeywordsInStatesAndRegions_react_external_internal(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state event. */
static void sTextKeywordsInStatesAndRegions_react_else_event(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state event. */
	if (sTextKeywordsInStatesAndRegions_check_else_event_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_else_event_tr0(handle);
	} 
}

/* The reactions of state local. */
static void sTextKeywordsInStatesAndRegions_react_else_local(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state in. */
static void sTextKeywordsInStatesAndRegions_react_entry_in(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state in. */
	if (sTextKeywordsInStatesAndRegions_check_entry_in_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_entry_in_tr0(handle);
	} 
}

/* The reactions of state out. */
static void sTextKeywordsInStatesAndRegions_react_entry_out(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state var. */
static void sTextKeywordsInStatesAndRegions_react_exit_var(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state var. */
	if (sTextKeywordsInStatesAndRegions_check_exit_var_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_exit_var_tr0(handle);
	} 
}

/* The reactions of state readonly. */
static void sTextKeywordsInStatesAndRegions_react_exit_readonly(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state external. */
static void sTextKeywordsInStatesAndRegions_react_always_external(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state external. */
	if (sTextKeywordsInStatesAndRegions_check_always_external_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_always_external_tr0(handle);
	} 
}

/* The reactions of state operation. */
static void sTextKeywordsInStatesAndRegions_react_always_operation(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state default. */
static void sTextKeywordsInStatesAndRegions_react_oncycle_default(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state default. */
	if (sTextKeywordsInStatesAndRegions_check_oncycle_default_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_oncycle_default_tr0(handle);
	} 
}

/* The reactions of state else. */
static void sTextKeywordsInStatesAndRegions_react_oncycle_else(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state entry. */
static void sTextKeywordsInStatesAndRegions_react_raise_entry(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state entry. */
	if (sTextKeywordsInStatesAndRegions_check_raise_entry_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_raise_entry_tr0(handle);
	} 
}

/* The reactions of state exit. */
static void sTextKeywordsInStatesAndRegions_react_raise_exit(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state always. */
static void sTextKeywordsInStatesAndRegions_react_valueof_always(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state always. */
	if (sTextKeywordsInStatesAndRegions_check_valueof_always_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_valueof_always_tr0(handle);
	} 
}

/* The reactions of state oncycle. */
static void sTextKeywordsInStatesAndRegions_react_valueof_oncycle(STextKeywordsInStatesAndRegions* handle)
{
}

/* The reactions of state raise. */
static void sTextKeywordsInStatesAndRegions_react_active_raise(STextKeywordsInStatesAndRegions* handle)
{
	/* The reactions of state raise. */
	if (sTextKeywordsInStatesAndRegions_check_active_raise_tr0_tr0(handle) == bool_true)
	{ 
		sTextKeywordsInStatesAndRegions_effect_active_raise_tr0(handle);
	} 
}

/* The reactions of state valueof. */
static void sTextKeywordsInStatesAndRegions_react_active_valueof(STextKeywordsInStatesAndRegions* handle)
{
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_default__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_default_namespace_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_operation__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_operation_interface_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_namespace__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_namespace_event_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_local__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_local_in_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_interface__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_interface_var_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_internal__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_internal_external_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_event__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_event_default_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_in__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_in_entry_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_out__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_out_always_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_var__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_var_raise_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_readonly__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_readonly_active_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_external__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_external_interface_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_else__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_else_event_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_entry__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_entry_in_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_exit__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_exit_var_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_always__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_always_external_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_oncycle__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_oncycle_default_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_raise__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_raise_entry_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_valueof__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_valueof_always_default(handle);
}

/* Default react sequence for initial entry  */
static void sTextKeywordsInStatesAndRegions_react_active__entry_Default(STextKeywordsInStatesAndRegions* handle)
{
	/* Default react sequence for initial entry  */
	sTextKeywordsInStatesAndRegions_enseq_active_raise_default(handle);
}


