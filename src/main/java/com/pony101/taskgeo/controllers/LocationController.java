package com.pony101.taskgeo.controllers;

import com.pony101.taskgeo.controllers.model.BaseResponse;
import com.pony101.taskgeo.dto.RectDTO;
import com.pony101.taskgeo.dto.SimpleRectDTO;
import com.pony101.taskgeo.dto.VehicleDTO;
import com.pony101.taskgeo.services.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Location Controller")
@RestController()
@RequestMapping("/search/vehicles")
@RequiredArgsConstructor
@BaseResponse
public class LocationController {

    private final LocationService locationService;
    private final ModelMapper mapper;

    @ApiOperation(value = "Search vehicle bounded by latitude and longitude from both sides", produces = "application/json",
            response = VehicleDTO.class, responseContainer = "List")
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> list(@Validated SimpleRectDTO searchRect) {
        return ResponseEntity.ok(locationService.list(searchRect)
                .stream()
                .map(vehicle -> mapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Search vehicle bounded by rectangle of 4 coordinates", produces = "application/json",
            response = VehicleDTO.class, responseContainer = "List")
    @PostMapping
    public ResponseEntity<List<VehicleDTO>> list(@Validated @RequestBody RectDTO searchRect) {
        return ResponseEntity.ok(locationService.list(searchRect)
                .stream()
                .map(vehicle -> mapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList()));
    }

}
