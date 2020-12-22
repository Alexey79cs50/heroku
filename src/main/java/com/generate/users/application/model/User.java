package com.generate.users.application.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value = "User entity", description = "Representation of user data")
@Getter
@Setter
@Entity
public class User{

    @ApiModelProperty(value = "User ID", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "User first name", example = "Sam", required = true)
    private String firstName;

    @ApiModelProperty(value = "User surname", example = "Fisher", required = true)
    private String lastName;

    @ApiModelProperty(value = "User age in the range from 18 to 100", example = "25", required = true)
    private Integer age;

    @ApiModelProperty(value = "User gender", example = "MALE", required = true)
    private Gender gender;

    @ApiModelProperty(value = "User e-mail. Use gmail.com addresses only", example = "sample@gmail.com", required = true)
    private String email;
}
