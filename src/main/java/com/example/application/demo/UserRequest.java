package com.example.application.demo;

import com.example.application.demo.entity.Address;
import com.example.application.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    private User user;
    private List<Address> address;
}
