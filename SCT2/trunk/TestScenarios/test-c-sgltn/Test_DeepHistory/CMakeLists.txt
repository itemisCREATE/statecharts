include_directories(../../src-gen-c-sgltn/Test_DeepHistory)

add_executable(TestDeepHistoryMain main.c)
target_link_libraries(TestDeepHistoryMain Test_DeepHistoryStatemachine)

add_test(initialJumpToState3 TestDeepHistoryMain "1")
add_test(initialJumpToState5 TestDeepHistoryMain "2")

