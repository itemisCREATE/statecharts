status | type
------ | ----
_DEFINED_ | _functional_

---
If an exception occurs during the interpretation of a state machine then this exceptions must be handled. 

#### Discussion
Excpetions during simulation may be caused due ti different reasons. First user implemented callbacks may fail or a bug in the statechart
tools itself may cause an error. In any case the error must be handled in a way that is controllable by the user. 
In any case the current simulation must be terminated. 

#### Preconditions
An excetion occurs within the simulation.

#### Postconditions
The simulation is terminated.

#### Solution Contraints
_none_

#### Feature : Promt User
The user must get available information about the error.

#### Feature : User Choice
The user may choose between terminating the erraneous simulation session or terminating and restarting.
