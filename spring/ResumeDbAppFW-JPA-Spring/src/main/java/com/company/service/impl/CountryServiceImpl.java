/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.impl.CountryRepository;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author HP
 */

@Service
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.getAll();
    }

    @Override
    public Country getById(int id) {
        return countryRepository.getById(id);
    }

    @Override
    public boolean update(Country c) {
        return countryRepository.update(c);
    }

    @Override
    public boolean add(Country c) {
        return countryRepository.add(c);
    }

    @Override
    public boolean deleteByObject(Country c) {
        return countryRepository.deleteByObject(c);
    }

    @Override
    public boolean delete(int id) {
        return countryRepository.delete(id);
    }
}
