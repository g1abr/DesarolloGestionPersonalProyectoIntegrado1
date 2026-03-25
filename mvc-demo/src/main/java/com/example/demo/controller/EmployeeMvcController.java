/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Gabriela
 */
@Controller
public class EmployeeMvcController {

    @Autowired
    private EmployeeService service;


    @GetMapping("/")
    public String viewHomePage(Model model,
            @RequestParam(value = "search", required = false) String searchTerm) {

        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            model.addAttribute("employees", service.searchEmployees(searchTerm.trim()));
            model.addAttribute("searchTerm", searchTerm);
        } else {
            model.addAttribute("employees", service.getAllEmployees());
        }

    
        model.addAttribute("totalEmployees", service.getTotalEmployees());
        model.addAttribute("averageSalary", service.getAverageSalary());

        return "list-employees";
    }
    

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "add-edit-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable("id") Long id, Model model) {
        EmployeeEntity e = service.getEmployeeById(id);
        model.addAttribute("employee", e);
        return "add-edit-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }

}
