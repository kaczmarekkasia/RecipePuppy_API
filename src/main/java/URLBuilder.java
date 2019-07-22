import java.util.ArrayList;
import java.util.List;

public class URLBuilder {
    private final static String BASE_URL = "http://www.recipepuppy.com/api/?i=";

    private StringBuilder builder;


    public URLBuilder() {

        builder = new StringBuilder(BASE_URL);
    }

    public String buildURL(List<Ingredient> ingredients, int pageNr) {
        for (int i = 0; i < ingredients.size(); i++) {
            builder.append(ingredients.get(i).ingredientsToString());
        }
        builder.append("&p=" + pageNr);

        System.out.println("Twoje przepisy to:");
        return builder.toString();
    }

    public String buildUpURL(String requiredURL, int pageNr){
        String newRequiredURL = requiredURL.substring(0, requiredURL.length()-1);
        builder = new StringBuilder(newRequiredURL);
        builder.append(pageNr);
        return builder.toString();
    }
}
