#!/bin/sh

# Check links in the generated documentation. This script runs on Linux and
# assumes the "linkchecker" program to be installed.
#

requiredBaseDir="org.yakindu.sct.doc.user"



#
# Check whether this script is executed in the required base directory.
#
dir=`pwd`
basedir=`basename ${dir}`
if [ "${basedir}" != "${requiredBaseDir}" ]
then
    echo "This script must be executed in the …/${requiredBaseDir} directory."
    echo "Please \"cd\" to the …/${requiredBaseDir} directory and retry!"
    exit 1
fi


#
# Common options for both linkchecker runs:
#
commonOptions="--anchors --check-css --check-extern --check-html --recursion-level=1 --stdin"



if [ "$1" = "--website" -o "$1" = "--both" ]
then

    # Check links in the website documentation:

    find website -name "*.html" | \
        linkchecker ${commonOptions} \
        --ignore-url="PLUGINS_ROOT/org\.eclipse\.platform\.doc\.user/gettingStarted/qs-01\.htm" \
        --ignore-url="file:///.+com\.yakindu\.traceability\.help/website/fonts/" \
        --ignore-url="file://static.hsappstatic.net/social_shared/static-2.2815/img/followme/icon_twitter.png" \
        --ignore-url="file:///_hcms/raw-resource" \
        --ignore-url="file://info\.itemis\.com/hs-fs/hubfs/itemis_Logos/itemis-Marke-200.png" \
        --ignore-url="file://info.itemis.com/hs-fs/hubfs/Yakindu-Bildmarke.png" \
        --ignore-url="file://static.hsappstatic.net/social_shared/static-2.2815/img/.*" \
        --ignore-url="file://cdn2.hubspot.net/hub/" \
        --ignore-url="file://.+/com.yakindu.traceability.help/website/%7B%7B%20site_settings.favicon_src%20%7D%7D" \
        --ignore-url="file://.+/com.yakindu.traceability.help/website/%7B%7B%20get_public_template_url" \
        --ignore-url="file://.+/com.yakindu.traceability.help/user-guide/"
elif [ "$1" = "--eclipsehelp" -o "$1" = "--both" ]
then

    # Check links in the Eclipsehelp documentation:

    find help -name "*.html" | \
        linkchecker ${commonOptions} \
        --ignore-url="PLUGINS_ROOT/org\.eclipse\.platform\.doc\.user/gettingStarted/qs-01\.htm"
else
    echo "Usage: $0 [ --website | --eclipsehelp | --both ]"
fi
