package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

/* Room for experiments with the Eclise help system. */
public class TextPropertyDescriptorWithHelp extends AbstractPropertyDescriptor {
	
	public TextPropertyDescriptorWithHelp(EAttribute feature, String labelName) {
		super(feature, labelName);
	}

	private Text text;
	
	public Object getControlValue() {
		Text text = getText();
		
		if (text == null) {
			return null;
		}
		
		return (text.getText() != null && text.getText().trim().length() != 0) ? text
				.getText().trim() : null;
	}

	private Text getText() {
		return text;
	}

	public void setControlValue(Object value) {
		if (value != null) {
			Assert.isTrue(value instanceof String, "Illegal value " + value);
			Text text = getText();
			text.setText((String) value);
		}
		
	}

	@Override
	// Parent layout? (number of grid columns, etc.)
	protected Control createControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		
		Text text = toolkit.createText(parent, "");
		PlatformUI.getWorkbench().getHelpSystem().setHelp(text, "org.yakindu.sct.ui.editor.YAKINDU_SCT_EDITOR");
		text.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				// Not called
			}

			// Will only bring be called when hitting Enter
			public void widgetDefaultSelected(SelectionEvent e) {
				// Displays a pop-up-message, unless set to open in Dynamic Help View via preference page
				PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.yakindu.sct.ui.editor.YAKINDU_SCT_EDITOR");
				// Opens the Dynamic Help View
//				PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
			}
		});
//		control.addMouseTrackListener(new MouseTrackAdapter() {
//
//			public void mouseHover(MouseEvent e) {
				// May force open Dynamic Help View on hover events!
//				PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.yakindu.sct.ui.editor.YAKINDU_SCT_EDITOR");
//			}
//			
//		});
		this.text = text;
		GridDataFactory.fillDefaults().grab(true,false).applyTo(text);
		Button helpButton = toolkit.createButton(parent,"", SWT.PUSH) ;
		helpButton.setToolTipText(JFaceResources.getString(IDialogLabelKeys.HELP_LABEL_KEY));
		helpButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_LCL_LINKTO_HELP));
		applyLayout(helpButton);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(helpButton, "org.yakindu.sct.ui.editor.YAKINDU_SCT_EDITOR");
		helpButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
			}
			
		});
		return parent;
	}

//	@Override
//	protected void applyLayout(Control control) {
//		GridDataFactory.fillDefaults().grab(false,false).applyTo(control);
//	}
	
}
