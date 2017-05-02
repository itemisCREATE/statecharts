
#ifndef OPERATIONS_H_
#define OPERATIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Operations'.
*/

class Operations : public StatemachineInterface
{
	
	public:
		
		Operations();
		
		~Operations();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_B,
			main_region_C,
			main_region_D,
			main_region_A,
			Operations_last_state
		} OperationsStates;
		
		
		//! Inner class for internal interface scope operation callbacks.
		class InternalSCI_OCB
		{
			public:
				virtual ~InternalSCI_OCB() = 0;
				
				virtual void internalOperation1() = 0;
				
				virtual sc_boolean InternalOperation2(sc_integer param1) = 0;
				
				virtual sc_real internalOperation3() = 0;
				
				virtual sc_real internalOperation3a(sc_real param1) = 0;
				
				virtual sc_integer internalOperation4() = 0;
				
				virtual sc_integer internalOperation4a(sc_integer param1) = 0;
				
				virtual sc_string internalOperation5() = 0;
				
				virtual sc_string internalOperation5a(sc_string param1) = 0;
		};
		
		/*! Set the working instance of the operation callback interface 'InternalSCI_OCB'. */
		void setInternalSCI_OCB(InternalSCI_OCB* operationCallback);
		//! Inner class for Interface1 interface scope.
		class SCI_Interface1
		{
			
			public:
				
			private:
				friend class Operations;
		};
				
				//! Inner class for Interface1 interface scope operation callbacks.
				class SCI_Interface1_OCB
				{
					public:
						virtual ~SCI_Interface1_OCB() = 0;
						
						virtual void interfaceOperation1() = 0;
						
						virtual sc_boolean InterfaceOperation2(sc_integer param1) = 0;
						
						virtual sc_real interfaceOperation3() = 0;
						
						virtual sc_real interfaceOperation3a(sc_real param1) = 0;
						
						virtual sc_integer interfaceOperation4() = 0;
						
						virtual sc_integer interfaceOperation4a(sc_integer param1) = 0;
						
						virtual sc_string interfaceOperation5() = 0;
						
						virtual sc_string interfaceOperation5a(sc_string param1) = 0;
				};
				
				/*! Set the working instance of the operation callback interface 'SCI_Interface1_OCB'. */
				void setSCI_Interface1_OCB(SCI_Interface1_OCB* operationCallback);
		
		/*! Returns an instance of the interface class 'SCI_Interface1'. */
		SCI_Interface1* getSCI_Interface1();
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'ev' that is defined in the default interface scope. */
				void raise_ev();
				
				
			private:
				friend class Operations;
				sc_boolean ev_raised;
		};
				
				//! Inner class for default interface scope operation callbacks.
				class DefaultSCI_OCB
				{
					public:
						virtual ~DefaultSCI_OCB() = 0;
						
						virtual void unnamedInterfaceOperation1() = 0;
						
						virtual sc_boolean UnnamedInterfaceOperation2(sc_integer param1) = 0;
						
						virtual sc_real unnamedOperation3() = 0;
						
						virtual sc_real unnamedOperation3a(sc_real param1) = 0;
						
						virtual sc_integer unnamedOperation4() = 0;
						
						virtual sc_integer unnamedOperation4a(sc_integer param1) = 0;
						
						virtual sc_string unnamedOperation5() = 0;
						
						virtual sc_string unnamedOperation5a(sc_string param1) = 0;
						
						virtual sc_boolean alwaysTrue() = 0;
				};
				
				/*! Set the working instance of the operation callback interface 'DefaultSCI_OCB'. */
				void setDefaultSCI_OCB(DefaultSCI_OCB* operationCallback);
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'ev' that is defined in the default interface scope. */
		void raise_ev();
		
		
		/*
		 * Functions inherited from StatemachineInterface
		 */
		virtual void init();
		
		virtual void enter();
		
		virtual void exit();
		
		virtual void runCycle();
		
		/*!
		* Checks if the state machine is active (until 2.4.1 this method was used for states).
		* A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
		*/
		virtual sc_boolean isActive() const;
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		*/
		virtual sc_boolean isFinal() const;
		
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(OperationsStates state) const;
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI
		{
			
			public:
				/*! Gets the value of the variable 'myBool' that is defined in the internal scope. */
				sc_boolean get_myBool() const;
				
				/*! Sets the value of the variable 'myBool' that is defined in the internal scope. */
				void set_myBool(sc_boolean value);
				
				
			private:
				friend class Operations;
				sc_boolean myBool;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		OperationsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		InternalSCI ifaceInternalSCI;
		InternalSCI_OCB* ifaceInternalSCI_OCB;
		SCI_Interface1 ifaceInterface1;
		SCI_Interface1_OCB* ifaceInterface1_OCB;
		DefaultSCI iface;
		DefaultSCI_OCB* iface_OCB;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_B_tr0_tr0();
		sc_boolean check_main_region_C_tr0_tr0();
		sc_boolean check_main_region_A_tr0_tr0();
		void effect_main_region_B_tr0();
		void effect_main_region_C_tr0();
		void effect_main_region_A_tr0();
		void enact_main_region_B();
		void enact_main_region_C();
		void enact_main_region_D();
		void enseq_main_region_B_default();
		void enseq_main_region_C_default();
		void enseq_main_region_D_default();
		void enseq_main_region_A_default();
		void enseq_main_region_default();
		void exseq_main_region_B();
		void exseq_main_region_C();
		void exseq_main_region_D();
		void exseq_main_region_A();
		void exseq_main_region();
		void react_main_region_B();
		void react_main_region_C();
		void react_main_region_D();
		void react_main_region_A();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
inline Operations::InternalSCI_OCB::~InternalSCI_OCB() {}
inline Operations::SCI_Interface1_OCB::~SCI_Interface1_OCB() {}
inline Operations::DefaultSCI_OCB::~DefaultSCI_OCB() {}
#endif /* OPERATIONS_H_ */
