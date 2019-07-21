package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Result {
    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;


    public String printResult() {
        return title;
    }
}
