package com.fit.se.service;

import com.fit.se.entity.Department;
import com.fit.se.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getListDepartments() {
        return departmentRepository.findAll();
    }


    public Department getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}
