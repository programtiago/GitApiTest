package git;

import git.mappings.generic.Repo;
import git.retrofit.repo.Repos;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

import static git.validators.ResponseValidator.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class updateTest {

    @BeforeMethod
    public void createRepo() throws IOException {

        Repo repo = new Repo();
        repo.setName("TQS");
        repo.setDescription("Projeto full stack desenvolvido por Gabriel e Tiago");
        repo.setId(30);
        Response<Repo> response = Repos.createRepo(repo);
        assertCreated(response);
    }

    @Test(description = "Update a repository with authentication")
    public void updateRepo() throws IOException{

        Repo repo = new Repo();

        repo.setName("TesteUpdate");
        String owner = "GitTestApi2021";
        String nameRepo = "TQS";

        Response<Repo> response = Repos.updateRepo(owner, nameRepo, repo);
        assertOk(response);
    }

    @AfterMethod
    public void deleteRepo() throws IOException{

        Repo repo = new Repo();
        String owner = "GitTestApi2021";
        String nameRepo = "TesteUpdate";

        Response<Repo> response = Repos.deleteRepo(owner, nameRepo);
        assertNoContent(response);

    }
}
