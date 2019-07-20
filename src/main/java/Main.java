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
        int pageNr = 3;


        System.out.println("Witaj w aplikacji do pobierania przepisów!");

        List<Ingredient> ingredients = scanner.loadIngredientsFromUserAndAddToURL();
        String requestURL = urlBuilder.buildURL(ingredients, pageNr);

        System.out.println(requestURL);

        RecipesResponse recipesResponse = recipeAPI.loadURLByContent(requestURL);

        System.out.println(recipesResponse.printRecipeResponse());

        String answer = scanner.loadAnswersFromUser();

        if (answer.equalsIgnoreCase("tak")){
        }
        if (answer.equalsIgnoreCase("nie")){
            String newRequestURL= urlBuilder.buildUpURL(requestURL, pageNr+1);
            System.out.println(recipeAPI.loadURLByContent(newRequestURL).printRecipeResponse());

        }
        else {
            System.out.println("nie rozumiem");
        }


    }


}
