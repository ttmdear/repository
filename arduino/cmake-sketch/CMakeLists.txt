## --------- General ---------
cmake_minimum_required(VERSION 3.15)
project(cmake_sketch)
set(CMAKE_SYSTEM_NAME Generic)

## --------- Dump ---------

## --------- AVR ---------
# set(ARDUINO_BOARD "Arduino/Genuino Uno [avr.uno]") # Arduino/Genuino Uno
# set(ARDUINO_BOARD "Arduino Duemilanove or Diecimila [avr.diecimila]") # Arduino Duemilanove or Diecimila
# set(ARDUINO_BOARD "Arduino Nano [avr.nano]") # Arduino Nano
# set(ARDUINO_BOARD "Arduino/Genuino Mega or Mega 2560 [avr.mega]") # Arduino/Genuino Mega or Mega 2560
# set(ARDUINO_BOARD "Arduino Mega ADK [avr.megaADK]") # Arduino Mega ADK
# set(ARDUINO_BOARD "Arduino Leonardo [avr.leonardo]") # Arduino Leonardo
# set(ARDUINO_BOARD "Arduino Leonardo ETH [avr.leonardoeth]") # Arduino Leonardo ETH
# set(ARDUINO_BOARD "Arduino/Genuino Micro [avr.micro]") # Arduino/Genuino Micro
# set(ARDUINO_BOARD "Arduino Esplora [avr.esplora]") # Arduino Esplora
# set(ARDUINO_BOARD "Arduino Mini [avr.mini]") # Arduino Mini
# set(ARDUINO_BOARD "Arduino Ethernet [avr.ethernet]") # Arduino Ethernet
# set(ARDUINO_BOARD "Arduino Fio [avr.fio]") # Arduino Fio
# set(ARDUINO_BOARD "Arduino BT [avr.bt]") # Arduino BT
# set(ARDUINO_BOARD "LilyPad Arduino USB [avr.LilyPadUSB]") # LilyPad Arduino USB
# set(ARDUINO_BOARD "LilyPad Arduino [avr.lilypad]") # LilyPad Arduino
# set(ARDUINO_BOARD "Arduino Pro or Pro Mini [avr.pro]") # Arduino Pro or Pro Mini
# set(ARDUINO_BOARD "Arduino NG or older [avr.atmegang]") # Arduino NG or older
# set(ARDUINO_BOARD "Arduino Robot Control [avr.robotControl]") # Arduino Robot Control
# set(ARDUINO_BOARD "Arduino Robot Motor [avr.robotMotor]") # Arduino Robot Motor
# set(ARDUINO_BOARD "Arduino Gemma [avr.gemma]") # Arduino Gemma
# set(ARDUINO_BOARD "Adafruit Circuit Playground [avr.circuitplay32u4cat]") # Adafruit Circuit Playground
# set(ARDUINO_BOARD "Arduino Yn Mini [avr.yunmini]") # Arduino Yn Mini
# set(ARDUINO_BOARD "Arduino Industrial 101 [avr.chiwawa]") # Arduino Industrial 101
# set(ARDUINO_BOARD "Linino One [avr.one]") # Linino One
# set(ARDUINO_BOARD "Arduino Uno WiFi [avr.unowifi]") # Arduino Uno WiFi

set(AVR_PROGRAMMER avrisp) # AVR ISP
# set(AVR_PROGRAMMER avrispmkii) # AVRISP mkII
# set(AVR_PROGRAMMER usbtinyisp) # USBtinyISP
# set(AVR_PROGRAMMER arduinoisp) # ArduinoISP
# set(AVR_PROGRAMMER org) # ArduinoISP.org
# set(AVR_PROGRAMMER usbasp) # USBasp
# set(AVR_PROGRAMMER parallel) # Parallel Programmer
# set(AVR_PROGRAMMER arduinoasisp) # Arduino as ISP
# set(AVR_PROGRAMMER usbGemma) # Arduino Gemma
# set(AVR_PROGRAMMER buspirate) # BusPirate as ISP
# set(AVR_PROGRAMMER stk500) # Atmel STK500 development board
# set(AVR_PROGRAMMER jtag3isp) # Atmel JTAGICE3 (ISP mode)
# set(AVR_PROGRAMMER jtag3) # Atmel JTAGICE3 (JTAG mode)
# set(AVR_PROGRAMMER atmel_ice) # Atmel-ICE (AVR)

set(AVR_PARTNO atmega328p)

set(ARDUINO_HOME_DIR /opt/arduino-1.8.9)
set(ARDUINO_CORE  ${ARDUINO_HOME_DIR}/hardware/arduino/avr/cores/arduino)
set(AVR_BIN ${ARDUINO_HOME_DIR}/hardware/tools/avr/bin)
set(AVR_INCLUDE ${ARDUINO_HOME_DIR}/hardware/tools/avr/avr/include/avr)
set(AVR_PORT /dev/ttyACM0)

include_directories(
    ${ARDUINO_CORE}
    ${ARDUINO_HOME_DIR}/hardware/tools/avr/avr/include
    ${ARDUINO_HOME_DIR}/hardware/arduino/avr/variants/standard
)

## --------- Compiler ---------

message("AVR_BIN: ${AVR_BIN}")

set(CMAKE_C_COMPILER ${AVR_BIN}/avr-gcc)
set(CMAKE_C_LINK_EXECUTABLE "<CMAKE_C_COMPILER> <FLAGS> <CMAKE_C_LINK_FLAGS> <LINK_FLAGS> <OBJECTS>  -o <TARGET>.bin <LINK_LIBRARIES>")

set(CMAKE_CXX_COMPILER "${AVR_BIN}/avr-g++")
set(CMAKE_CXX_LINK_EXECUTABLE "<CMAKE_CXX_COMPILER> <FLAGS> <CMAKE_CXX_LINK_FLAGS> <LINK_FLAGS> <OBJECTS>  -o <TARGET>.bin <LINK_LIBRARIES>")

# CXXFLAGS: <CMAKE_CXX_LINK_FLAGS>
# LINK_FLAGS: <LINKER_FLAGS>
# LINK_LIBRARIES: <LINK_LIBRARIES>
# OBJECTS: <OBJECTS>
# TARGET: <TARGET>
# set(CMAKE_CXX_LINK_EXECUTABLE "echo TARGET: <TARGET>")
message("CMAKE_SOURCE_DIR : ${CMAKE_SOURCE_DIR}")
message("CMAKE_BINARY_DIR : ${CMAKE_BINARY_DIR}")

set(CMAKE_CXX_STANDARD 14)

set(CSTANDARD "-std=gnu99")
set(CDEBUG "-gstabs")
set(CWARN "-Wall -Wstrict-prototypes")
set(CTUNING "-funsigned-char -funsigned-bitfields -fpack-struct -fshort-enums")
set(COPT "-Os")
# set(CINCS "-I${ArduinoCode_SOURCE_DIR}/libarduinocore")
set(CINCS "")
set(CMCU "-mmcu=atmega328p")
set(CDEFS "-DF_CPU=16000000L")

set(CFLAGS "${CMCU} ${CDEBUG} ${CDEFS} ${CINCS} ${COPT} ${CWARN} ${CSTANDARD} ${CEXTRA}")
set(CXXFLAGS "${CMCU} ${CDEFS} ${CINCS} ${COPT}")

set(CMAKE_C_FLAGS ${CFLAGS})
set(CMAKE_CXX_FLAGS ${CXXFLAGS})

# Linker
message("path: ${ARDUINO_HOME_DIR}/hardware/tools/avr/avr/include/avr/io.h")

# target_compile_definitions(${PROJECT_NAME} PRIVATE __AVR_ATmega328P__)
add_compile_definitions(__AVR_ATmega328P__=1)

add_executable(${PROJECT_NAME}
        # ${ARDUINO_HOME_DIR}/hardware/tools/avr/avr/include/avr/io.h
        # ${ARDUINO_HOME_DIR}/hardware/tools/avr/avr/include/avr/iom328.h

        main.cpp
        ${ARDUINO_CORE}/main.cpp

        ${ARDUINO_CORE}/Arduino.h

        ${ARDUINO_HOME_DIR}/hardware/arduino/avr/cores/arduino/abi.cpp
        # ${ARDUINO_CORE}/CDC.cpp
        # ${ARDUINO_CORE}/Client.h
        # ${ARDUINO_CORE}/HardwareSerial.h
        # ${ARDUINO_CORE}/HardwareSerial0.cpp
        # ${ARDUINO_CORE}/HardwareSerial1.cpp
        # ${ARDUINO_CORE}/HardwareSerial2.cpp
        # ${ARDUINO_CORE}/HardwareSerial3.cpp
        # ${ARDUINO_CORE}/HardwareSerial_private.h
        # ${ARDUINO_CORE}/IPAddress.cpp
        # ${ARDUINO_CORE}/IPAddress.h
        # ${ARDUINO_CORE}/PluggableUSB.cpp
        # ${ARDUINO_CORE}/PluggableUSB.h
        # ${ARDUINO_CORE}/Print.h
        # ${ARDUINO_CORE}/Printable.h
        # ${ARDUINO_CORE}/Server.h
        # ${ARDUINO_CORE}/Stream.cpp
        # ${ARDUINO_CORE}/Stream.h
        # ${ARDUINO_CORE}/Tone.cpp
        # ${ARDUINO_CORE}/USBAPI.h
        # ${ARDUINO_CORE}/USBCore.cpp
        # ${ARDUINO_CORE}/USBCore.h
        # ${ARDUINO_CORE}/USBDesc.h
        # ${ARDUINO_CORE}/Udp.h
        # ${ARDUINO_CORE}/WCharacter.h
        # ${ARDUINO_CORE}/WString.cpp
        # ${ARDUINO_CORE}/WString.h
        # ${ARDUINO_CORE}/abi.cpp
        # ${ARDUINO_CORE}/binary.h
        ${ARDUINO_CORE}/hooks.c
        # ${ARDUINO_CORE}/new.cpp
        # ${ARDUINO_CORE}/new.h
        # ${ARDUINO_CORE}/wiring_private.h
        # ${ARDUINO_CORE}/wiring_pulse.S

        # ${ARDUINO_CORE}/wiring_pulse.c
        ${ARDUINO_CORE}/wiring_shift.c
        ${ARDUINO_CORE}/wiring.c
        ${ARDUINO_CORE}/wiring_analog.c
        ${ARDUINO_CORE}/wiring_digital.c
        ${ARDUINO_CORE}/WInterrupts.c
        ${ARDUINO_CORE}/WMath.cpp
        ${ARDUINO_CORE}/Print.cpp
        ${ARDUINO_CORE}/HardwareSerial.cpp

        # ${ARDUINO_HOME_DIR}/hardware/arduino/avr/variants/mega/pins_arduino.h

        )

add_custom_target(upload
        COMMAND avr-objcopy -j .text -j .data -O ihex ${PROJECT_NAME}.bin ${PROJECT_NAME}.hex
        COMMAND avrdude -p ${AVR_PARTNO} -c ${AVR_PROGRAMMER} -U flash:w:${PROJECT_NAME}.hex:i -F -P ${AVR_PORT} -C "/opt/arduino-1.8.9/hardware/tools/avr/etc/avrdude.conf"
        VERBATIM)

add_dependencies(upload ${PROJECT_NAME})
