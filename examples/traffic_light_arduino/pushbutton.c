/*
 * button.c
 *
 *  Created on: 28.04.2016
 *      Author: terfloth
 */

#include "Arduino.h"
#include "pushbutton.h"



void read_pushbutton(pushbutton_t *button){

	int pin_value = digitalRead(button->pin);

	if (pin_value != button->debounce_state) {
		button->last_debounce_time = millis();
	}

	if ((millis() - button->last_debounce_time) > button->debounce_delay) {
		if (pin_value != button->state) {
			button->state = pin_value;
			button->callback(button);
		}
	}

	button->debounce_state = pin_value;

}


void setup_pushbutton(pushbutton_t *button, int pin, void (*callback)(pushbutton_t*)) {
	button->pin = pin;
	button->debounce_delay = 50;
	button->state = digitalRead(button->pin);
	button->debounce_state = LOW;
	button->last_debounce_time = 0;
	button->callback = callback;

	pinMode(pin, INPUT);
}
