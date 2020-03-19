package com.example.bookapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bookapp.models.Items;
import com.example.bookapp.models.MainObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    private BooksAdapter adapter;
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private ListView listView;
    private EditText mEditTextField;
    Button mSearchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View circleProgressBar = findViewById(R.id.loading_spinner);
        mSearchButton = findViewById(R.id.search_button);
        mEditTextField = findViewById(R.id.search_view_field);
        adapter = new BooksAdapter(this, new ArrayList<Items>());
        listView = findViewById(R.id.list);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        Call<MainObject> call = apiInterface.getNews("android", 20);
        call.enqueue(new Callback<MainObject>() {
            @Override
            @Nullable
            public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                if (response.isSuccessful()) {
                    MainObject mainObject = response.body();
                    List<Items> items = mainObject.getBookItems();
                    adapter.clear();
                    adapter.addAll(items);
                    circleProgressBar.setVisibility(GONE);
                    listView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<MainObject> call, Throwable t) {

                Log.e("MainActivity", t.getMessage());
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleProgressBar.setVisibility(View.VISIBLE);
                adapter.clear();
                String userInput = mEditTextField.getText().toString();
                if (userInput == " "){
                    apiInterface = retrofit.create(ApiInterface.class);
                    Call<MainObject> call = apiInterface.getNews("android", 20);
                    call.enqueue(new Callback<MainObject>() {
                        @Override
                        @Nullable
                        public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                            if (response.isSuccessful()) {
                                MainObject mainObject = response.body();
                                List<Items> items = mainObject.getBookItems();
                                adapter.clear();
                                adapter.addAll(items);
                                circleProgressBar.setVisibility(GONE);
                                listView.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<MainObject> call, Throwable t) {

                            Log.e("MainActivity", t.getMessage());
                        }
                    });
                } else{
                    apiInterface = retrofit.create(ApiInterface.class);
                    Call<MainObject> call = apiInterface.getNews(userInput, 20);
                    call.enqueue(new Callback<MainObject>() {
                        @Override
                        @Nullable
                        public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                            if (response.isSuccessful()) {
                                MainObject mainObject = response.body();
                                List<Items> items = mainObject.getBookItems();
                                adapter.clear();
                                adapter.addAll(items);
                                circleProgressBar.setVisibility(GONE);
                                listView.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<MainObject> call, Throwable t) {
                            Log.e("MainActivity", t.getMessage());
                        }
                    });


                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items currentItem = adapter.getItem(position);

                Uri bookUri = Uri.parse(currentItem.getBook().getInfoLink());

                Intent intent = new Intent(Intent.ACTION_VIEW, bookUri);

                startActivity(intent);
            }
        });
    }
}
