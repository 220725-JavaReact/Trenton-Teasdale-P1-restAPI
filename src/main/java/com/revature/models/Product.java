package com.revature.models;

public class Product {
    private String name;
	private double price;
	private int quantity;
	private int storeId;
	private int productId;
    private String url;

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public double getPrice() {
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



    public int getStoreId() {
        return storeId;
    }



    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }



    public int getProductId() {
        return productId;
    }



    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getUrl() {
        return url;
    }



    public void setUrl(String url) {
        this.url = url;
    }

    
    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", productId=" + productId + ", quantity=" + quantity
                + ", storeId=" + storeId + ", url=" + url + "]";
    }
    public Product(){
        
    }
    public Product(int productId, String name, Double price,  int quantity, String url){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
    }
}
