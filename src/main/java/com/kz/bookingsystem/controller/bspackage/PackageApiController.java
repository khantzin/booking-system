package com.kz.bookingsystem.controller.bspackage;

import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/package")
public class PackageApiController {

    private final PackageService service;

    public PackageApiController(PackageService service) {
        this.service = service;
    }

    @GetMapping("/available")
    public ResponseEntity<String> getAvailablePackage(){
        try{
            var res = new ResponseSuccessHandler();
            var result = service.getAvailablePackage();
            res.setBody(result);
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }
}
