package model;

import lombok.Data;

import java.util.List;

@Data

public class RecipesResponse {
    private String title;
    private double version;
    private String href;
    private List<Result> results;

    public String printRecipeResponse(){

        final int[] sign = new int[]{1};
        StringBuilder recipeList = new StringBuilder();

        results.forEach(r -> recipeList.append((sign[0]++) + ". " + r.printResult()+"\n"));

        return recipeList.toString();
    }
}
