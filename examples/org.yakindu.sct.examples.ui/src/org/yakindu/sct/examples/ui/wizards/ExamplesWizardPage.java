package org.yakindu.sct.examples.ui.wizards;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.examples.ui.service.IExampleService;
import org.yakindu.sct.examples.ui.service.IExampleService.ExampleData;
import org.yakindu.sct.examples.ui.service.MockExampleService;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleContentProvider;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleLabelProvider;

public class ExamplesWizardPage extends WizardPage {

	public static final String WIZARD_TITLE = "Select an example";
	public static final String WIZARD_DESCRIPTION = "This wizard provides serveral example projects created in Yakindu Statecharts";
	public static final String DEFAULT_PROJECT_TITLE = "Example title";
	public static final String DEFAULT_PROJECT_DESCRIPTION = "Example discription";
	public static final Path FILEICON = new Path("icons/logo-16.png");
	public static final Path FOLDERICON = new Path("icons/logo-16.png");

	private IExampleService exampleService = new MockExampleService();
	private TreeViewer viewer;
	private Label title, description;
	private ExampleData lastValidSelection;

	public ExamplesWizardPage(ISelection selection) {
		super(WIZARD_TITLE);
		setTitle(WIZARD_TITLE);
		setDescription(WIZARD_DESCRIPTION);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout(2, true);
		container.setLayout(layout);
		createTreeViewer(container);
		createDetailsPane(container);
		setControl(container);
	}

	protected void createTreeViewer(Composite container) {
		viewer = new TreeViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		viewer.setContentProvider(new ExampleContentProvider());
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
				new ExampleLabelProvider(createImageDescriptor(FILEICON), createImageDescriptor(FOLDERICON))));
		viewer.setInput(exampleService.getAllExamples());
		viewer.expandToLevel(2);
		;
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent e) {
				Object select = ((IStructuredSelection) e.getSelection()).getFirstElement();
				viewer.setExpandedState(select, !viewer.getExpandedState(select));
				adjustTreeViewer(select);
			}
		});
		Tree tree = (Tree) viewer.getControl();
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				adjustTreeViewer(((TreeItem) e.item).getData());
			}
		});
	}

	protected ImageDescriptor createImageDescriptor(Path path) {
		Bundle bundle = FrameworkUtil.getBundle(ExampleLabelProvider.class);
		URL url = FileLocator.find(bundle, path, null);
		return ImageDescriptor.createFromURL(url);
	}

	protected void adjustTreeViewer(Object selectedNode) {
		ExampleData selectedEData = (ExampleData) selectedNode;
		if (!selectedEData.hasChildren()) {
			lastValidSelection = selectedEData;
			title.setText(lastValidSelection.getTitle());
			description.setText(lastValidSelection.getDescription());
			setPageComplete(true);
		}
		viewer.refresh();
	}

	protected void createDetailsPane(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		// TODO: Show Image
		title = new Label(container, SWT.NONE);
		title.setText(DEFAULT_PROJECT_TITLE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(title);
		description = new Label(container, SWT.H_SCROLL);
		description.setText(DEFAULT_PROJECT_DESCRIPTION);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(description);
	}
}