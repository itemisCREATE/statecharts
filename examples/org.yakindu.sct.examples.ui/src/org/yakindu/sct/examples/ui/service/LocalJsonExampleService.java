package org.yakindu.sct.examples.ui.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardConstants;

import com.google.gson.Gson;

public class LocalJsonExampleService implements IExampleService, ExampleWizardConstants {

	@Override
	public List<ExampleData> getAllExamples() {
		List<File> projects = searchMetaInRoot();
		List<ExampleData> result = readJsonData(projects);
		result = sortList(result);
		return result;
	}

	protected List<File> searchMetaInRoot() {
		List<File> result = new ArrayList<File>();
		for (File repo : LOCAL_REPO_ROOT.listFiles()) {
			for (File file : repo.listFiles()) {
				File meta = new File(file.getAbsolutePath() + System.getProperty("file.separator") + "metadata.json");
				if (meta.exists()) {
					result.add(meta);
				}
			}
		}
		return result;
	}

	protected List<ExampleData> readJsonData(List<File> projects) {
		List<ExampleData> result = new ArrayList<ExampleData>();
		Iterator<File> ifi = projects.iterator();
		Gson gson = new Gson();
		while (ifi.hasNext()) {
			try {
				File file = ifi.next();
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String json = "", s = "";
				while ((s = reader.readLine()) != null) {
					json += s;
				}
				reader.close();
				ExampleData ed = gson.fromJson(json, ExampleData.class);
				ed.setProjectDir(file.getParentFile());
				result.add(ed);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	protected List<ExampleData> sortList(List<ExampleData> result) {
		List<String> domains = new ArrayList<String>();
		for (int i = 0; i < result.size(); i++) {
			if (!domains.contains(result.get(i).getDomain())) {
				domains.add(result.get(i).getDomain());
			}
		}
		ExampleData[] root = new ExampleData[domains.size()];
		for (int i = 0; i < root.length; i++) {
			root[i] = new ExampleData(null, null, domains.get(i));
		}
		for (int d = 0; d < root.length; d++) {
			int size = 0;
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getDomain().equals(root[d].getTitle())) {
					result.get(i).setParent(root[d]);
					size++;
				}
			}
			ExampleData[] children = new ExampleData[size];
			for (int i = 0, c = 0; i < result.size(); i++) {
				if (result.get(i).getParent() == root[d]) {
					children[c] = result.get(i);
					c++;
				}
			}
			root[d].setChildren(children);
			result.add(root[d]);
		}
		return result;

	}

	@Override
	public void importSelectedExample(ExampleData edata, IProgressMonitor monitor) {

		try {
			IProjectDescription pDescription = ResourcesPlugin.getWorkspace()
					.loadProjectDescription(new Path(edata.getProjectDir().getAbsolutePath()).append("/.project"));
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(edata.getProjectDir().getName());
			project.create(pDescription, monitor);
			List<File> filesToImport = findProjectFiles(edata.getProjectDir());
			ImportOperation io = new ImportOperation(project.getFullPath(), edata.getProjectDir(),
					FileSystemStructureProvider.INSTANCE, new IOverwriteQuery() {

						@Override
						public String queryOverwrite(String pathString) {
							return IOverwriteQuery.ALL;
						}

					}, filesToImport);
			io.run(monitor);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected List<File> findProjectFiles(File file) {
		List<File> result = new ArrayList<File>();
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				result.addAll(findProjectFiles(f));
			}
			result.add(f);
		}
		return result;
	}
}
