package org.yakindu.sct.examples.java.trafficlight;

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

/**
 * This class cares about setting up the UI of the pesestrian crossing and
 * delegates the state machine handling to the concrete subcasses.
 * 
 * @author terfloth
 */
public abstract class CrossingDemoBase {

	protected Shell shell;
	protected Display display;
	protected CrossingFigure crossing;
	protected TrafficLightFigure trafficLightFigure;
	protected PedestrianLightFigure pedestrianLightFigure;

	public CrossingDemoBase() {
		super();
	}

	protected abstract void setUpAndRunStatemachine();

	protected abstract void tearDownStatemachine();

	protected abstract void readStatemachineOutput();

	protected abstract void pedestrianRequestButtonClicked();

	protected abstract void onOffButtonClicked();

	public void runTrafficLight() {

		setUpAndRunStatemachine();
		createUIContent();

		shell.open();
		while (!shell.isDisposed()) {
			// update traffic lights
			readStatemachineOutput();

			crossing.repaint();

			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		tearDownStatemachine();
	}

	protected void createUIContent() {
		display = Display.getDefault();
		shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setText("Traffic Light Demo");
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shell.setLayout(shellLayout);

		LightweightSystem lws = createLightweightsystem(shell);
		createButtonComposite(shell);

		crossing = new CrossingFigure();
		lws.setContents(crossing);
		trafficLightFigure = new TrafficLightFigure();
		crossing.add(trafficLightFigure);
		crossing.getLayoutManager().setConstraint(trafficLightFigure,
				new Rectangle(275, 75, 35, 90));

		pedestrianLightFigure = new PedestrianLightFigure();
		crossing.add(pedestrianLightFigure);
		crossing.getLayoutManager().setConstraint(pedestrianLightFigure,
				new Rectangle(50, 10, 70, 20));
	}

	protected LightweightSystem createLightweightsystem(Shell shell) {

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

	protected void createButtonComposite(Shell shell) {
		// create a composite to hold the buttons
		Composite buttonComposite = new Composite(shell, SWT.NO_SCROLL);
		GridData buttonCompositeGridData = new GridData();
		buttonCompositeGridData.horizontalAlignment = GridData.FILL;
		buttonCompositeGridData.grabExcessHorizontalSpace = true;
		buttonComposite.setLayoutData(buttonCompositeGridData);
		FillLayout buttonCompositeLayout = new FillLayout();
		buttonCompositeLayout.type = SWT.HORIZONTAL;
		buttonComposite.setLayout(new FillLayout());

		// create a button and event handlers

		Button pedestrianRequest = new Button(buttonComposite, SWT.PUSH);
		pedestrianRequest.setText("pedestrian request");
		pedestrianRequest.addListener(SWT.Selection, new Listener() {
			public void handleEvent(final org.eclipse.swt.widgets.Event event) {
				pedestrianRequestButtonClicked();
			}

		});

		Button onOff = new Button(buttonComposite, SWT.PUSH);
		onOff.setText("on / off");
		onOff.addListener(SWT.Selection, new Listener() {
			public void handleEvent(final org.eclipse.swt.widgets.Event event) {
				onOffButtonClicked();
			}

		});
	}

}