/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 */
package org.yakindu.sct.types.generator.statechart.core;

public class PackageGeneratorEntryExecutor /* implements AbstractGeneratorEntryExecutor  */{
  /* @Inject
   */protected /* ModelSequencer */Object sequencer;
  
  /* @Inject
   */protected /* ITypesGenerator */Object generator;
  
  protected Object execute(final /* ISCTFileSystemAccess */Object access, final /* GeneratorEntry */Object generatorEntry) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PackageGeneratorEntryExecutor.generator refers to the missing type ITypesGenerator"
      + "\nThe method createPackages(GeneratorEntry) from the type PackageGeneratorEntryExecutor refers to the missing type Collection"
      + "\ngenerate cannot be resolved");
  }
  
  protected /* Collection<Package> */Object createPackages(final /* GeneratorEntry */Object entry) {
    throw new Error("Unresolved compilation problems:"
      + "\nStatechart cannot be resolved to a type."
      + "\nThe field PackageGeneratorEntryExecutor.sequencer refers to the missing type ModelSequencer"
      + "\nelementRef cannot be resolved"
      + "\ntransform cannot be resolved");
  }
}
