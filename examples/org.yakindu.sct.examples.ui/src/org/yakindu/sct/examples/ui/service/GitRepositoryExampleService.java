package org.yakindu.sct.examples.ui.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.transport.FetchResult;
import org.yakindu.sct.examples.ui.wizards.ExampleWizardConstants;

public class GitRepositoryExampleService implements ExampleWizardConstants {

	public static boolean updateExampleRepository(GitProgressMonitor monitor) {
		try {
			System.out.println(InetAddress.getByName("github.com").getHostName() + "is Reachable.");
			for(int i=0;i<REMOTE_REPOS.length;i++) {
				if(!updateExampleRepository(REMOTE_REPOS[i],monitor)) {
					return false;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("resource")
	protected static boolean updateExampleRepository(String remoteRepo,ProgressMonitor monitor) {
			try {
				File localRepo = new File(LOCAL_REPO_ROOT.getAbsolutePath() + System.getProperty("file.separator") + remoteRepo.substring(remoteRepo.lastIndexOf("/"), remoteRepo.indexOf(".git")));
				if(localRepo.exists()) {
					Repository repository = new RepositoryBuilder().setGitDir(localRepo).readEnvironment().findGitDir().build();
					Git git = new Git(repository);
					FetchResult result = git.fetch().setRemote(remoteRepo).setProgressMonitor(monitor).setCheckFetchedObjects(true).call();
					System.out.println("Result: " + result);
				} else {
					Git.cloneRepository().setURI(remoteRepo).setDirectory(localRepo).setProgressMonitor(monitor).call();
				}
			} catch (InvalidRemoteException e) {
				e.printStackTrace();
				return false;
			} catch (TransportException e) {
				e.printStackTrace();
				return false;
			} catch (GitAPIException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
			}
		return true;
	}
}