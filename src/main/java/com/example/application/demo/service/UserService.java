package com.example.application.demo.service;

import com.example.application.demo.Exception.UserNotFoundException;
import com.example.application.demo.UserRequest;
import com.example.application.demo.entity.Address;
import com.example.application.demo.entity.User;
import com.example.application.demo.repo.AddressRepo;
import com.example.application.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AddressRepo addressRepo;

    public List<User> getAllUser (){
        return userRepo.findAll();
    }

    public User getUserById(long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Enter the correct ID"));
    }
    public User saveUser(UserRequest userRequest) throws NullPointerException{
        User user = new User();
        user.setName(userRequest.getUser().getName());
        user.setMobileNo(userRequest.getUser().getMobileNo());
        userRepo.save(user);
        List<Address> addressList = userRequest.getUser().getAddress();
        addressList.stream().forEach(h-> {
                    Address address1 = new Address();
                    address1.setId(h.getId());
                    address1.setCity(h.getCity());
                    address1.setPinCode(h.getPinCode());
                    address1.setUser(user);
                    addressRepo.save(address1);
                });
        user.setAddress(addressList);
        return user;
    }

    public User getUserByAddress(String city){
        Address address = addressRepo.findByCity(city);
        User user = address.getUser();
        return user;
    }

    public User updateUser(Long id, User user) throws UserNotFoundException {
        Optional<User> userObj = userRepo.findById(id);
        User userobj1 = userObj.get();
        userobj1.setName(user.getName());
        userobj1.setMobileNo(user.getMobileNo());
        userRepo.save(userobj1);
        return userobj1;
        }


}
