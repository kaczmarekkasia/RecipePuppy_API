import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {

    private String name;

    public String ingredientsToString(){
        return name + ",";
    }

}
