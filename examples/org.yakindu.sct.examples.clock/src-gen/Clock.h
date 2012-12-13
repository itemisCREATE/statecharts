#ifndef CLOCK_H_
#define CLOCK_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'clock'.
*/

//! enumeration of all states 
typedef enum {
	clock_main_displays ,
	clock_main_displays__region0_regular_beep_test ,
	clock_main_displays__region0_regular_beep_test_regular_update ,
	clock_main_displays__region0_regular_beep_test_regular_update__region0_sec ,
	clock_main_displays__region0_regular_beep_test_regular_update__region0_min ,
	clock_main_displays__region0_regular_beep_test_regular_update__region0_hr ,
	clock_main_displays__region0_regular_beep_test_regular_update__region0_mode ,
	clock_main_displays__region0_regular_beep_test_regular_time ,
	clock_main_displays__region0_regular_beep_test_regular_date ,
	clock_main_displays__region0_regular_beep_test_beep_test_off ,
	clock_main_displays__region0_regular_beep_test_beep_test_beep ,
	clock_main_displays__region0_wait ,
	clock_main_alarms_beep ,
	clock_main_alarms_beep_r1_alarm_1_beeps ,
	clock_main_alarms_beep_r1_alarm_2_beeps ,
	clock_main_alarms_beep_r1_both_beep ,
	clock_main_stopwatch ,
	clock_main_stopwatch_r1_zero ,
	clock_main_stopwatch_r1_display_run ,
	clock_main_stopwatch_r1_display_run_display_regular ,
	clock_main_stopwatch_r1_display_run_display_lap ,
	clock_main_stopwatch_r1_display_run_run_on ,
	clock_main_stopwatch_r1_display_run_run_off ,
	clock_main_settings ,
	clock_main_settings_r1_alarm_1 ,
	clock_main_settings_r1_alarm_1_r1_off ,
	clock_main_settings_r1_alarm_1_r1_on ,
	clock_main_settings_r1_update_1 ,
	clock_main_settings_r1_update_1_r1_hr ,
	clock_main_settings_r1_update_1_r1_min ,
	clock_main_settings_r1_update_2 ,
	clock_main_settings_r1_update_2_r1_hr ,
	clock_main_settings_r1_update_2_r1_min ,
	clock_main_settings_r1_alarm_2 ,
	clock_main_settings_r1_alarm_2_r1_off ,
	clock_main_settings_r1_alarm_2_r1_on ,
	clock_main_settings_r1_chime ,
	clock_main_settings_r1_chime_r1_off ,
	clock_main_settings_r1_chime_r1_on ,
	clock_alarm_1_disabled ,
	clock_alarm_1_enabled ,
	clock_alarm_2_disabled ,
	clock_alarm_2_enabled ,
	clock_chime___status_disabled ,
	clock_chime___status_enabled ,
	clock_chime___status_enabled_r1_quiet ,
	clock_chime___status_enabled_r1_beep ,
	clock_light_off ,
	clock_light_on ,
	clock_power_ok ,
	clock_power_blink ,
	Clock_last_state
} ClockStates;

//! Type definition of the data structure for the ClockIface interface scope.
typedef struct {
	sc_boolean a_p_raised;
	sc_boolean b_p_raised;
	sc_boolean b_r_raised;
	sc_boolean c_p_raised;
	sc_boolean c_r_raised;
	sc_boolean d_p_raised;
	sc_boolean d_r_raised;
} ClockIface;

//! Type definition of the data structure for the ClockIfaceClock interface scope.
typedef struct {
	sc_integer  second;
	sc_integer  minute;
	sc_integer  hour;
	sc_integer  time;
	sc_integer  al1_time;
	sc_integer  al2_time;
} ClockIfaceClock;

//! Type definition of the data structure for the ClockIfaceStopwatch interface scope.
typedef struct {
	sc_integer  time;
	sc_integer  lap;
} ClockIfaceStopwatch;

//! Type definition of the data structure for the ClockIfaceBattery interface scope.
typedef struct {
	sc_boolean low_raised;
	sc_boolean replace_raised;
	sc_integer  max_energy;
	sc_real  min_energy;
	sc_integer  energy;
} ClockIfaceBattery;

//! Type definition of the data structure for the ClockInternal interface scope.
typedef struct {
	sc_integer  delta;
} ClockInternal;

//! Type definition of the data structure for the ClockTimeEvents interface scope.
typedef struct {
	sc_boolean clock_main_displays__region0_regular_beep_test_regular_update_time_event_0_raised;
	sc_boolean clock_main_displays__region0_regular_beep_test_regular_date_time_event_0_raised;
	sc_boolean clock_main_displays__region0_wait_time_event_0_raised;
	sc_boolean clock_main_alarms_beep_time_event_0_raised;
	sc_boolean clock_main_stopwatch_r1_display_run_run_on_time_event_0_raised;
	sc_boolean clock_chime___status_enabled_r1_beep_time_event_0_raised;
	sc_boolean clock_time_event_0_raised;
} ClockTimeEvents;


//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
#define CLOCK_MAX_ORTHOGONAL_STATES 7
//! dimension of the state configuration vector for history states
#define CLOCK_MAX_HISTORY_STATES 10

/*! Type definition of the data structure for the Clock state machine.
This data structure has to be allocated by the client code. */
typedef struct {
	ClockStates stateConfVector[CLOCK_MAX_ORTHOGONAL_STATES];
	ClockStates historyVector[CLOCK_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ClockIface iface;
	ClockIfaceClock ifaceClock;
	ClockIfaceStopwatch ifaceStopwatch;
	ClockIfaceBattery ifaceBattery;
	ClockInternal internal;
	ClockTimeEvents timeEvents;
} Clock;

/*! Initializes the Clock state machine data structures. Must be called before first usage.*/
extern void clock_init(Clock* handle);

/*! Activates the state machine */
extern void clock_enter(Clock* handle);

/*! Deactivates the state machine */
extern void clock_exit(Clock* handle);

/*! Performs a 'run to completion' step. */
extern void clock_runCycle(Clock* handle);

/*! Raises a time event. */
extern void clock_raiseTimeEvent(Clock* handle, sc_eventid evid);

/*! Raises the in event 'a_p' that is defined in the default interface scope. */ 
extern void clockIface_raise_a_p(Clock* handle);

/*! Raises the in event 'b_p' that is defined in the default interface scope. */ 
extern void clockIface_raise_b_p(Clock* handle);

/*! Raises the in event 'b_r' that is defined in the default interface scope. */ 
extern void clockIface_raise_b_r(Clock* handle);

/*! Raises the in event 'c_p' that is defined in the default interface scope. */ 
extern void clockIface_raise_c_p(Clock* handle);

/*! Raises the in event 'c_r' that is defined in the default interface scope. */ 
extern void clockIface_raise_c_r(Clock* handle);

/*! Raises the in event 'd_p' that is defined in the default interface scope. */ 
extern void clockIface_raise_d_p(Clock* handle);

/*! Raises the in event 'd_r' that is defined in the default interface scope. */ 
extern void clockIface_raise_d_r(Clock* handle);


/*! Gets the value of the variable 'second' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_second(Clock* handle);
/*! Gets the value of the variable 'minute' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_minute(Clock* handle);
/*! Sets the value of the variable 'minute' that is defined in the interface scope 'clock'. */ 
extern void clockIfaceClock_set_minute(Clock* handle, sc_integer value);
/*! Gets the value of the variable 'hour' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_hour(Clock* handle);
/*! Sets the value of the variable 'hour' that is defined in the interface scope 'clock'. */ 
extern void clockIfaceClock_set_hour(Clock* handle, sc_integer value);
/*! Gets the value of the variable 'time' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_time(Clock* handle);
/*! Sets the value of the variable 'time' that is defined in the interface scope 'clock'. */ 
extern void clockIfaceClock_set_time(Clock* handle, sc_integer value);
/*! Gets the value of the variable 'al1_time' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_al1_time(Clock* handle);
/*! Sets the value of the variable 'al1_time' that is defined in the interface scope 'clock'. */ 
extern void clockIfaceClock_set_al1_time(Clock* handle, sc_integer value);
/*! Gets the value of the variable 'al2_time' that is defined in the interface scope 'clock'. */ 
extern sc_integer clockIfaceClock_get_al2_time(Clock* handle);
/*! Sets the value of the variable 'al2_time' that is defined in the interface scope 'clock'. */ 
extern void clockIfaceClock_set_al2_time(Clock* handle, sc_integer value);

/*! Gets the value of the variable 'time' that is defined in the interface scope 'stopwatch'. */ 
extern sc_integer clockIfaceStopwatch_get_time(Clock* handle);
/*! Sets the value of the variable 'time' that is defined in the interface scope 'stopwatch'. */ 
extern void clockIfaceStopwatch_set_time(Clock* handle, sc_integer value);
/*! Gets the value of the variable 'lap' that is defined in the interface scope 'stopwatch'. */ 
extern sc_integer clockIfaceStopwatch_get_lap(Clock* handle);
/*! Sets the value of the variable 'lap' that is defined in the interface scope 'stopwatch'. */ 
extern void clockIfaceStopwatch_set_lap(Clock* handle, sc_integer value);

/*! Raises the in event 'low' that is defined in the interface scope 'battery'. */ 
extern void clockIfaceBattery_raise_low(Clock* handle);

/*! Raises the in event 'replace' that is defined in the interface scope 'battery'. */ 
extern void clockIfaceBattery_raise_replace(Clock* handle);

/*! Gets the value of the variable 'max_energy' that is defined in the interface scope 'battery'. */ 
extern sc_integer clockIfaceBattery_get_max_energy(Clock* handle);
/*! Gets the value of the variable 'min_energy' that is defined in the interface scope 'battery'. */ 
extern sc_real clockIfaceBattery_get_min_energy(Clock* handle);
/*! Gets the value of the variable 'energy' that is defined in the interface scope 'battery'. */ 
extern sc_integer clockIfaceBattery_get_energy(Clock* handle);
/*! Sets the value of the variable 'energy' that is defined in the interface scope 'battery'. */ 
extern void clockIfaceBattery_set_energy(Clock* handle, sc_integer value);


/*! Checks if the specified state is active. */
extern sc_boolean clock_isActive(Clock* handle, ClockStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CLOCK_H_ */
