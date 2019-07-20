import com.google.gson.Gson;
import model.RecipesResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RecipeAPI {

    private final static Gson GSON = new Gson();


    public RecipesResponse loadURLByContent(String requestURL) {

        Gson GSON = new Gson();
        RecipesResponse recipesResponse = new RecipesResponse();

        try {
            URL url = new URL(requestURL);
            recipesResponse = GSON.fromJson(new InputStreamReader(url.openStream()), RecipesResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return recipesResponse;
    }

}
