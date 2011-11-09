cmake_minimum_required(VERSION 2.8)

enable_testing()

add_definitions( -Wall -O0 -g)

add_subdirectory(src-gen-c/InterfaceTest.sct)
add_subdirectory(test-c/InterfaceTest)

