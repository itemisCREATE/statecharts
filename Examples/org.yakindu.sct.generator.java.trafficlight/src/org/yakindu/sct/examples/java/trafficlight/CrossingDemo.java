/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.java.trafficlight;

/**
 * Example to show how to integrate the generated statemachine code into existing projects.
 * 
 * @author a.nyssen - initial API and implementation
 * @author m.muehlbrandt - adaptions to new statemachine code.
 */
import java.lang.reflect.InvocationTargetException;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.yakindu.sct.runtime.java.TimerHandler;
import org.yakindu.sct.runtime.java.trafficlightwaitingsimple.TrafficLightWaitingSimpleCyleBasedStatemachine;

public class CrossingDemo {

	public static void main(String[] args) {

		final TrafficLightWaitingSimpleCyleBasedStatemachine statemachine = new TrafficLightWaitingSimpleCyleBasedStatemachine();

		// create display and shell
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setText("Traffic Light Demo");
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shell.setLayout(shellLayout);

		LightweightSystem lws = createLightweightsystem(shell);
		createButtonComposite(statemachine, shell);

		CrossingFigure crossing = new CrossingFigure();
		lws.setContents(crossing);
		final TrafficLightFigure tl = new TrafficLightFigure();
		crossing.add(tl);
		crossing.getLayoutManager().setConstraint(tl,
				new Rectangle(275, 75, 35, 90));

		final PedestrianLightFigure pl = new PedestrianLightFigure();
		crossing.add(pl);
		crossing.getLayoutManager().setConstraint(pl,
				new Rectangle(50, 10, 70, 20));

		Thread thread = new Thread() {
			@Override
			public void run() {
				statemachine.setTimerHandler(new TimerHandler(statemachine));
				statemachine.entry();
				while (!isInterrupted()) {
					statemachine.runCycle();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// if Thread is interrupted from outside while sleeping
						// the interrupt flag resets. Thread.sleep() reacts on
						// interrupt() calls too. Therefore interrupt has to be
						// called again to set the flag again and end the top
						// while loop.
						interrupt();
					}
				}
				statemachine.getTimerHandler().cancel();
			}
		};
		thread.start();
		shell.open();
		while (!shell.isDisposed()) {
			// update traffic lights
			tl.setRed(statemachine.getInterfaceTrafficLight().getVarRed());
			tl.setYellow(statemachine.getInterfaceTrafficLight().getVarYellow());
			tl.setGreen(statemachine.getInterfaceTrafficLight().getVarGreen());

			pl.setWhite(statemachine.getInterfacePedestrian().getVarRequest());
			pl.setRed(statemachine.getInterfacePedestrian().getVarRed());
			pl.setGreen(statemachine.getInterfacePedestrian().getVarGreen());

			crossing.repaint();

			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		System.out.println("Shell disposed...");
		thread.interrupt();
	}

	private static LightweightSystem createLightweightsystem(Shell shell) {

		FigureCanvas canvas = new FigureCanvas(shell);
		GridData canvasGridData = new GridData();
		canvasGridData.horizontalAlignment = GridData.FILL;
		canvasGridData.verticalAlignment = GridData.FILL;
		canvasGridData.grabExcessVerticalSpace = true;
		canvasGridData.grabExcessHorizontalSpace = true;
		canvas.setLayoutData(canvasGridData);
		LightweightSystem lws = new LightweightSystem(canvas);
		return lws;
	}

	private static void createButtonComposite(
			final TrafficLightWaitingSimpleCyleBasedStatemachine statemachine,
			Shell shell) {
		// create a composite to hold the buttons
		Composite buttonComposite = new Composite(shell, SWT.NO_SCROLL);
		GridData buttonCompositeGridData = new GridData();
		buttonCompositeGridData.horizontalAlignment = GridData.FILL;
		buttonCompositeGridData.grabExcessHorizontalSpace = true;
		buttonComposite.setLayoutData(buttonCompositeGridData);
		FillLayout buttonCompositeLayout = new FillLayout();
		buttonCompositeLayout.type = SWT.HORIZONTAL;
		buttonComposite.setLayout(new FillLayout());

		// create a button for each KEYPRESS event
		Button[] button = new Button[3];
		for (int i = 0; i < 3; i++) {
			button[i] = new Button(buttonComposite, SWT.PUSH);
			button[i].setText("key" + (i + 1));
			final int j = i;
			button[i].addListener(SWT.Selection, new Listener() {
				public void handleEvent(
						final org.eclipse.swt.widgets.Event event) {

					// Shorter call for code commentet out below
					try {
						Class<?> interfaceClass = statemachine
								.getInterfaceDefault().getClass();
						interfaceClass.getDeclaredMethod(
								"raiseKeypress" + (j + 1), new Class[0])
								.invoke(statemachine.getInterfaceDefault(),
										new Object[0]);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
				}
			});
		}
		// button[1].addListener(SWT.Selection, new Listener() {
		// public void handleEvent(final org.eclipse.swt.widgets.Event event) {
		// statechart.getInterfaceDefault().raiseKeypress1();
		// }
		// });
		//
		// button[2].addListener(SWT.Selection, new Listener() {
		// public void handleEvent(final org.eclipse.swt.widgets.Event event) {
		// statechart.getInterfaceDefault().raiseKeypress2();
		// }
		// });
		//
		// button[3].addListener(SWT.Selection, new Listener() {
		// public void handleEvent(final org.eclipse.swt.widgets.Event event) {
		// statechart.getInterfaceDefault().raiseKeypress3();
		// }
		// });
	}
}
