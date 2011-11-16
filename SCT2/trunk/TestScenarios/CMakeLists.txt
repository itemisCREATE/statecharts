cmake_minimum_required(VERSION 2.8)

enable_testing()

add_definitions( -Wall -O0 -g)

add_subdirectory(src-gen-c/InterfaceTest)
add_subdirectory(src-gen-c/Test_Expression)
add_subdirectory(src-gen-c/Test_Hierarchy)
add_subdirectory(test-c/InterfaceTest)
add_subdirectory(test-c/Test_Expression)
add_subdirectory(test-c/Test_Hierarchy)

