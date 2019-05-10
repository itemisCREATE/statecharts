/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.statechart.core;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.yakindu.sct.generator.core.execution.AbstractGeneratorEntryExecutor;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.model.sequencer.ModelSequencer;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.types.generator.ITypesGenerator;

@SuppressWarnings("all")
public class PackageGeneratorEntryExecutor extends AbstractGeneratorEntryExecutor {
  @Inject
  protected ModelSequencer sequencer;
  
  @Inject
  protected ITypesGenerator generator;
  
  @Override
  protected void execute(final ISCTFileSystemAccess access, final GeneratorEntry generatorEntry) {
    this.generator.generate(this.createPackages(generatorEntry), access);
  }
  
  protected Collection<org.yakindu.base.types.Package> createPackages(final GeneratorEntry entry) {
    List<org.yakindu.base.types.Package> _xblockexpression = null;
    {
      final EObject elementRef = entry.getElementRef();
      List<org.yakindu.base.types.Package> _xifexpression = null;
      if ((elementRef instanceof Statechart)) {
        org.yakindu.base.types.Package _transform = this.sequencer.transform(((Statechart)elementRef), null);
        _xifexpression = Collections.<org.yakindu.base.types.Package>unmodifiableList(CollectionLiterals.<org.yakindu.base.types.Package>newArrayList(_transform));
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
