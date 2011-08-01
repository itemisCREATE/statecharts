package org.eclipselabs.mscript.ide.core.launch;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.mscript.ide.core.internal.launch.util.ParseUtil;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.StaticEvaluationContext;
import org.eclipselabs.mscript.language.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

public abstract class AbstractMscriptLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.codegen.c.ide.core.codegen";
	
	public static final String ATTRIBUTE__FILE_PATH = "filePath";
	public static final String ATTRIBUTE__FUNCTION_NAME = "functionName";
	public static final String ATTRIBUTE__TEMPLATE_ARGUMENTS = "templateArguments";
	public static final String ATTRIBUTE__COMPUTATION_MODEL = "computationModel";
	
	private IStaticEvaluationContext staticEvaluationContext;

	private ComputationModel computationModel;
	
	private FunctionDefinition functionDefinition;
	
	private ILFunctionDefinition ilFunctionDefinition;
	
	private List<IValue> templateArguments;
	
	private List<DataType> inputParameterDataTypes;
	
	/**
	 * @return the staticEvaluationContext
	 */
	public IStaticEvaluationContext getStaticEvaluationContext() {
		return staticEvaluationContext;
	}
	
	/**
	 * @return the computationModel
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}
	
	/**
	 * @return the functionDefinition
	 */
	public FunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
	/**
	 * @return the ilFunctionDefinition
	 */
	public ILFunctionDefinition getILFunctionDefinition() {
		return ilFunctionDefinition;
	}
	
	/**
	 * @return the templateArguments
	 */
	public List<IValue> getTemplateArguments() {
		return templateArguments;
	}
	
	/**
	 * @return the inputParameterDataTypes
	 */
	public List<DataType> getInputParameterDataTypes() {
		return inputParameterDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.LaunchConfigurationDelegate#preLaunchCheck(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		
		String filePathString = configuration.getAttribute(ATTRIBUTE__FILE_PATH, "");
		if (filePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No Mscript file specified"));
		}

		String functionName = configuration.getAttribute(ATTRIBUTE__FUNCTION_NAME, "");
		if (functionName.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No function specified"));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePathString));
		if (!file.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Mscript file '" + file.getName() + "' does not exist"));
		}

		functionDefinition = createFunctionDefinition(file, functionName);
		
		String computationModelString = configuration.getAttribute(ATTRIBUTE__COMPUTATION_MODEL, "");
		if (computationModelString.length() == 0) {
			computationModel = ComputationModelUtil.constructDefaultComputationModel();
		} else {
			computationModel = createComputationModel(computationModelString);
		}
		
		String templateArgumentsString = configuration.getAttribute(ATTRIBUTE__TEMPLATE_ARGUMENTS, "");

		templateArguments = computeTemplateArguments(createTemplateArgumentsInterpreterContext(), functionDefinition, templateArgumentsString);

		inputParameterDataTypes = computeInputParameterDataTypes(configuration, mode, monitor);

		ilFunctionDefinition = createILFunctionDefinition(functionDefinition, getTargetFunctionName(), templateArguments, inputParameterDataTypes, monitor);

		return super.preLaunchCheck(configuration, mode, monitor);
	}
	
	protected abstract List<DataType> computeInputParameterDataTypes(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException;
	
	protected IInterpreterContext createTemplateArgumentsInterpreterContext() {
		return new InterpreterContext(new ComputationContext());
	}

	protected String getTargetFunctionName() throws CoreException {
		return null;
	}

	protected List<DataType> getDataTypes(IInterpreterContext interpreterContext, String dataTypesString) throws CoreException {
		List<DataType> dataTypes = new ArrayList<DataType>();
		
		String[] dataTypeStrings = dataTypesString.split(",");
		if (dataTypeStrings[0].length() == 0) {
			dataTypeStrings = new String[0];
		}
	
		MscriptParser parser = IDECorePlugin.getDefault().getMscriptParser();
		
		for (String dataTypeString : dataTypeStrings) {
			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getDataTypeSpecifierRule(), new StringReader(dataTypeString));
			if (parseResult.hasSyntaxErrors()) {
				return null;
			}
			DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier) parseResult.getRootASTElement();
			DataType dataType = EcoreUtil.copy(dataTypeSpecifier.getType());
			if (dataType instanceof InvalidDataType) {
				return null;
			}
			
			dataTypes.add(dataType);
		}
		
		return dataTypes;
	}

	private ComputationModel createComputationModel(String computationModelString) throws CoreException {
		try {
			URI uri = URI.createPlatformResourceURI(computationModelString, true);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			return (ComputationModel) resource.getContents().get(0);
		} catch (RuntimeException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Loading computation model failed", e));
		}
	}

	private FunctionDefinition createFunctionDefinition(IFile file, String functionName) throws CoreException {
		IParseResult parseResult = IDECorePlugin.getDefault().getMscriptParser().parse(new InputStreamReader(file.getContents()));
		if (parseResult.hasSyntaxErrors()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Parse errors"));
		}
			
		if (!(parseResult.getRootASTElement() instanceof Module)) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid parse result"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, functionName);
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Function '" + functionName + "' not found"));
		}
		return functionDefinition;
	}

	private ILFunctionDefinition createILFunctionDefinition(FunctionDefinition functionDefinition, String functionName, List<IValue> templateArguments, List<DataType> inputParameterDataTypes, IProgressMonitor monitor) throws CoreException {
		staticEvaluationContext = new StaticEvaluationContext();
		IStatus status = new StaticFunctionEvaluator().evaluate(staticEvaluationContext, functionDefinition);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer().transform(staticEvaluationContext, staticEvaluationContext.getFunctionDescriptor(functionDefinition), functionName, templateArguments, inputParameterDataTypes);
		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			throw new CoreException(functionDefinitionTransformerResult.getStatus());
		}

		return functionDefinitionTransformerResult.getILFunctionDefinition();
	}
	
	private List<IValue> computeTemplateArguments(IInterpreterContext interpreterContext, FunctionDefinition functionDefinition, String templateArgumentsString) throws CoreException {
		List<IValue> templateArguments = ParseUtil.parseValues(interpreterContext, templateArgumentsString);
		if (templateArguments == null) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid template arguments specified"));
		}
		
		if (templateArguments.size() != functionDefinition.getTemplateParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Number of template parameter data types does not correspond to the number of template parameter in function definition"));
		}
		
		return templateArguments;
	}

}
