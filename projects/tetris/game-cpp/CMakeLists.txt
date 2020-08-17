cmake_minimum_required(VERSION 3.13)  # CMake version check

set(CMAKE_FIND_LIBRARY_PREFIXES "")
set(CMAKE_FIND_LIBRARY_SUFFIXES "lib")

# link_directories(/usr/lib/x86_64-linux-gnu)

# set(CURSES_LIBRARY /usr/lib/x86_64-linux-gnu/libncurses.so)
# set(CMAKE_INCLUDE_PATH "/usr/include")

message("prefix: ${CMAKE_FIND_LIBRARY_PREFIXES}")
message("suffix: ${CMAKE_FIND_LIBRARY_SUFFIXES}")

# find_package(Curses REQUIRED)
# find_package(allegro-5 REQUIRED)
# include_directories(${CURSES_INCLUDE_DIR})

project(simple_example)               # Create project "simple_example"
set(CMAKE_CXX_STANDARD 14)            # Enable c++14 standard

# Add main.cpp file of project root directory as source file
set(SOURCE_FILES src/main.cpp src/ledgames/Bitmap.cpp src/ledgames/Bitmap.h src/ledgames/Display.cpp src/ledgames/Display.h src/ledgames/tetriminos/Tetrimino.cpp src/ledgames/tetriminos/Tetrimino.h src/ledgames/tetriminos/ITetrimino.cpp src/ledgames/tetriminos/ITetrimino.h src/ledgames/GameTetris.cpp src/ledgames/GameTetris.h src/ledgames/common.h src/ledgames/common.cpp src/ledgames/Gamepad.cpp src/ledgames/Gamepad.h src/ledgames/tetriminos/TTetrimino.cpp src/ledgames/tetriminos/TTetrimino.h src/ledgames/tetriminos/LTetrimino.cpp src/ledgames/tetriminos/LTetrimino.h src/ledgames/tetriminos/STetrimino.cpp src/ledgames/tetriminos/STetrimino.h src/ledgames/tetriminos/ZTetrimino.cpp src/ledgames/tetriminos/ZTetrimino.h src/ledgames/tetriminos/OTetrimino.cpp src/ledgames/tetriminos/OTetrimino.h src/ledgames/tetriminos/JTetrimino.cpp src/ledgames/tetriminos/JTetrimino.h src/ledgames/Bootstrap.cpp src/ledgames/Bootstrap.h)

# Add executable target with source files listed in SOURCE_FILES variable
add_executable(simple_example ${SOURCE_FILES})

target_link_libraries(simple_example -lallegro_primitives -lallegro_font -lallegro)