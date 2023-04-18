package com.example.pokemon_app;

public class ItemListView {

    private String name;

    private int image;
    private String type;

    public ItemListView(String name, int image, String type){
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getType(){return type;}
    public void setType(String type){this.type = type;}
}

