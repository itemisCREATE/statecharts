/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * 
 * @author andreas muelder - Initial contribution and API
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionContext#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionContext#getExecutedElements <em>Executed Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionContext#getSuspendedElements <em>Suspended Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionContext#isSnapshot <em>Snapshot</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionContext()
 * @model
 * @generated
 */
public interface ExecutionContext extends NamedElement, CompositeSlot {
	/**
	 * Returns the value of the '<em><b>Active States</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active States</em>' reference list.
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionContext_ActiveStates()
	 * @model
	 * @generated
	 */
	List<EObject> getActiveStates();

	/**
	 * Returns the value of the '<em><b>Executed Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executed Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executed Elements</em>' reference list.
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionContext_ExecutedElements()
	 * @model
	 * @generated
	 */
	List<EObject> getExecutedElements();

	/**
	 * Returns the value of the '<em><b>Suspended Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspended Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspended Elements</em>' reference list.
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionContext_SuspendedElements()
	 * @model
	 * @generated
	 */
	List<EObject> getSuspendedElements();

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot</em>' attribute.
	 * @see #setSnapshot(boolean)
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionContext_Snapshot()
	 * @model unique="false"
	 * @generated
	 */
	boolean isSnapshot();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sruntime.ExecutionContext#isSnapshot <em>Snapshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' attribute.
	 * @see #isSnapshot()
	 * @generated
	 */
	void setSnapshot(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(it.isRaised());\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;&gt;filter(this.getAllEvents(), _function));'"
	 * @generated
	 */
	List<ExecutionEvent> getRaisedEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" qualifiedNameUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt; _xblockexpression = null;\n{\n\t&lt;%org.eclipse.core.runtime.Assert%&gt;.isNotNull(qualifiedName);\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt; it)\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _fqName = it.getFqName();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(qualifiedName, _fqName));\n\t\t}\n\t};\n\t_xblockexpression = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;&gt;findFirst(this.getAllVariables(), _function);\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	ExecutionVariable getVariable(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" qualifiedNameUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt; _xblockexpression = null;\n{\n\t&lt;%org.eclipse.core.runtime.Assert%&gt;.isNotNull(qualifiedName);\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt; it)\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _fqName = it.getFqName();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(qualifiedName, _fqName));\n\t\t}\n\t};\n\t_xblockexpression = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;&gt;findFirst(this.getAllEvents(), _function);\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	ExecutionEvent getEvent(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" qualifiedNameUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt; _xblockexpression = null;\n{\n\t&lt;%org.eclipse.core.runtime.Assert%&gt;.isNotNull(qualifiedName);\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt; it)\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _fqName = it.getFqName();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(qualifiedName, _fqName));\n\t\t}\n\t};\n\t_xblockexpression = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt;findFirst(this.getAllSlots(), _function);\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	ExecutionSlot getSlot(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;&gt;filter(this.getAllSlots(), &lt;%org.yakindu.sct.model.sruntime.ExecutionEvent%&gt;.class));'"
	 * @generated
	 */
	List<ExecutionEvent> getAllEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;&gt;filter(this.getAllSlots(), &lt;%org.yakindu.sct.model.sruntime.ExecutionVariable%&gt;.class));'"
	 * @generated
	 */
	List<ExecutionVariable> getAllVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt; _xblockexpression = null;\n{\n\t&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt; result = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt;();\n\tthis.addSlots(result, this.getSlots(), &lt;%com.google.common.collect.Lists%&gt;.&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt;newArrayList());\n\t_xblockexpression = result;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	List<ExecutionSlot> getAllSlots();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model resultUnique="false" resultMany="true" slotsUnique="false" slotsMany="true" visitedMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.function.Consumer%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt;&gt;()\n{\n\tpublic void accept(final &lt;%org.yakindu.sct.model.sruntime.ExecutionSlot%&gt; it)\n\t{\n\t\tboolean _add = visited.add(it);\n\t\tif (_add)\n\t\t{\n\t\t\tresult.add(it);\n\t\t\tif ((it instanceof &lt;%org.yakindu.sct.model.sruntime.CompositeSlot%&gt;))\n\t\t\t{\n\t\t\t\t&lt;%this%&gt;.addSlots(result, ((&lt;%org.yakindu.sct.model.sruntime.CompositeSlot%&gt;)it).getSlots(), visited);\n\t\t\t}\n\t\t}\n\t}\n};\nslots.forEach(_function);'"
	 * @generated
	 */
	void addSlots(List<ExecutionSlot> result, List<ExecutionSlot> slots, List<ExecutionSlot> visited);

} // ExecutionContext
