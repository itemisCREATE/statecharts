package org.yakindu.sct.doc.user.wikitext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder;

/**
 * <p>
 * This document builder collects the headings from a textile stream and creates
 * a table of contents
 * </p>
 * 
 * @author Rainer Klute,
 *         <a href="mailto:rainer.klute@itemis.de">rainer.klute@itemise.de</a>,
 *         2017-09-25
 */
public class TableOfContentsBuilder extends DocumentBuilder {

	private final List<Heading> headings;
	private boolean isProcessingHeading = false;
	private boolean isEarlySeparator = false;
	private Heading currentHeading;
	private String resource;

	/**
	 * <p>
	 * Returns the headings collected by this {@link TableOfContentsBuilder}.
	 * </p>
	 */
	public List<Heading> getHeadings() {
		return headings;
	}

	/**
	 * <p>
	 * Sets the currently processed resource, e.g. a filename.
	 * </p>
	 * 
	 * @param resource
	 *            the resource
	 */
	public void setResource(final String resource) {
		this.resource = resource;
	}

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 */
	public TableOfContentsBuilder() {
		this.headings = new ArrayList<Heading>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#beginDocument()
	 */
	@Override
	public void beginDocument() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#endDocument()
	 */
	@Override
	public void endDocument() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#beginBlock(org.eclipse.
	 * mylyn.wikitext.parser.DocumentBuilder.BlockType,
	 * org.eclipse.mylyn.wikitext.parser.Attributes)
	 */
	@Override
	public void beginBlock(BlockType type, Attributes attributes) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#endBlock()
	 */
	@Override
	public void endBlock() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#beginSpan(org.eclipse.
	 * mylyn.wikitext.parser.DocumentBuilder.SpanType,
	 * org.eclipse.mylyn.wikitext.parser.Attributes)
	 */
	@Override
	public void beginSpan(SpanType type, Attributes attributes) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#endSpan()
	 */
	@Override
	public void endSpan() {
	}

	/**
	 * <p>
	 * The begin of a heading has been encountered. If it is an H1 heading, we
	 * have to write the first part of the contents template into the stream.
	 * Placeholders <em>${h1.id}</em> and <em>${h1.title}</em> have to be
	 * replaced by actual values.
	 * </p>
	 * <p>
	 * <strong>Please note:</strong> At this point the title text is not yet
	 * known! This is only the case at {@link #endHeading()}.
	 * </p>
	 */
	@Override
	public void beginHeading(final int level, final Attributes attributes) {
		isProcessingHeading = true;
		final String id = attributes.getId();
		isEarlySeparator = level == 1 && "%EARLY_SEPARATOR%".equals(attributes.getCssStyle());
		if (!isEarlySeparator)
			currentHeading = new Heading(resource, level, id);
	}

	@Override
	public void endHeading() {
		if (!isEarlySeparator) {
			headings.add(currentHeading);
			isProcessingHeading = false;
		}
	}

	@Override
	public void characters(final String text) {
		if (isProcessingHeading && !isEarlySeparator) {
			if (currentHeading.getTitle() == null)
				currentHeading.setTitle(text);
			else
				currentHeading.appendToTitle(text);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#entityReference(java.
	 * lang.String)
	 */
	@Override
	public void entityReference(String entity) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#image(org.eclipse.mylyn
	 * .wikitext.parser.Attributes, java.lang.String)
	 */
	@Override
	public void image(Attributes attributes, String url) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#link(org.eclipse.mylyn.
	 * wikitext.parser.Attributes, java.lang.String, java.lang.String)
	 */
	@Override
	public void link(Attributes attributes, String hrefOrHashName, String text) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#imageLink(org.eclipse.
	 * mylyn.wikitext.parser.Attributes,
	 * org.eclipse.mylyn.wikitext.parser.Attributes, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void imageLink(Attributes linkAttributes, Attributes imageAttributes, String href, String imageUrl) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#acronym(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void acronym(String text, String definition) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.wikitext.parser.DocumentBuilder#lineBreak()
	 */
	@Override
	public void lineBreak() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.wikitext.parser.DocumentBuilder#charactersUnescaped(
	 * java.lang.String)
	 */
	@Override
	public void charactersUnescaped(String literal) {
	}

}
