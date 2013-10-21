#include "include/CycleRunner.h"

CycleRunner::CycleRunner(Trafficlight *sc_handle){
	this->handle = sc_handle;
}

/**
 * The cycleRunner uses timer0 for his cycle-time-calculation (every second)
 */
void CycleRunner::start(void){
	TCCR0B |= (1<<CS02) | (1<<CS00);	// prescaler 1024
	TCNT0 = 0;	// Startvalue ->1s to overflow
	TIMSK0 |= (1<<TOIE0);
}

void CycleRunner::stop(void){
	TCCR0B = 0;
}

void CycleRunner::runCycle(void){
	trafficlight_runCycle(handle);
}
