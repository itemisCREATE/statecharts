/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.statechart.core.modification.library;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.AssignmentOperator;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.util.ExpressionBuilder;
import org.yakindu.base.expressions.util.ExpressionExtensions;
import org.yakindu.base.expressions.util.PackageNavigationExtensions;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Property;
import org.yakindu.sct.types.generator.modification.library.ContainmentExtensions;
import org.yakindu.sct.types.generator.modification.library.ReferenceExtension;
import org.yakindu.sct.types.generator.statechart.core.modification.library.PropertyAccessModification;
import org.yakindu.sct.types.modification.IModification;

/**
 * Transforms references to public properties by their respective getters or setters.
 * 
 * Needs PropertyAccessModification to be called beforehand.
 */
@SuppressWarnings("all")
public class PropertyReferenceModification implements IModification {
  @Inject
  @Extension
  protected PropertyAccessModification _propertyAccessModification;
  
  @Inject
  @Extension
  protected PackageNavigationExtensions _packageNavigationExtensions;
  
  @Inject
  @Extension
  protected ExpressionBuilder _expressionBuilder;
  
  @Inject
  @Extension
  protected ReferenceExtension _referenceExtension;
  
  @Inject
  @Extension
  protected ContainmentExtensions _containmentExtensions;
  
  @Inject
  @Extension
  protected ExpressionExtensions _expressionExtensions;
  
  @Override
  public Collection<org.yakindu.base.types.Package> modify(final Collection<org.yakindu.base.types.Package> packages) {
    Collection<org.yakindu.base.types.Package> _xblockexpression = null;
    {
      final Consumer<org.yakindu.base.types.Package> _function = (org.yakindu.base.types.Package it) -> {
        this.modify(it);
      };
      packages.forEach(_function);
      _xblockexpression = packages;
    }
    return _xblockexpression;
  }
  
  public org.yakindu.base.types.Package modify(final org.yakindu.base.types.Package p) {
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      Annotation _annotationOfType = it.getAnnotationOfType("InterfaceGroup");
      return Boolean.valueOf((_annotationOfType != null));
    };
    final Iterable<ComplexType> interfaceTypes = IterableExtensions.<ComplexType>filter(this._packageNavigationExtensions.allComplexTypes(p), _function);
    final Consumer<ComplexType> _function_1 = (ComplexType iface) -> {
      final Function1<Property, Boolean> _function_2 = (Property it) -> {
        boolean _isConst = it.isConst();
        return Boolean.valueOf((!_isConst));
      };
      final Procedure1<Property> _function_3 = (Property prop) -> {
        final Consumer<EObject> _function_4 = (EObject it) -> {
          this.toWriteAccess(it, prop);
        };
        this._referenceExtension.references(prop).forEach(_function_4);
        final Consumer<EObject> _function_5 = (EObject it) -> {
          this.toReadAccess(it, prop);
        };
        this._referenceExtension.references(prop).forEach(_function_5);
      };
      IteratorExtensions.<Property>forEach(IteratorExtensions.<Property>filter(Iterators.<Property>filter(iface.eAllContents(), Property.class), _function_2), _function_3);
    };
    interfaceTypes.forEach(_function_1);
    return p;
  }
  
  protected void _toReadAccess(final EObject reference, final Property prop) {
    throw new IllegalStateException(("Could not transform reference to read access: " + reference));
  }
  
  protected void _toReadAccess(final FeatureCall reference, final Property prop) {
    if (((!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.readAccess(prop))) && (!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.writeAccess(prop))))) {
      EObject _eContainer = reference.eContainer();
      boolean _not = (!(_eContainer instanceof PostFixUnaryExpression));
      if (_not) {
        EcoreUtil.replace(reference, this._expressionBuilder._fc(reference.getOwner(), this._propertyAccessModification.readAccess(prop)));
      }
    }
  }
  
  protected void _toReadAccess(final ElementReferenceExpression reference, final Property prop) {
    if ((((!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.readAccess(prop))) && (!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.writeAccess(prop)))) && (!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.assign(prop))))) {
      EObject _eContainer = reference.eContainer();
      boolean _not = (!(_eContainer instanceof PostFixUnaryExpression));
      if (_not) {
        EcoreUtil.replace(reference, this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)));
      }
    }
  }
  
  protected void _toWriteAccess(final EObject reference, final Property prop) {
    throw new IllegalStateException(("Could not transform reference to write access: " + reference));
  }
  
  protected void _toWriteAccess(final FeatureCall reference, final Property prop) {
    EObject _eContainer = reference.eContainer();
    if ((_eContainer instanceof AssignmentExpression)) {
      EObject _eContainer_1 = reference.eContainer();
      final AssignmentExpression assignment = ((AssignmentExpression) _eContainer_1);
      Expression _varRef = assignment.getVarRef();
      boolean _equals = Objects.equal(_varRef, reference);
      if (_equals) {
        if (((!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.writeAccess(prop))) && (!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.assign(prop))))) {
          final Operation method = this.getWriteMethod(prop, assignment);
          AssignmentOperator _operator = assignment.getOperator();
          if (_operator != null) {
            switch (_operator) {
              case ADD_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._plus(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case SUB_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._minus(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case DIV_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._divide(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case MULT_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._multiply(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case OR_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._bitwiseOr(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case AND_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._bitwiseAnd(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case XOR_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._bitwiseXor(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case LEFT_SHIFT_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._leftShift(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case RIGHT_SHIFT_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._rightShift(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case MOD_ASSIGN:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, this._expressionBuilder._mod(this._expressionBuilder._fc(this._expressionBuilder._ref(this._expressionExtensions.featureOrReference(reference.getOwner())), this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              default:
                EcoreUtil.replace(assignment, 
                  this._expressionBuilder._fc(reference.getOwner(), method, EcoreUtil.<Expression>copy(assignment.getExpression())));
                break;
            }
          } else {
            EcoreUtil.replace(assignment, 
              this._expressionBuilder._fc(reference.getOwner(), method, EcoreUtil.<Expression>copy(assignment.getExpression())));
          }
        }
      }
    }
  }
  
  protected void _toWriteAccess(final ElementReferenceExpression reference, final Property prop) {
    EObject _eContainer = reference.eContainer();
    if ((_eContainer instanceof AssignmentExpression)) {
      EObject _eContainer_1 = reference.eContainer();
      final AssignmentExpression assignment = ((AssignmentExpression) _eContainer_1);
      Expression _varRef = assignment.getVarRef();
      boolean _equals = Objects.equal(_varRef, reference);
      if (_equals) {
        if (((!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.writeAccess(prop))) && (!this._containmentExtensions.containedIn(reference, this._propertyAccessModification.assign(prop))))) {
          final Operation method = this.getWriteMethod(prop, assignment);
          AssignmentOperator _operator = assignment.getOperator();
          if (_operator != null) {
            switch (_operator) {
              case ADD_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._plus(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case SUB_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._minus(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case DIV_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._divide(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case MULT_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._multiply(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case OR_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._bitwiseOr(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case AND_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._bitwiseAnd(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case XOR_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._bitwiseXor(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case LEFT_SHIFT_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._leftShift(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case RIGHT_SHIFT_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._rightShift(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              case MOD_ASSIGN:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, this._expressionBuilder._mod(this._expressionBuilder._call(this._propertyAccessModification.readAccess(prop)), EcoreUtil.<Expression>copy(assignment.getExpression()))));
                break;
              default:
                EcoreUtil.replace(assignment, this._expressionBuilder._call(method, EcoreUtil.<Expression>copy(assignment.getExpression())));
                break;
            }
          } else {
            EcoreUtil.replace(assignment, this._expressionBuilder._call(method, EcoreUtil.<Expression>copy(assignment.getExpression())));
          }
        }
      }
    }
  }
  
  protected Operation getWriteMethod(final Property prop, final AssignmentExpression assignment) {
    Operation _xifexpression = null;
    boolean _needsAssignMethod = this._propertyAccessModification.needsAssignMethod(assignment);
    if (_needsAssignMethod) {
      _xifexpression = this._propertyAccessModification.assign(prop);
    } else {
      _xifexpression = this._propertyAccessModification.writeAccess(prop);
    }
    return _xifexpression;
  }
  
  protected void toReadAccess(final EObject reference, final Property prop) {
    if (reference instanceof ElementReferenceExpression) {
      _toReadAccess((ElementReferenceExpression)reference, prop);
      return;
    } else if (reference instanceof FeatureCall) {
      _toReadAccess((FeatureCall)reference, prop);
      return;
    } else if (reference != null) {
      _toReadAccess(reference, prop);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference, prop).toString());
    }
  }
  
  protected void toWriteAccess(final EObject reference, final Property prop) {
    if (reference instanceof ElementReferenceExpression) {
      _toWriteAccess((ElementReferenceExpression)reference, prop);
      return;
    } else if (reference instanceof FeatureCall) {
      _toWriteAccess((FeatureCall)reference, prop);
      return;
    } else if (reference != null) {
      _toWriteAccess(reference, prop);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference, prop).toString());
    }
  }
}
