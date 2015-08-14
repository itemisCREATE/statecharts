package de.itemis.xtext.utils.jface.viewers;

import java.lang.reflect.Field;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

/**
 * Source viewer replacement that implements a workaround for Eclipse bug
 * #352847 to enable that offsets are respected.
 * 
 * @author alexander.nyssen@itemis.de
 * 
 */
class XtextSourceViewerEx extends XtextSourceViewer {

	private final StyledText styledText;
	private final IPreferenceStore preferenceStore;

	public XtextSourceViewerEx(StyledText styledText,
			IPreferenceStore preferenceStore) {
		// super constructor will create a new text widget by calling
		// createControl(). As we want to use the passed in styled text, we have
		// to disable this mechanism.
		super(null, null, null, false, styledText.getStyle());
		this.styledText = styledText;
		this.preferenceStore = preferenceStore;
		super.createControl(styledText.getParent(), styledText.getStyle());
	}

	@Override
	protected void createControl(Composite parent, int styles) {
		// do nothing here (will be called by super constructor)
	}

	@Override
	protected StyledText createTextWidget(Composite parent, int styles) {
		return styledText;
	}

	/**
	 * Overwritten to handle offset properly.
	 */
	@Override
	protected boolean updateSlaveDocument(IDocument slaveDocument,
			int modelRangeOffset, int modelRangeLength)
			throws BadLocationException {
		if (slaveDocument instanceof ProjectionDocument) {
			ProjectionDocument projection = (ProjectionDocument) slaveDocument;

			int offset = modelRangeOffset;
			int length = modelRangeLength;

			if (!isProjectionMode()) {
				// mimic original TextViewer behavior
				IDocument master = projection.getMasterDocument();
				int line = master.getLineOfOffset(modelRangeOffset);
				offset += master.getLineOffset(line);
				length = (modelRangeOffset - offset) + modelRangeLength;
			}

			try {
				// fHandleProjectionChanges= false;
				setPrivateHandleProjectionChangesField(false);
				projection.replaceMasterDocumentRanges(offset, length);
			} finally {
				// fHandleProjectionChanges= true;
				setPrivateHandleProjectionChangesField(true);
			}
			return true;
		}
		return false;
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		// We have to set the preference store via reflection here because Xtext
		// uses package visibility for the setter
		Field declaredField;
		try {
			declaredField = TextSourceViewerConfiguration.class
					.getDeclaredField("fPreferenceStore");
			declaredField.setAccessible(true);
			declaredField.set(configuration, preferenceStore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.configure(configuration);
	}

	/**
	 * Set the private fHandleProjectionChanges field value.
	 * 
	 * @param value
	 *            the new value.
	 */
	private void setPrivateHandleProjectionChangesField(boolean value) {
		try {
			Field declaredField = ProjectionViewer.class
					.getDeclaredField("fHandleProjectionChanges");
			declaredField.setAccessible(true);
			declaredField.set(this, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
