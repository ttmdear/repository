cmake_minimum_required(VERSION 3.10)

# set the project name
project(tetris_led)

set(ARDUINO_INCLUDE_DIR "/opt/arduino-1.8.9/hardware/arduino/avr/cores/arduino")

include_directories(${ARDUINO_INCLUDE_DIR})

# add_executable(Tutorial tutorial.cxx)

set(CMAKE_CXX_STANDARD 14)            # Enable c++14 standard

# Add main.cpp file of project root directory as source file
set(SOURCE_FILES tetris.ino)

add_executable(tetris_led ${SOURCE_FILES})

# Add executable target with source files listed in SOURCE_FILES variable
# add_executable(tetris.ino ${SOURCE_FILES})

# target_link_libraries(tetris-led)
