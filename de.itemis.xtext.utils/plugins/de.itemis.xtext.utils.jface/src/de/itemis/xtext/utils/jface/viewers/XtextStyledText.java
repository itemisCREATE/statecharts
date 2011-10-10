package de.itemis.xtext.utils.jface.viewers;

import java.util.List;

import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.context.IXtextContextFakeResourcesProvider;

/**
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 * 
 */
public class XtextStyledText extends StyledText {

	private StyledTextXtextAdapter xtextAdapter;

	public XtextStyledText(Composite parent, int style, Injector injector,
			IXtextContextFakeResourcesProvider contextFakeResourceProvider) {
		super(parent, style);
		xtextAdapter = new StyledTextXtextAdapter(injector,
				contextFakeResourceProvider);
		xtextAdapter.adapt(this);
	}

	public void setVisibleRegion(int start, int length) {
		xtextAdapter.setVisibleRegion(start, length);
	}

	public void resetVisibleRegion() {
		xtextAdapter.resetVisibleRegion();
	}

	public IParseResult getXtextParseResult() {
		return xtextAdapter.getXtextParseResult();
	}

	public List<Issue> getXtextValidationIssues() {
		return xtextAdapter.getXtextValidationIssues();
	}

	public void updateFakeResourceContext() {
		xtextAdapter.updateFakeResourceContext();
	}
	
	public IContentAssistant getContentAssistant() {
		return xtextAdapter.getContentAssistant();
	}

	@Override
	public void dispose() {
		xtextAdapter.dispose();
		super.dispose();
	}
}
