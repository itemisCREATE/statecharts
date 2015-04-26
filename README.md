
#Yakindu Statechart Tools 
## (http://www.statecharts.org)

The free to use, open source toolkit YAKINDU Statechart Tools (SCT) provides an integrated modeling environment for the specification and development of reactive, event-driven systems based on the concept of statecharts. 

## How to setup your developer workspace 
  * Download Eclipse Luna from https://www.eclipse.org/downloads/
  * Install the current Xtext release 
   * Help / Install new Software / select 'Luna - http://download.eclipse.org/releases/luna'
   * Select Modeling / Xtext Complete SDK
  * Select the Git perspective and clone the following Git Repositories:
   * https://github.com/Yakindu/statecharts.git
   * https://github.com/Yakindu/base.git
  * On both repositories, select 'Import projects' on the 'working directory' subfolder
  * Set the target platform to org.yakindu.base.target/luna.target
    * Open the target file and click on the link for setting the target platform (takes some minutes the first time)
  * Build relevant Xtext grammars
    * Rightclick on org.yakindu.base.expressions/Expressions.xtext => Run As.. => Generate Xtext Artifacts
    * Rightclick on org.yakindu.sct.stext/SText.xtext => Run As.. => Generate Xtext Artifacts
    * Rightclick org.yakindu.sct.generator.genmodel/SGen.xtext => Run As.. => Generate Xtext Artifacts
    * 
After these steps all projects should compile without errors. To launch a runtime instance which has these projects as installed plugins, just right-click on a project => Run As => Eclipse Application

