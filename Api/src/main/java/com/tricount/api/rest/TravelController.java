package com.tricount.api.rest;

import com.tricount.api.requests.TravelModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {


    @PostMapping("/travels")
    public TravelModel Create(@RequestBody TravelModel travel){
        return travel;
    }
}
