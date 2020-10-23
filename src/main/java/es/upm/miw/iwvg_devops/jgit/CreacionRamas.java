package es.upm.miw.iwvg_devops.jgit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CreacionRamas {
    public static void Ramas() throws IOException, GitAPIException, URISyntaxException {
        for (int x = 0; x <= 5; x++) {

            switch(x){

                case 1:try {
                    String repoPath = "https://github.com/FerBoschi/Jgit-spab";
                    String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
                    Repository localRepo = new FileRepository(localPath);


                    try (Git git = Git.init().setDirectory(new File(localPath)).call()) {


                        git.checkout()
                                .setCreateBranch(true)
                                .setName("Farruco")
                                .call();

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
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                    break;

                case 2:try {
                    String repoPath = "https://github.com/FerBoschi/Jgit-spab";
                    String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
                    Repository localRepo = new FileRepository(localPath);


                    try (Git git = Git.init().setDirectory(new File(localPath)).call()) {


                        git.checkout()
                                .setCreateBranch(true)
                                .setName("Atr")
                                .call();

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
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                    break;

                case 3:try {
                    String repoPath = "https://github.com/FerBoschi/Jgit-spab";
                    String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
                    Repository localRepo = new FileRepository(localPath);


                    try (Git git = Git.init().setDirectory(new File(localPath)).call()) {


                        git.checkout()
                                .setCreateBranch(true)
                                .setName("DonaldTrump")
                                .call();

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
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                    break;

                case 4:try {
                    String repoPath = "https://github.com/FerBoschi/Jgit-spab";
                    String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
                    Repository localRepo = new FileRepository(localPath);


                    try (Git git = Git.init().setDirectory(new File(localPath)).call()) {


                        git.checkout()
                                .setCreateBranch(true)
                                .setName("MiVillanoFavorito")
                                .call();

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
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                    break;
                case 5:try {
                    String repoPath = "https://github.com/FerBoschi/Jgit-spab";
                    String localPath = "C:\\Users\\Cesar\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\spab";
                    Repository localRepo = new FileRepository(localPath);


                    try (Git git = Git.init().setDirectory(new File(localPath)).call()) {


                        git.checkout()
                                .setCreateBranch(true)
                                .setName("SeniorYSenioraSmith")
                                .call();

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
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                    break;
            }
        }
    }

}
