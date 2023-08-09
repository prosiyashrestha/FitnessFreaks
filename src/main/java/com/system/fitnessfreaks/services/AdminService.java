package com.system.fitnessfreaks.services;

import com.system.fitnessfreaks.Entity.Admin;
import com.system.fitnessfreaks.pojo.AdminPojo;

import java.util.List;


public interface AdminService {
    AdminPojo save(AdminPojo adminPojo) ;

    List<Admin> fetchAll();
    Admin fetchById(Integer id);



    void deleteById(Integer id);


}
