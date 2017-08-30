#!/usr/bin/perl -w

use Switch;

# $prefix = "edit";

sub processTableLine {
    $_ = "$_[0]";

    s|width="(.*)?"||g;
    s|cellpadding="(.*)?"||g;
    s|cellspacing="(.*)?"||g;

    s|<col (.*)?>||g;

    return $_;
}



while (<>)
{
    $a = $_;

    # Headers:
    if ($a =~ m|^h\d\(#|) {
	if ($a =~ m|-|) {
	    print $_;
	}
    }

    # Links:
#    if (m|":#|g) {
#	print;
#    }

}
