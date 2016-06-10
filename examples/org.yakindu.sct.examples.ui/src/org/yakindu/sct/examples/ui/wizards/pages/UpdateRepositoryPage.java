package org.yakindu.sct.examples.ui.wizards.pages;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.examples.ui.service.GitProgressMonitor;
import org.yakindu.sct.examples.ui.service.GitRepositoryExampleService;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardConstants;

public class UpdateRepositoryPage extends WizardPage implements ExampleWizardConstants {
	
	private boolean gitError = false;
	
	public UpdateRepositoryPage(ISelection selection) {
		super(UPDATE_PAGE_TITLE);
		setTitle(UPDATE_PAGE_TITLE);
		setDescription(UPDATE_PAGE_DESCRIPTION);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent,SWT.NONE);
		FillLayout layout = new FillLayout();
		layout.type = SWT.VERTICAL;
		container.setLayout(layout);
		setControl(container);
		setPageChangeListener();
	}
	
	protected void setPageChangeListener() {
		if(getContainer() instanceof IPageChangeProvider) {
			IPageChangeProvider provider = (IPageChangeProvider) getContainer();
			provider.addPageChangedListener(new IPageChangedListener() {
				
				@Override
				public void pageChanged(PageChangedEvent event) {
					if(event.getSelectedPage().equals(UpdateRepositoryPage.this)) {
						updateExampleRepository();
					}
				}
			});
		}
	}
	
	protected void updateExampleRepository() {
		try {
			getWizard().getContainer().run(true, false, new IRunnableWithProgress() {
				
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					UpdateRepositoryPage.this.gitError = !GitRepositoryExampleService.updateExampleRepository(monitor);
					monitor.done();
				}
			});
			if(gitError) {
				setErrorMessage(WIZARD_ERROR_GIT);
			} else {
				setPageComplete(true);
			}
			setPageComplete(true);
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
