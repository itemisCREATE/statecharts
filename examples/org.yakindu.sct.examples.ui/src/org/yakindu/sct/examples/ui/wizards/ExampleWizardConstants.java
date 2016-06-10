package org.yakindu.sct.examples.ui.wizards;

import java.io.File;

import org.eclipse.core.runtime.Path;

public interface ExampleWizardConstants {

	public static final String WINDOW_TITLE ="YAKINDU Examples";
	public static final String ASK_PAGE_TITLE = "Yakindu Statechart Tools";
	public static final String ASK_PAGE_DESCRIPTION = "This wizard provides serveral example projects created for and with Yakindu Statechart Tools.";
	public static final String ASK_PAGE_LABEL_TEXT = "\n\n\n\n\n\n\n\nIn order to provide you with the latest example prjects\nthis wizard need internet access to Github.\n A small amount of hard drive storage is also required.\nBy pressing on \"next\" you agree with these conditions.\nOtherwise close the wizard now by clicking on \"cancel\".";
	public static final String UPDATE_PAGE_TITLE = "Updating Example Repository...";
	public static final String UPDATE_PAGE_DESCRIPTION = "Please wait while the program updates your local example files.";
	public static final String UPDATE_PAGE_DESCRIPTION_FINISH = "Finished! Click \"next\" to continue";
	public static final String SELECT_PAGE_TITLE = "Select an example";
	public static final String SELECT_PAGE_DESCRIPTION = "Choose an Example Project to import it.";
	public static final String WIZARD_ERROR_NOTHING_SELECTED = "You have to select an Example in order to continue.";
	public static final String WIZARD_ERROR_NO_INTERNET_CONNECTION = "You are not connected to the Internet\nPlease check your cable and network configs.";
	public static final String WIZARD_ERROR_GIT = "It seems there is a Problem with git\nPlease try again later.";
	public static final String DEFAULT_PROJECT_TITLE = "Example title";
	public static final String DEFAULT_PROJECT_DESCRIPTION = "Example discription";
	public static final String[] REMOTE_REPOS = {"https://github.com/t00manysecretss/statecharts-examples.git"};
	public static final File LOCAL_REPO_ROOT = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "org.yakindu.temp");
	public static final Path FILEICON = new Path("icons/logo-16.png");
	public static final Path FOLDERICON = new Path("icons/logo-16.png");
	public static final Path WAITINGICON = new Path("icons/wait.png");
	public static final Path CHECKICON = new Path("icons/check.png");
}