package com.pony101.taskgeo.controllers;

import com.pony101.taskgeo.controllers.model.BaseResponse;
import com.pony101.taskgeo.dto.VehicleDTO;
import com.pony101.taskgeo.models.Vehicle;
import com.pony101.taskgeo.services.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Vehicle Controller")
@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@BaseResponse
public class VehicleController {

    private final VehicleService vehicleService;
    private final ModelMapper mapper;

    @ApiOperation(value = "Add new record of vehicle location", produces = "application/json", response = VehicleDTO.class)
    @PostMapping
    public ResponseEntity<VehicleDTO> create(@Validated @RequestBody VehicleDTO vehicleDTO) {
        Vehicle savedVehicle = vehicleService.save(mapper.map(vehicleDTO, Vehicle.class));
        return ResponseEntity.ok(mapper.map(savedVehicle, VehicleDTO.class));
    }

    @ApiOperation(value = "Get vehicle record by vehicle id", produces = "application/json", response = VehicleDTO.class)
    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> get(@PathVariable String vehicleId) {
        return ResponseEntity.ok(mapper.map(vehicleService.findById(vehicleId), VehicleDTO.class));
    }

    @ApiOperation(value = "Update vehicle record by vehicle id", produces = "application/json", response = VehicleDTO.class)
    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> update(@PathVariable String vehicleId, @Validated @RequestBody VehicleDTO vehicleDTO) {
        final Vehicle updatedVehicle = vehicleService.update(vehicleId, mapper.map(vehicleDTO, Vehicle.class));
        return ResponseEntity.ok(mapper.map(updatedVehicle, VehicleDTO.class));
    }

    @ApiOperation(value = "Delete vehicle record by vehicle id", produces = "application/json", response = VehicleDTO.class)
    @DeleteMapping("/{vehicleId}")
    public ResponseEntity delete(@PathVariable String vehicleId) {
        vehicleService.delete(vehicleId);
        return ResponseEntity.ok().build();
    }

}
