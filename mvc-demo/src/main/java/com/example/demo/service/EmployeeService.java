/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriela
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity e) {
        return repository.save(e);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public List<EmployeeEntity> searchEmployees(String searchTerm) {
        return repository.searchEmployees(searchTerm);
    }

    public long getTotalEmployees() {
        return repository.count();
    }

    public Double getAverageSalary() {
        return repository.findAverageSalary();
    }

}
