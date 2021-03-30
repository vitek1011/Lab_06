package com.udacity.sandwichclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> sandwiches = Arrays.asList(getResources().getStringArray(R.array.sandwich_names));

        RecyclerView recyclerView = findViewById(R.id.sandwiches_listview);

        Adapter adapter1 = new Adapter(this, sandwiches);
        recyclerView.setAdapter(adapter1);
    }
}
