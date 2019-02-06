package edu.psu.rjc65.ecommerce;

public class Product {
    private String productName;
    private double price;
    private String description;
    private int image;

    //Default constructor
    public Product(){
        this.productName = "Three-Footed Credenza";
        this.price = 999.99;
        this.description = "Do not buy this";
        this.image = R.drawable.credenza;
    }

    //Constructor with all parameters

    Product(String productName, double price, String description, int image){
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    //Getters and setters
    String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
