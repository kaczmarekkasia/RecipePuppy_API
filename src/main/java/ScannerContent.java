import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerContent {

    private Scanner scanner = new Scanner(System.in);
    URLBuilder urlBuilder = new URLBuilder();

    public List<Ingredient> loadIngredientsFromUserAndAddToURL() {

        String line = null;
        String line2 = null;
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        System.out.println("Podaj składniki na intersujący Cię przepis. Aby zakończyć wpisz koniec:");

        do {
            System.out.println("składnik:");
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("koniec")) {
                   System.out.println("Czy skończyłeś wpisywać składniki?");
                   line2 = scanner.nextLine();
                   if (line2.equalsIgnoreCase("tak")) {
                       break;
                   }
                   if (line2.equalsIgnoreCase("nie")) {
                       line = "";
                       continue;
                   }
                   if (!line2.equalsIgnoreCase("tak") || (!line2.equalsIgnoreCase("nie"))){
                       System.out.println("nie rozumiem...");
                       line = "";
                       continue;
                   }

            }
            if (!line.equalsIgnoreCase("koniec")) {
                Ingredient ingredient = new Ingredient(line);
                ingredients.add(ingredient);
            }
        } while (!line.equalsIgnoreCase("koniec"));
        System.out.println("Szukam przepisów...");

        return ingredients;
    }

    public String loadAnswersFromUser() {
        System.out.println("Czy widzisz przepis który Cię interesuje?");
        return scanner.nextLine();
    }

    public int loadRecipeNrFromUser() {
        System.out.println("Który przepis Cię interesuje?");
        String currentNr = scanner.nextLine();
        return Integer.parseInt(currentNr);
    }

}
