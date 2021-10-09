package com.example.pawsupapplication.data.model;

/**
 * This class is the structure for the product, it is composed of strings that will handle
 * product name, seller, price, location, categories, rating, description, and
 * link to a picture.
 *
 * @author Lingfeng Yang
 */

public class Product {


    private Integer productId;
    private String productName;
    private String productQty;
    private String price;
    private String rating;
    private Integer picture;

    public Product(Integer productId, String productName, String productQty, String price,
                   String rating, Integer picture){
        super();

        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
        this.price = price;
        this.rating = rating;
        this.picture = picture;
    }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductQty() { return productQty; }
    public void setProductQty(String productQty) { this.productQty = productQty; }
    public String getProductPrice() { return price; }
    public void setProductPrice(String price) { this.price = price; }
    public String getProductRating() { return rating; }
    public void setProductRating(String rating) { this.rating = rating; }
    public Integer getProductPicture() { return picture; }
    public void setProductPicture(Integer picture) { this.picture = picture; }
}