/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.EmployeeEntity;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriela
 */
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    @Query("SELECT e FROM EmployeeEntity e WHERE " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<EmployeeEntity> searchEmployees(@Param("searchTerm") String searchTerm);

    long count();


    @Query("SELECT AVG(e.salary) FROM EmployeeEntity e")
    Double findAverageSalary();

}
