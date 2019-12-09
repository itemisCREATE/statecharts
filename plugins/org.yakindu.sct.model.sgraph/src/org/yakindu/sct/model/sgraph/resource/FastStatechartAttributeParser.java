/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.yakindu.base.base.BasePackage;

/**
 * Efficient parser to determine a single attribute of a statechart without loading the whole resource
 *
 * @author Andreas Muelder - Initial contribution and API
 *
 */
public class FastStatechartAttributeParser {

	private static final String SGRAPH_STATECHART = "sgraph:Statechart";

	protected static class StopParsingException extends SAXException {

		private static final long serialVersionUID = 1L;

	}
	
	public static Optional<String> parse(URI uri, String attributeID) {
		try (InputStream is = URIConverter.INSTANCE.createInputStream(uri, null)) {
			return Optional.of(parse(is, attributeID));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	protected static String parse(InputStream is, String attributeID) {
		final StringBuilder result = new StringBuilder();
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser newSAXParser = f.newSAXParser();
			newSAXParser.parse(is, new DefaultHandler() {
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					if (SGRAPH_STATECHART.equals(qName)) {
						String attribute = attributes.getValue(attributeID);
						if (attribute != null) {
							result.append(attribute);
						}
						throw new StopParsingException();
					}
				}
			});
		} catch (StopParsingException e) {
			// Intentional to cancel parsing
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		if (result.length() == 0)
			result.append(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral());
		return result.toString();
	}
}
