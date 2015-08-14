[![Build Status](https://travis-ci.org/Yakindu/statecharts.svg?branch=master)](https://travis-ci.org/Yakindu/statecharts)

#Yakindu Statechart Tools 
# (http://www.statecharts.org)

The free to use, open source toolkit YAKINDU Statechart Tools (SCT) provides an integrated modeling environment for the specification and development of reactive, event-driven systems based on the concept of Harel statecharts. 

## How to Contribute

We appreciate any feedback and there are various ways to contribute feedback:

* Report bugs and request features in our issue tracker.
* Ask questions and get support in our <a href="https://groups.google.com/forum/embed/?place=forum/yakindu-user#!forum/yakindu-user">google group</a>
* visit our <a  href="http://statecharts.org">web page</a> take a look at blog posts tutorials etc.
* get the source code (see below) - fork it - work on it - and provide pull requests ... 
 

## Setting up the development environment using Oomph (recommended)

1. Download and start <a href="https://wiki.eclipse.org/Eclipse_Oomph_Installer" target="_blank">Oomph</a> and the <a href="https://raw.githubusercontent.com/Yakindu/statecharts/master/StatechartTools.setup" target="_blank">Oomph-Setup file</a> (rightclick, *save as...*).
2. On the initial page, click on the *Switch to advanced mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Java Developers*, press *Next*.
4. On the *Project* page, press on the green plus-symbol. *Browse File System* to select the downloaded Oomph-Setup file.
5. Doubleclick on the project *Statechart Tools* to add it to the catalog below, press *Next*.
6. Choose a meaningful name for the *Installation folder* on the *Variables* page, press *Next*.
7. On the last page you have to confirm the settings by clicking on *Finish*. The setup is executing tasks now. Meanwhile: Drink a cup of coffee, and watch how your Statechart Tools development environment is assembled.
8. (Optional) Press *Finish* to close the initial Progress window. 
9. (Optional) Clicking on the double arrow (![double arrow](oomph_icon.png)) allows you to see the further progression. Press *Finish* to close the window, when then installer is done.
10. After building the workspace, you will see a lot of errors in it. That's because the language artifacts haven't been generated yet. Oomph made a contribution to the toolbar. Press on the double arrow symbol and only select the three Launches (the other tasks already have been executed) to generate the languages (Expressions, SText, SGen)
11. Click *Proceed* three times to execute the launches although the errors.

## How to setup your developer workspace without Oomph
1. Download Eclipse Luna from https://www.eclipse.org/downloads/
2. Install the current Xtext release -> Help / Install new Software / select 'Luna - http://download.eclipse.org/releases/luna'
2.1 Select Modeling / Xtext Complete SDK
3. Select the Git perspective and clone the following Git Repositories:
https://github.com/Yakindu/statecharts.git
https://github.com/Yakindu/base.git
On both repositories, select 'Import projects' on the 'working directory' subfolder
4. Set the target platform to org.yakindu.base.target/luna.target
Open the target file and click on the link for setting the target platform (takes some minutes the first time)
5. Build relevant Xtext grammars
Rightclick on org.yakindu.base.expressions/Expressions.xtext => Run As.. => Generate Xtext Artifacts
Rightclick on org.yakindu.sct.stext/SText.xtext => Run As.. => Generate Xtext Artifacts
Rightclick org.yakindu.sct.generator.genmodel/SGen.xtext => Run As.. => Generate Xtext Artifacts

After these steps all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application


