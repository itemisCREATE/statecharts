include_directories(../../src-gen-c/Test_Transition)

add_executable(TestTransitionMain main.c)
target_link_libraries(TestTransitionMain Test_TransitionStatemachine)

add_test(Dummy1 TestTransitionMain "1")
add_test(Dummy2 TestTransitionMain "2")

