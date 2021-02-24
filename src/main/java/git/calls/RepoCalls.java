package git.calls;

import git.mappings.generic.Repo;
import git.mappings.generic.Topics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static git.data.Common.ACCEPT;
import static git.data.Common.AUTHORIZATION;


public interface RepoCalls {

    String USER_REPOS = "/user/repos";
    String REPO = "/repos/{owner}/{repo}";
    String OWNER = "owner";
    String NAMEREPO = "repo";
    String TOPIC = "repos/{owner}/{repo}/topics";


    @GET(REPO)
    Call<ResponseBody> getRepoByOwner(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader, @Path(REPO) String repo, @Path(OWNER) String owner, @Path(NAMEREPO) String nameRepo);

    @GET(USER_REPOS)
    Call<List<Repo>> getRepoUser(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader);

    @POST(USER_REPOS)
    Call<Repo> createRepo(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader, @Body Repo repo);

    @POST(USER_REPOS)
    Call<Repo> createRepoNoAuthentication(@Header(ACCEPT) String acceptHeader, @Body Repo repo);

    @POST(USER_REPOS)
    Call<Repo> createRepoNoBody(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader);

    @PATCH(REPO)
    Call<Repo> updateRepo(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader, @Path(OWNER) String owner, @Path(NAMEREPO) String name,  @Body Repo repo);

    @DELETE(REPO)
    Call<Repo> deleteRepo(@Header(AUTHORIZATION) String token, @Header(ACCEPT) String acceptHeader, @Path(OWNER) String owner, @Path(NAMEREPO) String name);

    @GET(TOPIC)
    Call<Topics> getTopics(@Header(ACCEPT) String acceptHeader, @Path(OWNER) String owner, @Path(NAMEREPO) String name);

}
