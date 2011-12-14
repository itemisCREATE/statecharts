include_directories(../../src-gen-c-sgltn/Test_ParallelRegions)

add_executable(TestParallelRegionsMain main.c)
target_link_libraries(TestParallelRegionsMain Test_ParallelRegionsStatemachine)

add_test(Dummy1 TestParallelRegionsMain "1")
add_test(Dummy2 TestParallelRegionsMain "2")

