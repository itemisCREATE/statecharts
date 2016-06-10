package org.yakindu.sct.examples.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.yakindu.sct.examples.ui.wizards.pages.AskPermissionPage;
import org.yakindu.sct.examples.ui.wizards.pages.SelectExamplePage;
import org.yakindu.sct.examples.ui.wizards.pages.UpdateRepositoryPage;

public class ExampleWizard extends Wizard implements INewWizard, ExampleWizardConstants {

	private AskPermissionPage page1;
	private UpdateRepositoryPage page2;
	private SelectExamplePage page3;
	private IStructuredSelection selection;

	public ExampleWizard() {
		super();
		setWindowTitle(WINDOW_TITLE);
		setNeedsProgressMonitor(true);

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public void addPages() {
		page1 = new AskPermissionPage(selection);
		page2 = new UpdateRepositoryPage(selection);
		page3 = new SelectExamplePage(selection);
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}

	public boolean performFinish() {
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	protected void doFinish(IProgressMonitor monitor) throws CoreException {
		page3.importSelectedExample(monitor);
		monitor.worked(1);
	}
}