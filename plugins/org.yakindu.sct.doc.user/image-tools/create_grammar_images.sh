#!/bin/sh

# Path + prefix of non-terminal symbols image files (PNG):
nti="../src/user-guide/images/docu_grammar_020_"

# Path + prefix of aggregated image files (PNG):
agi="../src/user-guide/images/docu_grammar_030_"

# Working directory containing PPM version of grammar image files:
wd="work"

setup_workdir()
{
    if [ \! -e ${wd} ]
    then
	echo "Creating working directory ${wd}."
	mkdir -p ${wd}
	echo "Populating working directory with PPM images."
	for i in ${nti}*.png
	do
	    pngtopnm ${i} >"${wd}/`basename $i .png`.ppm"
	done
    fi
}

create_grammar_image()
{
    local targetName="$1";
    shift
    n=""
    for i in $*
    do
	n="${n} ${wd}/docu_grammar_020_${i}.ppm"
    done
    local outputFile="${agi}${targetName}.png"
    echo "Creating grammar image file ${outputFile}."
    pnmcat -topbottom -jleft ${n} | \
	pnmtopng -compression 9 >"${outputFile}"
}


setup_workdir

# Transition: overview
create_grammar_image transition-overview \
    transitionreaction \
    stexttrigger \
    reactiontrigger \
    defaulttrigger \

# Transition: detailed
create_grammar_image transition-detailed \
    transitionspecification \
    transitionreaction \
    stexttrigger \
    reactiontrigger \
    eventspec \
    regulareventspec \
    simplefeaturecall \
    simpleelementreferenceexpression \
    timeeventspec \
    timeeventtype \
    conditionalexpression \
    timeunit \
    builtineventspec \
    entryevent \
    exitevent \
    alwaysevent \
    defaulttrigger \
    reactioneffect \
    eventraisingexpression \
    featurecall \
    transitionproperty \
    entrypointspec \
    exitpointspec
