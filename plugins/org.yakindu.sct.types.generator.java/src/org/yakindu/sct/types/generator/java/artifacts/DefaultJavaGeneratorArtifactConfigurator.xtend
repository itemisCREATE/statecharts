package org.yakindu.sct.types.generator.java.artifacts

import com.google.inject.Inject
import java.rmi.Naming
import java.util.Collection
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.types.generator.artifacts.GeneratorArtifactConfiguration
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator

class DefaultJavaGeneratorArtifactConfigurator implements IGeneratorArtifactConfigurator {

	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension Naming

	protected GeneratorArtifactConfiguration config

	override configure(Collection<Package> packages, ISCTFileSystemAccess fileSystemAccess) {
		config = new GeneratorArtifactConfiguration(fileSystemAccess)
		packages.forEach[
			configureFiles
		]
		config
	}

	def protected configureFiles(Package p) {
		p.member.filter(ComplexType).forEach [
			config.configure(toFilePath(p, it), sourceDirectory, it, false)
		]
	}

	def protected String sourceDirectory() {
		"src-gen"
	}

	def protected toFilePath(Package p, Type t) {
		p.name.replace(".", "/") + "/" + t.name + ".java"
	}

}
