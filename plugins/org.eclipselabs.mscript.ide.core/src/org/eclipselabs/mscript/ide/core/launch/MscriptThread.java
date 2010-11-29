/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.ide.core.launch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipselabs.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.mscript.language.interpreter.IFunctor;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.Interpreter;
import org.eclipselabs.mscript.language.interpreter.value.INumericValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class MscriptThread extends Thread {

	private IInterpreterContext interpreterContext;
	private IFunctor functor;
	private IFile inputFile;
	private IFile outputFile;
	
	private List<IMscriptExecutionListener> listeners = new ArrayList<IMscriptExecutionListener>();

	/**
	 * 
	 */
	public MscriptThread(IInterpreterContext interpreterContext, IFunctor functor, IFile inputFile, IFile outputFile) {
		super("Mscript Application");
		this.interpreterContext = interpreterContext;
		this.functor = functor;
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	/**
	 * @return the interpreterContext
	 */
	public IInterpreterContext getInterpreterContext() {
		return interpreterContext;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			new Interpreter().initialize(interpreterContext, functor);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getContents()));
			while (!interpreterContext.isCanceled() && reader.ready()) {
				List<IValue> inputValues = new ArrayList<IValue>();
				String[] stringValues = reader.readLine().split(",", 0);
				if (stringValues[0].length() == 0) {
					stringValues = new String[0];
				}
				for (String stringValue : stringValues) {
					double value = Double.parseDouble(stringValue);
					RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
					realType.setUnit(TypeSystemUtil.createUnit());
					inputValues.add(interpreterContext.getValueFactory().createRealValue(realType, value));
				}
				StringBuilder sb = new StringBuilder();
				List<IValue> outputValues = new Interpreter().execute(interpreterContext, functor, inputValues);
				for (IValue outputValue : outputValues) {
					if (sb.length() > 0) {
						sb.append(",");
					}
					if (outputValue instanceof INumericValue) {
						INumericValue numericValue = (INumericValue) outputValue;
						sb.append(numericValue.doubleValue());
					} else {
						sb.append("NaN");
					}
				}
				sb.append("\n");
				outputFile.appendContents(new StringInputStream(sb.toString()), false, false, new NullProgressMonitor());
				functor.incrementStepIndex();
			}
		} catch (Exception e) {
			fireMscriptExecutionListener(new MscriptExecutionEvent(this, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, e.getMessage(), e)));
		}
		fireMscriptExecutionListener(new MscriptExecutionEvent(this, Status.OK_STATUS));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#addSimulationListener(org.eclipselabs.damos.simulation.ISimulationListener)
	 */
	public void addExecutionListener(IMscriptExecutionListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l)) {
				listeners.add(l);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#removeSimulationListener(org.eclipselabs.damos.simulation.ISimulationListener)
	 */
	public void removeExecutionListener(IMscriptExecutionListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#fireSimulationListener(org.eclipselabs.damos.simulation.SimulationEvent)
	 */
	public void fireMscriptExecutionListener(MscriptExecutionEvent event) {
		IMscriptExecutionListener[] ls;
		synchronized (listeners) {
			ls = listeners.toArray(new IMscriptExecutionListener[listeners.size()]);
		}
		for (IMscriptExecutionListener l : ls) {
			l.handleSimulationEvent(event);
		}
	}

}
