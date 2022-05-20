package com.assignment.assignment.entity;

import java.time.LocalDateTime;

public class Account {
    private int id;
    private String UserName;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String Address;
    private String Country;
    private LocalDateTime CreateAt;
    private LocalDateTime UpdatedAt;
    private int status;

    public Account() {
    }

    public Account(int id, String userName, String password, String firstName, String lastName, String email, String phone, String address, String country, LocalDateTime createAt, LocalDateTime updatedAt, int status) {
        this.id = id;
        this.UserName = userName;
        this.Password = password;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Phone = phone;
        this.Address = address;
        this.Country = country;
        this.CreateAt = createAt;
        this.UpdatedAt = updatedAt;
        this.status = status;
    }

    public Account(int id, String userName, String password, String firstName, String lastName, String email, String phone, String address, String country) {
        this.id = id;
        this.UserName = userName;
        this.Password = password;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Phone = phone;
        this.Address = address;
        this.Country = country;
        this.CreateAt = LocalDateTime.now();
        this.UpdatedAt = LocalDateTime.now();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address='" + Address + '\'' +
                ", Country='" + Country + '\'' +
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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
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
