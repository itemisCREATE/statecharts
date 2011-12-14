

include_directories(../../src-gen-c-sgltn/Test_Expression)

add_executable(TestExpressionMain main.c)
target_link_libraries(TestExpressionMain Test_ExpressionStatemachine)

add_test(Expression_test_initialization_and_first_entry TestExpressionMain "1")
add_test(Expression_test_default_other_var1 TestExpressionMain "2")
add_test(Expression_test_default_other_var2_var3 TestExpressionMain "3")
add_test(Expression_test_onCycle TestExpressionMain "4")
