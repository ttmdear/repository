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
CMAKE_SOURCE_DIR = /home/thinkpad/workspace/tetris

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/thinkpad/workspace/tetris/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/tetris.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/tetris.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/tetris.dir/flags.make

tetris_tetris.ino.cpp: ../tetris.ino
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/thinkpad/workspace/tetris/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Regnerating tetris.ino Sketch"
	/home/thinkpad/bin/clion-2019.3.2/bin/cmake/linux/bin/cmake /home/thinkpad/workspace/tetris

CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj: CMakeFiles/tetris.dir/flags.make
CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj: tetris_tetris.ino.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/thinkpad/workspace/tetris/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj -c /home/thinkpad/workspace/tetris/cmake-build-debug/tetris_tetris.ino.cpp

CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.i"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/thinkpad/workspace/tetris/cmake-build-debug/tetris_tetris.ino.cpp > CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.i

CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.s"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/thinkpad/workspace/tetris/cmake-build-debug/tetris_tetris.ino.cpp -o CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.s

# Object files for target tetris
tetris_OBJECTS = \
"CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj"

# External object files for target tetris
tetris_EXTERNAL_OBJECTS =

tetris.elf: CMakeFiles/tetris.dir/tetris_tetris.ino.cpp.obj
tetris.elf: CMakeFiles/tetris.dir/build.make
tetris.elf: libuno_CORE.a
tetris.elf: CMakeFiles/tetris.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/thinkpad/workspace/tetris/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable tetris.elf"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/tetris.dir/link.txt --verbose=$(VERBOSE)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating EEP image"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-objcopy -O ihex -j .eeprom --set-section-flags=.eeprom=alloc,load --no-change-warnings --change-section-lma .eeprom=0 /home/thinkpad/workspace/tetris/cmake-build-debug/tetris.elf /home/thinkpad/workspace/tetris/cmake-build-debug/tetris.eep
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating HEX image"
	/opt/arduino-1.8.9/hardware/tools/avr/bin/avr-objcopy -O ihex -R .eeprom /home/thinkpad/workspace/tetris/cmake-build-debug/tetris.elf /home/thinkpad/workspace/tetris/cmake-build-debug/tetris.hex
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Calculating image size"
	/home/thinkpad/bin/clion-2019.3.2/bin/cmake/linux/bin/cmake -DFIRMWARE_IMAGE=/home/thinkpad/workspace/tetris/cmake-build-debug/tetris.elf -DMCU=atmega328p -DEEPROM_IMAGE=/home/thinkpad/workspace/tetris/cmake-build-debug/tetris.eep -P /home/thinkpad/workspace/tetris/cmake-build-debug/CMakeFiles/FirmwareSize.cmake

# Rule to build all files generated by this target.
CMakeFiles/tetris.dir/build: tetris.elf

.PHONY : CMakeFiles/tetris.dir/build

CMakeFiles/tetris.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/tetris.dir/cmake_clean.cmake
.PHONY : CMakeFiles/tetris.dir/clean

CMakeFiles/tetris.dir/depend: tetris_tetris.ino.cpp
	cd /home/thinkpad/workspace/tetris/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/thinkpad/workspace/tetris /home/thinkpad/workspace/tetris /home/thinkpad/workspace/tetris/cmake-build-debug /home/thinkpad/workspace/tetris/cmake-build-debug /home/thinkpad/workspace/tetris/cmake-build-debug/CMakeFiles/tetris.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/tetris.dir/depend

