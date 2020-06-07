package com.lofo.controller;

import com.lofo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    List<UserDTO> userDTOList = new ArrayList<>();

    @GetMapping(path = "/users")
    public List<UserDTO> getAllUsers() {
        return userDTOList;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        userDTOList.add(userDTO);
        return new ResponseEntity<>("User has been created", HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}")
    public UserDTO getUserById(@PathVariable(value = "id") int id) {
        return userDTOList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") int id, @RequestBody UserDTO userDTO) {
        UserDTO user = getUserById(id);
        if (user == null) {
            return new ResponseEntity<>("User not found at id = " + id, HttpStatus.NOT_FOUND);
        }
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());

        return new ResponseEntity<>("User has be changed" + "\n" + user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
        UserDTO userDTO = getUserById(id);
        if (userDTO == null) {
            return new ResponseEntity<>("User not found at id = " + id, HttpStatus.NOT_FOUND);
        }
        userDTOList.remove(userDTO);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);

    }

}
