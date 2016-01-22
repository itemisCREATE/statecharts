[![Build Status](https://travis-ci.org/Yakindu/statecharts.svg?branch=master)](https://travis-ci.org/Yakindu/statecharts)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/6091/badge.svg)](https://scan.coverity.com/projects/yakindu-statecharts)

#YAKINDU Statechart Tools 
# (http://www.statecharts.org)

The free to use, open source toolkit YAKINDU Statechart Tools (SCT) provides an integrated modeling environment for the specification and development of reactive, event-driven systems based on the concept of Harel statecharts. 


## License

The source code is provided under the <a href="http://www.eclipse.org/legal/epl-v10.html">Eclipse Public License</a>. 

The provided open source code generators do not imply any licence constraint on the generated code. The generated code is property of the user (as person or organization). There is no need to make the generate code open source and the user is free to choose any licence model for the generated code.

## Download & Installation

In addition to the source code provided here on GitHub we also provide ready-tu-use builds for Windows, Linux and OS X.  

1. Dowload a package from our <a href="http://www.statecharts.org/download.html" target="_blank">download page</a>.
2. Follow the <a href="https://github.com/Yakindu/statecharts/blob/master/plugins/org.yakindu.sct.doc.user/help/02_installation/installation.textile" target="_blank">installation instructions</a>.

## How to Contribute

We appreciate any feedback and there are various ways to contribute feedback:

* Report bugs and request features in our issue tracker.
* Ask questions and get support in our <a href="https://groups.google.com/forum/embed/?place=forum/yakindu-user#!forum/yakindu-user">google group</a>
* visit our <a  href="http://statecharts.org">web page</a> take a look at blog posts tutorials etc.
* get the source code (see below) - fork it - work on it - and provide pull requests ... 
 

## Setting up the development environment using Oomph (recommended)

1. Download the <a href="https://wiki.eclipse.org/Eclipse_Oomph_Installer" target="_blank">Oomph Eclipse Installer</a> for your platform and install it.
2. Download the <a href="https://raw.githubusercontent.com/Yakindu/statecharts/master/StatechartTools.setup" target="_blank">YAKINDU Statechart Tools Setup file</a> for Oomph (rightclick, *save as …*).
2.Download the <a href="https://github.com/Yakindu/statecharts/blob/master/StatechartTools.setup" target="_blank">YAKINDU Statechart Tools Setup file</a> for Oomph (rightclick, *save as …*).
3. Start Oomph by executing *eclipse-installer/eclipse-inst*.
4. On the initial page, select *Advanced Mode* in the menu at the top right.
5. On the *Product* page, select *Eclipse IDE for Eclipse Committers* in the *Eclipse.org* folder, then click *Next*.
6. On the *Projects* page, select *Github Projects*.
7. Click on the green "plus" symbol. Click on *Browse File System* and select the downloaded YAKINDU Statechart Tools Setup file.
8. Click on *OK*. The project *Statechart Tools* is available as *Github Projects/<User>/Statechart Tools*.
9. Double-click on the project *Statechart Tools* to add it to the catalog section at the bottom of the wizard page.
10. On the *Variables* page, choose a meaningful name for the *Installation folder name* variable, then click *Next*.
11. On the *Confirmation* page, check the settings, then click on *Finish*.
12. The setup is executing its tasks now. Meanwhile: Drink a cup of coffee, and watch your Statechart Tools development environment being assembled.
13. After the installation has been completed, Eclipse starts up with the YAKINDU Statechart Tools projects in your workspace.
14. (Optional) Click on *Finish* in the Oomph window to close it. 
15. (Optional) While installing, clicking on the double-arrow (![double arrow](oomph_icon.png)) allows you to see the further progression. Click on *Finish* to close the window when the installer is done.
16. After having built the workspace, you will see a lot of errors in it. That's because the language artifacts haven't been generated yet. Oomph made a contribution to the toolbar. Click on the double-arrow symbol. The *Confirmation* window appears. Deselect everything except for the three "Launch …" tasks. (The other tasks have already been executed.) The selected tasks will generate the languages "Expressions", "SText", and "SGen".
17. Click on *Finish*.
18. Click *Proceed* three times in order to confirm the execution of each launch despite any existing errors.

## How to setup your developer workspace without Oomph
1. Download Eclipse Luna from https://www.eclipse.org/downloads/
2. Install the current Xtext release -> Help / Install new Software / select 'Luna - http://download.eclipse.org/releases/luna'
2.1 Select Modeling / Xtext Complete SDK
3. Select the Git perspective and clone the following Git Repository:
https://github.com/Yakindu/statecharts.git
Select 'Import projects' on the 'working directory' subfolder
4. Set the target platform to org.yakindu.base.target/luna.target
Open the target file and click on the link for setting the target platform (takes some minutes the first time)
5. Build relevant Xtext grammars
Rightclick on org.yakindu.base.expressions/Expressions.xtext => Run As.. => Generate Xtext Artifacts
Rightclick on org.yakindu.sct.stext/SText.xtext => Run As.. => Generate Xtext Artifacts
Rightclick org.yakindu.sct.generator.genmodel/SGen.xtext => Run As.. => Generate Xtext Artifacts

After these steps all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application

## Thanks
<img src="https://www.yourkit.com/images/yklogo.png" /> <br />
YourKit is kindly supporting open source projects with its full-featured Java Profiler.
YourKit, LLC is the creator of innovative and intelligent tools for profiling
Java and .NET applications. Take a look at YourKit's leading software products:
<a href="http://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a> and
<a href="http://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>.
