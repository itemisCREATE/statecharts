
#ifndef STATETIMER_H_
#define STATETIMER_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" {
#endif

typedef void (*raiseEventCallback_t)(void* handle, sc_eventid evid);

void setTimer(void* handle, const sc_eventid evid, const sc_integer time_ms,
		const sc_boolean periodic, raiseEventCallback_t callback);

void unsetTimer(const sc_eventid evid);

void checkTimers(sc_integer deltaT_ms);
void initTimers(void);


#ifdef __cplusplus
}
#endif

#endif /* STATETIMER_H_ */
