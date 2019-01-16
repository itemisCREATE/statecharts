/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.execution;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.generator.core.console.IConsoleLogger;
import org.yakindu.sct.generator.core.filesystem.DefaultFileSystemAccessFactory;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import static org.yakindu.sct.generator.core.GeneratorActivator.PLUGIN_ID;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractGeneratorEntryExecutor implements IGeneratorEntryExecutor {

	@Inject
	protected DefaultFileSystemAccessFactory factory;
	@Inject
	protected IConsoleLogger logger;
	@Inject
	protected ICoreLibraryHelper helper;
	@Inject
	protected IResourceValidator validator;
	@Inject(optional = true)
	@Named(SKIP_VALIDATION)
	protected boolean skipValidation = false;

	protected abstract void execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry);

	@Override
	public IStatus execute(GeneratorEntry entry) {
		IStatus status = Status.OK_STATUS;
		
		logStart(entry);
		if (valid(entry)) {
			try {
				execute(factory.create(entry), entry);
			} catch (Exception ex) {
				logger.logError(ex);
				status = new Status(IStatus.ERROR, PLUGIN_ID, ex.toString());
			}
		} else {
			status = new Status(IStatus.ERROR, PLUGIN_ID,
					"The referenced model (" + ((NamedElement) entry.getElementRef()).getName() + ") contains errors. See console log for more details.");
		}
		logEnd(entry);
		return status;
	}

	protected void logStart(GeneratorEntry entry) {
		EObject elementRef = entry.getElementRef();
		String elementName = elementRef instanceof NamedElement
				? ((NamedElement) elementRef).getName()
				: elementRef.toString();
		String targetProject = helper.getTargetProjectValue(entry).getStringValue();
		logger.log(String.format("Generating '%s' to target project '%s' ...", elementName, targetProject));
	}

	protected void logEnd(GeneratorEntry entry) {
		logger.log(((NamedElement) entry.getElementRef()).getName() + " done.");
	}

	protected void logException(Exception ex) {
		logger.logError(ex);
	}

	protected boolean valid(GeneratorEntry entry) {
		if (skipValidation) {
			logger.log("Validation skipped...");
			return true;
		}
		List<Issue> issues = validator.validate(entry.getElementRef().eResource(), CheckMode.ALL, null);
		Iterable<Issue> errors = Iterables.filter(issues, new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				return input.getSeverity() == Severity.ERROR;
			}
		});
		if (!Iterables.isEmpty(errors)) {
			logger.log("The referenced model (" + ((NamedElement) entry.getElementRef()).getName()
					+ ") contains errors and could not be generated:");
			for (Issue issue : errors) {
				logger.log(issue.getMessage());
			}
			return false;
		}
		return true;
	}
}
