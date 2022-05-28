package com.assignment.assignment.entity;

import com.assignment.assignment.entity.base.BaseEntity;
import com.assignment.assignment.entity.myenum.ProductStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {
    private String id;
    private String name;
    private String image;
    private double price;
    private int qty;
    private int color_id;
    private String content;
    private int category_id;
    private int size_id;
    private int rate;
    private String mass;
    private ProductStatus status;
    HashMap<String,String> errors = new HashMap<>();



    public boolean isValid(){
        checkValidate();
        return errors.size()== 0;
    }
    private void checkValidate(){
        if (id == null || id.length() == 0){
            errors.put("id","Please enter id");
        }
        if (name == null || name.length() == 0){
            errors.put("name","Please enter name");
        }
        if (image == null || image.length() == 0){
            errors.put("image","Please enter image");
        }
        if (price == 0){
            errors.put("price","Please enter price");
        }
        if (qty == 0){
            errors.put("qty","Please enter qty");
        }
        if (color_id == 0){
            errors.put("color_id","Please enter color");
        }
        if (content == null || content.length() == 0){
            errors.put("content","Please enter content");
        }
        if (category_id == 0){
            errors.put("category_id","Please enter category");
        }
        if (size_id == 0){
            errors.put("size_id","Please enter size");
        }
        if (rate == 0){
            errors.put("rate","Please enter rate");
        }
        if (mass == null){
            errors.put("mass","Please enter mass");
        }
    }

    public Product() {
        this.id = "";
        this.name = "";
        this.image = "";
        this.price = 0;
        this.qty = 0;
        this.content = "";
        this.size_id = 0;
        this.rate = 0;
        this.mass = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status=ProductStatus.ACTIVE;
    }


    public Product(String id, String name, String image, double price, int qty, int color_id, String content, int category_id, int size_id, int rate, String mass) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.qty = qty;
        this.color_id = color_id;
        this.content = content;
        this.category_id = category_id;
        this.size_id = size_id;
        this.rate = rate;
        this.mass = mass;
        this.status = ProductStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", color_id=" + color_id +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", size_id=" + size_id +
                ", rate=" + rate +
                ", mass='" + mass + '\'' +
                ", status=" + status +
                ", errors=" + errors +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }


}
