#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Clock.h"
#include "ClockRequired.h"

/*! \file Implementation of the state machine 'clock'
*/

// prototypes of all internal functions

static sc_boolean clock_check_lr0(Clock* handle);
static sc_boolean clock_check_lr1(Clock* handle);
static sc_boolean clock_check_lr2(Clock* handle);
static void clock_effect_lr0(Clock* handle);
static void clock_effect_lr1(Clock* handle);
static void clock_effect_lr2(Clock* handle);
static void clock_entryaction(Clock* handle);
static void clock_exitaction(Clock* handle);
static void clock_deepentersequence_main_displays_region0(Clock* handle);
static void clock_deepentersequence_main_displays_region0_regular_beep_test_regular(Clock* handle);
static void clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(Clock* handle);
static void clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(Clock* handle);
static void clock_deepentersequence_main_stopwatch_r1(Clock* handle);
static void clock_deepentersequence_main_stopwatch_r1_display_run_display(Clock* handle);
static void clock_deepentersequence_main_stopwatch_r1_display_run_run(Clock* handle);
static void clock_shallowentersequence_main_settings_r1_alarm_1_r1(Clock* handle);
static void clock_shallowentersequence_main_settings_r1_alarm_2_r1(Clock* handle);
static void clock_shallowentersequence_main_settings_r1_chime_r1(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_sec(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_min(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_hr(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_mode(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_time(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_regular_date(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_beep_test_off(Clock* handle);
static void clock_react_main_displays_region0_regular_beep_test_beep_test_beep(Clock* handle);
static void clock_react_main_displays_region0_wait(Clock* handle);
static void clock_react_main_alarms_beep_r1_alarm_1_beeps(Clock* handle);
static void clock_react_main_alarms_beep_r1_alarm_2_beeps(Clock* handle);
static void clock_react_main_alarms_beep_r1_both_beep(Clock* handle);
static void clock_react_main_stopwatch_r1_zero(Clock* handle);
static void clock_react_main_stopwatch_r1_display_run_display_regular(Clock* handle);
static void clock_react_main_stopwatch_r1_display_run_display_lap(Clock* handle);
static void clock_react_main_stopwatch_r1_display_run_run_on(Clock* handle);
static void clock_react_main_stopwatch_r1_display_run_run_off(Clock* handle);
static void clock_react_main_settings_r1_alarm_1_r1_off(Clock* handle);
static void clock_react_main_settings_r1_alarm_1_r1_on(Clock* handle);
static void clock_react_main_settings_r1_update_1_r1_hr(Clock* handle);
static void clock_react_main_settings_r1_update_1_r1_min(Clock* handle);
static void clock_react_main_settings_r1_update_2_r1_hr(Clock* handle);
static void clock_react_main_settings_r1_update_2_r1_min(Clock* handle);
static void clock_react_main_settings_r1_alarm_2_r1_off(Clock* handle);
static void clock_react_main_settings_r1_alarm_2_r1_on(Clock* handle);
static void clock_react_main_settings_r1_chime_r1_off(Clock* handle);
static void clock_react_main_settings_r1_chime_r1_on(Clock* handle);
static void clock_react_alarm_1_disabled(Clock* handle);
static void clock_react_alarm_1_enabled(Clock* handle);
static void clock_react_alarm_2_disabled(Clock* handle);
static void clock_react_alarm_2_enabled(Clock* handle);
static void clock_react_chime___status_disabled(Clock* handle);
static void clock_react_chime___status_enabled_r1_quiet(Clock* handle);
static void clock_react_chime___status_enabled_r1_beep(Clock* handle);
static void clock_react_light_off(Clock* handle);
static void clock_react_light_on(Clock* handle);
static void clock_react_power_ok(Clock* handle);
static void clock_react_power_blink(Clock* handle);
static void clearInEvents(Clock* handle);
static void clearOutEvents(Clock* handle);


void clock_init(Clock* handle)
{
	int i;

	for (i = 0; i < CLOCK_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = Clock_last_state;
	
	for (i = 0; i < CLOCK_MAX_HISTORY_STATES; ++i)
		handle->historyVector[i] = Clock_last_state;
	
	handle->stateConfVectorPosition = 0;

clearInEvents(handle);
clearOutEvents(handle);

	// TODO: initialize all events ...

	{
		/* Default init sequence for statechart clock */
		handle->ifaceClock.second = 0;
		handle->ifaceClock.minute = 0;
		handle->ifaceClock.hour = 0;
		handle->ifaceClock.time = 0;
		handle->ifaceClock.al1_time = 0;
		handle->ifaceClock.al2_time = 0;
		handle->ifaceStopwatch.time = 0;
		handle->ifaceStopwatch.lap = 0;
		handle->ifaceBattery.max_energy = 1000;
		handle->ifaceBattery.min_energy = 0.05 * handle->ifaceBattery.max_energy;
		handle->ifaceBattery.energy = handle->ifaceBattery.max_energy;
		handle->internal.delta = 0;
	}

}

void clock_enter(Clock* handle)
{
	{
		/* Default enter sequence for statechart clock */
		clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_time_event_0_raised) , 100, bool_true);
		clock_entryaction(handle);
		{
			/* Default enter sequence for region main */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state displays */
					{
						/* Default enter sequence for region  */
						{
							/* Default react sequence for initial entry  */
							{
								/* Default enter sequence for state regular-beep-test */
								{
									/* Default enter sequence for region regular */
									{
										/* Default react sequence for initial entry  */
										{
											/* Default enter sequence for state time */
											handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
											handle->stateConfVectorPosition = 0;
										}
									}
								}
								{
									/* Default enter sequence for region beep-test */
									{
										/* Default react sequence for initial entry  */
										{
											/* Default enter sequence for state off */
											handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
											handle->stateConfVectorPosition = 1;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		{
			/* Default enter sequence for region alarm 1 */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state disabled */
					handle->stateConfVector[2] = clock_alarm_1_disabled;
					handle->stateConfVectorPosition = 2;
				}
			}
		}
		{
			/* Default enter sequence for region alarm 2 */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state disabled */
					handle->stateConfVector[3] = clock_alarm_2_disabled;
					handle->stateConfVectorPosition = 3;
				}
			}
		}
		{
			/* Default enter sequence for region chime - status */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state disabled */
					handle->stateConfVector[4] = clock_chime___status_disabled;
					handle->stateConfVectorPosition = 4;
				}
			}
		}
		{
			/* Default enter sequence for region light */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state off */
					handle->stateConfVector[5] = clock_light_off;
					handle->stateConfVectorPosition = 5;
				}
			}
		}
		{
			/* Default enter sequence for region power */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state ok */
					handle->stateConfVector[6] = clock_power_ok;
					handle->stateConfVectorPosition = 6;
				}
			}
		}
	}
}

void clock_exit(Clock* handle)
{
	{
		/* Default exit sequence for statechart clock */
		{
			/* Default exit sequence for region main */
			/* Handle exit of all possible states (of main) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
					handle->historyVector[2] = handle->stateConfVector[0];
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state sec */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'update'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
					handle->historyVector[2] = handle->stateConfVector[0];
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state min */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'update'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
					handle->historyVector[2] = handle->stateConfVector[0];
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state hr */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'update'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
					handle->historyVector[2] = handle->stateConfVector[0];
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state mode */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'update'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_regular_time : {
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state time */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_regular_date : {
					handle->historyVector[1] = handle->stateConfVector[0];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state date */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'date'. */
							clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
						}
					}
					break;
				}
				case clock_main_displays__region0_wait : {
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state wait */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'wait'. */
							clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
						}
					}
					break;
				}
				case clock_main_alarms_beep_r1_alarm_1_beeps : {
					{
						/* Default exit sequence for state alarm 1 beeps */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_alarms_beep_r1_alarm_2_beeps : {
					{
						/* Default exit sequence for state alarm 2 beeps */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_alarms_beep_r1_both_beep : {
					{
						/* Default exit sequence for state both beep */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
					break;
				}
				case clock_main_stopwatch_r1_zero : {
					handle->historyVector[4] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state zero */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_stopwatch_r1_display_run_display_regular : {
					handle->historyVector[5] = handle->stateConfVector[0];
					handle->historyVector[4] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state regular */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_stopwatch_r1_display_run_display_lap : {
					handle->historyVector[5] = handle->stateConfVector[0];
					handle->historyVector[4] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state lap */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_alarm_1_r1_off : {
					handle->historyVector[7] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_alarm_1_r1_on : {
					handle->historyVector[7] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_update_1_r1_hr : {
					{
						/* Default exit sequence for state hr */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_update_1_r1_min : {
					{
						/* Default exit sequence for state min */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_update_2_r1_hr : {
					{
						/* Default exit sequence for state hr */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_update_2_r1_min : {
					{
						/* Default exit sequence for state min */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_alarm_2_r1_off : {
					handle->historyVector[8] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_alarm_2_r1_on : {
					handle->historyVector[8] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_chime_r1_off : {
					handle->historyVector[9] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case clock_main_settings_r1_chime_r1_on : {
					handle->historyVector[9] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				default: break;
			}
			/* Handle exit of all possible states (of main) at position 1... */
			switch(handle->stateConfVector[ 1 ]) {
				case clock_main_displays__region0_regular_beep_test_beep_test_off : {
					handle->historyVector[3] = handle->stateConfVector[1];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[1] = Clock_last_state;
						handle->stateConfVectorPosition = 1;
					}
					break;
				}
				case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
					handle->historyVector[3] = handle->stateConfVector[1];
					handle->historyVector[0] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state beep */
						handle->stateConfVector[1] = Clock_last_state;
						handle->stateConfVectorPosition = 1;
					}
					break;
				}
				case clock_main_stopwatch_r1_display_run_run_on : {
					handle->historyVector[6] = handle->stateConfVector[1];
					handle->historyVector[4] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[1] = Clock_last_state;
						handle->stateConfVectorPosition = 1;
						{
							/* Exit action for state 'on'. */
							clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
						}
					}
					break;
				}
				case clock_main_stopwatch_r1_display_run_run_off : {
					handle->historyVector[6] = handle->stateConfVector[1];
					handle->historyVector[4] = handle->stateConfVector[0];
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[1] = Clock_last_state;
						handle->stateConfVectorPosition = 1;
					}
					break;
				}
				default: break;
			}
		}
		{
			/* Default exit sequence for region alarm 1 */
			/* Handle exit of all possible states (of alarm 1) at position 2... */
			switch(handle->stateConfVector[ 2 ]) {
				case clock_alarm_1_disabled : {
					{
						/* Default exit sequence for state disabled */
						handle->stateConfVector[2] = Clock_last_state;
						handle->stateConfVectorPosition = 2;
					}
					break;
				}
				case clock_alarm_1_enabled : {
					{
						/* Default exit sequence for state enabled */
						handle->stateConfVector[2] = Clock_last_state;
						handle->stateConfVectorPosition = 2;
					}
					break;
				}
				default: break;
			}
		}
		{
			/* Default exit sequence for region alarm 2 */
			/* Handle exit of all possible states (of alarm 2) at position 3... */
			switch(handle->stateConfVector[ 3 ]) {
				case clock_alarm_2_disabled : {
					{
						/* Default exit sequence for state disabled */
						handle->stateConfVector[3] = Clock_last_state;
						handle->stateConfVectorPosition = 3;
					}
					break;
				}
				case clock_alarm_2_enabled : {
					{
						/* Default exit sequence for state enabled */
						handle->stateConfVector[3] = Clock_last_state;
						handle->stateConfVectorPosition = 3;
					}
					break;
				}
				default: break;
			}
		}
		{
			/* Default exit sequence for region chime - status */
			/* Handle exit of all possible states (of chime - status) at position 4... */
			switch(handle->stateConfVector[ 4 ]) {
				case clock_chime___status_disabled : {
					{
						/* Default exit sequence for state disabled */
						handle->stateConfVector[4] = Clock_last_state;
						handle->stateConfVectorPosition = 4;
					}
					break;
				}
				case clock_chime___status_enabled_r1_quiet : {
					{
						/* Default exit sequence for state quiet */
						handle->stateConfVector[4] = Clock_last_state;
						handle->stateConfVectorPosition = 4;
					}
					break;
				}
				case clock_chime___status_enabled_r1_beep : {
					{
						/* Default exit sequence for state beep */
						handle->stateConfVector[4] = Clock_last_state;
						handle->stateConfVectorPosition = 4;
						{
							/* Exit action for state 'beep'. */
							clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) );		
						}
					}
					break;
				}
				default: break;
			}
		}
		{
			/* Default exit sequence for region light */
			/* Handle exit of all possible states (of light) at position 5... */
			switch(handle->stateConfVector[ 5 ]) {
				case clock_light_off : {
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[5] = Clock_last_state;
						handle->stateConfVectorPosition = 5;
					}
					break;
				}
				case clock_light_on : {
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[5] = Clock_last_state;
						handle->stateConfVectorPosition = 5;
					}
					break;
				}
				default: break;
			}
		}
		{
			/* Default exit sequence for region power */
			/* Handle exit of all possible states (of power) at position 6... */
			switch(handle->stateConfVector[ 6 ]) {
				case clock_power_ok : {
					{
						/* Default exit sequence for state ok */
						handle->stateConfVector[6] = Clock_last_state;
						handle->stateConfVectorPosition = 6;
					}
					break;
				}
				case clock_power_blink : {
					{
						/* Default exit sequence for state blink */
						handle->stateConfVector[6] = Clock_last_state;
						handle->stateConfVectorPosition = 6;
					}
					break;
				}
				default: break;
			}
		}
		clock_exitaction(handle);
	}
}

static void clearInEvents(Clock* handle) {
	handle->iface.a_p_raised = bool_false;
	handle->iface.b_p_raised = bool_false;
	handle->iface.b_r_raised = bool_false;
	handle->iface.c_p_raised = bool_false;
	handle->iface.c_r_raised = bool_false;
	handle->iface.d_p_raised = bool_false;
	handle->iface.d_r_raised = bool_false;
	handle->ifaceBattery.low_raised = bool_false;
	handle->ifaceBattery.replace_raised = bool_false;
	handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_main_alarms_beep_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised = bool_false; 
	handle->timeEvents.clock_time_event_0_raised = bool_false; 
}

static void clearOutEvents(Clock* handle) {
}

void clock_runCycle(Clock* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CLOCK_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
			clock_react_main_displays_region0_regular_beep_test_regular_update_region0_sec(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
			clock_react_main_displays_region0_regular_beep_test_regular_update_region0_min(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
			clock_react_main_displays_region0_regular_beep_test_regular_update_region0_hr(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
			clock_react_main_displays_region0_regular_beep_test_regular_update_region0_mode(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_regular_time : {
			clock_react_main_displays_region0_regular_beep_test_regular_time(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_regular_date : {
			clock_react_main_displays_region0_regular_beep_test_regular_date(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_beep_test_off : {
			clock_react_main_displays_region0_regular_beep_test_beep_test_off(handle);
			break;
		}
		case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
			clock_react_main_displays_region0_regular_beep_test_beep_test_beep(handle);
			break;
		}
		case clock_main_displays__region0_wait : {
			clock_react_main_displays_region0_wait(handle);
			break;
		}
		case clock_main_alarms_beep_r1_alarm_1_beeps : {
			clock_react_main_alarms_beep_r1_alarm_1_beeps(handle);
			break;
		}
		case clock_main_alarms_beep_r1_alarm_2_beeps : {
			clock_react_main_alarms_beep_r1_alarm_2_beeps(handle);
			break;
		}
		case clock_main_alarms_beep_r1_both_beep : {
			clock_react_main_alarms_beep_r1_both_beep(handle);
			break;
		}
		case clock_main_stopwatch_r1_zero : {
			clock_react_main_stopwatch_r1_zero(handle);
			break;
		}
		case clock_main_stopwatch_r1_display_run_display_regular : {
			clock_react_main_stopwatch_r1_display_run_display_regular(handle);
			break;
		}
		case clock_main_stopwatch_r1_display_run_display_lap : {
			clock_react_main_stopwatch_r1_display_run_display_lap(handle);
			break;
		}
		case clock_main_stopwatch_r1_display_run_run_on : {
			clock_react_main_stopwatch_r1_display_run_run_on(handle);
			break;
		}
		case clock_main_stopwatch_r1_display_run_run_off : {
			clock_react_main_stopwatch_r1_display_run_run_off(handle);
			break;
		}
		case clock_main_settings_r1_alarm_1_r1_off : {
			clock_react_main_settings_r1_alarm_1_r1_off(handle);
			break;
		}
		case clock_main_settings_r1_alarm_1_r1_on : {
			clock_react_main_settings_r1_alarm_1_r1_on(handle);
			break;
		}
		case clock_main_settings_r1_update_1_r1_hr : {
			clock_react_main_settings_r1_update_1_r1_hr(handle);
			break;
		}
		case clock_main_settings_r1_update_1_r1_min : {
			clock_react_main_settings_r1_update_1_r1_min(handle);
			break;
		}
		case clock_main_settings_r1_update_2_r1_hr : {
			clock_react_main_settings_r1_update_2_r1_hr(handle);
			break;
		}
		case clock_main_settings_r1_update_2_r1_min : {
			clock_react_main_settings_r1_update_2_r1_min(handle);
			break;
		}
		case clock_main_settings_r1_alarm_2_r1_off : {
			clock_react_main_settings_r1_alarm_2_r1_off(handle);
			break;
		}
		case clock_main_settings_r1_alarm_2_r1_on : {
			clock_react_main_settings_r1_alarm_2_r1_on(handle);
			break;
		}
		case clock_main_settings_r1_chime_r1_off : {
			clock_react_main_settings_r1_chime_r1_off(handle);
			break;
		}
		case clock_main_settings_r1_chime_r1_on : {
			clock_react_main_settings_r1_chime_r1_on(handle);
			break;
		}
		case clock_alarm_1_disabled : {
			clock_react_alarm_1_disabled(handle);
			break;
		}
		case clock_alarm_1_enabled : {
			clock_react_alarm_1_enabled(handle);
			break;
		}
		case clock_alarm_2_disabled : {
			clock_react_alarm_2_disabled(handle);
			break;
		}
		case clock_alarm_2_enabled : {
			clock_react_alarm_2_enabled(handle);
			break;
		}
		case clock_chime___status_disabled : {
			clock_react_chime___status_disabled(handle);
			break;
		}
		case clock_chime___status_enabled_r1_quiet : {
			clock_react_chime___status_enabled_r1_quiet(handle);
			break;
		}
		case clock_chime___status_enabled_r1_beep : {
			clock_react_chime___status_enabled_r1_beep(handle);
			break;
		}
		case clock_light_off : {
			clock_react_light_off(handle);
			break;
		}
		case clock_light_on : {
			clock_react_light_on(handle);
			break;
		}
		case clock_power_ok : {
			clock_react_power_ok(handle);
			break;
		}
		case clock_power_blink : {
			clock_react_power_blink(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}

void clock_raiseTimeEvent(Clock* handle, sc_eventid evid) {
	if ( ((intptr_t)evid) >= ((intptr_t)&(handle->timeEvents))
		&&  ((intptr_t)evid) < ((intptr_t)&(handle->timeEvents)) + sizeof(ClockTimeEvents)) {
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean clock_isActive(Clock* handle, ClockStates state) {
	switch (state) {
		case clock_main_displays : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_displays
				&& handle->stateConfVector[0] <= clock_main_displays__region0_wait);
		case clock_main_displays__region0_regular_beep_test : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_displays__region0_regular_beep_test
				&& handle->stateConfVector[0] <= clock_main_displays__region0_regular_beep_test_beep_test_beep);
		case clock_main_displays__region0_regular_beep_test_regular_update : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_displays__region0_regular_beep_test_regular_update
				&& handle->stateConfVector[0] <= clock_main_displays__region0_regular_beep_test_regular_update__region0_mode);
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_update__region0_sec
			);
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_update__region0_min
			);
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_update__region0_hr
			);
		case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_update__region0_mode
			);
		case clock_main_displays__region0_regular_beep_test_regular_time : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_time
			);
		case clock_main_displays__region0_regular_beep_test_regular_date : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_regular_beep_test_regular_date
			);
		case clock_main_displays__region0_regular_beep_test_beep_test_off : 
			return (sc_boolean) (handle->stateConfVector[1] == clock_main_displays__region0_regular_beep_test_beep_test_off
			);
		case clock_main_displays__region0_regular_beep_test_beep_test_beep : 
			return (sc_boolean) (handle->stateConfVector[1] == clock_main_displays__region0_regular_beep_test_beep_test_beep
			);
		case clock_main_displays__region0_wait : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_displays__region0_wait
			);
		case clock_main_alarms_beep : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_alarms_beep
				&& handle->stateConfVector[0] <= clock_main_alarms_beep_r1_both_beep);
		case clock_main_alarms_beep_r1_alarm_1_beeps : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_alarms_beep_r1_alarm_1_beeps
			);
		case clock_main_alarms_beep_r1_alarm_2_beeps : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_alarms_beep_r1_alarm_2_beeps
			);
		case clock_main_alarms_beep_r1_both_beep : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_alarms_beep_r1_both_beep
			);
		case clock_main_stopwatch : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_stopwatch
				&& handle->stateConfVector[0] <= clock_main_stopwatch_r1_display_run_run_off);
		case clock_main_stopwatch_r1_zero : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_stopwatch_r1_zero
			);
		case clock_main_stopwatch_r1_display_run : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_stopwatch_r1_display_run
				&& handle->stateConfVector[0] <= clock_main_stopwatch_r1_display_run_run_off);
		case clock_main_stopwatch_r1_display_run_display_regular : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_stopwatch_r1_display_run_display_regular
			);
		case clock_main_stopwatch_r1_display_run_display_lap : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_stopwatch_r1_display_run_display_lap
			);
		case clock_main_stopwatch_r1_display_run_run_on : 
			return (sc_boolean) (handle->stateConfVector[1] == clock_main_stopwatch_r1_display_run_run_on
			);
		case clock_main_stopwatch_r1_display_run_run_off : 
			return (sc_boolean) (handle->stateConfVector[1] == clock_main_stopwatch_r1_display_run_run_off
			);
		case clock_main_settings : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings
				&& handle->stateConfVector[0] <= clock_main_settings_r1_chime_r1_on);
		case clock_main_settings_r1_alarm_1 : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings_r1_alarm_1
				&& handle->stateConfVector[0] <= clock_main_settings_r1_alarm_1_r1_on);
		case clock_main_settings_r1_alarm_1_r1_off : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_alarm_1_r1_off
			);
		case clock_main_settings_r1_alarm_1_r1_on : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_alarm_1_r1_on
			);
		case clock_main_settings_r1_update_1 : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings_r1_update_1
				&& handle->stateConfVector[0] <= clock_main_settings_r1_update_1_r1_min);
		case clock_main_settings_r1_update_1_r1_hr : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_update_1_r1_hr
			);
		case clock_main_settings_r1_update_1_r1_min : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_update_1_r1_min
			);
		case clock_main_settings_r1_update_2 : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings_r1_update_2
				&& handle->stateConfVector[0] <= clock_main_settings_r1_update_2_r1_min);
		case clock_main_settings_r1_update_2_r1_hr : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_update_2_r1_hr
			);
		case clock_main_settings_r1_update_2_r1_min : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_update_2_r1_min
			);
		case clock_main_settings_r1_alarm_2 : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings_r1_alarm_2
				&& handle->stateConfVector[0] <= clock_main_settings_r1_alarm_2_r1_on);
		case clock_main_settings_r1_alarm_2_r1_off : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_alarm_2_r1_off
			);
		case clock_main_settings_r1_alarm_2_r1_on : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_alarm_2_r1_on
			);
		case clock_main_settings_r1_chime : 
			return (sc_boolean) (handle->stateConfVector[0] >= clock_main_settings_r1_chime
				&& handle->stateConfVector[0] <= clock_main_settings_r1_chime_r1_on);
		case clock_main_settings_r1_chime_r1_off : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_chime_r1_off
			);
		case clock_main_settings_r1_chime_r1_on : 
			return (sc_boolean) (handle->stateConfVector[0] == clock_main_settings_r1_chime_r1_on
			);
		case clock_alarm_1_disabled : 
			return (sc_boolean) (handle->stateConfVector[2] == clock_alarm_1_disabled
			);
		case clock_alarm_1_enabled : 
			return (sc_boolean) (handle->stateConfVector[2] == clock_alarm_1_enabled
			);
		case clock_alarm_2_disabled : 
			return (sc_boolean) (handle->stateConfVector[3] == clock_alarm_2_disabled
			);
		case clock_alarm_2_enabled : 
			return (sc_boolean) (handle->stateConfVector[3] == clock_alarm_2_enabled
			);
		case clock_chime___status_disabled : 
			return (sc_boolean) (handle->stateConfVector[4] == clock_chime___status_disabled
			);
		case clock_chime___status_enabled : 
			return (sc_boolean) (handle->stateConfVector[4] >= clock_chime___status_enabled
				&& handle->stateConfVector[4] <= clock_chime___status_enabled_r1_beep);
		case clock_chime___status_enabled_r1_quiet : 
			return (sc_boolean) (handle->stateConfVector[4] == clock_chime___status_enabled_r1_quiet
			);
		case clock_chime___status_enabled_r1_beep : 
			return (sc_boolean) (handle->stateConfVector[4] == clock_chime___status_enabled_r1_beep
			);
		case clock_light_off : 
			return (sc_boolean) (handle->stateConfVector[5] == clock_light_off
			);
		case clock_light_on : 
			return (sc_boolean) (handle->stateConfVector[5] == clock_light_on
			);
		case clock_power_ok : 
			return (sc_boolean) (handle->stateConfVector[6] == clock_power_ok
			);
		case clock_power_blink : 
			return (sc_boolean) (handle->stateConfVector[6] == clock_power_blink
			);
		default: return bool_false;
	}
}

void clockIface_raise_a_p(Clock* handle) {
	handle->iface.a_p_raised = bool_true;
}
void clockIface_raise_b_p(Clock* handle) {
	handle->iface.b_p_raised = bool_true;
}
void clockIface_raise_b_r(Clock* handle) {
	handle->iface.b_r_raised = bool_true;
}
void clockIface_raise_c_p(Clock* handle) {
	handle->iface.c_p_raised = bool_true;
}
void clockIface_raise_c_r(Clock* handle) {
	handle->iface.c_r_raised = bool_true;
}
void clockIface_raise_d_p(Clock* handle) {
	handle->iface.d_p_raised = bool_true;
}
void clockIface_raise_d_r(Clock* handle) {
	handle->iface.d_r_raised = bool_true;
}




sc_integer clockIfaceClock_get_second(Clock* handle) {
	return handle->ifaceClock.second;
}
sc_integer clockIfaceClock_get_minute(Clock* handle) {
	return handle->ifaceClock.minute;
}
void clockIfaceClock_set_minute(Clock* handle, sc_integer value) {
	handle->ifaceClock.minute = value;
}
sc_integer clockIfaceClock_get_hour(Clock* handle) {
	return handle->ifaceClock.hour;
}
void clockIfaceClock_set_hour(Clock* handle, sc_integer value) {
	handle->ifaceClock.hour = value;
}
sc_integer clockIfaceClock_get_time(Clock* handle) {
	return handle->ifaceClock.time;
}
void clockIfaceClock_set_time(Clock* handle, sc_integer value) {
	handle->ifaceClock.time = value;
}
sc_integer clockIfaceClock_get_al1_time(Clock* handle) {
	return handle->ifaceClock.al1_time;
}
void clockIfaceClock_set_al1_time(Clock* handle, sc_integer value) {
	handle->ifaceClock.al1_time = value;
}
sc_integer clockIfaceClock_get_al2_time(Clock* handle) {
	return handle->ifaceClock.al2_time;
}
void clockIfaceClock_set_al2_time(Clock* handle, sc_integer value) {
	handle->ifaceClock.al2_time = value;
}


sc_integer clockIfaceStopwatch_get_time(Clock* handle) {
	return handle->ifaceStopwatch.time;
}
void clockIfaceStopwatch_set_time(Clock* handle, sc_integer value) {
	handle->ifaceStopwatch.time = value;
}
sc_integer clockIfaceStopwatch_get_lap(Clock* handle) {
	return handle->ifaceStopwatch.lap;
}
void clockIfaceStopwatch_set_lap(Clock* handle, sc_integer value) {
	handle->ifaceStopwatch.lap = value;
}
void clockIfaceBattery_raise_low(Clock* handle) {
	handle->ifaceBattery.low_raised = bool_true;
}
void clockIfaceBattery_raise_replace(Clock* handle) {
	handle->ifaceBattery.replace_raised = bool_true;
}


sc_integer clockIfaceBattery_get_max_energy(Clock* handle) {
	return handle->ifaceBattery.max_energy;
}
sc_real clockIfaceBattery_get_min_energy(Clock* handle) {
	return handle->ifaceBattery.min_energy;
}
sc_integer clockIfaceBattery_get_energy(Clock* handle) {
	return handle->ifaceBattery.energy;
}
void clockIfaceBattery_set_energy(Clock* handle, sc_integer value) {
	handle->ifaceBattery.energy = value;
}
		
// implementations of all internal functions

static sc_boolean clock_check_lr0(Clock* handle) {
	return handle->timeEvents.clock_time_event_0_raised;
}

static sc_boolean clock_check_lr1(Clock* handle) {
	return handle->ifaceClock.time >= 864000 && bool_true;
}

static sc_boolean clock_check_lr2(Clock* handle) {
	return bool_true;
}

static void clock_effect_lr0(Clock* handle) {
	handle->ifaceClock.time += 1;
}

static void clock_effect_lr1(Clock* handle) {
	handle->ifaceClock.time = 0;
}

static void clock_effect_lr2(Clock* handle) {
	handle->ifaceBattery.energy -= 1;
}

/* Entry action for statechart 'clock'. */
static void clock_entryaction(Clock* handle) {
	{
		/* Entry action for statechart 'clock'. */
		clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_time_event_0_raised) , 100, bool_true);
	}
}

/* Exit action for state 'clock'. */
static void clock_exitaction(Clock* handle) {
	{
		/* Exit action for state 'clock'. */
		clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_time_event_0_raised) );		
	}
}

/* deep enterSequence with history in child  */
static void clock_deepentersequence_main_displays_region0(Clock* handle) {
	{
		/* deep enterSequence with history in child  */
		/* Handle deep history entry of  */
		switch(handle->historyVector[ 0 ]) {
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
				{
					/* enterSequence with history in child regular-beep-test for leaf sec */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
				{
					/* enterSequence with history in child regular-beep-test for leaf min */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
				{
					/* enterSequence with history in child regular-beep-test for leaf hr */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
				{
					/* enterSequence with history in child regular-beep-test for leaf mode */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_time : {
				{
					/* enterSequence with history in child regular-beep-test for leaf time */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_date : {
				{
					/* enterSequence with history in child regular-beep-test for leaf date */
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular(handle);
					clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(handle);
				}
				break;
			}
			case clock_main_displays__region0_wait : {
				{
					/* enterSequence with history in child wait for leaf wait */
					{
						/* Default enter sequence for state wait */
						{
							/* Entry action for state 'wait'. */
							clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) , 2 * 1000, bool_false);
						}
						handle->stateConfVector[0] = clock_main_displays__region0_wait;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child regular */
static void clock_deepentersequence_main_displays_region0_regular_beep_test_regular(Clock* handle) {
	{
		/* deep enterSequence with history in child regular */
		/* Handle deep history entry of regular */
		switch(handle->historyVector[ 1 ]) {
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
				{
					/* enterSequence with history in child update for leaf sec */
					{
						/* Entry action for state 'update'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) , 120 * 1000, bool_false);
					}
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
				{
					/* enterSequence with history in child update for leaf min */
					{
						/* Entry action for state 'update'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) , 120 * 1000, bool_false);
					}
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
				{
					/* enterSequence with history in child update for leaf hr */
					{
						/* Entry action for state 'update'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) , 120 * 1000, bool_false);
					}
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
				{
					/* enterSequence with history in child update for leaf mode */
					{
						/* Entry action for state 'update'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) , 120 * 1000, bool_false);
					}
					clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(handle);
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_time : {
				{
					/* enterSequence with history in child time for leaf time */
					{
						/* Default enter sequence for state time */
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_date : {
				{
					/* enterSequence with history in child date for leaf date */
					{
						/* Default enter sequence for state date */
						{
							/* Entry action for state 'date'. */
							clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) , 120 * 1000, bool_false);
						}
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_date;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child  */
static void clock_deepentersequence_main_displays_region0_regular_beep_test_regular_update_region0(Clock* handle) {
	{
		/* deep enterSequence with history in child  */
		/* Handle deep history entry of  */
		switch(handle->historyVector[ 2 ]) {
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
				{
					/* enterSequence with history in child sec for leaf sec */
					{
						/* Default enter sequence for state sec */
						{
							/* Entry action for state 'sec'. */
							handle->ifaceClock.second = (handle->ifaceClock.time / 10) % 60;
						}
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_sec;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
				{
					/* enterSequence with history in child min for leaf min */
					{
						/* Default enter sequence for state min */
						{
							/* Entry action for state 'min'. */
							handle->ifaceClock.minute = (handle->ifaceClock.time / 600) % 60;
						}
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_min;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
				{
					/* enterSequence with history in child hr for leaf hr */
					{
						/* Default enter sequence for state hr */
						{
							/* Entry action for state 'hr'. */
							handle->ifaceClock.hour = (handle->ifaceClock.time / 36000) % 24;
						}
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_hr;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
				{
					/* enterSequence with history in child mode for leaf mode */
					{
						/* Default enter sequence for state mode */
						handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_mode;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child beep-test */
static void clock_deepentersequence_main_displays_region0_regular_beep_test_beep_test(Clock* handle) {
	{
		/* deep enterSequence with history in child beep-test */
		/* Handle deep history entry of beep-test */
		switch(handle->historyVector[ 3 ]) {
			case clock_main_displays__region0_regular_beep_test_beep_test_off : {
				{
					/* enterSequence with history in child off for leaf off */
					{
						/* Default enter sequence for state off */
						handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
						handle->stateConfVectorPosition = 1;
					}
				}
				break;
			}
			case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
				{
					/* enterSequence with history in child beep for leaf beep */
					{
						/* Default enter sequence for state beep */
						handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_beep;
						handle->stateConfVectorPosition = 1;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child r1 */
static void clock_deepentersequence_main_stopwatch_r1(Clock* handle) {
	{
		/* deep enterSequence with history in child r1 */
		/* Handle deep history entry of r1 */
		switch(handle->historyVector[ 4 ]) {
			case clock_main_stopwatch_r1_zero : {
				{
					/* enterSequence with history in child zero for leaf zero */
					{
						/* Default enter sequence for state zero */
						{
							/* Entry action for state 'zero'. */
							handle->ifaceStopwatch.time = 0;
							handle->ifaceStopwatch.lap = 0;
							handle->internal.delta = 0;
						}
						handle->stateConfVector[0] = clock_main_stopwatch_r1_zero;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_stopwatch_r1_display_run_display_regular : {
				{
					/* enterSequence with history in child display-run for leaf regular */
					clock_deepentersequence_main_stopwatch_r1_display_run_display(handle);
					clock_deepentersequence_main_stopwatch_r1_display_run_run(handle);
				}
				break;
			}
			case clock_main_stopwatch_r1_display_run_display_lap : {
				{
					/* enterSequence with history in child display-run for leaf lap */
					clock_deepentersequence_main_stopwatch_r1_display_run_display(handle);
					clock_deepentersequence_main_stopwatch_r1_display_run_run(handle);
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child display */
static void clock_deepentersequence_main_stopwatch_r1_display_run_display(Clock* handle) {
	{
		/* deep enterSequence with history in child display */
		/* Handle deep history entry of display */
		switch(handle->historyVector[ 5 ]) {
			case clock_main_stopwatch_r1_display_run_display_regular : {
				{
					/* enterSequence with history in child regular for leaf regular */
					{
						/* Default enter sequence for state regular */
						handle->stateConfVector[0] = clock_main_stopwatch_r1_display_run_display_regular;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			case clock_main_stopwatch_r1_display_run_display_lap : {
				{
					/* enterSequence with history in child lap for leaf lap */
					{
						/* Default enter sequence for state lap */
						{
							/* Entry action for state 'lap'. */
							handle->ifaceStopwatch.lap = handle->ifaceStopwatch.time - handle->internal.delta;
							handle->internal.delta = handle->ifaceStopwatch.time;
						}
						handle->stateConfVector[0] = clock_main_stopwatch_r1_display_run_display_lap;
						handle->stateConfVectorPosition = 0;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* deep enterSequence with history in child run */
static void clock_deepentersequence_main_stopwatch_r1_display_run_run(Clock* handle) {
	{
		/* deep enterSequence with history in child run */
		/* Handle deep history entry of run */
		switch(handle->historyVector[ 6 ]) {
			case clock_main_stopwatch_r1_display_run_run_on : {
				{
					/* enterSequence with history in child on for leaf on */
					{
						/* Default enter sequence for state on */
						{
							/* Entry action for state 'on'. */
							clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) , 100, bool_true);
						}
						handle->stateConfVector[1] = clock_main_stopwatch_r1_display_run_run_on;
						handle->stateConfVectorPosition = 1;
					}
				}
				break;
			}
			case clock_main_stopwatch_r1_display_run_run_off : {
				{
					/* enterSequence with history in child off for leaf off */
					{
						/* Default enter sequence for state off */
						handle->stateConfVector[1] = clock_main_stopwatch_r1_display_run_run_off;
						handle->stateConfVectorPosition = 1;
					}
				}
				break;
			}
			default: break;
		}
	}
}

/* shallow enterSequence with history in child r1 */
static void clock_shallowentersequence_main_settings_r1_alarm_1_r1(Clock* handle) {
	{
		/* shallow enterSequence with history in child r1 */
		/* Handle shallow history entry of r1 */
		switch(handle->historyVector[ 7 ]) {
			case clock_main_settings_r1_alarm_1_r1_off : {
				{
					/* Default enter sequence for state off */
					handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			case clock_main_settings_r1_alarm_1_r1_on : {
				{
					/* Default enter sequence for state on */
					handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_on;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			default: break;
		}
	}
}

/* shallow enterSequence with history in child r1 */
static void clock_shallowentersequence_main_settings_r1_alarm_2_r1(Clock* handle) {
	{
		/* shallow enterSequence with history in child r1 */
		/* Handle shallow history entry of r1 */
		switch(handle->historyVector[ 8 ]) {
			case clock_main_settings_r1_alarm_2_r1_off : {
				{
					/* Default enter sequence for state off */
					handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			case clock_main_settings_r1_alarm_2_r1_on : {
				{
					/* Default enter sequence for state on */
					handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_on;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			default: break;
		}
	}
}

/* shallow enterSequence with history in child r1 */
static void clock_shallowentersequence_main_settings_r1_chime_r1(Clock* handle) {
	{
		/* shallow enterSequence with history in child r1 */
		/* Handle shallow history entry of r1 */
		switch(handle->historyVector[ 9 ]) {
			case clock_main_settings_r1_chime_r1_off : {
				{
					/* Default enter sequence for state off */
					handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_off;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			case clock_main_settings_r1_chime_r1_on : {
				{
					/* Default enter sequence for state on */
					handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_on;
					handle->stateConfVectorPosition = 0;
				}
				break;
			}
			default: break;
		}
	}
}

/* The reactions of state sec. */
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_sec(Clock* handle) {
	{
		/* The reactions of state sec. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.b_p_raised) { 
						{
							/* Default exit sequence for state update */
							{
								/* Default exit sequence for region  */
								handle->historyVector[2] = handle->stateConfVector[0];
								/* Handle exit of all possible states (of region0) at position 0... */
								switch(handle->stateConfVector[ 0 ]) {
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
										{
											/* Default exit sequence for state sec */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
										{
											/* Default exit sequence for state min */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
										{
											/* Default exit sequence for state hr */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
										{
											/* Default exit sequence for state mode */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									default: break;
								}
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) { 
							{
								/* Default exit sequence for state update */
								{
									/* Default exit sequence for region  */
									handle->historyVector[2] = handle->stateConfVector[0];
									/* Handle exit of all possible states (of region0) at position 0... */
									switch(handle->stateConfVector[ 0 ]) {
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
											{
												/* Default exit sequence for state sec */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
											{
												/* Default exit sequence for state min */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
											{
												/* Default exit sequence for state hr */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
											{
												/* Default exit sequence for state mode */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										default: break;
									}
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
							}
							{
								/* Default enter sequence for state time */
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
								handle->stateConfVectorPosition = 0;
							}
						}  else {
							if (handle->iface.c_p_raised) { 
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Default enter sequence for state min */
									{
										/* Entry action for state 'min'. */
										handle->ifaceClock.minute = (handle->ifaceClock.time / 600) % 60;
									}
									handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_min;
									handle->stateConfVectorPosition = 0;
								}
							}  else {
								if (handle->iface.d_p_raised) { 
									handle->ifaceClock.second = (handle->ifaceClock.second + 1) % 60;
								} 
							}
						}
					}
				}
			}
		}
	}
}

/* The reactions of state min. */
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_min(Clock* handle) {
	{
		/* The reactions of state min. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.b_p_raised) { 
						{
							/* Default exit sequence for state update */
							{
								/* Default exit sequence for region  */
								handle->historyVector[2] = handle->stateConfVector[0];
								/* Handle exit of all possible states (of region0) at position 0... */
								switch(handle->stateConfVector[ 0 ]) {
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
										{
											/* Default exit sequence for state sec */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
										{
											/* Default exit sequence for state min */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
										{
											/* Default exit sequence for state hr */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
										{
											/* Default exit sequence for state mode */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									default: break;
								}
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) { 
							{
								/* Default exit sequence for state update */
								{
									/* Default exit sequence for region  */
									handle->historyVector[2] = handle->stateConfVector[0];
									/* Handle exit of all possible states (of region0) at position 0... */
									switch(handle->stateConfVector[ 0 ]) {
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
											{
												/* Default exit sequence for state sec */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
											{
												/* Default exit sequence for state min */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
											{
												/* Default exit sequence for state hr */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
											{
												/* Default exit sequence for state mode */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										default: break;
									}
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
							}
							{
								/* Default enter sequence for state time */
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
								handle->stateConfVectorPosition = 0;
							}
						}  else {
							if (handle->iface.c_p_raised) { 
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Default enter sequence for state hr */
									{
										/* Entry action for state 'hr'. */
										handle->ifaceClock.hour = (handle->ifaceClock.time / 36000) % 24;
									}
									handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_hr;
									handle->stateConfVectorPosition = 0;
								}
							}  else {
								if (handle->iface.d_p_raised) { 
									handle->ifaceClock.minute = ((handle->ifaceClock.minute + 1) % 60);
								} 
							}
						}
					}
				}
			}
		}
	}
}

/* The reactions of state hr. */
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_hr(Clock* handle) {
	{
		/* The reactions of state hr. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.b_p_raised) { 
						{
							/* Default exit sequence for state update */
							{
								/* Default exit sequence for region  */
								handle->historyVector[2] = handle->stateConfVector[0];
								/* Handle exit of all possible states (of region0) at position 0... */
								switch(handle->stateConfVector[ 0 ]) {
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
										{
											/* Default exit sequence for state sec */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
										{
											/* Default exit sequence for state min */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
										{
											/* Default exit sequence for state hr */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
										{
											/* Default exit sequence for state mode */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									default: break;
								}
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) { 
							{
								/* Default exit sequence for state update */
								{
									/* Default exit sequence for region  */
									handle->historyVector[2] = handle->stateConfVector[0];
									/* Handle exit of all possible states (of region0) at position 0... */
									switch(handle->stateConfVector[ 0 ]) {
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
											{
												/* Default exit sequence for state sec */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
											{
												/* Default exit sequence for state min */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
											{
												/* Default exit sequence for state hr */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
											{
												/* Default exit sequence for state mode */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										default: break;
									}
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
							}
							{
								/* Default enter sequence for state time */
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
								handle->stateConfVectorPosition = 0;
							}
						}  else {
							if (handle->iface.c_p_raised) { 
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Default enter sequence for state mode */
									handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_mode;
									handle->stateConfVectorPosition = 0;
								}
							}  else {
								if (handle->iface.d_p_raised) { 
									handle->ifaceClock.hour = ((handle->ifaceClock.hour + 1) % 24);
								} 
							}
						}
					}
				}
			}
		}
	}
}

/* The reactions of state mode. */
static void clock_react_main_displays_region0_regular_beep_test_regular_update_region0_mode(Clock* handle) {
	{
		/* The reactions of state mode. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.b_p_raised) { 
						{
							/* Default exit sequence for state update */
							{
								/* Default exit sequence for region  */
								handle->historyVector[2] = handle->stateConfVector[0];
								/* Handle exit of all possible states (of region0) at position 0... */
								switch(handle->stateConfVector[ 0 ]) {
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
										{
											/* Default exit sequence for state sec */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
										{
											/* Default exit sequence for state min */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
										{
											/* Default exit sequence for state hr */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
										{
											/* Default exit sequence for state mode */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									default: break;
								}
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) { 
							{
								/* Default exit sequence for state update */
								{
									/* Default exit sequence for region  */
									handle->historyVector[2] = handle->stateConfVector[0];
									/* Handle exit of all possible states (of region0) at position 0... */
									switch(handle->stateConfVector[ 0 ]) {
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
											{
												/* Default exit sequence for state sec */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
											{
												/* Default exit sequence for state min */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
											{
												/* Default exit sequence for state hr */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
											{
												/* Default exit sequence for state mode */
												handle->stateConfVector[0] = Clock_last_state;
												handle->stateConfVectorPosition = 0;
											}
											break;
										}
										default: break;
									}
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
							}
							{
								/* Default enter sequence for state time */
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
								handle->stateConfVectorPosition = 0;
							}
						}  else {
							if (handle->iface.c_p_raised) { 
								{
									/* Default exit sequence for state update */
									{
										/* Default exit sequence for region  */
										handle->historyVector[2] = handle->stateConfVector[0];
										/* Handle exit of all possible states (of region0) at position 0... */
										switch(handle->stateConfVector[ 0 ]) {
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
												{
													/* Default exit sequence for state sec */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
												{
													/* Default exit sequence for state min */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
												{
													/* Default exit sequence for state hr */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
												{
													/* Default exit sequence for state mode */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												break;
											}
											default: break;
										}
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
								}
								handle->ifaceClock.time = (3600 * handle->ifaceClock.hour + 60 * handle->ifaceClock.minute + handle->ifaceClock.second) * 10;
								{
									/* Default enter sequence for state time */
									handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}
		}
	}
}

/* The reactions of state time. */
static void clock_react_main_displays_region0_regular_beep_test_regular_time(Clock* handle) {
	{
		/* The reactions of state time. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.c_p_raised) { 
						{
							/* Default exit sequence for state regular-beep-test */
							{
								/* Default exit sequence for region regular */
								handle->historyVector[1] = handle->stateConfVector[0];
								/* Handle exit of all possible states (of regular) at position 0... */
								switch(handle->stateConfVector[ 0 ]) {
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
										handle->historyVector[2] = handle->stateConfVector[0];
										{
											/* Default exit sequence for state sec */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										{
											/* Exit action for state 'update'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
										handle->historyVector[2] = handle->stateConfVector[0];
										{
											/* Default exit sequence for state min */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										{
											/* Exit action for state 'update'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
										handle->historyVector[2] = handle->stateConfVector[0];
										{
											/* Default exit sequence for state hr */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										{
											/* Exit action for state 'update'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
										handle->historyVector[2] = handle->stateConfVector[0];
										{
											/* Default exit sequence for state mode */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										{
											/* Exit action for state 'update'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_time : {
										{
											/* Default exit sequence for state time */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_regular_date : {
										{
											/* Default exit sequence for state date */
											handle->stateConfVector[0] = Clock_last_state;
											handle->stateConfVectorPosition = 0;
											{
												/* Exit action for state 'date'. */
												clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
											}
										}
										break;
									}
									default: break;
								}
							}
							{
								/* Default exit sequence for region beep-test */
								handle->historyVector[3] = handle->stateConfVector[1];
								/* Handle exit of all possible states (of beep-test) at position 1... */
								switch(handle->stateConfVector[ 1 ]) {
									case clock_main_displays__region0_regular_beep_test_beep_test_off : {
										{
											/* Default exit sequence for state off */
											handle->stateConfVector[1] = Clock_last_state;
											handle->stateConfVectorPosition = 1;
										}
										break;
									}
									case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
										{
											/* Default exit sequence for state beep */
											handle->stateConfVector[1] = Clock_last_state;
											handle->stateConfVectorPosition = 1;
										}
										break;
									}
									default: break;
								}
							}
						}
						{
							/* Default enter sequence for state wait */
							{
								/* Entry action for state 'wait'. */
								clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) , 2 * 1000, bool_false);
							}
							handle->stateConfVector[0] = clock_main_displays__region0_wait;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->iface.b_r_raised || handle->iface.d_p_raised) { 
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Default enter sequence for state date */
								{
									/* Entry action for state 'date'. */
									clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) , 120 * 1000, bool_false);
								}
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_date;
								handle->stateConfVectorPosition = 0;
							}
						}  else {
							if (handle->iface.a_p_raised) { 
								{
									/* Default exit sequence for state displays */
									{
										/* Default exit sequence for region  */
										handle->historyVector[0] = handle->stateConfVector[0];
										/* Handle exit of all possible states (of region0) at position 0... */
										switch(handle->stateConfVector[ 0 ]) {
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
												handle->historyVector[2] = handle->stateConfVector[0];
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state sec */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												{
													/* Exit action for state 'update'. */
													clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
												handle->historyVector[2] = handle->stateConfVector[0];
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state min */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												{
													/* Exit action for state 'update'. */
													clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
												handle->historyVector[2] = handle->stateConfVector[0];
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state hr */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												{
													/* Exit action for state 'update'. */
													clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
												handle->historyVector[2] = handle->stateConfVector[0];
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state mode */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												{
													/* Exit action for state 'update'. */
													clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_time : {
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state time */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_regular_date : {
												handle->historyVector[1] = handle->stateConfVector[0];
												{
													/* Default exit sequence for state date */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
													{
														/* Exit action for state 'date'. */
														clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
													}
												}
												break;
											}
											case clock_main_displays__region0_wait : {
												{
													/* Default exit sequence for state wait */
													handle->stateConfVector[0] = Clock_last_state;
													handle->stateConfVectorPosition = 0;
													{
														/* Exit action for state 'wait'. */
														clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
													}
												}
												break;
											}
											default: break;
										}
										/* Handle exit of all possible states (of region0) at position 1... */
										switch(handle->stateConfVector[ 1 ]) {
											case clock_main_displays__region0_regular_beep_test_beep_test_off : {
												handle->historyVector[3] = handle->stateConfVector[1];
												{
													/* Default exit sequence for state off */
													handle->stateConfVector[1] = Clock_last_state;
													handle->stateConfVectorPosition = 1;
												}
												break;
											}
											case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
												handle->historyVector[3] = handle->stateConfVector[1];
												{
													/* Default exit sequence for state beep */
													handle->stateConfVector[1] = Clock_last_state;
													handle->stateConfVectorPosition = 1;
												}
												break;
											}
											default: break;
										}
									}
								}
								{
									/* Default enter sequence for state alarm 1 */
									{
										/* Default enter sequence for region r1 */
										{
											/* Default react sequence for shallow history entry  */
											/* Enter the region with shallow history */
											if (handle->historyVector[7] != Clock_last_state) {
												clock_shallowentersequence_main_settings_r1_alarm_1_r1(handle);
											} else {
												{
													/* Default enter sequence for state off */
													handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
													handle->stateConfVectorPosition = 0;
												}
											} 
										}
									}
								}
							} 
						}
					}
				}
			}
		}
	}
}

/* The reactions of state date. */
static void clock_react_main_displays_region0_regular_beep_test_regular_date(Clock* handle) {
	{
		/* The reactions of state date. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.d_p_raised) { 
						{
							/* Default exit sequence for state date */
							handle->stateConfVector[0] = Clock_last_state;
							handle->stateConfVectorPosition = 0;
							{
								/* Exit action for state 'date'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) { 
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							{
								/* Default enter sequence for state time */
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}
	}
}

/* The reactions of state off. */
static void clock_react_main_displays_region0_regular_beep_test_beep_test_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state off */
				handle->stateConfVector[1] = Clock_last_state;
				handle->stateConfVectorPosition = 1;
			}
			{
				/* Default enter sequence for state beep */
				handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_beep;
				handle->stateConfVectorPosition = 1;
			}
		} 
	}
}

/* The reactions of state beep. */
static void clock_react_main_displays_region0_regular_beep_test_beep_test_beep(Clock* handle) {
	{
		/* The reactions of state beep. */
		if (handle->iface.b_r_raised || handle->iface.d_r_raised) { 
			{
				/* Default exit sequence for state beep */
				handle->stateConfVector[1] = Clock_last_state;
				handle->stateConfVectorPosition = 1;
			}
			{
				/* Default enter sequence for state off */
				handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
				handle->stateConfVectorPosition = 1;
			}
		} 
	}
}

/* The reactions of state wait. */
static void clock_react_main_displays_region0_wait(Clock* handle) {
	{
		/* The reactions of state wait. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
			{
				/* Default exit sequence for state displays */
				{
					/* Default exit sequence for region  */
					handle->historyVector[0] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of region0) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state sec */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
							handle->historyVector[2] = handle->stateConfVector[0];
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state mode */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Exit action for state 'update'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_time : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state time */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_regular_date : {
							handle->historyVector[1] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state date */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'date'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_displays__region0_wait : {
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of region0) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_displays__region0_regular_beep_test_beep_test_off : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
							handle->historyVector[3] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Entry action for state 'alarms-beep'. */
				clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
			}
			{
				/* Default enter sequence for state alarm 1 beeps */
				handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_1_beeps;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (clock_isActive(handle, clock_alarm_2_enabled) && handle->ifaceClock.time == handle->ifaceClock.al2_time) { 
				{
					/* Default exit sequence for state displays */
					{
						/* Default exit sequence for region  */
						handle->historyVector[0] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of region0) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state sec */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
								handle->historyVector[2] = handle->stateConfVector[0];
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state mode */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								{
									/* Exit action for state 'update'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_time : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state time */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_regular_date : {
								handle->historyVector[1] = handle->stateConfVector[0];
								{
									/* Default exit sequence for state date */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'date'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
									}
								}
								break;
							}
							case clock_main_displays__region0_wait : {
								{
									/* Default exit sequence for state wait */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'wait'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
						/* Handle exit of all possible states (of region0) at position 1... */
						switch(handle->stateConfVector[ 1 ]) {
							case clock_main_displays__region0_regular_beep_test_beep_test_off : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
								handle->historyVector[3] = handle->stateConfVector[1];
								{
									/* Default exit sequence for state beep */
									handle->stateConfVector[1] = Clock_last_state;
									handle->stateConfVectorPosition = 1;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Entry action for state 'alarms-beep'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
				}
				{
					/* Default enter sequence for state alarm 2 beeps */
					handle->stateConfVector[0] = clock_main_alarms_beep_r1_alarm_2_beeps;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_alarm_2_enabled) && clock_isActive(handle, clock_alarm_1_enabled) && handle->ifaceClock.time == handle->ifaceClock.al1_time) { 
					{
						/* Default exit sequence for state displays */
						{
							/* Default exit sequence for region  */
							handle->historyVector[0] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of region0) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_sec : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state sec */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_min : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state min */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_hr : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state hr */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_update__region0_mode : {
									handle->historyVector[2] = handle->stateConfVector[0];
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state mode */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									{
										/* Exit action for state 'update'. */
										clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) );		
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_time : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state time */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_regular_date : {
									handle->historyVector[1] = handle->stateConfVector[0];
									{
										/* Default exit sequence for state date */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'date'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_displays__region0_wait : {
									{
										/* Default exit sequence for state wait */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
										{
											/* Exit action for state 'wait'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
										}
									}
									break;
								}
								default: break;
							}
							/* Handle exit of all possible states (of region0) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_displays__region0_regular_beep_test_beep_test_off : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								case clock_main_displays__region0_regular_beep_test_beep_test_beep : {
									handle->historyVector[3] = handle->stateConfVector[1];
									{
										/* Default exit sequence for state beep */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Entry action for state 'alarms-beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) , 30 * 1000, bool_false);
					}
					{
						/* Default enter sequence for state both beep */
						handle->stateConfVector[0] = clock_main_alarms_beep_r1_both_beep;
						handle->stateConfVectorPosition = 0;
					}
				}  else {
					if (handle->iface.c_r_raised) { 
						{
							/* Default exit sequence for state wait */
							handle->stateConfVector[0] = Clock_last_state;
							handle->stateConfVectorPosition = 0;
							{
								/* Exit action for state 'wait'. */
								clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
							}
						}
						{
							/* Default enter sequence for state time */
							handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
							handle->stateConfVectorPosition = 0;
						}
						{
							/* Default enter sequence for region beep-test */
							{
								/* Default react sequence for initial entry  */
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
									handle->stateConfVectorPosition = 1;
								}
							}
						}
					}  else {
						if (handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) { 
							{
								/* Default exit sequence for state wait */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'wait'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_wait_time_event_0_raised) );		
								}
							}
							{
								/* Entry action for state 'update'. */
								clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised) , 120 * 1000, bool_false);
							}
							{
								/* Default enter sequence for state sec */
								{
									/* Entry action for state 'sec'. */
									handle->ifaceClock.second = (handle->ifaceClock.time / 10) % 60;
								}
								handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_update__region0_sec;
								handle->stateConfVectorPosition = 0;
							}
							{
								/* Default enter sequence for region beep-test */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state off */
										handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
										handle->stateConfVectorPosition = 1;
									}
								}
							}
						} 
					}
				}
			}
		}
	}
}

/* The reactions of state alarm 1 beeps. */
static void clock_react_main_alarms_beep_r1_alarm_1_beeps(Clock* handle) {
	{
		/* The reactions of state alarm 1 beeps. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.d_p_raised || handle->iface.c_p_raised || handle->iface.b_p_raised || handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state alarms-beep */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_alarms_beep_r1_alarm_1_beeps : {
							{
								/* Default exit sequence for state alarm 1 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_alarm_2_beeps : {
							{
								/* Default exit sequence for state alarm 2 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_both_beep : {
							{
								/* Default exit sequence for state both beep */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
				{
					/* Exit action for state 'alarms-beep'. */
					clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
				}
			}
			{
				/* Default react sequence for deep history entry deep_entry */
				/* Enter the region with deep history */
				if (handle->historyVector[0] != Clock_last_state) {
					clock_deepentersequence_main_displays_region0(handle);
				} 
			}
		}  else {
			if (handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) { 
				{
					/* Default exit sequence for state alarms-beep */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_alarms_beep_r1_alarm_1_beeps : {
								{
									/* Default exit sequence for state alarm 1 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_alarm_2_beeps : {
								{
									/* Default exit sequence for state alarm 2 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_both_beep : {
								{
									/* Default exit sequence for state both beep */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
				}
				{
					/* Default react sequence for deep history entry deep_entry */
					/* Enter the region with deep history */
					if (handle->historyVector[0] != Clock_last_state) {
						clock_deepentersequence_main_displays_region0(handle);
					} 
				}
			}  else {
			}
		}
	}
}

/* The reactions of state alarm 2 beeps. */
static void clock_react_main_alarms_beep_r1_alarm_2_beeps(Clock* handle) {
	{
		/* The reactions of state alarm 2 beeps. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.d_p_raised || handle->iface.c_p_raised || handle->iface.b_p_raised || handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state alarms-beep */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_alarms_beep_r1_alarm_1_beeps : {
							{
								/* Default exit sequence for state alarm 1 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_alarm_2_beeps : {
							{
								/* Default exit sequence for state alarm 2 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_both_beep : {
							{
								/* Default exit sequence for state both beep */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
				{
					/* Exit action for state 'alarms-beep'. */
					clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
				}
			}
			{
				/* Default react sequence for deep history entry deep_entry */
				/* Enter the region with deep history */
				if (handle->historyVector[0] != Clock_last_state) {
					clock_deepentersequence_main_displays_region0(handle);
				} 
			}
		}  else {
			if (handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) { 
				{
					/* Default exit sequence for state alarms-beep */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_alarms_beep_r1_alarm_1_beeps : {
								{
									/* Default exit sequence for state alarm 1 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_alarm_2_beeps : {
								{
									/* Default exit sequence for state alarm 2 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_both_beep : {
								{
									/* Default exit sequence for state both beep */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
				}
				{
					/* Default react sequence for deep history entry deep_entry */
					/* Enter the region with deep history */
					if (handle->historyVector[0] != Clock_last_state) {
						clock_deepentersequence_main_displays_region0(handle);
					} 
				}
			}  else {
			}
		}
	}
}

/* The reactions of state both beep. */
static void clock_react_main_alarms_beep_r1_both_beep(Clock* handle) {
	{
		/* The reactions of state both beep. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.d_p_raised || handle->iface.c_p_raised || handle->iface.b_p_raised || handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state alarms-beep */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_alarms_beep_r1_alarm_1_beeps : {
							{
								/* Default exit sequence for state alarm 1 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_alarm_2_beeps : {
							{
								/* Default exit sequence for state alarm 2 beeps */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_alarms_beep_r1_both_beep : {
							{
								/* Default exit sequence for state both beep */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
				{
					/* Exit action for state 'alarms-beep'. */
					clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
				}
			}
			{
				/* Default react sequence for deep history entry deep_entry */
				/* Enter the region with deep history */
				if (handle->historyVector[0] != Clock_last_state) {
					clock_deepentersequence_main_displays_region0(handle);
				} 
			}
		}  else {
			if (handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) { 
				{
					/* Default exit sequence for state alarms-beep */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_alarms_beep_r1_alarm_1_beeps : {
								{
									/* Default exit sequence for state alarm 1 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_alarm_2_beeps : {
								{
									/* Default exit sequence for state alarm 2 beeps */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_alarms_beep_r1_both_beep : {
								{
									/* Default exit sequence for state both beep */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
					{
						/* Exit action for state 'alarms-beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_alarms_beep_time_event_0_raised) );		
					}
				}
				{
					/* Default react sequence for deep history entry deep_entry */
					/* Enter the region with deep history */
					if (handle->historyVector[0] != Clock_last_state) {
						clock_deepentersequence_main_displays_region0(handle);
					} 
				}
			}  else {
			}
		}
	}
}

/* The reactions of state zero. */
static void clock_react_main_stopwatch_r1_zero(Clock* handle) {
	{
		/* The reactions of state zero. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state stopwatch */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[4] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_stopwatch_r1_zero : {
							{
								/* Default exit sequence for state zero */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_regular : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state regular */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_lap : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state lap */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of r1) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_stopwatch_r1_display_run_run_on : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
								{
									/* Exit action for state 'on'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_run_off : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state displays */
				{
					/* Default enter sequence for region  */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state regular-beep-test */
							{
								/* Default enter sequence for region regular */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state time */
										handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
										handle->stateConfVectorPosition = 0;
									}
								}
							}
							{
								/* Default enter sequence for region beep-test */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state off */
										handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
										handle->stateConfVectorPosition = 1;
									}
								}
							}
						}
					}
				}
			}
		}  else {
			if (handle->iface.b_p_raised) { 
				{
					/* Default exit sequence for state zero */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state display-run */
					{
						/* Default enter sequence for region display */
						{
							/* Default react sequence for initial entry  */
							{
								/* Default enter sequence for state regular */
								handle->stateConfVector[0] = clock_main_stopwatch_r1_display_run_display_regular;
								handle->stateConfVectorPosition = 0;
							}
						}
					}
					{
						/* Default enter sequence for region run */
						{
							/* Default react sequence for initial entry  */
							{
								/* Default enter sequence for state on */
								{
									/* Entry action for state 'on'. */
									clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) , 100, bool_true);
								}
								handle->stateConfVector[1] = clock_main_stopwatch_r1_display_run_run_on;
								handle->stateConfVectorPosition = 1;
							}
						}
					}
				}
			} 
		}
	}
}

/* The reactions of state regular. */
static void clock_react_main_stopwatch_r1_display_run_display_regular(Clock* handle) {
	{
		/* The reactions of state regular. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state stopwatch */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[4] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_stopwatch_r1_zero : {
							{
								/* Default exit sequence for state zero */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_regular : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state regular */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_lap : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state lap */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of r1) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_stopwatch_r1_display_run_run_on : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
								{
									/* Exit action for state 'on'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_run_off : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state displays */
				{
					/* Default enter sequence for region  */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state regular-beep-test */
							{
								/* Default enter sequence for region regular */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state time */
										handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
										handle->stateConfVectorPosition = 0;
									}
								}
							}
							{
								/* Default enter sequence for region beep-test */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state off */
										handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
										handle->stateConfVectorPosition = 1;
									}
								}
							}
						}
					}
				}
			}
		}  else {
			if (clock_isActive(handle, clock_main_stopwatch_r1_display_run_run_on) && handle->iface.d_p_raised) { 
				{
					/* Default exit sequence for state regular */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state lap */
					{
						/* Entry action for state 'lap'. */
						handle->ifaceStopwatch.lap = handle->ifaceStopwatch.time - handle->internal.delta;
						handle->internal.delta = handle->ifaceStopwatch.time;
					}
					handle->stateConfVector[0] = clock_main_stopwatch_r1_display_run_display_lap;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (clock_isActive(handle, clock_main_stopwatch_r1_display_run_run_off) && handle->iface.d_p_raised) { 
					{
						/* Default exit sequence for state display-run */
						{
							/* Default exit sequence for region display */
							handle->historyVector[5] = handle->stateConfVector[0];
							/* Handle exit of all possible states (of display) at position 0... */
							switch(handle->stateConfVector[ 0 ]) {
								case clock_main_stopwatch_r1_display_run_display_regular : {
									{
										/* Default exit sequence for state regular */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								case clock_main_stopwatch_r1_display_run_display_lap : {
									{
										/* Default exit sequence for state lap */
										handle->stateConfVector[0] = Clock_last_state;
										handle->stateConfVectorPosition = 0;
									}
									break;
								}
								default: break;
							}
						}
						{
							/* Default exit sequence for region run */
							handle->historyVector[6] = handle->stateConfVector[1];
							/* Handle exit of all possible states (of run) at position 1... */
							switch(handle->stateConfVector[ 1 ]) {
								case clock_main_stopwatch_r1_display_run_run_on : {
									{
										/* Default exit sequence for state on */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
										{
											/* Exit action for state 'on'. */
											clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
										}
									}
									break;
								}
								case clock_main_stopwatch_r1_display_run_run_off : {
									{
										/* Default exit sequence for state off */
										handle->stateConfVector[1] = Clock_last_state;
										handle->stateConfVectorPosition = 1;
									}
									break;
								}
								default: break;
							}
						}
					}
					{
						/* Default enter sequence for state zero */
						{
							/* Entry action for state 'zero'. */
							handle->ifaceStopwatch.time = 0;
							handle->ifaceStopwatch.lap = 0;
							handle->internal.delta = 0;
						}
						handle->stateConfVector[0] = clock_main_stopwatch_r1_zero;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state lap. */
static void clock_react_main_stopwatch_r1_display_run_display_lap(Clock* handle) {
	{
		/* The reactions of state lap. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state stopwatch */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[4] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_stopwatch_r1_zero : {
							{
								/* Default exit sequence for state zero */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_regular : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state regular */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_display_lap : {
							handle->historyVector[5] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state lap */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
					/* Handle exit of all possible states (of r1) at position 1... */
					switch(handle->stateConfVector[ 1 ]) {
						case clock_main_stopwatch_r1_display_run_run_on : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
								{
									/* Exit action for state 'on'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
								}
							}
							break;
						}
						case clock_main_stopwatch_r1_display_run_run_off : {
							handle->historyVector[6] = handle->stateConfVector[1];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[1] = Clock_last_state;
								handle->stateConfVectorPosition = 1;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state displays */
				{
					/* Default enter sequence for region  */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state regular-beep-test */
							{
								/* Default enter sequence for region regular */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state time */
										handle->stateConfVector[0] = clock_main_displays__region0_regular_beep_test_regular_time;
										handle->stateConfVectorPosition = 0;
									}
								}
							}
							{
								/* Default enter sequence for region beep-test */
								{
									/* Default react sequence for initial entry  */
									{
										/* Default enter sequence for state off */
										handle->stateConfVector[1] = clock_main_displays__region0_regular_beep_test_beep_test_off;
										handle->stateConfVectorPosition = 1;
									}
								}
							}
						}
					}
				}
			}
		}  else {
			if (handle->iface.d_p_raised) { 
				{
					/* Default exit sequence for state lap */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state regular */
					handle->stateConfVector[0] = clock_main_stopwatch_r1_display_run_display_regular;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state on. */
static void clock_react_main_stopwatch_r1_display_run_run_on(Clock* handle) {
	{
		/* The reactions of state on. */
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state on */
				handle->stateConfVector[1] = Clock_last_state;
				handle->stateConfVectorPosition = 1;
				{
					/* Exit action for state 'on'. */
					clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) );		
				}
			}
			{
				/* Default enter sequence for state off */
				handle->stateConfVector[1] = clock_main_stopwatch_r1_display_run_run_off;
				handle->stateConfVectorPosition = 1;
			}
		}  else {
			if (handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) { 
				handle->ifaceStopwatch.time += 1;
			} 
		}
	}
}

/* The reactions of state off. */
static void clock_react_main_stopwatch_r1_display_run_run_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state off */
				handle->stateConfVector[1] = Clock_last_state;
				handle->stateConfVectorPosition = 1;
			}
			{
				/* Default enter sequence for state on */
				{
					/* Entry action for state 'on'. */
					clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised) , 100, bool_true);
				}
				handle->stateConfVector[1] = clock_main_stopwatch_r1_display_run_run_on;
				handle->stateConfVectorPosition = 1;
			}
		} 
	}
}

/* The reactions of state off. */
static void clock_react_main_settings_r1_alarm_1_r1_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.c_p_raised) { 
			{
				/* Default exit sequence for state alarm 1 */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[7] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_1_r1_off : {
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_1_r1_on : {
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state hr */
				{
					/* Entry action for state 'hr'. */
					handle->ifaceClock.hour = (handle->ifaceClock.al1_time / 36000) % 24;
				}
				handle->stateConfVector[0] = clock_main_settings_r1_update_1_r1_hr;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (handle->iface.a_p_raised) { 
				{
					/* Default exit sequence for state alarm 1 */
					{
						/* Default exit sequence for region r1 */
						handle->historyVector[7] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_alarm_1_r1_off : {
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_alarm_1_r1_on : {
								{
									/* Default exit sequence for state on */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Default enter sequence for state alarm 2 */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[8] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_alarm_2_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Default enter sequence for state on */
						handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_on;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state on. */
static void clock_react_main_settings_r1_alarm_1_r1_on(Clock* handle) {
	{
		/* The reactions of state on. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.c_p_raised) { 
			{
				/* Default exit sequence for state alarm 1 */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[7] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_1_r1_off : {
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_1_r1_on : {
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state hr */
				{
					/* Entry action for state 'hr'. */
					handle->ifaceClock.hour = (handle->ifaceClock.al1_time / 36000) % 24;
				}
				handle->stateConfVector[0] = clock_main_settings_r1_update_1_r1_hr;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (handle->iface.a_p_raised) { 
				{
					/* Default exit sequence for state alarm 1 */
					{
						/* Default exit sequence for region r1 */
						handle->historyVector[7] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_alarm_1_r1_off : {
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_alarm_1_r1_on : {
								{
									/* Default exit sequence for state on */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Default enter sequence for state alarm 2 */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[8] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_alarm_2_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Default enter sequence for state off */
						handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state hr. */
static void clock_react_main_settings_r1_update_1_r1_hr(Clock* handle) {
	{
		/* The reactions of state hr. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state update 1 */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_update_1_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state alarm 1 */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for shallow history entry  */
						/* Enter the region with shallow history */
						if (handle->historyVector[7] != Clock_last_state) {
							clock_shallowentersequence_main_settings_r1_alarm_1_r1(handle);
						} else {
							{
								/* Default enter sequence for state off */
								handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.c_p_raised) { 
				{
					/* Default exit sequence for state hr */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state min */
					{
						/* Entry action for state 'min'. */
						handle->ifaceClock.minute = (handle->ifaceClock.al1_time / 600) % 60;
					}
					handle->stateConfVector[0] = clock_main_settings_r1_update_1_r1_min;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					handle->ifaceClock.hour = ((handle->ifaceClock.hour + 1) % 24);
				} 
			}
		}
	}
}

/* The reactions of state min. */
static void clock_react_main_settings_r1_update_1_r1_min(Clock* handle) {
	{
		/* The reactions of state min. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state update 1 */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_update_1_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state alarm 1 */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for shallow history entry  */
						/* Enter the region with shallow history */
						if (handle->historyVector[7] != Clock_last_state) {
							clock_shallowentersequence_main_settings_r1_alarm_1_r1(handle);
						} else {
							{
								/* Default enter sequence for state off */
								handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.c_p_raised) { 
				{
					/* Default exit sequence for state update 1 */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_update_1_r1_hr : {
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_update_1_r1_min : {
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				handle->ifaceClock.al1_time = (3600 * handle->ifaceClock.hour + 60 * handle->ifaceClock.minute) * 10;
				{
					/* Default enter sequence for state alarm 1 */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[7] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_alarm_1_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_alarm_1_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					handle->ifaceClock.minute = ((handle->ifaceClock.minute + 1) % 60);
				} 
			}
		}
	}
}

/* The reactions of state hr. */
static void clock_react_main_settings_r1_update_2_r1_hr(Clock* handle) {
	{
		/* The reactions of state hr. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state update 2 */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_update_2_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state alarm 2 */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for shallow history entry  */
						/* Enter the region with shallow history */
						if (handle->historyVector[8] != Clock_last_state) {
							clock_shallowentersequence_main_settings_r1_alarm_2_r1(handle);
						} else {
							{
								/* Default enter sequence for state off */
								handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.c_p_raised) { 
				{
					/* Default exit sequence for state hr */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state min */
					{
						/* Entry action for state 'min'. */
						handle->ifaceClock.minute = (handle->ifaceClock.al2_time / 600) % 60;
					}
					handle->stateConfVector[0] = clock_main_settings_r1_update_2_r1_min;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					handle->ifaceClock.hour = ((handle->ifaceClock.hour + 1) % 24);
				} 
			}
		}
	}
}

/* The reactions of state min. */
static void clock_react_main_settings_r1_update_2_r1_min(Clock* handle) {
	{
		/* The reactions of state min. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state update 2 */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_update_2_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state alarm 2 */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for shallow history entry  */
						/* Enter the region with shallow history */
						if (handle->historyVector[8] != Clock_last_state) {
							clock_shallowentersequence_main_settings_r1_alarm_2_r1(handle);
						} else {
							{
								/* Default enter sequence for state off */
								handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.c_p_raised) { 
				{
					/* Default exit sequence for state update 2 */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_update_2_r1_hr : {
								{
									/* Default exit sequence for state hr */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_update_2_r1_min : {
								{
									/* Default exit sequence for state min */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				handle->ifaceClock.al2_time = (3600 * handle->ifaceClock.hour + 60 * handle->ifaceClock.minute) * 10;
				{
					/* Default enter sequence for state alarm 2 */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[8] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_alarm_2_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					handle->ifaceClock.minute = ((handle->ifaceClock.minute + 1) % 60);
				} 
			}
		}
	}
}

/* The reactions of state off. */
static void clock_react_main_settings_r1_alarm_2_r1_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.c_p_raised) { 
			{
				/* Default exit sequence for state alarm 2 */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[8] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_2_r1_off : {
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_on : {
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state hr */
				{
					/* Entry action for state 'hr'. */
					handle->ifaceClock.hour = (handle->ifaceClock.al2_time / 36000) % 24;
				}
				handle->stateConfVector[0] = clock_main_settings_r1_update_2_r1_hr;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (handle->iface.a_p_raised) { 
				{
					/* Default exit sequence for state alarm 2 */
					{
						/* Default exit sequence for region r1 */
						handle->historyVector[8] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_alarm_2_r1_off : {
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_alarm_2_r1_on : {
								{
									/* Default exit sequence for state on */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Default enter sequence for state chime */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[9] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_chime_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					{
						/* Default exit sequence for state off */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Default enter sequence for state on */
						handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_on;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state on. */
static void clock_react_main_settings_r1_alarm_2_r1_on(Clock* handle) {
	{
		/* The reactions of state on. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.c_p_raised) { 
			{
				/* Default exit sequence for state alarm 2 */
				{
					/* Default exit sequence for region r1 */
					handle->historyVector[8] = handle->stateConfVector[0];
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_2_r1_off : {
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_on : {
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state hr */
				{
					/* Entry action for state 'hr'. */
					handle->ifaceClock.hour = (handle->ifaceClock.al2_time / 36000) % 24;
				}
				handle->stateConfVector[0] = clock_main_settings_r1_update_2_r1_hr;
				handle->stateConfVectorPosition = 0;
			}
		}  else {
			if (handle->iface.a_p_raised) { 
				{
					/* Default exit sequence for state alarm 2 */
					{
						/* Default exit sequence for region r1 */
						handle->historyVector[8] = handle->stateConfVector[0];
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case clock_main_settings_r1_alarm_2_r1_off : {
								{
									/* Default exit sequence for state off */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							case clock_main_settings_r1_alarm_2_r1_on : {
								{
									/* Default exit sequence for state on */
									handle->stateConfVector[0] = Clock_last_state;
									handle->stateConfVectorPosition = 0;
								}
								break;
							}
							default: break;
						}
					}
				}
				{
					/* Default enter sequence for state chime */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for shallow history entry  */
							/* Enter the region with shallow history */
							if (handle->historyVector[9] != Clock_last_state) {
								clock_shallowentersequence_main_settings_r1_chime_r1(handle);
							} else {
								{
									/* Default enter sequence for state off */
									handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_off;
									handle->stateConfVectorPosition = 0;
								}
							} 
						}
					}
				}
			}  else {
				if (handle->iface.d_p_raised) { 
					{
						/* Default exit sequence for state on */
						handle->stateConfVector[0] = Clock_last_state;
						handle->stateConfVectorPosition = 0;
					}
					{
						/* Default enter sequence for state off */
						handle->stateConfVector[0] = clock_main_settings_r1_alarm_2_r1_off;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state off. */
static void clock_react_main_settings_r1_chime_r1_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state settings */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_1_r1_off : {
							handle->historyVector[7] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_1_r1_on : {
							handle->historyVector[7] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_off : {
							handle->historyVector[8] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_on : {
							handle->historyVector[8] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_chime_r1_off : {
							handle->historyVector[9] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_chime_r1_on : {
							handle->historyVector[9] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state stopwatch */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for deep history entry  */
						/* Enter the region with deep history */
						if (handle->historyVector[4] != Clock_last_state) {
							clock_deepentersequence_main_stopwatch_r1(handle);
						} else {
							{
								/* Default enter sequence for state zero */
								{
									/* Entry action for state 'zero'. */
									handle->ifaceStopwatch.time = 0;
									handle->ifaceStopwatch.lap = 0;
									handle->internal.delta = 0;
								}
								handle->stateConfVector[0] = clock_main_stopwatch_r1_zero;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.d_p_raised) { 
				{
					/* Default exit sequence for state off */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state on */
					handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_on;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state on. */
static void clock_react_main_settings_r1_chime_r1_on(Clock* handle) {
	{
		/* The reactions of state on. */
		if (clock_check_lr0(handle)) { 
			clock_effect_lr0(handle);
		} 
		if (clock_check_lr1(handle)) { 
			clock_effect_lr1(handle);
		} 
		clock_effect_lr2(handle);
		if (handle->iface.a_p_raised) { 
			{
				/* Default exit sequence for state settings */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case clock_main_settings_r1_alarm_1_r1_off : {
							handle->historyVector[7] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_1_r1_on : {
							handle->historyVector[7] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_1_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_hr : {
							{
								/* Default exit sequence for state hr */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_update_2_r1_min : {
							{
								/* Default exit sequence for state min */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_off : {
							handle->historyVector[8] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_alarm_2_r1_on : {
							handle->historyVector[8] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_chime_r1_off : {
							handle->historyVector[9] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state off */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case clock_main_settings_r1_chime_r1_on : {
							handle->historyVector[9] = handle->stateConfVector[0];
							{
								/* Default exit sequence for state on */
								handle->stateConfVector[0] = Clock_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state stopwatch */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for deep history entry  */
						/* Enter the region with deep history */
						if (handle->historyVector[4] != Clock_last_state) {
							clock_deepentersequence_main_stopwatch_r1(handle);
						} else {
							{
								/* Default enter sequence for state zero */
								{
									/* Entry action for state 'zero'. */
									handle->ifaceStopwatch.time = 0;
									handle->ifaceStopwatch.lap = 0;
									handle->internal.delta = 0;
								}
								handle->stateConfVector[0] = clock_main_stopwatch_r1_zero;
								handle->stateConfVectorPosition = 0;
							}
						} 
					}
				}
			}
		}  else {
			if (handle->iface.d_p_raised) { 
				{
					/* Default exit sequence for state on */
					handle->stateConfVector[0] = Clock_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state off */
					handle->stateConfVector[0] = clock_main_settings_r1_chime_r1_off;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state disabled. */
static void clock_react_alarm_1_disabled(Clock* handle) {
	{
		/* The reactions of state disabled. */
		if (clock_isActive(handle, clock_main_settings_r1_alarm_1_r1_on)) { 
			{
				/* Default exit sequence for state disabled */
				handle->stateConfVector[2] = Clock_last_state;
				handle->stateConfVectorPosition = 2;
			}
			{
				/* Default enter sequence for state enabled */
				handle->stateConfVector[2] = clock_alarm_1_enabled;
				handle->stateConfVectorPosition = 2;
			}
		} 
	}
}

/* The reactions of state enabled. */
static void clock_react_alarm_1_enabled(Clock* handle) {
	{
		/* The reactions of state enabled. */
		if (clock_isActive(handle, clock_main_settings_r1_alarm_1_r1_off)) { 
			{
				/* Default exit sequence for state enabled */
				handle->stateConfVector[2] = Clock_last_state;
				handle->stateConfVectorPosition = 2;
			}
			{
				/* Default enter sequence for state disabled */
				handle->stateConfVector[2] = clock_alarm_1_disabled;
				handle->stateConfVectorPosition = 2;
			}
		} 
	}
}

/* The reactions of state disabled. */
static void clock_react_alarm_2_disabled(Clock* handle) {
	{
		/* The reactions of state disabled. */
		if (clock_isActive(handle, clock_main_settings_r1_alarm_2_r1_on)) { 
			{
				/* Default exit sequence for state disabled */
				handle->stateConfVector[3] = Clock_last_state;
				handle->stateConfVectorPosition = 3;
			}
			{
				/* Default enter sequence for state enabled */
				handle->stateConfVector[3] = clock_alarm_2_enabled;
				handle->stateConfVectorPosition = 3;
			}
		} 
	}
}

/* The reactions of state enabled. */
static void clock_react_alarm_2_enabled(Clock* handle) {
	{
		/* The reactions of state enabled. */
		if (clock_isActive(handle, clock_main_settings_r1_alarm_2_r1_off)) { 
			{
				/* Default exit sequence for state enabled */
				handle->stateConfVector[3] = Clock_last_state;
				handle->stateConfVectorPosition = 3;
			}
			{
				/* Default enter sequence for state disabled */
				handle->stateConfVector[3] = clock_alarm_2_disabled;
				handle->stateConfVectorPosition = 3;
			}
		} 
	}
}

/* The reactions of state disabled. */
static void clock_react_chime___status_disabled(Clock* handle) {
	{
		/* The reactions of state disabled. */
		if (clock_isActive(handle, clock_main_settings_r1_chime_r1_off) && handle->iface.d_p_raised) { 
			{
				/* Default exit sequence for state disabled */
				handle->stateConfVector[4] = Clock_last_state;
				handle->stateConfVectorPosition = 4;
			}
			{
				/* Default enter sequence for state quiet */
				handle->stateConfVector[4] = clock_chime___status_enabled_r1_quiet;
				handle->stateConfVectorPosition = 4;
			}
		} 
	}
}

/* The reactions of state quiet. */
static void clock_react_chime___status_enabled_r1_quiet(Clock* handle) {
	{
		/* The reactions of state quiet. */
		if (clock_isActive(handle, clock_main_settings_r1_chime_r1_on) && handle->iface.d_p_raised) { 
			{
				/* Default exit sequence for state enabled */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 4... */
					switch(handle->stateConfVector[ 4 ]) {
						case clock_chime___status_enabled_r1_quiet : {
							{
								/* Default exit sequence for state quiet */
								handle->stateConfVector[4] = Clock_last_state;
								handle->stateConfVectorPosition = 4;
							}
							break;
						}
						case clock_chime___status_enabled_r1_beep : {
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[4] = Clock_last_state;
								handle->stateConfVectorPosition = 4;
								{
									/* Exit action for state 'beep'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state disabled */
				handle->stateConfVector[4] = clock_chime___status_disabled;
				handle->stateConfVectorPosition = 4;
			}
		}  else {
			if (handle->ifaceClock.time % 36000 == 0) { 
				{
					/* Default exit sequence for state quiet */
					handle->stateConfVector[4] = Clock_last_state;
					handle->stateConfVectorPosition = 4;
				}
				{
					/* Default enter sequence for state beep */
					{
						/* Entry action for state 'beep'. */
						clock_setTimer( (sc_eventid) &(handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) , 2 * 1000, bool_false);
					}
					handle->stateConfVector[4] = clock_chime___status_enabled_r1_beep;
					handle->stateConfVectorPosition = 4;
				}
			} 
		}
	}
}

/* The reactions of state beep. */
static void clock_react_chime___status_enabled_r1_beep(Clock* handle) {
	{
		/* The reactions of state beep. */
		if (clock_isActive(handle, clock_main_settings_r1_chime_r1_on) && handle->iface.d_p_raised) { 
			{
				/* Default exit sequence for state enabled */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 4... */
					switch(handle->stateConfVector[ 4 ]) {
						case clock_chime___status_enabled_r1_quiet : {
							{
								/* Default exit sequence for state quiet */
								handle->stateConfVector[4] = Clock_last_state;
								handle->stateConfVectorPosition = 4;
							}
							break;
						}
						case clock_chime___status_enabled_r1_beep : {
							{
								/* Default exit sequence for state beep */
								handle->stateConfVector[4] = Clock_last_state;
								handle->stateConfVectorPosition = 4;
								{
									/* Exit action for state 'beep'. */
									clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state disabled */
				handle->stateConfVector[4] = clock_chime___status_disabled;
				handle->stateConfVectorPosition = 4;
			}
		}  else {
			if (handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) { 
				{
					/* Default exit sequence for state beep */
					handle->stateConfVector[4] = Clock_last_state;
					handle->stateConfVectorPosition = 4;
					{
						/* Exit action for state 'beep'. */
						clock_unsetTimer( (sc_eventid) &(handle->timeEvents.clock_chime___status_enabled_r1_beep_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state quiet */
					handle->stateConfVector[4] = clock_chime___status_enabled_r1_quiet;
					handle->stateConfVectorPosition = 4;
				}
			} 
		}
	}
}

/* The reactions of state off. */
static void clock_react_light_off(Clock* handle) {
	{
		/* The reactions of state off. */
		if (handle->iface.b_p_raised) { 
			{
				/* Default exit sequence for state off */
				handle->stateConfVector[5] = Clock_last_state;
				handle->stateConfVectorPosition = 5;
			}
			{
				/* Default enter sequence for state on */
				handle->stateConfVector[5] = clock_light_on;
				handle->stateConfVectorPosition = 5;
			}
		} 
	}
}

/* The reactions of state on. */
static void clock_react_light_on(Clock* handle) {
	{
		/* The reactions of state on. */
		if (handle->iface.b_r_raised) { 
			{
				/* Default exit sequence for state on */
				handle->stateConfVector[5] = Clock_last_state;
				handle->stateConfVectorPosition = 5;
			}
			{
				/* Default enter sequence for state off */
				handle->stateConfVector[5] = clock_light_off;
				handle->stateConfVectorPosition = 5;
			}
		} 
	}
}

/* The reactions of state ok. */
static void clock_react_power_ok(Clock* handle) {
	{
		/* The reactions of state ok. */
		if (handle->ifaceBattery.low_raised) { 
			{
				/* Default exit sequence for state ok */
				handle->stateConfVector[6] = Clock_last_state;
				handle->stateConfVectorPosition = 6;
			}
			{
				/* Default enter sequence for state blink */
				handle->stateConfVector[6] = clock_power_blink;
				handle->stateConfVectorPosition = 6;
			}
		}  else {
			if (handle->ifaceBattery.energy < handle->ifaceBattery.min_energy && bool_true) { 
				handle->ifaceBattery.low_raised = bool_true;
			} 
		}
	}
}

/* The reactions of state blink. */
static void clock_react_power_blink(Clock* handle) {
	{
		/* The reactions of state blink. */
		if (handle->ifaceBattery.replace_raised) { 
			{
				/* Default exit sequence for state blink */
				handle->stateConfVector[6] = Clock_last_state;
				handle->stateConfVectorPosition = 6;
			}
			handle->ifaceBattery.energy = handle->ifaceBattery.max_energy;
			{
				/* Default enter sequence for state ok */
				handle->stateConfVector[6] = clock_power_ok;
				handle->stateConfVectorPosition = 6;
			}
		} 
	}
}


