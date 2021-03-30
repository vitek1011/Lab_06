package com.udacity.sandwichclub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.w3c.dom.Text;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName().getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    private void populateUI(Sandwich sandwich) {
        System.out.println(sandwich.getMainName().getAlsoKnownAs());

        TextView originTv = findViewById(R.id.origin_tv);
        TextView descriptionTv = findViewById(R.id.description_tv);
        TextView placeOfOrigin = findViewById(R.id.textView3);
        TextView ingredients = findViewById(R.id.textView2);
        TextView alsoKnownTv = findViewById(R.id.also_known_tv);

        originTv.setText("Name: " + sandwich.getMainName().getMainName());
        descriptionTv.setText("Description " + sandwich.getDescription());
        placeOfOrigin.setText("Place of origin: " + sandwich.getPlaceOfOrigin());

        ingredients.setText("Ingredients: ");
        List<String> ingredientsList = sandwich.getIngredients();
        for (int i = 0; i < ingredientsList.size(); i++) {
            ingredients.append(ingredientsList.get(i));

            if (i == ingredientsList.size() - 1) {
                ingredients.append(".");
            } else {
                ingredients.append(", ");

            }

        }

        alsoKnownTv.setText("Also known as: ");
        List<String> alsoKnownTvList = sandwich.getMainName().getAlsoKnownAs();
        for (int i = 0; i < alsoKnownTvList.size(); i++) {
            alsoKnownTv.append(alsoKnownTvList.get(i));

            if (i == alsoKnownTvList.size() - 1) {
                alsoKnownTv.append(".");
            } else {
                alsoKnownTv.append(", ");

            }

        }
    }
}
