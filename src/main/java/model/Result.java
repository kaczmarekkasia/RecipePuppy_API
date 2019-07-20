package model;

import lombok.Data;

@Data

public class Result {
    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;


    public String printResult() {
        return title;
    }
}
