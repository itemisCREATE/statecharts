#include "Operations.h"

class InternalCallBack : public Operations::InternalSCI_OCB {

	public:

		void internalOperation1();

		sc_boolean InternalOperation2(sc_integer param1);

		sc_real internalOperation3();

		sc_real internalOperation3a(sc_real param1);

		sc_integer internalOperation4();

		sc_integer internalOperation4a(sc_integer param1);

		sc_string internalOperation5();

		sc_string internalOperation5a(sc_string param1);

};

class Interface1CallBack : public Operations::SCI_Interface1_OCB {
	public:

		void interfaceOperation1();

		sc_boolean InterfaceOperation2(sc_integer param1);

		sc_real interfaceOperation3();

		sc_real interfaceOperation3a(sc_real param1);

		sc_integer interfaceOperation4();

		sc_integer interfaceOperation4a(sc_integer param1);

		sc_string interfaceOperation5();

		sc_string interfaceOperation5a(sc_string param1);

};

class DefaultCallBack : public Operations::DefaultSCI_OCB {

	public:

		void unnamedInterfaceOperation1();

		sc_boolean UnnamedInterfaceOperation2(sc_integer param1);
		
		sc_boolean unnamedOperation2(sc_integer param1);

		sc_real unnamedOperation3();

		sc_real unnamedOperation3a(sc_real param1);

		sc_integer unnamedOperation4();

		sc_integer unnamedOperation4a(sc_integer param1);

		sc_string unnamedOperation5();

		sc_string unnamedOperation5a(sc_string param1);

		sc_boolean alwaysTrue();
};

