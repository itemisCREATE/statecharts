#!/bin/sh

# This script assembles aggregated railway graph images from logically
# (basic) related railway graph images.
#
# 1. Railway graph images *.png should exist.
# 2. The script crops all these images, puts a white border around them, and writes
#    them into a working directory as PPM files. That is, the user does not have to
#    provide properly cropped images, but just rough cuts of individual productions
#    from an Xtext syntax graph.
# 3. The script creates images of groups of related railway graph images by calling
#    the (internally defined) "create_grammar_image" command. For example, running
#    the command
#
#        create_grammar_image reaction-effect \
#            reactioneffect \
#            eventraisingexpression
#
#    expects the files "docu_grammar_020_reactioneffect.ppm" and
#    "docu_grammar_020_eventraisingexpression.ppm" to exist in the working directory.
#    These images are concatenated top to bottom in the given order, i.e. "reactioneffect"
#    on top, "eventraisingexpression" below, and the result will be written to the
#    file "${docuAgi}reaction-effect.png".


# Working directory containing PPM versions of grammar image files:
wd="work"

# Prefix of statechart language non-terminal symbols image files:
docuNtiPrefix="docu_grammar_020_"

# Prefix of statechart language aggregated symbols image files:
docuAgiPrefix="docu_grammar_030_"

# Path + prefix of statechart language non-terminal symbols image files (PNG):
docuNti="../src/user-guide/images/${docuNtiPrefix}"

# Path + prefix of statechart language aggregated image files (PNG):
docuAgi="../src/user-guide/images/${docuAgiPrefix}"


# Prefix of statechart language non-terminal symbols image files:
sctunitNtiPrefix="sctunit_grammar_020_"

# Prefix of statechart language aggregated symbols image files:
sctunitAgiPrefix="sctunit_grammar_030_"

# Path + prefix of statechart language non-terminal symbols image files (PNG):
sctunitNti="../src/user-guide/images/${sctunitNtiPrefix}"

# Path + prefix of statechart language aggregated image files (PNG):
sctunitAgi="../src/user-guide/images/${sctunitAgiPrefix}"



setup_workdir()
{
    if [ \! -e ${wd} ]
    then
	echo "Creating working directory ${wd}."
	mkdir -p ${wd}
	echo "Populating working directory with PPM images."
	for i in ${docuNti}*.png ${sctunitNti}*.png
	do
	    pngtopnm ${i} | pnmcrop | pnmmargin -white 10 >"${wd}/`basename $i .png`.ppm"
	done
    fi
}

create_grammar_image()
{
    local targetName="$1"
    shift
    n=""
    for i in $*
    do
	n="${n} ${wd}/${ntiPrefix}${i}.ppm"
    done
    local outputFile="${agi}${targetName}.png"
    echo "Creating grammar image file ${outputFile}"
    pnmcat -topbottom -jleft ${n} | \
	pnmtopng -compression 9 >"${outputFile}"
}


setup_workdir

ntiPrefix="${docuNtiPrefix}"
agiPrefix="${docuAgiPrefix}"
agi="${docuAgi}"

# Transition: overview
create_grammar_image transition-overview \
    transitionreaction \
    stexttrigger \
    reactiontrigger \
    defaulttrigger \

# Transition: event trigger + guard
create_grammar_image transition-eventtrigger \
    transitionreaction \
    stexttrigger \
    reactiontrigger \
    defaulttrigger

# Transition: reaction effect
create_grammar_image reaction-effect \
    reactioneffect \
    eventraisingexpression

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

# State: overview
create_grammar_image state-overview \
    statescope \
    localreaction \

# Local reaction
create_grammar_image state-localreaction \
    localreaction \
    reactiontrigger \
    reactioneffect

# Event specification overview
create_grammar_image event-specification-overview \
    reactiontrigger \
    eventspec \
    regulareventspec \
    timeeventspec \
    timeeventtype \
    timeunit \
    builtineventspec \
    entryevent \
    exitevent \
    alwaysevent

# Guard condition overview
create_grammar_image guard-condition-overview \
    reactiontrigger \
    guard



#
# SCTUnit grammar
#

ntiPrefix="${sctunitNtiPrefix}"
agiPrefix="${sctunitAgiPrefix}"
agi="${sctunitAgi}"

# Test package
create_grammar_image test_unit \
    testpackage \
    packageimport \
    namedsctunitelement \
    sctunitelement

# Operation
create_grammar_image operation \
    sctunitoperation \
    statementblock \
    teststatement

# Assertion
create_grammar_image assertion \
    assertionstatement \
    verifystatement

# Process
create_grammar_image proceed \
    proceedstatement \
    proceedunit
