status | type
------ | ----
_DEFINED_ | _functional_

---
The user must be able to use tags like _TODO_ and _FIXME_ within comments of the textual parts. These define artefact related tasks 
that should be displayed in a separate view. The view must provide an overview of statechart related tasks and allow navigation from 
the entries to the location where the task is defined.    

#### Discussion
Eclipse provides infrrastructure for these use cases and SCT should integrate with this.  

#### Preconditions
_none_

#### Postconditions
_none_

#### Solution Contraints
Make use of the Eclipse _Tasks_ view and related infrastructure.

#### Feature : Visualisation
* The task description should contain the comment line starting with _TODO_ or _FIXME_ tags.
* The task type must be _SC Task_ or _Statechart Task_.

#### Feature : Navigation
The _Tasks_ view allows navigation to the task location by double clicking. In the case os a stratechart the diagram must be opened 
and the graphical element must be highlighted. This includes opening subdiagrams if neccessary.
containing the task must be selected
