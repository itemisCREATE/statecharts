SET( LOCALDIR ../../src-gen-c/Test_ParallelRegions)
include_directories( ${LOCALDIR} )

add_executable(TimingParallelRegionsMain main.c)
target_link_libraries(TimingParallelRegionsMain Test_ParallelRegionsStatemachine rt)

