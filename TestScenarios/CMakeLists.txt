cmake_minimum_required(VERSION 2.8)

enable_testing()

if(CMAKE_COMPILER_IS_GNUCC)
add_definitions( -Wall -O0 -g)
endif(CMAKE_COMPILER_IS_GNUCC)

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

