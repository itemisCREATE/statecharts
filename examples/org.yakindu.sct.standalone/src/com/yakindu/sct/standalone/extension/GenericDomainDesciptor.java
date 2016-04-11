package com.yakindu.sct.standalone.extension;

import java.nio.charset.Charset;

import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.domain.extension.IDomainDescriptor;
import org.yakindu.sct.domain.extension.IDomainInjectorProvider;
import org.yakindu.sct.domain.generic.extension.GenericDomainInjectorProvider;

import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.yakindu.sct.standalone.generator.StandaloneFileSystemAccess;
import com.yakindu.sct.standalone.generator.Log4jGeneratorLog;
import com.yakindu.sct.standalone.generator.StandaloneGeneratorModule;

public class GenericDomainDesciptor implements IDomainDescriptor {
	
	
	private String genRootDir;
	private Charset encoding;
	public GenericDomainDesciptor(String genRootDir, Charset encoding) {
		this.genRootDir = genRootDir;
		this.encoding = encoding;
	}
	
	@Override
	public String getDomainID() {
		return "org.yakindu.domain.default";
	}
	@Override
	public String getName() {
		return "Default";
	}
	@Override
	public String getDescription() {
		return "The default domain for YAKINDU Statechart Tools.";
	}
	@Override
	public IDomainInjectorProvider getDomainInjectorProvider() {
		return new GenericDomainInjectorProvider() {
			@Override
			public Module getGeneratorModule(String generatorId) {
				Module generatorModule = super.getGeneratorModule(generatorId);
				return Modules.override(generatorModule).with(new StandaloneGeneratorModule(genRootDir,
						encoding, StandaloneFileSystemAccess.class, Log4jGeneratorLog.class));
			}
			protected Module getResourceModule() {
				return Modules.override(getLanguageRuntimeModule()).with(getTypeSystemModule());
			};
		};
	}
	@Override
	public Image getImage() {
		return null;
	}
}