# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/thinkpad/bin/clion-2019.3.2/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/thinkpad/bin/clion-2019.3.2/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/thinkpad/workspace/tetris/tetris-arduino

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/tetris_arduino.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/tetris_arduino.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/tetris_arduino.dir/flags.make

CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj: ../src/tetriminos/JTetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/JTetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/JTetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/JTetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj: ../src/tetriminos/ZTetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ZTetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ZTetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ZTetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj: ../src/tetriminos/Tetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/Tetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/Tetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/Tetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj: ../src/tetriminos/STetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/STetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/STetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/STetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj: ../src/tetriminos/ITetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ITetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ITetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/ITetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj: ../src/tetriminos/TTetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/TTetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/TTetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/TTetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj: ../src/tetriminos/OTetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/OTetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/OTetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/OTetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj: ../src/tetriminos/LTetrimino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Building CXX object CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/LTetrimino.cpp

CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/LTetrimino.cpp > CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.i

CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/tetriminos/LTetrimino.cpp -o CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.s

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj: ../src/boards/arduinoboard/Bootstrap.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Building CXX object CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Bootstrap.cpp

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Bootstrap.cpp > CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.i

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Bootstrap.cpp -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.s

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj: ../src/boards/arduinoboard/Display.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_10) "Building CXX object CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Display.cpp

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Display.cpp > CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.i

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Display.cpp -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.s

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj: ../src/boards/arduinoboard/Gamepad.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_11) "Building CXX object CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Gamepad.cpp

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Gamepad.cpp > CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.i

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Gamepad.cpp -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.s

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj: ../src/boards/arduinoboard/Audio.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_12) "Building CXX object CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Audio.cpp

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Audio.cpp > CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.i

CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/boards/arduinoboard/Audio.cpp -o CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.s

CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj: ../src/Bitmap.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_13) "Building CXX object CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/Bitmap.cpp

CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/Bitmap.cpp > CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.i

CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/Bitmap.cpp -o CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.s

CMakeFiles/tetris_arduino.dir/src/main.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/main.cpp.obj: ../src/main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_14) "Building CXX object CMakeFiles/tetris_arduino.dir/src/main.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/main.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/main.cpp

CMakeFiles/tetris_arduino.dir/src/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/main.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/main.cpp > CMakeFiles/tetris_arduino.dir/src/main.cpp.i

CMakeFiles/tetris_arduino.dir/src/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/main.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/main.cpp -o CMakeFiles/tetris_arduino.dir/src/main.cpp.s

CMakeFiles/tetris_arduino.dir/src/common.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/common.cpp.obj: ../src/common.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_15) "Building CXX object CMakeFiles/tetris_arduino.dir/src/common.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/common.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/common.cpp

CMakeFiles/tetris_arduino.dir/src/common.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/common.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/common.cpp > CMakeFiles/tetris_arduino.dir/src/common.cpp.i

CMakeFiles/tetris_arduino.dir/src/common.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/common.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/common.cpp -o CMakeFiles/tetris_arduino.dir/src/common.cpp.s

CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj: CMakeFiles/tetris_arduino.dir/flags.make
CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj: ../src/GameTetris.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_16) "Building CXX object CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj -c /home/thinkpad/workspace/tetris/tetris-arduino/src/GameTetris.cpp

CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/tetris-arduino/src/GameTetris.cpp > CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.i

CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/tetris-arduino/src/GameTetris.cpp -o CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.s

# Object files for target tetris_arduino
tetris_arduino_OBJECTS = \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/main.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/common.cpp.obj" \
"CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj"

# External object files for target tetris_arduino
tetris_arduino_EXTERNAL_OBJECTS =

tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/JTetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/ZTetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/Tetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/STetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/ITetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/TTetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/OTetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/tetriminos/LTetrimino.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Bootstrap.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Display.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Gamepad.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/boards/arduinoboard/Audio.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/Bitmap.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/main.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/common.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/src/GameTetris.cpp.obj
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/build.make
tetris_arduino.elf: libpro_LiquidCrystal.a
tetris_arduino.elf: libpro_CORE.a
tetris_arduino.elf: CMakeFiles/tetris_arduino.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_17) "Linking CXX executable tetris_arduino.elf"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/tetris_arduino.dir/link.txt --verbose=$(VERBOSE)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating EEP image"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-objcopy -O ihex -j .eeprom --set-section-flags=.eeprom=alloc,load --no-change-warnings --change-section-lma .eeprom=0 /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.elf /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.eep
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating HEX image"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-objcopy -O ihex -R .eeprom /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.elf /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.hex
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Calculating image size"
	/home/thinkpad/bin/clion-2019.3.2/bin/cmake/linux/bin/cmake -DFIRMWARE_IMAGE=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.elf -DMCU=atmega328p -DEEPROM_IMAGE=/home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/tetris_arduino.eep -P /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles/FirmwareSize.cmake

# Rule to build all files generated by this target.
CMakeFiles/tetris_arduino.dir/build: tetris_arduino.elf

.PHONY : CMakeFiles/tetris_arduino.dir/build

CMakeFiles/tetris_arduino.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/tetris_arduino.dir/cmake_clean.cmake
.PHONY : CMakeFiles/tetris_arduino.dir/clean

CMakeFiles/tetris_arduino.dir/depend:
	cd /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/thinkpad/workspace/tetris/tetris-arduino /home/thinkpad/workspace/tetris/tetris-arduino /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug /home/thinkpad/workspace/tetris/tetris-arduino/cmake-build-debug/CMakeFiles/tetris_arduino.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/tetris_arduino.dir/depend

