package org.eclipselabs.mscript.codegen.c.ide.core.launch;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipselabs.mscript.codegen.c.ide.core.CodegenCIDECorePlugin;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.ide.core.launch.AbstractMscriptLaunchConfigurationDelegate;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.transform.ArrayOperationDecomposer;
import org.eclipselabs.mscript.language.il.transform.IArrayOperationDecomposer;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.typesystem.DataType;

public class CodegenLaunchConfigurationDelegate extends AbstractMscriptLaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.codegen.c.ide.core.codegen";
	
	public static final String ATTRIBUTE__TARGET_FUNCTION_NAME = "targetFunctionName";
	public static final String ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES = "inputParameterDataTypes";
	public static final String ATTRIBUTE__TARGET_FOLDER_PATH = "targetFolderPath";
	
	private String targetFunctionName;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.ide.core.launch.AbstractMscriptLaunchConfigurationDelegate#preLaunchCheck(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		targetFunctionName = configuration.getAttribute(ATTRIBUTE__TARGET_FUNCTION_NAME, "");
		if (StringUtils.isBlank(targetFunctionName)) {
			targetFunctionName = null;
		}
		return super.preLaunchCheck(configuration, mode, monitor);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.ide.core.launch.MscriptLaunchConfigurationDelegate#doLaunch(java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipselabs.mscript.language.il.ILFunctionDefinition, org.eclipselabs.mscript.computation.computationmodel.ComputationModel, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String targetFolderPathString = configuration.getAttribute(ATTRIBUTE__TARGET_FOLDER_PATH, "");
		if (targetFolderPathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		IArrayOperationDecomposer arrayOperationDecomposer = new ArrayOperationDecomposer();
		arrayOperationDecomposer.decompose(getILFunctionDefinition().getInitializationCompound());
		for (Compound compound : getILFunctionDefinition().getComputationCompounds()) {
			arrayOperationDecomposer.decompose(compound);
		}
		
		IFolder targetFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(targetFolderPathString));
		CodegenProcess process = new CodegenProcess(launch, "C Code Generator", targetFolder, getILFunctionDefinition(), getComputationModel());
		process.run();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.ide.core.launch.MscriptLaunchConfigurationDelegate#getInputParameterDataTypes(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	@Override
	protected List<DataType> computeInputParameterDataTypes(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		String inputParameterDataTypesString = configuration.getAttribute(ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES, "");
		
		List<DataType> inputParameterDataTypes = getDataTypes(new InterpreterContext(new ComputationContext()), inputParameterDataTypesString);
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid input parameter data type specifiers"));
		}

		if (inputParameterDataTypes.size() != getFunctionDefinition().getInputParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Number of input parameter data types does not correspond to the number of input parameter in function definition"));
		}
		
		return inputParameterDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.ide.core.launch.AbstractMscriptLaunchConfigurationDelegate#getTargetFunctionName()
	 */
	@Override
	protected String getTargetFunctionName() throws CoreException {
		return targetFunctionName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.LaunchConfigurationDelegate#buildForLaunch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return false;
	}

}
