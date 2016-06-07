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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.examples.ui.service.IExampleService;
import org.yakindu.sct.examples.ui.service.IExampleService.ExampleData;
import org.yakindu.sct.examples.ui.service.LocalJsonExampleService;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleContentProvider;
import org.yakindu.sct.examples.ui.wizards.provider.ExampleLabelProvider;

public class ExamplesWizardPage extends WizardPage {

	public static final String WIZARD_TITLE = "Select an example";
	public static final String WIZARD_DESCRIPTION = "This wizard provides serveral example projects created in Yakindu Statecharts";
	public static final String DEFAULT_PROJECT_TITLE = "Example title";
	public static final String DEFAULT_PROJECT_DESCRIPTION = "Example discription";
	public static final Path FILEICON = new Path("icons/logo-16.png");
	public static final Path FOLDERICON = new Path("icons/logo-16.png");

	private IExampleService exampleService = new LocalJsonExampleService();
	private TreeViewer viewer;
	private Label title, description, canvas;
	private Button btLeft,btRight;
	private ExampleData lastValidSelection;
	private int urlnr;

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
		if (!selectedEData.hasChildren() && selectedEData != lastValidSelection) {
			lastValidSelection = selectedEData;
			title.setText(lastValidSelection.getTitle());
			description.setText(lastValidSelection.getDescription());
			if(lastValidSelection.getImages().length == 0) {
				urlnr = -1;
			} else {
				urlnr = 0;
			}
			setImage(urlnr);
			setPageComplete(true);
		}
		viewer.refresh();
	}
	
	protected void setImage(int urlnr) {
		if(urlnr >= 0) {
			Image image = ImageDescriptor.createFromURL(lastValidSelection.getImages()[urlnr]).createImage();
			Rectangle rCanvas = canvas.getBounds();
			Rectangle rImage = image.getBounds();
			double aspectRatio = rImage.width * 1.0 / rImage.height;
			Rectangle newBounds = new Rectangle(0,0,(int)Math.round(rCanvas.height*aspectRatio),rCanvas.height);
			if(newBounds.width>rCanvas.width) {
				newBounds.width = rCanvas.width;
				newBounds.height = (int) Math.round(rCanvas.width / aspectRatio); 
			}
			if(urlnr == 0) {
				btLeft.setEnabled(false);
				btRight.setEnabled(true);
			}
			canvas.setImage(ImageDescriptor.createFromImageData(image.getImageData().scaledTo(newBounds.width, newBounds.height)).createImage());
		} else {
			canvas.setImage(null);
			btLeft.setEnabled(false);
			btRight.setEnabled(false);
		}
	}

	protected void createDetailsPane(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		canvas = new Label(container, SWT.NONE);
		createSlideshowButtons(container);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(canvas);
		title = new Label(container, SWT.NONE);
		title.setText(DEFAULT_PROJECT_TITLE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(title);
		description = new Label(container, SWT.H_SCROLL);
		description.setText(DEFAULT_PROJECT_DESCRIPTION);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(description);
	}
	
	protected void createSlideshowButtons(Composite parent) {
		Composite container = new Composite(parent,SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(container);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		btLeft = new Button(container,SWT.NONE);
		btRight = new Button(container,SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(btLeft);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(btRight);
		btLeft.setEnabled(false);
		btRight.setEnabled(false);
		btLeft.setText("<");
		btRight.setText(">");
		btLeft.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doButtonClick((Button) e.getSource());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		btRight.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doButtonClick((Button) e.getSource());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}
	
	protected void doButtonClick(Button bt) {
		if(lastValidSelection != null) {
			if(bt == btLeft) {
				if(urlnr > 0) {
					setImage(--urlnr);
					btRight.setEnabled(true);
					if(urlnr == 0) {
						btLeft.setEnabled(false);
					}
				}
			} else if(bt == btRight) {
				if(urlnr < lastValidSelection.getImages().length-1) {
					setImage(++urlnr);
					btLeft.setEnabled(true);
					if(urlnr == lastValidSelection.getImages().length-1) {
						btRight.setEnabled(false);
					}
				}
			}
		}
	}
}