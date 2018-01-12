/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author rbeckmann
 *
 */
public class STextNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper implements INamesAreUniqueValidationHelper {
	protected OperationCanceledManager operationCanceledManager = new OperationCanceledManager();

	protected Map<QualifiedName, IEObjectDescription> nameMap;
	
	protected Map<EClass, Node<EClass>> superClasses = new HashMap<>();

	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, ValidationMessageAcceptor acceptor) {
		checkUniqueNames(descriptions, null, acceptor);
	}

	/**
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * The cancel indicator will be queried everytime a description has been
	 * processed. It should provide a fast answer about its canceled state.
	 */
	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator,
			ValidationMessageAcceptor acceptor) {
		Iterator<IEObjectDescription> iter = descriptions.iterator();
		this.nameMap = new HashMap<>();
		if (!iter.hasNext())
			return;
		while (iter.hasNext()) {
			IEObjectDescription description = iter.next();
			checkDescriptionForDuplicatedName(description, acceptor);
			operationCanceledManager.checkCanceled(cancelIndicator);
		}
	}

	protected void checkDescriptionForDuplicatedName(IEObjectDescription description,
			ValidationMessageAcceptor acceptor) {
		QualifiedName qName = description.getName();
		IEObjectDescription put = nameMap.put(qName, description);
		if(put != null) {
			EClass common = checkForCommonSuperClass(put, description, acceptor);
			if(common != null) {
				createDuplicateNameError(description, common, acceptor);
				createDuplicateNameError(put, common, acceptor);
			}
		}
	}
	
	protected Node<EClass> getSuperClassTree(EClass eClass) {
		Node<EClass> node;
		
		node = superClasses.get(eClass);
		
		if(node == null) {
			node = new Node<EClass>(eClass);
			buildSuperClassTree(node);
			superClasses.put(eClass, node);
		}
		
		return node;
	}

	protected EClass checkForCommonSuperClass(IEObjectDescription one, IEObjectDescription two,
			ValidationMessageAcceptor acceptor) {
		
		Node<EClass> superClassesOne = getSuperClassTree(one.getEClass());
		Node<EClass> superClassesTwo = getSuperClassTree(two.getEClass());
		
		List<EClass> flatOne = superClassesOne.flatten();
		List<EClass> flatTwo = superClassesTwo.flatten();
		
		for(EClass eC : flatOne) {
			if(flatTwo.contains(eC))
				return eC;
		}
		
		return null;
	}
	
	protected void buildSuperClassTree(Node<EClass> node) {
		List<EClass> superClasses = node.getData().getESuperTypes();
		
		for(EClass sC : superClasses) {
			Node<EClass> sCNode = new Node<EClass>(sC);
			node.addChild(sCNode);
			buildSuperClassTree(sCNode);
		}
	}
	
	private static class Node<T> {
		protected T data;
		
		protected List<Node<T>> children = new ArrayList<>();
		
		protected Node<T> parent;
		
		public Node(T data) {
			this.data = data;
		}
		
		public void addChild(T childData) {
			Node<T> node = new Node<T>(childData);
			addChild(node);
		}
		
		public void addChild(Node<T> child) {
			child.setParent(this);
			this.children.add(child);
		}
		
		public void setParent(Node<T> parent) {
			this.parent = parent;
		}
		
		public Node<T> getParent() {
			return this.parent;
		}
		
		public List<Node<T>> getChildren() {
			return this.children;
		}
		
		public T getData() {
			return this.data;
		}
		
		public List<T> flatten() {
			List<T> data = new ArrayList<T>();
			data.add(this.getData());
			
			this.flatten(data);
			
			return data;
		}
		
		public void flatten(List<T> data) {
			for(Node<T> child : this.getChildren()) {
				data.add(child.getData());
			}

			for(Node<T> child : this.getChildren()) {
				child.flatten(data);
			}
		}
	}

}
