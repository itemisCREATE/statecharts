package de.itemis.gmf.runtime.commons.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * Direct editing parser that allows editing of an EAttribute.
 * 
 * @author andreas muelder
 * 
 */
public class AttributeParser implements IParser {

	private final EAttribute attribute;
	private final String pluginId;

	public AttributeParser(EAttribute attribute, String pluginId ) {
		this.attribute = attribute;
		this.pluginId = pluginId;
	}

	
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		if (element.eGet(attribute) != null) {
			return String.valueOf(element.eGet(attribute));
		} else {
			return "<"+attribute.getName()+">";
		}
	}

	
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return new ParserEditStatus(pluginId, IParserEditStatus.OK, "");
	}

	
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		if (newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, attribute, newString);
		return new SetValueCommand(request);
	}

	
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		return String.valueOf(element.eGet(attribute));
	}

	
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			return (((Notification) event).getFeature() == attribute);
		}
		return false;
	}

	
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

}
