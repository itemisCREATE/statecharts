package org.yakindu.sct.types.generator.c

import org.yakindu.sct.types.generator.artifacts.GeneratorArtifact

class CTypesGeneratorExtensions {
	def includeGuardStart(GeneratorArtifact<?> it, String HeaderFileEnding) {
		if (name.endsWith(HeaderFileEnding)) {
			return '''
				#ifndef «getGuard(HeaderFileEnding)»
				#define «getGuard(HeaderFileEnding)»
			'''
		}
	}

	def includeGuardEnd(GeneratorArtifact<?> it, String HeaderFileEnding) {
		if (name.endsWith(HeaderFileEnding)) {
			return '''
				#endif /* «getGuard(HeaderFileEnding)» */
			'''
		}
	}

	def protected getGuard(GeneratorArtifact<?> it, String HeaderFileEnding) {
		name.replace(HeaderFileEnding, "").toUpperCase + "_H_"
	}

	def protected externCStart(GeneratorArtifact<?> it) {
		if (name.endsWith(CTargetPlatform.HEADER_FILE_ENDING)) {
			return '''
				#ifdef __cplusplus
				extern "C" {
				#endif
			'''
		}
	}

	def protected externCEnd(GeneratorArtifact<?> it) {
		if (name.endsWith(CTargetPlatform.HEADER_FILE_ENDING)) {
			return '''
				#ifdef __cplusplus
				}
				#endif
			'''
		}
	}
}
