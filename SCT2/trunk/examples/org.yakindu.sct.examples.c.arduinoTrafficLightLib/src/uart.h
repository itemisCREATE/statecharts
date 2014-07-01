
#ifndef UART_H_
#define UART_H_

#ifdef __cplusplus
extern "C" {
#endif

#include <avr/pgmspace.h>

// Macro to send strings stored in program memory space
#define printf(format, ...) printf_P(PSTR(format), ## __VA_ARGS__)

void uartInit(long baud);

#ifdef __cplusplus
}
#endif

#endif /* UART_H_ */
