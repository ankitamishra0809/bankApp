package com.example.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.bo.UserNotFoundException;
import com.example.bank.bo.UserService;
import com.example.bank.dto.UserDto;
import com.example.bank.vo.UserVO;

@RestController
@CrossOrigin
@RequestMapping("/bank")
public class UserController {
	@Autowired
    UserService userService ; 
 
	
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

@GetMapping("/users")
public ResponseEntity<List<UserVO>> getUser() {
    List<UserVO> userVO=userService.getUser();
    logger.debug("Creating user: {}", userVO);
    if (userVO.equals(null)) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(userVO, HttpStatus.OK);
}
@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
@GetMapping("/user/{id}")
public ResponseEntity<UserVO> getUserById(String id )
{
	logger.debug("Getting user by ID: {}", id);
	return new ResponseEntity<UserVO>(userService.getUserById(id),HttpStatus.OK);
}
@PostMapping("/postuser")
public void updateUser(@RequestBody UserVO userVO)

{
	logger.debug("Creating user: {}", userVO);
	userService.saveAndUpdate(userVO);
	
}
@GetMapping("/hello")
public String hello(){
	return "Hello WORLD";
}
}

