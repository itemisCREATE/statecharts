

include_directories(../../src-gen-c/InterfaceTest)

add_executable(InterfaceTestStatemachineMainOO main.cpp)
target_link_libraries(InterfaceTestStatemachineMainOO InterfaceTestStatemachine)

add_test(Interface_test_default_interface_good InterfaceTestStatemachineMainOO "1")
add_test(Interface_test_default_interface_bad InterfaceTestStatemachineMainOO "2")
