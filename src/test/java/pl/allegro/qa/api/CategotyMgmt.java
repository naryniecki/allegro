package pl.allegro.qa.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CategotyMgmt {
    private ApiClient apiClient;
    private static final String CATEGORIES_END_POINT = "sale/categories";

    /**
     * Constructor for an Object to work with categories.
     * @param apiClient has token and needed URLs.
     */
    public CategotyMgmt(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get categories.
     * @return List of available categories.
     * @throws IOException
     */
    public Map<String, String> getMainCategories() throws IOException {

        Map<String, String> cats = new HashMap<String, String>();

        Request getCategories = new Request.Builder()
                .header("Authorization", "Bearer " + apiClient.getToken())
                .header("Accept", "application/vnd.allegro.public.v1+json")
                .url(apiClient.getApiUrl() + CATEGORIES_END_POINT)
                .build();

        Response categotiesResponse = apiClient.client.newCall(getCategories).execute();
        if (categotiesResponse.code() != 200)
            throw new IOException("Unexpected response code, expecinn 200, got: " + categotiesResponse.toString());
        JsonObject jsonCategories = new JsonParser().parse(categotiesResponse.body().string()).getAsJsonObject();
        JsonArray categories = jsonCategories.getAsJsonArray("categories");
        for (JsonElement category : categories) {
            JsonObject categoryObject = category.getAsJsonObject();
            cats.put(categoryObject.get("name").getAsString(), categoryObject.get("id").getAsString());
        }

        return cats;
    }
}
