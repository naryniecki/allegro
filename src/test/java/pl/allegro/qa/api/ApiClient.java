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

    /**
     * Construct for a REST API client
     * @param authUrl URL to obtain token.
     * @param apiUrl URL to interact with the API.
     * @param clientId Client ID for a registered application.
     * @param clientSecret Client secret for an application.
     * @throws IOException
     */
    public ApiClient(String authUrl, String apiUrl, String clientId, String clientSecret) throws IOException {

        this.authUrl = authUrl;
        this.apiUrl = apiUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Get a authentication token using client id and client secret.
     * @throws IOException
     */

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

    /**
     * Refresh token if the current one is about to expire.
     * @throws IOException
     */
    public void refreshBearerToken() throws IOException {
        //TODO implement
    }

    /**
     * Getter for authentication token to be used for other calls.
     * @return Bearer token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Getter for the API URL, used for following calls.
     * @return
     */
    public String getApiUrl() {
        return this.apiUrl;
    }
}
