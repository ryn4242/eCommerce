package edu.psu.rjc65.ecommerce;

public class Product {
    private String productName;
    private String price;

    public Product(){
        this.productName = "Three-Footed Credenza";
        this.price = "$999.99";
    }

    public Product(String productName, String price){
        this.productName = productName;
        this.price = price;
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
}
