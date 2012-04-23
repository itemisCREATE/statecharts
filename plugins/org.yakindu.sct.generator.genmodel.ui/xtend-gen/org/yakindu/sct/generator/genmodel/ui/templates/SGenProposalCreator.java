package org.yakindu.sct.generator.genmodel.ui.templates;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.Literal;
import org.yakindu.sct.model.sgen.ParameterTypes;

@SuppressWarnings("all")
public class SGenProposalCreator {
  
  public String createProposal(final FeatureType featureType, final IDefaultFeatureValueProvider defaultProvider, final EObject context) {
    String _xblockexpression = null;
    {
      FeatureConfiguration _createDefaultFeatureConfiguration = defaultProvider.createDefaultFeatureConfiguration(featureType, context);
      FeatureConfiguration defaultConfiguration = _createDefaultFeatureConfiguration;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("feature ");
      String _name = featureType.getName();
      _builder.append(_name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        EList<FeatureParameter> _parameters = featureType.getParameters();
        for(final FeatureParameter param : _parameters) {
          _builder.append("\t");
          String _name_1 = param.getName();
          _builder.append(_name_1, "	");
          _builder.append(" = ");
          Object _value = this.value(defaultConfiguration, param);
          _builder.append(_value, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public Object value(final FeatureConfiguration value, final FeatureParameter param) {
    Object _xblockexpression = null;
    {
      String _name = param.getName();
      FeatureParameterValue _parameterValue = value.getParameterValue(_name);
      FeatureParameterValue defaultValue = _parameterValue;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(defaultValue, null);
      if (_operator_notEquals) {
        ParameterTypes _parameterType = param.getParameterType();
        boolean _equals = _parameterType.equals(ParameterTypes.STRING);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(" ");
          _builder.append("\"");
          Literal _expression = defaultValue.getExpression();
          _builder.append(_expression, " ");
          _builder.append("\" ");
          String _string = _builder.toString();
          return _string;
        } else {
          Literal _expression_1 = defaultValue.getExpression();
          return _expression_1;
        }
      }
      ParameterTypes _parameterType_1 = param.getParameterType();
      final ParameterTypes __valOfSwitchOver = _parameterType_1;
      boolean matched = false;
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,ParameterTypes.STRING)) {
          matched=true;
          return "\"\"";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,ParameterTypes.BOOLEAN)) {
          matched=true;
          return "false";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,ParameterTypes.FLOAT)) {
          matched=true;
          return "0.0";
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,ParameterTypes.INTEGER)) {
          matched=true;
          return "0";
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
}