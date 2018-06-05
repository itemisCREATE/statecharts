/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;

/**
 * 
 * @author robert rudi - Initial contribution and API
 * 
 */
public class DiagramStatusLabel extends Composite {

	
	private static final Font DIAGRAM_STATUS_FONT = new Font(null, new FontData("Verdana", 10, SWT.BOLD));

	private CLabel label;
	
	public DiagramStatusLabel(DiagramStatus status, Composite parent) {
		super(parent, SWT.BORDER);
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		setLayout(layout);
		setBackground(ColorConstants.white);
		createLabel(status);	
	}

	protected void createLabel(DiagramStatus status) {
		label = new CLabel(this, SWT.NONE);
		label.setFont(DIAGRAM_STATUS_FONT);
		label.setBackground(ColorConstants.white);
		label.setForeground(getSeverityColor(status.getSeverity()));
		label.setImage(getSeverityImage(status.getSeverity()));
		label.setText(getMessage(status));
	}
	
	protected String getMessage(DiagramStatus diagramStatus) {
		if (diagramStatus.getSeverity() == Severity.ERROR)
			return diagramStatus.getMessage();
		return diagramStatus.getMessage();

	}

	protected Color getSeverityColor(Severity severity) {
		if (severity == Severity.ERROR)
			return ColorConstants.red;
		else if (severity == Severity.WARNING)
			return ColorConstants.darkBlue;
		return ColorConstants.darkBlue;
	}

	protected Image getSeverityImage(Severity severity) {
		if (severity == Severity.ERROR) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		} else if (severity == Severity.WARNING) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}

}
