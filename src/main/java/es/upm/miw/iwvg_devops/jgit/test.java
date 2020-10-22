package es.upm.miw.iwvg_devops.jgit;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class test {
    private String localPath, remotePath;
    private Git git;

    //Metodo para init
    public void init() throws IOException {
        localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
        remotePath = "https://github.com/FerBoschi/Jgit-spab";
        Repository localRepo = new FileRepository(localPath + "/.git");
        git = new Git(localRepo);
    }

    //Metodo para crear repositorio
    public void createRepositorio() throws IOException {
        Repository newRepo = new FileRepository(localPath + ".git");
        newRepo.create();
    }

    //Metodo para clonar
    public void cloneRepositorio() throws IOException, GitAPIException {
        Git.cloneRepository().setURI(remotePath).setDirectory(new File(localPath)).call();
    }

    //Metodo para agregar un archivo
    public void add() throws IOException, GitAPIException {
        File myfile = new File(localPath + "/myfile");
        myfile.createNewFile();
        git.add().addFilepattern("myfile").call();
    }

    //Metodo remote irigin
    public void remote() throws URISyntaxException, GitAPIException {
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("origin");
        remoteAddCommand.setUri(new URIish(remotePath));
        remoteAddCommand.call();
    }

    //Metodo para hacer commit
    public void commit() throws IOException, GitAPIException, JGitInternalException {
        git.commit().setMessage("Added myfile").call();
    }

    //Metodo para hacer push
    public void push() throws IOException, JGitInternalException, GitAPIException {
        git.push().call();
    }

    public void pushDos() {
        try {
            git.push().setRemote("origin").add("master").call();
        } catch (
                GitAPIException e) {
            // Add your own logic here, for example:
            System.out.println("Username or password incorrect.");
        }

    }

    //Track origin/master a master (esto es necesario si la clonación de un desnudo de repo)
    public void trackMaster() throws IOException, JGitInternalException, GitAPIException {
        git.branchCreate().setName("master").setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.SET_UPSTREAM).setStartPoint("origin/master").setForce(true).call();
    }

    //Metodo para hacer pull
    public void pull() throws IOException, GitAPIException {
        git.pull().call();
    }

    public void checkout() throws IOException, GitAPIException {
        git.checkout()
                .setCreateBranch(true)
                .setName("Entidades")
                .call();
    }
}