/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.editor.figures.utils;

import java.util.Arrays;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;


public class ImageRenderer {

	
	public ImageData calculateVerticalAlphaGradient(Rectangle bounds, RGB color, int alphaMax) {
		
		// we build an indexed palette with one color
		RGB[] colors = new RGB[2];
		colors[0] = new RGB(0, 0, 0);
		colors[1] = (color != null) ? color : new RGB(255, 255, 255);
		PaletteData pd = new PaletteData(colors);
		
		// we use image with 1 bit color depth plus alpha
		int bytesPerRow = bounds.width / 8 + ((bounds.width % 8 != 0) ? 1 : 0); 
		byte[] data = new byte[bytesPerRow * bounds.height];
		
		// fill all pixel with the same color 
		Arrays.fill(data, (byte) 0xFF);

		// and create the image
		ImageData id = new ImageData(bounds.width, bounds.height, 1, pd, 1, data);
		
		// now calculate the gradient of alpha values ...
		byte[] alphaData = id.alphaData = new byte[bounds.width * bounds.height];
		double alphaFactor = alphaMax;
		double height = bounds.height;
		for(int i=0; i<bounds.height; i++){
			// double ratio = (i<=alphaMaxPos) ? (2.0*i/height) : (2.0* (height-i)/height);
			double ratio = 1.0 - Math.sin(i/height*Math.PI/2.0);
			byte alphaValue = (byte) (ratio * alphaFactor);
			Arrays.fill(alphaData, i*bounds.width, i*bounds.width + bounds.width, alphaValue);
		}

		return id;
	}

	
	/**
	 * Masks the corners of a rounded rectangle with a specified alpha value.
	 * 
	 * @param imageData
	 * @param bounds
	 * @param corner
	 * @param alphaValue
	 * @return The manipulated image data that is the same instance that is specified by the parameter {@link #imageData}. 
	 */
	public ImageData maskAlphaAsRoundedrectangle(ImageData imageData, Dimension corner, int alphaValue) {

		byte[] alphaData = imageData.alphaData;
		int width = imageData.width;
		int height = imageData.height;
		int r = corner.width / 2;
		double r_square = r*r;
		byte[] alphaPixel = new byte[r];
		Arrays.fill(alphaPixel, (byte)alphaValue);

		// make sure that the corner radius is smaller than the image dimensions and make it smaller if necessary
		r = Math.min(r, Math.min(imageData.height, imageData.width)/2);
		
		for (int i=0; i<r; i++) {
			// calculate pixel 
			int p = r- (int) Math.sqrt(r_square - (double)((i)*(i)));
			// mask corners ...
			if (p>0) {
				System.arraycopy(alphaPixel, 0, alphaData, 
						(r-(i+1))*width, p);
				System.arraycopy(alphaPixel, 0, alphaData, 
						(r-(i+1))*width  + (width-p), p);
				System.arraycopy(alphaPixel, 0, alphaData, 
						((height - (r-(i))))*width, p);
				System.arraycopy(alphaPixel, 0, alphaData, 
						((height - (r-(i))))*width + (width-p), p);
			}
		}	

		return imageData;
	}
	
	
	/**
	 * 
	 * @param graphics
	 * @return
	 */
	protected ImageData calculateVerticalRoundedRectangleLinearColorGradient(Rectangle bounds, Dimension corner, RGB c1, RGB c2) {
		

		PaletteData pd = new PaletteData(0xFF0000, 0xFF00, 0xFF);
		byte[] data = new byte[3*bounds.width * bounds.height];
		
		for(int i=0; i<bounds.width; i++){
			double ratio = (double)i / (double)bounds.width;
			int red = (int) (c1.red * (1 - ratio) + c2.red * ratio);
			int green = (int) (c1.green * (1 - ratio) + c2.green * ratio);
			int blue = (int) (c1.blue * (1 - ratio) + c2.blue * ratio);
			data[i*3+0] = (byte) red;
			data[i*3+1] = (byte) green;
			data[i*3+2] = (byte) blue;
		}
		
		for(int i=1; i<bounds.height; i++){
			System.arraycopy(data, 0, data, i*3*bounds.width, 3*bounds.width);
		}
		
		int r = corner.width / 2;
		double r_square = r*r;
		byte[] alphaPixel = new byte[r * 3];
		Arrays.fill(alphaPixel, (byte)0);
		
		for (int i=0; i<r; i++) {
			// calculate pixel 
			int p = r- (int) Math.sqrt(r_square - (double)((i)*(i)));
			// mask corners ...
			if (p>0) {
				System.arraycopy(alphaPixel, 0, data, 
						(r-(i+1))*3*bounds.width, p*3);
				System.arraycopy(alphaPixel, 0, data, 
						(r-(i+1))*3*bounds.width  + (bounds.width-p)*3, p*3);
				System.arraycopy(alphaPixel, 0, data, 
						((bounds.height - (r-(i))))*3*bounds.width, p*3);
				System.arraycopy(alphaPixel, 0, data, 
						((bounds.height - (r-(i))))*3*bounds.width + (bounds.width-p)*3, p*3);
			}
		}
		
		ImageData id = new ImageData(bounds.width, bounds.height, 24, pd, 3, data);
		id.transparentPixel = 0;

		return id;
	}


}
