package com.assignment.assignment.model;

import com.assignment.assignment.entity.Account;

import java.util.List;

public interface VegetablesModel {

    Account save(Account account);

    List<Account> findAll();

    Account findById(int id);

    Account update(int id, Account updateAccount);

    boolean delete(int id);
}
