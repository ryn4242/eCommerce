package edu.psu.rjc65.ecommerce;

public class Product {
    private String productName;
    private String price;
    private String description;

    public Product(){
        this.productName = "Three-Footed Credenza";
        this.price = "$999.99";
        this.description = "Do not buy this";
    }

    public Product(String productName, String price, String description){
        this.productName = productName;
        this.price = price;
        this.description = description;
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
}
