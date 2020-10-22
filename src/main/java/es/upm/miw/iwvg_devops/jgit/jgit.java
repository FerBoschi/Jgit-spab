package es.upm.miw.iwvg_devops.jgit;


import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class jgit {

    private String localPath, remotePath;
    private Git git;
    public static void main(String[] args) throws IOException, GitAPIException, URISyntaxException {
    }
        public void checkout() throws IOException, NoFilepatternException, GitAPIException {
        git.checkout()
                .setCreateBranch(true)
                .setName("Entidades")
                .call();
    }
}
