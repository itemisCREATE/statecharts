SET (CTEST_PROJECT_NAME TestScenarios)
SET (CTEST_CMAKE_GENERATOR "Unix Makefiles")

SET (CTEST_SOURCE_DIRECTORY "/home/yorn/runtime-New_configuration/TestScenarios")
SET (CTEST_BINARY_DIRECTORY "/tmp/build")

# which ctest command to use for running the dashboard
SET (CTEST_COMMAND 
  "/usr/bin/ctest -D ExperimentalCoverage"
  )

# what cmake command to use for configuring this dashboard
SET (CTEST_CMAKE_COMMAND 
  "/usr/bin/cmake"
  )

set (CTEST_COVERAGE_COMMAND "/usr/bin/gcov")
SET (CMAKE_C_COMPILER "/usr/bin/clang")
SET (CTEST_START_WITH_EMPTY_BINARY_DIRECTORY TRUE)

CTEST_START (ExperimentalCoverage)
#CTEST_UPDATE (SOURCE "${CTEST_SOURCE_DIRECTORY}")
CTEST_CONFIGURE (BUILD "${CTEST_BINARY_DIRECTORY}")
# turn on coverage for build and test
#SET(RES 1)
#EXECUTE_PROCESS(COMMAND ${COV01} -1 RESULT_VARIABLE RES)
#IF(RES)
# MESSAGE(FATAL_ERROR "could not run cov01 -1")
#ENDIF(RES)
CTEST_BUILD (BUILD "${CTEST_BINARY_DIRECTORY}")
CTEST_TEST  (BUILD "${CTEST_BINARY_DIRECTORY}")
CTEST_COVERAGE(BUILD "${CTEST_BINARY_DIRECTORY}")
#CTEST_SUBMIT ()
#EXECUTE_PROCESS(COMMAND ${COV01} -0 RESULT_VARIABLE RES)
