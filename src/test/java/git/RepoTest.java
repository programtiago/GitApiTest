package git;


import git.calls.RepoCalls;
import git.mappings.generic.Repo;
import git.mappings.generic.Topics;
import git.retrofit.repo.Repos;
import okhttp3.ResponseBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;

import git.mappings.generic.Owner;
import git.mappings.generic.Permissions;

import java.io.IOException;
import java.util.List;

import static git.validators.ResponseValidator.assertCreated;
import static git.validators.ResponseValidator.assertOk;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RepoTest {

    @Test(description = "visualizar repositórios do owner com autenticação")
    public void getRepo() throws IOException {
        Response<List<Repo>> response = Repos.getRepoUser();
        assertOk(response);
        assertThat("x", response.body().get(0).getId(), is(331434863));
    }

    @Test(description = "Creates a new repository for the authenticated user")
    public void createRepo() throws IOException{

        Repo repo = new Repo();
        Owner owner = new Owner();
        repo.setName("C#");
        repo.setFull_name("Django é fantástico !");
        owner.setLogin("GitApiTest2021");
        repo.setDescription("Projeto full stack desenvolvido por Gabriel e Tiago");
        repo.setId(30);
        Response<Repo> response = Repos.createRepo(repo);
        assertCreated(response);
        assertThat(String.format("Name of the repo should be %s", repo.getName()), repo.getName(), is("C#"));
        assertThat(String.format("Full name of the repo should be %s", repo.getFull_name()), repo.getFull_name(), is("Django é fantástico !"));
        assertThat(String.format("Login of the owner of the repo should be %s", owner.getLogin()), owner.getLogin(), is("GitApiTest2021"));
        assertThat(String.format("Repo description should be %s", repo.getDescription()), repo.getDescription(), is("Projeto full stack desenvolvido por Gabriel e Tiago"));
        assertThat(String.format("Id of the repo should be %d", repo.getId()), repo.getId(), is(30));
    }

    @Test(description = "Get all repository topics")
    public void getTopics() throws IOException{
        Response<Topics> response = Repos.getTopic("GitApiTest2021", "Python");
        assertOk(response);

    }


}
