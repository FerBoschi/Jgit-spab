package es.upm.miw.iwvg_devops.jgit;


import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class jgit {
    FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
    Repository repository = repositoryBuilder.setGitDir(new File("/path/to/repo/.git"))
            .readEnvironment() // scan environment GIT_* variables
            .findGitDir() // scan up the file system tree
            .setMustExist(true)
            .build();

    public jgit() throws IOException {
    }
}
