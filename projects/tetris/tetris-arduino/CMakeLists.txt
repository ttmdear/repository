cmake_minimum_required(VERSION 2.8.4)
set(CMAKE_TOOLCHAIN_FILE ${CMAKE_SOURCE_DIR}/cmake/ArduinoToolchain.cmake)
# set(CMAKE_CXX_STANDARD 98)
set(CMAKE_CXX_STANDARD 11)
set(PROJECT_NAME tetris_arduino)
set(ARDUINO_CPU 16MHzatmega328)

# print_board_list()

# set(${PROJECT_NAME}_BOARD uno)
set(${PROJECT_NAME}_BOARD pro)
# set(${PROJECT_NAME}_BOARD mini)
# set(ARDUINO_CPU)
project(${PROJECT_NAME})

set(BOARD_ARDUINO 1)

# Define additional source and header files or default arduino sketch files
# set(${PROJECT_NAME}_SRCS)
set(${PROJECT_NAME}_HDRS
    include/Bootstrap.h
    include/tetriminos/JTetrimino.h
    include/tetriminos/TTetrimino.h
    include/tetriminos/STetrimino.h
    include/tetriminos/ZTetrimino.h
    include/tetriminos/ITetrimino.h
    include/tetriminos/LTetrimino.h
    include/tetriminos/Tetrimino.h
    include/tetriminos/OTetrimino.h
    include/Bitmap.h
    include/Gamepad.h
    include/Audio.h
    include/common.h
    include/Display.h
    include/GameTetris.h
    include/board.h
)

### Additional static libraries to include in the target.
# set(${PROJECT_NAME}_LIBS)

### Main sketch file
# set(${PROJECT_NAME}_SKETCH src/tetris_arduino.ino)
set(${PROJECT_NAME}_SRCS
        src/tetriminos/JTetrimino.cpp
        src/tetriminos/ZTetrimino.cpp
        src/tetriminos/Tetrimino.cpp
        src/tetriminos/STetrimino.cpp
        src/tetriminos/ITetrimino.cpp
        src/tetriminos/TTetrimino.cpp
        src/tetriminos/OTetrimino.cpp
        src/tetriminos/LTetrimino.cpp
        src/boards/arduinoboard/Bootstrap.cpp
        src/boards/arduinoboard/Display.cpp
        src/boards/arduinoboard/Gamepad.cpp
        src/boards/arduinoboard/Audio.cpp
        src/Bitmap.cpp
        src/main.cpp
        src/common.cpp
        src/GameTetris.cpp
)

### Add project directories into the build
# add_subdirectory(boards)

### Additional settings to add non-standard or your own Arduino libraries.
# For this example (libs will contain additional arduino libraries)
# An Arduino library my_lib will contain files in libs/my_lib/: my_lib.h, my_lib.cpp + any other cpp files
# link_directories(${CMAKE_CURRENT_SOURCE_DIR}/)

# For nested library sources replace ${LIB_NAME} with library name for each library
# set(_RECURSE true)
# –uno: Arduino Uno
# – atmega328: Arduino Duemilanove w/ ATmega328
# – diecimila: Arduino Diecimila or Duemilanove w/ ATmega168
# – nano328: Arduino Nano w/ ATmega328
# – nano: Arduino Nano w/ ATmega168
# – mega2560: Arduino Mega 2560 or Mega ADK
# – mega: Arduino Mega (ATmega1280)
# – mini328: Arduino Mini w/ ATmega328
# – mini: Arduino Mini w/ ATmega168
# – ethernet: Arduino Ethernet
# – fio: Arduino Fio
# – bt328: Arduino BT w/ ATmega328
# – bt: Arduino BT w/ ATmega168
# – lilypad328: LilyPad Arduino w/ ATmega328
# – lilypad: LilyPad Arduino w/ ATmega168
# – pro5v328: Arduino Pro or Pro Mini (5V, 16 MHz) w/ ATmega328
# – pro5v: Arduino Pro or Pro Mini (5V, 16 MHz) w/ ATmega168
# – pro328: Arduino Pro or Pro Mini (3.3V, 8 MHz) w/ ATmega328
# – pro: Arduino Pro or Pro Mini (3.3V, 8 MHz) w/ ATmega168
# – atmega168: Arduino NG or older w/ ATmega168
# – atmega8: Arduino NG or older w/ ATmega8

#### Additional settings for programmer. From programmers.txt
# set(${PROJECT_NAME}_PROGRAMMER avrispmkii)
set(${PROJECT_NAME}_PROGRAMMER avrisp)
# set(${PROJECT_NAME}_BOARD pro5v328)
# set(${PROJECT_NAME}_PORT /dev/ttyACM1)
set(${PROJECT_NAME}_PORT /dev/ttyUSB0)
set(${PROJECT_NAME}_LIBRARY LiquidCrystal)
set(${PROJECT_NAME}_LIBRARY LiquidCrystal)
# set(uno.upload.speed 9600)

## Verbose build process
set(${PROJECT_NAME}_AFLAGS -v)

generate_arduino_firmware(${PROJECT_NAME})
