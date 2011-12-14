cmake_minimum_required(VERSION 2.8)

enable_testing()

if (CMAKE_COMPILER_IS_GNUCC)
add_definitions( -Wall -O0 -g)
endif (CMAKE_COMPILER_IS_GNUCC)

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