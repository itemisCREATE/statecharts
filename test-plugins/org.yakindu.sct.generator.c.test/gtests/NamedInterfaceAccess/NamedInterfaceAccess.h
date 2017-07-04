
#ifndef NAMEDINTERFACEACCESS_H_
#define NAMEDINTERFACEACCESS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'NamedInterfaceAccess'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	NamedInterfaceAccess_last_state,
	NamedInterfaceAccess_region_1_Idle,
	NamedInterfaceAccess_region_1_Number1Pressed,
	NamedInterfaceAccess_region_1_Number2Pressed,
	NamedInterfaceAccess_region_1_Number3Pressed,
	NamedInterfaceAccess__region1_Closed,
	NamedInterfaceAccess__region1_Open
} NamedInterfaceAccessStates;

/*! Type definition of the data structure for the NamedInterfaceAccessIfaceSafe interface scope. */
typedef struct
{
	sc_boolean open_raised;
	sc_boolean close_raised;
} NamedInterfaceAccessIfaceSafe;

/*! Type definition of the data structure for the NamedInterfaceAccessIfaceUser interface scope. */
typedef struct
{
	sc_boolean numberPressed_raised;
	sc_integer numberPressed_value;
	sc_boolean reset_raised;
} NamedInterfaceAccessIfaceUser;

/*! Type definition of the data structure for the NamedInterfaceAccessInternal interface scope. */
typedef struct
{
	sc_integer number1;
	sc_integer number2;
	sc_integer number3;
} NamedInterfaceAccessInternal;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define NAMEDINTERFACEACCESS_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_NAMEDINTERFACEACCESS_REGION_1_IDLE 0
#define SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER1PRESSED 0
#define SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER2PRESSED 0
#define SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER3PRESSED 0
#define SCVI_NAMEDINTERFACEACCESS__REGION1_CLOSED 1
#define SCVI_NAMEDINTERFACEACCESS__REGION1_OPEN 1

/*! 
 * Type definition of the data structure for the NamedInterfaceAccess state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	NamedInterfaceAccessStates stateConfVector[NAMEDINTERFACEACCESS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	NamedInterfaceAccessIfaceSafe ifaceSafe;
	NamedInterfaceAccessIfaceUser ifaceUser;
	NamedInterfaceAccessInternal internal;
} NamedInterfaceAccess;

/*! Initializes the NamedInterfaceAccess state machine data structures. Must be called before first usage.*/
extern void namedInterfaceAccess_init(NamedInterfaceAccess* handle);

/*! Activates the state machine */
extern void namedInterfaceAccess_enter(NamedInterfaceAccess* handle);

/*! Deactivates the state machine */
extern void namedInterfaceAccess_exit(NamedInterfaceAccess* handle);

/*! Performs a 'run to completion' step. */
extern void namedInterfaceAccess_runCycle(NamedInterfaceAccess* handle);


/*! Checks if the out event 'open' that is defined in the interface scope 'Safe' has been raised. */ 
extern sc_boolean namedInterfaceAccessIfaceSafe_israised_open(const NamedInterfaceAccess* handle);

/*! Checks if the out event 'close' that is defined in the interface scope 'Safe' has been raised. */ 
extern sc_boolean namedInterfaceAccessIfaceSafe_israised_close(const NamedInterfaceAccess* handle);

/*! Raises the in event 'numberPressed' that is defined in the interface scope 'User'. */ 
extern void namedInterfaceAccessIfaceUser_raise_numberPressed(NamedInterfaceAccess* handle, sc_integer value);

/*! Raises the in event 'reset' that is defined in the interface scope 'User'. */ 
extern void namedInterfaceAccessIfaceUser_raise_reset(NamedInterfaceAccess* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean namedInterfaceAccess_isActive(const NamedInterfaceAccess* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean namedInterfaceAccess_isFinal(const NamedInterfaceAccess* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean namedInterfaceAccess_isStateActive(const NamedInterfaceAccess* handle, NamedInterfaceAccessStates state);

#ifdef __cplusplus
}
#endif 

#endif /* NAMEDINTERFACEACCESS_H_ */
