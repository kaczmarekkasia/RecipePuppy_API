import model.RecipesResponse;
import model.Result;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowseOpener {

    public void openBrowser(RecipesResponse recipesResponse, int recipeNr) throws URISyntaxException, IOException {
        try {
            Result currentResult = recipesResponse.getResults().get(recipeNr - 1);
            //do podejrzenia sam link
            System.out.println(currentResult.getHref());

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(currentResult.getHref()));
            }
        } catch (IndexOutOfBoundsException i) {
            System.err.println("Nie ma przepisu o takim numerze...");
        }
    }
}
