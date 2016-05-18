#ifdef __IN_ECLIPSE__
//This is a automatic generated file
//Please do not modify this file
//If you touch this file your change will be overwritten during the next build
//This file has been generated on 2016-05-13 16:17:30

#include "Arduino.h"
#include "Arduino.h"
#include <avr/sleep.h>
#include "pushbutton.h"
#include "TrafficLightCtrl.h"
#include "TrafficLightCtrlRequired.h"
#include "scutil/sc_timer_service.h"
void trafficLightCtrl_setTimer(TrafficLightCtrl* handle, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
void trafficLightCtrl_unsetTimer(TrafficLightCtrl* handle, const sc_eventid evid) ;
static void button_1_changed(pushbutton_t *button) ;
static void button_2_changed(pushbutton_t *button) ;
void setup() ;
void loop() ;
void trafficLightCtrlIface_synchronize(const TrafficLightCtrl *handle) ;

#include "traffic_light_arduino.ino"


#endif
