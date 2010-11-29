package org.eclipselabs.mscript.language.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionDefinition;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeFunctionTransformer;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

	@Check
	public void checkBeginExpressionMustBeInsideArraySubscript(BeginExpression beginExpression) {
		if (!isInsideArraySubscript(beginExpression)) {
			error("'begin' may only appear inside array subscripts", AstPackage.BEGIN_EXPRESSION);
		}
	}

	@Check
	public void checkEndExpressionMustBeInsideArraySubscript(EndExpression endExpression) {
		if (!isInsideArraySubscript(endExpression)) {
			error("'end' may only appear inside array subscripts", AstPackage.END_EXPRESSION);
		}
	}
	
	private boolean isInsideArraySubscript(EObject eObject) {
		EObject container = eObject.eContainer();
		
		while (container != null && !(container instanceof ArraySubscript)) {
			container = container.eContainer();
		}
		
		return container instanceof ArraySubscript && ((ArraySubscript) container).eContainer() instanceof ArrayElementAccess;
	}

	@Check
	public void checkUnitExpressionNumeratorMustConsistOfSymbolsOrOne(UnitExpressionNumerator numerator) {
		if (numerator.getFactors().isEmpty() && numerator.getOne() != 1) {
			error("Invalid unit numerator", AstPackage.UNIT_EXPRESSION_NUMERATOR__ONE);
		}
	}
	
	@Check
	public void checkFunctionDefinition(FunctionDefinition functionDefinition) {
		FunctionDescriptor functionDescriptor = new FunctionDescriptorConstructor().construct(functionDefinition, getChain());
		List<DataType> templateParameterDataTypes = new ArrayList<DataType>();
		List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
		
		if (functionDefinition.getName().equals("sum123")) {
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
				RealType elementType = TypeSystemFactory.eINSTANCE.createRealType();
				elementType.setUnit(TypeSystemUtil.createUnit());
				TensorType tensorType = TypeSystemFactory.eINSTANCE.createTensorType();
				tensorType.setElementType(elementType);
				ArrayDimension arrayDimension = TypeSystemFactory.eINSTANCE.createArrayDimension();
				arrayDimension.setSize(10);
				tensorType.getDimensions().add(arrayDimension);
				inputParameterDataTypes.add(tensorType);
				parameterDeclaration.getName();
			}
		} else {
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
				IntegerType type = TypeSystemFactory.eINSTANCE.createIntegerType();
				type.setUnit(TypeSystemUtil.createUnit());
				templateParameterDataTypes.add(type);
				parameterDeclaration.getName();
			}
			for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
				IntegerType type = TypeSystemFactory.eINSTANCE.createIntegerType();
				type.setUnit(TypeSystemUtil.createUnit());
				inputParameterDataTypes.add(type);
				parameterDeclaration.getName();
			}
		}

		ImperativeFunctionDefinition imperativeFunctionDefinition = new ImperativeFunctionTransformer().transform(functionDescriptor, templateParameterDataTypes, inputParameterDataTypes, getChain());

		System.out.print("### " + functionDefinition.getName() + " -> ");
		for (OutputVariableDeclaration outputVariableDeclaration : imperativeFunctionDefinition.getOutputVariableDeclarations()) {
			System.out.print(outputVariableDeclaration.getType().getClass().getSimpleName());
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("--- Initialize compound:");
		System.out.println(new CompoundCGenerator().doSwitch(imperativeFunctionDefinition.getInitializationCompound()));
		for (Compound compound : imperativeFunctionDefinition.getComputationCompounds()) {
			System.out.println("--- Computation compound:");
			System.out.println(new CompoundCGenerator().doSwitch(compound));
		}
		System.out.println();
	}
	
}
