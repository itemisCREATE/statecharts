/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service;

/**
 * 
 * @author t00manysecretss
 * 
 */

public interface ExampleWizardConstants {

	public static final String WINDOW_TITLE = "YAKINDU Examples";
	public static final String ASK_PAGE_TITLE = "Yakindu Statechart Tools";
	public static final String ASK_PAGE_DESCRIPTION = "This wizard provides serveral example projects created for and with Yakindu Statechart Tools.";
	public static final String ASK_PAGE_LABEL_TEXT = "In order to provide you with the latest example projects\nthis wizard needs internet access.\n A small amount of hard drive storage is also required.\nBy pressing on \"next\" you agree with these conditions.\nOtherwise close the wizard now by clicking on \"cancel\".";
	public static final String UPDATE_PAGE_TITLE = "Updating Example Repository...";
	public static final String UPDATE_PAGE_DESCRIPTION = "Please wait while the program updates your local example files.";
	public static final String UPDATE_PAGE_DESCRIPTION_FINISH = "Finished! Click \"next\" to continue";
	public static final String SELECT_PAGE_TITLE = "Select an example";
	public static final String SELECT_PAGE_DESCRIPTION = "Choose an example project to import it.";
	public static final String WIZARD_ERROR_NOTHING_SELECTED = "You have to select an example in order to continue.";
	public static final String WIZARD_ERROR_NO_INTERNET_CONNECTION = "You are not connected to the internet.\nPlease check your cable and network configs.";
	public static final String WIZARD_ERROR_GIT = "It seems there is a problem with git\nPlease try again later.";
}