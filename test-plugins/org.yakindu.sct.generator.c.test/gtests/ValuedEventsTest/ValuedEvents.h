
#ifndef VALUEDEVENTS_H_
#define VALUEDEVENTS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ValuedEvents'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ValuedEvents_main_region1_A,
	ValuedEvents_integer_region_B,
	ValuedEvents_integer_region_C,
	ValuedEvents_integer_region_D,
	ValuedEvents_boolean_region_B,
	ValuedEvents_boolean_region_C,
	ValuedEvents_boolean_region_D,
	ValuedEvents_real_region_B,
	ValuedEvents_real_region_C,
	ValuedEvents_real_region_D,
	ValuedEvents_string_region_B,
	ValuedEvents_string_region_C,
	ValuedEvents_string_region_D,
	ValuedEvents_last_state
} ValuedEventsStates;

/*! Type definition of the data structure for the ValuedEventsIface interface scope. */
typedef struct
{
	sc_boolean integerEvent_raised;
	sc_integer integerEvent_value;
	sc_integer myInt;
	sc_boolean booleanEvent_raised;
	sc_boolean booleanEvent_value;
	sc_boolean myBool;
	sc_boolean realEvent_raised;
	sc_real realEvent_value;
	sc_real myReal;
	sc_boolean stringEvent_raised;
	sc_string stringEvent_value;
	sc_string myString;
} ValuedEventsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define VALUEDEVENTS_MAX_ORTHOGONAL_STATES 5

/*! 
 * Type definition of the data structure for the ValuedEvents state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ValuedEventsStates stateConfVector[VALUEDEVENTS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ValuedEventsIface iface;
} ValuedEvents;

/*! Initializes the ValuedEvents state machine data structures. Must be called before first usage.*/
extern void valuedEvents_init(ValuedEvents* handle);

/*! Activates the state machine */
extern void valuedEvents_enter(ValuedEvents* handle);

/*! Deactivates the state machine */
extern void valuedEvents_exit(ValuedEvents* handle);

/*! Performs a 'run to completion' step. */
extern void valuedEvents_runCycle(ValuedEvents* handle);


/*! Raises the in event 'integerEvent' that is defined in the default interface scope. */ 
extern void valuedEventsIface_raise_integerEvent(ValuedEvents* handle, sc_integer value);

/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */ 
extern sc_integer valuedEventsIface_get_myInt(const ValuedEvents* handle);
/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */ 
extern void valuedEventsIface_set_myInt(ValuedEvents* handle, sc_integer value);
/*! Raises the in event 'booleanEvent' that is defined in the default interface scope. */ 
extern void valuedEventsIface_raise_booleanEvent(ValuedEvents* handle, sc_boolean value);

/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */ 
extern sc_boolean valuedEventsIface_get_myBool(const ValuedEvents* handle);
/*! Sets the value of the variable 'myBool' that is defined in the default interface scope. */ 
extern void valuedEventsIface_set_myBool(ValuedEvents* handle, sc_boolean value);
/*! Raises the in event 'realEvent' that is defined in the default interface scope. */ 
extern void valuedEventsIface_raise_realEvent(ValuedEvents* handle, sc_real value);

/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */ 
extern sc_real valuedEventsIface_get_myReal(const ValuedEvents* handle);
/*! Sets the value of the variable 'myReal' that is defined in the default interface scope. */ 
extern void valuedEventsIface_set_myReal(ValuedEvents* handle, sc_real value);
/*! Raises the in event 'stringEvent' that is defined in the default interface scope. */ 
extern void valuedEventsIface_raise_stringEvent(ValuedEvents* handle, sc_string value);

/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */ 
extern sc_string valuedEventsIface_get_myString(const ValuedEvents* handle);
/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */ 
extern void valuedEventsIface_set_myString(ValuedEvents* handle, sc_string value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean valuedEvents_isActive(const ValuedEvents* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean valuedEvents_isFinal(const ValuedEvents* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean valuedEvents_isStateActive(const ValuedEvents* handle, ValuedEventsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* VALUEDEVENTS_H_ */
