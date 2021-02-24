package git.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RetrofitBuilder {

    private static final String API_URL = System.getProperty("base_url", "https://api.github.com/");
    private static final Integer TIMEOUT = Integer.parseInt(System.getProperty("timeout", "30"));
    private StringBuilder logMessage = new StringBuilder();
    private Retrofit retrofit;


    public RetrofitBuilder() {
        retrofit = buildRetrofit(buildClient());
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    /**
     * @return HttpClient and logging set
     */
    protected OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(TIMEOUT, SECONDS)
                .readTimeout(TIMEOUT, SECONDS)
                .build();
    }

    /**
     * @return Retrofit with base url, converter and client set
     */
    private Retrofit buildRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }
}
