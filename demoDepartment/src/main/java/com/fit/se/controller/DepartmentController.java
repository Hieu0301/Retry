package com.fit.se.controller;

import com.fit.se.entity.Department;
import com.fit.se.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    List<Department> getListDepartment(){
        return  departmentService.getListDepartments();
    }
    @GetMapping("/departments/{id}")
    Department getUserById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/departments")
    Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
