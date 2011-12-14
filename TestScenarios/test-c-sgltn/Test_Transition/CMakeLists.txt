include_directories(../../src-gen-c-sgltn/Test_Transition)

add_executable(TestTransitionMain main.c)
target_link_libraries(TestTransitionMain Test_TransitionStatemachine)

add_test(d_test_state9_state10_transition TestTransitionMain "1")
add_test(d_test_state1_state2_back_transition TestTransitionMain "2")

