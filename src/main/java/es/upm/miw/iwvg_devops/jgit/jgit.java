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

public class jgit {

    public static void main(String[] args) throws IOException, GitAPIException, URISyntaxException {

        try{
            String httpUrl = "https://github.com/FerBoschi/Jgit-spab";
            String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
            Repository localRepo = new FileRepository(localPath);
            try (Git git = Git.open(new File(localPath))) {

                AddCommand add = git.add();
                add.addFilepattern(".").call();
                git.commit().setMessage("Added myfile").call();


                // agregar al repositorio remoto
                RemoteAddCommand remoteAddCommand = git.remoteAdd();
                remoteAddCommand.setName("origin");
                remoteAddCommand.setUri(new URIish(httpUrl));

                // Podemos agregar mas configuraciones si es necesario aca
                remoteAddCommand.call();

                // hacer push al remoto:
                PushCommand pushCommand = git.push();
                pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("poner usuario de github", "poner contraseña"));
                // podemos agregar mas configuraciones aca si es necesario
                pushCommand.call();
            }


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
