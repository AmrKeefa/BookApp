package com.example.bookapp.models;

public class Book {


    private String title;

    private String publisher;

    private String description;

    private String publishedDate;

    private String infoLink;

public Book(String title, String publisher, String description, String publishedDate,String infoLink){
    this.title = title;
    this.publisher = publisher;
    this.description = description;
    this.publishedDate = publishedDate;
    this.infoLink = infoLink;
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
public String getInfoLink(){
    return infoLink;

}


}

