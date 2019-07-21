import com.google.gson.Gson;
import model.RecipesResponse;
import model.Result;

import java.awt.*;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String BASE_URL = "http://www.recipepuppy.com/api/?i=";

    public static void main(String[] args) throws IOException, URISyntaxException {

        ScannerContent scanner = new ScannerContent();
        URLBuilder urlBuilder = new URLBuilder();
        RecipeAPI recipeAPI = new RecipeAPI();
        StringBuilder builder = new StringBuilder();
        int pageNr = 3;

        Scanner scanner1 = new Scanner(System.in);


        System.out.println("Witaj w aplikacji do pobierania przepisów!");

        List<Ingredient> ingredients = scanner.loadIngredientsFromUserAndAddToURL();
        String requestURL = urlBuilder.buildURL(ingredients, pageNr);

        System.out.println(requestURL);

        RecipesResponse recipesResponse = recipeAPI.loadURLByContent(requestURL);

        System.out.println(recipesResponse.printRecipeResponse());

        String answer = scanner.loadAnswersFromUser();


        do {
            if (answer.equalsIgnoreCase("tak")) {
                System.out.println("Który przepis Cię interesuje?");
                String currentNr = scanner1.nextLine();
                int recipeNr = Integer.parseInt(currentNr);

                try {
                    Result currentResult = recipesResponse.getResults().get(recipeNr - 1);

                    //do podejrzenia sam link
                    System.out.println(currentResult.getHref());

                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new URI(currentResult.getHref()));
                    }
                    break;
                } catch (IndexOutOfBoundsException i){
                    System.err.println("Nie ma przepisu o takim numerze...");
                }
            }


            if (answer.equalsIgnoreCase("nie")) {
                String newRequestURL = urlBuilder.buildUpURL(requestURL, pageNr + 1);
                System.out.println(recipeAPI.loadURLByContent(newRequestURL).printRecipeResponse());
                break;

            }
            if (!answer.equalsIgnoreCase("tak") || (!answer.equalsIgnoreCase("nie"))) {
                System.err.println("Nie rozumiem..");
                answer = scanner.loadAnswersFromUser();
                continue;
            }

        } while (!answer.equalsIgnoreCase("tak") || (!answer.equalsIgnoreCase("nie")));


    }


}
