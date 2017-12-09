package com.roshan092.demoservices.controller;

import com.roshan092.demoservices.domain.CalculationResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    @GetMapping("/calculate")
    public CalculationResult calculate(@RequestParam Integer id) throws InterruptedException {
        Thread.sleep(200L);
        return CalculationResult.builder()
                .id(id)
                .value(id * 100)
                .build();
    }
}
