/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Admin;
import com.company.entity.User;

import java.util.List;

/**
 *
 * @author HP
 */
public interface AdminDaoInter {

    public List<Admin> getAll(String name, String surname);

    public Admin getByEmailAndPassword(String email, String password);

    public Admin getByEmail(String email);

    public Admin getById(int userId);

    public boolean add(Admin admin);

    public boolean delete(int id);
}