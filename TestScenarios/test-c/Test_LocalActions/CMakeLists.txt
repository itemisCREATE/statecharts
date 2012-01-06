include_directories(../../src-gen-c/Test_LocalActions)

add_executable(TestLocalActionsMain main.c)
target_link_libraries(TestLocalActionsMain Test_LocalActionsStatemachine)

add_test(localActions_check_initial_entry TestLocalActionsMain "1")
add_test(localActions_check_transition_entry TestLocalActionsMain "2")
add_test(localActions_check_transition_exit TestLocalActionsMain "3")
