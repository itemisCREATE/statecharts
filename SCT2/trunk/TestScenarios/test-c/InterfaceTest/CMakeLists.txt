

include_directories(../../src-gen-c/InterfaceTest.sct)

add_executable(InterfaceTestStatemachineMain main.c)
target_link_libraries(InterfaceTestStatemachineMain InterfaceTestStatemachine)

add_test(test_default_interface_good InterfaceTestStatemachineMain "1")
add_test(test_default_interface_bad InterfaceTestStatemachineMain "2")
