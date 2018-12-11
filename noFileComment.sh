#/bin/bash

find . -type f -name $1 | grep -E -v $2 | xargs -L1 -I % sh -c 'echo %:$(head -1 %)' | grep -E -v '/\*'
ret=$?
if [ $ret -eq 0 ] ; then
	echo "Error: The files listed above don't seem to have a file comment (copyright header)."
	exit 1
else
	exit 0
fi
