package com.example.bookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookapp.models.Book;
import com.example.bookapp.models.Items;

import java.util.List;

public class BooksAdapter extends ArrayAdapter<Items> {


    public BooksAdapter(Context context, List<Items> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Find the earthquake at the given position in the list of earthquakes
        Items currentItems = getItem(position);
        Book currentBook = currentItems.getBook();

        // Find the TextView with view ID magnitude
        TextView textViewtitle = listItemView.findViewById(R.id.title);
        textViewtitle.setText(currentBook.getTitle());

        // Find the TextView with view ID location
        TextView textViewDescription = listItemView.findViewById(R.id.description);
        // Display the location of the current earthquake in that TextView
        textViewDescription.setText(currentBook.getDescription());

        // Find the TextView with view ID location offset
        TextView textViewPublishedDate = listItemView.findViewById(R.id.published_date);
        textViewPublishedDate.setText(currentBook.getPublishedDate());

        TextView textViewPublisher = listItemView.findViewById(R.id.publisher);
        textViewPublisher.setText(currentBook.getPublisher());


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
