include_directories(../../src-gen-c/Test_Transition)

add_executable(TestTransitionMain main.c)
target_link_libraries(TestTransitionMain Test_TransitionStatemachine)

add_test(test_transition_with_AEvent1_value_gt5 TestTransitionMain "1")
add_test(test_transition_with_AEvent1_value_is0 TestTransitionMain "2")

