package es.upm.miw.iwvg_devops.jgit;

import org.eclipse.jgit.api.AddCommand;
        import org.eclipse.jgit.api.Git;
        import org.eclipse.jgit.api.PushCommand;
        import org.eclipse.jgit.api.RemoteAddCommand;
        import org.eclipse.jgit.api.errors.GitAPIException;
        import org.eclipse.jgit.api.errors.TransportException;
        import org.eclipse.jgit.internal.storage.file.FileRepository;
        import org.eclipse.jgit.lib.Repository;
        import org.eclipse.jgit.transport.URIish;
        import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

        import java.io.File;
        import java.io.IOException;
        import java.net.URISyntaxException;

        import static es.upm.miw.iwvg_devops.jgit.CreacionRamas.Ramas;
public class jgit {
    public static void main(String[] args) throws IOException, GitAPIException, URISyntaxException {

        try{
            String repoPath = "https://github.com/FerBoschi/Jgit-spab";
            String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
            Repository localRepo = new FileRepository(localPath);
            int i=0;

            try (Git git = Git.init().setDirectory(new File(localPath)).call()){

                AddCommand add = git.add();
                add.addFilepattern(".").call();
                git.commit().setMessage("Added Persona").call();

                // agregar al repositorio remoto
                RemoteAddCommand remoteAddCommand = git.remoteAdd();
                remoteAddCommand.setName("origin");
                remoteAddCommand.setUri(new URIish(repoPath));

                // Podemos agregar mas configuraciones si es necesario aca
                remoteAddCommand.call();

                // hacer push al remoto:
                PushCommand push = git.push();
                push.setCredentialsProvider(new UsernamePasswordCredentialsProvider("USER", "CONTRA"));

                // podemos agregar mas configuraciones aca si es necesario
                push.call();

                //RealizaLaCreacionDeLasRamas
                Ramas();
            }



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
