package org.yakindu.sct.doc.user.wikitext;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.builder.HtmlDocumentBuilder;

/**
 * <p>
 * This document builder creates a Hubspot document with a table of contents. It
 * extends MyLyn Wikitext's {@link HtmlDocumentBuilder} class. The resulting
 * document consists of the following compartments:
 * </p>
 * 
 * <ol>
 * <li>
 * <p>
 * The <em>p1</em> compartment is a piece of text that is read from the
 * <em>p1</em> reader and copied unmodified to the output document.
 * </p>
 * </li>
 * <li>
 * <p>
 * The <em>table of contents</em> compartment contains the document's table of
 * contents. Each H1 entry and its subordinated H2 entries will be rendered
 * using a "template". That template is a piece of text – usually consting of
 * Hubspot instructions – that is read from the <em>tocTemplate</em> reader.
 * Placeholders like <code>${h1.id}</code> or <code>${h1.title}</code> will be
 * replaced by the current H1 heading's ID and title, respectively.
 * <code>${h2.toc}</code> will be replaced by the subordinated headings,
 * currently H2 entries only. These entries are generated purely
 * programmatically.
 * </p>
 * </li>
 * <li>
 * <p>
 * The <em>p2</em> compartment is a piece of text that is read from the
 * <em>p2</em> reader and copied unmodified to the output document.
 * </p>
 * </li>
 * <li>
 * <p>
 * The <em>contents</em> compartment contains the actual document contents. Each
 * H1 chapter will be rendered using a "template". That template is a piece of
 * text – usually consisting of Hubspot instructions – that is read from the
 * <em>contentsTemplate</em> reader. Placeholders like <code>${h1.id}</code>,
 * <code>${h1.title}</code>, or <code>${h1.contents}</code> will be replaced by
 * the current H1 heading's ID, title, and the contents of that section,
 * respectively.
 * </p>
 * </li>
 * <li>
 * <p>
 * The <em>p3</em> compartment is a piece of text that is read from the
 * <em>p3</em> reader and and copied unmodified to the output document.
 * </p>
 * </li>
 * </ol>
 * 
 * <p>
 * H1 headlines are used to separate sections. However, sometimes certain text
 * elements preceed the H1 that must go into the same section, for instance if
 * the H1 and subsequent elements are encapsulated in a DIV element. In this
 * case, you can place an "early separator" before the DIV's start tag. The
 * early separator is a pseudo H1 headline with a very special CSS class. It
 * looks like this:
 * </p>
 * 
 * <pre>
 * h1{%EARLY_SEPARATOR%}. Some text
 * </pre>
 * 
 * @author Rainer Klute,
 *         <a href="mailto:rainer.klute@itemis.de">rainer.klute@itemise.de</a>,
 *         2017-08-28
 */
public class HubspotDocumentBuilder extends HtmlDocumentBuilder {

	final String p1;
	final String p2;
	final String p3;
	final String[] contentsTemplate;
	final String[] tocTemplate;
	boolean isFirstH1 = true;
	final List<Heading> headings = new ArrayList<Heading>();

	private PrintWriter w;
	private String resource = "";
	private boolean isProcessingHeading = false;
	private boolean isEarlySeparator = false;
	private boolean isFollowingEarlySeparator = false;
	private Heading currentHeading;

	/*
	 * Used to collect stuff between an early separator and the next H1 heading:
	 */
	private HtmlDocumentBuilder h2 = null;
	private StringWriter s2 = null;
	private PrintWriter w2 = null;
	private List<Heading> pass1Headings;

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
	 * Constructor. Reads all the required static files and template files.
	 * </p>
	 * 
	 * @param properties
	 * 
	 * @param pass1Headings
	 */
	public HubspotDocumentBuilder(final Reader p1Reader, final Reader contentsTemplateReader, final Reader p2Reader,
			final Reader tocTemplateReader, final Reader p3Reader, final Map<String, String> properties,
			final List<Heading> pass1Headings, final Writer writer) {
		super(writer, true);
		this.pass1Headings = pass1Headings;
		try {
			this.p1 = resolveProperties(readContents(p1Reader, false), properties);
			this.p2 = resolveProperties(readContents(p2Reader, false), properties);
			this.p3 = resolveProperties(readContents(p3Reader, false), properties);
		} catch (IOException e) {
			throw new RuntimeException("Reading one the p files failed.", e);
		}
		try {
			this.contentsTemplate = splitContentsTemplate(contentsTemplateReader);
		} catch (IOException e) {
			throw new RuntimeException("Reading the contents template failed.", e);
		}
		try {
			this.tocTemplate = splitTocTemplate(tocTemplateReader);
		} catch (IOException e) {
			throw new RuntimeException("Reading the TOC template failed.", e);
		}
		if (writer instanceof PrintWriter)
			w = (PrintWriter) writer;
		else
			w = new PrintWriter(writer);
	}

	/**
	 * <p>
	 * Replaces all occurrences of the <var>properties</var> map's "key" entries
	 * in a string by the corresponding "value" entries. Replacement starts at
	 * the beginning of the string and proceeds to the end. However, the
	 * processing order of the properties is undefined.
	 * </p>
	 * 
	 * @param s
	 *            the string to do the replacements in
	 * @param properties
	 *            the properties map
	 * @return the resulting string with all replacements done
	 */
	private String resolveProperties(final String s, final Map<String, String> properties) {
		String result = s;
		for (final String key : properties.keySet()) {
			System.out.println("Replacing \"" + key + "\" by \"" + properties.get(key) + "\"");
			result = result.replace(key, properties.get(key));
		}
		return result;
	}

	/**
	 * <p>
	 * When the beginning of the document is encountered the P1 part is written
	 * to the output.
	 * </p>
	 */
	@Override
	public void beginDocument() {
		/* Copy the P1 string to the output: */
		w.print(p1);

		/*
		 * Create the table of contents. Each H1 heading and its subordinate
		 * headings are encapsulated in the TOC template.
		 */

		Heading h1Heading = null;
		for (final Heading h : pass1Headings) {
			if (h.getLevel() == 1) {
				if (h1Heading != null)
					/*
					 * Close the previously opened H1 encapsulation, unless we
					 * are processing the very first H1:
					 */
					w.println(resolveHeadingIdAndTitle(tocTemplate[1], 1, h1Heading.getId(), h1Heading.getTitle()));
				/* Open the H1 encapsulation for the current H1 heading: */
				w.println(resolveHeadingIdAndTitle(tocTemplate[0], 1, h.getId(), h.getTitle()));
				h1Heading = h;
			} else if (h.getLevel() == 2)
				/* H2 headings are rendered within an H1 encapsulation: */
				w.println(resolveHeadingIdAndTitle("<li><a href=\"#${h2.id}\">${h2.title}</a></li>", 2, h.getId(),
						h.getTitle()));
		}
		/*
		 * Close the last H1 encapsulation:
		 */
		w.println(resolveHeadingIdAndTitle(tocTemplate[1], 1, h1Heading.getId(), h1Heading.getTitle()));

		/* Copy the P2 string to the output: */
		w.print(p2);

		/*
		 * We don't call the superclass' beginDocument() method here, because
		 * the beginning part of the resulting document should be provided by
		 * the P1 part.
		 */
	}

	/**
	 * <p>
	 * At the end of the document, any open H1 Hubspot encapsulation is closed.
	 * Then the P2 part is written to the output, followed by the table of
	 * contents, followed by the P3 part.
	 * </p>
	 */
	@Override
	public void endDocument() {

		/* Close the current H1 encapsulation, if any: */
		Heading h1Heading = lookupLastH1Heading(pass1Headings);
		w.print(resolveHeadingIdAndTitle(contentsTemplate[1], 1, h1Heading.getId(), h1Heading.getTitle()));

		/* Copy the P3 string to the output: */
		w.print(p3);

		/*
		 * We don't call the superclass' endDocument() method here, because the
		 * finnishing part of the resulting document should have been provided
		 * by the P3 part.
		 */

		w.close();
	}

	@Override
	public void beginBlock(final BlockType type, final Attributes attributes) {
		if (isEarlySeparator)
			h2.beginBlock(type, attributes);
		else
			super.beginBlock(type, attributes);
	}

	@Override
	public void endBlock() {
		if (isEarlySeparator)
			h2.endBlock();
		else
			super.endBlock();
	}

	@Override
	public void beginSpan(final SpanType type, final Attributes attributes) {
		if (isEarlySeparator) {
			if (!isProcessingHeading)
				h2.beginSpan(type, attributes);
		} else
			super.beginSpan(type, attributes);
	}

	@Override
	public void endSpan() {
		if (isEarlySeparator) {
			if (!isProcessingHeading)
				h2.endSpan();
		} else
			super.endSpan();
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
		if (!isEarlySeparator) {
			isFollowingEarlySeparator = isEarlySeparator;
			isEarlySeparator = level == 1 && "%EARLY_SEPARATOR%".equals(attributes.getCssStyle());
		} else {
			isFollowingEarlySeparator = isEarlySeparator;
			isEarlySeparator = false;
		}
		if (isEarlySeparator) {
			/*
			 * Collect everything between the early separator and the next H1 in
			 * another writer.
			 */
			s2 = new StringWriter();
			w2 = new PrintWriter(s2);
			h2 = new HtmlDocumentBuilder(w2);
		} else
			currentHeading = new Heading(resource, level, id);

		if (level == 1) {
			if (!isFirstH1 && !isFollowingEarlySeparator)
				w.print(resolveHeadingIdAndTitle(contentsTemplate[1], 1, id, null));
			else
				isFirstH1 = false;

			if (!isEarlySeparator) {
				w.println(resolveHeadingIdAndTitle(contentsTemplate[0], 1, id, null));
				if (isFollowingEarlySeparator) {
					w2.close();
					w.println(s2.toString());
					h2 = null;
					w2 = null;
				}
				super.beginHeading(level, attributes);
			}
		} else
			super.beginHeading(level, attributes);
	}

	@Override
	public void endHeading() {
		if (!isEarlySeparator) {
			headings.add(currentHeading);
			isProcessingHeading = false;
			super.endHeading();
		}
	}

	@Override
	public void characters(final String text) {
		if (isEarlySeparator) {
			if (!isProcessingHeading)
				h2.characters(text);
		} else if (isProcessingHeading) {
			if (currentHeading.getTitle() == null)
				currentHeading.setTitle(text);
			else
				currentHeading.appendToTitle(text);
			super.characters(text);
		} else
			super.characters(text);
	}

	@Override
	public void entityReference(final String entity) {
		if (isEarlySeparator)
			h2.entityReference(entity);
		else
			super.entityReference(entity);
	}

	@Override
	public void image(final Attributes attributes, final String url) {
		if (isEarlySeparator)
			h2.image(attributes, url);
		else
			super.image(attributes, url);
	}

	@Override
	public void link(final Attributes attributes, final String hrefOrHashName, final String text) {
		if (isEarlySeparator)
			h2.link(attributes, hrefOrHashName, text);
		else
			super.link(attributes, hrefOrHashName, text);
	}

	@Override
	public void imageLink(final Attributes linkAttributes, final Attributes imageAttributes, final String href,
			final String imageUrl) {
		if (isEarlySeparator)
			h2.imageLink(linkAttributes, imageAttributes, href, imageUrl);
		else
			super.imageLink(linkAttributes, imageAttributes, href, imageUrl);
	}

	@Override
	public void acronym(final String text, final String definition) {
		if (isEarlySeparator)
			h2.acronym(text, definition);
		else
			super.acronym(text, definition);
	}

	@Override
	public void lineBreak() {
		if (isEarlySeparator)
			h2.lineBreak();
		else
			super.lineBreak();
	}

	@Override
	public void charactersUnescaped(final String literal) {
		if (isEarlySeparator)
			h2.charactersUnescaped(literal);
		else
			super.charactersUnescaped(literal);
	}

	/**
	 * <p>
	 * Replaces the placeholders like <code>${h1.id}</code> and
	 * <code>${h1.title}</code> by actual values, if available. If an actual
	 * value is <code>null</code>, no replacement will be done. The level
	 * number, i.e. the "1" in <code>${h1.id}</code> and
	 * <code>${h1.title}</code> must be supplied as a parameter.
	 * </p>
	 * 
	 * @param s
	 *            The string containing the placeholders
	 * @param level
	 *            The level number of the heading
	 * @param id
	 *            The ID of the heading
	 * @param title
	 *            The title of the heading
	 * @return The result string
	 */
	private String resolveHeadingIdAndTitle(final String s, final int level, final String id, final String title) {
		String result = s;
		final String re = "\\$\\{h" + level + "\\.";
		if (id != null)
			result = result.replaceAll(re + "id}", id);
		if (title != null)
			result = result.replaceAll(re + "title}", title);
		return result;
	}
	/**
	 * <p>
	 * Splits the contents template into two parts: everything <em>before</em>
	 * <code>${h1.contents}</code> and everything <em>after</em> that string.
	 * 
	 * @param contentsTemplateReader
	 *            reader containing the contents template
	 * @return a string array with two fields representing the two parts.
	 * @throws IOException
	 *             if reading from the contents template reader fails
	 */
	private String[] splitContentsTemplate(final Reader contentsTemplateReader) throws IOException {
		return split(contentsTemplateReader, "${h1.contents}");
	}

	/**
	 * <p>
	 * Splits the TOC template into two parts: everything <em>before</em>
	 * <code>${h2.toc}</code> and everything <em>after</em> that string.
	 * 
	 * @param tocTemplateReader
	 *            reader containing the TOC template
	 * @return a string array with two fields representing the two parts.
	 * @throws IOException
	 *             if reading from the contents template reader fails
	 */
	private String[] splitTocTemplate(final Reader tocTemplateReader) throws IOException {
		return split(tocTemplateReader, "${h2.toc}");
	}

	/**
	 * <p>
	 * Splits the string read from a {@link Reader} into two parts: everything
	 * <em>before</em> a separator and everything <em>after</em> it.
	 * 
	 * @param reader
	 *            reader to read the string from
	 * @return a string array with two fields representing the two parts.
	 * @throws IOException
	 *             if reading from the reader fails
	 */
	private String[] split(final Reader reader, final String separator) throws IOException {
		final String s = readContents(reader, false);
		final String[] result = new String[2];
		final int beginPart1 = 0;
		final int endPart1 = s.indexOf(separator);
		final int beginPart2 = endPart1 + separator.length();
		final int endPart2 = s.length();
		if (endPart1 < 0) {
			result[0] = s;
			result[1] = "";
		} else if (endPart1 == 0) {
			result[0] = "";
			result[1] = s;
		} else if (endPart1 > 0) {
			result[0] = s.substring(beginPart1, endPart1);
			result[1] = s.substring(beginPart2, endPart2);
		}
		return result;
	}

	/**
	 * <p>
	 * Looks up the last H1 heading in a list of headings.
	 * </p>
	 * 
	 * @param headings
	 *            The list of heading to search
	 * @return The last H1 heading in the list of headings or <code>null</code>.
	 */
	private Heading lookupLastH1Heading(final List<Heading> headings) {
		final ListIterator<Heading> i = headings.listIterator(headings.size());
		Heading result = null;
		while (result == null && i.hasPrevious()) {
			final Heading h = i.previous();
			if (h.getLevel() == 1)
				result = h;
		}
		return result;
	}

	/**
	 * <p>
	 * Reads the complete contents of a {@link Reader} and returns it as a
	 * string.
	 * </p>
	 * 
	 * @param reader
	 *            The {@link Reader} to read from
	 * @param isRobustReading
	 *            If <code>true</code>, failing to read from the {@link Reader}
	 *            or a {@link Reader} of <code>null</code> won't result in an
	 *            error. Instead an empty string will be returned.
	 * @return see above
	 * @throws IOException
	 */
	private String readContents(final Reader reader, final boolean isRobustReading) throws IOException {
		final char[] buffer = new char[5000];
		final StringBuilder result = new StringBuilder();
		int read = 0;
		while (read >= 0) {
			read = reader.read(buffer, 0, buffer.length);
			if (read > 0)
				result.append(buffer, 0, read);
		}
		reader.close();
		return result.toString();
	}

}
