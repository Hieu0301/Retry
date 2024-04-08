package com.fit.se.service;

import com.fit.se.entity.Department;
import com.fit.se.entity.User;
import com.fit.se.repository.UserRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private RestTemplate restTemplate;

    @Retry(name = "retryApi")
    public List<User> getListUser(){
        List<User> userList = userRepository.findAll();
        for (User o: userList) {
            Department department = restTemplate.getForObject("http://localhost:8080/api/v1/departments/" + o.getId(), Department.class);
            o.setDepartment(department);
        }
        return userList;
    }

    @Retry(name = "retryApi")
    public User getUserById(int id){
        User user = userRepository.findById(id).get();
        Department department = restTemplate.getForObject("http://localhost:8080/api/v1/departments/"+id, Department.class);
        user.setDepartment(department);
        return user;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }



}
