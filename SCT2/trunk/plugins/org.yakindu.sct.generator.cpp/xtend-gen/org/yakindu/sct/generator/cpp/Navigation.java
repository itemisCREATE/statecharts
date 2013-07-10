package org.yakindu.sct.generator.cpp;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;

@SuppressWarnings("all")
public class Navigation extends org.yakindu.sct.generator.c.Navigation {
  public Iterable<OperationDefinition> operations(final Scope it) {
    EList<Declaration> _declarations = it.getDeclarations();
    Iterable<OperationDefinition> _filter = Iterables.<OperationDefinition>filter(_declarations, OperationDefinition.class);
    return _filter;
  }
  
  public boolean hasOperations(final Scope it) {
    Iterable<OperationDefinition> _operations = this.operations(it);
    boolean _isEmpty = IterableExtensions.isEmpty(_operations);
    boolean _not = (!_isEmpty);
    return _not;
  }
}
