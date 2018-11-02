/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainStatusLabel extends Composite {

	private static final Font DOMAIN_STATUS_FONT = new Font(null, new FontData("Verdana", 10, SWT.BOLD));

	private CLabel label;
	private Link link;

	public DomainStatusLabel(DomainStatus status, Composite parent) {
		super(parent, SWT.BORDER);
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		setLayout(layout);
		setBackground(ColorConstants.white);
		createLabel(status);
		createLink(status);
	}

	protected void createLink(DomainStatus status) {
		link = new Link(this, SWT.NONE);
		link.setFont(DOMAIN_STATUS_FONT);
		link.setBackground(ColorConstants.white);
		link.setText(getMessage(status));
		link.setForeground(getSeverityColor(status.getSeverity()));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				status.handleLink();
			}
		});
	}

	protected void createLabel(DomainStatus status) {
		label = new CLabel(this, SWT.NONE);
		label.setFont(DOMAIN_STATUS_FONT);
		label.setBackground(ColorConstants.white);
		label.setForeground(getSeverityColor(status.getSeverity()));
		label.setImage(getSeverityImage(status.getSeverity()));
	}

	protected String getMessage(DomainStatus domainStatus) {
		if (domainStatus.getSeverity() == Severity.ERROR)
			return domainStatus.getMessage() + " - editor is in readonly mode.";
		return domainStatus.getMessage();

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
