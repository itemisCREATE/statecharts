package org.eclipselabs.mscript.codegen.c.ide.core.launch;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.mscript.codegen.c.ide.core.CodegenCIDECorePlugin;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.DataTypeSpecifierEvaluator;
import org.eclipselabs.mscript.language.interpreter.ExpressionValueEvaluator;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

public class CodegenLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.codegen.c.ide.core.codegen";
	
	public static final String ATTRIBUTE__FILE_PATH = "filePath";
	public static final String ATTRIBUTE__FUNCTION_NAME = "functionName";
	public static final String ATTRIBUTE__TARGET_FUNCTION_NAME = "targetFunctionName";
	public static final String ATTRIBUTE__TEMPLATE_ARGUMENTS = "templateArguments";
	public static final String ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES = "inputParameterDataTypes";
	public static final String ATTRIBUTE__TARGET_FOLDER_PATH = "targetFolderPath";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String filePathString = configuration.getAttribute(ATTRIBUTE__FILE_PATH, "");
		if (filePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No Mscript file specified"));
		}

		String functionName = configuration.getAttribute(ATTRIBUTE__FUNCTION_NAME, "");
		if (functionName.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No function specified"));
		}

		String targetFunctionName = configuration.getAttribute(ATTRIBUTE__TARGET_FUNCTION_NAME, "");
		if (StringUtils.isBlank(targetFunctionName)) {
			targetFunctionName = null;
		}

		String templateArgumentsString = configuration.getAttribute(ATTRIBUTE__TEMPLATE_ARGUMENTS, "");
		
		String inputParameterDataTypesString = configuration.getAttribute(ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES, "");

		String targetFolderPathString = configuration.getAttribute(ATTRIBUTE__TARGET_FOLDER_PATH, "");
		if (targetFolderPathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePathString));
		if (!file.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Mscript file '" + file.getName() + "' does not exist"));
		}
		
		IFolder targetFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(targetFolderPathString));

		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());
		
		FunctionDefinition functionDefinition = createFunctionDefinition(file, functionName);
		
		List<IValue> templateArguments = getTemplateArguments(interpreterContext, functionDefinition, templateArgumentsString);
		List<DataType> inputParameterDataTypes = getInputParameterDataTypes(interpreterContext, functionDefinition, inputParameterDataTypesString);
		
		ILFunctionDefinition ilFunctionDefinition = createILFunctionDefinition(functionDefinition, targetFunctionName, templateArguments, inputParameterDataTypes, monitor);
		
		CodegenProcess process = new CodegenProcess(launch, "C Code Generator", targetFolder, ilFunctionDefinition);
		process.run();
	}

	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
	private FunctionDefinition createFunctionDefinition(IFile file, String functionName) throws CoreException {
		IParseResult parseResult = CodegenCIDECorePlugin.getDefault().getMscriptParser().parse(new InputStreamReader(file.getContents()));
		if (!parseResult.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Parse errors"));
		}
			
		if (!(parseResult.getRootASTElement() instanceof Module)) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid parse result"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, functionName);
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Function '" + functionName + "' not found"));
		}
		return functionDefinition;
	}

	private ILFunctionDefinition createILFunctionDefinition(FunctionDefinition functionDefinition, String functionName, List<IValue> templateArguments, List<DataType> inputParameterDataTypes, IProgressMonitor monitor) throws CoreException {
		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor().construct(functionDefinition);
		if (!functionDescriptorConstructorResult.getStatus().isOK()) {
			throw new CoreException(functionDescriptorConstructorResult.getStatus());
		}
		
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer().transform(functionDescriptorConstructorResult.getFunctionDescriptor(), functionName, templateArguments, inputParameterDataTypes);
		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			throw new CoreException(functionDefinitionTransformerResult.getStatus());
		}

		return functionDefinitionTransformerResult.getILFunctionDefinition();
	}
	
	private List<IValue> getTemplateArguments(IInterpreterContext interpreterContext, FunctionDefinition functionDefinition, String templateArgumentsString) throws CoreException {
		List<IValue> templateArguments = getValues(interpreterContext, templateArgumentsString);
		if (templateArguments == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid template arguments specified"));
		}
		
		if (templateArguments.size() != functionDefinition.getTemplateParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Number of template parameter data types does not correspond to the number of template parameter in function definition"));
		}
		
		return templateArguments;
	}
	
	private List<DataType> getInputParameterDataTypes(IInterpreterContext interpreterContext, FunctionDefinition functionDefinition, String inputParameterDataTypesString) throws CoreException {
		List<DataType> inputParameterDataTypes = getDataTypes(interpreterContext, inputParameterDataTypesString);
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid input parameter data type specifiers"));
		}

		if (inputParameterDataTypes.size() != functionDefinition.getInputParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Number of input parameter data types does not correspond to the number of input parameter in function definition"));
		}
		return inputParameterDataTypes;
	}
	
	private List<DataType> getDataTypes(IInterpreterContext interpreterContext, String dataTypesString) throws CoreException {
		List<DataType> dataTypes = new ArrayList<DataType>();
		
		String[] dataTypeStrings = dataTypesString.split(",");
		if (dataTypeStrings[0].length() == 0) {
			dataTypeStrings = new String[0];
		}

		MscriptParser parser = CodegenCIDECorePlugin.getDefault().getMscriptParser();
		
		for (String dataTypeString : dataTypeStrings) {
			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getDataTypeSpecifierRule().getName(), new StringReader(dataTypeString));
			if (!parseResult.getParseErrors().isEmpty()) {
				return null;
			}
			DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier) parseResult.getRootASTElement();
			DataType dataType = new DataTypeSpecifierEvaluator(interpreterContext).doSwitch(dataTypeSpecifier);
			if (dataType instanceof InvalidDataType) {
				return null;
			}
			
			dataTypes.add(dataType);
		}
		
		return dataTypes;
	}
	
	private List<IValue> getValues(IInterpreterContext interpreterContext, String valuesString) {
		List<IValue> values = new ArrayList<IValue>();
		
		MscriptParser parser = CodegenCIDECorePlugin.getDefault().getMscriptParser();
		
		IParseResult parseResult = parser.parse(parser.getGrammarAccess().getExpressionListRule().getName(), new StringReader(valuesString));
		if (!parseResult.getParseErrors().isEmpty()) {
			return null;
		}
		ExpressionList expressionList = (ExpressionList) parseResult.getRootASTElement();
		
		ExpressionValueEvaluator expressionValueEvaluator = new ExpressionValueEvaluator(interpreterContext);
		
		for (Expression expression : expressionList.getExpressions()) {
			IValue value = expressionValueEvaluator.doSwitch(expression);
			if (value instanceof InvalidDataType) {
				return null;
			}
			values.add(value);
		}

		return values;
	}

}
