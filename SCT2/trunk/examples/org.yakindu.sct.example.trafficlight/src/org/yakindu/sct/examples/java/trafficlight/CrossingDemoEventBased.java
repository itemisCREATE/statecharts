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
 * It uses the event based statemachine approach and the generated RuntimeService to execute it.
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
import org.yakindu.sct.runtime.java.TimerService;
import org.yakindu.sct.runtime.java.trafficlightwaiting.TrafficLightWaitingCycleBasedStatemachine;
import org.yakindu.sct.runtime.java.trafficlightwaiting.TrafficLightWaitingEventBasedStatemachine;

public class CrossingDemoEventBased {

	public static void main(String[] args) {

		final TrafficLightWaitingEventBasedStatemachine statemachine = new TrafficLightWaitingEventBasedStatemachine();

		// create display and shell
		Display display = Display.getDefault();
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

		statemachine.setTimerService(new TimerService());
		statemachine.enter();

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
		statemachine.getTimerService().cancel();
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
			final TrafficLightWaitingCycleBasedStatemachine statemachine,
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
		Button[] button = new Button[2];
		for (int i = 0; i < 2; i++) {
			button[i] = new Button(buttonComposite, SWT.PUSH);
			button[i].setText("key" + (i + 1));
			final int j = i;
			button[i].addListener(SWT.Selection, new Listener() {
				public void handleEvent(
						final org.eclipse.swt.widgets.Event event) {

					try {
						Class<?> interfaceClass = statemachine
								.getDefaultInterface().getClass();
						interfaceClass.getDeclaredMethod(
								"raiseKeypress" + (j + 1), new Class[0])
								.invoke(statemachine.getDefaultInterface(),
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
	}
}
