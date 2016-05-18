#include "Arduino.h"
#include <avr/sleep.h>

#include "pushbutton.h"
#include "TrafficLightCtrl.h"
#include "TrafficLightCtrlRequired.h"
#include "scutil/sc_timer_service.h"

//! As we make use of time triggers (after & every) we make use of a generic timer implementation and need a defined number of timers.
#define MAX_TIMERS 20

const int button_1_pin = 3;    // the number of the pushbutton 1 pin
const int button_2_pin = 2;    // the number of the pushbutton 2 pin

const int led_green_pin = 8;
const int led_yellow_pin = 12;
const int led_red_pin = 9;

const int ped_led_red_pin = 4;
const int ped_led_green_pin = 5;

const int ped_led_request_pin = 6;


pushbutton_t pushbutton_1;		// first pushbutton
pushbutton_t pushbutton_2;		// second pushbutton

static TrafficLightCtrl trafficLight;

//! We allocate the desired array of timers.
static sc_timer_t timers[MAX_TIMERS];

//! The timers are managed by a timer service. */
static sc_timer_service_t timer_service;

//! callback implementation for the setting up time events
void trafficLightCtrl_setTimer(TrafficLightCtrl* handle, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_start(&timer_service, (void*) handle, evid, time_ms, periodic);
}

//! callback implementation for canceling time events.
void trafficLightCtrl_unsetTimer(TrafficLightCtrl* handle, const sc_eventid evid) {
	sc_timer_cancel(&timer_service, evid);
}

static void button_1_changed(pushbutton_t *button) {
	if (!pushbutton_1.state) trafficLightCtrlIface_raise_pedestrianRequest(&trafficLight);
}

static void button_2_changed(pushbutton_t *button) {
	if (!pushbutton_2.state) trafficLightCtrlIface_raise_onOff(&trafficLight);
}

//The setup function is called once at startup of the sketch
void setup()
{
	setup_pushbutton(&pushbutton_1, button_1_pin, button_1_changed);
	setup_pushbutton(&pushbutton_2, button_2_pin, button_2_changed);

	pinMode(led_green_pin, OUTPUT);
	pinMode(led_yellow_pin, OUTPUT);
	pinMode(led_red_pin, OUTPUT);

	pinMode(ped_led_red_pin, OUTPUT);
	pinMode(ped_led_green_pin, OUTPUT);
	pinMode(ped_led_request_pin, OUTPUT);

	sc_timer_service_init(
				&timer_service,
				timers, MAX_TIMERS,
				(sc_raise_time_event_fp) &trafficLightCtrl_raiseTimeEvent);

	trafficLightCtrl_init(&trafficLight);

	trafficLightCtrl_enter(&trafficLight);
}

#define CYCLE_PERIOD (10)
static unsigned long cycle_count = 0L;
static unsigned long last_cycle_time = 0L;


void loop() {

	unsigned long current_millies = millis();

	read_pushbutton(&pushbutton_1);
	read_pushbutton(&pushbutton_2);


	if ( cycle_count == 0L || (current_millies >= last_cycle_time + CYCLE_PERIOD) ) {

		sc_timer_service_proceed(&timer_service, current_millies - last_cycle_time);

		trafficLightCtrl_runCycle(&trafficLight);


		last_cycle_time = current_millies;
		cycle_count++;
	}
}

void trafficLightCtrlIface_synchronize(const TrafficLightCtrl *handle)
{
	//synchronize red traffic light
	if(trafficLightCtrlIfaceTrafficLight_get_red(handle) == true)
		digitalWrite(led_red_pin, HIGH);
	else
		digitalWrite(led_red_pin, LOW);

	//synchronize yellow traffic light
	if(trafficLightCtrlIfaceTrafficLight_get_yellow(handle) == true)
		digitalWrite(led_yellow_pin, HIGH);
	else
		digitalWrite(led_yellow_pin, LOW);

	//synchronize green traffic light
	if(trafficLightCtrlIfaceTrafficLight_get_green(handle) == true)
		digitalWrite(led_green_pin, HIGH);
	else
		digitalWrite(led_green_pin, LOW);

	//synchronize red pedestrian traffic light
	if(trafficLightCtrlIfacePedestrian_get_red(handle) == true)
		digitalWrite(ped_led_red_pin, HIGH);
	else
		digitalWrite(ped_led_red_pin, LOW);

	//synchronize green pedestrian traffic light
	if(trafficLightCtrlIfacePedestrian_get_green(handle) == true)
		digitalWrite(ped_led_green_pin, HIGH);
	else
		digitalWrite(ped_led_green_pin, LOW);

	//synchronize pedestrian waiting light
	if(trafficLightCtrlIfacePedestrian_get_request(handle) == true)
		digitalWrite(ped_led_request_pin, HIGH);
	else
		digitalWrite(ped_led_request_pin, LOW);
}
