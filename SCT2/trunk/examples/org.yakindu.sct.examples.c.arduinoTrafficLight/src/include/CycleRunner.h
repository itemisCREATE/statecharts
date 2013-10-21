/*
 * CycleRunner.h
 *
 *  Created on: 25.06.2013
 *      Author: scholtyssek
 */

#ifndef CYCLERUNNER_H_
#define CYCLERUNNER_H_

#include "sc_types.h"
#include <avr/interrupt.h>
#include "../src-gen/Trafficlight.h"

class CycleRunner{
	public:
		CycleRunner(Trafficlight *sc_handle);
		void start(void);
		void stop(void);
		void runCycle(void);

	private:
		Trafficlight *handle;
};
#endif /* CYCLERUNNER_H_ */
