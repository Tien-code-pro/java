package com.assignment.assignment.entity;

import java.time.LocalDateTime;

public class Products {
    private int id;
    private String name;
    private double price;
    private String image;
    private String title;
    private String size;
    private int qty;
    private int rate;
    private String mass;
    private LocalDateTime CreateAt;
    private LocalDateTime UpdatedAt;
    private int status; // xoá mềm

    public Products() {
    }

    public Products(int id, String name, double price, String image, String title, String size, int qty, int rate, String mass, LocalDateTime createAt, LocalDateTime updatedAt, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.title = title;
        this.size = size;
        this.qty = qty;
        this.rate = rate;
        this.mass = mass;
        CreateAt = createAt;
        UpdatedAt = updatedAt;
        this.status = status;
    }

    public Products(int id, String name, double price, String image, String title, String size, int qty, int rate, String mass) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.title = title;
        this.size = size;
        this.qty = qty;
        this.rate = rate;
        this.mass = mass;
        this.CreateAt = LocalDateTime.now();
        this.UpdatedAt = LocalDateTime.now();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", qty=" + qty +
                ", rate=" + rate +
                ", mass='" + mass + '\'' +
                ", CreateAt=" + CreateAt +
                ", UpdatedAt=" + UpdatedAt +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        CreateAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}