

include_directories(../../src-gen-c/InterfaceTest)

add_executable(InterfaceTestStatemachineMain main.c)
target_link_libraries(InterfaceTestStatemachineMain InterfaceTestStatemachine)

add_test(test_default_interface_good InterfaceTestStatemachineMain "1")
add_test(test_default_interface_bad InterfaceTestStatemachineMain "2")
add_test(test_other_interface_good InterfaceTestStatemachineMain "3")
add_test(test_other_interface_bad InterfaceTestStatemachineMain "4")
add_test(test_third_interface_good InterfaceTestStatemachineMain "5")
add_test(test_third_interface_bad InterfaceTestStatemachineMain "6")
add_test(test_namespaces InterfaceTestStatemachineMain "7")
