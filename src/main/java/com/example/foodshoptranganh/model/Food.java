package com.example.foodshoptranganh.model;

public class Food {
    private int foodItemID;
    private String name;
    private int price;
    private String description;
    private String image;
    private String type;
    private boolean stock;

    public Food() {
    }

    public Food(String name, int price, String description, String image, String type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public Food(int foodItemID, String name, int price, String description, String image, String type, boolean stock) {
        this.foodItemID = foodItemID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.type = type;
        this.stock = stock;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodItemID=" + foodItemID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                '}';
    }
}