#!/bin/sh

#
# Check links in the generated documentation. This script runs on Linux and
# assumes
# - the W3C "checklink" program to be installed,
# - the generated documentation being "online", i.e. served by a web server.
#
# Use "python3 -m http.server 8082" to start a web server that serves
# the current directory.
#
#

prefix="http://localhost:8082/"
target="eclipsehelp"

usage() {
    echo "Usage: $0 { --eclipsehelp | --web | --help }"
    exit $1
}

# Read command line parameters
while [ "$1" != "" ]
do
    case "$1" in
	-e | --eclipsehelp)
            target="eclipsehelp"
	    shift
            ;;
	-w | --web)
            target="web"
	    shift
            ;;
	-h | --help)
	    usage 0
            ;;
	-*)
	    echo "Illegal option: $1"
	    usage 1
            ;;
	*)
	    file="$1"
	    shift
            ;;
    esac
done

if [ "${target}" == "eclipsehelp" ]
then
    checklink --broken --dir-redirects \
	--recursive --depth 1 \
	--exclude https://github.com/Yakindu/.* \
	${prefix}user-guide/advanced_simulation.html \
	${prefix}user-guide/c-domain.html \
	${prefix}user-guide/editing_statecharts.html \
	${prefix}user-guide/generating_code_headless.html \
	${prefix}user-guide/generating_code.html \
	${prefix}user-guide/glossary.html \
	${prefix}user-guide/overview.html \
	${prefix}user-guide/sctunit.html \
	${prefix}user-guide/simulating_statecharts.html \
	${prefix}user-guide/statechart_language.html \
	${prefix}tutorials/tutorials.html \
	2>&1 | tee log.txt
elif [ "${target}" == "web" ]
then
    checklink --broken --dir-redirects \
	--recursive --depth 1 \
	--exclude https://github.com/Yakindu/.* \
	https://www.itemis.com/en/yakindu/state-machine/documentation/user-guide/ \
        2>&1 | tee log.txt
else
    echo "Unknown target: ${target}"
    usage 1
fi
