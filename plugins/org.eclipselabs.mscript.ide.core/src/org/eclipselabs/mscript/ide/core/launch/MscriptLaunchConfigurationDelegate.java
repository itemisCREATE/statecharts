package org.eclipselabs.mscript.ide.core.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.mscript.ide.core.internal.launch.util.ParseUtil;
import org.eclipselabs.mscript.language.interpreter.Functor;
import org.eclipselabs.mscript.language.interpreter.IFunctor;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IVariable;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class MscriptLaunchConfigurationDelegate extends AbstractMscriptLaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.ide.core.mscriptApplication";

	public static final String ATTRIBUTE__INPUT_FILE_PATH = "inputFilePath";
	public static final String ATTRIBUTE__OUTPUT_FILE_PATH = "outputFilePath";

	private IFile inputFile;
	private IFile outputFile;

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.ide.core.launch.AbstractMscriptLaunchConfigurationDelegate#preLaunchCheck(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		
		String inputFilePathString = configuration.getAttribute(ATTRIBUTE__INPUT_FILE_PATH, "");
		if (inputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No input file specified"));
		}

		String outputFilePathString = configuration.getAttribute(ATTRIBUTE__OUTPUT_FILE_PATH, "");
		if (outputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(inputFilePathString));
		if (!inputFile.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Input file '"
					+ inputFile.getName() + "' does not exist"));
		}

		outputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(outputFilePathString));

		prepareOutputFile(outputFile, monitor);

		return super.preLaunchCheck(configuration, mode, monitor);
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		IInterpreterContext context = new InterpreterContext(new ComputationContext(getComputationModel()));

		IFunctor functor = Functor.create(context, getILFunctionDefinition());

		for (IVariable variable : functor.getVariables()) {
			context.addVariable(variable);
		}

		new MscriptProcess(launch, "Mscript Application").run(context, functor, inputFile, outputFile);
	}

	@Override
	protected List<DataType> computeInputParameterDataTypes(ILaunchConfiguration configuration, String mode,
			IProgressMonitor monitor) throws CoreException {
		int n = getFunctionDefinition().getInputParameterDeclarations().size();
		DataType[] dataTypes = new DataType[n];
		
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext(getComputationModel()));
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getContents()));
			while (!monitor.isCanceled() && reader.ready()) {
				List<IValue> values = ParseUtil.parseValues(interpreterContext, reader.readLine());
				if (values == null) {
					throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid values in '"
							+ inputFile.getName() + "'"));
				}
				if (values.size() != n) {
					throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID,
							"Number of columns in input file '" + inputFile.getName()
									+ "' does not correspond to number of input parameters"));
				}
				
				int i = 0;
				for (IValue value : values) {
					if (dataTypes[i] == null) {
						dataTypes[i] = value.getDataType();
					} else {
						dataTypes[i] = TypeSystemUtil.getLeftHandDataType(dataTypes[i], value.getDataType());
						if (dataTypes[i] == null) {
							throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Incompatible values in '"
									+ inputFile.getName() + "'"));
						}
					}
				}
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Reading input file '"
					+ inputFile.getName() + "' failed", e));
		}
		
		return Arrays.asList(dataTypes);
	}

	protected void prepareOutputFile(IFile outputFile, IProgressMonitor monitor) throws CoreException {
		if (outputFile.exists() && outputFile.isReadOnly()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Output file is read-only"));
		}
		if (outputFile.exists()) {
			outputFile.setContents(new StringInputStream(""), false, false, new NullProgressMonitor());
		} else {
			outputFile.create(new StringInputStream(""), false, new NullProgressMonitor());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.model.LaunchConfigurationDelegate#buildForLaunch
	 * (org.eclipse.debug.core.ILaunchConfiguration, java.lang.String,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return false;
	}

}
