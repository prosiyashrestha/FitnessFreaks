package com.system.fitnessfreaks.pojo;

import com.system.fitnessfreaks.Entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminPojo {
    private Integer id;
    private String duration;
    private Integer price;

    public AdminPojo(Admin admin) {
        this.id= admin.getId();
        this.duration= admin.getDuration();
        this.price= admin.getPrice();
    }


}
