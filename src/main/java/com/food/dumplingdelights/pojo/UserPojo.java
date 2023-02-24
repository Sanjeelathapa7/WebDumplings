package com.food.dumplingdelights.pojo;

import com.food.dumplingdelights.Entity.User;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Integer id;



    @NotEmpty(message = "Email can't be empty")
    private String email;




    @NotEmpty(message = "Full name can't be empty")
    private String fullname;


    @NotEmpty(message = "Password can't be empty")
    private String password;


    public UserPojo(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.fullname=user.getFullName();
        this.password=user.getPassword();
    }


}