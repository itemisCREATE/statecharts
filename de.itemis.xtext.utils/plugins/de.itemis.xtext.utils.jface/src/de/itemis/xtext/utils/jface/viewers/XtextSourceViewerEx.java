package de.itemis.xtext.utils.jface.viewers;

import java.lang.reflect.Field;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

/**
 * Source viewer replacement that implements a workaround for Eclipse bug
 * #352847 to enable that offsets are respected.
 * 
 * @author alexander nyssen (alexander.nyssen@itemis.de)
 * 
 */
public class XtextSourceViewerEx extends XtextSourceViewer {

	public XtextSourceViewerEx(Composite parent, IVerticalRuler ruler,
			IOverviewRuler overviewRuler, boolean showsAnnotationOverview,
			int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}

	public static class DefaultFactoryEx implements Factory {
		public XtextSourceViewer createSourceViewer(Composite parent,
				IVerticalRuler ruler, IOverviewRuler overviewRuler,
				boolean showsAnnotationOverview, int styles) {
			return new XtextSourceViewerEx(parent, ruler, overviewRuler,
					showsAnnotationOverview, styles);
		}
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
