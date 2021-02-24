package git;

import git.mappings.generic.Repo;
import git.retrofit.repo.Repos;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

import static git.validators.ResponseValidator.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class NegativeTests {

   @Test(description = "Tenta criar repositório sem autenticação")
    public void createRepoNoAuthentication() throws IOException {

        Repo repo = new Repo();
        repo.setName("Qualidade de Software");
        repo.setDescription("Testar a API do GIT");
        repo.setId(100);
        Response<Repo> response = Repos.createRepoNoAuthentication(repo);
        assertUnauthorized(response);
    }

    @Test(description = "Tenta fazer update a um repositório que não existe")
    public void updateRepoNotExists() throws IOException{

        Repo repo = new Repo();

        repo.setName("TesteUpdate");
        String owner = "GitTestApi2021";
        String nameRepo = "123";

        Response<Repo> response = Repos.updateRepo(owner, nameRepo, repo);
        assertNotFound(response);
    }

    @Test(description = "Tenta eliminar um repositório que não existe")
    public void deleteRepoNotExists() throws IOException{

        Repo repo = new Repo();
        String owner = "GitTestApi2021";
        String nameRepo = "Não existe";

        Response<Repo> response = Repos.deleteRepo(owner, nameRepo);
        assertNotFound(response);
    }

    @Test(description = "Criar repositório sem dar informação")
    public void createRepoNoBody() throws IOException{

        String owner = "GitTestApi2021";
        String nameRepo = "Java POO";

        Response<Repo> response = Repos.createRepoNoBody();
        assertBadRequest(response);

    }



}
