import com.google.gson.Gson;
import model.RecipesResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String BASE_URL = "http://www.recipepuppy.com/api/?i=";

    public static void main(String[] args) {

        ScannerContent scanner = new ScannerContent();
        URLBuilder urlBuilder = new URLBuilder();
        RecipeAPI recipeAPI = new RecipeAPI();
        StringBuilder builder = new StringBuilder();


        System.out.println("Witaj w aplikacji do pobierania przepisów!");

        List<Ingredient> ingredients = scanner.loadIngredientsFromUserAndAddToURL();
        String requestURL = urlBuilder.buildURL(ingredients, 3);

        RecipesResponse recipesResponse = recipeAPI.loadURLByContent(requestURL);

        System.out.println(recipesResponse.printRecipeResponse());



    }


}
