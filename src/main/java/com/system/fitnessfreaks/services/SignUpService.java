package com.system.fitnessfreaks.services;

import com.system.fitnessfreaks.Entity.SignUp;
import com.system.fitnessfreaks.pojo.SignUpPojo;

import java.io.IOException;
import java.util.List;


public interface SignUpService {
    SignUpPojo saveUser(SignUpPojo signUpPojo)throws IOException;
    SignUpPojo updateUser(SignUpPojo signUpPojo)throws IOException;
    SignUp fetchByEmail(String email);

    List<SignUp> fetchAll();
    SignUp fetchById(Integer id);

    void deleteById(Integer id);

}
