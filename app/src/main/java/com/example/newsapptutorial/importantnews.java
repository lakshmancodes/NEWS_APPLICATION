package com.example.newsapptutorial;
import java.util.ArrayList;
//code for fetching main array from the authentication in NEWSAPI
public class importantnews {
    public String status;
    private String totalResults;
    private ArrayList<ModelClass> articles;
    //constructors
    public importantnews(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
    //getter and setter methods
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
