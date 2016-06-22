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
package org.yakindu.sct.examples.ui.wizards.pages;

import org.eclipse.gef.internal.InternalImages;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ImageViewer extends Composite {

	private SWTImageCanvas canvas;

	private Composite controls;

	private String[] images;
	private int index = 0;

	private Button previous;

	private Button next;

	public ImageViewer(Composite parent) {
		super(parent, SWT.BORDER);
		createContents();
		addResizeListener();
	}

	private void addResizeListener() {
		this.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				canvas.fitCanvas();
			}
		});
	}

	public void setViewerInput(String[] images) {
		this.images = images;
		showCurrentImage();
		updateButtonState();
	}

	protected void showCurrentImage() {
		ImageData imageData = new ImageData(images[index]);
		canvas.setImageData(imageData);
		canvas.fitCanvas();
	}

	public void createContents() {
		this.setLayout(new GridLayout(1, true));
		canvas = new SWTImageCanvas(this);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(canvas);
		canvas.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		controls = new Composite(this, SWT.NULL);
		controls.setLayout(new GridLayout(5, true));
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).applyTo(controls);
		createButtonPrevious();
		createZoomIn();
		createZoomOriginal();
		createZoomOut();
		createButtonNext();
	}

	protected void updateButtonState() {
		previous.setEnabled(true);
		next.setEnabled(true);
		if (index == 0)
			previous.setEnabled(false);
		if (images.length == index + 1) {
			next.setEnabled(false);
		}
	}

	protected void createZoomOriginal() {
		Button original = new Button(controls, SWT.FLAT);
		GridDataFactory.fillDefaults().applyTo(previous);
		original.setText("100 %");
		original.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas.showOriginal();
			}
		});
		original.setToolTipText("original size");
	}

	protected void createButtonPrevious() {
		previous = new Button(controls, SWT.FLAT);
		GridDataFactory.fillDefaults().applyTo(previous);
		previous.setText("<<");
		previous.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index--;
				showCurrentImage();
				updateButtonState();
			}
		});
		previous.setToolTipText("previous image");
	}

	protected void createButtonNext() {
		next = new Button(controls, SWT.FLAT);
		GridDataFactory.fillDefaults().applyTo(next);
		next.setText(">>");
		next.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index++;
				showCurrentImage();
				updateButtonState();
			}
		});
		next.setToolTipText("Next Image");
	}

	private void createZoomIn() {
		Button zoomIn = new Button(controls, SWT.FLAT);
		GridDataFactory.fillDefaults().applyTo(zoomIn);
		zoomIn.setImage(InternalImages.DESC_ZOOM_IN.createImage());
		zoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas.zoomIn();
			}
		});
		zoomIn.setToolTipText("Zoom in");
	}

	private void createZoomOut() {
		Button zoomOut = new Button(controls, SWT.FLAT);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).applyTo(zoomOut);
		zoomOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas.zoomOut();
			}
		});
		zoomOut.setImage(InternalImages.DESC_ZOOM_OUT.createImage());
		zoomOut.setToolTipText("Zoom out");
	}

}
