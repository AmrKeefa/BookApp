package com.example.bookapp.models;

public class Book {


    private String title;

    private String publisher;

    private String description;

    private String publishedDate;

public Book(String title, String publisher, String description, String publishedDate){
    this.title = title;
    this.publisher = publisher;
    this.description = description;
    this.publishedDate = publishedDate;
}


public String getTitle(){
    return title;
}

public String getPublisher(){
    return publisher;
}


public String getDescription(){
    return description;
}

public String getPublishedDate(){
    return publishedDate;
}


}

