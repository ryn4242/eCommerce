package edu.psu.rjc65.ecommerce;

import android.media.Image;

public class Product {
    private String productName;
    private String price;
    private String description;
    private int image;

    public Product(){
        this.productName = "Three-Footed Credenza";
        this.price = "$999.99";
        this.description = "Do not buy this";
        this.image = R.drawable.credenza;
    }

    public Product(String productName, String price, String description, int image){
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
