## Build everything from source

If you are familiar with Eclipse plugin development then you may want to checkout the source, setup the development environment, and start working with it. In this case you have the options described below.

### Setting up the development environment using Oomph (recommended)

1. Download the <a href="https://wiki.eclipse.org/Eclipse_Oomph_Installer" target="_blank">Oomph Eclipse Installer</a> for your platform and install it.
2. Start Oomph by executing *eclipse-installer/eclipse-inst*.
3. On the initial page, select *Advanced Mode* in the menu at the top right.
4. On the *Product* page, select *Eclipse IDE for Eclipse Committers* in the *Eclipse.org* folder, then click *Next*.
5. On the *Projects* page, select *Github Projects*.
6. Click on the green "plus" symbol. Copy the Link https://raw.githubusercontent.com/Yakindu/statecharts/master/StatechartTools.setup in to the text field.
7. Click on *OK*. The project *Statechart Tools* is available as *Github Projects/&lt;User&gt;/Statechart Tools*.
8. Double-click on the project *Statechart Tools* to add it to the catalog section at the bottom of the wizard page, then click *Next*. Choose only the "Statechart Tools". Uncheck the others, if needed.
9. On the *Variables* page, choose a meaningful name for the *Installation folder name* variable, then click *Next*.
10. On the *Confirmation* page, check the settings, then click on *Finish*.
11. The setup is executing its tasks now. Meanwhile: Drink a cup of coffee, and watch your Statechart Tools development environment being assembled. Oh, and please review and accept any licenses for the software to be installed.
12. You are asked whether you trust the certificate of "Eclipse.org Foundation, Inc.". If you do, check the certificate in the dialog box and click on *OK*.
13. After the installation has been completed, Eclipse starts up with the YAKINDU Statechart Tools projects in your workspace.
14. (Optional) Click on *Finish* in the Oomph window to close it. 
15. (Optional) While installing, clicking on the double-arrow (![double arrow](oomph_icon.png)) allows you to see the further progression. Click on *Finish* to close the window when the installer is done.
16. After having built the workspace, you will see a lot of errors in it. That's because the language artifacts haven't been generated yet. Oomph made a contribution to the toolbar. Click on the double-arrow symbol. The *Confirmation* window appears. Deselect everything except for the three "Launch …" tasks and the "Project Build (Clean, Build) task. (The other tasks have already been executed.) The selected tasks will generate the languages "Expressions", "SText", and "SGen" and run a clean build.
17. Click on *Finish*.
18. Click *Proceed* three times in order to confirm the execution of each launch despite any existing errors.

### How to setup your developer workspace without Oomph
1. Download latest Eclipse from https://www.eclipse.org/downloads/
2. Install the latest Xtext release -> Help / Install new Software / select '2018-09 - http://download.eclipse.org/releases/2018-09'
2.1 Select Modeling / Xtext Complete SDK 
3. Select the Git perspective and clone the following Git Repository:
https://github.com/Yakindu/statecharts.git
Select 'Import projects' on the 'working directory' subfolder
4. Set the target platform to org.yakindu.base.target/2018-09.target
Open the target file and click on the link for setting the target platform (takes some minutes the first time)
5. Build relevant Xtext grammars
    1. Rightclick on org.yakindu.base.expressions/Expressions.xtext => Run As... => Generate Xtext Artifacts
    1. Rightclick on org.yakindu.sct.stext/SText.xtext => Run As... => Generate Xtext Artifacts
    1. Rightclick org.yakindu.sct.generator.genmodel/SGen.xtext => Run As... => Generate Xtext Artifacts


After these steps, all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application