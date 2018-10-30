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
productionWebsite="https://www.itemis.com/en/yakindu/state-machine/documentation/user-guide/ \
                   https://www.itemis.com/en/yakindu/state-machine/documentation/tutorials/"
sandboxWebsite="http://761475.hs-sites.com/en/yakindu/state-machine/documentation/user-guide/ \
                http://761475.hs-sites.com/en/yakindu/state-machine/documentation/tutorials/"

usage() {
    echo "Usage: $0 { --eclipsehelp | --web  | --sandbox | --help }"
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
	    website="${productionWebsite}"
	    shift
            ;;
	-s | --sandbox)
            target="sandbox"
	    website="${sandboxWebsite}"
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

commonExcludes="http://groups.google.com/.*|https://github.com/Yakindu/.*|https://www.instagram.com/itemisag/|mailto:.*|https://itemisag.wistia.com/medias/9ek8usz18r|https://bugs.eclipse.org/.*|javascript:.*|tel:.*|https://cta-redirect.hubspot.com/|https://www.facebook.com/ItemisAg/"

if [ "${target}" == "eclipsehelp" ]
then
    checklink --broken --dir-redirects \
	--recursive --depth 1 \
	--exclude "${commonExcludes}" \
	${prefix}user-guide/c-domain.html \
	${prefix}user-guide/code_generation_cpp.textile \
	${prefix}user-guide/code_generation_c.textile \
	${prefix}user-guide/code_generation_custom.textile \
	${prefix}user-guide/code_generation_intro.textile \
	${prefix}user-guide/code_generation_java.textile \
	${prefix}user-guide/code_generation_statechart_image.textile \
	${prefix}user-guide/editing_statecharts.html \
	${prefix}user-guide/generating_code_headless.html \
	${prefix}user-guide/glossary.html \
	${prefix}user-guide/installation.html \
	${prefix}user-guide/overview.html \
	${prefix}user-guide/sctunit.html \
	${prefix}user-guide/simulating_statecharts.html \
	${prefix}user-guide/statechart_language.html \
	${prefix}tutorials/tutorials.html \
	2>&1 | tee log.txt
elif [ "${target}" == "web" -o "${target}" == "sandbox" ]
then
    checklink --broken --dir-redirects \
	--recursive --depth 1 \
	--exclude "${commonExcludes}"'|http://github.com/Yakindu/statecharts.*' \
	${website} \
        2>&1 | tee log.txt
else
    echo "Unknown target: ${target}"
    usage 1
fi
