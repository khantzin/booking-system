package com.kz.bookingsystem.controller.authentication;

import com.kz.bookingsystem.dto.UserDTO;
import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.AuthenticationService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//@Api(tags = "Authentication", value = "Authentication Api")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationApiController {

    private AuthenticationService service;

    @Autowired
    public AuthenticationApiController(final AuthenticationService service){
        this.service = service;
    }


//    private final JwtToken
    @PostMapping("/register")
//    @ApiOperation(value = "Register Request", notes = "Method to register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDTO request
            ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
//    @ApiOperation(value = "Login Request", notes = "Method to login")
    public ResponseEntity<String> register(
            @RequestBody AuthenticationRequest request
    ){
        try{
            var res = new ResponseSuccessHandler();
            var user = service.authenticate(request);

            res.setBody(user);
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getMessage(), ex.getCode());
        }
    }

    @GetMapping("/sendotpemail")
    public ResponseEntity<String> sendEmail(
            @PathParam("email") String email
        ){
        try{
            var res = new ResponseSuccessHandler();
            var result = service.sendEmail(email);
            res.setBody(result);
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

    @GetMapping("/validateotp")
    public ResponseEntity<String> validateOtp(
            @PathParam("email") String email,
            @PathParam("otpId") String otpId,
            @PathParam("otpCOde") String otpCode
    ){
        try{
            var res = new ResponseSuccessHandler();
            var result = service.validateOtp(email, otpId, otpCode);
            res.setBody(result);
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody AuthenticationRequest request){
        try{
            var res = new ResponseSuccessHandler();
            var result = service.updatePasord(request);
            res.setBody(result);
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

}
