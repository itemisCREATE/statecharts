################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
INO_SRCS += \
../traffic_light_arduino.ino 

CPP_SRCS += \
../.ino.cpp 

C_SRCS += \
../TrafficLightCtrl.c \
../pushbutton.c 

C_DEPS += \
./TrafficLightCtrl.c.d \
./pushbutton.c.d 

LINK_OBJ += \
./.ino.cpp.o \
./TrafficLightCtrl.c.o \
./pushbutton.c.o 

INO_DEPS += \
./traffic_light_arduino.ino.d 

CPP_DEPS += \
./.ino.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
.ino.cpp.o: ../.ino.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/tools/arduino/avr-gcc/4.8.1-arduino5/bin/avr-g++" -c -g -Os -std=gnu++11 -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10606 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/cores/arduino" -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/variants/standard" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '

TrafficLightCtrl.c.o: ../TrafficLightCtrl.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/tools/arduino/avr-gcc/4.8.1-arduino5/bin/avr-gcc" -c -g -Os -std=gnu11 -ffunction-sections -fdata-sections -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10606 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/cores/arduino" -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/variants/standard" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '

pushbutton.c.o: ../pushbutton.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/tools/arduino/avr-gcc/4.8.1-arduino5/bin/avr-gcc" -c -g -Os -std=gnu11 -ffunction-sections -fdata-sections -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10606 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/cores/arduino" -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/variants/standard" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '

traffic_light_arduino.o: ../traffic_light_arduino.ino
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/tools/arduino/avr-gcc/4.8.1-arduino5/bin/avr-g++" -c -g -Os -std=gnu++11 -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10606 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/cores/arduino" -I"/home/beckmann/Downloads/yakindu-sctpro/arduinoPlugin/packages/arduino/hardware/avr/1.6.11/variants/standard" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '


