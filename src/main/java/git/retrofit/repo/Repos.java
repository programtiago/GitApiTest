package git.retrofit.repo;

import git.calls.RepoCalls;
import git.mappings.generic.Repo;
import git.mappings.generic.Topics;
import git.retrofit.RetrofitBuilder;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static git.data.Common.*;

public class Repos {

    private static final RepoCalls repoCalls = new RetrofitBuilder().getRetrofit().create(RepoCalls.class);

    public static Response<ResponseBody> getRepoByOwner(String repo, String owner, String name) throws IOException {
        return repoCalls.getRepoByOwner(TOKEN, ACCEPT_HEADER, repo, owner, name).execute();
    }

    public static Response<List<Repo>> getRepoUser() throws IOException {
        return repoCalls.getRepoUser(TOKEN, ACCEPT_HEADER).execute();
    }

    public static Response<Repo> createRepo(Repo repo) throws IOException{
        return repoCalls.createRepo(TOKEN, ACCEPT_HEADER, repo).execute();
    }

    public static Response<Repo> createRepoNoAuthentication(Repo repo) throws IOException{
        return repoCalls.createRepoNoAuthentication(ACCEPT_HEADER, repo).execute();
    }

    public static Response<Repo> createRepoNoBody() throws IOException{
        return repoCalls.createRepoNoBody(TOKEN, ACCEPT_HEADER).execute();
    }

    public static Response<Repo> updateRepo(String owner, String repoName, Repo repo) throws IOException{
        return repoCalls.updateRepo(TOKEN, ACCEPT_HEADER, owner, repoName, repo).execute();
    }

    public static Response<Repo> deleteRepo(String owner, String repoName) throws IOException{
        return repoCalls.deleteRepo(TOKEN, ACCEPT_HEADER, owner, repoName).execute();
    }

    public static Response<Topics> getTopic(String owner, String repoName) throws IOException{
        return repoCalls.getTopics(ACCEPT_HEADER2, owner, repoName).execute();
    }

}
