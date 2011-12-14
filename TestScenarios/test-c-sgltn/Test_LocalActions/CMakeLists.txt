include_directories(../../src-gen-c-sgltn/Test_LocalActions)

add_executable(TestLocalActionsMain main.c)
target_link_libraries(TestLocalActionsMain Test_LocalActionsStatemachine)

add_test(Dummy1 TestLocalActionsMain "1")
add_test(Dummy2 TestLocalActionsMain "2")

