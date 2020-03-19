package com.example.bookapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("volumeInfo")
    @Expose
    private Book book;

    public Book getBook() {
        return book;
    }

    public Items(Book book) {
        this.book = book;
    }
}
