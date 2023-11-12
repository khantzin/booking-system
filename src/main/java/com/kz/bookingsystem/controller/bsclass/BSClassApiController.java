package com.kz.bookingsystem.controller.bsclass;

import com.kz.bookingsystem.dto.BSClassDTO;
import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.BSClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bsclass")
public class BSClassApiController {

    private final BSClassService bsClassService;

    public BSClassApiController(BSClassService bsClassService) {
        this.bsClassService = bsClassService;
    }

    @PostMapping
    public ResponseEntity<String> createBSClass(@RequestBody BSClassDTO bsClassDTO) {
        try{
            var res = new ResponseSuccessHandler();
            var result = bsClassService.save(bsClassDTO);

            res.setBody(result.getData());
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllClasses(){
        try{
            var res = new ResponseSuccessHandler();
            var result = bsClassService.getAllClasses();

            res.setBody(result);
            return res.response();
        }
        catch (CoreApiException ex){
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }


}
