package com.kz.bookingsystem.controller.userpackage;

import com.kz.bookingsystem.dto.BuyPackageDTO;
import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.UserPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userpackage")
public class UserPackageApiController {

    private final UserPackageService service;

    public UserPackageApiController(UserPackageService service) {
        this.service = service;
    }

    @PostMapping("/buypackage")
    public ResponseEntity<String> buyPackage(@RequestBody BuyPackageDTO buyPackageDTO){
        try {
            var res = new ResponseSuccessHandler();
            var result = service.buyUserPackge(buyPackageDTO);

            if(!result.isStatus()) {
                throw new CoreApiException("Fail to buy package", result.getCode(), result.getMessage());
            }
            res.setBody(result.getData());
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }
}
