
cmake_minimum_required(VERSION 2.8)

set ( Boost_USE_STATIC_LIBS ON )
set ( Boost_DEBUG OFF )
find_package( Boost 1.44 COMPONENTS thread system date_time regex)
find_library(YACOP_SM NAMES InterfaceTestStatemachineyacop HINTS C:/Users/seger/runtime-HMIDevel/TestScenarios/src-gen-yacop/build)
find_library(YACOP_COM NAMES YakinduCom HINTS C:/Users/seger/workspace-hmi-allplugins/YakinduCom/build/src)

include_directories(${Boost_INCLUDE_DIRS} src "C:/segerlocal/include" "../src-gen-yacop")

add_executable(InterfaceTestStatemachineMain main.cpp)
target_link_libraries(InterfaceTestStatemachineMain ${YACOP_SM} ${YACOP_COM} 
${Boost_LIBRARIES})

