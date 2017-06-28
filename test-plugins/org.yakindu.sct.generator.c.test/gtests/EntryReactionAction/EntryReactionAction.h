
#ifndef ENTRYREACTIONACTION_H_
#define ENTRYREACTIONACTION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'EntryReactionAction'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	EntryReactionAction_last_state,
	EntryReactionAction_EntryReactionAction_r2_B,
	EntryReactionAction_EntryReactionAction_r2_B_r_BA,
	EntryReactionAction_EntryReactionAction_r2_B_r_BB,
	EntryReactionAction_EntryReactionAction_r2_D,
	EntryReactionAction_EntryReactionAction_r1_A
} EntryReactionActionStates;

/*! Type definition of the data structure for the EntryReactionActionIface interface scope. */
typedef struct
{
	sc_boolean enteredR1;
	sc_boolean enteredR2;
	sc_boolean enteredBdefault;
	sc_boolean enteredBother;
	sc_boolean b_raised;
	sc_boolean d_raised;
} EntryReactionActionIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ENTRYREACTIONACTION_MAX_ORTHOGONAL_STATES 2
	/*! Define dimension of the state configuration vector for history states. */
#define ENTRYREACTIONACTION_MAX_HISTORY_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_ENTRYREACTIONACTION_ENTRYREACTIONACTION_R2_B 0
#define SCVI_ENTRYREACTIONACTION_ENTRYREACTIONACTION_R2_B_R_BA 0
#define SCVI_ENTRYREACTIONACTION_ENTRYREACTIONACTION_R2_B_R_BB 0
#define SCVI_ENTRYREACTIONACTION_ENTRYREACTIONACTION_R2_D 0
#define SCVI_ENTRYREACTIONACTION_ENTRYREACTIONACTION_R1_A 1

/*! 
 * Type definition of the data structure for the EntryReactionAction state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	EntryReactionActionStates stateConfVector[ENTRYREACTIONACTION_MAX_ORTHOGONAL_STATES];
	EntryReactionActionStates historyVector[ENTRYREACTIONACTION_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	EntryReactionActionIface iface;
} EntryReactionAction;

/*! Initializes the EntryReactionAction state machine data structures. Must be called before first usage.*/
extern void entryReactionAction_init(EntryReactionAction* handle);

/*! Activates the state machine */
extern void entryReactionAction_enter(EntryReactionAction* handle);

/*! Deactivates the state machine */
extern void entryReactionAction_exit(EntryReactionAction* handle);

/*! Performs a 'run to completion' step. */
extern void entryReactionAction_runCycle(EntryReactionAction* handle);


/*! Gets the value of the variable 'enteredR1' that is defined in the default interface scope. */ 
extern sc_boolean entryReactionActionIface_get_enteredR1(const EntryReactionAction* handle);
/*! Sets the value of the variable 'enteredR1' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_set_enteredR1(EntryReactionAction* handle, sc_boolean value);
/*! Gets the value of the variable 'enteredR2' that is defined in the default interface scope. */ 
extern sc_boolean entryReactionActionIface_get_enteredR2(const EntryReactionAction* handle);
/*! Sets the value of the variable 'enteredR2' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_set_enteredR2(EntryReactionAction* handle, sc_boolean value);
/*! Gets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */ 
extern sc_boolean entryReactionActionIface_get_enteredBdefault(const EntryReactionAction* handle);
/*! Sets the value of the variable 'enteredBdefault' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_set_enteredBdefault(EntryReactionAction* handle, sc_boolean value);
/*! Gets the value of the variable 'enteredBother' that is defined in the default interface scope. */ 
extern sc_boolean entryReactionActionIface_get_enteredBother(const EntryReactionAction* handle);
/*! Sets the value of the variable 'enteredBother' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_set_enteredBother(EntryReactionAction* handle, sc_boolean value);
/*! Raises the in event 'b' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_raise_b(EntryReactionAction* handle);

/*! Raises the in event 'd' that is defined in the default interface scope. */ 
extern void entryReactionActionIface_raise_d(EntryReactionAction* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean entryReactionAction_isActive(const EntryReactionAction* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean entryReactionAction_isFinal(const EntryReactionAction* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean entryReactionAction_isStateActive(const EntryReactionAction* handle, EntryReactionActionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ENTRYREACTIONACTION_H_ */
