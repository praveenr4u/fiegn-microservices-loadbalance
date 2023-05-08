package com.example.feign.client;

import com.example.feign.config.SatelliteClientConfiguration;
import com.example.feign.model.SatelliteRequest;
import com.example.feign.model.SatelliteRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "satelliteclient",
        url = "${satellite.client.url}",
        configuration = SatelliteClientConfiguration.class
)
public interface SatelliteClient {
    @RequestMapping(method = RequestMethod.GET,
            value = "/satellite",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> getSatelliteDataByIds(@RequestParam("ids") List<Long> ids);

    @RequestMapping(method = RequestMethod.DELETE,
            value = "/satellite",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity deleteSatelliteDataById(@RequestParam("id") Long id);

    @RequestMapping(method = RequestMethod.PUT,
            value = "/satellite",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> updateData(@RequestParam("id") Long id, @RequestBody SatelliteRequest satelliteRequest);

    @RequestMapping(method = RequestMethod.POST,
        value = "/satellite",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> saveNewData(SatelliteRequest satelliteRequest);
}
