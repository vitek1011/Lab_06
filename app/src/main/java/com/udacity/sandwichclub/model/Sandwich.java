package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    private Name name;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(Name name, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.name = name;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public Name getMainName() {
        return name;
    }

    public void setMainName(Name name) {
        this.name = name;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public class Name {
        private final String mainName;
        private final List<String> alsoKnownAs;

        public Name(String mainName, List<String> alsoKnownAs) {
            this.mainName = mainName;
            this.alsoKnownAs = alsoKnownAs;
        }

        public String getMainName() {
            return mainName;
        }

        public List<String> getAlsoKnownAs() {
            return alsoKnownAs;
        }
    }

//    String mName, mPlase, mDescription, mImage;
//    List<String> alsoList = new ArrayList<>(), ingredientsList = new ArrayList<>();
//    JSONObject mJson = new JSONObject(json);
//    JSONObject name = mJson.getJSONObject("name"); try
//
//    {
//        mName = name.getString("mainName");
//        JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
//        if (alsoKnownAsArray != null) {
//            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
//                alsoList.add(alsoKnownAsArray.getString(i));
//            }
//        }
//        JSONArray ingredients = mJson.getJSONArray("ingredients");
//        if (ingredients != null) {
//            for (int i = 0; i < ingredients.length(); i++) {
//                ingredientsList.add(ingredients.getString(i));
//            }
//        }
//        mPlase = mJson.getString("placeOfOrigin");
//        mDescription = mJson.getString("description");
//        mImage = mJson.getString("image");
//        return new Sandwich(mName, alsoList, mPlase, mDescription, mImage, ingredientsList);
//    } catch(
//    Exception e)
//
//    {
//        e.printStackTrace();
//        return null;
//    } Log.i("GSON",sandwich.name.mainName);
//    List<String> list = sandwich.name.alsoKnownAs;
//    StringBuffer fullString = new StringBuffer(" "); if(list !=null)
//
//    {
//        for (String string : list) fullString.append(string + ", ");
//    }
}
