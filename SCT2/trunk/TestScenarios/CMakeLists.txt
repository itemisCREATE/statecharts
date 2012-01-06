cmake_minimum_required(VERSION 2.8)

enable_testing()

if (CMAKE_COMPILER_IS_GNUCC)
#add_definitions( -Wall -O0 -g)
SET(CMAKE_C_FLAGS "-g -O2 -Wall -fprofile-arcs -ftest-coverage")
 
#SET(CMAKE_SHARED_LINKER_FLAGS="-fprofile-arcs -ftest-coverage")
#SET(CMAKE_EXE_LINKER_FLAGS "-fprofile-arcs -ftest-coverage")

endif (CMAKE_COMPILER_IS_GNUCC)

string(REGEX MATCH "clang" CMAKE_COMPILER_IS_CLANG "${CMAKE_C_COMPILER}")

if (CMAKE_COMPILER_IS_CLANG)
message("This is CLANG")
SET(CMAKE_C_FLAGS "-g -O0 -Wall")
endif (CMAKE_COMPILER_IS_CLANG)

if (COMPILE_SINGLETON)

message ("Compiling Singleton code")
add_subdirectory(src-gen-c-sgltn/InterfaceTest)
add_subdirectory(src-gen-c-sgltn/Test_Expression)
add_subdirectory(src-gen-c-sgltn/Test_Hierarchy)
add_subdirectory(src-gen-c-sgltn/Test_ParallelRegions)
add_subdirectory(src-gen-c-sgltn/Test_Transition)
add_subdirectory(src-gen-c-sgltn/Test_ShallowHistory)
add_subdirectory(src-gen-c-sgltn/Test_LocalActions)


add_subdirectory(test-c-sgltn/InterfaceTest)
add_subdirectory(test-c-sgltn/Test_Expression)
add_subdirectory(test-c-sgltn/Test_Hierarchy)
add_subdirectory(test-c-sgltn/Test_ParallelRegions)
add_subdirectory(test-c-sgltn/Test_Transition)
add_subdirectory(test-c-sgltn/Test_ShallowHistory)
add_subdirectory(test-c-sgltn/Test_LocalActions)

else (COMPILE_SINGLETON)

message ("Compiling Multi-Instance code")
add_subdirectory(src-gen-c/InterfaceTest)
add_subdirectory(src-gen-c/Test_Expression)
add_subdirectory(src-gen-c/Test_Hierarchy)
add_subdirectory(src-gen-c/Test_ParallelRegions)
add_subdirectory(src-gen-c/Test_Transition)
add_subdirectory(src-gen-c/Test_ShallowHistory)
add_subdirectory(src-gen-c/Test_LocalActions)


add_subdirectory(test-c/InterfaceTest)
add_subdirectory(test-c/Test_Expression)
add_subdirectory(test-c/Test_Hierarchy)
add_subdirectory(test-c/Test_ParallelRegions)
add_subdirectory(test-c/Test_Transition)
add_subdirectory(test-c/Test_ShallowHistory)
add_subdirectory(test-c/Test_LocalActions)

endif (COMPILE_SINGLETON)