################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../scutil/sc_timer_service.c 

C_DEPS += \
./scutil/sc_timer_service.c.d 

LINK_OBJ += \
./scutil/sc_timer_service.c.o 


# Each subdirectory must supply rules for building sources it contributes
scutil/sc_timer_service.c.o: ../scutil/sc_timer_service.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/tools/arduino/avr-gcc/4.8.1-arduino5/bin/avr-gcc" -c -g -Os -std=gnu11 -ffunction-sections -fdata-sections -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10606 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/cores/arduino" -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/variants/standard" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '


