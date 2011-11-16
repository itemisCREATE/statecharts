include_directories(../../src-gen-c/Test_Hierarchy)

add_executable(TestHierarchyMain main.c)
target_link_libraries(TestHierarchyMain Test_HierarchyStatemachine)

add_test(test_default_other_var1 TestHierarchyMain "1")
add_test(test_default_other_var2_var3 TestHierarchyMain "2")

