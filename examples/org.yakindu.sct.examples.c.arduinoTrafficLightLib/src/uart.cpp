/*
 * Wrapper to make printf() usable with the Arduino Serial implementation
 *
 * Author:
 * Axel Utech <axel.utech@gmail.com>
 *
 */

#include <stdio.h>
//#include "arduino.h"
#include <wiring.h>
#include <HardwareSerial.h>

static FILE uartout = {0};

// create a output function
// This works because Serial.write, although of
// type virtual, already exists.
static int uart_putchar(char c, FILE *stream) {
	Serial.write(c);
	return 0;
}

/**
 * sets up the necessary pointers
 *
 * \warning Must be called before all printf statements!
 *
 * \param baud Baudrate for the communication (see Serial.begin())
 */
extern "C" void uartInit(long baud) {
	// Start the UART
	Serial.begin(baud);

	// fill in the UART file descriptor with pointer to writer.
	fdev_setup_stream(&uartout, uart_putchar, NULL, _FDEV_SETUP_WRITE);
//	fdev_setup_stream(&uartout, uart_putchar, NULL, _FDEV_SETUP_WRITE);

	// The uart is the standard output device STDOUT.
	stdout = &uartout;
}

