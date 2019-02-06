package edu.psu.rjc65.ecommerce;

import android.os.Parcel;
import android.os.Parcelable;

public class CartItem implements Parcelable {
    String name;
    double price;
    int quantity;
    int image;

    public CartItem(String name, double price, int quantity, int image) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    //Constructor from parcel
    protected CartItem(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
        image = in.readInt();
    }

    //Create CartItem from a parcel
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Required parcel methods
    public int describeContents(){
        return this.hashCode();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(quantity);
        dest.writeInt(image);
    }
}
