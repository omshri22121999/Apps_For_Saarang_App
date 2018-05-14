package com.example.omshri.newsapp.Objects;

import java.util.List;

public class NewsList {
    String status;
    Integer totalResults;
    List<ArticlesClass> articles;
    public String getsourceID(int position){
        return articles.get(position).source.id;
    }
    public String getsourceName(int position){
        return articles.get(position).source.name;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public String getauthor(int position) {
        return articles.get(position).author;
    }
    public String gettitle(int position) {
        return articles.get(position).title;
    }
    public String getdescription(int position) {
        return articles.get(position).description;
    }
    public String geturl(int position) {
        return articles.get(position).url;
    }
    public String geturltoimage(int position) {
        return articles.get(position).urlToImage;
    }
    public String getpublishedat(int position) {
        return articles.get(position).publishedAt;
    }

}
