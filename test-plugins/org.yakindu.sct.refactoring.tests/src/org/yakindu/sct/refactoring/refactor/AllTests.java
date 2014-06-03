/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.refactoring.refactor.impl.ExtractSubdiagramRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.FoldIncomingActionsRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.FoldOutgoingActionsRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.GroupStatesIntoCompositeRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.InlineSubdiagramRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.RenameRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.UnfoldEntryActionsRefactoringTest;
import org.yakindu.sct.refactoring.refactor.impl.UnfoldExitActionsRefactoringTest;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ FoldIncomingActionsRefactoringTest.class,
		FoldOutgoingActionsRefactoringTest.class, RenameRefactoringTest.class,
		UnfoldEntryActionsRefactoringTest.class,
		UnfoldExitActionsRefactoringTest.class,
		GroupStatesIntoCompositeRefactoringTest.class,
		ExtractSubdiagramRefactoringTest.class,
		InlineSubdiagramRefactoringTest.class})
public class AllTests {

}
