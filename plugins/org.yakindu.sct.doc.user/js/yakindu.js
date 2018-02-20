function copyPermalinkToClipboard(event, element) {
	event.preventDefault();
    var origin = (window.location.origin != 'null') ? window.location.origin : window.location.href;
    var permalink = origin + window.location.pathname + '#' + jQuery(element).parent().attr('id');

	var textInput = document.createElement("input");
	textInput.style.position = 'fixed';
	textInput.style.top = '230px';
	textInput.style.left = 0;
	textInput.style.width = '2em';
	textInput.style.height = '2em';
	textInput.style.padding = 0;
	textInput.style.border = 'none';
	textInput.style.outline = 'none';
	textInput.style.boxShadow = 'none';
	textInput.style.background = 'transparent';
	textInput.value = permalink;

	document.body.appendChild(textInput);
	textInput.select();

	try {
		if (document.execCommand('copy')) {
			jQuery(element).find('.tooltip').html('Copied');
		}
	} catch (err) {
		alert('Permalink: ' + permalink);
		console.log('Oops, unable to copy', err);
	}

	document.body.removeChild(textInput);
	return false;
}

jQuery(document).ready(function() {
	jQuery('.permalink').on('focusout, mouseout', function() {
		jQuery(this).find('.tooltip').html('Copy link to clipboard');
	});
});
