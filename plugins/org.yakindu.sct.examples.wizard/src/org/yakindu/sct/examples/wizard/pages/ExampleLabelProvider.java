/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.pages;

import java.util.Arrays;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.examples.wizard.pages.ExampleContentProvider.Category;
import org.yakindu.sct.examples.wizard.service.ExampleData;
import org.yakindu.sct.ui.editor.StatechartImages;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class ExampleLabelProvider extends LabelProvider implements IStyledLabelProvider {

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof ExampleData) {
			return new StyledString(((ExampleData) element).getTitle());
		} else if (element instanceof Category) {
			return new StyledString(((Category) element).getName());
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ExampleData) {
			if (Arrays.asList(((ExampleData) element).getCategory()).contains("professional")) {
				return StatechartImages.PRO_EDITION.image();
			} else {
				return StatechartImages.LOGO.image();
			}
		}
		return StatechartImages.MENU.image();
	}

	@Override
	public void dispose() {
	}

}
