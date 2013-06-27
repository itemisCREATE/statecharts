package de.itemis.gmf.runtime.commons.parsers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
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

import de.itemis.xtext.utils.gmf.directedit.IEAttributeProvider;

/**
 * Direct editing parser that allows editing of an EAttribute of type String.
 * 
 * @author andreas muelder
 * 
 */
public class StringAttributeParser implements IParser {

	private final String pluginId;
	private IEAttributeProvider provider;

	public StringAttributeParser(IEAttributeProvider provider, String pluginId) {
		this.provider = provider;
		this.pluginId = pluginId;
	}

	public StringAttributeParser(final EAttribute attribute, String pluginId) {
		this.provider = new IEAttributeProvider() {
			public EAttribute getAttribute() {
				return attribute;
			}
		};
		this.pluginId = pluginId;
	}

	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		EAttribute attribute = provider.getAttribute();
		Assert.isTrue(attribute.getEAttributeType() == EcorePackage.Literals.ESTRING);
		String string = (String) element.eGet(attribute);
		if (string != null && !string.trim().isEmpty()) {
			return String.valueOf(string);
		} else {
			return "<" + attribute.getName() + ">";
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
		SetRequest request = new SetRequest(element, provider.getAttribute(), newString);
		return new SetValueCommand(request);
	}

	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		return String.valueOf(element.eGet(provider.getAttribute()));
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			return (((Notification) event).getFeature() == provider.getAttribute());
		}
		return false;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}
}
