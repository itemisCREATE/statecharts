/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * rbeckmann - initial API and implementation
 */
package org.yakindu.sct.model.sgen.util;

import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression;
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.expressions.interpreter.DefaultExpressionInterpreter;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgen.util.BuiltinDeclarationNames;

/**
 * @author rbeckmann
 */
@SuppressWarnings("all")
public class BuiltinExpressionsInterpreter extends DefaultExpressionInterpreter implements BuiltinDeclarationNames {
  @Override
  protected Object _execute(final ElementReferenceExpression expression) {
    try {
      Object _xblockexpression = null;
      {
        EObject _reference = expression.getReference();
        if ((_reference instanceof Property)) {
          EObject _reference_1 = expression.getReference();
          String _name = ((Property) _reference_1).getName();
          if (_name != null) {
            switch (_name) {
              case BuiltinDeclarationNames.SCT_VERSION_VAR:
                final Version v = FrameworkUtil.getBundle(this.getClass()).getVersion();
                StringConcatenation _builder = new StringConcatenation();
                int _major = v.getMajor();
                _builder.append(_major);
                _builder.append(".");
                int _minor = v.getMinor();
                _builder.append(_minor);
                _builder.append(".");
                int _micro = v.getMicro();
                _builder.append(_micro);
                return _builder.toString();
              case BuiltinDeclarationNames.TIMESTAMP_VAR:
                DateFormat _dateTimeInstance = DateFormat.getDateTimeInstance();
                Date _date = new Date();
                return _dateTimeInstance.format(_date).toString();
              case BuiltinDeclarationNames.USER_VAR:
                return System.getProperty("user.name").toString();
              case BuiltinDeclarationNames.HOSTNAME_VAR:
                return InetAddress.getLocalHost().getHostName().toString();
              default:
                return this.executeElementReferenceExpression(expression);
            }
          } else {
            return this.executeElementReferenceExpression(expression);
          }
        }
        _xblockexpression = this.executeElementReferenceExpression(expression);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object execute(final Expression expression) {
    if (expression instanceof BitwiseAndExpression) {
      return _execute((BitwiseAndExpression)expression);
    } else if (expression instanceof BitwiseOrExpression) {
      return _execute((BitwiseOrExpression)expression);
    } else if (expression instanceof BitwiseXorExpression) {
      return _execute((BitwiseXorExpression)expression);
    } else if (expression instanceof ElementReferenceExpression) {
      return _execute((ElementReferenceExpression)expression);
    } else if (expression instanceof FeatureCall) {
      return _execute((FeatureCall)expression);
    } else if (expression instanceof LogicalAndExpression) {
      return _execute((LogicalAndExpression)expression);
    } else if (expression instanceof LogicalNotExpression) {
      return _execute((LogicalNotExpression)expression);
    } else if (expression instanceof LogicalOrExpression) {
      return _execute((LogicalOrExpression)expression);
    } else if (expression instanceof LogicalRelationExpression) {
      return _execute((LogicalRelationExpression)expression);
    } else if (expression instanceof NumericalAddSubtractExpression) {
      return _execute((NumericalAddSubtractExpression)expression);
    } else if (expression instanceof NumericalMultiplyDivideExpression) {
      return _execute((NumericalMultiplyDivideExpression)expression);
    } else if (expression instanceof NumericalUnaryExpression) {
      return _execute((NumericalUnaryExpression)expression);
    } else if (expression instanceof PostFixUnaryExpression) {
      return _execute((PostFixUnaryExpression)expression);
    } else if (expression instanceof ShiftExpression) {
      return _execute((ShiftExpression)expression);
    } else if (expression instanceof AssignmentExpression) {
      return _execute((AssignmentExpression)expression);
    } else if (expression instanceof ConditionalExpression) {
      return _execute((ConditionalExpression)expression);
    } else if (expression instanceof ParenthesizedExpression) {
      return _execute((ParenthesizedExpression)expression);
    } else if (expression instanceof PrimitiveValueExpression) {
      return _execute((PrimitiveValueExpression)expression);
    } else if (expression instanceof TypeCastExpression) {
      return _execute((TypeCastExpression)expression);
    } else if (expression != null) {
      return _execute(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
