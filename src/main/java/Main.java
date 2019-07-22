import model.RecipesResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class Main {

    private final static String BASE_URL = "http://www.recipepuppy.com/api/?i=";

    public static void main(String[] args) throws IOException, URISyntaxException {

        ScannerContent scanner = new ScannerContent();
        URLBuilder urlBuilder = new URLBuilder();
        RecipeAPI recipeAPI = new RecipeAPI();
        int pageNr = 3;
        int counter =0;

        System.out.println("Witaj w aplikacji do pobierania przepisów!");

        List<Ingredient> ingredients = scanner.loadIngredientsFromUserAndAddToURL();
        String requestURL = urlBuilder.buildURL(ingredients, pageNr);

        System.out.println(requestURL);

        RecipesResponse recipesResponse = recipeAPI.loadURLByContent(requestURL);

        System.out.println(recipesResponse.printRecipeResponse());

        String answer = scanner.loadAnswersFromUser();


        do {
            if (answer.equalsIgnoreCase("tak")) {
                int recipeNr = scanner.loadRecipeNrFromUser();
                BrowseOpener browseOpener = new BrowseOpener();
                browseOpener.openBrowser(recipesResponse, recipeNr);
                break;
            }
            if (answer.equalsIgnoreCase("nie")) {
                pageNr++;
                String newRequestURL = urlBuilder.buildUpURL(requestURL, pageNr);
                System.out.println(newRequestURL);
                recipesResponse = recipeAPI.loadURLByContent(newRequestURL);
                System.out.println(recipesResponse.printRecipeResponse());
                answer = scanner.loadAnswersFromUser();

            } else if (!answer.equalsIgnoreCase("tak") || (!answer.equalsIgnoreCase("nie"))) {
                System.err.println("Nie rozumiem..");
                answer = scanner.loadAnswersFromUser();
                continue;
            }
        } while (!answer.equalsIgnoreCase("tak") || (!answer.equalsIgnoreCase("nie")));
    }
}
