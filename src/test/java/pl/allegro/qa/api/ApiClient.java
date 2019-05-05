package pl.allegro.qa.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ApiClient {
    private String token = null;
    private String authUrl;
    private String apiUrl;
    private String clientId;
    private String clientSecret;

    public OkHttpClient client = new OkHttpClient();

    public ApiClient(String authUrl, String apiUrl, String clientId, String clientSecret) throws IOException {

        this.authUrl = authUrl;
        this.apiUrl = apiUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public void obtainBearerToken() throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(authUrl).newBuilder();
        urlBuilder.addQueryParameter("grant_type", "client_credentials");
        String tokenUrl = urlBuilder.build().toString();

        String creds = Credentials.basic(clientId, clientSecret);
        Request getToken = new Request.Builder()
                .header("Authorization", creds)
                .url(tokenUrl)
                .build();

        Response tokenResponse = this.client.newCall(getToken).execute();
        JsonObject jsonToken = new JsonParser().parse(tokenResponse.body().string()).getAsJsonObject();
        this.token = jsonToken.get("access_token").getAsString();
    }

    public void refreshBearerToken() throws IOException {
        //TODO check if the token is expired and refresh if needed
    }

    public String getToken() {
        return this.token;
    }

    public String getApiUrl() {
        return this.apiUrl;
    }
}
