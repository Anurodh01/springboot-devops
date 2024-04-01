package com.nagarro.devops.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.devops.models.User;
import com.nagarro.devops.services.UserService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        List<User> users = readJsonData();
        return users;
    }
    public List<User> readJsonData() {
        List<User> userDataList = new ArrayList<>();
        try {
            InputStream inputStream = new ClassPathResource("data/users.json").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ObjectMapper objectMapper = new ObjectMapper();
            userDataList = Arrays.asList(objectMapper.readValue(reader, User[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userDataList;
    }
}
