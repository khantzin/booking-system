package com.kz.bookingsystem.controller.user;

import com.kz.bookingsystem.dto.ChangePasswordDTO;
import com.kz.bookingsystem.dto.UserDTO;
import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Api(tags = "User", value = "User Api")
@RestController
@RequestMapping("/api/v1/user")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Integer id){
        try {
            var res = new ResponseSuccessHandler();
            var result = userService.getUserByID(id);
            res.setBody(result.getData());
            return res.response();
        }
        catch (CoreApiException ex){
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> getAllUser(){
        try{
            var res = new ResponseSuccessHandler();
            var users = userService.getAllUsers();
            res.setBody(users);
            return res.response();
        }
        catch(CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

    @PostMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO request){
        try{
            var res = new ResponseSuccessHandler();
            var result = userService.updaetPassword(request);
            res.setBody(result.getData());
            return res.response();
        }
        catch(CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

}
