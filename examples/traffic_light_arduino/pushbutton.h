/*
 * button.h
 *
 *  Created on: 28.04.2016
 *      Author: terfloth
 */

#ifndef PUSHBUTTON_H_
#define PUSHBUTTON_H_

#include "Arduino.h"

#ifdef __cplusplus
extern "C" {
#endif

struct pushbutton;

typedef struct {
	boolean state;
	int pin;
	unsigned long debounce_delay;
	boolean debounce_state;
	unsigned long last_debounce_time;
	void (*callback)(struct pushbutton*);
} pushbutton_t;

extern void read_pushbutton(pushbutton_t *button);
extern void setup_pushbutton(pushbutton_t *button, int pin, void (*callback)(pushbutton_t*));

#ifdef __cplusplus
}
#endif


#endif /* PUSHBUTTON_H_ */
