package org.yakindu.base.xtext.utils.jface.viewers;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TextAttributeProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Modified copy of
 * org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingHelper
 */
class XtextStyledTextHighlightingHelper implements IPropertyChangeListener {

	@Inject
	private Provider<XtextStyledTextHighlightingReconciler> reconcilerProvider;

	@Inject
	private Provider<HighlightingPresenter> presenterProvider;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccessor;

	@Inject
	private TextAttributeProvider textAttributeProvider;

	/** Highlighting presenter */
	private HighlightingPresenter fPresenter;
	/** Highlighting reconciler */
	private XtextStyledTextHighlightingReconciler fReconciler;

	/** The editor */
	private StyledTextXtextAdapter styledTextXtextAdapter;
	/** The source viewer */
	private XtextSourceViewer fSourceViewer;
	/** The source viewer configuration */
	private XtextSourceViewerConfiguration fConfiguration;
	/** The presentation reconciler */
	private XtextPresentationReconciler fPresentationReconciler;

	private IPreferenceStore preferenceStore;

	public void install(StyledTextXtextAdapter styledTextXtextAdapter,
			XtextSourceViewer sourceViewer) {
		this.styledTextXtextAdapter = styledTextXtextAdapter;
		fSourceViewer = sourceViewer;
		if (styledTextXtextAdapter != null) {
			fConfiguration = styledTextXtextAdapter
					.getXtextSourceViewerConfiguration();
			fPresentationReconciler = (XtextPresentationReconciler) fConfiguration
					.getPresentationReconciler(sourceViewer);
		} else {
			fConfiguration = null;
			fPresentationReconciler = null;
		}
		preferenceStore = getPreferenceStoreAccessor().getPreferenceStore();
		preferenceStore.addPropertyChangeListener(this);
		enable();
	}

	/**
	 * Enable advanced highlighting.
	 */
	private void enable() {
		fPresenter = getPresenterProvider().get();
		fPresenter.install(fSourceViewer, fPresentationReconciler);

		if (styledTextXtextAdapter != null) {
			fReconciler = reconcilerProvider.get();
			fReconciler.install(styledTextXtextAdapter, fSourceViewer, fPresenter);
		}
	}

	public void uninstall() {
		disable();
		if (preferenceStore != null) {
			preferenceStore.removePropertyChangeListener(this);
		}
		styledTextXtextAdapter = null;
		fSourceViewer = null;
		fConfiguration = null;
		fPresentationReconciler = null;
	}

	/**
	 * Disable advanced highlighting.
	 */
	private void disable() {
		if (fReconciler != null) {
			fReconciler.uninstall();
			fReconciler = null;
		}

		if (fPresenter != null) {
			fPresenter.uninstall();
			fPresenter = null;
		}
	}

	/**
	 * Returns this hightlighter's reconciler.
	 * 
	 * @return the highlighter reconciler or <code>null</code> if none
	 */
	public XtextStyledTextHighlightingReconciler getReconciler() {
		return fReconciler;
	}

	public void setReconcilerProvider(
			Provider<XtextStyledTextHighlightingReconciler> reconcilerProvider) {
		this.reconcilerProvider = reconcilerProvider;
	}

	public Provider<XtextStyledTextHighlightingReconciler> getReconcilerProvider() {
		return reconcilerProvider;
	}

	public void setPresenterProvider(
			Provider<HighlightingPresenter> presenterProvider) {
		this.presenterProvider = presenterProvider;
	}

	public Provider<HighlightingPresenter> getPresenterProvider() {
		return presenterProvider;
	}

	public void setPreferenceStoreAccessor(
			IPreferenceStoreAccess preferenceStoreAccessor) {
		this.preferenceStoreAccessor = preferenceStoreAccessor;
	}

	public IPreferenceStoreAccess getPreferenceStoreAccessor() {
		return preferenceStoreAccessor;
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (fReconciler != null
				&& event.getProperty().contains(".syntaxColorer.tokenStyles")) {
			textAttributeProvider.propertyChange(event);
			fReconciler.refresh();
		}
	}
}
