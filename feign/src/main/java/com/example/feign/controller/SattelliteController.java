package com.example.feign.controller;

import com.example.feign.client.SatelliteClient;
import com.example.feign.model.SatelliteRequest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fienclient")
@RequiredArgsConstructor
public class SattelliteController {

    private final SatelliteClient satelliteClient;

    @GetMapping
    public ResponseEntity getSampleDataByIds(@RequestParam("ids") List<Long> ids) {
        try {
            ResponseEntity responseEntity = satelliteClient.getSatelliteDataByIds(ids);

            return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
        }catch (FeignException feignException) {
            return new ResponseEntity(feignException.responseBody(), HttpStatus.valueOf(feignException.status()));
        }
    }

    @DeleteMapping
    public ResponseEntity deleteSampleDataById(@RequestParam("id") Long id) {
        try {
            ResponseEntity responseEntity = satelliteClient.deleteSatelliteDataById(id);

            return new ResponseEntity(responseEntity.getStatusCode());
        }catch (FeignException feignException) {
            return new ResponseEntity(feignException.responseBody(), HttpStatus.valueOf(feignException.status()));
        }
    }

    @PutMapping
    public ResponseEntity updateData(@RequestParam("id") Long id, @RequestBody SatelliteRequest sampleRequest) {
        try {
            ResponseEntity responseEntity = satelliteClient.updateData(id, sampleRequest);

            return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
        }catch (FeignException feignException) {
            return new ResponseEntity(feignException.responseBody(), HttpStatus.valueOf(feignException.status()));
        }
    }

    @PostMapping
    public ResponseEntity saveNewData(@RequestBody SatelliteRequest sampleRequest) {
        try {
            ResponseEntity responseEntity = satelliteClient.saveNewData(sampleRequest);

            return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
        }catch (FeignException feignException) {
            return new ResponseEntity(feignException.responseBody(), HttpStatus.valueOf(feignException.status()));
        }
    }
}
