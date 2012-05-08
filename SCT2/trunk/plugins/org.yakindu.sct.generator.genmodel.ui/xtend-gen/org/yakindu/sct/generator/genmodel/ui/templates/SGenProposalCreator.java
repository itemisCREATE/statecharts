package org.yakindu.sct.generator.genmodel.ui.templates;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.Literal;
import org.yakindu.sct.model.sgen.ParameterTypes;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class SGenProposalCreator {
  public String createProposal(final FeatureType featureType, final IDefaultFeatureValueProvider defaultProvider, final EObject context) {
    String _xblockexpression = null;
    {
      FeatureConfiguration defaultConfiguration = defaultProvider.createDefaultFeatureConfiguration(featureType, context);
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
      FeatureParameterValue defaultValue = value.getParameterValue(_name);
      boolean _notEquals = (!Objects.equal(defaultValue, null));
      if (_notEquals) {
        ParameterTypes _parameterType = param.getParameterType();
        boolean _equals = _parameterType.equals(ParameterTypes.STRING);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(" ");
          _builder.append("\"");
          Literal _expression = defaultValue.getExpression();
          _builder.append(_expression, " ");
          _builder.append("\" ");
          return _builder.toString();
        } else {
          return defaultValue.getExpression();
        }
      }
      ParameterTypes _parameterType_1 = param.getParameterType();
      final ParameterTypes _switchValue = _parameterType_1;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,ParameterTypes.STRING)) {
          _matched=true;
          return "\"\"";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ParameterTypes.BOOLEAN)) {
          _matched=true;
          return "false";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ParameterTypes.FLOAT)) {
          _matched=true;
          return "0.0";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ParameterTypes.INTEGER)) {
          _matched=true;
          return "0";
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
}
