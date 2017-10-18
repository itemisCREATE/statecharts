package org.yakindu.sct.doc.user.wikitext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.mylyn.wikitext.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.util.ServiceLocator;

/**
 * <p>
 * This application reads one or more documents in Textile format and converts
 * it into a Hubspot template document. In it's current state, the application
 * expects the resulting document to consist of several different compartments.
 * They are explained in the {@link HubspotDocumentBuilder} class documentation.
 * </p>
 * 
 * @author Rainer Klute,
 *         <a href="mailto:rainer.klute@itemis.de">rainer.klute@itemise.de</a>,
 *         2017-08-28
 *
 */
public class TextileToHubspotConverter {

	public static void main(String[] args) throws IOException {
		final List<String> inFileNames = new ArrayList<String>();
		String outFilename = null;
		String p1Filename = null;
		String contentsTemplateFilename = null;
		String p2Filename = null;
		String tocTemplateFilename = null;
		String p3Filename = null;
		final Map<String, String> properties = new HashMap<String, String>();

		/*
		 * Parse command-line parameters:
		 */
		for (int i = 0; i < args.length; i++) {
			final String arg = args[i];
			if (arg.equals("-p1") || arg.equals("--p1-file")) {
				p1Filename = args[++i];
				continue;
			}
			if (arg.equals("-c") || arg.equals("--contents-template-file")) {
				contentsTemplateFilename = args[++i];
				continue;
			}
			if (arg.equals("-p2") || arg.equals("--p2-file")) {
				p2Filename = args[++i];
				continue;
			}
			if (arg.equals("-t") || arg.equals("--toc-template-file")) {
				tocTemplateFilename = args[++i];
				continue;
			}
			if (arg.equals("-p3") || arg.equals("--p3-file")) {
				p3Filename = args[++i];
				continue;
			}
			if (arg.equals("-i") || arg.equals("--input")) {
				inFileNames.add(args[++i]);
				continue;
			}
			if (arg.equals("-o") || arg.equals("--output")) {
				outFilename = args[++i];
				continue;
			}
			if (arg.equals("-p") || arg.equals("--property")) {
				final String nameValue = args[++i];
				addTo(properties, nameValue);
				continue;
			}
		}
		assertParameterIsSpecified(p1Filename, "P1 file not specified.");
		assertParameterIsSpecified(contentsTemplateFilename, "Contents template file not specified.");
		assertParameterIsSpecified(p2Filename, "P2 file not specified.");
		assertParameterIsSpecified(tocTemplateFilename, "TOC template file not specified.");
		assertParameterIsSpecified(p3Filename, "P3 file not specified.");
		assertParameterIsSpecified(inFileNames, "Input file(s) not specified.");
		assertParameterIsSpecified(outFilename, "Output file not specified.");

		/*
		 * Setup the TOC document builder:
		 */
		final TableOfContentsBuilder tocBuilder = new TableOfContentsBuilder();

		/*
		 * Concatenate all input files so that the Textile parser sees
		 * everything as one large input file:
		 */
		final Vector<Reader> readers = new Vector<Reader>(inFileNames.size());
		for (final String inFileName : inFileNames)
			readers.addElement(new FileReader(inFileName));
		Reader in = new SequenceReader(new Vector<Reader>(readers).elements());

		/*
		 * Create, configure, and run the Textile markup parser. It will call
		 * back into the table of contents builder, which will create the table
		 * of contents.
		 */
		MarkupParser markupParser = new MarkupParser();
		markupParser.setMarkupLanguage(ServiceLocator.getInstance().getMarkupLanguage("Textile"));
		markupParser.setBuilder(tocBuilder);
		markupParser.parse(in);
		List<Heading> headings = tocBuilder.getHeadings();

		/*
		 * Setup everything for the Hubspot document builder and process files:
		 */
		final Reader p1 = createFileReader(p1Filename, "P1 file not found");
		final Reader contentsTemplate = createFileReader(contentsTemplateFilename, "Contents template file not found");
		final Reader p2 = createFileReader(p2Filename, "P2 file not found");
		final Reader tocTemplate = createFileReader(tocTemplateFilename, "TOC template file not found");
		final Reader p3 = createFileReader(p3Filename, "P3 file not found");
		final Writer out = new FileWriter(outFilename);
		final HubspotDocumentBuilder docBuilder = new HubspotDocumentBuilder(p1, contentsTemplate, p2, tocTemplate, p3,
				properties, headings, out);

		/*
		 * Concatenate all input files so that the Textile parser sees
		 * everything as one large input file:
		 */
		/*
		 * Concatenate all input files so that the Textile parser sees
		 * everything as one large input file:
		 */
		readers.clear();
		for (final String inFileName : inFileNames)
			readers.addElement(new FileReader(inFileName));
		in = new SequenceReader(new Vector<Reader>(readers).elements());

		/*
		 * Create, configure, and run the Textile markup parser. It will call
		 * back into the document builder, which will construct the output
		 * document.
		 */
		markupParser = new MarkupParser();
		markupParser.setMarkupLanguage(ServiceLocator.getInstance().getMarkupLanguage("Textile"));
		markupParser.setBuilder(docBuilder);
		markupParser.parse(in);
		out.close();
	}

	/**
	 * <p>
	 * Add a name/value pair to a property map. The former is expected in the
	 * form <code>name=value</code>. Leading or trailing white space around name
	 * or value is removed. If the <code>=value</code> part or the
	 * <code>value</code> part is missing, the <code>name</code> property will
	 * be added with the value being the empty string. If the <code>name</code>
	 * part is missing, a {@link RuntimeException} will be thrown.
	 * </p>
	 * 
	 * @param properties
	 *            the map to add the name/value pair to
	 * @param nameValue
	 *            the name/value pair
	 */
	private static void addTo(final Map<String, String> properties, final String nameValue) {
		final int p = nameValue.indexOf('=');
		final String name;
		final String value;
		if (p > 1) {
			name = nameValue.substring(0, p);
			if (p < nameValue.length() - 1)
				value = nameValue.substring(p + 1);
			else
				value = "";
		} else if (p == 0) {
			value = nameValue.substring(1);
			throw new RuntimeException("Name/value pair does not contain a name. Value: \"" + value + "\"");
		} else {
			name = nameValue;
			value = "";
		}
		properties.put(name, value);
	}

	private static void assertParameterIsSpecified(final String p, final String msg) {
		if (p == null || p.trim().isEmpty())
			errorExit(msg);
	}

	private static void assertParameterIsSpecified(final List<String> p, final String msg) {
		if (p == null || p.isEmpty())
			errorExit(msg);
	}

	private static void errorExit(final String msg) {
		System.err.println(msg);
		System.err
				.println("Parameters: --p1-file part1File.htmlf" + " --contents-template-file contentTemplateFile.htmlf"
						+ " --p2-file part2File.htmlf" + " --toc-template-file tocTemplateFile.htmlf"
						+ " --p3-file part3file.htmlf" + " --input file.textile [--input file.textile]…"
						+ " --output file.html" + " [--property name=value]…");
		System.exit(1);
	}

	/**
	 * <p>
	 * Creates a {@link Reader} for the specified file. If that fails, the
	 * application is terminated with a specified error message.
	 * 
	 * @param filename
	 *            Name of the file to create a {@link Reader} for.
	 * @param msg
	 *            Error message to print if the file cannot be opened.
	 * @return see above
	 */
	private static Reader createFileReader(final String filename, final String msg) {
		Reader r = null;
		try {
			r = new FileReader(filename);
		} catch (FileNotFoundException e) {
			errorExit(msg + ": " + filename);
		}
		return r;
	}

}
