

include_directories(../../src-gen-c/Test_Expression)

add_executable(TestExpressionMain main.c)
target_link_libraries(TestExpressionMain Test_ExpressionStatemachine)

add_test(test_default_other_var1 TestExpressionMain "1")
add_test(test_default_other_var2_var3 TestExpressionMain "2")
