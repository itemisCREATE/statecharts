include_directories(../../src-gen-c/Test_ShallowHistory)

add_executable(TestShallowHistoryMain main.c)
target_link_libraries(TestShallowHistoryMain Test_ShallowHistoryStatemachine)

add_test(Dummy1 TestShallowHistoryMain "1")
add_test(Dummy2 TestShallowHistoryMain "2")

