SET( LOCALDIR ../../src-gen-c/Test_ParallelRegions)
include_directories( ${LOCALDIR} )

add_executable(TestParallelRegionsMain main.c)
target_link_libraries(TestParallelRegionsMain Test_ParallelRegionsStatemachine)

add_test(test_initialization TestParallelRegionsMain "1")
add_test(test_state1_transition_event1 TestParallelRegionsMain "2")
add_test(test_state1_transition_and_back TestParallelRegionsMain "3")
add_test(test_state1_transition_and_back_from_state3 TestParallelRegionsMain "4")
add_test(test_state1_transition_and_back_from_state7 TestParallelRegionsMain "5")
add_test(test_state1_transition_to_State4 TestParallelRegionsMain "6")
add_test(test_parallel_event3_handling_state5_state7 TestParallelRegionsMain "7")
add_test(test_preference_event3_leaving_state3_and_state7 TestParallelRegionsMain "8")