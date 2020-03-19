package com.example.bookapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MainObject {

    @SerializedName("items")
    @Expose
    private List<Items> bookItems;

    public List<Items> getBookItems() {
        return bookItems;

    }

    public MainObject(List<Items> bookItems) {
        this.bookItems = bookItems;

    }
}
