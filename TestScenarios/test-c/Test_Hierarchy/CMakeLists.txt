include_directories(../../src-gen-c/Test_Hierarchy)

add_executable(TestHierarchyMain main.c)
target_link_libraries(TestHierarchyMain Test_HierarchyStatemachine)

add_test(Hierarchy_test_state9_state10_transition TestHierarchyMain "1")
add_test(Hierarchy_test_state1_state2_back_transition TestHierarchyMain "2")

