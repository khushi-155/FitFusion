package com.CN.FitFusion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    String email;
    String password;
    int age;
    String gender;
    Long contactNo;
    String userType;
}
