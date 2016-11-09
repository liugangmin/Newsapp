package com.example.a38633.newsapp.bean;

import java.util.List;

/**
 * Created by 38633 on 2016/11/6.
 */

public class Gameaa {
    private boolean isError;
    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
    private List<GameData> results;
    public void setResults(List<GameData> results) {
        this.results = results;
    }
    public List<GameData> getResults() {
        return results;
    }
}
